/**
 */
package gov.nist.hla.fom;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interactions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.fom.Interactions#getInteractionClass <em>Interaction Class</em>}</li>
 * </ul>
 *
 * @see gov.nist.hla.fom.FomPackage#getInteractions()
 * @model extendedMetaData="name='Interactions' kind='elementOnly'"
 * @generated
 */
public interface Interactions extends EObject {
	/**
	 * Returns the value of the '<em><b>Interaction Class</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nist.hla.fom.InteractionClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction Class</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction Class</em>' containment reference list.
	 * @see gov.nist.hla.fom.FomPackage#getInteractions_InteractionClass()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='interactionClass'"
	 * @generated
	 */
	EList<InteractionClass> getInteractionClass();

} // Interactions
