/**
 */
package gov.nist.hla.script;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.script.Script#getInteraction <em>Interaction</em>}</li>
 *   <li>{@link gov.nist.hla.script.Script#getExpect <em>Expect</em>}</li>
 * </ul>
 *
 * @see gov.nist.hla.script.ScriptPackage#getScript()
 * @model extendedMetaData="name='Script' kind='elementOnly'"
 * @generated
 */
public interface Script extends EObject {
	/**
	 * Returns the value of the '<em><b>Interaction</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nist.hla.script.Interaction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction</em>' containment reference list.
	 * @see gov.nist.hla.script.ScriptPackage#getScript_Interaction()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='interaction'"
	 * @generated
	 */
	EList<Interaction> getInteraction();

	/**
	 * Returns the value of the '<em><b>Expect</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nist.hla.script.Expect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expect</em>' containment reference list.
	 * @see gov.nist.hla.script.ScriptPackage#getScript_Expect()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='expect'"
	 * @generated
	 */
	EList<Expect> getExpect();

} // Script
