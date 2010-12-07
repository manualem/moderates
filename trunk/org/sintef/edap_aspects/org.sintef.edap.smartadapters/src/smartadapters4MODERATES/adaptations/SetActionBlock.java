/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations;

import edap_relaxed.Action;
import edap_relaxed.ActionBlock;

import org.eclipse.emf.common.util.EList;

import smartadapters4MODERATES.SetAdaptation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Action Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetActionBlock#getBlockToSet <em>Block To Set</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetActionBlock#getActions <em>Actions</em>}</li>
 * </ul>
 * </p>
 *
 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetActionBlock()
 * @model
 * @generated
 */
public interface SetActionBlock extends SetAdaptation {
	/**
	 * Returns the value of the '<em><b>Block To Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block To Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block To Set</em>' reference.
	 * @see #setBlockToSet(ActionBlock)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetActionBlock_BlockToSet()
	 * @model required="true"
	 * @generated
	 */
	ActionBlock getBlockToSet();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.SetActionBlock#getBlockToSet <em>Block To Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block To Set</em>' reference.
	 * @see #getBlockToSet()
	 * @generated
	 */
	void setBlockToSet(ActionBlock value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' reference list.
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetActionBlock_Actions()
	 * @model
	 * @generated
	 */
	EList<Action> getActions();

} // SetActionBlock
