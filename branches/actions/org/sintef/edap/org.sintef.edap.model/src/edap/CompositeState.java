/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.CompositeState#getSubstate <em>Substate</em>}</li>
 *   <li>{@link edap.CompositeState#getInitial <em>Initial</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getCompositeState()
 * @model
 * @generated
 */
public interface CompositeState extends State {
	/**
	 * Returns the value of the '<em><b>Substate</b></em>' containment reference list.
	 * The list contents are of type {@link edap.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Substate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Substate</em>' containment reference list.
	 * @see edap.EdapPackage#getCompositeState_Substate()
	 * @model containment="true"
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
	 * @see edap.EdapPackage#getCompositeState_Initial()
	 * @model required="true"
	 * @generated
	 */
	State getInitial();

	/**
	 * Sets the value of the '{@link edap.CompositeState#getInitial <em>Initial</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' reference.
	 * @see #getInitial()
	 * @generated
	 */
	void setInitial(State value);

} // CompositeState
