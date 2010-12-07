/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage
 * @generated
 */
public interface Smartadapters4MODERATESFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Smartadapters4MODERATESFactory eINSTANCE = smartadapters4MODERATES.impl.Smartadapters4MODERATESFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Aspect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aspect</em>'.
	 * @generated
	 */
	Aspect createAspect();

	/**
	 * Returns a new object of class '<em>Advice Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Advice Model</em>'.
	 * @generated
	 */
	AdviceModel createAdviceModel();

	/**
	 * Returns a new object of class '<em>Pointcut Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pointcut Model</em>'.
	 * @generated
	 */
	PointcutModel createPointcutModel();

	/**
	 * Returns a new object of class '<em>Global Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Global Instantiation</em>'.
	 * @generated
	 */
	GlobalInstantiation createGlobalInstantiation();

	/**
	 * Returns a new object of class '<em>Per Role Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Per Role Match</em>'.
	 * @generated
	 */
	PerRoleMatch createPerRoleMatch();

	/**
	 * Returns a new object of class '<em>Per Element Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Per Element Match</em>'.
	 * @generated
	 */
	PerElementMatch createPerElementMatch();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Smartadapters4MODERATESPackage getSmartadapters4MODERATESPackage();

} //Smartadapters4MODERATESFactory
