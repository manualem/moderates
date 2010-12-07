/**
 * Copyright (c) 2010 SINTEF
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      SINTEF - initial API and implementation
 */
package edapuC;

import edap.Message;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UC Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edapuC.UCMessage#getMessage <em>Message</em>}</li>
 *   <li>{@link edapuC.UCMessage#getSend <em>Send</em>}</li>
 * </ul>
 * </p>
 *
 * @see edapuC.EdapuCPackage#getUCMessage()
 * @model
 * @generated
 */
public interface UCMessage extends UCElement {
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
	 * @see edapuC.EdapuCPackage#getUCMessage_Message()
	 * @model required="true"
	 * @generated
	 */
	Message getMessage();

	/**
	 * Sets the value of the '{@link edapuC.UCMessage#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(Message value);

	/**
	 * Returns the value of the '<em><b>Send</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Send</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Send</em>' containment reference.
	 * @see #setSend(Template)
	 * @see edapuC.EdapuCPackage#getUCMessage_Send()
	 * @model containment="true"
	 * @generated
	 */
	Template getSend();

	/**
	 * Sets the value of the '{@link edapuC.UCMessage#getSend <em>Send</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Send</em>' containment reference.
	 * @see #getSend()
	 * @generated
	 */
	void setSend(Template value);

} // UCMessage
