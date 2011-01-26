/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap.util;

import edap.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edap.EdapPackage
 * @generated
 */
public class EdapSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EdapPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdapSwitch() {
		if (modelPackage == null) {
			modelPackage = EdapPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EdapPackage.EDAP_MODEL: {
				EdapModel edapModel = (EdapModel)theEObject;
				T result = caseEdapModel(edapModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.MESSAGE: {
				Message message = (Message)theEObject;
				T result = caseMessage(message);
				if (result == null) result = caseAnnotatedElement(message);
				if (result == null) result = caseEdapElement(message);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseType(component);
				if (result == null) result = caseAnnotatedElement(component);
				if (result == null) result = caseEdapElement(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseEdapElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.EDAP_ELEMENT: {
				EdapElement edapElement = (EdapElement)theEObject;
				T result = caseEdapElement(edapElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseAnnotatedElement(type);
				if (result == null) result = caseEdapElement(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseAnnotatedElement(property);
				if (result == null) result = caseEdapElement(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PLATFORM_ANNOTATION: {
				PlatformAnnotation platformAnnotation = (PlatformAnnotation)theEObject;
				T result = casePlatformAnnotation(platformAnnotation);
				if (result == null) result = caseEdapElement(platformAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.ENUMERATION: {
				Enumeration enumeration = (Enumeration)theEObject;
				T result = caseEnumeration(enumeration);
				if (result == null) result = caseType(enumeration);
				if (result == null) result = caseAnnotatedElement(enumeration);
				if (result == null) result = caseEdapElement(enumeration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseType(primitiveType);
				if (result == null) result = caseAnnotatedElement(primitiveType);
				if (result == null) result = caseEdapElement(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.ENUMERATION_LITERAL: {
				EnumerationLiteral enumerationLiteral = (EnumerationLiteral)theEObject;
				T result = caseEnumerationLiteral(enumerationLiteral);
				if (result == null) result = caseAnnotatedElement(enumerationLiteral);
				if (result == null) result = caseEdapElement(enumerationLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.ANNOTATED_ELEMENT: {
				AnnotatedElement annotatedElement = (AnnotatedElement)theEObject;
				T result = caseAnnotatedElement(annotatedElement);
				if (result == null) result = caseEdapElement(annotatedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.STATE_MACHINE: {
				StateMachine stateMachine = (StateMachine)theEObject;
				T result = caseStateMachine(stateMachine);
				if (result == null) result = caseCompositeState(stateMachine);
				if (result == null) result = caseState(stateMachine);
				if (result == null) result = caseAnnotatedElement(stateMachine);
				if (result == null) result = caseEdapElement(stateMachine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.TRANSITION: {
				Transition transition = (Transition)theEObject;
				T result = caseTransition(transition);
				if (result == null) result = caseAnnotatedElement(transition);
				if (result == null) result = caseEdapElement(transition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.STATE: {
				State state = (State)theEObject;
				T result = caseState(state);
				if (result == null) result = caseAnnotatedElement(state);
				if (result == null) result = caseEdapElement(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.COMPOSITE_STATE: {
				CompositeState compositeState = (CompositeState)theEObject;
				T result = caseCompositeState(compositeState);
				if (result == null) result = caseState(compositeState);
				if (result == null) result = caseAnnotatedElement(compositeState);
				if (result == null) result = caseEdapElement(compositeState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseAnnotatedElement(action);
				if (result == null) result = caseEdapElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.ACTION_BLOCK: {
				ActionBlock actionBlock = (ActionBlock)theEObject;
				T result = caseActionBlock(actionBlock);
				if (result == null) result = caseAction(actionBlock);
				if (result == null) result = caseAnnotatedElement(actionBlock);
				if (result == null) result = caseEdapElement(actionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.EXTERN_STATEMENT: {
				ExternStatement externStatement = (ExternStatement)theEObject;
				T result = caseExternStatement(externStatement);
				if (result == null) result = caseAction(externStatement);
				if (result == null) result = caseAnnotatedElement(externStatement);
				if (result == null) result = caseEdapElement(externStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.EXTERN_EXPRESSION: {
				ExternExpression externExpression = (ExternExpression)theEObject;
				T result = caseExternExpression(externExpression);
				if (result == null) result = caseExpression(externExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.SEND_ACTION: {
				SendAction sendAction = (SendAction)theEObject;
				T result = caseSendAction(sendAction);
				if (result == null) result = caseAction(sendAction);
				if (result == null) result = caseAnnotatedElement(sendAction);
				if (result == null) result = caseEdapElement(sendAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.BROADCAST: {
				Broadcast broadcast = (Broadcast)theEObject;
				T result = caseBroadcast(broadcast);
				if (result == null) result = caseSendAction(broadcast);
				if (result == null) result = caseAction(broadcast);
				if (result == null) result = caseAnnotatedElement(broadcast);
				if (result == null) result = caseEdapElement(broadcast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.UNICAST: {
				Unicast unicast = (Unicast)theEObject;
				T result = caseUnicast(unicast);
				if (result == null) result = caseSendAction(unicast);
				if (result == null) result = caseAction(unicast);
				if (result == null) result = caseAnnotatedElement(unicast);
				if (result == null) result = caseEdapElement(unicast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PROPERTY_ASSIGNMENT: {
				PropertyAssignment propertyAssignment = (PropertyAssignment)theEObject;
				T result = casePropertyAssignment(propertyAssignment);
				if (result == null) result = caseAction(propertyAssignment);
				if (result == null) result = caseAnnotatedElement(propertyAssignment);
				if (result == null) result = caseEdapElement(propertyAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.SOFTWARE_COMPONENT: {
				SoftwareComponent softwareComponent = (SoftwareComponent)theEObject;
				T result = caseSoftwareComponent(softwareComponent);
				if (result == null) result = caseComponent(softwareComponent);
				if (result == null) result = caseType(softwareComponent);
				if (result == null) result = caseAnnotatedElement(softwareComponent);
				if (result == null) result = caseEdapElement(softwareComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.DEVICE: {
				Device device = (Device)theEObject;
				T result = caseDevice(device);
				if (result == null) result = caseComponent(device);
				if (result == null) result = caseType(device);
				if (result == null) result = caseAnnotatedElement(device);
				if (result == null) result = caseEdapElement(device);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.RECEIVE_MESSAGE: {
				ReceiveMessage receiveMessage = (ReceiveMessage)theEObject;
				T result = caseReceiveMessage(receiveMessage);
				if (result == null) result = caseEvent(receiveMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.SIMULATOR: {
				Simulator simulator = (Simulator)theEObject;
				T result = caseSimulator(simulator);
				if (result == null) result = caseSoftwareComponent(simulator);
				if (result == null) result = caseComponent(simulator);
				if (result == null) result = caseType(simulator);
				if (result == null) result = caseAnnotatedElement(simulator);
				if (result == null) result = caseEdapElement(simulator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.DICTIONARY: {
				Dictionary dictionary = (Dictionary)theEObject;
				T result = caseDictionary(dictionary);
				if (result == null) result = caseProperty(dictionary);
				if (result == null) result = caseAnnotatedElement(dictionary);
				if (result == null) result = caseEdapElement(dictionary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.COMPONENT_REFERENCE: {
				ComponentReference componentReference = (ComponentReference)theEObject;
				T result = caseComponentReference(componentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PROPERTY_NAVIGATION: {
				PropertyNavigation propertyNavigation = (PropertyNavigation)theEObject;
				T result = casePropertyNavigation(propertyNavigation);
				if (result == null) result = caseExpression(propertyNavigation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.DICTIONARY_NAVIGATION: {
				DictionaryNavigation dictionaryNavigation = (DictionaryNavigation)theEObject;
				T result = caseDictionaryNavigation(dictionaryNavigation);
				if (result == null) result = casePropertyNavigation(dictionaryNavigation);
				if (result == null) result = caseExpression(dictionaryNavigation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.CONNECTOR: {
				Connector connector = (Connector)theEObject;
				T result = caseConnector(connector);
				if (result == null) result = caseAnnotatedElement(connector);
				if (result == null) result = caseEdapElement(connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseAnnotatedElement(port);
				if (result == null) result = caseEdapElement(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.CREATE_ACTION: {
				CreateAction createAction = (CreateAction)theEObject;
				T result = caseCreateAction(createAction);
				if (result == null) result = caseAction(createAction);
				if (result == null) result = caseAnnotatedElement(createAction);
				if (result == null) result = caseEdapElement(createAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.EVENT_REFERENCE: {
				EventReference eventReference = (EventReference)theEObject;
				T result = caseEventReference(eventReference);
				if (result == null) result = caseExpression(eventReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.LITTERAL: {
				Litteral litteral = (Litteral)theEObject;
				T result = caseLitteral(litteral);
				if (result == null) result = caseExpression(litteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.INTEGER_LITTERAL: {
				IntegerLitteral integerLitteral = (IntegerLitteral)theEObject;
				T result = caseIntegerLitteral(integerLitteral);
				if (result == null) result = caseLitteral(integerLitteral);
				if (result == null) result = caseExpression(integerLitteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.BOOLEAN_LITTERAL: {
				BooleanLitteral booleanLitteral = (BooleanLitteral)theEObject;
				T result = caseBooleanLitteral(booleanLitteral);
				if (result == null) result = caseLitteral(booleanLitteral);
				if (result == null) result = caseExpression(booleanLitteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.STRING_LITTERAL: {
				StringLitteral stringLitteral = (StringLitteral)theEObject;
				T result = caseStringLitteral(stringLitteral);
				if (result == null) result = caseLitteral(stringLitteral);
				if (result == null) result = caseExpression(stringLitteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.DOUBLE_LITTERAL: {
				DoubleLitteral doubleLitteral = (DoubleLitteral)theEObject;
				T result = caseDoubleLitteral(doubleLitteral);
				if (result == null) result = caseLitteral(doubleLitteral);
				if (result == null) result = caseExpression(doubleLitteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseExpression(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.NOT_EXPRESSION: {
				NotExpression notExpression = (NotExpression)theEObject;
				T result = caseNotExpression(notExpression);
				if (result == null) result = caseUnaryExpression(notExpression);
				if (result == null) result = caseExpression(notExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.UNARY_MINUS: {
				UnaryMinus unaryMinus = (UnaryMinus)theEObject;
				T result = caseUnaryMinus(unaryMinus);
				if (result == null) result = caseUnaryExpression(unaryMinus);
				if (result == null) result = caseExpression(unaryMinus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.BINARY_EXPRESSION: {
				BinaryExpression binaryExpression = (BinaryExpression)theEObject;
				T result = caseBinaryExpression(binaryExpression);
				if (result == null) result = caseExpression(binaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PLUS_EXPRESSION: {
				PlusExpression plusExpression = (PlusExpression)theEObject;
				T result = casePlusExpression(plusExpression);
				if (result == null) result = caseBinaryExpression(plusExpression);
				if (result == null) result = caseExpression(plusExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.MINUS_EXPRESSION: {
				MinusExpression minusExpression = (MinusExpression)theEObject;
				T result = caseMinusExpression(minusExpression);
				if (result == null) result = caseBinaryExpression(minusExpression);
				if (result == null) result = caseExpression(minusExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.TIMES_EXPRESSION: {
				TimesExpression timesExpression = (TimesExpression)theEObject;
				T result = caseTimesExpression(timesExpression);
				if (result == null) result = caseBinaryExpression(timesExpression);
				if (result == null) result = caseExpression(timesExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.DIV_EXPRESSION: {
				DivExpression divExpression = (DivExpression)theEObject;
				T result = caseDivExpression(divExpression);
				if (result == null) result = caseBinaryExpression(divExpression);
				if (result == null) result = caseExpression(divExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.MOD_EXPRESSION: {
				ModExpression modExpression = (ModExpression)theEObject;
				T result = caseModExpression(modExpression);
				if (result == null) result = caseBinaryExpression(modExpression);
				if (result == null) result = caseExpression(modExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.EQUALS_EXPRESSION: {
				EqualsExpression equalsExpression = (EqualsExpression)theEObject;
				T result = caseEqualsExpression(equalsExpression);
				if (result == null) result = caseBinaryExpression(equalsExpression);
				if (result == null) result = caseExpression(equalsExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.GREATER_EXPRESSION: {
				GreaterExpression greaterExpression = (GreaterExpression)theEObject;
				T result = caseGreaterExpression(greaterExpression);
				if (result == null) result = caseBinaryExpression(greaterExpression);
				if (result == null) result = caseExpression(greaterExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.LOWER_EXPRESSION: {
				LowerExpression lowerExpression = (LowerExpression)theEObject;
				T result = caseLowerExpression(lowerExpression);
				if (result == null) result = caseBinaryExpression(lowerExpression);
				if (result == null) result = caseExpression(lowerExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.AND_EXPRESSION: {
				AndExpression andExpression = (AndExpression)theEObject;
				T result = caseAndExpression(andExpression);
				if (result == null) result = caseBinaryExpression(andExpression);
				if (result == null) result = caseExpression(andExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.OR_EXPRESSION: {
				OrExpression orExpression = (OrExpression)theEObject;
				T result = caseOrExpression(orExpression);
				if (result == null) result = caseBinaryExpression(orExpression);
				if (result == null) result = caseExpression(orExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.CONTROL_STRUCTURE: {
				ControlStructure controlStructure = (ControlStructure)theEObject;
				T result = caseControlStructure(controlStructure);
				if (result == null) result = caseAction(controlStructure);
				if (result == null) result = caseAnnotatedElement(controlStructure);
				if (result == null) result = caseEdapElement(controlStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.LOOP_ACTION: {
				LoopAction loopAction = (LoopAction)theEObject;
				T result = caseLoopAction(loopAction);
				if (result == null) result = caseControlStructure(loopAction);
				if (result == null) result = caseAction(loopAction);
				if (result == null) result = caseAnnotatedElement(loopAction);
				if (result == null) result = caseEdapElement(loopAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.CONDITIONAL_ACTION: {
				ConditionalAction conditionalAction = (ConditionalAction)theEObject;
				T result = caseConditionalAction(conditionalAction);
				if (result == null) result = caseControlStructure(conditionalAction);
				if (result == null) result = caseAction(conditionalAction);
				if (result == null) result = caseAnnotatedElement(conditionalAction);
				if (result == null) result = caseEdapElement(conditionalAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PROPERTY_REFERENCE: {
				PropertyReference propertyReference = (PropertyReference)theEObject;
				T result = casePropertyReference(propertyReference);
				if (result == null) result = caseExpression(propertyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.EXPRESSION_GROUP: {
				ExpressionGroup expressionGroup = (ExpressionGroup)theEObject;
				T result = caseExpressionGroup(expressionGroup);
				if (result == null) result = caseExpression(expressionGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.PRINT_ACTION: {
				PrintAction printAction = (PrintAction)theEObject;
				T result = casePrintAction(printAction);
				if (result == null) result = caseAction(printAction);
				if (result == null) result = caseAnnotatedElement(printAction);
				if (result == null) result = caseEdapElement(printAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdapPackage.ERROR_ACTION: {
				ErrorAction errorAction = (ErrorAction)theEObject;
				T result = caseErrorAction(errorAction);
				if (result == null) result = caseAction(errorAction);
				if (result == null) result = caseAnnotatedElement(errorAction);
				if (result == null) result = caseEdapElement(errorAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdapModel(EdapModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessage(Message object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdapElement(EdapElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Platform Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Platform Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlatformAnnotation(PlatformAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeration(Enumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteral(EnumerationLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotated Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotated Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotatedElement(AnnotatedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Machine</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Machine</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMachine(StateMachine object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransition(Transition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeState(CompositeState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionBlock(ActionBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extern Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extern Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternStatement(ExternStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Extern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extern Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternExpression(ExternExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Send Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Send Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSendAction(SendAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Broadcast</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Broadcast</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBroadcast(Broadcast object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unicast</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unicast</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnicast(Unicast object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyAssignment(PropertyAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Software Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Software Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSoftwareComponent(SoftwareComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDevice(Device object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Receive Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Receive Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReceiveMessage(ReceiveMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simulator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simulator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimulator(Simulator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dictionary</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dictionary</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictionary(Dictionary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentReference(ComponentReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Navigation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Navigation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyNavigation(PropertyNavigation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dictionary Navigation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dictionary Navigation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDictionaryNavigation(DictionaryNavigation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateAction(CreateAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventReference(EventReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Litteral</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Litteral</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLitteral(Litteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Litteral</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Litteral</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLitteral(IntegerLitteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Litteral</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Litteral</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLitteral(BooleanLitteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Litteral</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Litteral</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLitteral(StringLitteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Litteral</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Litteral</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleLitteral(DoubleLitteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotExpression(NotExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Minus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Minus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryMinus(UnaryMinus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryExpression(BinaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plus Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plus Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlusExpression(PlusExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Minus Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Minus Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinusExpression(MinusExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Times Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Times Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimesExpression(TimesExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Div Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Div Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDivExpression(DivExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mod Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mod Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModExpression(ModExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equals Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equals Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualsExpression(EqualsExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Greater Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Greater Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGreaterExpression(GreaterExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lower Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lower Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLowerExpression(LowerExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndExpression(AndExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrExpression(OrExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlStructure(ControlStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopAction(LoopAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalAction(ConditionalAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyReference(PropertyReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionGroup(ExpressionGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Print Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Print Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrintAction(PrintAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseErrorAction(ErrorAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EdapSwitch
