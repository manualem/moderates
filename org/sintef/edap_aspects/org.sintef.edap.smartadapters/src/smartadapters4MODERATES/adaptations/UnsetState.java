/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations;

import edap_relaxed.Action;
import edap_relaxed.Property;
import edap_relaxed.State;
import edap_relaxed.Transition;

import org.eclipse.emf.common.util.EList;

import smartadapters4MODERATES.UnsetAdaptation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unset State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.UnsetState#getStateToUnset <em>State To Unset</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.UnsetState#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.UnsetState#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.UnsetState#getEntry <em>Entry</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.UnsetState#getExit <em>Exit</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.UnsetState#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetState()
 * @model
 * @generated
 */
public interface UnsetState extends UnsetAdaptation {
	/**
	 * Returns the value of the '<em><b>State To Unset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State To Unset</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State To Unset</em>' reference.
	 * @see #setStateToUnset(State)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetState_StateToUnset()
	 * @model required="true"
	 * @generated
	 */
	State getStateToUnset();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.UnsetState#getStateToUnset <em>State To Unset</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State To Unset</em>' reference.
	 * @see #getStateToUnset()
	 * @generated
	 */
	void setStateToUnset(State value);

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetState_Outgoing()
	 * @model
	 * @generated
	 */
	EList<Transition> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetState_Incoming()
	 * @model
	 * @generated
	 */
	EList<Transition> getIncoming();

	/**
	 * Returns the value of the '<em><b>Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' reference.
	 * @see #setEntry(Action)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetState_Entry()
	 * @model
	 * @generated
	 */
	Action getEntry();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.UnsetState#getEntry <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry</em>' reference.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(Action value);

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit</em>' reference.
	 * @see #setExit(Action)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetState_Exit()
	 * @model
	 * @generated
	 */
	Action getExit();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.UnsetState#getExit <em>Exit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit</em>' reference.
	 * @see #getExit()
	 * @generated
	 */
	void setExit(Action value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' reference list.
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetState_Properties()
	 * @model
	 * @generated
	 */
	EList<Property> getProperties();

} // UnsetState
