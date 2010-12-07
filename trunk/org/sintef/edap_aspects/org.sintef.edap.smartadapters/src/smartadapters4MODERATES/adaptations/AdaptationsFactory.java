/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage
 * @generated
 */
public interface AdaptationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AdaptationsFactory eINSTANCE = smartadapters4MODERATES.adaptations.impl.AdaptationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Set Composite State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Composite State</em>'.
	 * @generated
	 */
	SetCompositeState createSetCompositeState();

	/**
	 * Returns a new object of class '<em>Unset Composite State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unset Composite State</em>'.
	 * @generated
	 */
	UnsetCompositeState createUnsetCompositeState();

	/**
	 * Returns a new object of class '<em>Set State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set State</em>'.
	 * @generated
	 */
	SetState createSetState();

	/**
	 * Returns a new object of class '<em>Unset State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unset State</em>'.
	 * @generated
	 */
	UnsetState createUnsetState();

	/**
	 * Returns a new object of class '<em>Set Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Transition</em>'.
	 * @generated
	 */
	SetTransition createSetTransition();

	/**
	 * Returns a new object of class '<em>Unset Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unset Transition</em>'.
	 * @generated
	 */
	UnsetTransition createUnsetTransition();

	/**
	 * Returns a new object of class '<em>Set Annotated Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Annotated Element</em>'.
	 * @generated
	 */
	SetAnnotatedElement createSetAnnotatedElement();

	/**
	 * Returns a new object of class '<em>Set Action Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Action Block</em>'.
	 * @generated
	 */
	SetActionBlock createSetActionBlock();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AdaptationsPackage getAdaptationsPackage();

} //AdaptationsFactory
