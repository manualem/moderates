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
package edapuC.impl;

import edapuC.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EdapuCFactoryImpl extends EFactoryImpl implements EdapuCFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EdapuCFactory init() {
		try {
			EdapuCFactory theEdapuCFactory = (EdapuCFactory)EPackage.Registry.INSTANCE.getEFactory("http://edapuC"); 
			if (theEdapuCFactory != null) {
				return theEdapuCFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EdapuCFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdapuCFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EdapuCPackage.UC_GENERATOR: return createUCGenerator();
			case EdapuCPackage.UC_DEVICE: return createUCDevice();
			case EdapuCPackage.UC_MESSAGE: return createUCMessage();
			case EdapuCPackage.TEMPLATE: return createTemplate();
			case EdapuCPackage.STATIC_PROPERTY: return createStaticProperty();
			case EdapuCPackage.UC_APPLICATION: return createUCApplication();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCGenerator createUCGenerator() {
		UCGeneratorImpl ucGenerator = new UCGeneratorImpl();
		return ucGenerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCDevice createUCDevice() {
		UCDeviceImpl ucDevice = new UCDeviceImpl();
		return ucDevice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCMessage createUCMessage() {
		UCMessageImpl ucMessage = new UCMessageImpl();
		return ucMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template createTemplate() {
		TemplateImpl template = new TemplateImpl();
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticProperty createStaticProperty() {
		StaticPropertyImpl staticProperty = new StaticPropertyImpl();
		return staticProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCApplication createUCApplication() {
		UCApplicationImpl ucApplication = new UCApplicationImpl();
		return ucApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdapuCPackage getEdapuCPackage() {
		return (EdapuCPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EdapuCPackage getPackage() {
		return EdapuCPackage.eINSTANCE;
	}

} //EdapuCFactoryImpl
