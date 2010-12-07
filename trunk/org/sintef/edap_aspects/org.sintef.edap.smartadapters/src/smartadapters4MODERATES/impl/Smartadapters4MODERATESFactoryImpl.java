/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import smartadapters4MODERATES.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Smartadapters4MODERATESFactoryImpl extends EFactoryImpl implements Smartadapters4MODERATESFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Smartadapters4MODERATESFactory init() {
		try {
			Smartadapters4MODERATESFactory theSmartadapters4MODERATESFactory = (Smartadapters4MODERATESFactory)EPackage.Registry.INSTANCE.getEFactory("http://SmartAdapters4MODERATES"); 
			if (theSmartadapters4MODERATESFactory != null) {
				return theSmartadapters4MODERATESFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Smartadapters4MODERATESFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Smartadapters4MODERATESFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Smartadapters4MODERATESPackage.ASPECT: return createAspect();
			case Smartadapters4MODERATESPackage.ADVICE_MODEL: return createAdviceModel();
			case Smartadapters4MODERATESPackage.POINTCUT_MODEL: return createPointcutModel();
			case Smartadapters4MODERATESPackage.GLOBAL_INSTANTIATION: return createGlobalInstantiation();
			case Smartadapters4MODERATESPackage.PER_ROLE_MATCH: return createPerRoleMatch();
			case Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH: return createPerElementMatch();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Smartadapters4MODERATESPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Smartadapters4MODERATESPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aspect createAspect() {
		AspectImpl aspect = new AspectImpl();
		return aspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdviceModel createAdviceModel() {
		AdviceModelImpl adviceModel = new AdviceModelImpl();
		return adviceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PointcutModel createPointcutModel() {
		PointcutModelImpl pointcutModel = new PointcutModelImpl();
		return pointcutModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalInstantiation createGlobalInstantiation() {
		GlobalInstantiationImpl globalInstantiation = new GlobalInstantiationImpl();
		return globalInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerRoleMatch createPerRoleMatch() {
		PerRoleMatchImpl perRoleMatch = new PerRoleMatchImpl();
		return perRoleMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerElementMatch createPerElementMatch() {
		PerElementMatchImpl perElementMatch = new PerElementMatchImpl();
		return perElementMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Smartadapters4MODERATESPackage getSmartadapters4MODERATESPackage() {
		return (Smartadapters4MODERATESPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Smartadapters4MODERATESPackage getPackage() {
		return Smartadapters4MODERATESPackage.eINSTANCE;
	}

} //Smartadapters4MODERATESFactoryImpl
