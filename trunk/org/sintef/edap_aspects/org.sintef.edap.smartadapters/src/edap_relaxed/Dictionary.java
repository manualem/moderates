/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dictionary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.Dictionary#getIndexType <em>Index Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getDictionary()
 * @model
 * @generated
 */
public interface Dictionary extends Property {
	/**
	 * Returns the value of the '<em><b>Index Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Type</em>' reference.
	 * @see #setIndexType(Type)
	 * @see edap_relaxed.Edap_relaxedPackage#getDictionary_IndexType()
	 * @model required="true"
	 * @generated
	 */
	Type getIndexType();

	/**
	 * Sets the value of the '{@link edap_relaxed.Dictionary#getIndexType <em>Index Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Type</em>' reference.
	 * @see #getIndexType()
	 * @generated
	 */
	void setIndexType(Type value);

} // Dictionary
