/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations.impl;

import edap_relaxed.CompositeState;
import edap_relaxed.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import smartadapters4MODERATES.adaptations.AdaptationsPackage;
import smartadapters4MODERATES.adaptations.UnsetCompositeState;

import smartadapters4MODERATES.impl.UnsetAdaptationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unset Composite State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.UnsetCompositeStateImpl#getCompositeStateToUnset <em>Composite State To Unset</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.UnsetCompositeStateImpl#getSubstate <em>Substate</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.UnsetCompositeStateImpl#getInitial <em>Initial</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnsetCompositeStateImpl extends UnsetAdaptationImpl implements UnsetCompositeState {
	/**
	 * The cached value of the '{@link #getCompositeStateToUnset() <em>Composite State To Unset</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeStateToUnset()
	 * @generated
	 * @ordered
	 */
	protected CompositeState compositeStateToUnset;

	/**
	 * The cached value of the '{@link #getSubstate() <em>Substate</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubstate()
	 * @generated
	 * @ordered
	 */
	protected EList<State> substate;

	/**
	 * The cached value of the '{@link #getInitial() <em>Initial</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitial()
	 * @generated
	 * @ordered
	 */
	protected State initial;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnsetCompositeStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptationsPackage.Literals.UNSET_COMPOSITE_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeState getCompositeStateToUnset() {
		if (compositeStateToUnset != null && compositeStateToUnset.eIsProxy()) {
			InternalEObject oldCompositeStateToUnset = (InternalEObject)compositeStateToUnset;
			compositeStateToUnset = (CompositeState)eResolveProxy(oldCompositeStateToUnset);
			if (compositeStateToUnset != oldCompositeStateToUnset) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET, oldCompositeStateToUnset, compositeStateToUnset));
			}
		}
		return compositeStateToUnset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeState basicGetCompositeStateToUnset() {
		return compositeStateToUnset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeStateToUnset(CompositeState newCompositeStateToUnset) {
		CompositeState oldCompositeStateToUnset = compositeStateToUnset;
		compositeStateToUnset = newCompositeStateToUnset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET, oldCompositeStateToUnset, compositeStateToUnset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getSubstate() {
		if (substate == null) {
			substate = new EObjectResolvingEList<State>(State.class, this, AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE);
		}
		return substate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getInitial() {
		if (initial != null && initial.eIsProxy()) {
			InternalEObject oldInitial = (InternalEObject)initial;
			initial = (State)eResolveProxy(oldInitial);
			if (initial != oldInitial) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL, oldInitial, initial));
			}
		}
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetInitial() {
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitial(State newInitial) {
		State oldInitial = initial;
		initial = newInitial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL, oldInitial, initial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET:
				if (resolve) return getCompositeStateToUnset();
				return basicGetCompositeStateToUnset();
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE:
				return getSubstate();
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL:
				if (resolve) return getInitial();
				return basicGetInitial();
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
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET:
				setCompositeStateToUnset((CompositeState)newValue);
				return;
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE:
				getSubstate().clear();
				getSubstate().addAll((Collection<? extends State>)newValue);
				return;
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL:
				setInitial((State)newValue);
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
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET:
				setCompositeStateToUnset((CompositeState)null);
				return;
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE:
				getSubstate().clear();
				return;
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL:
				setInitial((State)null);
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
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET:
				return compositeStateToUnset != null;
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE:
				return substate != null && !substate.isEmpty();
			case AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL:
				return initial != null;
		}
		return super.eIsSet(featureID);
	}

} //UnsetCompositeStateImpl
