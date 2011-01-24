/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Litteral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.IntegerLitteral#getIntValue <em>Int Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getIntegerLitteral()
 * @model
 * @generated
 */
public interface IntegerLitteral extends Litteral {
	/**
	 * Returns the value of the '<em><b>Int Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Int Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Int Value</em>' attribute.
	 * @see #setIntValue(int)
	 * @see edap.EdapPackage#getIntegerLitteral_IntValue()
	 * @model required="true"
	 * @generated
	 */
	int getIntValue();

	/**
	 * Sets the value of the '{@link edap.IntegerLitteral#getIntValue <em>Int Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Int Value</em>' attribute.
	 * @see #getIntValue()
	 * @generated
	 */
	void setIntValue(int value);

} // IntegerLitteral
