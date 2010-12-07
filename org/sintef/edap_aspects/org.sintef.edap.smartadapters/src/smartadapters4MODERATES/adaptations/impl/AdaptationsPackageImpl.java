/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations.impl;

import edap_relaxed.Edap_relaxedPackage;

import edap_relaxed.impl.Edap_relaxedPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import smartadapters4MODERATES.Smartadapters4MODERATESPackage;

import smartadapters4MODERATES.adaptations.AdaptationsFactory;
import smartadapters4MODERATES.adaptations.AdaptationsPackage;
import smartadapters4MODERATES.adaptations.SetActionBlock;
import smartadapters4MODERATES.adaptations.SetAnnotatedElement;
import smartadapters4MODERATES.adaptations.SetCompositeState;
import smartadapters4MODERATES.adaptations.SetState;
import smartadapters4MODERATES.adaptations.SetTransition;
import smartadapters4MODERATES.adaptations.UnsetCompositeState;
import smartadapters4MODERATES.adaptations.UnsetState;
import smartadapters4MODERATES.adaptations.UnsetTransition;

import smartadapters4MODERATES.impl.Smartadapters4MODERATESPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AdaptationsPackageImpl extends EPackageImpl implements AdaptationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setCompositeStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unsetCompositeStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unsetStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unsetTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setAnnotatedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setActionBlockEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AdaptationsPackageImpl() {
		super(eNS_URI, AdaptationsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link AdaptationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AdaptationsPackage init() {
		if (isInited) return (AdaptationsPackage)EPackage.Registry.INSTANCE.getEPackage(AdaptationsPackage.eNS_URI);

		// Obtain or create and register package
		AdaptationsPackageImpl theAdaptationsPackage = (AdaptationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AdaptationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AdaptationsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Smartadapters4MODERATESPackageImpl theSmartadapters4MODERATESPackage = (Smartadapters4MODERATESPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Smartadapters4MODERATESPackage.eNS_URI) instanceof Smartadapters4MODERATESPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Smartadapters4MODERATESPackage.eNS_URI) : Smartadapters4MODERATESPackage.eINSTANCE);
		Edap_relaxedPackageImpl theEdap_relaxedPackage = (Edap_relaxedPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Edap_relaxedPackage.eNS_URI) instanceof Edap_relaxedPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Edap_relaxedPackage.eNS_URI) : Edap_relaxedPackage.eINSTANCE);

		// Create package meta-data objects
		theAdaptationsPackage.createPackageContents();
		theSmartadapters4MODERATESPackage.createPackageContents();
		theEdap_relaxedPackage.createPackageContents();

		// Initialize created meta-data
		theAdaptationsPackage.initializePackageContents();
		theSmartadapters4MODERATESPackage.initializePackageContents();
		theEdap_relaxedPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAdaptationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AdaptationsPackage.eNS_URI, theAdaptationsPackage);
		return theAdaptationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetCompositeState() {
		return setCompositeStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetCompositeState_CompositeStateToSet() {
		return (EReference)setCompositeStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetCompositeState_Substate() {
		return (EReference)setCompositeStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetCompositeState_Initial() {
		return (EReference)setCompositeStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnsetCompositeState() {
		return unsetCompositeStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetCompositeState_CompositeStateToUnset() {
		return (EReference)unsetCompositeStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetCompositeState_Substate() {
		return (EReference)unsetCompositeStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetCompositeState_Initial() {
		return (EReference)unsetCompositeStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetState() {
		return setStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetState_StateToSet() {
		return (EReference)setStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetState_Outgoing() {
		return (EReference)setStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetState_Incoming() {
		return (EReference)setStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetState_Entry() {
		return (EReference)setStateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetState_Exit() {
		return (EReference)setStateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetState_Properties() {
		return (EReference)setStateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnsetState() {
		return unsetStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetState_StateToUnset() {
		return (EReference)unsetStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetState_Outgoing() {
		return (EReference)unsetStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetState_Incoming() {
		return (EReference)unsetStateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetState_Entry() {
		return (EReference)unsetStateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetState_Exit() {
		return (EReference)unsetStateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetState_Properties() {
		return (EReference)unsetStateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetTransition() {
		return setTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetTransition_TransitionToSet() {
		return (EReference)setTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetTransition_Event() {
		return (EReference)setTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetTransition_Guard() {
		return (EReference)setTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetTransition_Action() {
		return (EReference)setTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetTransition_Target() {
		return (EReference)setTransitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetTransition_Source() {
		return (EReference)setTransitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnsetTransition() {
		return unsetTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetTransition_TransitionToUnset() {
		return (EReference)unsetTransitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetTransition_Event() {
		return (EReference)unsetTransitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetTransition_Guard() {
		return (EReference)unsetTransitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetTransition_Action() {
		return (EReference)unsetTransitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetTransition_Target() {
		return (EReference)unsetTransitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnsetTransition_Source() {
		return (EReference)unsetTransitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetAnnotatedElement() {
		return setAnnotatedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetAnnotatedElement_AnnotatedElementToSet() {
		return (EReference)setAnnotatedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetAnnotatedElement_Annotations() {
		return (EReference)setAnnotatedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetActionBlock() {
		return setActionBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetActionBlock_BlockToSet() {
		return (EReference)setActionBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetActionBlock_Actions() {
		return (EReference)setActionBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdaptationsFactory getAdaptationsFactory() {
		return (AdaptationsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		setCompositeStateEClass = createEClass(SET_COMPOSITE_STATE);
		createEReference(setCompositeStateEClass, SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET);
		createEReference(setCompositeStateEClass, SET_COMPOSITE_STATE__SUBSTATE);
		createEReference(setCompositeStateEClass, SET_COMPOSITE_STATE__INITIAL);

		unsetCompositeStateEClass = createEClass(UNSET_COMPOSITE_STATE);
		createEReference(unsetCompositeStateEClass, UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET);
		createEReference(unsetCompositeStateEClass, UNSET_COMPOSITE_STATE__SUBSTATE);
		createEReference(unsetCompositeStateEClass, UNSET_COMPOSITE_STATE__INITIAL);

		setStateEClass = createEClass(SET_STATE);
		createEReference(setStateEClass, SET_STATE__STATE_TO_SET);
		createEReference(setStateEClass, SET_STATE__OUTGOING);
		createEReference(setStateEClass, SET_STATE__INCOMING);
		createEReference(setStateEClass, SET_STATE__ENTRY);
		createEReference(setStateEClass, SET_STATE__EXIT);
		createEReference(setStateEClass, SET_STATE__PROPERTIES);

		unsetStateEClass = createEClass(UNSET_STATE);
		createEReference(unsetStateEClass, UNSET_STATE__STATE_TO_UNSET);
		createEReference(unsetStateEClass, UNSET_STATE__OUTGOING);
		createEReference(unsetStateEClass, UNSET_STATE__INCOMING);
		createEReference(unsetStateEClass, UNSET_STATE__ENTRY);
		createEReference(unsetStateEClass, UNSET_STATE__EXIT);
		createEReference(unsetStateEClass, UNSET_STATE__PROPERTIES);

		setTransitionEClass = createEClass(SET_TRANSITION);
		createEReference(setTransitionEClass, SET_TRANSITION__TRANSITION_TO_SET);
		createEReference(setTransitionEClass, SET_TRANSITION__EVENT);
		createEReference(setTransitionEClass, SET_TRANSITION__GUARD);
		createEReference(setTransitionEClass, SET_TRANSITION__ACTION);
		createEReference(setTransitionEClass, SET_TRANSITION__TARGET);
		createEReference(setTransitionEClass, SET_TRANSITION__SOURCE);

		unsetTransitionEClass = createEClass(UNSET_TRANSITION);
		createEReference(unsetTransitionEClass, UNSET_TRANSITION__TRANSITION_TO_UNSET);
		createEReference(unsetTransitionEClass, UNSET_TRANSITION__EVENT);
		createEReference(unsetTransitionEClass, UNSET_TRANSITION__GUARD);
		createEReference(unsetTransitionEClass, UNSET_TRANSITION__ACTION);
		createEReference(unsetTransitionEClass, UNSET_TRANSITION__TARGET);
		createEReference(unsetTransitionEClass, UNSET_TRANSITION__SOURCE);

		setAnnotatedElementEClass = createEClass(SET_ANNOTATED_ELEMENT);
		createEReference(setAnnotatedElementEClass, SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET);
		createEReference(setAnnotatedElementEClass, SET_ANNOTATED_ELEMENT__ANNOTATIONS);

		setActionBlockEClass = createEClass(SET_ACTION_BLOCK);
		createEReference(setActionBlockEClass, SET_ACTION_BLOCK__BLOCK_TO_SET);
		createEReference(setActionBlockEClass, SET_ACTION_BLOCK__ACTIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Smartadapters4MODERATESPackage theSmartadapters4MODERATESPackage = (Smartadapters4MODERATESPackage)EPackage.Registry.INSTANCE.getEPackage(Smartadapters4MODERATESPackage.eNS_URI);
		Edap_relaxedPackage theEdap_relaxedPackage = (Edap_relaxedPackage)EPackage.Registry.INSTANCE.getEPackage(Edap_relaxedPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		setCompositeStateEClass.getESuperTypes().add(theSmartadapters4MODERATESPackage.getSetAdaptation());
		unsetCompositeStateEClass.getESuperTypes().add(theSmartadapters4MODERATESPackage.getUnsetAdaptation());
		setStateEClass.getESuperTypes().add(theSmartadapters4MODERATESPackage.getSetAdaptation());
		unsetStateEClass.getESuperTypes().add(theSmartadapters4MODERATESPackage.getUnsetAdaptation());
		setTransitionEClass.getESuperTypes().add(theSmartadapters4MODERATESPackage.getSetAdaptation());
		unsetTransitionEClass.getESuperTypes().add(theSmartadapters4MODERATESPackage.getUnsetAdaptation());
		setAnnotatedElementEClass.getESuperTypes().add(theSmartadapters4MODERATESPackage.getSetAdaptation());
		setActionBlockEClass.getESuperTypes().add(theSmartadapters4MODERATESPackage.getSetAdaptation());

		// Initialize classes and features; add operations and parameters
		initEClass(setCompositeStateEClass, SetCompositeState.class, "SetCompositeState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetCompositeState_CompositeStateToSet(), theEdap_relaxedPackage.getCompositeState(), null, "CompositeStateToSet", null, 1, 1, SetCompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetCompositeState_Substate(), theEdap_relaxedPackage.getState(), null, "substate", null, 0, -1, SetCompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetCompositeState_Initial(), theEdap_relaxedPackage.getState(), null, "initial", null, 0, 1, SetCompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unsetCompositeStateEClass, UnsetCompositeState.class, "UnsetCompositeState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnsetCompositeState_CompositeStateToUnset(), theEdap_relaxedPackage.getCompositeState(), null, "CompositeStateToUnset", null, 1, 1, UnsetCompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetCompositeState_Substate(), theEdap_relaxedPackage.getState(), null, "substate", null, 0, -1, UnsetCompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetCompositeState_Initial(), theEdap_relaxedPackage.getState(), null, "initial", null, 0, 1, UnsetCompositeState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setStateEClass, SetState.class, "SetState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetState_StateToSet(), theEdap_relaxedPackage.getState(), null, "StateToSet", null, 1, 1, SetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetState_Outgoing(), theEdap_relaxedPackage.getTransition(), null, "outgoing", null, 0, -1, SetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetState_Incoming(), theEdap_relaxedPackage.getTransition(), null, "incoming", null, 0, -1, SetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetState_Entry(), theEdap_relaxedPackage.getAction(), null, "entry", null, 0, 1, SetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetState_Exit(), theEdap_relaxedPackage.getAction(), null, "exit", null, 0, 1, SetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetState_Properties(), theEdap_relaxedPackage.getProperty(), null, "properties", null, 0, -1, SetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unsetStateEClass, UnsetState.class, "UnsetState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnsetState_StateToUnset(), theEdap_relaxedPackage.getState(), null, "StateToUnset", null, 1, 1, UnsetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetState_Outgoing(), theEdap_relaxedPackage.getTransition(), null, "outgoing", null, 0, -1, UnsetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetState_Incoming(), theEdap_relaxedPackage.getTransition(), null, "incoming", null, 0, -1, UnsetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetState_Entry(), theEdap_relaxedPackage.getAction(), null, "entry", null, 0, 1, UnsetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetState_Exit(), theEdap_relaxedPackage.getAction(), null, "exit", null, 0, 1, UnsetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetState_Properties(), theEdap_relaxedPackage.getProperty(), null, "properties", null, 0, -1, UnsetState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setTransitionEClass, SetTransition.class, "SetTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetTransition_TransitionToSet(), theEdap_relaxedPackage.getTransition(), null, "TransitionToSet", null, 1, 1, SetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetTransition_Event(), theEdap_relaxedPackage.getEvent(), null, "event", null, 0, -1, SetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetTransition_Guard(), theEdap_relaxedPackage.getExpression(), null, "guard", null, 0, 1, SetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetTransition_Action(), theEdap_relaxedPackage.getAction(), null, "action", null, 0, 1, SetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetTransition_Target(), theEdap_relaxedPackage.getState(), null, "target", null, 0, 1, SetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetTransition_Source(), theEdap_relaxedPackage.getState(), null, "source", null, 0, 1, SetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unsetTransitionEClass, UnsetTransition.class, "UnsetTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnsetTransition_TransitionToUnset(), theEdap_relaxedPackage.getTransition(), null, "TransitionToUnset", null, 1, 1, UnsetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetTransition_Event(), theEdap_relaxedPackage.getEvent(), null, "event", null, 0, -1, UnsetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetTransition_Guard(), theEdap_relaxedPackage.getExpression(), null, "guard", null, 0, 1, UnsetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetTransition_Action(), theEdap_relaxedPackage.getAction(), null, "action", null, 0, 1, UnsetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetTransition_Target(), theEdap_relaxedPackage.getState(), null, "target", null, 0, 1, UnsetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnsetTransition_Source(), theEdap_relaxedPackage.getState(), null, "source", null, 0, 1, UnsetTransition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setAnnotatedElementEClass, SetAnnotatedElement.class, "SetAnnotatedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetAnnotatedElement_AnnotatedElementToSet(), theEdap_relaxedPackage.getAnnotatedElement(), null, "AnnotatedElementToSet", null, 1, 1, SetAnnotatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetAnnotatedElement_Annotations(), theEdap_relaxedPackage.getPlatformAnnotation(), null, "annotations", null, 0, -1, SetAnnotatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setActionBlockEClass, SetActionBlock.class, "SetActionBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetActionBlock_BlockToSet(), theEdap_relaxedPackage.getActionBlock(), null, "blockToSet", null, 1, 1, SetActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetActionBlock_Actions(), theEdap_relaxedPackage.getAction(), null, "actions", null, 0, -1, SetActionBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //AdaptationsPackageImpl
