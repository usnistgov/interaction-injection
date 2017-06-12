package gov.nist.hla.ii;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class InterObjReceptionImpl implements InterObjReception {

	private static final Logger log = LogManager
			.getLogger(InterObjReceptionImpl.class);

	@Override
	public abstract void receiveInteraction(Double timeStep, String interactionName,
			Map<String, String> parameters);
	
//	public void receiveInteraction(Interaction receivedInteraction,
//			RTIambassador rtiAmb) {
//		int interactionHandle = receivedInteraction.getInteractionClassHandle();
//		try {
//			String interactionName = rtiAmb
//					.getInteractionClassName(interactionHandle);
//			log.info("received interaction handle=" + interactionHandle
//					+ " name=" + interactionName);
//
//			HashMap<String, String> parameters = new HashMap<String, String>();
//			for (int i = 0; i < receivedInteraction.getParameterCount(); i++) {
//				int parameterHandle = receivedInteraction.getParameterHandle(i);
//				String parameterName = rtiAmb.getParameterName(parameterHandle,
//						interactionHandle);
//				String parameterValue = receivedInteraction
//						.getParameterValue(i);
//				log.debug(parameterName + "=" + parameterValue);
//				parameters.put(parameterName, parameterValue);
//			}
//		} catch (RTIexception e) {
//			log.error("", e);
//		}
//	}

	@Override
	public abstract void receiveObject(Double timeStep, String objectClassName, String objectName,
			Map<String, String> attributes);
	
//	@Override
//	public void receiveObject(ObjectReflection receivedObjectReflection,
//			RTIambassador rtiAmb) {
//		try {
//			int objectClassHandle = receivedObjectReflection.getObjectClass();
//			String objectClassName = rtiAmb
//					.getObjectClassName(objectClassHandle);
//			String objectName = receivedObjectReflection.getObjectName();
//			log.debug("received object class=" + objectClassName + ", name="
//					+ objectName);
//
//			HashMap<String, String> attributes = new HashMap<String, String>();
//			for (int i = 0; i < receivedObjectReflection.getAttributeCount(); i++) {
//				int attributeHandle = receivedObjectReflection
//						.getAttributeHandle(i);
//				String attributeName = rtiAmb.getAttributeName(attributeHandle,
//						objectClassHandle);
//				String attributeValue = receivedObjectReflection
//						.getAttributeValue(i);
//				log.debug(attributeName + "=" + attributeValue);
//				attributes.put(attributeName, attributeValue);
//			}
//		} catch (RTIexception e) {
//			log.error("", e);
//		}
//	}
}
