/**
 */
package gov.nist.hla.fom;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.fom.ObjectClass#getName <em>Name</em>}</li>
 *   <li>{@link gov.nist.hla.fom.ObjectClass#getObjectClass <em>Object Class</em>}</li>
 *   <li>{@link gov.nist.hla.fom.ObjectClass#getAttribute <em>Attribute</em>}</li>
 * </ul>
 *
 * @see gov.nist.hla.fom.FomPackage#getObjectClass()
 * @model extendedMetaData="name='ObjectClass' kind='elementOnly'"
 * @generated
 */
public interface ObjectClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see gov.nist.hla.fom.FomPackage#getObjectClass_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link gov.nist.hla.fom.ObjectClass#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Object Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Class</em>' containment reference.
	 * @see #setObjectClass(ObjectClass)
	 * @see gov.nist.hla.fom.FomPackage#getObjectClass_ObjectClass()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='objectClass'"
	 * @generated
	 */
	ObjectClass getObjectClass();

	/**
	 * Sets the value of the '{@link gov.nist.hla.fom.ObjectClass#getObjectClass <em>Object Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Class</em>' containment reference.
	 * @see #getObjectClass()
	 * @generated
	 */
	void setObjectClass(ObjectClass value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference.
	 * @see #setAttribute(Attribute)
	 * @see gov.nist.hla.fom.FomPackage#getObjectClass_Attribute()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='attribute'"
	 * @generated
	 */
	Attribute getAttribute();

	/**
	 * Sets the value of the '{@link gov.nist.hla.fom.ObjectClass#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(Attribute value);

} // ObjectClass
