package gov.nist.hla.ii;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.portico.impl.hla13.types.DoubleTime;
import org.portico.impl.hla13.types.DoubleTimeInterval;

import emf.sds.DeSerialize;
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
import hla.rti.InvalidFederationTime;
import hla.rti.LogicalTime;
import hla.rti.NameNotFound;
import hla.rti.ObjectClassNotDefined;
import hla.rti.ObjectNotKnown;
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
	private static final Logger log = LogManager.getLogger();

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

	private RTIambassador rtiAmb;
	private FederateAmbassador fedAmb;
	private DeSerialize somReader;
	private SOMReader simulationObjectModel;

	// set of object names that have been created as FIWARE entities
	private HashSet<String> discoveredObjects = new HashSet<String>();

	// set of interaction classes that have been created as FIWARE entities
	private HashSet<String> initializedInteractions = new HashSet<String>();

	private String federateName;
	private String federationName;
	private String somFilepath;

	private double lookahead;
	private double stepsize;

	public InjectionFederate(String somfile) throws RTIAmbassadorException, ParserConfigurationException {

		try {
			rtiAmb = RtiFactoryFactory.getRtiFactory().createRtiAmbassador();
		} catch (RTIinternalError e) {
			throw new RTIAmbassadorException(e);
		}
		fedAmb = new FederateAmbassador();
		somReader = new DeSerialize();
		this.simulationObjectModel = new SOMReader();
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
		somFilepath = configuration.getRequiredProperty("som-file");
		log.debug("som-file=" + somFilepath);
		lookahead = configuration.getRequiredPropertyAsDouble("lookahead");
		log.debug("lookahead=" + lookahead);
		stepsize = configuration.getRequiredPropertyAsDouble("stepsize");
		log.debug("stepsize=" + stepsize);

		changeState(State.INITIALIZED);
	}

	private void changeState(State newState) {
		if (newState != state) {
			log.info("state change from " + state.name() + " to " + newState.name());
			state = newState;
		}
	}

	public void execute() throws RTIAmbassadorException, ContextBrokerException, InterruptedException {
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

			synchronize(READY_TO_POPULATE);
			synchronize(READY_TO_RUN);

			while (state != State.TERMINATING) {
				handleMessages();
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
			Interaction receivedInteraction;
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
	private void enableAsynchronousDelivery() throws RTIAmbassadorException {
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

	private void publishAndSubscribe() throws RTIAmbassadorException {
		try {
			for (String interactionName : simulationObjectModel.getPublishedInteractions()) {
				log.info("creating HLA publication for the interaction " + interactionName);
				injectInteraction(interactionName, new HashMap<String, String>());
			}
			for (String interactionName : simulationObjectModel.getSubscribedInteractions()) {
				log.info("creating HLA subscription for the interaction " + interactionName);
				int interactionHandle = rtiAmb.getInteractionClassHandle(interactionName);
				rtiAmb.subscribeInteractionClass(interactionHandle);
			}
			for (String objectClass : simulationObjectModel.getPublishedObjects()) {
				int objectHandle = rtiAmb.getObjectClassHandle(objectClass);
				AttributeHandleSet attributes = RtiFactoryFactory.getRtiFactory().createAttributeHandleSet();

				for (String attributeName : simulationObjectModel.getPublishedAttributes(objectClass)) {
					log.info("creating HLA publication for object=" + objectClass + ", attribute=" + attributeName);
					int attributeHandle = rtiAmb.getAttributeHandle(attributeName, objectHandle);
					attributes.add(attributeHandle);
				}
				rtiAmb.publishObjectClass(objectHandle, attributes);
			}
			for (String objectClass : simulationObjectModel.getSubscribedObjects()) {
				int objectHandle = rtiAmb.getObjectClassHandle(objectClass);
				AttributeHandleSet attributes = RtiFactoryFactory.getRtiFactory().createAttributeHandleSet();

				for (String attributeName : simulationObjectModel.getSubscribedAttributes(objectClass)) {
					log.info("creating HLA subscription for object=" + objectClass + ", attribute=" + attributeName);
					int attributeHandle = rtiAmb.getAttributeHandle(attributeName, objectHandle);
					attributes.add(attributeHandle);
				}
				rtiAmb.subscribeObjectClassAttributes(objectHandle, attributes);
			}
		} catch (RTIexception e) {
			throw new RTIAmbassadorException(e);
		}
	}

	public void injectInteraction(String interactionName, Map<String, String> parameters) {
		int interactionHandle;
		try {
			interactionHandle = rtiAmb.getInteractionClassHandle(interactionName);
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
				byte[] parameterValue = EncodingHelpers.encodeString(String.format("%s:%d", entry.getKey(), getLbts()));
				suppliedParameters.add(parameterHandle, parameterValue);
			}
		} catch (NameNotFound | FederateNotExecutionMember | RTIinternalError e) {
			log.error("", e);
		} catch (InteractionClassNotDefined e) {
			log.error("", e);
		}
		return suppliedParameters;
	}

	public void injectObject(String className, Map<String, String> attributes) {
		int classHandle;
		try {
			classHandle = rtiAmb.getObjectClassHandle(className);
			SuppliedAttributes suppliedAttributes = assembleAttributes(classHandle, attributes);
			rtiAmb.updateAttributeValues(classHandle, suppliedAttributes, generateTag(), convertTime(getLbts()));
		} catch (NameNotFound | FederateNotExecutionMember | RTIinternalError e) {
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
		} catch (InvalidFederationTime e) {
			log.error("", e);
		}
	}

	public SuppliedAttributes assembleAttributes(int classHandle, Map<String, String> attributes) {
		SuppliedAttributes suppliedAttributes = null;
		try {
			suppliedAttributes = RtiFactoryFactory.getRtiFactory().createSuppliedAttributes();
			for (Map.Entry<String, String> entry : attributes.entrySet()) {
				int attributeHandle = rtiAmb.getAttributeHandle(entry.getKey(), classHandle);
				byte[] attributeValue = EncodingHelpers.encodeString(String.format("%s:%d", entry.getKey(), getLbts()));
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
			InjectionFederate federate = new InjectionFederate(args[0]);
			federate.loadConfiguration(args[0]);
			federate.execute();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
