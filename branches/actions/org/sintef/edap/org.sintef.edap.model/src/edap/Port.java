/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.Port#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getPort()
 * @model
 * @generated
 */
public interface Port extends AnnotatedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edap.Component#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Component)
	 * @see edap.EdapPackage#getPort_Owner()
	 * @see edap.Component#getPorts
	 * @model opposite="ports" transient="false"
	 * @generated
	 */
	Component getOwner();

	/**
	 * Sets the value of the '{@link edap.Port#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Component value);

} // Port
