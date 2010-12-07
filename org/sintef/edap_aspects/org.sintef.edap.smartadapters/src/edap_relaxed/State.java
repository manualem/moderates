/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.State#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link edap_relaxed.State#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link edap_relaxed.State#getEntry <em>Entry</em>}</li>
 *   <li>{@link edap_relaxed.State#getExit <em>Exit</em>}</li>
 *   <li>{@link edap_relaxed.State#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getState()
 * @model
 * @generated
 */
public interface State extends AnnotatedElement {
	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.Transition}.
	 * It is bidirectional and its opposite is '{@link edap_relaxed.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getState_Outgoing()
	 * @see edap_relaxed.Transition#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<Transition> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.Transition}.
	 * It is bidirectional and its opposite is '{@link edap_relaxed.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getState_Incoming()
	 * @see edap_relaxed.Transition#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Transition> getIncoming();

	/**
	 * Returns the value of the '<em><b>Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' containment reference.
	 * @see #setEntry(Action)
	 * @see edap_relaxed.Edap_relaxedPackage#getState_Entry()
	 * @model containment="true"
	 * @generated
	 */
	Action getEntry();

	/**
	 * Sets the value of the '{@link edap_relaxed.State#getEntry <em>Entry</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry</em>' containment reference.
	 * @see #getEntry()
	 * @generated
	 */
	void setEntry(Action value);

	/**
	 * Returns the value of the '<em><b>Exit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit</em>' containment reference.
	 * @see #setExit(Action)
	 * @see edap_relaxed.Edap_relaxedPackage#getState_Exit()
	 * @model containment="true"
	 * @generated
	 */
	Action getExit();

	/**
	 * Sets the value of the '{@link edap_relaxed.State#getExit <em>Exit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit</em>' containment reference.
	 * @see #getExit()
	 * @generated
	 */
	void setExit(Action value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getState_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

} // State
