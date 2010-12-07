/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations.impl;

import edap_relaxed.Action;
import edap_relaxed.Event;
import edap_relaxed.Expression;
import edap_relaxed.State;
import edap_relaxed.Transition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import smartadapters4MODERATES.adaptations.AdaptationsPackage;
import smartadapters4MODERATES.adaptations.SetTransition;

import smartadapters4MODERATES.impl.SetAdaptationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetTransitionImpl#getTransitionToSet <em>Transition To Set</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetTransitionImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetTransitionImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetTransitionImpl#getAction <em>Action</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetTransitionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetTransitionImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetTransitionImpl extends SetAdaptationImpl implements SetTransition {
	/**
	 * The cached value of the '{@link #getTransitionToSet() <em>Transition To Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionToSet()
	 * @generated
	 * @ordered
	 */
	protected Transition transitionToSet;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> event;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected Expression guard;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected State target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected State source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptationsPackage.Literals.SET_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getTransitionToSet() {
		if (transitionToSet != null && transitionToSet.eIsProxy()) {
			InternalEObject oldTransitionToSet = (InternalEObject)transitionToSet;
			transitionToSet = (Transition)eResolveProxy(oldTransitionToSet);
			if (transitionToSet != oldTransitionToSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET, oldTransitionToSet, transitionToSet));
			}
		}
		return transitionToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition basicGetTransitionToSet() {
		return transitionToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionToSet(Transition newTransitionToSet) {
		Transition oldTransitionToSet = transitionToSet;
		transitionToSet = newTransitionToSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET, oldTransitionToSet, transitionToSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvent() {
		if (event == null) {
			event = new EObjectResolvingEList<Event>(Event.class, this, AdaptationsPackage.SET_TRANSITION__EVENT);
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getGuard() {
		if (guard != null && guard.eIsProxy()) {
			InternalEObject oldGuard = (InternalEObject)guard;
			guard = (Expression)eResolveProxy(oldGuard);
			if (guard != oldGuard) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_TRANSITION__GUARD, oldGuard, guard));
			}
		}
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(Expression newGuard) {
		Expression oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_TRANSITION__GUARD, oldGuard, guard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_TRANSITION__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_TRANSITION__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (State)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_TRANSITION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(State newTarget) {
		State oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_TRANSITION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (State)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_TRANSITION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(State newSource) {
		State oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_TRANSITION__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET:
				if (resolve) return getTransitionToSet();
				return basicGetTransitionToSet();
			case AdaptationsPackage.SET_TRANSITION__EVENT:
				return getEvent();
			case AdaptationsPackage.SET_TRANSITION__GUARD:
				if (resolve) return getGuard();
				return basicGetGuard();
			case AdaptationsPackage.SET_TRANSITION__ACTION:
				if (resolve) return getAction();
				return basicGetAction();
			case AdaptationsPackage.SET_TRANSITION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case AdaptationsPackage.SET_TRANSITION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
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
			case AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET:
				setTransitionToSet((Transition)newValue);
				return;
			case AdaptationsPackage.SET_TRANSITION__EVENT:
				getEvent().clear();
				getEvent().addAll((Collection<? extends Event>)newValue);
				return;
			case AdaptationsPackage.SET_TRANSITION__GUARD:
				setGuard((Expression)newValue);
				return;
			case AdaptationsPackage.SET_TRANSITION__ACTION:
				setAction((Action)newValue);
				return;
			case AdaptationsPackage.SET_TRANSITION__TARGET:
				setTarget((State)newValue);
				return;
			case AdaptationsPackage.SET_TRANSITION__SOURCE:
				setSource((State)newValue);
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
			case AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET:
				setTransitionToSet((Transition)null);
				return;
			case AdaptationsPackage.SET_TRANSITION__EVENT:
				getEvent().clear();
				return;
			case AdaptationsPackage.SET_TRANSITION__GUARD:
				setGuard((Expression)null);
				return;
			case AdaptationsPackage.SET_TRANSITION__ACTION:
				setAction((Action)null);
				return;
			case AdaptationsPackage.SET_TRANSITION__TARGET:
				setTarget((State)null);
				return;
			case AdaptationsPackage.SET_TRANSITION__SOURCE:
				setSource((State)null);
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
			case AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET:
				return transitionToSet != null;
			case AdaptationsPackage.SET_TRANSITION__EVENT:
				return event != null && !event.isEmpty();
			case AdaptationsPackage.SET_TRANSITION__GUARD:
				return guard != null;
			case AdaptationsPackage.SET_TRANSITION__ACTION:
				return action != null;
			case AdaptationsPackage.SET_TRANSITION__TARGET:
				return target != null;
			case AdaptationsPackage.SET_TRANSITION__SOURCE:
				return source != null;
		}
		return super.eIsSet(featureID);
	}

} //SetTransitionImpl
