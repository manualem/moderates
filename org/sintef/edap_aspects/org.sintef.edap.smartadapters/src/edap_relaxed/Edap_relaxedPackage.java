/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edap_relaxed.Edap_relaxedFactory
 * @model kind="package"
 * @generated
 */
public interface Edap_relaxedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "edap_relaxed";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://edap_relaxed";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edap_relaxed";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Edap_relaxedPackage eINSTANCE = edap_relaxed.impl.Edap_relaxedPackageImpl.init();

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.AspectModelElementImpl <em>Aspect Model Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.AspectModelElementImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getAspectModelElement()
	 * @generated
	 */
	int ASPECT_MODEL_ELEMENT = 38;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_MODEL_ELEMENT__ASPECT_ID = 0;

	/**
	 * The number of structural features of the '<em>Aspect Model Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASPECT_MODEL_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.EdapModelImpl <em>Edap Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.EdapModelImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEdapModel()
	 * @generated
	 */
	int EDAP_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDAP_MODEL__ASPECT_ID = ASPECT_MODEL_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDAP_MODEL__TYPES = ASPECT_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDAP_MODEL__IMPORTS = ASPECT_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edap Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDAP_MODEL_FEATURE_COUNT = ASPECT_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.EdapElementImpl <em>Edap Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.EdapElementImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEdapElement()
	 * @generated
	 */
	int EDAP_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDAP_ELEMENT__ASPECT_ID = ASPECT_MODEL_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDAP_ELEMENT__NAME = ASPECT_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edap Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDAP_ELEMENT_FEATURE_COUNT = ASPECT_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.AnnotatedElementImpl <em>Annotated Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.AnnotatedElementImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getAnnotatedElement()
	 * @generated
	 */
	int ANNOTATED_ELEMENT = 11;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATED_ELEMENT__ASPECT_ID = EDAP_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATED_ELEMENT__NAME = EDAP_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATED_ELEMENT__ANNOTATIONS = EDAP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Annotated Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATED_ELEMENT_FEATURE_COUNT = EDAP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.MessageImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__ASPECT_ID = ANNOTATED_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__NAME = ANNOTATED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__PARAMETERS = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allow Multicast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__ALLOW_MULTICAST = ANNOTATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.TypeImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 5;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__ASPECT_ID = ANNOTATED_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = ANNOTATED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ComponentImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 2;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ASPECT_ID = TYPE__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ANNOTATIONS = TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Composite Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__COMPOSITE_COMPONENT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PROPERTIES = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Partial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PARTIAL = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SINGLETON = TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Receives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__RECEIVES = TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Sends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__SENDS = TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__MESSAGES = TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__CONNECTORS = TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__PORTS = TYPE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = TYPE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ParameterImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__ASPECT_ID = EDAP_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = EDAP_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = EDAP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = EDAP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.PropertyImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ASPECT_ID = ANNOTATED_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = ANNOTATED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__CHANGEABLE = ANNOTATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LOWER_BOUND = ANNOTATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UPPER_BOUND = ANNOTATED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.PlatformAnnotationImpl <em>Platform Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.PlatformAnnotationImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPlatformAnnotation()
	 * @generated
	 */
	int PLATFORM_ANNOTATION = 7;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_ANNOTATION__ASPECT_ID = EDAP_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_ANNOTATION__NAME = EDAP_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_ANNOTATION__VALUE = EDAP_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Platform Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_ANNOTATION_FEATURE_COUNT = EDAP_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.EnumerationImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 8;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__ASPECT_ID = TYPE__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__ANNOTATIONS = TYPE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERALS = TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.PrimitiveTypeImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__ASPECT_ID = TYPE__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__ANNOTATIONS = TYPE__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.EnumerationLiteralImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 10;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__ASPECT_ID = ANNOTATED_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = ANNOTATED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.StateImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getState()
	 * @generated
	 */
	int STATE = 14;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ASPECT_ID = ANNOTATED_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__NAME = ANNOTATED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__OUTGOING = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__INCOMING = ANNOTATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ENTRY = ANNOTATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__EXIT = ANNOTATED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__PROPERTIES = ANNOTATED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.CompositeStateImpl <em>Composite State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.CompositeStateImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getCompositeState()
	 * @generated
	 */
	int COMPOSITE_STATE = 15;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__ASPECT_ID = STATE__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__NAME = STATE__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__ANNOTATIONS = STATE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__OUTGOING = STATE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__INCOMING = STATE__INCOMING;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__ENTRY = STATE__ENTRY;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__EXIT = STATE__EXIT;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__PROPERTIES = STATE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Substate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__SUBSTATE = STATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE__INITIAL = STATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composite State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STATE_FEATURE_COUNT = STATE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.StateMachineImpl <em>State Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.StateMachineImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getStateMachine()
	 * @generated
	 */
	int STATE_MACHINE = 12;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__ASPECT_ID = COMPOSITE_STATE__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__NAME = COMPOSITE_STATE__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__ANNOTATIONS = COMPOSITE_STATE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__OUTGOING = COMPOSITE_STATE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__INCOMING = COMPOSITE_STATE__INCOMING;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__ENTRY = COMPOSITE_STATE__ENTRY;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__EXIT = COMPOSITE_STATE__EXIT;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__PROPERTIES = COMPOSITE_STATE__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Substate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__SUBSTATE = COMPOSITE_STATE__SUBSTATE;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE__INITIAL = COMPOSITE_STATE__INITIAL;

	/**
	 * The number of structural features of the '<em>State Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_MACHINE_FEATURE_COUNT = COMPOSITE_STATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.TransitionImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 13;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ASPECT_ID = ANNOTATED_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = ANNOTATED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Event</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EVENT = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = ANNOTATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ACTION = ANNOTATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET = ANNOTATED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE = ANNOTATED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ActionImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 16;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ASPECT_ID = ANNOTATED_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = ANNOTATED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ActionBlockImpl <em>Action Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ActionBlockImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getActionBlock()
	 * @generated
	 */
	int ACTION_BLOCK = 17;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BLOCK__ASPECT_ID = ACTION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BLOCK__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BLOCK__ANNOTATIONS = ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BLOCK__ACTIONS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_BLOCK_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ExternStatementImpl <em>Extern Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ExternStatementImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getExternStatement()
	 * @generated
	 */
	int EXTERN_STATEMENT = 18;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_STATEMENT__ASPECT_ID = ACTION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_STATEMENT__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_STATEMENT__ANNOTATIONS = ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_STATEMENT__STATEMENT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extern Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_STATEMENT_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ExpressionImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 19;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__ASPECT_ID = ASPECT_MODEL_ELEMENT__ASPECT_ID;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = ASPECT_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ExternExpressionImpl <em>Extern Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ExternExpressionImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getExternExpression()
	 * @generated
	 */
	int EXTERN_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_EXPRESSION__ASPECT_ID = EXPRESSION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Extern Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERN_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.SendActionImpl <em>Send Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.SendActionImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getSendAction()
	 * @generated
	 */
	int SEND_ACTION = 21;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__ASPECT_ID = ACTION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__ANNOTATIONS = ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__PARAMETERS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__TARGET = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__MESSAGE = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION__PORT = ACTION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Send Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.BroadcastImpl <em>Broadcast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.BroadcastImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getBroadcast()
	 * @generated
	 */
	int BROADCAST = 22;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__ASPECT_ID = SEND_ACTION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__NAME = SEND_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__ANNOTATIONS = SEND_ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__PARAMETERS = SEND_ACTION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__TARGET = SEND_ACTION__TARGET;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__MESSAGE = SEND_ACTION__MESSAGE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST__PORT = SEND_ACTION__PORT;

	/**
	 * The number of structural features of the '<em>Broadcast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BROADCAST_FEATURE_COUNT = SEND_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.UnicastImpl <em>Unicast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.UnicastImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getUnicast()
	 * @generated
	 */
	int UNICAST = 23;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST__ASPECT_ID = SEND_ACTION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST__NAME = SEND_ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST__ANNOTATIONS = SEND_ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST__PARAMETERS = SEND_ACTION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST__TARGET = SEND_ACTION__TARGET;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST__MESSAGE = SEND_ACTION__MESSAGE;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST__PORT = SEND_ACTION__PORT;

	/**
	 * The number of structural features of the '<em>Unicast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNICAST_FEATURE_COUNT = SEND_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.PropertyAssignmentImpl <em>Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.PropertyAssignmentImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPropertyAssignment()
	 * @generated
	 */
	int PROPERTY_ASSIGNMENT = 24;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__ASPECT_ID = ACTION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__ANNOTATIONS = ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__PROPERTY = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__EXPRESSION = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.SoftwareComponentImpl <em>Software Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.SoftwareComponentImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getSoftwareComponent()
	 * @generated
	 */
	int SOFTWARE_COMPONENT = 25;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__ASPECT_ID = COMPONENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__ANNOTATIONS = COMPONENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Composite Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__COMPOSITE_COMPONENT = COMPONENT__COMPOSITE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__PROPERTIES = COMPONENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Partial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__PARTIAL = COMPONENT__PARTIAL;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__SINGLETON = COMPONENT__SINGLETON;

	/**
	 * The feature id for the '<em><b>Receives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__RECEIVES = COMPONENT__RECEIVES;

	/**
	 * The feature id for the '<em><b>Sends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__SENDS = COMPONENT__SENDS;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__MESSAGES = COMPONENT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__CONNECTORS = COMPONENT__CONNECTORS;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__PORTS = COMPONENT__PORTS;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT__BEHAVIOUR = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Software Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.DeviceImpl <em>Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.DeviceImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getDevice()
	 * @generated
	 */
	int DEVICE = 26;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__ASPECT_ID = COMPONENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__ANNOTATIONS = COMPONENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Composite Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__COMPOSITE_COMPONENT = COMPONENT__COMPOSITE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PROPERTIES = COMPONENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Partial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PARTIAL = COMPONENT__PARTIAL;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__SINGLETON = COMPONENT__SINGLETON;

	/**
	 * The feature id for the '<em><b>Receives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__RECEIVES = COMPONENT__RECEIVES;

	/**
	 * The feature id for the '<em><b>Sends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__SENDS = COMPONENT__SENDS;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__MESSAGES = COMPONENT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__CONNECTORS = COMPONENT__CONNECTORS;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE__PORTS = COMPONENT__PORTS;

	/**
	 * The number of structural features of the '<em>Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.EventImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 27;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ASPECT_ID = ASPECT_MODEL_ELEMENT__ASPECT_ID;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = ASPECT_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ReceiveMessageImpl <em>Receive Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ReceiveMessageImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getReceiveMessage()
	 * @generated
	 */
	int RECEIVE_MESSAGE = 28;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE__ASPECT_ID = EVENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Device</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE__DEVICE = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE__MESSAGE = EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Receive Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECEIVE_MESSAGE_FEATURE_COUNT = EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.SimulatorImpl <em>Simulator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.SimulatorImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getSimulator()
	 * @generated
	 */
	int SIMULATOR = 29;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__ASPECT_ID = SOFTWARE_COMPONENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__NAME = SOFTWARE_COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__ANNOTATIONS = SOFTWARE_COMPONENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Composite Component</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__COMPOSITE_COMPONENT = SOFTWARE_COMPONENT__COMPOSITE_COMPONENT;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__PROPERTIES = SOFTWARE_COMPONENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Partial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__PARTIAL = SOFTWARE_COMPONENT__PARTIAL;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__SINGLETON = SOFTWARE_COMPONENT__SINGLETON;

	/**
	 * The feature id for the '<em><b>Receives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__RECEIVES = SOFTWARE_COMPONENT__RECEIVES;

	/**
	 * The feature id for the '<em><b>Sends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__SENDS = SOFTWARE_COMPONENT__SENDS;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__MESSAGES = SOFTWARE_COMPONENT__MESSAGES;

	/**
	 * The feature id for the '<em><b>Connectors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__CONNECTORS = SOFTWARE_COMPONENT__CONNECTORS;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__PORTS = SOFTWARE_COMPONENT__PORTS;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__BEHAVIOUR = SOFTWARE_COMPONENT__BEHAVIOUR;

	/**
	 * The feature id for the '<em><b>Device</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR__DEVICE = SOFTWARE_COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simulator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATOR_FEATURE_COUNT = SOFTWARE_COMPONENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.DictionaryImpl <em>Dictionary</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.DictionaryImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getDictionary()
	 * @generated
	 */
	int DICTIONARY = 30;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY__ASPECT_ID = PROPERTY__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY__ANNOTATIONS = PROPERTY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY__TYPE = PROPERTY__TYPE;

	/**
	 * The feature id for the '<em><b>Changeable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY__CHANGEABLE = PROPERTY__CHANGEABLE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY__LOWER_BOUND = PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY__UPPER_BOUND = PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Index Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY__INDEX_TYPE = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dictionary</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ComponentReferenceImpl <em>Component Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ComponentReferenceImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getComponentReference()
	 * @generated
	 */
	int COMPONENT_REFERENCE = 31;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_REFERENCE__ASPECT_ID = EXPRESSION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_REFERENCE__COMPONENT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Navigations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.PropertyNavigationImpl <em>Property Navigation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.PropertyNavigationImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPropertyNavigation()
	 * @generated
	 */
	int PROPERTY_NAVIGATION = 32;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_NAVIGATION__ASPECT_ID = ASPECT_MODEL_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_NAVIGATION__PROPERTY = ASPECT_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Navigation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_NAVIGATION_FEATURE_COUNT = ASPECT_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.DictionaryNavigationImpl <em>Dictionary Navigation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.DictionaryNavigationImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getDictionaryNavigation()
	 * @generated
	 */
	int DICTIONARY_NAVIGATION = 33;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_NAVIGATION__ASPECT_ID = PROPERTY_NAVIGATION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_NAVIGATION__PROPERTY = PROPERTY_NAVIGATION__PROPERTY;

	/**
	 * The feature id for the '<em><b>Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_NAVIGATION__INDEX = PROPERTY_NAVIGATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dictionary Navigation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DICTIONARY_NAVIGATION_FEATURE_COUNT = PROPERTY_NAVIGATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.ConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.ConnectorImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getConnector()
	 * @generated
	 */
	int CONNECTOR = 34;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__ASPECT_ID = ANNOTATED_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__NAME = ANNOTATED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__OWNER = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PORT1 = ANNOTATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PORT2 = ANNOTATED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Prop1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PROP1 = ANNOTATED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Prop2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__PROP2 = ANNOTATED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.PortImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 35;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ASPECT_ID = ANNOTATED_ELEMENT__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = ANNOTATED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ANNOTATIONS = ANNOTATED_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OWNER = ANNOTATED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = ANNOTATED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.CreateActionImpl <em>Create Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.CreateActionImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getCreateAction()
	 * @generated
	 */
	int CREATE_ACTION = 36;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__ASPECT_ID = ACTION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__NAME = ACTION__NAME;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__ANNOTATIONS = ACTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION__REF = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Create Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edap_relaxed.impl.EventReferenceImpl <em>Event Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edap_relaxed.impl.EventReferenceImpl
	 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEventReference()
	 * @generated
	 */
	int EVENT_REFERENCE = 37;

	/**
	 * The feature id for the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__ASPECT_ID = EXPRESSION__ASPECT_ID;

	/**
	 * The feature id for the '<em><b>Msg Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__MSG_REF = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Param Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE__PARAM_REF = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link edap_relaxed.EdapModel <em>Edap Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edap Model</em>'.
	 * @see edap_relaxed.EdapModel
	 * @generated
	 */
	EClass getEdapModel();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.EdapModel#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see edap_relaxed.EdapModel#getTypes()
	 * @see #getEdapModel()
	 * @generated
	 */
	EReference getEdapModel_Types();

	/**
	 * Returns the meta object for the reference list '{@link edap_relaxed.EdapModel#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see edap_relaxed.EdapModel#getImports()
	 * @see #getEdapModel()
	 * @generated
	 */
	EReference getEdapModel_Imports();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see edap_relaxed.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.Message#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edap_relaxed.Message#getParameters()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.Message#isAllowMulticast <em>Allow Multicast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Multicast</em>'.
	 * @see edap_relaxed.Message#isAllowMulticast()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_AllowMulticast();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see edap_relaxed.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.Component#getCompositeComponent <em>Composite Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composite Component</em>'.
	 * @see edap_relaxed.Component#getCompositeComponent()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_CompositeComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.Component#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see edap_relaxed.Component#getProperties()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Properties();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.Component#isPartial <em>Partial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partial</em>'.
	 * @see edap_relaxed.Component#isPartial()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Partial();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.Component#isSingleton <em>Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Singleton</em>'.
	 * @see edap_relaxed.Component#isSingleton()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Singleton();

	/**
	 * Returns the meta object for the reference list '{@link edap_relaxed.Component#getReceives <em>Receives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receives</em>'.
	 * @see edap_relaxed.Component#getReceives()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Receives();

	/**
	 * Returns the meta object for the reference list '{@link edap_relaxed.Component#getSends <em>Sends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sends</em>'.
	 * @see edap_relaxed.Component#getSends()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Sends();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.Component#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Messages</em>'.
	 * @see edap_relaxed.Component#getMessages()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Messages();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.Component#getConnectors <em>Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connectors</em>'.
	 * @see edap_relaxed.Component#getConnectors()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Connectors();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.Component#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see edap_relaxed.Component#getPorts()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Ports();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see edap_relaxed.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edap_relaxed.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.EdapElement <em>Edap Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edap Element</em>'.
	 * @see edap_relaxed.EdapElement
	 * @generated
	 */
	EClass getEdapElement();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.EdapElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edap_relaxed.EdapElement#getName()
	 * @see #getEdapElement()
	 * @generated
	 */
	EAttribute getEdapElement_Name();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see edap_relaxed.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see edap_relaxed.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edap_relaxed.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_Type();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.Property#isChangeable <em>Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Changeable</em>'.
	 * @see edap_relaxed.Property#isChangeable()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Changeable();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.Property#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see edap_relaxed.Property#getLowerBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.Property#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see edap_relaxed.Property#getUpperBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_UpperBound();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.PlatformAnnotation <em>Platform Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platform Annotation</em>'.
	 * @see edap_relaxed.PlatformAnnotation
	 * @generated
	 */
	EClass getPlatformAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.PlatformAnnotation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edap_relaxed.PlatformAnnotation#getValue()
	 * @see #getPlatformAnnotation()
	 * @generated
	 */
	EAttribute getPlatformAnnotation_Value();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see edap_relaxed.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.Enumeration#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see edap_relaxed.Enumeration#getLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_Literals();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see edap_relaxed.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see edap_relaxed.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.AnnotatedElement <em>Annotated Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotated Element</em>'.
	 * @see edap_relaxed.AnnotatedElement
	 * @generated
	 */
	EClass getAnnotatedElement();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.AnnotatedElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see edap_relaxed.AnnotatedElement#getAnnotations()
	 * @see #getAnnotatedElement()
	 * @generated
	 */
	EReference getAnnotatedElement_Annotations();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.StateMachine <em>State Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Machine</em>'.
	 * @see edap_relaxed.StateMachine
	 * @generated
	 */
	EClass getStateMachine();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see edap_relaxed.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.Transition#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event</em>'.
	 * @see edap_relaxed.Transition#getEvent()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Event();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.Transition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard</em>'.
	 * @see edap_relaxed.Transition#getGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Guard();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.Transition#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see edap_relaxed.Transition#getAction()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Action();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edap_relaxed.Transition#getTarget()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Target();

	/**
	 * Returns the meta object for the container reference '{@link edap_relaxed.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see edap_relaxed.Transition#getSource()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Source();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see edap_relaxed.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.State#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Outgoing</em>'.
	 * @see edap_relaxed.State#getOutgoing()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link edap_relaxed.State#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see edap_relaxed.State#getIncoming()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Incoming();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.State#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Entry</em>'.
	 * @see edap_relaxed.State#getEntry()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Entry();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.State#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exit</em>'.
	 * @see edap_relaxed.State#getExit()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Exit();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.State#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see edap_relaxed.State#getProperties()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Properties();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.CompositeState <em>Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite State</em>'.
	 * @see edap_relaxed.CompositeState
	 * @generated
	 */
	EClass getCompositeState();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.CompositeState#getSubstate <em>Substate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Substate</em>'.
	 * @see edap_relaxed.CompositeState#getSubstate()
	 * @see #getCompositeState()
	 * @generated
	 */
	EReference getCompositeState_Substate();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.CompositeState#getInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial</em>'.
	 * @see edap_relaxed.CompositeState#getInitial()
	 * @see #getCompositeState()
	 * @generated
	 */
	EReference getCompositeState_Initial();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see edap_relaxed.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.ActionBlock <em>Action Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Block</em>'.
	 * @see edap_relaxed.ActionBlock
	 * @generated
	 */
	EClass getActionBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.ActionBlock#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see edap_relaxed.ActionBlock#getActions()
	 * @see #getActionBlock()
	 * @generated
	 */
	EReference getActionBlock_Actions();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.ExternStatement <em>Extern Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extern Statement</em>'.
	 * @see edap_relaxed.ExternStatement
	 * @generated
	 */
	EClass getExternStatement();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.ExternStatement#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Statement</em>'.
	 * @see edap_relaxed.ExternStatement#getStatement()
	 * @see #getExternStatement()
	 * @generated
	 */
	EAttribute getExternStatement_Statement();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see edap_relaxed.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.ExternExpression <em>Extern Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extern Expression</em>'.
	 * @see edap_relaxed.ExternExpression
	 * @generated
	 */
	EClass getExternExpression();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.ExternExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see edap_relaxed.ExternExpression#getExpression()
	 * @see #getExternExpression()
	 * @generated
	 */
	EAttribute getExternExpression_Expression();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.SendAction <em>Send Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send Action</em>'.
	 * @see edap_relaxed.SendAction
	 * @generated
	 */
	EClass getSendAction();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.SendAction#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edap_relaxed.SendAction#getParameters()
	 * @see #getSendAction()
	 * @generated
	 */
	EReference getSendAction_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.SendAction#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see edap_relaxed.SendAction#getTarget()
	 * @see #getSendAction()
	 * @generated
	 */
	EReference getSendAction_Target();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.SendAction#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see edap_relaxed.SendAction#getMessage()
	 * @see #getSendAction()
	 * @generated
	 */
	EReference getSendAction_Message();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.SendAction#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see edap_relaxed.SendAction#getPort()
	 * @see #getSendAction()
	 * @generated
	 */
	EReference getSendAction_Port();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Broadcast <em>Broadcast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Broadcast</em>'.
	 * @see edap_relaxed.Broadcast
	 * @generated
	 */
	EClass getBroadcast();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Unicast <em>Unicast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unicast</em>'.
	 * @see edap_relaxed.Unicast
	 * @generated
	 */
	EClass getUnicast();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.PropertyAssignment <em>Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Assignment</em>'.
	 * @see edap_relaxed.PropertyAssignment
	 * @generated
	 */
	EClass getPropertyAssignment();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.PropertyAssignment#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see edap_relaxed.PropertyAssignment#getProperty()
	 * @see #getPropertyAssignment()
	 * @generated
	 */
	EReference getPropertyAssignment_Property();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.PropertyAssignment#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see edap_relaxed.PropertyAssignment#getExpression()
	 * @see #getPropertyAssignment()
	 * @generated
	 */
	EReference getPropertyAssignment_Expression();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.SoftwareComponent <em>Software Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Component</em>'.
	 * @see edap_relaxed.SoftwareComponent
	 * @generated
	 */
	EClass getSoftwareComponent();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.SoftwareComponent#getBehaviour <em>Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behaviour</em>'.
	 * @see edap_relaxed.SoftwareComponent#getBehaviour()
	 * @see #getSoftwareComponent()
	 * @generated
	 */
	EReference getSoftwareComponent_Behaviour();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Device <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device</em>'.
	 * @see edap_relaxed.Device
	 * @generated
	 */
	EClass getDevice();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see edap_relaxed.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.ReceiveMessage <em>Receive Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Receive Message</em>'.
	 * @see edap_relaxed.ReceiveMessage
	 * @generated
	 */
	EClass getReceiveMessage();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.ReceiveMessage#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Device</em>'.
	 * @see edap_relaxed.ReceiveMessage#getDevice()
	 * @see #getReceiveMessage()
	 * @generated
	 */
	EReference getReceiveMessage_Device();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.ReceiveMessage#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see edap_relaxed.ReceiveMessage#getMessage()
	 * @see #getReceiveMessage()
	 * @generated
	 */
	EReference getReceiveMessage_Message();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Simulator <em>Simulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulator</em>'.
	 * @see edap_relaxed.Simulator
	 * @generated
	 */
	EClass getSimulator();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.Simulator#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Device</em>'.
	 * @see edap_relaxed.Simulator#getDevice()
	 * @see #getSimulator()
	 * @generated
	 */
	EReference getSimulator_Device();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Dictionary <em>Dictionary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dictionary</em>'.
	 * @see edap_relaxed.Dictionary
	 * @generated
	 */
	EClass getDictionary();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.Dictionary#getIndexType <em>Index Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Index Type</em>'.
	 * @see edap_relaxed.Dictionary#getIndexType()
	 * @see #getDictionary()
	 * @generated
	 */
	EReference getDictionary_IndexType();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.ComponentReference <em>Component Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Reference</em>'.
	 * @see edap_relaxed.ComponentReference
	 * @generated
	 */
	EClass getComponentReference();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.ComponentReference#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see edap_relaxed.ComponentReference#getComponent()
	 * @see #getComponentReference()
	 * @generated
	 */
	EReference getComponentReference_Component();

	/**
	 * Returns the meta object for the containment reference list '{@link edap_relaxed.ComponentReference#getPropertyNavigations <em>Property Navigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Navigations</em>'.
	 * @see edap_relaxed.ComponentReference#getPropertyNavigations()
	 * @see #getComponentReference()
	 * @generated
	 */
	EReference getComponentReference_PropertyNavigations();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.PropertyNavigation <em>Property Navigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Navigation</em>'.
	 * @see edap_relaxed.PropertyNavigation
	 * @generated
	 */
	EClass getPropertyNavigation();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.PropertyNavigation#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see edap_relaxed.PropertyNavigation#getProperty()
	 * @see #getPropertyNavigation()
	 * @generated
	 */
	EReference getPropertyNavigation_Property();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.DictionaryNavigation <em>Dictionary Navigation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dictionary Navigation</em>'.
	 * @see edap_relaxed.DictionaryNavigation
	 * @generated
	 */
	EClass getDictionaryNavigation();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.DictionaryNavigation#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Index</em>'.
	 * @see edap_relaxed.DictionaryNavigation#getIndex()
	 * @see #getDictionaryNavigation()
	 * @generated
	 */
	EReference getDictionaryNavigation_Index();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see edap_relaxed.Connector
	 * @generated
	 */
	EClass getConnector();

	/**
	 * Returns the meta object for the container reference '{@link edap_relaxed.Connector#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see edap_relaxed.Connector#getOwner()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Owner();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.Connector#getPort1 <em>Port1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port1</em>'.
	 * @see edap_relaxed.Connector#getPort1()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Port1();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.Connector#getPort2 <em>Port2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port2</em>'.
	 * @see edap_relaxed.Connector#getPort2()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Port2();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.Connector#getProp1 <em>Prop1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prop1</em>'.
	 * @see edap_relaxed.Connector#getProp1()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Prop1();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.Connector#getProp2 <em>Prop2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Prop2</em>'.
	 * @see edap_relaxed.Connector#getProp2()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Prop2();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see edap_relaxed.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the container reference '{@link edap_relaxed.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see edap_relaxed.Port#getOwner()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Owner();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.CreateAction <em>Create Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Action</em>'.
	 * @see edap_relaxed.CreateAction
	 * @generated
	 */
	EClass getCreateAction();

	/**
	 * Returns the meta object for the containment reference '{@link edap_relaxed.CreateAction#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ref</em>'.
	 * @see edap_relaxed.CreateAction#getRef()
	 * @see #getCreateAction()
	 * @generated
	 */
	EReference getCreateAction_Ref();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.EventReference <em>Event Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Reference</em>'.
	 * @see edap_relaxed.EventReference
	 * @generated
	 */
	EClass getEventReference();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.EventReference#getMsgRef <em>Msg Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Msg Ref</em>'.
	 * @see edap_relaxed.EventReference#getMsgRef()
	 * @see #getEventReference()
	 * @generated
	 */
	EReference getEventReference_MsgRef();

	/**
	 * Returns the meta object for the reference '{@link edap_relaxed.EventReference#getParamRef <em>Param Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Param Ref</em>'.
	 * @see edap_relaxed.EventReference#getParamRef()
	 * @see #getEventReference()
	 * @generated
	 */
	EReference getEventReference_ParamRef();

	/**
	 * Returns the meta object for class '{@link edap_relaxed.AspectModelElement <em>Aspect Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aspect Model Element</em>'.
	 * @see edap_relaxed.AspectModelElement
	 * @generated
	 */
	EClass getAspectModelElement();

	/**
	 * Returns the meta object for the attribute '{@link edap_relaxed.AspectModelElement#getAspectID <em>Aspect ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aspect ID</em>'.
	 * @see edap_relaxed.AspectModelElement#getAspectID()
	 * @see #getAspectModelElement()
	 * @generated
	 */
	EAttribute getAspectModelElement_AspectID();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Edap_relaxedFactory getEdap_relaxedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.EdapModelImpl <em>Edap Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.EdapModelImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEdapModel()
		 * @generated
		 */
		EClass EDAP_MODEL = eINSTANCE.getEdapModel();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDAP_MODEL__TYPES = eINSTANCE.getEdapModel_Types();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDAP_MODEL__IMPORTS = eINSTANCE.getEdapModel_Imports();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.MessageImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__PARAMETERS = eINSTANCE.getMessage_Parameters();

		/**
		 * The meta object literal for the '<em><b>Allow Multicast</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__ALLOW_MULTICAST = eINSTANCE.getMessage_AllowMulticast();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ComponentImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Composite Component</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__COMPOSITE_COMPONENT = eINSTANCE.getComponent_CompositeComponent();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PROPERTIES = eINSTANCE.getComponent_Properties();

		/**
		 * The meta object literal for the '<em><b>Partial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__PARTIAL = eINSTANCE.getComponent_Partial();

		/**
		 * The meta object literal for the '<em><b>Singleton</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__SINGLETON = eINSTANCE.getComponent_Singleton();

		/**
		 * The meta object literal for the '<em><b>Receives</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__RECEIVES = eINSTANCE.getComponent_Receives();

		/**
		 * The meta object literal for the '<em><b>Sends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__SENDS = eINSTANCE.getComponent_Sends();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__MESSAGES = eINSTANCE.getComponent_Messages();

		/**
		 * The meta object literal for the '<em><b>Connectors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__CONNECTORS = eINSTANCE.getComponent_Connectors();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__PORTS = eINSTANCE.getComponent_Ports();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ParameterImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.EdapElementImpl <em>Edap Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.EdapElementImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEdapElement()
		 * @generated
		 */
		EClass EDAP_ELEMENT = eINSTANCE.getEdapElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDAP_ELEMENT__NAME = eINSTANCE.getEdapElement_Name();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.TypeImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.PropertyImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Changeable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__CHANGEABLE = eINSTANCE.getProperty_Changeable();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__LOWER_BOUND = eINSTANCE.getProperty_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__UPPER_BOUND = eINSTANCE.getProperty_UpperBound();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.PlatformAnnotationImpl <em>Platform Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.PlatformAnnotationImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPlatformAnnotation()
		 * @generated
		 */
		EClass PLATFORM_ANNOTATION = eINSTANCE.getPlatformAnnotation();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLATFORM_ANNOTATION__VALUE = eINSTANCE.getPlatformAnnotation_Value();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.EnumerationImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__LITERALS = eINSTANCE.getEnumeration_Literals();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.PrimitiveTypeImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.EnumerationLiteralImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.AnnotatedElementImpl <em>Annotated Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.AnnotatedElementImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getAnnotatedElement()
		 * @generated
		 */
		EClass ANNOTATED_ELEMENT = eINSTANCE.getAnnotatedElement();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATED_ELEMENT__ANNOTATIONS = eINSTANCE.getAnnotatedElement_Annotations();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.StateMachineImpl <em>State Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.StateMachineImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getStateMachine()
		 * @generated
		 */
		EClass STATE_MACHINE = eINSTANCE.getStateMachine();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.TransitionImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__EVENT = eINSTANCE.getTransition_Event();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__ACTION = eINSTANCE.getTransition_Action();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET = eINSTANCE.getTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE = eINSTANCE.getTransition_Source();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.StateImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__OUTGOING = eINSTANCE.getState_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__INCOMING = eINSTANCE.getState_Incoming();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__ENTRY = eINSTANCE.getState_Entry();

		/**
		 * The meta object literal for the '<em><b>Exit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__EXIT = eINSTANCE.getState_Exit();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__PROPERTIES = eINSTANCE.getState_Properties();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.CompositeStateImpl <em>Composite State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.CompositeStateImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getCompositeState()
		 * @generated
		 */
		EClass COMPOSITE_STATE = eINSTANCE.getCompositeState();

		/**
		 * The meta object literal for the '<em><b>Substate</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE__SUBSTATE = eINSTANCE.getCompositeState_Substate();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STATE__INITIAL = eINSTANCE.getCompositeState_Initial();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ActionImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ActionBlockImpl <em>Action Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ActionBlockImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getActionBlock()
		 * @generated
		 */
		EClass ACTION_BLOCK = eINSTANCE.getActionBlock();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_BLOCK__ACTIONS = eINSTANCE.getActionBlock_Actions();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ExternStatementImpl <em>Extern Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ExternStatementImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getExternStatement()
		 * @generated
		 */
		EClass EXTERN_STATEMENT = eINSTANCE.getExternStatement();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERN_STATEMENT__STATEMENT = eINSTANCE.getExternStatement_Statement();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ExpressionImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ExternExpressionImpl <em>Extern Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ExternExpressionImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getExternExpression()
		 * @generated
		 */
		EClass EXTERN_EXPRESSION = eINSTANCE.getExternExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERN_EXPRESSION__EXPRESSION = eINSTANCE.getExternExpression_Expression();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.SendActionImpl <em>Send Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.SendActionImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getSendAction()
		 * @generated
		 */
		EClass SEND_ACTION = eINSTANCE.getSendAction();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_ACTION__PARAMETERS = eINSTANCE.getSendAction_Parameters();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_ACTION__TARGET = eINSTANCE.getSendAction_Target();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_ACTION__MESSAGE = eINSTANCE.getSendAction_Message();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND_ACTION__PORT = eINSTANCE.getSendAction_Port();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.BroadcastImpl <em>Broadcast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.BroadcastImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getBroadcast()
		 * @generated
		 */
		EClass BROADCAST = eINSTANCE.getBroadcast();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.UnicastImpl <em>Unicast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.UnicastImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getUnicast()
		 * @generated
		 */
		EClass UNICAST = eINSTANCE.getUnicast();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.PropertyAssignmentImpl <em>Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.PropertyAssignmentImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPropertyAssignment()
		 * @generated
		 */
		EClass PROPERTY_ASSIGNMENT = eINSTANCE.getPropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ASSIGNMENT__PROPERTY = eINSTANCE.getPropertyAssignment_Property();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ASSIGNMENT__EXPRESSION = eINSTANCE.getPropertyAssignment_Expression();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.SoftwareComponentImpl <em>Software Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.SoftwareComponentImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getSoftwareComponent()
		 * @generated
		 */
		EClass SOFTWARE_COMPONENT = eINSTANCE.getSoftwareComponent();

		/**
		 * The meta object literal for the '<em><b>Behaviour</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_COMPONENT__BEHAVIOUR = eINSTANCE.getSoftwareComponent_Behaviour();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.DeviceImpl <em>Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.DeviceImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getDevice()
		 * @generated
		 */
		EClass DEVICE = eINSTANCE.getDevice();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.EventImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ReceiveMessageImpl <em>Receive Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ReceiveMessageImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getReceiveMessage()
		 * @generated
		 */
		EClass RECEIVE_MESSAGE = eINSTANCE.getReceiveMessage();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_MESSAGE__DEVICE = eINSTANCE.getReceiveMessage_Device();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECEIVE_MESSAGE__MESSAGE = eINSTANCE.getReceiveMessage_Message();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.SimulatorImpl <em>Simulator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.SimulatorImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getSimulator()
		 * @generated
		 */
		EClass SIMULATOR = eINSTANCE.getSimulator();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMULATOR__DEVICE = eINSTANCE.getSimulator_Device();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.DictionaryImpl <em>Dictionary</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.DictionaryImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getDictionary()
		 * @generated
		 */
		EClass DICTIONARY = eINSTANCE.getDictionary();

		/**
		 * The meta object literal for the '<em><b>Index Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICTIONARY__INDEX_TYPE = eINSTANCE.getDictionary_IndexType();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ComponentReferenceImpl <em>Component Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ComponentReferenceImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getComponentReference()
		 * @generated
		 */
		EClass COMPONENT_REFERENCE = eINSTANCE.getComponentReference();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_REFERENCE__COMPONENT = eINSTANCE.getComponentReference_Component();

		/**
		 * The meta object literal for the '<em><b>Property Navigations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS = eINSTANCE.getComponentReference_PropertyNavigations();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.PropertyNavigationImpl <em>Property Navigation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.PropertyNavigationImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPropertyNavigation()
		 * @generated
		 */
		EClass PROPERTY_NAVIGATION = eINSTANCE.getPropertyNavigation();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_NAVIGATION__PROPERTY = eINSTANCE.getPropertyNavigation_Property();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.DictionaryNavigationImpl <em>Dictionary Navigation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.DictionaryNavigationImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getDictionaryNavigation()
		 * @generated
		 */
		EClass DICTIONARY_NAVIGATION = eINSTANCE.getDictionaryNavigation();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DICTIONARY_NAVIGATION__INDEX = eINSTANCE.getDictionaryNavigation_Index();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.ConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.ConnectorImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getConnector()
		 * @generated
		 */
		EClass CONNECTOR = eINSTANCE.getConnector();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__OWNER = eINSTANCE.getConnector_Owner();

		/**
		 * The meta object literal for the '<em><b>Port1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__PORT1 = eINSTANCE.getConnector_Port1();

		/**
		 * The meta object literal for the '<em><b>Port2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__PORT2 = eINSTANCE.getConnector_Port2();

		/**
		 * The meta object literal for the '<em><b>Prop1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__PROP1 = eINSTANCE.getConnector_Prop1();

		/**
		 * The meta object literal for the '<em><b>Prop2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__PROP2 = eINSTANCE.getConnector_Prop2();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.PortImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OWNER = eINSTANCE.getPort_Owner();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.CreateActionImpl <em>Create Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.CreateActionImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getCreateAction()
		 * @generated
		 */
		EClass CREATE_ACTION = eINSTANCE.getCreateAction();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_ACTION__REF = eINSTANCE.getCreateAction_Ref();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.EventReferenceImpl <em>Event Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.EventReferenceImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getEventReference()
		 * @generated
		 */
		EClass EVENT_REFERENCE = eINSTANCE.getEventReference();

		/**
		 * The meta object literal for the '<em><b>Msg Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_REFERENCE__MSG_REF = eINSTANCE.getEventReference_MsgRef();

		/**
		 * The meta object literal for the '<em><b>Param Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_REFERENCE__PARAM_REF = eINSTANCE.getEventReference_ParamRef();

		/**
		 * The meta object literal for the '{@link edap_relaxed.impl.AspectModelElementImpl <em>Aspect Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edap_relaxed.impl.AspectModelElementImpl
		 * @see edap_relaxed.impl.Edap_relaxedPackageImpl#getAspectModelElement()
		 * @generated
		 */
		EClass ASPECT_MODEL_ELEMENT = eINSTANCE.getAspectModelElement();

		/**
		 * The meta object literal for the '<em><b>Aspect ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASPECT_MODEL_ELEMENT__ASPECT_ID = eINSTANCE.getAspectModelElement_AspectID();

	}

} //Edap_relaxedPackage
