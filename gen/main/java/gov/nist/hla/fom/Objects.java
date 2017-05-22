/**
 */
package gov.nist.hla.fom;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Objects</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.fom.Objects#getObjectClass <em>Object Class</em>}</li>
 * </ul>
 *
 * @see gov.nist.hla.fom.FomPackage#getObjects()
 * @model extendedMetaData="name='Objects' kind='elementOnly'"
 * @generated
 */
public interface Objects extends EObject {
	/**
	 * Returns the value of the '<em><b>Object Class</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nist.hla.fom.ObjectClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Class</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Class</em>' containment reference list.
	 * @see gov.nist.hla.fom.FomPackage#getObjects_ObjectClass()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='objectClass'"
	 * @generated
	 */
	EList<ObjectClass> getObjectClass();

} // Objects
