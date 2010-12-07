/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Platform Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.PlatformAnnotation#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getPlatformAnnotation()
 * @model
 * @generated
 */
public interface PlatformAnnotation extends EdapElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see edap_relaxed.Edap_relaxedPackage#getPlatformAnnotation_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link edap_relaxed.PlatformAnnotation#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // PlatformAnnotation
