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

import edap.EdapModel;

import edapuC.EdapuCPackage;
import edapuC.UCApplication;
import edapuC.UCDevice;
import edapuC.UCGenerator;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UC Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edapuC.impl.UCGeneratorImpl#getDevices <em>Devices</em>}</li>
 *   <li>{@link edapuC.impl.UCGeneratorImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link edapuC.impl.UCGeneratorImpl#getEdap <em>Edap</em>}</li>
 *   <li>{@link edapuC.impl.UCGeneratorImpl#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UCGeneratorImpl extends UCElementImpl implements UCGenerator {
	/**
	 * The cached value of the '{@link #getDevices() <em>Devices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevices()
	 * @generated
	 * @ordered
	 */
	protected EList<UCDevice> devices;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<UCGenerator> imports;

	/**
	 * The cached value of the '{@link #getEdap() <em>Edap</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdap()
	 * @generated
	 * @ordered
	 */
	protected EList<EdapModel> edap;

	/**
	 * The cached value of the '{@link #getApplication() <em>Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplication()
	 * @generated
	 * @ordered
	 */
	protected UCApplication application;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UCGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdapuCPackage.Literals.UC_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UCDevice> getDevices() {
		if (devices == null) {
			devices = new EObjectContainmentEList<UCDevice>(UCDevice.class, this, EdapuCPackage.UC_GENERATOR__DEVICES);
		}
		return devices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UCGenerator> getImports() {
		if (imports == null) {
			imports = new EObjectResolvingEList<UCGenerator>(UCGenerator.class, this, EdapuCPackage.UC_GENERATOR__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EdapModel> getEdap() {
		if (edap == null) {
			edap = new EObjectResolvingEList<EdapModel>(EdapModel.class, this, EdapuCPackage.UC_GENERATOR__EDAP);
		}
		return edap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UCApplication getApplication() {
		return application;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplication(UCApplication newApplication, NotificationChain msgs) {
		UCApplication oldApplication = application;
		application = newApplication;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_GENERATOR__APPLICATION, oldApplication, newApplication);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplication(UCApplication newApplication) {
		if (newApplication != application) {
			NotificationChain msgs = null;
			if (application != null)
				msgs = ((InternalEObject)application).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_GENERATOR__APPLICATION, null, msgs);
			if (newApplication != null)
				msgs = ((InternalEObject)newApplication).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_GENERATOR__APPLICATION, null, msgs);
			msgs = basicSetApplication(newApplication, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_GENERATOR__APPLICATION, newApplication, newApplication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EdapuCPackage.UC_GENERATOR__DEVICES:
				return ((InternalEList<?>)getDevices()).basicRemove(otherEnd, msgs);
			case EdapuCPackage.UC_GENERATOR__APPLICATION:
				return basicSetApplication(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdapuCPackage.UC_GENERATOR__DEVICES:
				return getDevices();
			case EdapuCPackage.UC_GENERATOR__IMPORTS:
				return getImports();
			case EdapuCPackage.UC_GENERATOR__EDAP:
				return getEdap();
			case EdapuCPackage.UC_GENERATOR__APPLICATION:
				return getApplication();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EdapuCPackage.UC_GENERATOR__DEVICES:
				getDevices().clear();
				getDevices().addAll((Collection<? extends UCDevice>)newValue);
				return;
			case EdapuCPackage.UC_GENERATOR__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends UCGenerator>)newValue);
				return;
			case EdapuCPackage.UC_GENERATOR__EDAP:
				getEdap().clear();
				getEdap().addAll((Collection<? extends EdapModel>)newValue);
				return;
			case EdapuCPackage.UC_GENERATOR__APPLICATION:
				setApplication((UCApplication)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EdapuCPackage.UC_GENERATOR__DEVICES:
				getDevices().clear();
				return;
			case EdapuCPackage.UC_GENERATOR__IMPORTS:
				getImports().clear();
				return;
			case EdapuCPackage.UC_GENERATOR__EDAP:
				getEdap().clear();
				return;
			case EdapuCPackage.UC_GENERATOR__APPLICATION:
				setApplication((UCApplication)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EdapuCPackage.UC_GENERATOR__DEVICES:
				return devices != null && !devices.isEmpty();
			case EdapuCPackage.UC_GENERATOR__IMPORTS:
				return imports != null && !imports.isEmpty();
			case EdapuCPackage.UC_GENERATOR__EDAP:
				return edap != null && !edap.isEmpty();
			case EdapuCPackage.UC_GENERATOR__APPLICATION:
				return application != null;
		}
		return super.eIsSet(featureID);
	}

} //UCGeneratorImpl
