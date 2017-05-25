/**
 */
package gov.nist.hla.script;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link gov.nist.hla.script.ObjectModel#getInteractions <em>Interactions</em>}</li>
 *   <li>{@link gov.nist.hla.script.ObjectModel#getObjects <em>Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @see gov.nist.hla.script.ScriptPackage#getObjectModel()
 * @model extendedMetaData="name='ObjectModel' kind='elementOnly'"
 * @generated
 */
public interface ObjectModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Interactions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interactions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interactions</em>' containment reference.
	 * @see #setInteractions(Interactions)
	 * @see gov.nist.hla.script.ScriptPackage#getObjectModel_Interactions()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='interactions'"
	 * @generated
	 */
	Interactions getInteractions();

	/**
	 * Sets the value of the '{@link gov.nist.hla.script.ObjectModel#getInteractions <em>Interactions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interactions</em>' containment reference.
	 * @see #getInteractions()
	 * @generated
	 */
	void setInteractions(Interactions value);

	/**
	 * Returns the value of the '<em><b>Objects</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' containment reference.
	 * @see #setObjects(Objects)
	 * @see gov.nist.hla.script.ScriptPackage#getObjectModel_Objects()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='objects'"
	 * @generated
	 */
	Objects getObjects();

	/**
	 * Sets the value of the '{@link gov.nist.hla.script.ObjectModel#getObjects <em>Objects</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Objects</em>' containment reference.
	 * @see #getObjects()
	 * @generated
	 */
	void setObjects(Objects value);

} // ObjectModel
