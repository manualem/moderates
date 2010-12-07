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
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.Message#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edap_relaxed.Message#isAllowMulticast <em>Allow Multicast</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getMessage()
 * @model
 * @generated
 */
public interface Message extends AnnotatedElement {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getMessage_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Allow Multicast</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allow Multicast</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Multicast</em>' attribute.
	 * @see #setAllowMulticast(boolean)
	 * @see edap_relaxed.Edap_relaxedPackage#getMessage_AllowMulticast()
	 * @model ordered="false"
	 * @generated
	 */
	boolean isAllowMulticast();

	/**
	 * Sets the value of the '{@link edap_relaxed.Message#isAllowMulticast <em>Allow Multicast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Multicast</em>' attribute.
	 * @see #isAllowMulticast()
	 * @generated
	 */
	void setAllowMulticast(boolean value);

} // Message
