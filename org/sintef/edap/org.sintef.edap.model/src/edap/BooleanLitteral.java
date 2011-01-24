/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Litteral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.BooleanLitteral#isBoolValue <em>Bool Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getBooleanLitteral()
 * @model
 * @generated
 */
public interface BooleanLitteral extends Litteral {
	/**
	 * Returns the value of the '<em><b>Bool Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bool Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bool Value</em>' attribute.
	 * @see #setBoolValue(boolean)
	 * @see edap.EdapPackage#getBooleanLitteral_BoolValue()
	 * @model required="true"
	 * @generated
	 */
	boolean isBoolValue();

	/**
	 * Sets the value of the '{@link edap.BooleanLitteral#isBoolValue <em>Bool Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bool Value</em>' attribute.
	 * @see #isBoolValue()
	 * @generated
	 */
	void setBoolValue(boolean value);

} // BooleanLitteral
