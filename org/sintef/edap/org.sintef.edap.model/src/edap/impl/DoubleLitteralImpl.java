/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap.impl;

import edap.DoubleLitteral;
import edap.EdapPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Litteral</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edap.impl.DoubleLitteralImpl#getDoubleValue <em>Double Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DoubleLitteralImpl extends LitteralImpl implements DoubleLitteral {
	/**
	 * The default value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleValue()
	 * @generated
	 * @ordered
	 */
	protected static final double DOUBLE_VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDoubleValue() <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleValue()
	 * @generated
	 * @ordered
	 */
	protected double doubleValue = DOUBLE_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleLitteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdapPackage.Literals.DOUBLE_LITTERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDoubleValue() {
		return doubleValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoubleValue(double newDoubleValue) {
		double oldDoubleValue = doubleValue;
		doubleValue = newDoubleValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.DOUBLE_LITTERAL__DOUBLE_VALUE, oldDoubleValue, doubleValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdapPackage.DOUBLE_LITTERAL__DOUBLE_VALUE:
				return getDoubleValue();
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
			case EdapPackage.DOUBLE_LITTERAL__DOUBLE_VALUE:
				setDoubleValue((Double)newValue);
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
			case EdapPackage.DOUBLE_LITTERAL__DOUBLE_VALUE:
				setDoubleValue(DOUBLE_VALUE_EDEFAULT);
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
			case EdapPackage.DOUBLE_LITTERAL__DOUBLE_VALUE:
				return doubleValue != DOUBLE_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (doubleValue: ");
		result.append(doubleValue);
		result.append(')');
		return result.toString();
	}

} //DoubleLitteralImpl
