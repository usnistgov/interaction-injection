package gov.nist.hla.ii;

import java.util.Map;

public class ObjectDef extends InteractionDef {

	private final int objectHandle;

	private final int instanceHandle;

	public ObjectDef(String name, int objectHandle, int instanceHandle,
			Map<String, String> parameters) {
		super(name, parameters);
		this.objectHandle = objectHandle;
		this.instanceHandle = instanceHandle;
	}

	public int getObjectHandle() {
		return objectHandle;
	}

	public int getInstanceHandle() {
		return instanceHandle;
	}
}
