/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Litteral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.StringLitteral#getStringValue <em>String Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getStringLitteral()
 * @model
 * @generated
 */
public interface StringLitteral extends Litteral {
	/**
	 * Returns the value of the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Value</em>' attribute.
	 * @see #setStringValue(String)
	 * @see edap.EdapPackage#getStringLitteral_StringValue()
	 * @model required="true"
	 * @generated
	 */
	String getStringValue();

	/**
	 * Sets the value of the '{@link edap.StringLitteral#getStringValue <em>String Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Value</em>' attribute.
	 * @see #getStringValue()
	 * @generated
	 */
	void setStringValue(String value);

} // StringLitteral
