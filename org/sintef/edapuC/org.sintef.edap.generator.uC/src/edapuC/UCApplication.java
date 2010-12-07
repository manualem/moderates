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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UC Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edapuC.UCApplication#getState_machine <em>State machine</em>}</li>
 *   <li>{@link edapuC.UCApplication#getHeaders <em>Headers</em>}</li>
 *   <li>{@link edapuC.UCApplication#getInit <em>Init</em>}</li>
 *   <li>{@link edapuC.UCApplication#getPoll <em>Poll</em>}</li>
 *   <li>{@link edapuC.UCApplication#getGlobal <em>Global</em>}</li>
 * </ul>
 * </p>
 *
 * @see edapuC.EdapuCPackage#getUCApplication()
 * @model
 * @generated
 */
public interface UCApplication extends UCElement {
	/**
	 * Returns the value of the '<em><b>State machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State machine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State machine</em>' reference.
	 * @see #setState_machine(Component)
	 * @see edapuC.EdapuCPackage#getUCApplication_State_machine()
	 * @model required="true"
	 * @generated
	 */
	Component getState_machine();

	/**
	 * Sets the value of the '{@link edapuC.UCApplication#getState_machine <em>State machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State machine</em>' reference.
	 * @see #getState_machine()
	 * @generated
	 */
	void setState_machine(Component value);

	/**
	 * Returns the value of the '<em><b>Headers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Headers</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Headers</em>' containment reference.
	 * @see #setHeaders(Template)
	 * @see edapuC.EdapuCPackage#getUCApplication_Headers()
	 * @model containment="true"
	 * @generated
	 */
	Template getHeaders();

	/**
	 * Sets the value of the '{@link edapuC.UCApplication#getHeaders <em>Headers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Headers</em>' containment reference.
	 * @see #getHeaders()
	 * @generated
	 */
	void setHeaders(Template value);

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
	 * @see edapuC.EdapuCPackage#getUCApplication_Init()
	 * @model containment="true"
	 * @generated
	 */
	Template getInit();

	/**
	 * Sets the value of the '{@link edapuC.UCApplication#getInit <em>Init</em>}' containment reference.
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
	 * @see edapuC.EdapuCPackage#getUCApplication_Poll()
	 * @model containment="true"
	 * @generated
	 */
	Template getPoll();

	/**
	 * Sets the value of the '{@link edapuC.UCApplication#getPoll <em>Poll</em>}' containment reference.
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
	 * @see edapuC.EdapuCPackage#getUCApplication_Global()
	 * @model containment="true"
	 * @generated
	 */
	Template getGlobal();

	/**
	 * Sets the value of the '{@link edapuC.UCApplication#getGlobal <em>Global</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global</em>' containment reference.
	 * @see #getGlobal()
	 * @generated
	 */
	void setGlobal(Template value);

} // UCApplication
