/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Litteral</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.DoubleLitteral#getDoubleValue <em>Double Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getDoubleLitteral()
 * @model
 * @generated
 */
public interface DoubleLitteral extends Litteral {
	/**
	 * Returns the value of the '<em><b>Double Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Double Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double Value</em>' attribute.
	 * @see #setDoubleValue(double)
	 * @see edap.EdapPackage#getDoubleLitteral_DoubleValue()
	 * @model required="true"
	 * @generated
	 */
	double getDoubleValue();

	/**
	 * Sets the value of the '{@link edap.DoubleLitteral#getDoubleValue <em>Double Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Value</em>' attribute.
	 * @see #getDoubleValue()
	 * @generated
	 */
	void setDoubleValue(double value);

} // DoubleLitteral
