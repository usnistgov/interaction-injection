package gov.nist.hla.ii;

import java.util.Map;

public class InteractionDef {
	
	public enum TYPE {INTERACTION, OBJECT};
	
	public final TYPE type;
	private String name;
	private Map<String, String> parameters;
	
	public InteractionDef(TYPE type) {
		super();
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public TYPE getType() {
		return type;
	}
}
