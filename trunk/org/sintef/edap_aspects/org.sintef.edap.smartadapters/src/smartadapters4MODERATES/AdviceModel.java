/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES;

import edap_relaxed.AspectModelElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advice Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.AdviceModel#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getAdviceModel()
 * @model
 * @generated
 */
public interface AdviceModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.AspectModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' containment reference list.
	 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getAdviceModel_Content()
	 * @model containment="true"
	 * @generated
	 */
	EList<AspectModelElement> getContent();

} // AdviceModel
