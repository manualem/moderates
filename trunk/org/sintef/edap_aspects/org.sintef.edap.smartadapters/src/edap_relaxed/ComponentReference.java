/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.ComponentReference#getComponent <em>Component</em>}</li>
 *   <li>{@link edap_relaxed.ComponentReference#getPropertyNavigations <em>Property Navigations</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getComponentReference()
 * @model
 * @generated
 */
public interface ComponentReference extends Expression {
	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see edap_relaxed.Edap_relaxedPackage#getComponentReference_Component()
	 * @model required="true"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link edap_relaxed.ComponentReference#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Property Navigations</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.PropertyNavigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Navigations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Navigations</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getComponentReference_PropertyNavigations()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyNavigation> getPropertyNavigations();

} // ComponentReference
