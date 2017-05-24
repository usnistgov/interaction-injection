/**
 */
package gov.nist.hla.script;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link gov.nist.hla.script.Interaction#getInjectionTimeValue <em>Injection Time Value</em>}</li>
 *   <li>{@link gov.nist.hla.script.Interaction#getName <em>Name</em>}</li>
 *   <li>{@link gov.nist.hla.script.Interaction#getParam1 <em>Param1</em>}</li>
 *   <li>{@link gov.nist.hla.script.Interaction#getParam2 <em>Param2</em>}</li>
 *   <li>{@link gov.nist.hla.script.Interaction#getStartTime <em>Start Time</em>}</li>
 * </ul>
 *
 * @see gov.nist.hla.script.ScriptPackage#getInteraction()
 * @model extendedMetaData="name='Interaction' kind='elementOnly'"
 * @generated
 */
public interface Interaction extends EObject {
	/**
	 * Returns the value of the '<em><b>Injection Time Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Injection Time Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Injection Time Value</em>' attribute.
	 * @see #isSetInjectionTimeValue()
	 * @see #unsetInjectionTimeValue()
	 * @see #setInjectionTimeValue(double)
	 * @see gov.nist.hla.script.ScriptPackage#getInteraction_InjectionTimeValue()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 *        extendedMetaData="kind='element' name='injection_time_value'"
	 * @generated
	 */
	double getInjectionTimeValue();

	/**
	 * Sets the value of the '{@link gov.nist.hla.script.Interaction#getInjectionTimeValue <em>Injection Time Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Injection Time Value</em>' attribute.
	 * @see #isSetInjectionTimeValue()
	 * @see #unsetInjectionTimeValue()
	 * @see #getInjectionTimeValue()
	 * @generated
	 */
	void setInjectionTimeValue(double value);

	/**
	 * Unsets the value of the '{@link gov.nist.hla.script.Interaction#getInjectionTimeValue <em>Injection Time Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInjectionTimeValue()
	 * @see #getInjectionTimeValue()
	 * @see #setInjectionTimeValue(double)
	 * @generated
	 */
	void unsetInjectionTimeValue();

	/**
	 * Returns whether the value of the '{@link gov.nist.hla.script.Interaction#getInjectionTimeValue <em>Injection Time Value</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Injection Time Value</em>' attribute is set.
	 * @see #unsetInjectionTimeValue()
	 * @see #getInjectionTimeValue()
	 * @see #setInjectionTimeValue(double)
	 * @generated
	 */
	boolean isSetInjectionTimeValue();

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
	 * @see gov.nist.hla.script.ScriptPackage#getInteraction_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link gov.nist.hla.script.Interaction#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Param1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param1</em>' attribute.
	 * @see #setParam1(String)
	 * @see gov.nist.hla.script.ScriptPackage#getInteraction_Param1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='param1'"
	 * @generated
	 */
	String getParam1();

	/**
	 * Sets the value of the '{@link gov.nist.hla.script.Interaction#getParam1 <em>Param1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param1</em>' attribute.
	 * @see #getParam1()
	 * @generated
	 */
	void setParam1(String value);

	/**
	 * Returns the value of the '<em><b>Param2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param2</em>' attribute.
	 * @see #setParam2(String)
	 * @see gov.nist.hla.script.ScriptPackage#getInteraction_Param2()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='param2'"
	 * @generated
	 */
	String getParam2();

	/**
	 * Sets the value of the '{@link gov.nist.hla.script.Interaction#getParam2 <em>Param2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param2</em>' attribute.
	 * @see #getParam2()
	 * @generated
	 */
	void setParam2(String value);

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #isSetStartTime()
	 * @see #unsetStartTime()
	 * @see #setStartTime(double)
	 * @see gov.nist.hla.script.ScriptPackage#getInteraction_StartTime()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double" required="true"
	 *        extendedMetaData="kind='attribute' name='startTime'"
	 * @generated
	 */
	double getStartTime();

	/**
	 * Sets the value of the '{@link gov.nist.hla.script.Interaction#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #isSetStartTime()
	 * @see #unsetStartTime()
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(double value);

	/**
	 * Unsets the value of the '{@link gov.nist.hla.script.Interaction#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(double)
	 * @generated
	 */
	void unsetStartTime();

	/**
	 * Returns whether the value of the '{@link gov.nist.hla.script.Interaction#getStartTime <em>Start Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Time</em>' attribute is set.
	 * @see #unsetStartTime()
	 * @see #getStartTime()
	 * @see #setStartTime(double)
	 * @generated
	 */
	boolean isSetStartTime();

} // Interaction
