/**
 */
package gov.nist.hla.script.impl;

import gov.nist.hla.script.Expect;
import gov.nist.hla.script.Interaction;
import gov.nist.hla.script.Script;
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
 * An implementation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.script.impl.ScriptImpl#getInteraction <em>Interaction</em>}</li>
 *   <li>{@link gov.nist.hla.script.impl.ScriptImpl#getExpect <em>Expect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScriptImpl extends MinimalEObjectImpl.Container implements Script {
	/**
	 * The cached value of the '{@link #getInteraction() <em>Interaction</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteraction()
	 * @generated
	 * @ordered
	 */
	protected EList<Interaction> interaction;

	/**
	 * The cached value of the '{@link #getExpect() <em>Expect</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpect()
	 * @generated
	 * @ordered
	 */
	protected EList<Expect> expect;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScriptPackage.Literals.SCRIPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interaction> getInteraction() {
		if (interaction == null) {
			interaction = new EObjectContainmentEList<Interaction>(Interaction.class, this, ScriptPackage.SCRIPT__INTERACTION);
		}
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expect> getExpect() {
		if (expect == null) {
			expect = new EObjectContainmentEList<Expect>(Expect.class, this, ScriptPackage.SCRIPT__EXPECT);
		}
		return expect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScriptPackage.SCRIPT__INTERACTION:
				return ((InternalEList<?>)getInteraction()).basicRemove(otherEnd, msgs);
			case ScriptPackage.SCRIPT__EXPECT:
				return ((InternalEList<?>)getExpect()).basicRemove(otherEnd, msgs);
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
			case ScriptPackage.SCRIPT__INTERACTION:
				return getInteraction();
			case ScriptPackage.SCRIPT__EXPECT:
				return getExpect();
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
			case ScriptPackage.SCRIPT__INTERACTION:
				getInteraction().clear();
				getInteraction().addAll((Collection<? extends Interaction>)newValue);
				return;
			case ScriptPackage.SCRIPT__EXPECT:
				getExpect().clear();
				getExpect().addAll((Collection<? extends Expect>)newValue);
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
			case ScriptPackage.SCRIPT__INTERACTION:
				getInteraction().clear();
				return;
			case ScriptPackage.SCRIPT__EXPECT:
				getExpect().clear();
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
			case ScriptPackage.SCRIPT__INTERACTION:
				return interaction != null && !interaction.isEmpty();
			case ScriptPackage.SCRIPT__EXPECT:
				return expect != null && !expect.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ScriptImpl
