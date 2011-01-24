/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap.impl;

import edap.EdapPackage;
import edap.Property;
import edap.Type;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edap.impl.PropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link edap.impl.PropertyImpl#isChangeable <em>Changeable</em>}</li>
 *   <li>{@link edap.impl.PropertyImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link edap.impl.PropertyImpl#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyImpl extends AnnotatedElementImpl implements Property {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The default value of the '{@link #isChangeable() <em>Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHANGEABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChangeable() <em>Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeable()
	 * @generated
	 * @ordered
	 */
	protected boolean changeable = CHANGEABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected int lowerBound = LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected int upperBound = UPPER_BOUND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EdapPackage.Literals.PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EdapPackage.PROPERTY__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.PROPERTY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChangeable() {
		return changeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeable(boolean newChangeable) {
		boolean oldChangeable = changeable;
		changeable = newChangeable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.PROPERTY__CHANGEABLE, oldChangeable, changeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(int newLowerBound) {
		int oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.PROPERTY__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(int newUpperBound) {
		int oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EdapPackage.PROPERTY__UPPER_BOUND, oldUpperBound, upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EdapPackage.PROPERTY__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case EdapPackage.PROPERTY__CHANGEABLE:
				return isChangeable();
			case EdapPackage.PROPERTY__LOWER_BOUND:
				return getLowerBound();
			case EdapPackage.PROPERTY__UPPER_BOUND:
				return getUpperBound();
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
			case EdapPackage.PROPERTY__TYPE:
				setType((Type)newValue);
				return;
			case EdapPackage.PROPERTY__CHANGEABLE:
				setChangeable((Boolean)newValue);
				return;
			case EdapPackage.PROPERTY__LOWER_BOUND:
				setLowerBound((Integer)newValue);
				return;
			case EdapPackage.PROPERTY__UPPER_BOUND:
				setUpperBound((Integer)newValue);
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
			case EdapPackage.PROPERTY__TYPE:
				setType((Type)null);
				return;
			case EdapPackage.PROPERTY__CHANGEABLE:
				setChangeable(CHANGEABLE_EDEFAULT);
				return;
			case EdapPackage.PROPERTY__LOWER_BOUND:
				setLowerBound(LOWER_BOUND_EDEFAULT);
				return;
			case EdapPackage.PROPERTY__UPPER_BOUND:
				setUpperBound(UPPER_BOUND_EDEFAULT);
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
			case EdapPackage.PROPERTY__TYPE:
				return type != null;
			case EdapPackage.PROPERTY__CHANGEABLE:
				return changeable != CHANGEABLE_EDEFAULT;
			case EdapPackage.PROPERTY__LOWER_BOUND:
				return lowerBound != LOWER_BOUND_EDEFAULT;
			case EdapPackage.PROPERTY__UPPER_BOUND:
				return upperBound != UPPER_BOUND_EDEFAULT;
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
		result.append(" (changeable: ");
		result.append(changeable);
		result.append(", lowerBound: ");
		result.append(lowerBound);
		result.append(", upperBound: ");
		result.append(upperBound);
		result.append(')');
		return result.toString();
	}

} //PropertyImpl
