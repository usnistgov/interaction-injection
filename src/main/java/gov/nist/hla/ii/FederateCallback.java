package gov.nist.hla.ii;

import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface FederateCallback {

//	public InteractionClassType getInteractionClassType(int handle);
//	public InteractionClassType getInteractionClassType(String name);
//	public Set<InteractionClassType> getInteractionClassTypes();
//	public ObjectClassType getObjectClassType(int handle);
//	public ObjectClassType getObjectClassType(String name);
//	public Set<ObjectClassType> getObjectClassTypes();
	
	public boolean injectInteractions(SortedSet<Double> timesteps, Set<String> names, Set<Map<String, String>> parameters);
	public boolean updateObjects(SortedSet<Double> timesteps, Set<String> names, Set<Map<String, String>> attributes);

	public Object[] nextInteraction(Double timeStep);
	public Object[] nextObject(Double timeStep);
}
