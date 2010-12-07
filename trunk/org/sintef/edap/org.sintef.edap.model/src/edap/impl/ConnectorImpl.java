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

import edap.Component;
import edap.Connector;
import edap.EdapPackage;
import edap.Port;
import edap.Property;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edap.impl.ConnectorImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link edap.impl.ConnectorImpl#getPort1 <em>Port1</em>}</li>
 *   <li>{@link edap.impl.ConnectorImpl#getPort2 <em>Port2</em>}</li>
 *   <li>{@link edap.impl.ConnectorImpl#getProp1 <em>Prop1</em>}</li>
 *   <li>{@link edap.impl.ConnectorImpl#getProp2 <em>Prop2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorImpl extends AnnotatedElementImpl implements Connector {
	/**
	 * The cached value of the '{@link #getPort1() <em>Port1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort1()
	 * @generated
	 * @ordered
	 */
	protected Port port1;

	/**
	 * The cached value of the '{@link #getPort2() <em>Port2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort2()
	 * @generated
	 * @ordered
	 */
	protected Port port2;

	/**
	 * The cached value of the '{@link #getProp1() <em>Prop1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProp1()
	 * @generated
	 * @ordered
	 */
	protected Property prop1;

	/**
	 * The cached value of the '{@link #getProp2() <em>Prop2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProp2()
	 * @generated
	 * @ordered
	 */
	protected Property prop2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdapPackage.Literals.CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getOwner() {
		if (eContainerFeatureID() != EdapPackage.CONNECTOR__OWNER) return null;
		return (Component)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Component newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, EdapPackage.CONNECTOR__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Component newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != EdapPackage.CONNECTOR__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, EdapPackage.COMPONENT__CONNECTORS, Component.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.CONNECTOR__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getPort1() {
		if (port1 != null && port1.eIsProxy()) {
			InternalEObject oldPort1 = (InternalEObject)port1;
			port1 = (Port)eResolveProxy(oldPort1);
			if (port1 != oldPort1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdapPackage.CONNECTOR__PORT1, oldPort1, port1));
			}
		}
		return port1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetPort1() {
		return port1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort1(Port newPort1) {
		Port oldPort1 = port1;
		port1 = newPort1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.CONNECTOR__PORT1, oldPort1, port1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getPort2() {
		if (port2 != null && port2.eIsProxy()) {
			InternalEObject oldPort2 = (InternalEObject)port2;
			port2 = (Port)eResolveProxy(oldPort2);
			if (port2 != oldPort2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdapPackage.CONNECTOR__PORT2, oldPort2, port2));
			}
		}
		return port2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetPort2() {
		return port2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort2(Port newPort2) {
		Port oldPort2 = port2;
		port2 = newPort2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.CONNECTOR__PORT2, oldPort2, port2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProp1() {
		if (prop1 != null && prop1.eIsProxy()) {
			InternalEObject oldProp1 = (InternalEObject)prop1;
			prop1 = (Property)eResolveProxy(oldProp1);
			if (prop1 != oldProp1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdapPackage.CONNECTOR__PROP1, oldProp1, prop1));
			}
		}
		return prop1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProp1() {
		return prop1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProp1(Property newProp1) {
		Property oldProp1 = prop1;
		prop1 = newProp1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.CONNECTOR__PROP1, oldProp1, prop1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProp2() {
		if (prop2 != null && prop2.eIsProxy()) {
			InternalEObject oldProp2 = (InternalEObject)prop2;
			prop2 = (Property)eResolveProxy(oldProp2);
			if (prop2 != oldProp2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdapPackage.CONNECTOR__PROP2, oldProp2, prop2));
			}
		}
		return prop2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProp2() {
		return prop2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProp2(Property newProp2) {
		Property oldProp2 = prop2;
		prop2 = newProp2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.CONNECTOR__PROP2, oldProp2, prop2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EdapPackage.CONNECTOR__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Component)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EdapPackage.CONNECTOR__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EdapPackage.CONNECTOR__OWNER:
				return eInternalContainer().eInverseRemove(this, EdapPackage.COMPONENT__CONNECTORS, Component.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdapPackage.CONNECTOR__OWNER:
				return getOwner();
			case EdapPackage.CONNECTOR__PORT1:
				if (resolve) return getPort1();
				return basicGetPort1();
			case EdapPackage.CONNECTOR__PORT2:
				if (resolve) return getPort2();
				return basicGetPort2();
			case EdapPackage.CONNECTOR__PROP1:
				if (resolve) return getProp1();
				return basicGetProp1();
			case EdapPackage.CONNECTOR__PROP2:
				if (resolve) return getProp2();
				return basicGetProp2();
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
			case EdapPackage.CONNECTOR__OWNER:
				setOwner((Component)newValue);
				return;
			case EdapPackage.CONNECTOR__PORT1:
				setPort1((Port)newValue);
				return;
			case EdapPackage.CONNECTOR__PORT2:
				setPort2((Port)newValue);
				return;
			case EdapPackage.CONNECTOR__PROP1:
				setProp1((Property)newValue);
				return;
			case EdapPackage.CONNECTOR__PROP2:
				setProp2((Property)newValue);
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
			case EdapPackage.CONNECTOR__OWNER:
				setOwner((Component)null);
				return;
			case EdapPackage.CONNECTOR__PORT1:
				setPort1((Port)null);
				return;
			case EdapPackage.CONNECTOR__PORT2:
				setPort2((Port)null);
				return;
			case EdapPackage.CONNECTOR__PROP1:
				setProp1((Property)null);
				return;
			case EdapPackage.CONNECTOR__PROP2:
				setProp2((Property)null);
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
			case EdapPackage.CONNECTOR__OWNER:
				return getOwner() != null;
			case EdapPackage.CONNECTOR__PORT1:
				return port1 != null;
			case EdapPackage.CONNECTOR__PORT2:
				return port2 != null;
			case EdapPackage.CONNECTOR__PROP1:
				return prop1 != null;
			case EdapPackage.CONNECTOR__PROP2:
				return prop2 != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectorImpl
