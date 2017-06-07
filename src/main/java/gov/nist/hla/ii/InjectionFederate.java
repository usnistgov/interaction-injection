package gov.nist.hla.ii;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ieee.standards.ieee1516._2010.AttributeType1;
import org.ieee.standards.ieee1516._2010.DocumentRoot;
import org.ieee.standards.ieee1516._2010.InteractionClassType;
import org.ieee.standards.ieee1516._2010.ObjectClassType;
import org.ieee.standards.ieee1516._2010.ObjectModelType;
import org.ieee.standards.ieee1516._2010.SharingEnumerations;
import org.ieee.standards.ieee1516._2010._2010Package;
import org.ieee.standards.ieee1516._2010.util._2010ResourceFactoryImpl;
import org.portico.impl.hla13.types.DoubleTime;
import org.portico.impl.hla13.types.DoubleTimeInterval;

import emf.sds.Deserialize;
import gov.nist.hla.ii.exception.ContextBrokerException;
import gov.nist.hla.ii.exception.PropertyNotAssigned;
import gov.nist.hla.ii.exception.PropertyNotFound;
import gov.nist.hla.ii.exception.RTIAmbassadorException;
import hla.rti.AsynchronousDeliveryAlreadyEnabled;
import hla.rti.AttributeHandleSet;
import hla.rti.AttributeNotDefined;
import hla.rti.AttributeNotOwned;
import hla.rti.ConcurrentAccessAttempted;
import hla.rti.EnableTimeConstrainedPending;
import hla.rti.EnableTimeRegulationPending;
import hla.rti.FederateNotExecutionMember;
import hla.rti.FederationExecutionDoesNotExist;
import hla.rti.InteractionClassNotDefined;
import hla.rti.InteractionClassNotPublished;
import hla.rti.InteractionParameterNotDefined;
import hla.rti.LogicalTime;
import hla.rti.NameNotFound;
import hla.rti.ObjectClassNotDefined;
import hla.rti.ObjectClassNotPublished;
import hla.rti.ObjectNotKnown;
import hla.rti.OwnershipAcquisitionPending;
import hla.rti.RTIambassador;
import hla.rti.RTIexception;
import hla.rti.RTIinternalError;
import hla.rti.ResignAction;
import hla.rti.RestoreInProgress;
import hla.rti.SaveInProgress;
import hla.rti.SuppliedAttributes;
import hla.rti.SuppliedParameters;
import hla.rti.TimeConstrainedAlreadyEnabled;
import hla.rti.TimeRegulationAlreadyEnabled;
import hla.rti.jlc.EncodingHelpers;
import hla.rti.jlc.RtiFactoryFactory;

// assume that SIMULATION_END is not sent as a Receive Order message
public class InjectionFederate {
	private static final Logger log = LogManager.getLogger(InjectionFederate.class);

	private static final String INTERACTION_NAME_ROOT = "InteractionRoot.C2WInteractionRoot";
	private static final String OBJECT_NAME_ROOT = "ObjectRoot";
	private static final String SIMULATION_END = "InteractionRoot.C2WInteractionRoot.SimulationControl.SimEnd";
	private static final String READY_TO_POPULATE = "readyToPopulate";
	private static final String READY_TO_RUN = "readyToRun";
	private static final String READY_TO_RESIGN = "readyToResign";

	private static final int MAX_JOIN_ATTEMPTS = 6;
	private static final int REJOIN_DELAY_MS = 10000;

	private enum State {
		CONSTRUCTED, INITIALIZED, JOINED, TERMINATING;
	}

	private State state = State.CONSTRUCTED;

	RTIambassador getRtiAmb() {
		return rtiAmb;
	}

	FederateAmbassador getFedAmb() {
		return fedAmb;
	}

	private RTIambassador rtiAmb;
	private FederateAmbassador fedAmb;
	private ObjectModelType fom;

	// set of object names that have been created as injectable entities
	private HashSet<String> discoveredObjects = new HashSet<String>();

	// set of interaction classes that have been created as injectable entities
	private HashSet<String> initializedInteractions = new HashSet<String>();

	private String federateName;
	private String federationName;
	private static String fomFilePath;

	private FederateCallback callBack;
	
	private InteractionSet interactionSet;

	public String getFomFilePath() {
		return fomFilePath;
	}

	private double lookahead;

	public State getState() {
		return state;
	}

	public ObjectModelType getFom() {
		return fom;
	}

	public String getFederateName() {
		return federateName;
	}

