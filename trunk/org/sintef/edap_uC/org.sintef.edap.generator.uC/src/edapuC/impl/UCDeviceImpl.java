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

import edap.Component;

import edapuC.EdapuCPackage;
import edapuC.Template;
import edapuC.UCDevice;
import edapuC.UCMessage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UC Device</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edapuC.impl.UCDeviceImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link edapuC.impl.UCDeviceImpl#getDevice <em>Device</em>}</li>
 *   <li>{@link edapuC.impl.UCDeviceImpl#getInit <em>Init</em>}</li>
 *   <li>{@link edapuC.impl.UCDeviceImpl#getPoll <em>Poll</em>}</li>
 *   <li>{@link edapuC.impl.UCDeviceImpl#getGlobal <em>Global</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UCDeviceImpl extends UCElementImpl implements UCDevice {
	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<UCMessage> messages;

	/**
	 * The cached value of the '{@link #getDevice() <em>Device</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDevice()
	 * @generated
	 * @ordered
	 */
	protected Component device;

	/**
	 * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInit()
	 * @generated
	 * @ordered
	 */
	protected Template init;

	/**
	 * The cached value of the '{@link #getPoll() <em>Poll</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoll()
	 * @generated
	 * @ordered
	 */
	protected Template poll;

	/**
	 * The cached value of the '{@link #getGlobal() <em>Global</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobal()
	 * @generated
	 * @ordered
	 */
	protected Template global;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UCDeviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdapuCPackage.Literals.UC_DEVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UCMessage> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentEList<UCMessage>(UCMessage.class, this, EdapuCPackage.UC_DEVICE__MESSAGES);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getDevice() {
		if (device != null && device.eIsProxy()) {
			InternalEObject oldDevice = (InternalEObject)device;
			device = (Component)eResolveProxy(oldDevice);
			if (device != oldDevice) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdapuCPackage.UC_DEVICE__DEVICE, oldDevice, device));
			}
		}
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetDevice() {
		return device;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDevice(Component newDevice) {
		Component oldDevice = device;
		device = newDevice;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_DEVICE__DEVICE, oldDevice, device));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template getInit() {
		return init;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInit(Template newInit, NotificationChain msgs) {
		Template oldInit = init;
		init = newInit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_DEVICE__INIT, oldInit, newInit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInit(Template newInit) {
		if (newInit != init) {
			NotificationChain msgs = null;
			if (init != null)
				msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_DEVICE__INIT, null, msgs);
			if (newInit != null)
				msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_DEVICE__INIT, null, msgs);
			msgs = basicSetInit(newInit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_DEVICE__INIT, newInit, newInit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template getPoll() {
		return poll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPoll(Template newPoll, NotificationChain msgs) {
		Template oldPoll = poll;
		poll = newPoll;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_DEVICE__POLL, oldPoll, newPoll);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPoll(Template newPoll) {
		if (newPoll != poll) {
			NotificationChain msgs = null;
			if (poll != null)
				msgs = ((InternalEObject)poll).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_DEVICE__POLL, null, msgs);
			if (newPoll != null)
				msgs = ((InternalEObject)newPoll).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_DEVICE__POLL, null, msgs);
			msgs = basicSetPoll(newPoll, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_DEVICE__POLL, newPoll, newPoll));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template getGlobal() {
		return global;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGlobal(Template newGlobal, NotificationChain msgs) {
		Template oldGlobal = global;
		global = newGlobal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_DEVICE__GLOBAL, oldGlobal, newGlobal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobal(Template newGlobal) {
		if (newGlobal != global) {
			NotificationChain msgs = null;
			if (global != null)
				msgs = ((InternalEObject)global).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_DEVICE__GLOBAL, null, msgs);
			if (newGlobal != null)
				msgs = ((InternalEObject)newGlobal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_DEVICE__GLOBAL, null, msgs);
			msgs = basicSetGlobal(newGlobal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_DEVICE__GLOBAL, newGlobal, newGlobal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EdapuCPackage.UC_DEVICE__MESSAGES:
				return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
			case EdapuCPackage.UC_DEVICE__INIT:
				return basicSetInit(null, msgs);
			case EdapuCPackage.UC_DEVICE__POLL:
				return basicSetPoll(null, msgs);
			case EdapuCPackage.UC_DEVICE__GLOBAL:
				return basicSetGlobal(null, msgs);
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
			case EdapuCPackage.UC_DEVICE__MESSAGES:
				return getMessages();
			case EdapuCPackage.UC_DEVICE__DEVICE:
				if (resolve) return getDevice();
				return basicGetDevice();
			case EdapuCPackage.UC_DEVICE__INIT:
				return getInit();
			case EdapuCPackage.UC_DEVICE__POLL:
				return getPoll();
			case EdapuCPackage.UC_DEVICE__GLOBAL:
				return getGlobal();
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
			case EdapuCPackage.UC_DEVICE__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends UCMessage>)newValue);
				return;
			case EdapuCPackage.UC_DEVICE__DEVICE:
				setDevice((Component)newValue);
				return;
			case EdapuCPackage.UC_DEVICE__INIT:
				setInit((Template)newValue);
				return;
			case EdapuCPackage.UC_DEVICE__POLL:
				setPoll((Template)newValue);
				return;
			case EdapuCPackage.UC_DEVICE__GLOBAL:
				setGlobal((Template)newValue);
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
			case EdapuCPackage.UC_DEVICE__MESSAGES:
				getMessages().clear();
				return;
			case EdapuCPackage.UC_DEVICE__DEVICE:
				setDevice((Component)null);
				return;
			case EdapuCPackage.UC_DEVICE__INIT:
				setInit((Template)null);
				return;
			case EdapuCPackage.UC_DEVICE__POLL:
				setPoll((Template)null);
				return;
			case EdapuCPackage.UC_DEVICE__GLOBAL:
				setGlobal((Template)null);
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
			case EdapuCPackage.UC_DEVICE__MESSAGES:
				return messages != null && !messages.isEmpty();
			case EdapuCPackage.UC_DEVICE__DEVICE:
				return device != null;
			case EdapuCPackage.UC_DEVICE__INIT:
				return init != null;
			case EdapuCPackage.UC_DEVICE__POLL:
				return poll != null;
			case EdapuCPackage.UC_DEVICE__GLOBAL:
				return global != null;
		}
		return super.eIsSet(featureID);
	}

} //UCDeviceImpl
