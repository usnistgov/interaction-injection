/**
 */
package gov.nist.hla.fom.impl;

import gov.nist.hla.fom.FomPackage;
import gov.nist.hla.fom.ObjectClass;
import gov.nist.hla.fom.Objects;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Objects</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.fom.impl.ObjectsImpl#getObjectClass <em>Object Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectsImpl extends MinimalEObjectImpl.Container implements Objects {
	/**
	 * The cached value of the '{@link #getObjectClass() <em>Object Class</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectClass()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectClass> objectClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FomPackage.Literals.OBJECTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectClass> getObjectClass() {
		if (objectClass == null) {
			objectClass = new EObjectContainmentEList<ObjectClass>(ObjectClass.class, this, FomPackage.OBJECTS__OBJECT_CLASS);
		}
		return objectClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case FomPackage.OBJECTS__OBJECT_CLASS:
				return ((InternalEList<?>)getObjectClass()).basicRemove(otherEnd, msgs);
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
			case FomPackage.OBJECTS__OBJECT_CLASS:
				return getObjectClass();
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
			case FomPackage.OBJECTS__OBJECT_CLASS:
				getObjectClass().clear();
				getObjectClass().addAll((Collection<? extends ObjectClass>)newValue);
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
			case FomPackage.OBJECTS__OBJECT_CLASS:
				getObjectClass().clear();
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
			case FomPackage.OBJECTS__OBJECT_CLASS:
				return objectClass != null && !objectClass.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObjectsImpl
