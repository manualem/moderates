/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations;

import edap_relaxed.Action;
import edap_relaxed.Event;
import edap_relaxed.Expression;
import edap_relaxed.State;
import edap_relaxed.Transition;

import org.eclipse.emf.common.util.EList;

import smartadapters4MODERATES.SetAdaptation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetTransition#getTransitionToSet <em>Transition To Set</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetTransition#getEvent <em>Event</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetTransition#getGuard <em>Guard</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetTransition#getAction <em>Action</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetTransition#getTarget <em>Target</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetTransition#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetTransition()
 * @model
 * @generated
 */
public interface SetTransition extends SetAdaptation {
	/**
	 * Returns the value of the '<em><b>Transition To Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition To Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition To Set</em>' reference.
	 * @see #setTransitionToSet(Transition)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetTransition_TransitionToSet()
	 * @model required="true"
	 * @generated
	 */
	Transition getTransitionToSet();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.SetTransition#getTransitionToSet <em>Transition To Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition To Set</em>' reference.
	 * @see #getTransitionToSet()
	 * @generated
	 */
	void setTransitionToSet(Transition value);

	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference list.
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetTransition_Event()
	 * @model
	 * @generated
	 */
	EList<Event> getEvent();

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' reference.
	 * @see #setGuard(Expression)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetTransition_Guard()
	 * @model
	 * @generated
	 */
	Expression getGuard();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.SetTransition#getGuard <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Expression value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetTransition_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.SetTransition#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(State)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetTransition_Target()
	 * @model
	 * @generated
	 */
	State getTarget();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.SetTransition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(State value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(State)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetTransition_Source()
	 * @model
	 * @generated
	 */
	State getSource();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.SetTransition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(State value);

} // SetTransition
