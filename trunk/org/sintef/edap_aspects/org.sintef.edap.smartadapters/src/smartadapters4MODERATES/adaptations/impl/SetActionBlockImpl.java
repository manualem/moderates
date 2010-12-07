/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations.impl;

import edap_relaxed.Action;
import edap_relaxed.ActionBlock;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import smartadapters4MODERATES.adaptations.AdaptationsPackage;
import smartadapters4MODERATES.adaptations.SetActionBlock;

import smartadapters4MODERATES.impl.SetAdaptationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Action Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetActionBlockImpl#getBlockToSet <em>Block To Set</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetActionBlockImpl#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetActionBlockImpl extends SetAdaptationImpl implements SetActionBlock {
	/**
	 * The cached value of the '{@link #getBlockToSet() <em>Block To Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlockToSet()
	 * @generated
	 * @ordered
	 */
	protected ActionBlock blockToSet;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<Action> actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetActionBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptationsPackage.Literals.SET_ACTION_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionBlock getBlockToSet() {
		if (blockToSet != null && blockToSet.eIsProxy()) {
			InternalEObject oldBlockToSet = (InternalEObject)blockToSet;
			blockToSet = (ActionBlock)eResolveProxy(oldBlockToSet);
			if (blockToSet != oldBlockToSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET, oldBlockToSet, blockToSet));
			}
		}
		return blockToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionBlock basicGetBlockToSet() {
		return blockToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlockToSet(ActionBlock newBlockToSet) {
		ActionBlock oldBlockToSet = blockToSet;
		blockToSet = newBlockToSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET, oldBlockToSet, blockToSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Action> getActions() {
		if (actions == null) {
			actions = new EObjectResolvingEList<Action>(Action.class, this, AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET:
				if (resolve) return getBlockToSet();
				return basicGetBlockToSet();
			case AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS:
				return getActions();
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
			case AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET:
				setBlockToSet((ActionBlock)newValue);
				return;
			case AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends Action>)newValue);
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
			case AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET:
				setBlockToSet((ActionBlock)null);
				return;
			case AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS:
				getActions().clear();
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
			case AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET:
				return blockToSet != null;
			case AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS:
				return actions != null && !actions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SetActionBlockImpl
