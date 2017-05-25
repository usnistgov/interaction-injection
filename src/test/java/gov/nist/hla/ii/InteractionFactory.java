package gov.nist.hla.ii;

import java.util.HashMap;
import java.util.Map;

public class InteractionFactory {

	public static Map<String, String> createParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("param1", "paramValue1");
		parameters.put("param2", "paramValue2");
		parameters.put("param3", "paramValue3");
		return parameters;
	}
	
	public static Map<String, String> createAttributes() {
		Map<String, String> attrubutes = new HashMap<String, String>();
		attrubutes.put("attr1", "attrValue1");
		attrubutes.put("attr2", "attrValue2");
		attrubutes.put("attr3", "attrValue3");
		return attrubutes;
	}	
}
