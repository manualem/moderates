/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extern Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.ExternStatement#getStatement <em>Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getExternStatement()
 * @model
 * @generated
 */
public interface ExternStatement extends Action {
	/**
	 * Returns the value of the '<em><b>Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' attribute.
	 * @see #setStatement(String)
	 * @see edap_relaxed.Edap_relaxedPackage#getExternStatement_Statement()
	 * @model required="true"
	 * @generated
	 */
	String getStatement();

	/**
	 * Sets the value of the '{@link edap_relaxed.ExternStatement#getStatement <em>Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' attribute.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(String value);

} // ExternStatement
