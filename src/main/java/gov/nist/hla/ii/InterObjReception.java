package gov.nist.hla.ii;

import hla.rti.RTIambassador;

public interface InterObjReception {

	public void receiveInteraction(Interaction receivedInteraction, RTIambassador rtiAmb);
	public void receiveObject(ObjectReflection receivedObjectReflection, RTIambassador rtiAmb);
}
