package gov.nist.hla.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultInterObjSetImpl  implements InterObjSet {
		
	private static final long serialVersionUID = -3409552497539566001L;

	private static final Logger log = LogManager
			.getLogger(DefaultInterObjSetImpl.class);

	private final InjectionFederate injFed;
	
	Map<Double, List<InteractionDef>> interactions = new HashMap<Double, List<InteractionDef>>();

	Map<Double, List<ObjectDef>> objects = new HashMap<Double, List<ObjectDef>>();
	
	public DefaultInterObjSetImpl(InjectionFederate injFed) {
		super();
		this.injFed = injFed;
	}

	@Override
	public List<InteractionDef> getInteractions(Double timeStep) {
		return interactions.get(timeStep);
	}

	@Override
	public List<ObjectDef> getObjects(Double timeStep) {
		return objects.get(timeStep);
	}

	private void add(Double timeStep, InteractionDef def) {
		List<InteractionDef> list = interactions.get(timeStep);
		if (list == null) {
			list = new ArrayList<InteractionDef>();
		}
		list.add(def);
		interactions.put(timeStep, list);
	}

	private void add(Double timeStep, ObjectDef def) {
		List<ObjectDef> list = objects.get(timeStep);
		if (list == null) {
			list = new ArrayList<ObjectDef>();
		}
		list.add(def);
		objects.put(timeStep, list);
	}
	
	public void init() {
		String objectName = String
				.format("%s.%s", OBJECT_NAME_ROOT, "Obj1");
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put("Obj1Attr1", "XXX");
		int objectHandle = injFed.publishObject(objectName, attrMap);
		int instanceHandle = injFed.registerObject(objectName);
		ObjectDef objDef = new ObjectDef(objectName, objectHandle, instanceHandle, attrMap);
		add(1D, objDef);
		
		String interactionName = String.format("%s.%s", INTERACTION_NAME_ROOT, "Int1");
		Map<String, String> paramMap = new HashMap<String, String>(); 
		log.trace("paramMap==>" + paramMap.size());
		InteractionDef itrDef = new InteractionDef(interactionName, paramMap);
		add(1D, itrDef);
		log.info("injectObject==>");

	}
}
