package gov.nist.hla.ii;

import java.util.Map;

public class ObjectDef extends InteractionDef {

	private final int classHandle;

	private final int objectHandle;

	public ObjectDef(String name, int classHandle, int objectHandle, 
			Map<String, String> parameters) {
		super(name, parameters);
		this.classHandle = classHandle;
		this.objectHandle = objectHandle;
	}

	public int getClassHandle() {
		return classHandle;
	}
	
	public int getObjectHandle() {
		return objectHandle;
	}
}
