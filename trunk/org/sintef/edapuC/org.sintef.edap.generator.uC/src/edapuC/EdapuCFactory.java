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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edapuC.EdapuCPackage
 * @generated
 */
public interface EdapuCFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EdapuCFactory eINSTANCE = edapuC.impl.EdapuCFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>UC Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UC Generator</em>'.
	 * @generated
	 */
	UCGenerator createUCGenerator();

	/**
	 * Returns a new object of class '<em>UC Device</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UC Device</em>'.
	 * @generated
	 */
	UCDevice createUCDevice();

	/**
	 * Returns a new object of class '<em>UC Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UC Message</em>'.
	 * @generated
	 */
	UCMessage createUCMessage();

	/**
	 * Returns a new object of class '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template</em>'.
	 * @generated
	 */
	Template createTemplate();

	/**
	 * Returns a new object of class '<em>Static Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Property</em>'.
	 * @generated
	 */
	StaticProperty createStaticProperty();

	/**
	 * Returns a new object of class '<em>UC Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UC Application</em>'.
	 * @generated
	 */
	UCApplication createUCApplication();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EdapuCPackage getEdapuCPackage();

} //EdapuCFactory
