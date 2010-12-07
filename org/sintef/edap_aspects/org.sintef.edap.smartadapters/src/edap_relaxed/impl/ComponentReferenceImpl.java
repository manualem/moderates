/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed.impl;

import edap_relaxed.Component;
import edap_relaxed.ComponentReference;
import edap_relaxed.Edap_relaxedPackage;
import edap_relaxed.PropertyNavigation;

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
 * An implementation of the model object '<em><b>Component Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edap_relaxed.impl.ComponentReferenceImpl#getComponent <em>Component</em>}</li>
 *   <li>{@link edap_relaxed.impl.ComponentReferenceImpl#getPropertyNavigations <em>Property Navigations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentReferenceImpl extends ExpressionImpl implements ComponentReference {
	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected Component component;

	/**
	 * The cached value of the '{@link #getPropertyNavigations() <em>Property Navigations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyNavigations()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyNavigation> propertyNavigations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Edap_relaxedPackage.Literals.COMPONENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (Component)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(Component newComponent) {
		Component oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyNavigation> getPropertyNavigations() {
		if (propertyNavigations == null) {
			propertyNavigations = new EObjectContainmentEList<PropertyNavigation>(PropertyNavigation.class, this, Edap_relaxedPackage.COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS);
		}
		return propertyNavigations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Edap_relaxedPackage.COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS:
				return ((InternalEList<?>)getPropertyNavigations()).basicRemove(otherEnd, msgs);
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
			case Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
			case Edap_relaxedPackage.COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS:
				return getPropertyNavigations();
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
			case Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT:
				setComponent((Component)newValue);
				return;
			case Edap_relaxedPackage.COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS:
				getPropertyNavigations().clear();
				getPropertyNavigations().addAll((Collection<? extends PropertyNavigation>)newValue);
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
			case Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT:
				setComponent((Component)null);
				return;
			case Edap_relaxedPackage.COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS:
				getPropertyNavigations().clear();
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
			case Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT:
				return component != null;
			case Edap_relaxedPackage.COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS:
				return propertyNavigations != null && !propertyNavigations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComponentReferenceImpl
