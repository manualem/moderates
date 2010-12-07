/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.AspectModelElement#getAspectID <em>Aspect ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getAspectModelElement()
 * @model abstract="true"
 * @generated
 */
public interface AspectModelElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Aspect ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aspect ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect ID</em>' attribute.
	 * @see #setAspectID(String)
	 * @see edap_relaxed.Edap_relaxedPackage#getAspectModelElement_AspectID()
	 * @model required="true"
	 * @generated
	 */
	String getAspectID();

	/**
	 * Sets the value of the '{@link edap_relaxed.AspectModelElement#getAspectID <em>Aspect ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect ID</em>' attribute.
	 * @see #getAspectID()
	 * @generated
	 */
	void setAspectID(String value);

} // AspectModelElement
