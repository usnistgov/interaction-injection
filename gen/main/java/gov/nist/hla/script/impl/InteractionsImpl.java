/**
 */
package gov.nist.hla.script.impl;

import gov.nist.hla.script.InteractionClass;
import gov.nist.hla.script.Interactions;
import gov.nist.hla.script.ScriptPackage;

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
 * An implementation of the model object '<em><b>Interactions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link gov.nist.hla.script.impl.InteractionsImpl#getInteractionClass <em>Interaction Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InteractionsImpl extends MinimalEObjectImpl.Container implements Interactions {
	/**
	 * The cached value of the '{@link #getInteractionClass() <em>Interaction Class</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionClass()
	 * @generated
	 * @ordered
	 */
	protected EList<InteractionClass> interactionClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptPackage.Literals.INTERACTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InteractionClass> getInteractionClass() {
		if (interactionClass == null) {
			interactionClass = new EObjectContainmentEList<InteractionClass>(InteractionClass.class, this, ScriptPackage.INTERACTIONS__INTERACTION_CLASS);
		}
		return interactionClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScriptPackage.INTERACTIONS__INTERACTION_CLASS:
				return ((InternalEList<?>)getInteractionClass()).basicRemove(otherEnd, msgs);
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
			case ScriptPackage.INTERACTIONS__INTERACTION_CLASS:
				return getInteractionClass();
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
			case ScriptPackage.INTERACTIONS__INTERACTION_CLASS:
				getInteractionClass().clear();
				getInteractionClass().addAll((Collection<? extends InteractionClass>)newValue);
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
			case ScriptPackage.INTERACTIONS__INTERACTION_CLASS:
				getInteractionClass().clear();
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
			case ScriptPackage.INTERACTIONS__INTERACTION_CLASS:
				return interactionClass != null && !interactionClass.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InteractionsImpl
