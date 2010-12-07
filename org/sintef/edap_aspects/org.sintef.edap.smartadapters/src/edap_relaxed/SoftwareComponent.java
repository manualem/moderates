/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.SoftwareComponent#getBehaviour <em>Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getSoftwareComponent()
 * @model
 * @generated
 */
public interface SoftwareComponent extends Component {
	/**
	 * Returns the value of the '<em><b>Behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behaviour</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behaviour</em>' containment reference.
	 * @see #setBehaviour(StateMachine)
	 * @see edap_relaxed.Edap_relaxedPackage#getSoftwareComponent_Behaviour()
	 * @model containment="true"
	 * @generated
	 */
	StateMachine getBehaviour();

	/**
	 * Sets the value of the '{@link edap_relaxed.SoftwareComponent#getBehaviour <em>Behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behaviour</em>' containment reference.
	 * @see #getBehaviour()
	 * @generated
	 */
	void setBehaviour(StateMachine value);

} // SoftwareComponent
