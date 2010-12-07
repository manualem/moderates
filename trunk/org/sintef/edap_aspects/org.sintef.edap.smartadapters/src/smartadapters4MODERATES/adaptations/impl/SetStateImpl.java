/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations.impl;

import edap_relaxed.Action;
import edap_relaxed.Property;
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
import smartadapters4MODERATES.adaptations.SetState;

import smartadapters4MODERATES.impl.SetAdaptationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetStateImpl#getStateToSet <em>State To Set</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetStateImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetStateImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetStateImpl#getEntry <em>Entry</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetStateImpl#getExit <em>Exit</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetStateImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetStateImpl extends SetAdaptationImpl implements SetState {
	/**
	 * The cached value of the '{@link #getStateToSet() <em>State To Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateToSet()
	 * @generated
	 * @ordered
	 */
	protected State stateToSet;

	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outgoing;

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> incoming;

	/**
	 * The cached value of the '{@link #getEntry() <em>Entry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntry()
	 * @generated
	 * @ordered
	 */
	protected Action entry;

	/**
	 * The cached value of the '{@link #getExit() <em>Exit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExit()
	 * @generated
	 * @ordered
	 */
	protected Action exit;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptationsPackage.Literals.SET_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getStateToSet() {
		if (stateToSet != null && stateToSet.eIsProxy()) {
			InternalEObject oldStateToSet = (InternalEObject)stateToSet;
			stateToSet = (State)eResolveProxy(oldStateToSet);
			if (stateToSet != oldStateToSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_STATE__STATE_TO_SET, oldStateToSet, stateToSet));
			}
		}
		return stateToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetStateToSet() {
		return stateToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateToSet(State newStateToSet) {
		State oldStateToSet = stateToSet;
		stateToSet = newStateToSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_STATE__STATE_TO_SET, oldStateToSet, stateToSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectResolvingEList<Transition>(Transition.class, this, AdaptationsPackage.SET_STATE__OUTGOING);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectResolvingEList<Transition>(Transition.class, this, AdaptationsPackage.SET_STATE__INCOMING);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getEntry() {
		if (entry != null && entry.eIsProxy()) {
			InternalEObject oldEntry = (InternalEObject)entry;
			entry = (Action)eResolveProxy(oldEntry);
			if (entry != oldEntry) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_STATE__ENTRY, oldEntry, entry));
			}
		}
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetEntry() {
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntry(Action newEntry) {
		Action oldEntry = entry;
		entry = newEntry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_STATE__ENTRY, oldEntry, entry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getExit() {
		if (exit != null && exit.eIsProxy()) {
			InternalEObject oldExit = (InternalEObject)exit;
			exit = (Action)eResolveProxy(oldExit);
			if (exit != oldExit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_STATE__EXIT, oldExit, exit));
			}
		}
		return exit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetExit() {
		return exit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExit(Action newExit) {
		Action oldExit = exit;
		exit = newExit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_STATE__EXIT, oldExit, exit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectResolvingEList<Property>(Property.class, this, AdaptationsPackage.SET_STATE__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdaptationsPackage.SET_STATE__STATE_TO_SET:
				if (resolve) return getStateToSet();
				return basicGetStateToSet();
			case AdaptationsPackage.SET_STATE__OUTGOING:
				return getOutgoing();
			case AdaptationsPackage.SET_STATE__INCOMING:
				return getIncoming();
			case AdaptationsPackage.SET_STATE__ENTRY:
				if (resolve) return getEntry();
				return basicGetEntry();
			case AdaptationsPackage.SET_STATE__EXIT:
				if (resolve) return getExit();
				return basicGetExit();
			case AdaptationsPackage.SET_STATE__PROPERTIES:
				return getProperties();
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
			case AdaptationsPackage.SET_STATE__STATE_TO_SET:
				setStateToSet((State)newValue);
				return;
			case AdaptationsPackage.SET_STATE__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends Transition>)newValue);
				return;
			case AdaptationsPackage.SET_STATE__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends Transition>)newValue);
				return;
			case AdaptationsPackage.SET_STATE__ENTRY:
				setEntry((Action)newValue);
				return;
			case AdaptationsPackage.SET_STATE__EXIT:
				setExit((Action)newValue);
				return;
			case AdaptationsPackage.SET_STATE__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
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
			case AdaptationsPackage.SET_STATE__STATE_TO_SET:
				setStateToSet((State)null);
				return;
			case AdaptationsPackage.SET_STATE__OUTGOING:
				getOutgoing().clear();
				return;
			case AdaptationsPackage.SET_STATE__INCOMING:
				getIncoming().clear();
				return;
			case AdaptationsPackage.SET_STATE__ENTRY:
				setEntry((Action)null);
				return;
			case AdaptationsPackage.SET_STATE__EXIT:
				setExit((Action)null);
				return;
			case AdaptationsPackage.SET_STATE__PROPERTIES:
				getProperties().clear();
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
			case AdaptationsPackage.SET_STATE__STATE_TO_SET:
				return stateToSet != null;
			case AdaptationsPackage.SET_STATE__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case AdaptationsPackage.SET_STATE__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case AdaptationsPackage.SET_STATE__ENTRY:
				return entry != null;
			case AdaptationsPackage.SET_STATE__EXIT:
				return exit != null;
			case AdaptationsPackage.SET_STATE__PROPERTIES:
				return properties != null && !properties.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SetStateImpl
