/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.Aspect#getName <em>Name</em>}</li>
 *   <li>{@link smartadapters4MODERATES.Aspect#getPointcut <em>Pointcut</em>}</li>
 *   <li>{@link smartadapters4MODERATES.Aspect#getAdvice <em>Advice</em>}</li>
 *   <li>{@link smartadapters4MODERATES.Aspect#getStrategies <em>Strategies</em>}</li>
 *   <li>{@link smartadapters4MODERATES.Aspect#getAdapt <em>Adapt</em>}</li>
 * </ul>
 * </p>
 *
 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getAspect()
 * @model
 * @generated
 */
public interface Aspect extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getAspect_Name()
	 * @model dataType="smartadapters4MODERATES.String"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.Aspect#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Pointcut</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pointcut</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pointcut</em>' containment reference.
	 * @see #setPointcut(PointcutModel)
	 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getAspect_Pointcut()
	 * @model containment="true"
	 * @generated
	 */
	PointcutModel getPointcut();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.Aspect#getPointcut <em>Pointcut</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pointcut</em>' containment reference.
	 * @see #getPointcut()
	 * @generated
	 */
	void setPointcut(PointcutModel value);

	/**
	 * Returns the value of the '<em><b>Advice</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advice</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advice</em>' containment reference.
	 * @see #setAdvice(AdviceModel)
	 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getAspect_Advice()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AdviceModel getAdvice();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.Aspect#getAdvice <em>Advice</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Advice</em>' containment reference.
	 * @see #getAdvice()
	 * @generated
	 */
	void setAdvice(AdviceModel value);

	/**
	 * Returns the value of the '<em><b>Strategies</b></em>' containment reference list.
	 * The list contents are of type {@link smartadapters4MODERATES.InstantiationStrategy}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategies</em>' containment reference list.
	 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getAspect_Strategies()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstantiationStrategy> getStrategies();

	/**
	 * Returns the value of the '<em><b>Adapt</b></em>' containment reference list.
	 * The list contents are of type {@link smartadapters4MODERATES.Adaptation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adapt</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adapt</em>' containment reference list.
	 * @see smartadapters4MODERATES.Smartadapters4MODERATESPackage#getAspect_Adapt()
	 * @model containment="true"
	 * @generated
	 */
	EList<Adaptation> getAdapt();

} // Aspect
