/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.EdapModel#getTypes <em>Types</em>}</li>
 *   <li>{@link edap.EdapModel#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getEdapModel()
 * @model
 * @generated
 */
public interface EdapModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link edap.Type}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see edap.EdapPackage#getEdapModel_Types()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTypes();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link edap.EdapModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see edap.EdapPackage#getEdapModel_Imports()
	 * @model
	 * @generated
	 */
	EList<EdapModel> getImports();

} // EdapModel
