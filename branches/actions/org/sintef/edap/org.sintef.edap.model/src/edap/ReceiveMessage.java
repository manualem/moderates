/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Receive Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.ReceiveMessage#getDevice <em>Device</em>}</li>
 *   <li>{@link edap.ReceiveMessage#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getReceiveMessage()
 * @model
 * @generated
 */
public interface ReceiveMessage extends Event {
	/**
	 * Returns the value of the '<em><b>Device</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device</em>' containment reference.
	 * @see #setDevice(Expression)
	 * @see edap.EdapPackage#getReceiveMessage_Device()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getDevice();

	/**
	 * Sets the value of the '{@link edap.ReceiveMessage#getDevice <em>Device</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device</em>' containment reference.
	 * @see #getDevice()
	 * @generated
	 */
	void setDevice(Expression value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' reference.
	 * @see #setMessage(Message)
	 * @see edap.EdapPackage#getReceiveMessage_Message()
	 * @model required="true"
	 * @generated
	 */
	Message getMessage();

	/**
	 * Sets the value of the '{@link edap.ReceiveMessage#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(Message value);

} // ReceiveMessage
