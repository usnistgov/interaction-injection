package gov.nist.hla.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterObjInjectionImpl implements InterObjInjection {

	private static final long serialVersionUID = -3409552497539566001L;

	private static final Logger log = LogManager
			.getLogger(InterObjInjectionImpl.class);

	protected final InjectionFederate injFed;

	Map<Double, List<InteractionDef>> interactions = new HashMap<Double, List<InteractionDef>>();

	Map<Double, List<ObjectDef>> objects = new HashMap<Double, List<ObjectDef>>();

	public InterObjInjectionImpl(InjectionFederate injFed) {
		super();
		this.injFed = injFed;
	}

	@Override
	public List<InteractionDef> getInteractions(Double timeStep) {
		// It won't do to return null so we instead return an empty set;
		List<InteractionDef> list = interactions.get(timeStep);
		// It won't do to return null so we instead return an empty set;
		if (list == null) {
			list = new ArrayList<InteractionDef>();
		}
		return list;
	}

	@Override
	public List<ObjectDef> getObjects(Double timeStep) {
		List<ObjectDef> list = objects.get(timeStep);
		// It won't do to return null so we instead return an empty set;
		if (list == null) {
			list = new ArrayList<ObjectDef>();
		}
		return list;
	}

	protected void addInteration(Double timeStep, String interactionName, Map<String, String> parameters) {
		List<InteractionDef> list = interactions.get(timeStep);
		if (list == null) {
			list = new ArrayList<InteractionDef>();
		}
		InteractionDef def = new InteractionDef(interactionName, parameters);
		list.add(def);
		interactions.put(timeStep, list);
	}
	
	protected void addObject(Double timeStep, String objectName, Map<String, String> attributes) {
		List<ObjectDef> list = objects.get(timeStep);
		if (list == null) {
			list = new ArrayList<ObjectDef>();
		}
		int classHandle = injFed.registerObject(objectName);
		int objectHandle = injFed.publishObject(objectName, attributes);
		ObjectDef def = new ObjectDef(objectName, classHandle, objectHandle, attributes);
		list.add(def);
		objects.put(timeStep, list);
	}

	protected String formatInteractionName(String interactionName) {
		return String.format("%s.%s", INTERACTION_NAME_ROOT, interactionName);
	}

	protected String formatObjectName(String objectName) {
		return String.format("%s.%s", OBJECT_NAME_ROOT, objectName);
	}
}
