/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Print Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.PrintAction#getMsg <em>Msg</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getPrintAction()
 * @model
 * @generated
 */
public interface PrintAction extends Action {
	/**
	 * Returns the value of the '<em><b>Msg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Msg</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Msg</em>' containment reference.
	 * @see #setMsg(Expression)
	 * @see edap.EdapPackage#getPrintAction_Msg()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getMsg();

	/**
	 * Sets the value of the '{@link edap.PrintAction#getMsg <em>Msg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Msg</em>' containment reference.
	 * @see #getMsg()
	 * @generated
	 */
	void setMsg(Expression value);

} // PrintAction