	public String getFederationName() {
		return federationName;
	}

	public double getStepsize() {
		return stepsize;
	}

	private double stepsize;

	public InjectionFederate() throws RTIAmbassadorException, ParserConfigurationException {

		try {
			rtiAmb = RtiFactoryFactory.getRtiFactory().createRtiAmbassador();
		} catch (RTIinternalError e) {
			throw new RTIAmbassadorException(e);
		}
		fedAmb = new FederateAmbassador();
	}

	public void loadConfiguration(String filepath) throws IOException, PropertyNotFound, PropertyNotAssigned {
		if (state != State.CONSTRUCTED && state != State.INITIALIZED) {
			throw new IllegalStateException("loadConfiguration cannot be called in the current state: " + state.name());
		}

		log.debug("loading FIWARE federate configuration");
		Configuration configuration = new Configuration(filepath);

		federateName = configuration.getRequiredProperty("federate-name");
		log.debug("federate-name=" + federateName);
		federationName = configuration.getRequiredProperty("federation");
		log.debug("federation=" + federationName);
		fomFilePath = configuration.getRequiredProperty("fom-file");
		log.debug("fom-file=" + fomFilePath);
		lookahead = configuration.getRequiredPropertyAsDouble("lookahead");
		log.debug("lookahead=" + lookahead);
		stepsize = configuration.getRequiredPropertyAsDouble("stepsize");
		log.debug("stepsize=" + stepsize);
		String dataFilePath = configuration.getRequiredProperty("data-file");
		
				
		fom = loadFOM();

		changeState(State.INITIALIZED);
	}

	private void changeState(State newState) {
		if (newState != state) {
			log.info("state change from " + state.name() + " to " + newState.name());
			state = newState;
		}
	}

	public void execute() throws RTIAmbassadorException, ContextBrokerException, InterruptedException {
		log.trace("execute==>");
		if (state != State.INITIALIZED) {
			throw new IllegalStateException("execute cannot be called in the current state: " + state.name());
		}

		try {
			joinFederationExecution();
			changeState(State.JOINED);

			enableAsynchronousDelivery();
			enableTimeConstrained();
			enableTimeRegulation();
			publishAndSubscribe();
			 String objectName = String.format("%s.%s", OBJECT_NAME_ROOT,
			 "Obj1");
			 String[] attrs = { "Obj1Attr1" };
			 int objectHandle = publishObject(objectName, attrs);
			 int instanceHandle = registerObject(objectName);

			synchronize(READY_TO_POPULATE);
			synchronize(READY_TO_RUN);
			log.trace("enter while==>");

			int i = 0;
			while (state != State.TERMINATING) {
				log.trace("handleMessages==>");
				handleMessages();
//				doInjectsUpdates();
				log.trace("injectInteraction==>");
				Map<String, String> params = new HashMap<String, String>(); // InteractionFactory.createParameters();
				log.trace("params==>" + params.size());
				injectInteraction(String.format("%s.%s", INTERACTION_NAME_ROOT, "Int1"), params);
				log.info("injectObject==>");
				Map<String, String> attrMap = new HashMap<String, String>();
				attrMap.put(attrs[0], "XXX" + i++);
				updateObject(objectHandle, instanceHandle, attrMap);
				log.trace("advanceLogicalTime==>");
				advanceLogicalTime();
			}
		} finally {
			try {
				switch (state) {
				case TERMINATING:
					synchronize(READY_TO_RESIGN);
					resignFederationExecution();
					break;
				case JOINED:
					resignFederationExecution();
					break;
				default:
					break;
				}
			} catch (Exception e) {
				log.warn("failed to resign federation execution", e);
			}
		}
	}

