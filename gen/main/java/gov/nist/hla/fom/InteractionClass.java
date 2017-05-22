/**
 */
package gov.nist.hla.fom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.fom.InteractionClass#getName <em>Name</em>}</li>
 *   <li>{@link gov.nist.hla.fom.InteractionClass#getSharing <em>Sharing</em>}</li>
 *   <li>{@link gov.nist.hla.fom.InteractionClass#getInteractionClass <em>Interaction Class</em>}</li>
 *   <li>{@link gov.nist.hla.fom.InteractionClass#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see gov.nist.hla.fom.FomPackage#getInteractionClass()
 * @model extendedMetaData="name='InteractionClass' kind='elementOnly'"
 * @generated
 */
public interface InteractionClass extends EObject {
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
	 * @see gov.nist.hla.fom.FomPackage#getInteractionClass_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link gov.nist.hla.fom.InteractionClass#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sharing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sharing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sharing</em>' attribute.
	 * @see #setSharing(String)
	 * @see gov.nist.hla.fom.FomPackage#getInteractionClass_Sharing()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='sharing'"
	 * @generated
	 */
	String getSharing();

	/**
	 * Sets the value of the '{@link gov.nist.hla.fom.InteractionClass#getSharing <em>Sharing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sharing</em>' attribute.
	 * @see #getSharing()
	 * @generated
	 */
	void setSharing(String value);

	/**
	 * Returns the value of the '<em><b>Interaction Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction Class</em>' containment reference.
	 * @see #setInteractionClass(InteractionClass)
	 * @see gov.nist.hla.fom.FomPackage#getInteractionClass_InteractionClass()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='interactionClass'"
	 * @generated
	 */
	InteractionClass getInteractionClass();

	/**
	 * Sets the value of the '{@link gov.nist.hla.fom.InteractionClass#getInteractionClass <em>Interaction Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction Class</em>' containment reference.
	 * @see #getInteractionClass()
	 * @generated
	 */
	void setInteractionClass(InteractionClass value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link gov.nist.hla.fom.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see gov.nist.hla.fom.FomPackage#getInteractionClass_Parameter()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='parameter'"
	 * @generated
	 */
	EList<Parameter> getParameter();

} // InteractionClass
