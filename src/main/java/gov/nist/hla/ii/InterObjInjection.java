package gov.nist.hla.ii;

import hla.rti.FederateNotExecutionMember;
import hla.rti.NameNotFound;
import hla.rti.ObjectNotKnown;
import hla.rti.RTIinternalError;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public interface InterObjInjection {
	
	public BlockingQueue<InterObjDef> getInteractions();

	public void addObject(String objectName, Map<String, String> attributes) throws NameNotFound, FederateNotExecutionMember, RTIinternalError, ObjectNotKnown;

	public void addInteraction(String interactionName, Map<String, String> parameters);

	void addInterObj(InterObjDef def);
}