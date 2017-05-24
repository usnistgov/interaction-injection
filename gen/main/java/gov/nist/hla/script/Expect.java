/**
 */
package gov.nist.hla.script;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.script.Expect#getFederateType <em>Federate Type</em>}</li>
 * </ul>
 *
 * @see gov.nist.hla.script.ScriptPackage#getExpect()
 * @model extendedMetaData="name='Expect' kind='empty'"
 * @generated
 */
public interface Expect extends EObject {
	/**
	 * Returns the value of the '<em><b>Federate Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Federate Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Federate Type</em>' attribute.
	 * @see #setFederateType(String)
	 * @see gov.nist.hla.script.ScriptPackage#getExpect_FederateType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='federateType'"
	 * @generated
	 */
	String getFederateType();

	/**
	 * Sets the value of the '{@link gov.nist.hla.script.Expect#getFederateType <em>Federate Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Federate Type</em>' attribute.
	 * @see #getFederateType()
	 * @generated
	 */
	void setFederateType(String value);

} // Expect
