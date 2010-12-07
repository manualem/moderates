/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations;

import edap_relaxed.CompositeState;
import edap_relaxed.State;

import org.eclipse.emf.common.util.EList;

import smartadapters4MODERATES.UnsetAdaptation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unset Composite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.UnsetCompositeState#getCompositeStateToUnset <em>Composite State To Unset</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.UnsetCompositeState#getSubstate <em>Substate</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.UnsetCompositeState#getInitial <em>Initial</em>}</li>
 * </ul>
 * </p>
 *
 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetCompositeState()
 * @model
 * @generated
 */
public interface UnsetCompositeState extends UnsetAdaptation {
	/**
	 * Returns the value of the '<em><b>Composite State To Unset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite State To Unset</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite State To Unset</em>' reference.
	 * @see #setCompositeStateToUnset(CompositeState)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetCompositeState_CompositeStateToUnset()
	 * @model required="true"
	 * @generated
	 */
	CompositeState getCompositeStateToUnset();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.UnsetCompositeState#getCompositeStateToUnset <em>Composite State To Unset</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite State To Unset</em>' reference.
	 * @see #getCompositeStateToUnset()
	 * @generated
	 */
	void setCompositeStateToUnset(CompositeState value);

	/**
	 * Returns the value of the '<em><b>Substate</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Substate</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Substate</em>' reference list.
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetCompositeState_Substate()
	 * @model
	 * @generated
	 */
	EList<State> getSubstate();

	/**
	 * Returns the value of the '<em><b>Initial</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' reference.
	 * @see #setInitial(State)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getUnsetCompositeState_Initial()
	 * @model
	 * @generated
	 */
	State getInitial();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.UnsetCompositeState#getInitial <em>Initial</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' reference.
	 * @see #getInitial()
	 * @generated
	 */
	void setInitial(State value);

} // UnsetCompositeState
