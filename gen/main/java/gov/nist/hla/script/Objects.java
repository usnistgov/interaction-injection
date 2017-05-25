/**
 */
package gov.nist.hla.script;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Objects</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gov.nist.hla.script.Objects#getObjectClass <em>Object Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see gov.nist.hla.script.ScriptPackage#getObjects()
 * @model extendedMetaData="name='Objects' kind='elementOnly'"
 * @generated
 */
public interface Objects extends EObject {
	/**
	 * Returns the value of the '<em><b>Object Class</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nist.hla.script.ObjectClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Class</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Class</em>' containment reference list.
	 * @see gov.nist.hla.script.ScriptPackage#getObjects_ObjectClass()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='objectClass'"
	 * @generated
	 */
	EList<ObjectClass> getObjectClass();

} // Objects
