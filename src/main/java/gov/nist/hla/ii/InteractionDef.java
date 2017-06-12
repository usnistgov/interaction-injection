package gov.nist.hla.ii;

import java.util.Map;

public class InteractionDef {
	
	protected final String name;
	protected final Map<String, String> parameters;
	
	public InteractionDef(String name, Map<String, String> parameters) {
		this.name = name;
		this.parameters = parameters;
	}

	public String getName() {
		return name;
	}
	
	public Map<String, String> getParameters() {
		return parameters;
	}
	
	public String toString() {
		return String.format("name=%s parameters=%d", name, parameters.size());
	}
}
