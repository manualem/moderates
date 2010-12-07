/**
 *  Copyright (c) 2010 SINTEF
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      SINTEF - initial API and implementation
 */
package edap;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.Message#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edap.Message#isAllowMulticast <em>Allow Multicast</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends AnnotatedElement {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edap.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see edap.EdapPackage#getMessage_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Allow Multicast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Multicast</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Multicast</em>' attribute.
	 * @see #setAllowMulticast(boolean)
	 * @see edap.EdapPackage#getMessage_AllowMulticast()
	 * @model ordered="false"
	 * @generated
	 */
	boolean isAllowMulticast();

	/**
	 * Sets the value of the '{@link edap.Message#isAllowMulticast <em>Allow Multicast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Multicast</em>' attribute.
	 * @see #isAllowMulticast()
	 * @generated
	 */
	void setAllowMulticast(boolean value);

} // Message
