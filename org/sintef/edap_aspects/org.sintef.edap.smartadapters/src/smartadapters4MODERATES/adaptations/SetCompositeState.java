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

import smartadapters4MODERATES.SetAdaptation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Composite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetCompositeState#getCompositeStateToSet <em>Composite State To Set</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetCompositeState#getSubstate <em>Substate</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetCompositeState#getInitial <em>Initial</em>}</li>
 * </ul>
 * </p>
 *
 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetCompositeState()
 * @model
 * @generated
 */
public interface SetCompositeState extends SetAdaptation {
	/**
	 * Returns the value of the '<em><b>Composite State To Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite State To Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite State To Set</em>' reference.
	 * @see #setCompositeStateToSet(CompositeState)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetCompositeState_CompositeStateToSet()
	 * @model required="true"
	 * @generated
	 */
	CompositeState getCompositeStateToSet();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.SetCompositeState#getCompositeStateToSet <em>Composite State To Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite State To Set</em>' reference.
	 * @see #getCompositeStateToSet()
	 * @generated
	 */
	void setCompositeStateToSet(CompositeState value);

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
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetCompositeState_Substate()
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
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetCompositeState_Initial()
	 * @model
	 * @generated
	 */
	State getInitial();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.SetCompositeState#getInitial <em>Initial</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' reference.
	 * @see #getInitial()
	 * @generated
	 */
	void setInitial(State value);

} // SetCompositeState
