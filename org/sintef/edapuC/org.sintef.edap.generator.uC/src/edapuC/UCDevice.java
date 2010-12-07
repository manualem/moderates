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

import edap.Component;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UC Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edapuC.UCDevice#getMessages <em>Messages</em>}</li>
 *   <li>{@link edapuC.UCDevice#getDevice <em>Device</em>}</li>
 *   <li>{@link edapuC.UCDevice#getInit <em>Init</em>}</li>
 *   <li>{@link edapuC.UCDevice#getPoll <em>Poll</em>}</li>
 *   <li>{@link edapuC.UCDevice#getGlobal <em>Global</em>}</li>
 * </ul>
 * </p>
 *
 * @see edapuC.EdapuCPackage#getUCDevice()
 * @model
 * @generated
 */
public interface UCDevice extends UCElement {
	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link edapuC.UCMessage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see edapuC.EdapuCPackage#getUCDevice_Messages()
	 * @model containment="true"
	 * @generated
	 */
	EList<UCMessage> getMessages();

	/**
	 * Returns the value of the '<em><b>Device</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Device</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Device</em>' reference.
	 * @see #setDevice(Component)
	 * @see edapuC.EdapuCPackage#getUCDevice_Device()
	 * @model required="true"
	 * @generated
	 */
	Component getDevice();

	/**
	 * Sets the value of the '{@link edapuC.UCDevice#getDevice <em>Device</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Device</em>' reference.
	 * @see #getDevice()
	 * @generated
	 */
	void setDevice(Component value);

	/**
	 * Returns the value of the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init</em>' containment reference.
	 * @see #setInit(Template)
	 * @see edapuC.EdapuCPackage#getUCDevice_Init()
	 * @model containment="true"
	 * @generated
	 */
	Template getInit();

	/**
	 * Sets the value of the '{@link edapuC.UCDevice#getInit <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init</em>' containment reference.
	 * @see #getInit()
	 * @generated
	 */
	void setInit(Template value);

	/**
	 * Returns the value of the '<em><b>Poll</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Poll</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Poll</em>' containment reference.
	 * @see #setPoll(Template)
	 * @see edapuC.EdapuCPackage#getUCDevice_Poll()
	 * @model containment="true"
	 * @generated
	 */
	Template getPoll();

	/**
	 * Sets the value of the '{@link edapuC.UCDevice#getPoll <em>Poll</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Poll</em>' containment reference.
	 * @see #getPoll()
	 * @generated
	 */
	void setPoll(Template value);

	/**
	 * Returns the value of the '<em><b>Global</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global</em>' containment reference.
	 * @see #setGlobal(Template)
	 * @see edapuC.EdapuCPackage#getUCDevice_Global()
	 * @model containment="true"
	 * @generated
	 */
	Template getGlobal();

	/**
	 * Sets the value of the '{@link edapuC.UCDevice#getGlobal <em>Global</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global</em>' containment reference.
	 * @see #getGlobal()
	 * @generated
	 */
	void setGlobal(Template value);

} // UCDevice
