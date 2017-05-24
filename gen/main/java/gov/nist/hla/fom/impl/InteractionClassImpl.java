/**
 */
package gov.nist.hla.fom.impl;

import gov.nist.hla.fom.FomPackage;
import gov.nist.hla.fom.InteractionClass;

import gov.nist.hla.fom.Parameter;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.fom.impl.InteractionClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link gov.nist.hla.fom.impl.InteractionClassImpl#getSharing <em>Sharing</em>}</li>
 *   <li>{@link gov.nist.hla.fom.impl.InteractionClassImpl#getInteractionClass <em>Interaction Class</em>}</li>
 *   <li>{@link gov.nist.hla.fom.impl.InteractionClassImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InteractionClassImpl extends MinimalEObjectImpl.Container implements InteractionClass {
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
	 * The default value of the '{@link #getSharing() <em>Sharing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharing()
	 * @generated
	 * @ordered
	 */
	protected static final String SHARING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSharing() <em>Sharing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharing()
	 * @generated
	 * @ordered
	 */
	protected String sharing = SHARING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInteractionClass() <em>Interaction Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionClass()
	 * @generated
	 * @ordered
	 */
	protected InteractionClass interactionClass;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FomPackage.Literals.INTERACTION_CLASS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, FomPackage.INTERACTION_CLASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSharing() {
		return sharing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharing(String newSharing) {
		String oldSharing = sharing;
		sharing = newSharing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FomPackage.INTERACTION_CLASS__SHARING, oldSharing, sharing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionClass getInteractionClass() {
		return interactionClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteractionClass(InteractionClass newInteractionClass, NotificationChain msgs) {
		InteractionClass oldInteractionClass = interactionClass;
		interactionClass = newInteractionClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FomPackage.INTERACTION_CLASS__INTERACTION_CLASS, oldInteractionClass, newInteractionClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteractionClass(InteractionClass newInteractionClass) {
		if (newInteractionClass != interactionClass) {
			NotificationChain msgs = null;
			if (interactionClass != null)
				msgs = ((InternalEObject)interactionClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FomPackage.INTERACTION_CLASS__INTERACTION_CLASS, null, msgs);
			if (newInteractionClass != null)
				msgs = ((InternalEObject)newInteractionClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FomPackage.INTERACTION_CLASS__INTERACTION_CLASS, null, msgs);
			msgs = basicSetInteractionClass(newInteractionClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FomPackage.INTERACTION_CLASS__INTERACTION_CLASS, newInteractionClass, newInteractionClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, FomPackage.INTERACTION_CLASS__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FomPackage.INTERACTION_CLASS__INTERACTION_CLASS:
				return basicSetInteractionClass(null, msgs);
			case FomPackage.INTERACTION_CLASS__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FomPackage.INTERACTION_CLASS__NAME:
				return getName();
			case FomPackage.INTERACTION_CLASS__SHARING:
				return getSharing();
			case FomPackage.INTERACTION_CLASS__INTERACTION_CLASS:
				return getInteractionClass();
			case FomPackage.INTERACTION_CLASS__PARAMETER:
				return getParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FomPackage.INTERACTION_CLASS__NAME:
				setName((String)newValue);
				return;
			case FomPackage.INTERACTION_CLASS__SHARING:
				setSharing((String)newValue);
				return;
			case FomPackage.INTERACTION_CLASS__INTERACTION_CLASS:
				setInteractionClass((InteractionClass)newValue);
				return;
			case FomPackage.INTERACTION_CLASS__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
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
			case FomPackage.INTERACTION_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case FomPackage.INTERACTION_CLASS__SHARING:
				setSharing(SHARING_EDEFAULT);
				return;
			case FomPackage.INTERACTION_CLASS__INTERACTION_CLASS:
				setInteractionClass((InteractionClass)null);
				return;
			case FomPackage.INTERACTION_CLASS__PARAMETER:
				getParameter().clear();
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
			case FomPackage.INTERACTION_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case FomPackage.INTERACTION_CLASS__SHARING:
				return SHARING_EDEFAULT == null ? sharing != null : !SHARING_EDEFAULT.equals(sharing);
			case FomPackage.INTERACTION_CLASS__INTERACTION_CLASS:
				return interactionClass != null;
			case FomPackage.INTERACTION_CLASS__PARAMETER:
				return parameter != null && !parameter.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", sharing: ");
		result.append(sharing);
		result.append(')');
		return result.toString();
	}

} //InteractionClassImpl
