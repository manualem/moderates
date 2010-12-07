/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed.impl;

import edap_relaxed.AspectModelElement;
import edap_relaxed.Edap_relaxedPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edap_relaxed.impl.AspectModelElementImpl#getAspectID <em>Aspect ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AspectModelElementImpl extends EObjectImpl implements AspectModelElement {
	/**
	 * The default value of the '{@link #getAspectID() <em>Aspect ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspectID()
	 * @generated
	 * @ordered
	 */
	protected static final String ASPECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAspectID() <em>Aspect ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspectID()
	 * @generated
	 * @ordered
	 */
	protected String aspectID = ASPECT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AspectModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Edap_relaxedPackage.Literals.ASPECT_MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAspectID() {
		return aspectID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAspectID(String newAspectID) {
		String oldAspectID = aspectID;
		aspectID = newAspectID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Edap_relaxedPackage.ASPECT_MODEL_ELEMENT__ASPECT_ID, oldAspectID, aspectID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Edap_relaxedPackage.ASPECT_MODEL_ELEMENT__ASPECT_ID:
				return getAspectID();
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
			case Edap_relaxedPackage.ASPECT_MODEL_ELEMENT__ASPECT_ID:
				setAspectID((String)newValue);
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
			case Edap_relaxedPackage.ASPECT_MODEL_ELEMENT__ASPECT_ID:
				setAspectID(ASPECT_ID_EDEFAULT);
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
			case Edap_relaxedPackage.ASPECT_MODEL_ELEMENT__ASPECT_ID:
				return ASPECT_ID_EDEFAULT == null ? aspectID != null : !ASPECT_ID_EDEFAULT.equals(aspectID);
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
		result.append(" (aspectID: ");
		result.append(aspectID);
		result.append(')');
		return result.toString();
	}

} //AspectModelElementImpl
