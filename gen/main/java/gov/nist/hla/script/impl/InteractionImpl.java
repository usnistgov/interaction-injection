/**
 */
package gov.nist.hla.script.impl;

import gov.nist.hla.script.Interaction;
import gov.nist.hla.script.ScriptPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.script.impl.InteractionImpl#getInjectionTimeValue <em>Injection Time Value</em>}</li>
 *   <li>{@link gov.nist.hla.script.impl.InteractionImpl#getName <em>Name</em>}</li>
 *   <li>{@link gov.nist.hla.script.impl.InteractionImpl#getParam1 <em>Param1</em>}</li>
 *   <li>{@link gov.nist.hla.script.impl.InteractionImpl#getParam2 <em>Param2</em>}</li>
 *   <li>{@link gov.nist.hla.script.impl.InteractionImpl#getStartTime <em>Start Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InteractionImpl extends MinimalEObjectImpl.Container implements Interaction {
	/**
	 * The default value of the '{@link #getInjectionTimeValue() <em>Injection Time Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInjectionTimeValue()
	 * @generated
	 * @ordered
	 */
	protected static final double INJECTION_TIME_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInjectionTimeValue() <em>Injection Time Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInjectionTimeValue()
	 * @generated
	 * @ordered
	 */
	protected double injectionTimeValue = INJECTION_TIME_VALUE_EDEFAULT;

	/**
	 * This is true if the Injection Time Value attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean injectionTimeValueESet;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getParam1() <em>Param1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParam1()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAM1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParam1() <em>Param1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParam1()
	 * @generated
	 * @ordered
	 */
	protected String param1 = PARAM1_EDEFAULT;

	/**
	 * The default value of the '{@link #getParam2() <em>Param2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParam2()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAM2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParam2() <em>Param2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParam2()
	 * @generated
	 * @ordered
	 */
	protected String param2 = PARAM2_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected static final double START_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStartTime() <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartTime()
	 * @generated
	 * @ordered
	 */
	protected double startTime = START_TIME_EDEFAULT;

	/**
	 * This is true if the Start Time attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean startTimeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptPackage.Literals.INTERACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInjectionTimeValue() {
		return injectionTimeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInjectionTimeValue(double newInjectionTimeValue) {
		double oldInjectionTimeValue = injectionTimeValue;
		injectionTimeValue = newInjectionTimeValue;
		boolean oldInjectionTimeValueESet = injectionTimeValueESet;
		injectionTimeValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.INTERACTION__INJECTION_TIME_VALUE, oldInjectionTimeValue, injectionTimeValue, !oldInjectionTimeValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInjectionTimeValue() {
		double oldInjectionTimeValue = injectionTimeValue;
		boolean oldInjectionTimeValueESet = injectionTimeValueESet;
		injectionTimeValue = INJECTION_TIME_VALUE_EDEFAULT;
		injectionTimeValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ScriptPackage.INTERACTION__INJECTION_TIME_VALUE, oldInjectionTimeValue, INJECTION_TIME_VALUE_EDEFAULT, oldInjectionTimeValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInjectionTimeValue() {
		return injectionTimeValueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.INTERACTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParam1() {
		return param1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParam1(String newParam1) {
		String oldParam1 = param1;
		param1 = newParam1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.INTERACTION__PARAM1, oldParam1, param1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParam2() {
		return param2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParam2(String newParam2) {
		String oldParam2 = param2;
		param2 = newParam2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.INTERACTION__PARAM2, oldParam2, param2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStartTime() {
		return startTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartTime(double newStartTime) {
		double oldStartTime = startTime;
		startTime = newStartTime;
		boolean oldStartTimeESet = startTimeESet;
		startTimeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptPackage.INTERACTION__START_TIME, oldStartTime, startTime, !oldStartTimeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetStartTime() {
		double oldStartTime = startTime;
		boolean oldStartTimeESet = startTimeESet;
		startTime = START_TIME_EDEFAULT;
		startTimeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ScriptPackage.INTERACTION__START_TIME, oldStartTime, START_TIME_EDEFAULT, oldStartTimeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetStartTime() {
		return startTimeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScriptPackage.INTERACTION__INJECTION_TIME_VALUE:
				return getInjectionTimeValue();
			case ScriptPackage.INTERACTION__NAME:
				return getName();
			case ScriptPackage.INTERACTION__PARAM1:
				return getParam1();
			case ScriptPackage.INTERACTION__PARAM2:
				return getParam2();
			case ScriptPackage.INTERACTION__START_TIME:
				return getStartTime();
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
			case ScriptPackage.INTERACTION__INJECTION_TIME_VALUE:
				setInjectionTimeValue((Double)newValue);
				return;
			case ScriptPackage.INTERACTION__NAME:
				setName((String)newValue);
				return;
			case ScriptPackage.INTERACTION__PARAM1:
				setParam1((String)newValue);
				return;
			case ScriptPackage.INTERACTION__PARAM2:
				setParam2((String)newValue);
				return;
			case ScriptPackage.INTERACTION__START_TIME:
				setStartTime((Double)newValue);
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
			case ScriptPackage.INTERACTION__INJECTION_TIME_VALUE:
				unsetInjectionTimeValue();
				return;
			case ScriptPackage.INTERACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ScriptPackage.INTERACTION__PARAM1:
				setParam1(PARAM1_EDEFAULT);
				return;
			case ScriptPackage.INTERACTION__PARAM2:
				setParam2(PARAM2_EDEFAULT);
				return;
			case ScriptPackage.INTERACTION__START_TIME:
				unsetStartTime();
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
			case ScriptPackage.INTERACTION__INJECTION_TIME_VALUE:
				return isSetInjectionTimeValue();
			case ScriptPackage.INTERACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ScriptPackage.INTERACTION__PARAM1:
				return PARAM1_EDEFAULT == null ? param1 != null : !PARAM1_EDEFAULT.equals(param1);
			case ScriptPackage.INTERACTION__PARAM2:
				return PARAM2_EDEFAULT == null ? param2 != null : !PARAM2_EDEFAULT.equals(param2);
			case ScriptPackage.INTERACTION__START_TIME:
				return isSetStartTime();
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
		result.append(" (injectionTimeValue: ");
		if (injectionTimeValueESet) result.append(injectionTimeValue); else result.append("<unset>");
		result.append(", name: ");
		result.append(name);
		result.append(", param1: ");
		result.append(param1);
		result.append(", param2: ");
		result.append(param2);
		result.append(", startTime: ");
		if (startTimeESet) result.append(startTime); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //InteractionImpl
