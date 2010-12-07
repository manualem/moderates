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

import edap.EdapModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UC Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edapuC.UCGenerator#getDevices <em>Devices</em>}</li>
 *   <li>{@link edapuC.UCGenerator#getImports <em>Imports</em>}</li>
 *   <li>{@link edapuC.UCGenerator#getEdap <em>Edap</em>}</li>
 *   <li>{@link edapuC.UCGenerator#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see edapuC.EdapuCPackage#getUCGenerator()
 * @model
 * @generated
 */
public interface UCGenerator extends UCElement {
	/**
	 * Returns the value of the '<em><b>Devices</b></em>' containment reference list.
	 * The list contents are of type {@link edapuC.UCDevice}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Devices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Devices</em>' containment reference list.
	 * @see edapuC.EdapuCPackage#getUCGenerator_Devices()
	 * @model containment="true"
	 * @generated
	 */
	EList<UCDevice> getDevices();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link edapuC.UCGenerator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see edapuC.EdapuCPackage#getUCGenerator_Imports()
	 * @model
	 * @generated
	 */
	EList<UCGenerator> getImports();

	/**
	 * Returns the value of the '<em><b>Edap</b></em>' reference list.
	 * The list contents are of type {@link edap.EdapModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edap</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edap</em>' reference list.
	 * @see edapuC.EdapuCPackage#getUCGenerator_Edap()
	 * @model required="true"
	 * @generated
	 */
	EList<EdapModel> getEdap();

	/**
	 * Returns the value of the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' containment reference.
	 * @see #setApplication(UCApplication)
	 * @see edapuC.EdapuCPackage#getUCGenerator_Application()
	 * @model containment="true"
	 * @generated
	 */
	UCApplication getApplication();

	/**
	 * Sets the value of the '{@link edapuC.UCGenerator#getApplication <em>Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' containment reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(UCApplication value);

} // UCGenerator