	private void handleMessages() throws RTIAmbassadorException, ContextBrokerException {
		try {
			Interaction1 receivedInteraction;
			while ((receivedInteraction = fedAmb.nextInteraction()) != null) {
				int interactionHandle = receivedInteraction.getInteractionClassHandle();
				String interactionName = rtiAmb.getInteractionClassName(interactionHandle);
				log.debug("received interaction name=" + interactionName);

				HashMap<String, String> parameters = new HashMap<String, String>();
				for (int i = 0; i < receivedInteraction.getParameterCount(); i++) {
					int parameterHandle = receivedInteraction.getParameterHandle(i);
					String parameterName = rtiAmb.getParameterName(parameterHandle, interactionHandle);
					String parameterValue = receivedInteraction.getParameterValue(i);
					log.debug(parameterName + "=" + parameterValue);
					parameters.put(parameterName, parameterValue);
				}

				if (interactionName.equals(SIMULATION_END)) {
					changeState(State.TERMINATING);
				}
			}

			ObjectReflection receivedObjectReflection;
			while ((receivedObjectReflection = fedAmb.nextObjectReflection()) != null) {
				int objectClassHandle = receivedObjectReflection.getObjectClass();
				String objectClassName = rtiAmb.getObjectClassName(objectClassHandle);
				String objectName = receivedObjectReflection.getObjectName();
				log.debug("received object class=" + objectClassName + ", name=" + objectName);

				HashMap<String, String> attributes = new HashMap<String, String>();
				for (int i = 0; i < receivedObjectReflection.getAttributeCount(); i++) {
					int attributeHandle = receivedObjectReflection.getAttributeHandle(i);
					String attributeName = rtiAmb.getAttributeName(attributeHandle, objectClassHandle);
					String attributeValue = receivedObjectReflection.getAttributeValue(i);
					log.debug(attributeName + "=" + attributeValue);
					attributes.put(attributeName, attributeValue);
				}
				log.trace("<==handleMessages");
			}

			String removedObjectName;
			while ((removedObjectName = fedAmb.nextRemovedObjectName()) != null) {
				if (discoveredObjects.remove(removedObjectName) == false) {
					log.warn("tried to delete an unknown object instance with name=" + removedObjectName);
				} else {
					log.info("deleting context broker entity with id=" + removedObjectName);
				}
			}
		} catch (RTIexception e) {
			throw new RTIAmbassadorException(e);
		}
	}

	private void tick() throws RTIAmbassadorException, ContextBrokerException {
		try {
			rtiAmb.tick();
		} catch (RTIexception e) {
			throw new RTIAmbassadorException(e);
		}
		handleMessages();
	}

	private void joinFederationExecution() throws InterruptedException, RTIAmbassadorException {
		boolean joinSuccessful = false;

		for (int i = 0; !joinSuccessful && i < MAX_JOIN_ATTEMPTS; i++) {
			if (i > 0) {
				log.info("next join attempt in " + REJOIN_DELAY_MS + " ms...");
				Thread.sleep(REJOIN_DELAY_MS);
			}

			try {
				log.info("joining federation " + federationName + " as " + federateName + " (" + i + ")");
				rtiAmb.joinFederationExecution(federateName, federationName, fedAmb, null);
				joinSuccessful = true;
			} catch (FederationExecutionDoesNotExist e) {
				log.warn("federation execution does not exist: " + federationName);
			} catch (SaveInProgress e) {
				log.warn("failed to join federation: save in progress");
			} catch (RestoreInProgress e) {
				log.warn("failed to join federation: restore in progress");
			} catch (RTIexception e) {
				throw new RTIAmbassadorException(e);
			}
		}
	}

	// enable Receive Order messages during any tick call
	public void enableAsynchronousDelivery() throws RTIAmbassadorException {
		try {
			log.info("enabling asynchronous delivery of receive order messages");
			rtiAmb.enableAsynchronousDelivery();
		} catch (AsynchronousDeliveryAlreadyEnabled e) {
			log.info("asynchronous delivery already enabled");
		} catch (RTIexception e) {
			throw new RTIAmbassadorException(e);
		}
	}

	private void enableTimeConstrained() throws RTIAmbassadorException, ContextBrokerException {
		try {
			log.info("enabling time constrained");
			rtiAmb.enableTimeConstrained();
			while (fedAmb.isTimeConstrained() == false) {
				tick();
			}
		} catch (TimeConstrainedAlreadyEnabled e) {
			log.info("time constrained already enabled");
		} catch (EnableTimeConstrainedPending e) {
			log.warn("multiple attempts made to enable time constrained mode");
		} catch (RTIexception e) {
			throw new RTIAmbassadorException(e);
		}
	}

	private void enableTimeRegulation() throws RTIAmbassadorException, ContextBrokerException {
		try {
			log.info("enabling time regulation");
			rtiAmb.enableTimeRegulation(new DoubleTime(fedAmb.getLogicalTime()), new DoubleTimeInterval(lookahead));
			while (fedAmb.isTimeRegulating() == false) {
				tick();
			}
		} catch (TimeRegulationAlreadyEnabled e) {
			log.info("time regulation already enabled");
		} catch (EnableTimeRegulationPending e) {
			log.warn("multiple attempts made to enable time regulation mode");
		} catch (RTIexception e) {
			throw new RTIAmbassadorException(e);
		}
	}

