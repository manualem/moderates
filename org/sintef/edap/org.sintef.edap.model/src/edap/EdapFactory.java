/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edap.EdapPackage
 * @generated
 */
public interface EdapFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EdapFactory eINSTANCE = edap.impl.EdapFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	EdapModel createEdapModel();

	/**
	 * Returns a new object of class '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message</em>'.
	 * @generated
	 */
	Message createMessage();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Platform Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Platform Annotation</em>'.
	 * @generated
	 */
	PlatformAnnotation createPlatformAnnotation();

	/**
	 * Returns a new object of class '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration</em>'.
	 * @generated
	 */
	Enumeration createEnumeration();

	/**
	 * Returns a new object of class '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type</em>'.
	 * @generated
	 */
	PrimitiveType createPrimitiveType();

	/**
	 * Returns a new object of class '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal</em>'.
	 * @generated
	 */
	EnumerationLiteral createEnumerationLiteral();

	/**
	 * Returns a new object of class '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Machine</em>'.
	 * @generated
	 */
	StateMachine createStateMachine();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	/**
	 * Returns a new object of class '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State</em>'.
	 * @generated
	 */
	State createState();

	/**
	 * Returns a new object of class '<em>Composite State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Composite State</em>'.
	 * @generated
	 */
	CompositeState createCompositeState();

	/**
	 * Returns a new object of class '<em>Action Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Block</em>'.
	 * @generated
	 */
	ActionBlock createActionBlock();

	/**
	 * Returns a new object of class '<em>Extern Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extern Statement</em>'.
	 * @generated
	 */
	ExternStatement createExternStatement();

	/**
	 * Returns a new object of class '<em>Extern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extern Expression</em>'.
	 * @generated
	 */
	ExternExpression createExternExpression();

	/**
	 * Returns a new object of class '<em>Broadcast</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Broadcast</em>'.
	 * @generated
	 */
	Broadcast createBroadcast();

	/**
	 * Returns a new object of class '<em>Unicast</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unicast</em>'.
	 * @generated
	 */
	Unicast createUnicast();

	/**
	 * Returns a new object of class '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Assignment</em>'.
	 * @generated
	 */
	PropertyAssignment createPropertyAssignment();

	/**
	 * Returns a new object of class '<em>Software Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Software Component</em>'.
	 * @generated
	 */
	SoftwareComponent createSoftwareComponent();

	/**
	 * Returns a new object of class '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device</em>'.
	 * @generated
	 */
	Device createDevice();

	/**
	 * Returns a new object of class '<em>Receive Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Receive Message</em>'.
	 * @generated
	 */
	ReceiveMessage createReceiveMessage();

	/**
	 * Returns a new object of class '<em>Simulator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulator</em>'.
	 * @generated
	 */
	Simulator createSimulator();

	/**
	 * Returns a new object of class '<em>Dictionary</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dictionary</em>'.
	 * @generated
	 */
	Dictionary createDictionary();

	/**
	 * Returns a new object of class '<em>Component Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Reference</em>'.
	 * @generated
	 */
	ComponentReference createComponentReference();

	/**
	 * Returns a new object of class '<em>Property Navigation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Navigation</em>'.
	 * @generated
	 */
	PropertyNavigation createPropertyNavigation();

	/**
	 * Returns a new object of class '<em>Dictionary Navigation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dictionary Navigation</em>'.
	 * @generated
	 */
	DictionaryNavigation createDictionaryNavigation();

	/**
	 * Returns a new object of class '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector</em>'.
	 * @generated
	 */
	Connector createConnector();

	/**
	 * Returns a new object of class '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port</em>'.
	 * @generated
	 */
	Port createPort();

	/**
	 * Returns a new object of class '<em>Create Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create Action</em>'.
	 * @generated
	 */
	CreateAction createCreateAction();

	/**
	 * Returns a new object of class '<em>Event Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Reference</em>'.
	 * @generated
	 */
	EventReference createEventReference();

	/**
	 * Returns a new object of class '<em>Integer Litteral</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Litteral</em>'.
	 * @generated
	 */
	IntegerLitteral createIntegerLitteral();

	/**
	 * Returns a new object of class '<em>Boolean Litteral</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Litteral</em>'.
	 * @generated
	 */
	BooleanLitteral createBooleanLitteral();

	/**
	 * Returns a new object of class '<em>String Litteral</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Litteral</em>'.
	 * @generated
	 */
	StringLitteral createStringLitteral();

	/**
	 * Returns a new object of class '<em>Double Litteral</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Litteral</em>'.
	 * @generated
	 */
	DoubleLitteral createDoubleLitteral();

	/**
	 * Returns a new object of class '<em>Not Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Expression</em>'.
	 * @generated
	 */
	NotExpression createNotExpression();

	/**
	 * Returns a new object of class '<em>Unary Minus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Minus</em>'.
	 * @generated
	 */
	UnaryMinus createUnaryMinus();

	/**
	 * Returns a new object of class '<em>Plus Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plus Expression</em>'.
	 * @generated
	 */
	PlusExpression createPlusExpression();

	/**
	 * Returns a new object of class '<em>Minus Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Minus Expression</em>'.
	 * @generated
	 */
	MinusExpression createMinusExpression();

	/**
	 * Returns a new object of class '<em>Times Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Times Expression</em>'.
	 * @generated
	 */
	TimesExpression createTimesExpression();

	/**
	 * Returns a new object of class '<em>Div Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Div Expression</em>'.
	 * @generated
	 */
	DivExpression createDivExpression();

	/**
	 * Returns a new object of class '<em>Mod Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mod Expression</em>'.
	 * @generated
	 */
	ModExpression createModExpression();

	/**
	 * Returns a new object of class '<em>Equals Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equals Expression</em>'.
	 * @generated
	 */
	EqualsExpression createEqualsExpression();

	/**
	 * Returns a new object of class '<em>Greater Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Greater Expression</em>'.
	 * @generated
	 */
	GreaterExpression createGreaterExpression();

	/**
	 * Returns a new object of class '<em>Lower Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lower Expression</em>'.
	 * @generated
	 */
	LowerExpression createLowerExpression();

	/**
	 * Returns a new object of class '<em>And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Expression</em>'.
	 * @generated
	 */
	AndExpression createAndExpression();

	/**
	 * Returns a new object of class '<em>Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Expression</em>'.
	 * @generated
	 */
	OrExpression createOrExpression();

	/**
	 * Returns a new object of class '<em>Loop Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Action</em>'.
	 * @generated
	 */
	LoopAction createLoopAction();

	/**
	 * Returns a new object of class '<em>Conditional Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Action</em>'.
	 * @generated
	 */
	ConditionalAction createConditionalAction();

	/**
	 * Returns a new object of class '<em>Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Reference</em>'.
	 * @generated
	 */
	PropertyReference createPropertyReference();

	/**
	 * Returns a new object of class '<em>Expression Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Group</em>'.
	 * @generated
	 */
	ExpressionGroup createExpressionGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EdapPackage getEdapPackage();

} //EdapFactory
