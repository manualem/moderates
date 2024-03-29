/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES;

import edap_relaxed.AspectModelElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scoped Instantiation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.ScopedInstantiation#getPointcutElements <em>Pointcut Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getScopedInstantiation()
 * @model abstract="true"
 * @generated
 */
public interface ScopedInstantiation extends InstantiationStrategy {
	/**
	 * Returns the value of the '<em><b>Pointcut Elements</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.AspectModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pointcut Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pointcut Elements</em>' reference list.
	 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getScopedInstantiation_PointcutElements()
	 * @model
	 * @generated
	 */
	EList<AspectModelElement> getPointcutElements();

} // ScopedInstantiation
