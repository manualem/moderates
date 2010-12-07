/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import smartadapters4MODERATES.Smartadapters4MODERATESPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see smartadapters4MODERATES.adaptations.AdaptationsFactory
 * @model kind="package"
 * @generated
 */
public interface AdaptationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "adaptations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://SmartAdapters4ART/smartadapters/core/adaptations";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "adaptations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AdaptationsPackage eINSTANCE = smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link smartadapters4MODERATES.adaptations.impl.SetCompositeStateImpl <em>Set Composite State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see smartadapters4MODERATES.adaptations.impl.SetCompositeStateImpl
	 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetCompositeState()
	 * @generated
	 */
	int SET_COMPOSITE_STATE = 0;

	/**
	 * The feature id for the '<em><b>Composite State To Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Substate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMPOSITE_STATE__SUBSTATE = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMPOSITE_STATE__INITIAL = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Set Composite State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_COMPOSITE_STATE_FEATURE_COUNT = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link smartadapters4MODERATES.adaptations.impl.UnsetCompositeStateImpl <em>Unset Composite State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see smartadapters4MODERATES.adaptations.impl.UnsetCompositeStateImpl
	 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getUnsetCompositeState()
	 * @generated
	 */
	int UNSET_COMPOSITE_STATE = 1;

	/**
	 * The feature id for the '<em><b>Composite State To Unset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Substate</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_COMPOSITE_STATE__SUBSTATE = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_COMPOSITE_STATE__INITIAL = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Unset Composite State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_COMPOSITE_STATE_FEATURE_COUNT = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link smartadapters4MODERATES.adaptations.impl.SetStateImpl <em>Set State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see smartadapters4MODERATES.adaptations.impl.SetStateImpl
	 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetState()
	 * @generated
	 */
	int SET_STATE = 2;

	/**
	 * The feature id for the '<em><b>State To Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATE__STATE_TO_SET = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATE__OUTGOING = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATE__INCOMING = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATE__ENTRY = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATE__EXIT = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATE__PROPERTIES = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Set State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATE_FEATURE_COUNT = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link smartadapters4MODERATES.adaptations.impl.UnsetStateImpl <em>Unset State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see smartadapters4MODERATES.adaptations.impl.UnsetStateImpl
	 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getUnsetState()
	 * @generated
	 */
	int UNSET_STATE = 3;

	/**
	 * The feature id for the '<em><b>State To Unset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_STATE__STATE_TO_UNSET = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_STATE__OUTGOING = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_STATE__INCOMING = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_STATE__ENTRY = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_STATE__EXIT = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_STATE__PROPERTIES = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Unset State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_STATE_FEATURE_COUNT = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link smartadapters4MODERATES.adaptations.impl.SetTransitionImpl <em>Set Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see smartadapters4MODERATES.adaptations.impl.SetTransitionImpl
	 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetTransition()
	 * @generated
	 */
	int SET_TRANSITION = 4;

	/**
	 * The feature id for the '<em><b>Transition To Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TRANSITION__TRANSITION_TO_SET = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TRANSITION__EVENT = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TRANSITION__GUARD = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TRANSITION__ACTION = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TRANSITION__TARGET = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TRANSITION__SOURCE = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Set Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TRANSITION_FEATURE_COUNT = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link smartadapters4MODERATES.adaptations.impl.UnsetTransitionImpl <em>Unset Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see smartadapters4MODERATES.adaptations.impl.UnsetTransitionImpl
	 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getUnsetTransition()
	 * @generated
	 */
	int UNSET_TRANSITION = 5;

	/**
	 * The feature id for the '<em><b>Transition To Unset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_TRANSITION__TRANSITION_TO_UNSET = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_TRANSITION__EVENT = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_TRANSITION__GUARD = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_TRANSITION__ACTION = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_TRANSITION__TARGET = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_TRANSITION__SOURCE = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Unset Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSET_TRANSITION_FEATURE_COUNT = Smartadapters4MODERATESPackage.UNSET_ADAPTATION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link smartadapters4MODERATES.adaptations.impl.SetAnnotatedElementImpl <em>Set Annotated Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see smartadapters4MODERATES.adaptations.impl.SetAnnotatedElementImpl
	 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetAnnotatedElement()
	 * @generated
	 */
	int SET_ANNOTATED_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Annotated Element To Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ANNOTATED_ELEMENT__ANNOTATIONS = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Annotated Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ANNOTATED_ELEMENT_FEATURE_COUNT = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link smartadapters4MODERATES.adaptations.impl.SetActionBlockImpl <em>Set Action Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see smartadapters4MODERATES.adaptations.impl.SetActionBlockImpl
	 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetActionBlock()
	 * @generated
	 */
	int SET_ACTION_BLOCK = 7;

	/**
	 * The feature id for the '<em><b>Block To Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION_BLOCK__BLOCK_TO_SET = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION_BLOCK__ACTIONS = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Action Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION_BLOCK_FEATURE_COUNT = Smartadapters4MODERATESPackage.SET_ADAPTATION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link smartadapters4MODERATES.adaptations.SetCompositeState <em>Set Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Composite State</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetCompositeState
	 * @generated
	 */
	EClass getSetCompositeState();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetCompositeState#getCompositeStateToSet <em>Composite State To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite State To Set</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetCompositeState#getCompositeStateToSet()
	 * @see #getSetCompositeState()
	 * @generated
	 */
	EReference getSetCompositeState_CompositeStateToSet();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.SetCompositeState#getSubstate <em>Substate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Substate</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetCompositeState#getSubstate()
	 * @see #getSetCompositeState()
	 * @generated
	 */
	EReference getSetCompositeState_Substate();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetCompositeState#getInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetCompositeState#getInitial()
	 * @see #getSetCompositeState()
	 * @generated
	 */
	EReference getSetCompositeState_Initial();

	/**
	 * Returns the meta object for class '{@link smartadapters4MODERATES.adaptations.UnsetCompositeState <em>Unset Composite State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unset Composite State</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetCompositeState
	 * @generated
	 */
	EClass getUnsetCompositeState();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetCompositeState#getCompositeStateToUnset <em>Composite State To Unset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Composite State To Unset</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetCompositeState#getCompositeStateToUnset()
	 * @see #getUnsetCompositeState()
	 * @generated
	 */
	EReference getUnsetCompositeState_CompositeStateToUnset();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.UnsetCompositeState#getSubstate <em>Substate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Substate</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetCompositeState#getSubstate()
	 * @see #getUnsetCompositeState()
	 * @generated
	 */
	EReference getUnsetCompositeState_Substate();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetCompositeState#getInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetCompositeState#getInitial()
	 * @see #getUnsetCompositeState()
	 * @generated
	 */
	EReference getUnsetCompositeState_Initial();

	/**
	 * Returns the meta object for class '{@link smartadapters4MODERATES.adaptations.SetState <em>Set State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set State</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetState
	 * @generated
	 */
	EClass getSetState();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetState#getStateToSet <em>State To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State To Set</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetState#getStateToSet()
	 * @see #getSetState()
	 * @generated
	 */
	EReference getSetState_StateToSet();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.SetState#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetState#getOutgoing()
	 * @see #getSetState()
	 * @generated
	 */
	EReference getSetState_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.SetState#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetState#getIncoming()
	 * @see #getSetState()
	 * @generated
	 */
	EReference getSetState_Incoming();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetState#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entry</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetState#getEntry()
	 * @see #getSetState()
	 * @generated
	 */
	EReference getSetState_Entry();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetState#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exit</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetState#getExit()
	 * @see #getSetState()
	 * @generated
	 */
	EReference getSetState_Exit();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.SetState#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetState#getProperties()
	 * @see #getSetState()
	 * @generated
	 */
	EReference getSetState_Properties();

	/**
	 * Returns the meta object for class '{@link smartadapters4MODERATES.adaptations.UnsetState <em>Unset State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unset State</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetState
	 * @generated
	 */
	EClass getUnsetState();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetState#getStateToUnset <em>State To Unset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>State To Unset</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetState#getStateToUnset()
	 * @see #getUnsetState()
	 * @generated
	 */
	EReference getUnsetState_StateToUnset();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.UnsetState#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetState#getOutgoing()
	 * @see #getUnsetState()
	 * @generated
	 */
	EReference getUnsetState_Outgoing();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.UnsetState#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetState#getIncoming()
	 * @see #getUnsetState()
	 * @generated
	 */
	EReference getUnsetState_Incoming();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetState#getEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entry</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetState#getEntry()
	 * @see #getUnsetState()
	 * @generated
	 */
	EReference getUnsetState_Entry();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetState#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exit</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetState#getExit()
	 * @see #getUnsetState()
	 * @generated
	 */
	EReference getUnsetState_Exit();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.UnsetState#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Properties</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetState#getProperties()
	 * @see #getUnsetState()
	 * @generated
	 */
	EReference getUnsetState_Properties();

	/**
	 * Returns the meta object for class '{@link smartadapters4MODERATES.adaptations.SetTransition <em>Set Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Transition</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetTransition
	 * @generated
	 */
	EClass getSetTransition();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetTransition#getTransitionToSet <em>Transition To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transition To Set</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetTransition#getTransitionToSet()
	 * @see #getSetTransition()
	 * @generated
	 */
	EReference getSetTransition_TransitionToSet();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.SetTransition#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetTransition#getEvent()
	 * @see #getSetTransition()
	 * @generated
	 */
	EReference getSetTransition_Event();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetTransition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guard</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetTransition#getGuard()
	 * @see #getSetTransition()
	 * @generated
	 */
	EReference getSetTransition_Guard();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetTransition#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetTransition#getAction()
	 * @see #getSetTransition()
	 * @generated
	 */
	EReference getSetTransition_Action();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetTransition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetTransition#getTarget()
	 * @see #getSetTransition()
	 * @generated
	 */
	EReference getSetTransition_Target();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetTransition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetTransition#getSource()
	 * @see #getSetTransition()
	 * @generated
	 */
	EReference getSetTransition_Source();

	/**
	 * Returns the meta object for class '{@link smartadapters4MODERATES.adaptations.UnsetTransition <em>Unset Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unset Transition</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetTransition
	 * @generated
	 */
	EClass getUnsetTransition();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetTransition#getTransitionToUnset <em>Transition To Unset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transition To Unset</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetTransition#getTransitionToUnset()
	 * @see #getUnsetTransition()
	 * @generated
	 */
	EReference getUnsetTransition_TransitionToUnset();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.UnsetTransition#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Event</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetTransition#getEvent()
	 * @see #getUnsetTransition()
	 * @generated
	 */
	EReference getUnsetTransition_Event();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetTransition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guard</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetTransition#getGuard()
	 * @see #getUnsetTransition()
	 * @generated
	 */
	EReference getUnsetTransition_Guard();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetTransition#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetTransition#getAction()
	 * @see #getUnsetTransition()
	 * @generated
	 */
	EReference getUnsetTransition_Action();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetTransition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetTransition#getTarget()
	 * @see #getUnsetTransition()
	 * @generated
	 */
	EReference getUnsetTransition_Target();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.UnsetTransition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see smartadapters4MODERATES.adaptations.UnsetTransition#getSource()
	 * @see #getUnsetTransition()
	 * @generated
	 */
	EReference getUnsetTransition_Source();

	/**
	 * Returns the meta object for class '{@link smartadapters4MODERATES.adaptations.SetAnnotatedElement <em>Set Annotated Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Annotated Element</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetAnnotatedElement
	 * @generated
	 */
	EClass getSetAnnotatedElement();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetAnnotatedElement#getAnnotatedElementToSet <em>Annotated Element To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Annotated Element To Set</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetAnnotatedElement#getAnnotatedElementToSet()
	 * @see #getSetAnnotatedElement()
	 * @generated
	 */
	EReference getSetAnnotatedElement_AnnotatedElementToSet();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.SetAnnotatedElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotations</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetAnnotatedElement#getAnnotations()
	 * @see #getSetAnnotatedElement()
	 * @generated
	 */
	EReference getSetAnnotatedElement_Annotations();

	/**
	 * Returns the meta object for class '{@link smartadapters4MODERATES.adaptations.SetActionBlock <em>Set Action Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Action Block</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetActionBlock
	 * @generated
	 */
	EClass getSetActionBlock();

	/**
	 * Returns the meta object for the reference '{@link smartadapters4MODERATES.adaptations.SetActionBlock#getBlockToSet <em>Block To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Block To Set</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetActionBlock#getBlockToSet()
	 * @see #getSetActionBlock()
	 * @generated
	 */
	EReference getSetActionBlock_BlockToSet();

	/**
	 * Returns the meta object for the reference list '{@link smartadapters4MODERATES.adaptations.SetActionBlock#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see smartadapters4MODERATES.adaptations.SetActionBlock#getActions()
	 * @see #getSetActionBlock()
	 * @generated
	 */
	EReference getSetActionBlock_Actions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AdaptationsFactory getAdaptationsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link smartadapters4MODERATES.adaptations.impl.SetCompositeStateImpl <em>Set Composite State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see smartadapters4MODERATES.adaptations.impl.SetCompositeStateImpl
		 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetCompositeState()
		 * @generated
		 */
		EClass SET_COMPOSITE_STATE = eINSTANCE.getSetCompositeState();

		/**
		 * The meta object literal for the '<em><b>Composite State To Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET = eINSTANCE.getSetCompositeState_CompositeStateToSet();

		/**
		 * The meta object literal for the '<em><b>Substate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_COMPOSITE_STATE__SUBSTATE = eINSTANCE.getSetCompositeState_Substate();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_COMPOSITE_STATE__INITIAL = eINSTANCE.getSetCompositeState_Initial();

		/**
		 * The meta object literal for the '{@link smartadapters4MODERATES.adaptations.impl.UnsetCompositeStateImpl <em>Unset Composite State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see smartadapters4MODERATES.adaptations.impl.UnsetCompositeStateImpl
		 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getUnsetCompositeState()
		 * @generated
		 */
		EClass UNSET_COMPOSITE_STATE = eINSTANCE.getUnsetCompositeState();

		/**
		 * The meta object literal for the '<em><b>Composite State To Unset</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET = eINSTANCE.getUnsetCompositeState_CompositeStateToUnset();

		/**
		 * The meta object literal for the '<em><b>Substate</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_COMPOSITE_STATE__SUBSTATE = eINSTANCE.getUnsetCompositeState_Substate();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_COMPOSITE_STATE__INITIAL = eINSTANCE.getUnsetCompositeState_Initial();

		/**
		 * The meta object literal for the '{@link smartadapters4MODERATES.adaptations.impl.SetStateImpl <em>Set State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see smartadapters4MODERATES.adaptations.impl.SetStateImpl
		 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetState()
		 * @generated
		 */
		EClass SET_STATE = eINSTANCE.getSetState();

		/**
		 * The meta object literal for the '<em><b>State To Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATE__STATE_TO_SET = eINSTANCE.getSetState_StateToSet();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATE__OUTGOING = eINSTANCE.getSetState_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATE__INCOMING = eINSTANCE.getSetState_Incoming();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATE__ENTRY = eINSTANCE.getSetState_Entry();

		/**
		 * The meta object literal for the '<em><b>Exit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATE__EXIT = eINSTANCE.getSetState_Exit();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATE__PROPERTIES = eINSTANCE.getSetState_Properties();

		/**
		 * The meta object literal for the '{@link smartadapters4MODERATES.adaptations.impl.UnsetStateImpl <em>Unset State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see smartadapters4MODERATES.adaptations.impl.UnsetStateImpl
		 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getUnsetState()
		 * @generated
		 */
		EClass UNSET_STATE = eINSTANCE.getUnsetState();

		/**
		 * The meta object literal for the '<em><b>State To Unset</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_STATE__STATE_TO_UNSET = eINSTANCE.getUnsetState_StateToUnset();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_STATE__OUTGOING = eINSTANCE.getUnsetState_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_STATE__INCOMING = eINSTANCE.getUnsetState_Incoming();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_STATE__ENTRY = eINSTANCE.getUnsetState_Entry();

		/**
		 * The meta object literal for the '<em><b>Exit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_STATE__EXIT = eINSTANCE.getUnsetState_Exit();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_STATE__PROPERTIES = eINSTANCE.getUnsetState_Properties();

		/**
		 * The meta object literal for the '{@link smartadapters4MODERATES.adaptations.impl.SetTransitionImpl <em>Set Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see smartadapters4MODERATES.adaptations.impl.SetTransitionImpl
		 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetTransition()
		 * @generated
		 */
		EClass SET_TRANSITION = eINSTANCE.getSetTransition();

		/**
		 * The meta object literal for the '<em><b>Transition To Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TRANSITION__TRANSITION_TO_SET = eINSTANCE.getSetTransition_TransitionToSet();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TRANSITION__EVENT = eINSTANCE.getSetTransition_Event();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TRANSITION__GUARD = eINSTANCE.getSetTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TRANSITION__ACTION = eINSTANCE.getSetTransition_Action();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TRANSITION__TARGET = eINSTANCE.getSetTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_TRANSITION__SOURCE = eINSTANCE.getSetTransition_Source();

		/**
		 * The meta object literal for the '{@link smartadapters4MODERATES.adaptations.impl.UnsetTransitionImpl <em>Unset Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see smartadapters4MODERATES.adaptations.impl.UnsetTransitionImpl
		 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getUnsetTransition()
		 * @generated
		 */
		EClass UNSET_TRANSITION = eINSTANCE.getUnsetTransition();

		/**
		 * The meta object literal for the '<em><b>Transition To Unset</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_TRANSITION__TRANSITION_TO_UNSET = eINSTANCE.getUnsetTransition_TransitionToUnset();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_TRANSITION__EVENT = eINSTANCE.getUnsetTransition_Event();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_TRANSITION__GUARD = eINSTANCE.getUnsetTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_TRANSITION__ACTION = eINSTANCE.getUnsetTransition_Action();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_TRANSITION__TARGET = eINSTANCE.getUnsetTransition_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNSET_TRANSITION__SOURCE = eINSTANCE.getUnsetTransition_Source();

		/**
		 * The meta object literal for the '{@link smartadapters4MODERATES.adaptations.impl.SetAnnotatedElementImpl <em>Set Annotated Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see smartadapters4MODERATES.adaptations.impl.SetAnnotatedElementImpl
		 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetAnnotatedElement()
		 * @generated
		 */
		EClass SET_ANNOTATED_ELEMENT = eINSTANCE.getSetAnnotatedElement();

		/**
		 * The meta object literal for the '<em><b>Annotated Element To Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET = eINSTANCE.getSetAnnotatedElement_AnnotatedElementToSet();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_ANNOTATED_ELEMENT__ANNOTATIONS = eINSTANCE.getSetAnnotatedElement_Annotations();

		/**
		 * The meta object literal for the '{@link smartadapters4MODERATES.adaptations.impl.SetActionBlockImpl <em>Set Action Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see smartadapters4MODERATES.adaptations.impl.SetActionBlockImpl
		 * @see smartadapters4MODERATES.adaptations.impl.AdaptationsPackageImpl#getSetActionBlock()
		 * @generated
		 */
		EClass SET_ACTION_BLOCK = eINSTANCE.getSetActionBlock();

		/**
		 * The meta object literal for the '<em><b>Block To Set</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_ACTION_BLOCK__BLOCK_TO_SET = eINSTANCE.getSetActionBlock_BlockToSet();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_ACTION_BLOCK__ACTIONS = eINSTANCE.getSetActionBlock_Actions();

	}

} //AdaptationsPackage
