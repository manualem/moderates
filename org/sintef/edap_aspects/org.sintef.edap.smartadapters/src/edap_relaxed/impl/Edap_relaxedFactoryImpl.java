/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed.impl;

import edap_relaxed.*;

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
public class Edap_relaxedFactoryImpl extends EFactoryImpl implements Edap_relaxedFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Edap_relaxedFactory init() {
		try {
			Edap_relaxedFactory theEdap_relaxedFactory = (Edap_relaxedFactory)EPackage.Registry.INSTANCE.getEFactory("http://edap_relaxed"); 
			if (theEdap_relaxedFactory != null) {
				return theEdap_relaxedFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Edap_relaxedFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edap_relaxedFactoryImpl() {
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
			case Edap_relaxedPackage.EDAP_MODEL: return createEdapModel();
			case Edap_relaxedPackage.MESSAGE: return createMessage();
			case Edap_relaxedPackage.PARAMETER: return createParameter();
			case Edap_relaxedPackage.PROPERTY: return createProperty();
			case Edap_relaxedPackage.PLATFORM_ANNOTATION: return createPlatformAnnotation();
			case Edap_relaxedPackage.ENUMERATION: return createEnumeration();
			case Edap_relaxedPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case Edap_relaxedPackage.ENUMERATION_LITERAL: return createEnumerationLiteral();
			case Edap_relaxedPackage.STATE_MACHINE: return createStateMachine();
			case Edap_relaxedPackage.TRANSITION: return createTransition();
			case Edap_relaxedPackage.STATE: return createState();
			case Edap_relaxedPackage.COMPOSITE_STATE: return createCompositeState();
			case Edap_relaxedPackage.ACTION_BLOCK: return createActionBlock();
			case Edap_relaxedPackage.EXTERN_STATEMENT: return createExternStatement();
			case Edap_relaxedPackage.EXTERN_EXPRESSION: return createExternExpression();
			case Edap_relaxedPackage.BROADCAST: return createBroadcast();
			case Edap_relaxedPackage.UNICAST: return createUnicast();
			case Edap_relaxedPackage.PROPERTY_ASSIGNMENT: return createPropertyAssignment();
			case Edap_relaxedPackage.SOFTWARE_COMPONENT: return createSoftwareComponent();
			case Edap_relaxedPackage.DEVICE: return createDevice();
			case Edap_relaxedPackage.RECEIVE_MESSAGE: return createReceiveMessage();
			case Edap_relaxedPackage.SIMULATOR: return createSimulator();
			case Edap_relaxedPackage.DICTIONARY: return createDictionary();
			case Edap_relaxedPackage.COMPONENT_REFERENCE: return createComponentReference();
			case Edap_relaxedPackage.PROPERTY_NAVIGATION: return createPropertyNavigation();
			case Edap_relaxedPackage.DICTIONARY_NAVIGATION: return createDictionaryNavigation();
			case Edap_relaxedPackage.CONNECTOR: return createConnector();
			case Edap_relaxedPackage.PORT: return createPort();
			case Edap_relaxedPackage.CREATE_ACTION: return createCreateAction();
			case Edap_relaxedPackage.EVENT_REFERENCE: return createEventReference();
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
	public Edap_relaxedPackage getEdap_relaxedPackage() {
		return (Edap_relaxedPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Edap_relaxedPackage getPackage() {
		return Edap_relaxedPackage.eINSTANCE;
	}

} //Edap_relaxedFactoryImpl
