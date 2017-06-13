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

	BlockingQueue<InteractionDef> interactions = new LinkedBlockingQueue<InteractionDef>();

	public InterObjInjectionImpl(InjectionFederate injFed) {
		super();
		this.injFed = injFed;
	}

	@Override
	public BlockingQueue<InteractionDef> getInteractions() {
		return  interactions;
	}

	@Override
	public void addInteraction(String interactionName, Map<String, String> parameters) {
		InteractionDef def = new InteractionDef(interactionName, parameters, InteractionDef.TYPE.INTERACTION);
		interactions.add(def);
		log.trace("addInteraction=" + def);
	}
	
	@Override
	public void addObject(String objectName, Map<String, String> attributes) throws NameNotFound, FederateNotExecutionMember, RTIinternalError, ObjectNotKnown {
		InteractionDef def = new InteractionDef(objectName, attributes, InteractionDef.TYPE.OBJECT);
		interactions.add(def);
		log.trace("addObject=" + def);
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
