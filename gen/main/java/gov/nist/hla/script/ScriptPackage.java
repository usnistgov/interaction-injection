/**
 */
package gov.nist.hla.script;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see gov.nist.hla.script.ScriptFactory
 * @model kind="package"
 * @generated
 */
public interface ScriptPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "script";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://hla.nist.gov/script.Script";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "script";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScriptPackage eINSTANCE = gov.nist.hla.script.impl.ScriptPackageImpl.init();

	/**
	 * The meta object id for the '{@link gov.nist.hla.script.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nist.hla.script.impl.AttributeImpl
	 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__DATA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Sharing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__SHARING = 2;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nist.hla.script.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nist.hla.script.impl.DocumentRootImpl
	 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Objectmodel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__OBJECTMODEL = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nist.hla.script.impl.InteractionClassImpl <em>Interaction Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nist.hla.script.impl.InteractionClassImpl
	 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getInteractionClass()
	 * @generated
	 */
	int INTERACTION_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_CLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Sharing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_CLASS__SHARING = 1;

	/**
	 * The number of structural features of the '<em>Interaction Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_CLASS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Interaction Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nist.hla.script.impl.InteractionsImpl <em>Interactions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nist.hla.script.impl.InteractionsImpl
	 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getInteractions()
	 * @generated
	 */
	int INTERACTIONS = 3;

	/**
	 * The feature id for the '<em><b>Interaction Class</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTIONS__INTERACTION_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Interactions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTIONS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Interactions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nist.hla.script.impl.ObjectClassImpl <em>Object Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nist.hla.script.impl.ObjectClassImpl
	 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getObjectClass()
	 * @generated
	 */
	int OBJECT_CLASS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Object Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CLASS__OBJECT_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CLASS__ATTRIBUTE = 2;

	/**
	 * The number of structural features of the '<em>Object Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CLASS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Object Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nist.hla.script.impl.ObjectModelImpl <em>Object Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nist.hla.script.impl.ObjectModelImpl
	 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getObjectModel()
	 * @generated
	 */
	int OBJECT_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Interactions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_MODEL__INTERACTIONS = 0;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_MODEL__OBJECTS = 1;

	/**
	 * The number of structural features of the '<em>Object Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Object Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link gov.nist.hla.script.impl.ObjectsImpl <em>Objects</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see gov.nist.hla.script.impl.ObjectsImpl
	 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getObjects()
	 * @generated
	 */
	int OBJECTS = 6;

	/**
	 * The feature id for the '<em><b>Object Class</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTS__OBJECT_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Objects</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Objects</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECTS_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link gov.nist.hla.script.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see gov.nist.hla.script.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link gov.nist.hla.script.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see gov.nist.hla.script.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link gov.nist.hla.script.Attribute#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data Type</em>'.
	 * @see gov.nist.hla.script.Attribute#getDataType()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_DataType();

	/**
	 * Returns the meta object for the attribute '{@link gov.nist.hla.script.Attribute#getSharing <em>Sharing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sharing</em>'.
	 * @see gov.nist.hla.script.Attribute#getSharing()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Sharing();

	/**
	 * Returns the meta object for class '{@link gov.nist.hla.script.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see gov.nist.hla.script.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link gov.nist.hla.script.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see gov.nist.hla.script.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link gov.nist.hla.script.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see gov.nist.hla.script.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link gov.nist.hla.script.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see gov.nist.hla.script.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link gov.nist.hla.script.DocumentRoot#getObjectmodel <em>Objectmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Objectmodel</em>'.
	 * @see gov.nist.hla.script.DocumentRoot#getObjectmodel()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Objectmodel();

	/**
	 * Returns the meta object for class '{@link gov.nist.hla.script.InteractionClass <em>Interaction Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction Class</em>'.
	 * @see gov.nist.hla.script.InteractionClass
	 * @generated
	 */
	EClass getInteractionClass();

	/**
	 * Returns the meta object for the attribute '{@link gov.nist.hla.script.InteractionClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see gov.nist.hla.script.InteractionClass#getName()
	 * @see #getInteractionClass()
	 * @generated
	 */
	EAttribute getInteractionClass_Name();

	/**
	 * Returns the meta object for the attribute '{@link gov.nist.hla.script.InteractionClass#getSharing <em>Sharing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sharing</em>'.
	 * @see gov.nist.hla.script.InteractionClass#getSharing()
	 * @see #getInteractionClass()
	 * @generated
	 */
	EAttribute getInteractionClass_Sharing();

	/**
	 * Returns the meta object for class '{@link gov.nist.hla.script.Interactions <em>Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interactions</em>'.
	 * @see gov.nist.hla.script.Interactions
	 * @generated
	 */
	EClass getInteractions();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nist.hla.script.Interactions#getInteractionClass <em>Interaction Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Interaction Class</em>'.
	 * @see gov.nist.hla.script.Interactions#getInteractionClass()
	 * @see #getInteractions()
	 * @generated
	 */
	EReference getInteractions_InteractionClass();

	/**
	 * Returns the meta object for class '{@link gov.nist.hla.script.ObjectClass <em>Object Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Class</em>'.
	 * @see gov.nist.hla.script.ObjectClass
	 * @generated
	 */
	EClass getObjectClass();

	/**
	 * Returns the meta object for the attribute '{@link gov.nist.hla.script.ObjectClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see gov.nist.hla.script.ObjectClass#getName()
	 * @see #getObjectClass()
	 * @generated
	 */
	EAttribute getObjectClass_Name();

	/**
	 * Returns the meta object for the containment reference '{@link gov.nist.hla.script.ObjectClass#getObjectClass <em>Object Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Object Class</em>'.
	 * @see gov.nist.hla.script.ObjectClass#getObjectClass()
	 * @see #getObjectClass()
	 * @generated
	 */
	EReference getObjectClass_ObjectClass();

	/**
	 * Returns the meta object for the containment reference '{@link gov.nist.hla.script.ObjectClass#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see gov.nist.hla.script.ObjectClass#getAttribute()
	 * @see #getObjectClass()
	 * @generated
	 */
	EReference getObjectClass_Attribute();

	/**
	 * Returns the meta object for class '{@link gov.nist.hla.script.ObjectModel <em>Object Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Model</em>'.
	 * @see gov.nist.hla.script.ObjectModel
	 * @generated
	 */
	EClass getObjectModel();

	/**
	 * Returns the meta object for the containment reference '{@link gov.nist.hla.script.ObjectModel#getInteractions <em>Interactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Interactions</em>'.
	 * @see gov.nist.hla.script.ObjectModel#getInteractions()
	 * @see #getObjectModel()
	 * @generated
	 */
	EReference getObjectModel_Interactions();

	/**
	 * Returns the meta object for the containment reference '{@link gov.nist.hla.script.ObjectModel#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Objects</em>'.
	 * @see gov.nist.hla.script.ObjectModel#getObjects()
	 * @see #getObjectModel()
	 * @generated
	 */
	EReference getObjectModel_Objects();

	/**
	 * Returns the meta object for class '{@link gov.nist.hla.script.Objects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Objects</em>'.
	 * @see gov.nist.hla.script.Objects
	 * @generated
	 */
	EClass getObjects();

	/**
	 * Returns the meta object for the containment reference list '{@link gov.nist.hla.script.Objects#getObjectClass <em>Object Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Object Class</em>'.
	 * @see gov.nist.hla.script.Objects#getObjectClass()
	 * @see #getObjects()
	 * @generated
	 */
	EReference getObjects_ObjectClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScriptFactory getScriptFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link gov.nist.hla.script.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nist.hla.script.impl.AttributeImpl
		 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__DATA_TYPE = eINSTANCE.getAttribute_DataType();

		/**
		 * The meta object literal for the '<em><b>Sharing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__SHARING = eINSTANCE.getAttribute_Sharing();

		/**
		 * The meta object literal for the '{@link gov.nist.hla.script.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nist.hla.script.impl.DocumentRootImpl
		 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Objectmodel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__OBJECTMODEL = eINSTANCE.getDocumentRoot_Objectmodel();

		/**
		 * The meta object literal for the '{@link gov.nist.hla.script.impl.InteractionClassImpl <em>Interaction Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nist.hla.script.impl.InteractionClassImpl
		 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getInteractionClass()
		 * @generated
		 */
		EClass INTERACTION_CLASS = eINSTANCE.getInteractionClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION_CLASS__NAME = eINSTANCE.getInteractionClass_Name();

		/**
		 * The meta object literal for the '<em><b>Sharing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION_CLASS__SHARING = eINSTANCE.getInteractionClass_Sharing();

		/**
		 * The meta object literal for the '{@link gov.nist.hla.script.impl.InteractionsImpl <em>Interactions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nist.hla.script.impl.InteractionsImpl
		 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getInteractions()
		 * @generated
		 */
		EClass INTERACTIONS = eINSTANCE.getInteractions();

		/**
		 * The meta object literal for the '<em><b>Interaction Class</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTIONS__INTERACTION_CLASS = eINSTANCE.getInteractions_InteractionClass();

		/**
		 * The meta object literal for the '{@link gov.nist.hla.script.impl.ObjectClassImpl <em>Object Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nist.hla.script.impl.ObjectClassImpl
		 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getObjectClass()
		 * @generated
		 */
		EClass OBJECT_CLASS = eINSTANCE.getObjectClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT_CLASS__NAME = eINSTANCE.getObjectClass_Name();

		/**
		 * The meta object literal for the '<em><b>Object Class</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_CLASS__OBJECT_CLASS = eINSTANCE.getObjectClass_ObjectClass();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_CLASS__ATTRIBUTE = eINSTANCE.getObjectClass_Attribute();

		/**
		 * The meta object literal for the '{@link gov.nist.hla.script.impl.ObjectModelImpl <em>Object Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nist.hla.script.impl.ObjectModelImpl
		 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getObjectModel()
		 * @generated
		 */
		EClass OBJECT_MODEL = eINSTANCE.getObjectModel();

		/**
		 * The meta object literal for the '<em><b>Interactions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_MODEL__INTERACTIONS = eINSTANCE.getObjectModel_Interactions();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_MODEL__OBJECTS = eINSTANCE.getObjectModel_Objects();

		/**
		 * The meta object literal for the '{@link gov.nist.hla.script.impl.ObjectsImpl <em>Objects</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see gov.nist.hla.script.impl.ObjectsImpl
		 * @see gov.nist.hla.script.impl.ScriptPackageImpl#getObjects()
		 * @generated
		 */
		EClass OBJECTS = eINSTANCE.getObjects();

		/**
		 * The meta object literal for the '<em><b>Object Class</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECTS__OBJECT_CLASS = eINSTANCE.getObjects_ObjectClass();

	}

} //ScriptPackage
