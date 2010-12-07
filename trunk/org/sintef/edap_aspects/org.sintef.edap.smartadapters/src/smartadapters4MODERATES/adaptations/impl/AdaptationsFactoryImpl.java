/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import smartadapters4MODERATES.adaptations.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AdaptationsFactoryImpl extends EFactoryImpl implements AdaptationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AdaptationsFactory init() {
		try {
			AdaptationsFactory theAdaptationsFactory = (AdaptationsFactory)EPackage.Registry.INSTANCE.getEFactory("http://SmartAdapters4ART/smartadapters/core/adaptations"); 
			if (theAdaptationsFactory != null) {
				return theAdaptationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AdaptationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdaptationsFactoryImpl() {
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
			case AdaptationsPackage.SET_COMPOSITE_STATE: return createSetCompositeState();
			case AdaptationsPackage.UNSET_COMPOSITE_STATE: return createUnsetCompositeState();
			case AdaptationsPackage.SET_STATE: return createSetState();
			case AdaptationsPackage.UNSET_STATE: return createUnsetState();
			case AdaptationsPackage.SET_TRANSITION: return createSetTransition();
			case AdaptationsPackage.UNSET_TRANSITION: return createUnsetTransition();
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT: return createSetAnnotatedElement();
			case AdaptationsPackage.SET_ACTION_BLOCK: return createSetActionBlock();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetCompositeState createSetCompositeState() {
		SetCompositeStateImpl setCompositeState = new SetCompositeStateImpl();
		return setCompositeState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnsetCompositeState createUnsetCompositeState() {
		UnsetCompositeStateImpl unsetCompositeState = new UnsetCompositeStateImpl();
		return unsetCompositeState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetState createSetState() {
		SetStateImpl setState = new SetStateImpl();
		return setState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnsetState createUnsetState() {
		UnsetStateImpl unsetState = new UnsetStateImpl();
		return unsetState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTransition createSetTransition() {
		SetTransitionImpl setTransition = new SetTransitionImpl();
		return setTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnsetTransition createUnsetTransition() {
		UnsetTransitionImpl unsetTransition = new UnsetTransitionImpl();
		return unsetTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetAnnotatedElement createSetAnnotatedElement() {
		SetAnnotatedElementImpl setAnnotatedElement = new SetAnnotatedElementImpl();
		return setAnnotatedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetActionBlock createSetActionBlock() {
		SetActionBlockImpl setActionBlock = new SetActionBlockImpl();
		return setActionBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdaptationsPackage getAdaptationsPackage() {
		return (AdaptationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AdaptationsPackage getPackage() {
		return AdaptationsPackage.eINSTANCE;
	}

} //AdaptationsFactoryImpl
