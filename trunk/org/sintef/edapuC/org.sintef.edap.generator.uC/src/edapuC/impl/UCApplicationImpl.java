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
import edapuC.UCApplication;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UC Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edapuC.impl.UCApplicationImpl#getState_machine <em>State machine</em>}</li>
 *   <li>{@link edapuC.impl.UCApplicationImpl#getHeaders <em>Headers</em>}</li>
 *   <li>{@link edapuC.impl.UCApplicationImpl#getInit <em>Init</em>}</li>
 *   <li>{@link edapuC.impl.UCApplicationImpl#getPoll <em>Poll</em>}</li>
 *   <li>{@link edapuC.impl.UCApplicationImpl#getGlobal <em>Global</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UCApplicationImpl extends UCElementImpl implements UCApplication {
	/**
	 * The cached value of the '{@link #getState_machine() <em>State machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState_machine()
	 * @generated
	 * @ordered
	 */
	protected Component state_machine;

	/**
	 * The cached value of the '{@link #getHeaders() <em>Headers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaders()
	 * @generated
	 * @ordered
	 */
	protected Template headers;

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
	protected UCApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdapuCPackage.Literals.UC_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getState_machine() {
		if (state_machine != null && state_machine.eIsProxy()) {
			InternalEObject oldState_machine = (InternalEObject)state_machine;
			state_machine = (Component)eResolveProxy(oldState_machine);
			if (state_machine != oldState_machine) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdapuCPackage.UC_APPLICATION__STATE_MACHINE, oldState_machine, state_machine));
			}
		}
		return state_machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetState_machine() {
		return state_machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState_machine(Component newState_machine) {
		Component oldState_machine = state_machine;
		state_machine = newState_machine;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_APPLICATION__STATE_MACHINE, oldState_machine, state_machine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template getHeaders() {
		return headers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeaders(Template newHeaders, NotificationChain msgs) {
		Template oldHeaders = headers;
		headers = newHeaders;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_APPLICATION__HEADERS, oldHeaders, newHeaders);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeaders(Template newHeaders) {
		if (newHeaders != headers) {
			NotificationChain msgs = null;
			if (headers != null)
				msgs = ((InternalEObject)headers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_APPLICATION__HEADERS, null, msgs);
			if (newHeaders != null)
				msgs = ((InternalEObject)newHeaders).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_APPLICATION__HEADERS, null, msgs);
			msgs = basicSetHeaders(newHeaders, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_APPLICATION__HEADERS, newHeaders, newHeaders));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_APPLICATION__INIT, oldInit, newInit);
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
				msgs = ((InternalEObject)init).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_APPLICATION__INIT, null, msgs);
			if (newInit != null)
				msgs = ((InternalEObject)newInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_APPLICATION__INIT, null, msgs);
			msgs = basicSetInit(newInit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_APPLICATION__INIT, newInit, newInit));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_APPLICATION__POLL, oldPoll, newPoll);
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
				msgs = ((InternalEObject)poll).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_APPLICATION__POLL, null, msgs);
			if (newPoll != null)
				msgs = ((InternalEObject)newPoll).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_APPLICATION__POLL, null, msgs);
			msgs = basicSetPoll(newPoll, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_APPLICATION__POLL, newPoll, newPoll));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_APPLICATION__GLOBAL, oldGlobal, newGlobal);
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
				msgs = ((InternalEObject)global).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_APPLICATION__GLOBAL, null, msgs);
			if (newGlobal != null)
				msgs = ((InternalEObject)newGlobal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdapuCPackage.UC_APPLICATION__GLOBAL, null, msgs);
			msgs = basicSetGlobal(newGlobal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapuCPackage.UC_APPLICATION__GLOBAL, newGlobal, newGlobal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EdapuCPackage.UC_APPLICATION__HEADERS:
				return basicSetHeaders(null, msgs);
			case EdapuCPackage.UC_APPLICATION__INIT:
				return basicSetInit(null, msgs);
			case EdapuCPackage.UC_APPLICATION__POLL:
				return basicSetPoll(null, msgs);
			case EdapuCPackage.UC_APPLICATION__GLOBAL:
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
			case EdapuCPackage.UC_APPLICATION__STATE_MACHINE:
				if (resolve) return getState_machine();
				return basicGetState_machine();
			case EdapuCPackage.UC_APPLICATION__HEADERS:
				return getHeaders();
			case EdapuCPackage.UC_APPLICATION__INIT:
				return getInit();
			case EdapuCPackage.UC_APPLICATION__POLL:
				return getPoll();
			case EdapuCPackage.UC_APPLICATION__GLOBAL:
				return getGlobal();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EdapuCPackage.UC_APPLICATION__STATE_MACHINE:
				setState_machine((Component)newValue);
				return;
			case EdapuCPackage.UC_APPLICATION__HEADERS:
				setHeaders((Template)newValue);
				return;
			case EdapuCPackage.UC_APPLICATION__INIT:
				setInit((Template)newValue);
				return;
			case EdapuCPackage.UC_APPLICATION__POLL:
				setPoll((Template)newValue);
				return;
			case EdapuCPackage.UC_APPLICATION__GLOBAL:
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
			case EdapuCPackage.UC_APPLICATION__STATE_MACHINE:
				setState_machine((Component)null);
				return;
			case EdapuCPackage.UC_APPLICATION__HEADERS:
				setHeaders((Template)null);
				return;
			case EdapuCPackage.UC_APPLICATION__INIT:
				setInit((Template)null);
				return;
			case EdapuCPackage.UC_APPLICATION__POLL:
				setPoll((Template)null);
				return;
			case EdapuCPackage.UC_APPLICATION__GLOBAL:
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
			case EdapuCPackage.UC_APPLICATION__STATE_MACHINE:
				return state_machine != null;
			case EdapuCPackage.UC_APPLICATION__HEADERS:
				return headers != null;
			case EdapuCPackage.UC_APPLICATION__INIT:
				return init != null;
			case EdapuCPackage.UC_APPLICATION__POLL:
				return poll != null;
			case EdapuCPackage.UC_APPLICATION__GLOBAL:
				return global != null;
		}
		return super.eIsSet(featureID);
	}

} //UCApplicationImpl
