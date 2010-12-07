/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edap Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.EdapModel#getTypes <em>Types</em>}</li>
 *   <li>{@link edap_relaxed.EdapModel#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getEdapModel()
 * @model
 * @generated
 */
public interface EdapModel extends AspectModelElement {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getEdapModel_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.EdapModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getEdapModel_Imports()
	 * @model
	 * @generated
	 */
	EList<EdapModel> getImports();

} // EdapModel
