package gov.nist.hla.ii;

import java.util.List;

public interface InterObjSet {
	
	public static final String INTERACTION_NAME_ROOT = "InteractionRoot.C2WInteractionRoot";

	public static final String OBJECT_NAME_ROOT = "ObjectRoot";

	public abstract List<InteractionDef> getInteractions(Double timeStep);

	public abstract List<ObjectDef> getObjects(Double timeStep);
}