/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.CreateAction#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getCreateAction()
 * @model
 * @generated
 */
public interface CreateAction extends Action {
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' containment reference.
	 * @see #setRef(ComponentReference)
	 * @see edap.EdapPackage#getCreateAction_Ref()
	 * @model containment="true"
	 * @generated
	 */
	ComponentReference getRef();

	/**
	 * Sets the value of the '{@link edap.CreateAction#getRef <em>Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' containment reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(ComponentReference value);

} // CreateAction
