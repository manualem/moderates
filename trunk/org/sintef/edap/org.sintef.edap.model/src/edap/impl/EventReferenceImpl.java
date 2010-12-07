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
package edap.impl;

import edap.EdapPackage;
import edap.EventReference;
import edap.Parameter;
import edap.ReceiveMessage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edap.impl.EventReferenceImpl#getMsgRef <em>Msg Ref</em>}</li>
 *   <li>{@link edap.impl.EventReferenceImpl#getParamRef <em>Param Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventReferenceImpl extends ExpressionImpl implements EventReference {
	/**
	 * The cached value of the '{@link #getMsgRef() <em>Msg Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsgRef()
	 * @generated
	 * @ordered
	 */
	protected ReceiveMessage msgRef;

	/**
	 * The cached value of the '{@link #getParamRef() <em>Param Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParamRef()
	 * @generated
	 * @ordered
	 */
	protected Parameter paramRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdapPackage.Literals.EVENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReceiveMessage getMsgRef() {
		if (msgRef != null && msgRef.eIsProxy()) {
			InternalEObject oldMsgRef = (InternalEObject)msgRef;
			msgRef = (ReceiveMessage)eResolveProxy(oldMsgRef);
			if (msgRef != oldMsgRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdapPackage.EVENT_REFERENCE__MSG_REF, oldMsgRef, msgRef));
			}
		}
		return msgRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReceiveMessage basicGetMsgRef() {
		return msgRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsgRef(ReceiveMessage newMsgRef) {
		ReceiveMessage oldMsgRef = msgRef;
		msgRef = newMsgRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.EVENT_REFERENCE__MSG_REF, oldMsgRef, msgRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getParamRef() {
		if (paramRef != null && paramRef.eIsProxy()) {
			InternalEObject oldParamRef = (InternalEObject)paramRef;
			paramRef = (Parameter)eResolveProxy(oldParamRef);
			if (paramRef != oldParamRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdapPackage.EVENT_REFERENCE__PARAM_REF, oldParamRef, paramRef));
			}
		}
		return paramRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetParamRef() {
		return paramRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParamRef(Parameter newParamRef) {
		Parameter oldParamRef = paramRef;
		paramRef = newParamRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.EVENT_REFERENCE__PARAM_REF, oldParamRef, paramRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdapPackage.EVENT_REFERENCE__MSG_REF:
				if (resolve) return getMsgRef();
				return basicGetMsgRef();
			case EdapPackage.EVENT_REFERENCE__PARAM_REF:
				if (resolve) return getParamRef();
				return basicGetParamRef();
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
			case EdapPackage.EVENT_REFERENCE__MSG_REF:
				setMsgRef((ReceiveMessage)newValue);
				return;
			case EdapPackage.EVENT_REFERENCE__PARAM_REF:
				setParamRef((Parameter)newValue);
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
			case EdapPackage.EVENT_REFERENCE__MSG_REF:
				setMsgRef((ReceiveMessage)null);
				return;
			case EdapPackage.EVENT_REFERENCE__PARAM_REF:
				setParamRef((Parameter)null);
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
			case EdapPackage.EVENT_REFERENCE__MSG_REF:
				return msgRef != null;
			case EdapPackage.EVENT_REFERENCE__PARAM_REF:
				return paramRef != null;
		}
		return super.eIsSet(featureID);
	}

} //EventReferenceImpl
