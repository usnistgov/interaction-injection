package gov.nist.hla.ii;

import hla.rti.FederateNotExecutionMember;
import hla.rti.NameNotFound;
import hla.rti.ObjectNotKnown;
import hla.rti.RTIinternalError;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterObjInjectionImpl implements InterObjInjection {

	private static final long serialVersionUID = -3409552497539566001L;

	private static final Logger log = LogManager
			.getLogger(InterObjInjectionImpl.class);

	protected final InjectionFederate injFed;

	BlockingQueue<InterObjDef> interactions = new LinkedBlockingQueue<InterObjDef>();

	public InterObjInjectionImpl(InjectionFederate injFed) {
		super();
		this.injFed = injFed;
	}

	@Override
	public BlockingQueue<InterObjDef> getInteractions() {
		return  interactions;
	}
	
	@Override
	public void addInteraction(String interactionName, Map<String, String> parameters) {
		InterObjDef def = new InterObjDef(interactionName, parameters, InterObjDef.TYPE.INTERACTION);
		addInterObj(def);
		log.trace("addInteraction=" + def);
	}
	
	@Override
	public void addObject(String objectName, Map<String, String> attributes) throws NameNotFound, FederateNotExecutionMember, RTIinternalError, ObjectNotKnown {
		InterObjDef def = new InterObjDef(objectName, attributes, InterObjDef.TYPE.OBJECT);
		addInterObj(def);
		log.trace("addObject=" + def);
	}
	
	@Override
	public void addInterObj(InterObjDef def) {
		interactions.add(def);
	}

	@Override
	public String formatInteractionName(String interactionName) {
		return String.format("%s.%s", INTERACTION_NAME_ROOT, interactionName);
	}

	@Override
	public String formatObjectName(String objectName) {
		return String.format("%s.%s", OBJECT_NAME_ROOT, objectName);
	}
}