	ObjectModelType loadFOM() {
		Deserialize.associateExtension("xml", new _2010ResourceFactoryImpl());
		Deserialize.registerPackage(_2010Package.eNS_URI, _2010Package.eINSTANCE);
		DocumentRoot docRoot = (DocumentRoot) Deserialize.it(fomFilePath);
		return docRoot.getObjectModel();
	}

	private void publishAndSubscribe() throws RTIAmbassadorException {
		try {
			for (InteractionClassType classType : getInteractionSubscribe()) {
				log.info("creating HLA subscription for the interaction=" + classType.getName().getValue());
				int handle = rtiAmb.getInteractionClassHandle(classType.getName().getValue());
				rtiAmb.subscribeInteractionClass(handle);
			}
			for (InteractionClassType classType : getInteractionPublish()) {
				log.info("creating HLA publication for the interaction=" + classType.getName().getValue());
				int handle = rtiAmb.getInteractionClassHandle(classType.getName().getValue());
				rtiAmb.publishInteractionClass(handle);
			}
			for (ObjectClassType classType : getObjectSubscribe()) {
				log.info("creating HLA subscription for the object=" + classType.getName());
				int objectHandle = rtiAmb.getInteractionClassHandle(classType.getName().getValue());
				AttributeHandleSet attributes = RtiFactoryFactory.getRtiFactory().createAttributeHandleSet();
				for (AttributeType1 attribute : classType.getAttribute()) {
					int attributeHandle = rtiAmb.getAttributeHandle(attribute.getName().getValue(), objectHandle);
					attributes.add(attributeHandle);
				}
				rtiAmb.subscribeObjectClassAttributes(objectHandle, attributes);
			}
			for (ObjectClassType classType : getObjectPublish()) {
				log.info("creating HLA publication for the object=" + classType.getName());
				int objectHandle = rtiAmb.getInteractionClassHandle(classType.getName().getValue());
				AttributeHandleSet attributes = RtiFactoryFactory.getRtiFactory().createAttributeHandleSet();
				for (AttributeType1 attribute : classType.getAttribute()) {
					int attributeHandle = rtiAmb.getAttributeHandle(attribute.getName().getValue(), objectHandle);
					attributes.add(attributeHandle);
				}
				rtiAmb.publishObjectClass(objectHandle, attributes);
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}

	public void injectInteraction(String interactionName, Map<String, String> parameters) {
		int interactionHandle;
		try {
			interactionHandle = rtiAmb.getInteractionClassHandle(interactionName);
			rtiAmb.publishInteractionClass(interactionHandle);
			log.debug("interactionName=" + interactionName);
			log.debug("interactionHandle=" + interactionHandle);
			SuppliedParameters suppliedParameters = assembleParameters(interactionHandle, parameters);
			rtiAmb.sendInteraction(interactionHandle, suppliedParameters, generateTag());
		} catch (NameNotFound | FederateNotExecutionMember | RTIinternalError e) {
			log.error("", e);
		} catch (InteractionClassNotDefined e) {
			log.error("", e);
		} catch (InteractionClassNotPublished e) {
			log.error("", e);
		} catch (InteractionParameterNotDefined e) {
			log.error("", e);
		} catch (SaveInProgress e) {
			log.error("", e);
		} catch (RestoreInProgress e) {
			log.error("", e);
		} catch (ConcurrentAccessAttempted e) {
			log.error("", e);
		}
	}

	public SuppliedParameters assembleParameters(int interactionHandle, Map<String, String> parameters) {
		SuppliedParameters suppliedParameters = null;
		try {
			suppliedParameters = RtiFactoryFactory.getRtiFactory().createSuppliedParameters();
			for (Map.Entry<String, String> entry : parameters.entrySet()) {
				int parameterHandle = rtiAmb.getParameterHandle(entry.getKey(), interactionHandle);
				byte[] parameterValue = EncodingHelpers
						.encodeString(String.format("%s:%f", entry.getValue(), getLbts()));
				suppliedParameters.add(parameterHandle, parameterValue);
			}
		} catch (NameNotFound | FederateNotExecutionMember | RTIinternalError e) {
			log.error("", e);
		} catch (InteractionClassNotDefined e) {
			log.error("", e);
		}
		return suppliedParameters;
	}

	public void updateObject(String objectName, Map<String, String> attributes) {
		String objectFullName = String.format("%s.%s", OBJECT_NAME_ROOT, objectName);
		int objectHandle = publishObject(objectFullName, (String[]) attributes.keySet().toArray());
		int instanceHandle = registerObject(objectFullName);
		updateObject(objectHandle, instanceHandle, attributes);
	}

	public void updateObject(int classHandle, int objectHandle, Map<String, String> attributes) {
		try {
			SuppliedAttributes suppliedAttributes = assembleAttributes(classHandle, attributes);
			log.debug("suppliedAttributes=" + suppliedAttributes.size());
			rtiAmb.updateAttributeValues(objectHandle, suppliedAttributes, generateTag());
		} catch (FederateNotExecutionMember | RTIinternalError e) {
			log.error("", e);
		} catch (AttributeNotDefined e) {
			log.error("", e);
		} catch (SaveInProgress e) {
			log.error("", e);
		} catch (RestoreInProgress e) {
			log.error("", e);
		} catch (ConcurrentAccessAttempted e) {
			log.error("", e);
		} catch (ObjectNotKnown e) {
			log.error("", e);
		} catch (AttributeNotOwned e) {
			log.error("", e);
		} finally {
			log.debug("objectHandle=" + objectHandle);
		}
	}

	public SuppliedAttributes assembleAttributes(int classHandle, Map<String, String> attributes) {
		SuppliedAttributes suppliedAttributes = null;
		try {
			suppliedAttributes = RtiFactoryFactory.getRtiFactory().createSuppliedAttributes();
			for (Map.Entry<String, String> entry : attributes.entrySet()) {
				int attributeHandle = rtiAmb.getAttributeHandle(entry.getKey(), classHandle);
				byte[] attributeValue = EncodingHelpers
						.encodeString(String.format("%s:%f", entry.getValue(), getLbts()));
				suppliedAttributes.add(attributeHandle, attributeValue);
			}
		} catch (RTIinternalError e) {
			log.error("", e);
		} catch (ObjectClassNotDefined e) {
			log.error("", e);
		} catch (NameNotFound e) {
			log.error("", e);
		} catch (FederateNotExecutionMember e) {
			log.error("", e);
		}
		return suppliedAttributes;
	}

	private int publishObject(String objectName, Map<String, String> attributes) {

		return 0;
	}

	private int publishObject(String objectName, String... attributes) {
		int objectHandle = 0;
		try {
			objectHandle = rtiAmb.getObjectClassHandle(objectName);
			AttributeHandleSet attributeSet = RtiFactoryFactory.getRtiFactory().createAttributeHandleSet();
			for (String attrName : attributes) {
				int attributeHandle = rtiAmb.getAttributeHandle(attrName, objectHandle);
				attributeSet.add(attributeHandle);
			}
			rtiAmb.publishObjectClass(objectHandle, attributeSet);
		} catch (NameNotFound | FederateNotExecutionMember | RTIinternalError e) {
			log.error("", e);
		} catch (ObjectClassNotDefined e) {
			log.error("", e);
		} catch (AttributeNotDefined e) {
			log.error("", e);
		} catch (OwnershipAcquisitionPending e) {
			log.error("", e);
		} catch (SaveInProgress e) {
			log.error("", e);
		} catch (RestoreInProgress e) {
			log.error("", e);
		} catch (ConcurrentAccessAttempted e) {
			log.error("", e);
		}
		return objectHandle;
	}

	private int registerObject(String objName) {
		int classHandle;
		try {
			classHandle = rtiAmb.getObjectClassHandle(objName);
			log.debug("classHandle=" + classHandle);
			return rtiAmb.registerObjectInstance(classHandle);
		} catch (NameNotFound | FederateNotExecutionMember | RTIinternalError e) {
			log.error("", e);
		} catch (ObjectClassNotDefined e) {
			log.error("", e);
		} catch (ObjectClassNotPublished e) {
			log.error("", e);
		} catch (SaveInProgress e) {
			log.error("", e);
		} catch (RestoreInProgress e) {
			log.error("", e);
		} catch (ConcurrentAccessAttempted e) {
			log.error("", e);
		}
		return -1;
	}

	private LogicalTime convertTime(double time) {
		return new DoubleTime(time);
	}

	private double getLbts() {
		return fedAmb.getFederateTime() + fedAmb.getFederateLookahead();
	}

	private byte[] generateTag() {
		return ("" + System.currentTimeMillis()).getBytes();
	}

	private void synchronize(String label) throws RTIAmbassadorException, ContextBrokerException {
		log.info("waiting for announcement of the synchronization point " + label);
		while (fedAmb.isSynchronizationPointPending(label) == false) {
			tick();
		}

		try {
			rtiAmb.synchronizationPointAchieved(label);
		} catch (RTIexception e) {
			throw new RTIAmbassadorException(e);
		}

		log.info("waiting for federation to synchronize on synchronization point " + label);
		while (fedAmb.isSynchronizationPointPending(label) == true) {
			tick();
		}
		log.info("federation synchronized on " + label);
	}

	private void advanceLogicalTime() throws RTIAmbassadorException, ContextBrokerException {
		Double newLogicalTime = fedAmb.getLogicalTime() + stepsize;
		log.info("advancing logical time to " + newLogicalTime);
		try {
			fedAmb.setTimeAdvancing();
			rtiAmb.timeAdvanceRequest(new DoubleTime(newLogicalTime));
		} catch (RTIexception e) {
			throw new RTIAmbassadorException(e);
		}
		while (fedAmb.isTimeAdvancing() == true) {
			tick();
		}
		log.info("advanced logical time to " + fedAmb.getLogicalTime());
	}

	private void resignFederationExecution() throws RTIAmbassadorException {
		log.info("resigning from the federation execution " + federationName);
		try {
			rtiAmb.resignFederationExecution(ResignAction.NO_ACTION);
		} catch (RTIexception e) {
			throw new RTIAmbassadorException(e);
		}
	}

	public static void main(String args[]) {
		if (args.length != 1) {
			log.error("command line argument for properties file not specified");
			args = new String[1];
			args[0] = "config.properties";
		}

		try {
			InjectionFederate federate = new InjectionFederate();
			federate.loadConfiguration(args[0]);

			federate.execute();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public Set<InteractionClassType> getInteractionSubscribe() {
		Set<InteractionClassType> set = new HashSet<InteractionClassType>();
		for (InteractionClassType itr : getFom().getInteractions().getInteractionClass().getInteractionClass()) {
			getInteractions(set, itr, SharingEnumerations.SUBSCRIBE);
		}

		return set;
	}

	public Set<InteractionClassType> getInteractionPublish() {
		Set<InteractionClassType> set = new HashSet<InteractionClassType>();
		for (InteractionClassType itr : getFom().getInteractions().getInteractionClass().getInteractionClass()) {
			getInteractions(set, itr, SharingEnumerations.PUBLISH);
		}

		return set;
	}

	public Set<InteractionClassType> getInteractions(Set<InteractionClassType> set, InteractionClassType itr,
			SharingEnumerations pubsub) {
		if (itr.getSharing().getValue() == pubsub
				|| itr.getSharing().getValue() == SharingEnumerations.PUBLISH_SUBSCRIBE) {
			set.add(itr);
			log.trace("added InteractionClassType.name=" + itr.getName().getValue() + "size=" + set.size());
		}
		for (InteractionClassType itr1 : itr.getInteractionClass()) {
			getInteractions(set, itr1, pubsub);
		}
		return set;
	}

	public Set<ObjectClassType> getObjectSubscribe() {
		Set<ObjectClassType> set = new HashSet<ObjectClassType>();
		for (ObjectClassType itr : getFom().getObjects().getObjectClass().getObjectClass()) {
			getObjects(set, itr, SharingEnumerations.SUBSCRIBE);
		}

		return set;
	}

	public Set<ObjectClassType> getObjectPublish() {
		Set<ObjectClassType> set = new HashSet<ObjectClassType>();
		for (ObjectClassType itr : getFom().getObjects().getObjectClass().getObjectClass()) {
			getObjects(set, itr, SharingEnumerations.PUBLISH);
		}

		return set;
	}

	public Set<ObjectClassType> getObjects(Set<ObjectClassType> set, ObjectClassType itr, SharingEnumerations pubsub) {
		if (itr.getSharing().getValue() == pubsub
				|| itr.getSharing().getValue() == SharingEnumerations.PUBLISH_SUBSCRIBE) {
			set.add(itr);
			log.trace("added ObjectClassType.name=" + itr.getName().getValue() + "size=" + set.size());
		}
		for (ObjectClassType itr1 : itr.getObjectClass()) {
			getObjects(set, itr1, pubsub);
		}
		return set;
	}

	public InteractionSet getInteractionSet() {
		return interactionSet;
	}

	public void setInteractionSet(InteractionSet interactionSet) {
		this.interactionSet = interactionSet;
	}
}
