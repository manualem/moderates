/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed.util;

import edap_relaxed.*;

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
 * @see edap_relaxed.Edap_relaxedPackage
 * @generated
 */
public class Edap_relaxedSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Edap_relaxedPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edap_relaxedSwitch() {
		if (modelPackage == null) {
			modelPackage = Edap_relaxedPackage.eINSTANCE;
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
			case Edap_relaxedPackage.EDAP_MODEL: {
				EdapModel edapModel = (EdapModel)theEObject;
				T result = caseEdapModel(edapModel);
				if (result == null) result = caseAspectModelElement(edapModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.MESSAGE: {
				Message message = (Message)theEObject;
				T result = caseMessage(message);
				if (result == null) result = caseAnnotatedElement(message);
				if (result == null) result = caseEdapElement(message);
				if (result == null) result = caseAspectModelElement(message);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseType(component);
				if (result == null) result = caseAnnotatedElement(component);
				if (result == null) result = caseEdapElement(component);
				if (result == null) result = caseAspectModelElement(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseEdapElement(parameter);
				if (result == null) result = caseAspectModelElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.EDAP_ELEMENT: {
				EdapElement edapElement = (EdapElement)theEObject;
				T result = caseEdapElement(edapElement);
				if (result == null) result = caseAspectModelElement(edapElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseAnnotatedElement(type);
				if (result == null) result = caseEdapElement(type);
				if (result == null) result = caseAspectModelElement(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseAnnotatedElement(property);
				if (result == null) result = caseEdapElement(property);
				if (result == null) result = caseAspectModelElement(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.PLATFORM_ANNOTATION: {
				PlatformAnnotation platformAnnotation = (PlatformAnnotation)theEObject;
				T result = casePlatformAnnotation(platformAnnotation);
				if (result == null) result = caseEdapElement(platformAnnotation);
				if (result == null) result = caseAspectModelElement(platformAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.ENUMERATION: {
				Enumeration enumeration = (Enumeration)theEObject;
				T result = caseEnumeration(enumeration);
				if (result == null) result = caseType(enumeration);
				if (result == null) result = caseAnnotatedElement(enumeration);
				if (result == null) result = caseEdapElement(enumeration);
				if (result == null) result = caseAspectModelElement(enumeration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseType(primitiveType);
				if (result == null) result = caseAnnotatedElement(primitiveType);
				if (result == null) result = caseEdapElement(primitiveType);
				if (result == null) result = caseAspectModelElement(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.ENUMERATION_LITERAL: {
				EnumerationLiteral enumerationLiteral = (EnumerationLiteral)theEObject;
				T result = caseEnumerationLiteral(enumerationLiteral);
				if (result == null) result = caseAnnotatedElement(enumerationLiteral);
				if (result == null) result = caseEdapElement(enumerationLiteral);
				if (result == null) result = caseAspectModelElement(enumerationLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.ANNOTATED_ELEMENT: {
				AnnotatedElement annotatedElement = (AnnotatedElement)theEObject;
				T result = caseAnnotatedElement(annotatedElement);
				if (result == null) result = caseEdapElement(annotatedElement);
				if (result == null) result = caseAspectModelElement(annotatedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.STATE_MACHINE: {
				StateMachine stateMachine = (StateMachine)theEObject;
				T result = caseStateMachine(stateMachine);
				if (result == null) result = caseCompositeState(stateMachine);
				if (result == null) result = caseState(stateMachine);
				if (result == null) result = caseAnnotatedElement(stateMachine);
				if (result == null) result = caseEdapElement(stateMachine);
				if (result == null) result = caseAspectModelElement(stateMachine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.TRANSITION: {
				Transition transition = (Transition)theEObject;
				T result = caseTransition(transition);
				if (result == null) result = caseAnnotatedElement(transition);
				if (result == null) result = caseEdapElement(transition);
				if (result == null) result = caseAspectModelElement(transition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.STATE: {
				State state = (State)theEObject;
				T result = caseState(state);
				if (result == null) result = caseAnnotatedElement(state);
				if (result == null) result = caseEdapElement(state);
				if (result == null) result = caseAspectModelElement(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.COMPOSITE_STATE: {
				CompositeState compositeState = (CompositeState)theEObject;
				T result = caseCompositeState(compositeState);
				if (result == null) result = caseState(compositeState);
				if (result == null) result = caseAnnotatedElement(compositeState);
				if (result == null) result = caseEdapElement(compositeState);
				if (result == null) result = caseAspectModelElement(compositeState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseAnnotatedElement(action);
				if (result == null) result = caseEdapElement(action);
				if (result == null) result = caseAspectModelElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.ACTION_BLOCK: {
				ActionBlock actionBlock = (ActionBlock)theEObject;
				T result = caseActionBlock(actionBlock);
				if (result == null) result = caseAction(actionBlock);
				if (result == null) result = caseAnnotatedElement(actionBlock);
				if (result == null) result = caseEdapElement(actionBlock);
				if (result == null) result = caseAspectModelElement(actionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.EXTERN_STATEMENT: {
				ExternStatement externStatement = (ExternStatement)theEObject;
				T result = caseExternStatement(externStatement);
				if (result == null) result = caseAction(externStatement);
				if (result == null) result = caseAnnotatedElement(externStatement);
				if (result == null) result = caseEdapElement(externStatement);
				if (result == null) result = caseAspectModelElement(externStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseAspectModelElement(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.EXTERN_EXPRESSION: {
				ExternExpression externExpression = (ExternExpression)theEObject;
				T result = caseExternExpression(externExpression);
				if (result == null) result = caseExpression(externExpression);
				if (result == null) result = caseAspectModelElement(externExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.SEND_ACTION: {
				SendAction sendAction = (SendAction)theEObject;
				T result = caseSendAction(sendAction);
				if (result == null) result = caseAction(sendAction);
				if (result == null) result = caseAnnotatedElement(sendAction);
				if (result == null) result = caseEdapElement(sendAction);
				if (result == null) result = caseAspectModelElement(sendAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.BROADCAST: {
				Broadcast broadcast = (Broadcast)theEObject;
				T result = caseBroadcast(broadcast);
				if (result == null) result = caseSendAction(broadcast);
				if (result == null) result = caseAction(broadcast);
				if (result == null) result = caseAnnotatedElement(broadcast);
				if (result == null) result = caseEdapElement(broadcast);
				if (result == null) result = caseAspectModelElement(broadcast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.UNICAST: {
				Unicast unicast = (Unicast)theEObject;
				T result = caseUnicast(unicast);
				if (result == null) result = caseSendAction(unicast);
				if (result == null) result = caseAction(unicast);
				if (result == null) result = caseAnnotatedElement(unicast);
				if (result == null) result = caseEdapElement(unicast);
				if (result == null) result = caseAspectModelElement(unicast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.PROPERTY_ASSIGNMENT: {
				PropertyAssignment propertyAssignment = (PropertyAssignment)theEObject;
				T result = casePropertyAssignment(propertyAssignment);
				if (result == null) result = caseAction(propertyAssignment);
				if (result == null) result = caseAnnotatedElement(propertyAssignment);
				if (result == null) result = caseEdapElement(propertyAssignment);
				if (result == null) result = caseAspectModelElement(propertyAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.SOFTWARE_COMPONENT: {
				SoftwareComponent softwareComponent = (SoftwareComponent)theEObject;
				T result = caseSoftwareComponent(softwareComponent);
				if (result == null) result = caseComponent(softwareComponent);
				if (result == null) result = caseType(softwareComponent);
				if (result == null) result = caseAnnotatedElement(softwareComponent);
				if (result == null) result = caseEdapElement(softwareComponent);
				if (result == null) result = caseAspectModelElement(softwareComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.DEVICE: {
				Device device = (Device)theEObject;
				T result = caseDevice(device);
				if (result == null) result = caseComponent(device);
				if (result == null) result = caseType(device);
				if (result == null) result = caseAnnotatedElement(device);
				if (result == null) result = caseEdapElement(device);
				if (result == null) result = caseAspectModelElement(device);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = caseAspectModelElement(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.RECEIVE_MESSAGE: {
				ReceiveMessage receiveMessage = (ReceiveMessage)theEObject;
				T result = caseReceiveMessage(receiveMessage);
				if (result == null) result = caseEvent(receiveMessage);
				if (result == null) result = caseAspectModelElement(receiveMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.SIMULATOR: {
				Simulator simulator = (Simulator)theEObject;
				T result = caseSimulator(simulator);
				if (result == null) result = caseSoftwareComponent(simulator);
				if (result == null) result = caseComponent(simulator);
				if (result == null) result = caseType(simulator);
				if (result == null) result = caseAnnotatedElement(simulator);
				if (result == null) result = caseEdapElement(simulator);
				if (result == null) result = caseAspectModelElement(simulator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.DICTIONARY: {
				Dictionary dictionary = (Dictionary)theEObject;
				T result = caseDictionary(dictionary);
				if (result == null) result = caseProperty(dictionary);
				if (result == null) result = caseAnnotatedElement(dictionary);
				if (result == null) result = caseEdapElement(dictionary);
				if (result == null) result = caseAspectModelElement(dictionary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.COMPONENT_REFERENCE: {
				ComponentReference componentReference = (ComponentReference)theEObject;
				T result = caseComponentReference(componentReference);
				if (result == null) result = caseExpression(componentReference);
				if (result == null) result = caseAspectModelElement(componentReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.PROPERTY_NAVIGATION: {
				PropertyNavigation propertyNavigation = (PropertyNavigation)theEObject;
				T result = casePropertyNavigation(propertyNavigation);
				if (result == null) result = caseAspectModelElement(propertyNavigation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.DICTIONARY_NAVIGATION: {
				DictionaryNavigation dictionaryNavigation = (DictionaryNavigation)theEObject;
				T result = caseDictionaryNavigation(dictionaryNavigation);
				if (result == null) result = casePropertyNavigation(dictionaryNavigation);
				if (result == null) result = caseAspectModelElement(dictionaryNavigation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.CONNECTOR: {
				Connector connector = (Connector)theEObject;
				T result = caseConnector(connector);
				if (result == null) result = caseAnnotatedElement(connector);
				if (result == null) result = caseEdapElement(connector);
				if (result == null) result = caseAspectModelElement(connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseAnnotatedElement(port);
				if (result == null) result = caseEdapElement(port);
				if (result == null) result = caseAspectModelElement(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.CREATE_ACTION: {
				CreateAction createAction = (CreateAction)theEObject;
				T result = caseCreateAction(createAction);
				if (result == null) result = caseAction(createAction);
				if (result == null) result = caseAnnotatedElement(createAction);
				if (result == null) result = caseEdapElement(createAction);
				if (result == null) result = caseAspectModelElement(createAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.EVENT_REFERENCE: {
				EventReference eventReference = (EventReference)theEObject;
				T result = caseEventReference(eventReference);
				if (result == null) result = caseExpression(eventReference);
				if (result == null) result = caseAspectModelElement(eventReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Edap_relaxedPackage.ASPECT_MODEL_ELEMENT: {
				AspectModelElement aspectModelElement = (AspectModelElement)theEObject;
				T result = caseAspectModelElement(aspectModelElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edap Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edap Model</em>'.
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
	 * Returns the result of interpreting the object as an instance of '<em>Edap Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edap Element</em>'.
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
	 * Returns the result of interpreting the object as an instance of '<em>Aspect Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aspect Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAspectModelElement(AspectModelElement object) {
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

} //Edap_relaxedSwitch
