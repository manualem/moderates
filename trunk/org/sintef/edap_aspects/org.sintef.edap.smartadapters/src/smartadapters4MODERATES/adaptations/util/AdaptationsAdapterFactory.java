/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import smartadapters4MODERATES.Adaptation;
import smartadapters4MODERATES.SetAdaptation;
import smartadapters4MODERATES.UnsetAdaptation;

import smartadapters4MODERATES.adaptations.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage
 * @generated
 */
public class AdaptationsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AdaptationsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdaptationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AdaptationsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdaptationsSwitch<Adapter> modelSwitch =
		new AdaptationsSwitch<Adapter>() {
			@Override
			public Adapter caseSetCompositeState(SetCompositeState object) {
				return createSetCompositeStateAdapter();
			}
			@Override
			public Adapter caseUnsetCompositeState(UnsetCompositeState object) {
				return createUnsetCompositeStateAdapter();
			}
			@Override
			public Adapter caseSetState(SetState object) {
				return createSetStateAdapter();
			}
			@Override
			public Adapter caseUnsetState(UnsetState object) {
				return createUnsetStateAdapter();
			}
			@Override
			public Adapter caseSetTransition(SetTransition object) {
				return createSetTransitionAdapter();
			}
			@Override
			public Adapter caseUnsetTransition(UnsetTransition object) {
				return createUnsetTransitionAdapter();
			}
			@Override
			public Adapter caseSetAnnotatedElement(SetAnnotatedElement object) {
				return createSetAnnotatedElementAdapter();
			}
			@Override
			public Adapter caseSetActionBlock(SetActionBlock object) {
				return createSetActionBlockAdapter();
			}
			@Override
			public Adapter caseAdaptation(Adaptation object) {
				return createAdaptationAdapter();
			}
			@Override
			public Adapter caseSetAdaptation(SetAdaptation object) {
				return createSetAdaptationAdapter();
			}
			@Override
			public Adapter caseUnsetAdaptation(UnsetAdaptation object) {
				return createUnsetAdaptationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.adaptations.SetCompositeState <em>Set Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.adaptations.SetCompositeState
	 * @generated
	 */
	public Adapter createSetCompositeStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.adaptations.UnsetCompositeState <em>Unset Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.adaptations.UnsetCompositeState
	 * @generated
	 */
	public Adapter createUnsetCompositeStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.adaptations.SetState <em>Set State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.adaptations.SetState
	 * @generated
	 */
	public Adapter createSetStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.adaptations.UnsetState <em>Unset State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.adaptations.UnsetState
	 * @generated
	 */
	public Adapter createUnsetStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.adaptations.SetTransition <em>Set Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.adaptations.SetTransition
	 * @generated
	 */
	public Adapter createSetTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.adaptations.UnsetTransition <em>Unset Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.adaptations.UnsetTransition
	 * @generated
	 */
	public Adapter createUnsetTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.adaptations.SetAnnotatedElement <em>Set Annotated Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.adaptations.SetAnnotatedElement
	 * @generated
	 */
	public Adapter createSetAnnotatedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.adaptations.SetActionBlock <em>Set Action Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.adaptations.SetActionBlock
	 * @generated
	 */
	public Adapter createSetActionBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.Adaptation <em>Adaptation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.Adaptation
	 * @generated
	 */
	public Adapter createAdaptationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.SetAdaptation <em>Set Adaptation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.SetAdaptation
	 * @generated
	 */
	public Adapter createSetAdaptationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link smartadapters4MODERATES.UnsetAdaptation <em>Unset Adaptation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see smartadapters4MODERATES.UnsetAdaptation
	 * @generated
	 */
	public Adapter createUnsetAdaptationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AdaptationsAdapterFactory
