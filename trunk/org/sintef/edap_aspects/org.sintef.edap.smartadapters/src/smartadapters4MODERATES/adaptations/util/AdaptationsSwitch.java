/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import smartadapters4MODERATES.Adaptation;
import smartadapters4MODERATES.SetAdaptation;
import smartadapters4MODERATES.UnsetAdaptation;

import smartadapters4MODERATES.adaptations.*;

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
 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage
 * @generated
 */
public class AdaptationsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AdaptationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdaptationsSwitch() {
		if (modelPackage == null) {
			modelPackage = AdaptationsPackage.eINSTANCE;
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
			case AdaptationsPackage.SET_COMPOSITE_STATE: {
				SetCompositeState setCompositeState = (SetCompositeState)theEObject;
				T result = caseSetCompositeState(setCompositeState);
				if (result == null) result = caseSetAdaptation(setCompositeState);
				if (result == null) result = caseAdaptation(setCompositeState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AdaptationsPackage.UNSET_COMPOSITE_STATE: {
				UnsetCompositeState unsetCompositeState = (UnsetCompositeState)theEObject;
				T result = caseUnsetCompositeState(unsetCompositeState);
				if (result == null) result = caseUnsetAdaptation(unsetCompositeState);
				if (result == null) result = caseAdaptation(unsetCompositeState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AdaptationsPackage.SET_STATE: {
				SetState setState = (SetState)theEObject;
				T result = caseSetState(setState);
				if (result == null) result = caseSetAdaptation(setState);
				if (result == null) result = caseAdaptation(setState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AdaptationsPackage.UNSET_STATE: {
				UnsetState unsetState = (UnsetState)theEObject;
				T result = caseUnsetState(unsetState);
				if (result == null) result = caseUnsetAdaptation(unsetState);
				if (result == null) result = caseAdaptation(unsetState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AdaptationsPackage.SET_TRANSITION: {
				SetTransition setTransition = (SetTransition)theEObject;
				T result = caseSetTransition(setTransition);
				if (result == null) result = caseSetAdaptation(setTransition);
				if (result == null) result = caseAdaptation(setTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AdaptationsPackage.UNSET_TRANSITION: {
				UnsetTransition unsetTransition = (UnsetTransition)theEObject;
				T result = caseUnsetTransition(unsetTransition);
				if (result == null) result = caseUnsetAdaptation(unsetTransition);
				if (result == null) result = caseAdaptation(unsetTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT: {
				SetAnnotatedElement setAnnotatedElement = (SetAnnotatedElement)theEObject;
				T result = caseSetAnnotatedElement(setAnnotatedElement);
				if (result == null) result = caseSetAdaptation(setAnnotatedElement);
				if (result == null) result = caseAdaptation(setAnnotatedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AdaptationsPackage.SET_ACTION_BLOCK: {
				SetActionBlock setActionBlock = (SetActionBlock)theEObject;
				T result = caseSetActionBlock(setActionBlock);
				if (result == null) result = caseSetAdaptation(setActionBlock);
				if (result == null) result = caseAdaptation(setActionBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Composite State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Composite State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetCompositeState(SetCompositeState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unset Composite State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unset Composite State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnsetCompositeState(UnsetCompositeState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetState(SetState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unset State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unset State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnsetState(UnsetState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetTransition(SetTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unset Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unset Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnsetTransition(UnsetTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Annotated Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Annotated Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetAnnotatedElement(SetAnnotatedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Action Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Action Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetActionBlock(SetActionBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adaptation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adaptation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdaptation(Adaptation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Adaptation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Adaptation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetAdaptation(SetAdaptation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unset Adaptation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unset Adaptation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnsetAdaptation(UnsetAdaptation object) {
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

} //AdaptationsSwitch
