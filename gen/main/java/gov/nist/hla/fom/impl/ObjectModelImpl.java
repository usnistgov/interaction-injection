/**
 */
package gov.nist.hla.fom.impl;

import gov.nist.hla.fom.FomPackage;
import gov.nist.hla.fom.Interactions;
import gov.nist.hla.fom.ObjectModel;
import gov.nist.hla.fom.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.fom.impl.ObjectModelImpl#getInteractions <em>Interactions</em>}</li>
 *   <li>{@link gov.nist.hla.fom.impl.ObjectModelImpl#getObjects <em>Objects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectModelImpl extends MinimalEObjectImpl.Container implements ObjectModel {
	/**
	 * The cached value of the '{@link #getInteractions() <em>Interactions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractions()
	 * @generated
	 * @ordered
	 */
	protected Interactions interactions;

	/**
	 * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjects()
	 * @generated
	 * @ordered
	 */
	protected Objects objects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FomPackage.Literals.OBJECT_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interactions getInteractions() {
		return interactions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteractions(Interactions newInteractions, NotificationChain msgs) {
		Interactions oldInteractions = interactions;
		interactions = newInteractions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FomPackage.OBJECT_MODEL__INTERACTIONS, oldInteractions, newInteractions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteractions(Interactions newInteractions) {
		if (newInteractions != interactions) {
			NotificationChain msgs = null;
			if (interactions != null)
				msgs = ((InternalEObject)interactions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FomPackage.OBJECT_MODEL__INTERACTIONS, null, msgs);
			if (newInteractions != null)
				msgs = ((InternalEObject)newInteractions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FomPackage.OBJECT_MODEL__INTERACTIONS, null, msgs);
			msgs = basicSetInteractions(newInteractions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FomPackage.OBJECT_MODEL__INTERACTIONS, newInteractions, newInteractions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Objects getObjects() {
		return objects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjects(Objects newObjects, NotificationChain msgs) {
		Objects oldObjects = objects;
		objects = newObjects;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FomPackage.OBJECT_MODEL__OBJECTS, oldObjects, newObjects);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjects(Objects newObjects) {
		if (newObjects != objects) {
			NotificationChain msgs = null;
			if (objects != null)
				msgs = ((InternalEObject)objects).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FomPackage.OBJECT_MODEL__OBJECTS, null, msgs);
			if (newObjects != null)
				msgs = ((InternalEObject)newObjects).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FomPackage.OBJECT_MODEL__OBJECTS, null, msgs);
			msgs = basicSetObjects(newObjects, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FomPackage.OBJECT_MODEL__OBJECTS, newObjects, newObjects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FomPackage.OBJECT_MODEL__INTERACTIONS:
				return basicSetInteractions(null, msgs);
			case FomPackage.OBJECT_MODEL__OBJECTS:
				return basicSetObjects(null, msgs);
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
			case FomPackage.OBJECT_MODEL__INTERACTIONS:
				return getInteractions();
			case FomPackage.OBJECT_MODEL__OBJECTS:
				return getObjects();
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
			case FomPackage.OBJECT_MODEL__INTERACTIONS:
				setInteractions((Interactions)newValue);
				return;
			case FomPackage.OBJECT_MODEL__OBJECTS:
				setObjects((Objects)newValue);
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
			case FomPackage.OBJECT_MODEL__INTERACTIONS:
				setInteractions((Interactions)null);
				return;
			case FomPackage.OBJECT_MODEL__OBJECTS:
				setObjects((Objects)null);
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
			case FomPackage.OBJECT_MODEL__INTERACTIONS:
				return interactions != null;
			case FomPackage.OBJECT_MODEL__OBJECTS:
				return objects != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectModelImpl
