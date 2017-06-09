package gov.nist.hla.ii;

import hla.rti.RTIambassador;
import hla.rti.RTIexception;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultInterObjReceptionImpl implements InterObjReception {

	private static final Logger log = LogManager
			.getLogger(DefaultInterObjReceptionImpl.class);

	@Override
	public void receiveInteraction(Interaction receivedInteraction,
			RTIambassador rtiAmb) {
		int interactionHandle = receivedInteraction.getInteractionClassHandle();
		try {
			String interactionName = rtiAmb
					.getInteractionClassName(interactionHandle);
			log.info("received interaction handle=" + interactionHandle
					+ " name=" + interactionName);

			HashMap<String, String> parameters = new HashMap<String, String>();
			for (int i = 0; i < receivedInteraction.getParameterCount(); i++) {
				int parameterHandle = receivedInteraction.getParameterHandle(i);
				String parameterName = rtiAmb.getParameterName(parameterHandle,
						interactionHandle);
				String parameterValue = receivedInteraction
						.getParameterValue(i);
				log.debug(parameterName + "=" + parameterValue);
				parameters.put(parameterName, parameterValue);
			}
		} catch (RTIexception e) {
			log.error("", e);
		}
	}

	@Override
	public void receiveObject(ObjectReflection receivedObjectReflection,
			RTIambassador rtiAmb) {
		try {
			int objectClassHandle = receivedObjectReflection.getObjectClass();
			String objectClassName = rtiAmb
					.getObjectClassName(objectClassHandle);
			String objectName = receivedObjectReflection.getObjectName();
			log.debug("received object class=" + objectClassName + ", name="
					+ objectName);

			HashMap<String, String> attributes = new HashMap<String, String>();
			for (int i = 0; i < receivedObjectReflection.getAttributeCount(); i++) {
				int attributeHandle = receivedObjectReflection
						.getAttributeHandle(i);
				String attributeName = rtiAmb.getAttributeName(attributeHandle,
						objectClassHandle);
				String attributeValue = receivedObjectReflection
						.getAttributeValue(i);
				log.debug(attributeName + "=" + attributeValue);
				attributes.put(attributeName, attributeValue);
			}
		} catch (RTIexception e) {
			log.error("", e);
		}
	}
}
