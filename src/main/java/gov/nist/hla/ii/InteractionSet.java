package gov.nist.hla.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InteractionSet extends HashMap<Double, List<InteractionDef>> {
	
	
	private static final long serialVersionUID = -3409552497539566001L;

	public void add(Double timeStep, InteractionDef interactionDef) {
		List<InteractionDef> list = this.get(timeStep);
		if (list == null) {
			list = new ArrayList<InteractionDef>();
		}
		list.add(interactionDef);
		this.put(timeStep, list);
	}

	public void remove(Double timeStep, InteractionDef interactionDef) {
		List<InteractionDef> list = this.get(timeStep);
		if (list == null) {
			return;
		}
		list.remove(interactionDef);
		if (list.size() == 0) {
//			this.remove(timeStep, list);
		}
	}
}
