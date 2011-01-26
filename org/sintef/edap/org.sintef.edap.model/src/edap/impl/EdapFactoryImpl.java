/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap.impl;

import edap.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EdapFactoryImpl extends EFactoryImpl implements EdapFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EdapFactory init() {
		try {
			EdapFactory theEdapFactory = (EdapFactory)EPackage.Registry.INSTANCE.getEFactory("http://edap"); 
			if (theEdapFactory != null) {
				return theEdapFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EdapFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdapFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EdapPackage.EDAP_MODEL: return createEdapModel();
			case EdapPackage.MESSAGE: return createMessage();
			case EdapPackage.PARAMETER: return createParameter();
			case EdapPackage.PROPERTY: return createProperty();
			case EdapPackage.PLATFORM_ANNOTATION: return createPlatformAnnotation();
			case EdapPackage.ENUMERATION: return createEnumeration();
			case EdapPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case EdapPackage.ENUMERATION_LITERAL: return createEnumerationLiteral();
			case EdapPackage.STATE_MACHINE: return createStateMachine();
			case EdapPackage.TRANSITION: return createTransition();
			case EdapPackage.STATE: return createState();
			case EdapPackage.COMPOSITE_STATE: return createCompositeState();
			case EdapPackage.ACTION_BLOCK: return createActionBlock();
			case EdapPackage.EXTERN_STATEMENT: return createExternStatement();
			case EdapPackage.EXTERN_EXPRESSION: return createExternExpression();
			case EdapPackage.BROADCAST: return createBroadcast();
			case EdapPackage.UNICAST: return createUnicast();
			case EdapPackage.PROPERTY_ASSIGNMENT: return createPropertyAssignment();
			case EdapPackage.SOFTWARE_COMPONENT: return createSoftwareComponent();
			case EdapPackage.DEVICE: return createDevice();
			case EdapPackage.RECEIVE_MESSAGE: return createReceiveMessage();
			case EdapPackage.SIMULATOR: return createSimulator();
			case EdapPackage.DICTIONARY: return createDictionary();
			case EdapPackage.COMPONENT_REFERENCE: return createComponentReference();
			case EdapPackage.PROPERTY_NAVIGATION: return createPropertyNavigation();
			case EdapPackage.DICTIONARY_NAVIGATION: return createDictionaryNavigation();
			case EdapPackage.CONNECTOR: return createConnector();
			case EdapPackage.PORT: return createPort();
			case EdapPackage.CREATE_ACTION: return createCreateAction();
			case EdapPackage.EVENT_REFERENCE: return createEventReference();
			case EdapPackage.INTEGER_LITTERAL: return createIntegerLitteral();
			case EdapPackage.BOOLEAN_LITTERAL: return createBooleanLitteral();
			case EdapPackage.STRING_LITTERAL: return createStringLitteral();
			case EdapPackage.DOUBLE_LITTERAL: return createDoubleLitteral();
			case EdapPackage.NOT_EXPRESSION: return createNotExpression();
			case EdapPackage.UNARY_MINUS: return createUnaryMinus();
			case EdapPackage.PLUS_EXPRESSION: return createPlusExpression();
			case EdapPackage.MINUS_EXPRESSION: return createMinusExpression();
			case EdapPackage.TIMES_EXPRESSION: return createTimesExpression();
			case EdapPackage.DIV_EXPRESSION: return createDivExpression();
			case EdapPackage.MOD_EXPRESSION: return createModExpression();
			case EdapPackage.EQUALS_EXPRESSION: return createEqualsExpression();
			case EdapPackage.GREATER_EXPRESSION: return createGreaterExpression();
			case EdapPackage.LOWER_EXPRESSION: return createLowerExpression();
			case EdapPackage.AND_EXPRESSION: return createAndExpression();
			case EdapPackage.OR_EXPRESSION: return createOrExpression();
			case EdapPackage.LOOP_ACTION: return createLoopAction();
			case EdapPackage.CONDITIONAL_ACTION: return createConditionalAction();
			case EdapPackage.PROPERTY_REFERENCE: return createPropertyReference();
			case EdapPackage.EXPRESSION_GROUP: return createExpressionGroup();
			case EdapPackage.PRINT_ACTION: return createPrintAction();
			case EdapPackage.ERROR_ACTION: return createErrorAction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdapModel createEdapModel() {
		EdapModelImpl edapModel = new EdapModelImpl();
		return edapModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message createMessage() {
		MessageImpl message = new MessageImpl();
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlatformAnnotation createPlatformAnnotation() {
		PlatformAnnotationImpl platformAnnotation = new PlatformAnnotationImpl();
		return platformAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine createStateMachine() {
		StateMachineImpl stateMachine = new StateMachineImpl();
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeState createCompositeState() {
		CompositeStateImpl compositeState = new CompositeStateImpl();
		return compositeState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionBlock createActionBlock() {
		ActionBlockImpl actionBlock = new ActionBlockImpl();
		return actionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternStatement createExternStatement() {
		ExternStatementImpl externStatement = new ExternStatementImpl();
		return externStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternExpression createExternExpression() {
		ExternExpressionImpl externExpression = new ExternExpressionImpl();
		return externExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Broadcast createBroadcast() {
		BroadcastImpl broadcast = new BroadcastImpl();
		return broadcast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unicast createUnicast() {
		UnicastImpl unicast = new UnicastImpl();
		return unicast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAssignment createPropertyAssignment() {
		PropertyAssignmentImpl propertyAssignment = new PropertyAssignmentImpl();
		return propertyAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareComponent createSoftwareComponent() {
		SoftwareComponentImpl softwareComponent = new SoftwareComponentImpl();
		return softwareComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Device createDevice() {
		DeviceImpl device = new DeviceImpl();
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReceiveMessage createReceiveMessage() {
		ReceiveMessageImpl receiveMessage = new ReceiveMessageImpl();
		return receiveMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Simulator createSimulator() {
		SimulatorImpl simulator = new SimulatorImpl();
		return simulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dictionary createDictionary() {
		DictionaryImpl dictionary = new DictionaryImpl();
		return dictionary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentReference createComponentReference() {
		ComponentReferenceImpl componentReference = new ComponentReferenceImpl();
		return componentReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyNavigation createPropertyNavigation() {
		PropertyNavigationImpl propertyNavigation = new PropertyNavigationImpl();
		return propertyNavigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictionaryNavigation createDictionaryNavigation() {
		DictionaryNavigationImpl dictionaryNavigation = new DictionaryNavigationImpl();
		return dictionaryNavigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector createConnector() {
		ConnectorImpl connector = new ConnectorImpl();
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateAction createCreateAction() {
		CreateActionImpl createAction = new CreateActionImpl();
		return createAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventReference createEventReference() {
		EventReferenceImpl eventReference = new EventReferenceImpl();
		return eventReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLitteral createIntegerLitteral() {
		IntegerLitteralImpl integerLitteral = new IntegerLitteralImpl();
		return integerLitteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLitteral createBooleanLitteral() {
		BooleanLitteralImpl booleanLitteral = new BooleanLitteralImpl();
		return booleanLitteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLitteral createStringLitteral() {
		StringLitteralImpl stringLitteral = new StringLitteralImpl();
		return stringLitteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleLitteral createDoubleLitteral() {
		DoubleLitteralImpl doubleLitteral = new DoubleLitteralImpl();
		return doubleLitteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotExpression createNotExpression() {
		NotExpressionImpl notExpression = new NotExpressionImpl();
		return notExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryMinus createUnaryMinus() {
		UnaryMinusImpl unaryMinus = new UnaryMinusImpl();
		return unaryMinus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlusExpression createPlusExpression() {
		PlusExpressionImpl plusExpression = new PlusExpressionImpl();
		return plusExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinusExpression createMinusExpression() {
		MinusExpressionImpl minusExpression = new MinusExpressionImpl();
		return minusExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimesExpression createTimesExpression() {
		TimesExpressionImpl timesExpression = new TimesExpressionImpl();
		return timesExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DivExpression createDivExpression() {
		DivExpressionImpl divExpression = new DivExpressionImpl();
		return divExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModExpression createModExpression() {
		ModExpressionImpl modExpression = new ModExpressionImpl();
		return modExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualsExpression createEqualsExpression() {
		EqualsExpressionImpl equalsExpression = new EqualsExpressionImpl();
		return equalsExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GreaterExpression createGreaterExpression() {
		GreaterExpressionImpl greaterExpression = new GreaterExpressionImpl();
		return greaterExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LowerExpression createLowerExpression() {
		LowerExpressionImpl lowerExpression = new LowerExpressionImpl();
		return lowerExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndExpression createAndExpression() {
		AndExpressionImpl andExpression = new AndExpressionImpl();
		return andExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrExpression createOrExpression() {
		OrExpressionImpl orExpression = new OrExpressionImpl();
		return orExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopAction createLoopAction() {
		LoopActionImpl loopAction = new LoopActionImpl();
		return loopAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalAction createConditionalAction() {
		ConditionalActionImpl conditionalAction = new ConditionalActionImpl();
		return conditionalAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyReference createPropertyReference() {
		PropertyReferenceImpl propertyReference = new PropertyReferenceImpl();
		return propertyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionGroup createExpressionGroup() {
		ExpressionGroupImpl expressionGroup = new ExpressionGroupImpl();
		return expressionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrintAction createPrintAction() {
		PrintActionImpl printAction = new PrintActionImpl();
		return printAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorAction createErrorAction() {
		ErrorActionImpl errorAction = new ErrorActionImpl();
		return errorAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdapPackage getEdapPackage() {
		return (EdapPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EdapPackage getPackage() {
		return EdapPackage.eINSTANCE;
	}

} //EdapFactoryImpl
