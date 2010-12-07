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
import smartadapters4MODERATES.adaptations.SetCompositeState;

import smartadapters4MODERATES.impl.SetAdaptationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Composite State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetCompositeStateImpl#getCompositeStateToSet <em>Composite State To Set</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetCompositeStateImpl#getSubstate <em>Substate</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetCompositeStateImpl#getInitial <em>Initial</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetCompositeStateImpl extends SetAdaptationImpl implements SetCompositeState {
	/**
	 * The cached value of the '{@link #getCompositeStateToSet() <em>Composite State To Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeStateToSet()
	 * @generated
	 * @ordered
	 */
	protected CompositeState compositeStateToSet;

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
	protected SetCompositeStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptationsPackage.Literals.SET_COMPOSITE_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeState getCompositeStateToSet() {
		if (compositeStateToSet != null && compositeStateToSet.eIsProxy()) {
			InternalEObject oldCompositeStateToSet = (InternalEObject)compositeStateToSet;
			compositeStateToSet = (CompositeState)eResolveProxy(oldCompositeStateToSet);
			if (compositeStateToSet != oldCompositeStateToSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET, oldCompositeStateToSet, compositeStateToSet));
			}
		}
		return compositeStateToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeState basicGetCompositeStateToSet() {
		return compositeStateToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositeStateToSet(CompositeState newCompositeStateToSet) {
		CompositeState oldCompositeStateToSet = compositeStateToSet;
		compositeStateToSet = newCompositeStateToSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET, oldCompositeStateToSet, compositeStateToSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getSubstate() {
		if (substate == null) {
			substate = new EObjectResolvingEList<State>(State.class, this, AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL, oldInitial, initial));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL, oldInitial, initial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET:
				if (resolve) return getCompositeStateToSet();
				return basicGetCompositeStateToSet();
			case AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE:
				return getSubstate();
			case AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL:
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
			case AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET:
				setCompositeStateToSet((CompositeState)newValue);
				return;
			case AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE:
				getSubstate().clear();
				getSubstate().addAll((Collection<? extends State>)newValue);
				return;
			case AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL:
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
			case AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET:
				setCompositeStateToSet((CompositeState)null);
				return;
			case AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE:
				getSubstate().clear();
				return;
			case AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL:
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
			case AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET:
				return compositeStateToSet != null;
			case AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE:
				return substate != null && !substate.isEmpty();
			case AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL:
				return initial != null;
		}
		return super.eIsSet(featureID);
	}

} //SetCompositeStateImpl
