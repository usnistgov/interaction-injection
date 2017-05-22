/**
 */
package gov.nist.hla.script.impl;

import gov.nist.hla.script.Expect;
import gov.nist.hla.script.ScriptPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.script.impl.ExpectImpl#getFederateType <em>Federate Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpectImpl extends MinimalEObjectImpl.Container implements Expect {
	/**
	 * The default value of the '{@link #getFederateType() <em>Federate Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFederateType()
	 * @generated
	 * @ordered
	 */
	protected static final String FEDERATE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFederateType() <em>Federate Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFederateType()
	 * @generated
	 * @ordered
	 */
	protected String federateType = FEDERATE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptPackage.Literals.EXPECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFederateType() {
		return federateType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFederateType(String newFederateType) {
		String oldFederateType = federateType;
		federateType = newFederateType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.EXPECT__FEDERATE_TYPE, oldFederateType, federateType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScriptPackage.EXPECT__FEDERATE_TYPE:
				return getFederateType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScriptPackage.EXPECT__FEDERATE_TYPE:
				setFederateType((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ScriptPackage.EXPECT__FEDERATE_TYPE:
				setFederateType(FEDERATE_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScriptPackage.EXPECT__FEDERATE_TYPE:
				return FEDERATE_TYPE_EDEFAULT == null ? federateType != null : !FEDERATE_TYPE_EDEFAULT.equals(federateType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (federateType: ");
		result.append(federateType);
		result.append(')');
		return result.toString();
	}

} //ExpectImpl
