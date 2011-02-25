/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap.impl;

import edap.EdapPackage;
import edap.Expression;
import edap.PrintAction;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Print Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edap.impl.PrintActionImpl#getMsg <em>Msg</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrintActionImpl extends ActionImpl implements PrintAction {
	/**
	 * The cached value of the '{@link #getMsg() <em>Msg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMsg()
	 * @generated
	 * @ordered
	 */
	protected Expression msg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrintActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdapPackage.Literals.PRINT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getMsg() {
		return msg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMsg(Expression newMsg, NotificationChain msgs) {
		Expression oldMsg = msg;
		msg = newMsg;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EdapPackage.PRINT_ACTION__MSG, oldMsg, newMsg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMsg(Expression newMsg) {
		if (newMsg != msg) {
			NotificationChain msgs = null;
			if (msg != null)
				msgs = ((InternalEObject)msg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EdapPackage.PRINT_ACTION__MSG, null, msgs);
			if (newMsg != null)
				msgs = ((InternalEObject)newMsg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EdapPackage.PRINT_ACTION__MSG, null, msgs);
			msgs = basicSetMsg(newMsg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.PRINT_ACTION__MSG, newMsg, newMsg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EdapPackage.PRINT_ACTION__MSG:
				return basicSetMsg(null, msgs);
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
			case EdapPackage.PRINT_ACTION__MSG:
				return getMsg();
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
			case EdapPackage.PRINT_ACTION__MSG:
				setMsg((Expression)newValue);
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
			case EdapPackage.PRINT_ACTION__MSG:
				setMsg((Expression)null);
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
			case EdapPackage.PRINT_ACTION__MSG:
				return msg != null;
		}
		return super.eIsSet(featureID);
	}

} //PrintActionImpl