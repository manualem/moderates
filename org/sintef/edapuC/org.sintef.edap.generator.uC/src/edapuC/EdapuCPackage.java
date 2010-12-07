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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edapuC.EdapuCFactory
 * @model kind="package"
 * @generated
 */
public interface EdapuCPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "edapuC";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://edapuC";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edapuC";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EdapuCPackage eINSTANCE = edapuC.impl.EdapuCPackageImpl.init();

	/**
	 * The meta object id for the '{@link edapuC.impl.UCElementImpl <em>UC Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edapuC.impl.UCElementImpl
	 * @see edapuC.impl.EdapuCPackageImpl#getUCElement()
	 * @generated
	 */
	int UC_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_ELEMENT__PROPERTIES = 0;

	/**
	 * The number of structural features of the '<em>UC Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edapuC.impl.UCGeneratorImpl <em>UC Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edapuC.impl.UCGeneratorImpl
	 * @see edapuC.impl.EdapuCPackageImpl#getUCGenerator()
	 * @generated
	 */
	int UC_GENERATOR = 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_GENERATOR__PROPERTIES = UC_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_GENERATOR__DEVICES = UC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_GENERATOR__IMPORTS = UC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Edap</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_GENERATOR__EDAP = UC_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_GENERATOR__APPLICATION = UC_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>UC Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_GENERATOR_FEATURE_COUNT = UC_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link edapuC.impl.UCDeviceImpl <em>UC Device</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edapuC.impl.UCDeviceImpl
	 * @see edapuC.impl.EdapuCPackageImpl#getUCDevice()
	 * @generated
	 */
	int UC_DEVICE = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_DEVICE__PROPERTIES = UC_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_DEVICE__MESSAGES = UC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Device</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_DEVICE__DEVICE = UC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_DEVICE__INIT = UC_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Poll</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_DEVICE__POLL = UC_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Global</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_DEVICE__GLOBAL = UC_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>UC Device</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_DEVICE_FEATURE_COUNT = UC_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link edapuC.impl.UCMessageImpl <em>UC Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edapuC.impl.UCMessageImpl
	 * @see edapuC.impl.EdapuCPackageImpl#getUCMessage()
	 * @generated
	 */
	int UC_MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_MESSAGE__PROPERTIES = UC_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_MESSAGE__MESSAGE = UC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Send</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_MESSAGE__SEND = UC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>UC Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_MESSAGE_FEATURE_COUNT = UC_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edapuC.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edapuC.impl.TemplateImpl
	 * @see edapuC.impl.EdapuCPackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 3;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__GENERATOR = 1;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edapuC.impl.StaticPropertyImpl <em>Static Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edapuC.impl.StaticPropertyImpl
	 * @see edapuC.impl.EdapuCPackageImpl#getStaticProperty()
	 * @generated
	 */
	int STATIC_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PROPERTY__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PROPERTY__NAME = 1;

	/**
	 * The number of structural features of the '<em>Static Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edapuC.impl.UCApplicationImpl <em>UC Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edapuC.impl.UCApplicationImpl
	 * @see edapuC.impl.EdapuCPackageImpl#getUCApplication()
	 * @generated
	 */
	int UC_APPLICATION = 6;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_APPLICATION__PROPERTIES = UC_ELEMENT__PROPERTIES;

	/**
	 * The feature id for the '<em><b>State machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_APPLICATION__STATE_MACHINE = UC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Headers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_APPLICATION__HEADERS = UC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_APPLICATION__INIT = UC_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Poll</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_APPLICATION__POLL = UC_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Global</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_APPLICATION__GLOBAL = UC_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>UC Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UC_APPLICATION_FEATURE_COUNT = UC_ELEMENT_FEATURE_COUNT + 5;


	/**
	 * Returns the meta object for class '{@link edapuC.UCGenerator <em>UC Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UC Generator</em>'.
	 * @see edapuC.UCGenerator
	 * @generated
	 */
	EClass getUCGenerator();

	/**
	 * Returns the meta object for the containment reference list '{@link edapuC.UCGenerator#getDevices <em>Devices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Devices</em>'.
	 * @see edapuC.UCGenerator#getDevices()
	 * @see #getUCGenerator()
	 * @generated
	 */
	EReference getUCGenerator_Devices();

	/**
	 * Returns the meta object for the reference list '{@link edapuC.UCGenerator#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see edapuC.UCGenerator#getImports()
	 * @see #getUCGenerator()
	 * @generated
	 */
	EReference getUCGenerator_Imports();

	/**
	 * Returns the meta object for the reference list '{@link edapuC.UCGenerator#getEdap <em>Edap</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edap</em>'.
	 * @see edapuC.UCGenerator#getEdap()
	 * @see #getUCGenerator()
	 * @generated
	 */
	EReference getUCGenerator_Edap();

	/**
	 * Returns the meta object for the containment reference '{@link edapuC.UCGenerator#getApplication <em>Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Application</em>'.
	 * @see edapuC.UCGenerator#getApplication()
	 * @see #getUCGenerator()
	 * @generated
	 */
	EReference getUCGenerator_Application();

	/**
	 * Returns the meta object for class '{@link edapuC.UCDevice <em>UC Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UC Device</em>'.
	 * @see edapuC.UCDevice
	 * @generated
	 */
	EClass getUCDevice();

	/**
	 * Returns the meta object for the containment reference list '{@link edapuC.UCDevice#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Messages</em>'.
	 * @see edapuC.UCDevice#getMessages()
	 * @see #getUCDevice()
	 * @generated
	 */
	EReference getUCDevice_Messages();

	/**
	 * Returns the meta object for the reference '{@link edapuC.UCDevice#getDevice <em>Device</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Device</em>'.
	 * @see edapuC.UCDevice#getDevice()
	 * @see #getUCDevice()
	 * @generated
	 */
	EReference getUCDevice_Device();

	/**
	 * Returns the meta object for the containment reference '{@link edapuC.UCDevice#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see edapuC.UCDevice#getInit()
	 * @see #getUCDevice()
	 * @generated
	 */
	EReference getUCDevice_Init();

	/**
	 * Returns the meta object for the containment reference '{@link edapuC.UCDevice#getPoll <em>Poll</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Poll</em>'.
	 * @see edapuC.UCDevice#getPoll()
	 * @see #getUCDevice()
	 * @generated
	 */
	EReference getUCDevice_Poll();

	/**
	 * Returns the meta object for the containment reference '{@link edapuC.UCDevice#getGlobal <em>Global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Global</em>'.
	 * @see edapuC.UCDevice#getGlobal()
	 * @see #getUCDevice()
	 * @generated
	 */
	EReference getUCDevice_Global();

	/**
	 * Returns the meta object for class '{@link edapuC.UCMessage <em>UC Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UC Message</em>'.
	 * @see edapuC.UCMessage
	 * @generated
	 */
	EClass getUCMessage();

	/**
	 * Returns the meta object for the reference '{@link edapuC.UCMessage#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Message</em>'.
	 * @see edapuC.UCMessage#getMessage()
	 * @see #getUCMessage()
	 * @generated
	 */
	EReference getUCMessage_Message();

	/**
	 * Returns the meta object for the containment reference '{@link edapuC.UCMessage#getSend <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Send</em>'.
	 * @see edapuC.UCMessage#getSend()
	 * @see #getUCMessage()
	 * @generated
	 */
	EReference getUCMessage_Send();

	/**
	 * Returns the meta object for class '{@link edapuC.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see edapuC.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the attribute '{@link edapuC.Template#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see edapuC.Template#getText()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_Text();

	/**
	 * Returns the meta object for the attribute '{@link edapuC.Template#getGenerator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generator</em>'.
	 * @see edapuC.Template#getGenerator()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_Generator();

	/**
	 * Returns the meta object for class '{@link edapuC.StaticProperty <em>Static Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Property</em>'.
	 * @see edapuC.StaticProperty
	 * @generated
	 */
	EClass getStaticProperty();

	/**
	 * Returns the meta object for the attribute '{@link edapuC.StaticProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edapuC.StaticProperty#getValue()
	 * @see #getStaticProperty()
	 * @generated
	 */
	EAttribute getStaticProperty_Value();

	/**
	 * Returns the meta object for the attribute '{@link edapuC.StaticProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edapuC.StaticProperty#getName()
	 * @see #getStaticProperty()
	 * @generated
	 */
	EAttribute getStaticProperty_Name();

	/**
	 * Returns the meta object for class '{@link edapuC.UCElement <em>UC Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UC Element</em>'.
	 * @see edapuC.UCElement
	 * @generated
	 */
	EClass getUCElement();

	/**
	 * Returns the meta object for the containment reference list '{@link edapuC.UCElement#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see edapuC.UCElement#getProperties()
	 * @see #getUCElement()
	 * @generated
	 */
	EReference getUCElement_Properties();

	/**
	 * Returns the meta object for class '{@link edapuC.UCApplication <em>UC Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UC Application</em>'.
	 * @see edapuC.UCApplication
	 * @generated
	 */
	EClass getUCApplication();

	/**
	 * Returns the meta object for the reference '{@link edapuC.UCApplication#getState_machine <em>State machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State machine</em>'.
	 * @see edapuC.UCApplication#getState_machine()
	 * @see #getUCApplication()
	 * @generated
	 */
	EReference getUCApplication_State_machine();

	/**
	 * Returns the meta object for the containment reference '{@link edapuC.UCApplication#getHeaders <em>Headers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Headers</em>'.
	 * @see edapuC.UCApplication#getHeaders()
	 * @see #getUCApplication()
	 * @generated
	 */
	EReference getUCApplication_Headers();

	/**
	 * Returns the meta object for the containment reference '{@link edapuC.UCApplication#getInit <em>Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Init</em>'.
	 * @see edapuC.UCApplication#getInit()
	 * @see #getUCApplication()
	 * @generated
	 */
	EReference getUCApplication_Init();

	/**
	 * Returns the meta object for the containment reference '{@link edapuC.UCApplication#getPoll <em>Poll</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Poll</em>'.
	 * @see edapuC.UCApplication#getPoll()
	 * @see #getUCApplication()
	 * @generated
	 */
	EReference getUCApplication_Poll();

	/**
	 * Returns the meta object for the containment reference '{@link edapuC.UCApplication#getGlobal <em>Global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Global</em>'.
	 * @see edapuC.UCApplication#getGlobal()
	 * @see #getUCApplication()
	 * @generated
	 */
	EReference getUCApplication_Global();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EdapuCFactory getEdapuCFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edapuC.impl.UCGeneratorImpl <em>UC Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edapuC.impl.UCGeneratorImpl
		 * @see edapuC.impl.EdapuCPackageImpl#getUCGenerator()
		 * @generated
		 */
		EClass UC_GENERATOR = eINSTANCE.getUCGenerator();

		/**
		 * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_GENERATOR__DEVICES = eINSTANCE.getUCGenerator_Devices();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_GENERATOR__IMPORTS = eINSTANCE.getUCGenerator_Imports();

		/**
		 * The meta object literal for the '<em><b>Edap</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_GENERATOR__EDAP = eINSTANCE.getUCGenerator_Edap();

		/**
		 * The meta object literal for the '<em><b>Application</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_GENERATOR__APPLICATION = eINSTANCE.getUCGenerator_Application();

		/**
		 * The meta object literal for the '{@link edapuC.impl.UCDeviceImpl <em>UC Device</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edapuC.impl.UCDeviceImpl
		 * @see edapuC.impl.EdapuCPackageImpl#getUCDevice()
		 * @generated
		 */
		EClass UC_DEVICE = eINSTANCE.getUCDevice();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_DEVICE__MESSAGES = eINSTANCE.getUCDevice_Messages();

		/**
		 * The meta object literal for the '<em><b>Device</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_DEVICE__DEVICE = eINSTANCE.getUCDevice_Device();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_DEVICE__INIT = eINSTANCE.getUCDevice_Init();

		/**
		 * The meta object literal for the '<em><b>Poll</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_DEVICE__POLL = eINSTANCE.getUCDevice_Poll();

		/**
		 * The meta object literal for the '<em><b>Global</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_DEVICE__GLOBAL = eINSTANCE.getUCDevice_Global();

		/**
		 * The meta object literal for the '{@link edapuC.impl.UCMessageImpl <em>UC Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edapuC.impl.UCMessageImpl
		 * @see edapuC.impl.EdapuCPackageImpl#getUCMessage()
		 * @generated
		 */
		EClass UC_MESSAGE = eINSTANCE.getUCMessage();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_MESSAGE__MESSAGE = eINSTANCE.getUCMessage_Message();

		/**
		 * The meta object literal for the '<em><b>Send</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_MESSAGE__SEND = eINSTANCE.getUCMessage_Send();

		/**
		 * The meta object literal for the '{@link edapuC.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edapuC.impl.TemplateImpl
		 * @see edapuC.impl.EdapuCPackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE__TEXT = eINSTANCE.getTemplate_Text();

		/**
		 * The meta object literal for the '<em><b>Generator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE__GENERATOR = eINSTANCE.getTemplate_Generator();

		/**
		 * The meta object literal for the '{@link edapuC.impl.StaticPropertyImpl <em>Static Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edapuC.impl.StaticPropertyImpl
		 * @see edapuC.impl.EdapuCPackageImpl#getStaticProperty()
		 * @generated
		 */
		EClass STATIC_PROPERTY = eINSTANCE.getStaticProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_PROPERTY__VALUE = eINSTANCE.getStaticProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATIC_PROPERTY__NAME = eINSTANCE.getStaticProperty_Name();

		/**
		 * The meta object literal for the '{@link edapuC.impl.UCElementImpl <em>UC Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edapuC.impl.UCElementImpl
		 * @see edapuC.impl.EdapuCPackageImpl#getUCElement()
		 * @generated
		 */
		EClass UC_ELEMENT = eINSTANCE.getUCElement();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_ELEMENT__PROPERTIES = eINSTANCE.getUCElement_Properties();

		/**
		 * The meta object literal for the '{@link edapuC.impl.UCApplicationImpl <em>UC Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edapuC.impl.UCApplicationImpl
		 * @see edapuC.impl.EdapuCPackageImpl#getUCApplication()
		 * @generated
		 */
		EClass UC_APPLICATION = eINSTANCE.getUCApplication();

		/**
		 * The meta object literal for the '<em><b>State machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_APPLICATION__STATE_MACHINE = eINSTANCE.getUCApplication_State_machine();

		/**
		 * The meta object literal for the '<em><b>Headers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_APPLICATION__HEADERS = eINSTANCE.getUCApplication_Headers();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_APPLICATION__INIT = eINSTANCE.getUCApplication_Init();

		/**
		 * The meta object literal for the '<em><b>Poll</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_APPLICATION__POLL = eINSTANCE.getUCApplication_Poll();

		/**
		 * The meta object literal for the '<em><b>Global</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UC_APPLICATION__GLOBAL = eINSTANCE.getUCApplication_Global();

	}

} //EdapuCPackage
