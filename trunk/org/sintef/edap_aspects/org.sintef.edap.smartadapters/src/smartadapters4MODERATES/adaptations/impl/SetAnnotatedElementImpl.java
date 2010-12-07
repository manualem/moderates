/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations.impl;

import edap_relaxed.AnnotatedElement;
import edap_relaxed.PlatformAnnotation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import smartadapters4MODERATES.adaptations.AdaptationsPackage;
import smartadapters4MODERATES.adaptations.SetAnnotatedElement;

import smartadapters4MODERATES.impl.SetAdaptationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Annotated Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetAnnotatedElementImpl#getAnnotatedElementToSet <em>Annotated Element To Set</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.impl.SetAnnotatedElementImpl#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetAnnotatedElementImpl extends SetAdaptationImpl implements SetAnnotatedElement {
	/**
	 * The cached value of the '{@link #getAnnotatedElementToSet() <em>Annotated Element To Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotatedElementToSet()
	 * @generated
	 * @ordered
	 */
	protected AnnotatedElement annotatedElementToSet;

	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<PlatformAnnotation> annotations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetAnnotatedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AdaptationsPackage.Literals.SET_ANNOTATED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotatedElement getAnnotatedElementToSet() {
		if (annotatedElementToSet != null && annotatedElementToSet.eIsProxy()) {
			InternalEObject oldAnnotatedElementToSet = (InternalEObject)annotatedElementToSet;
			annotatedElementToSet = (AnnotatedElement)eResolveProxy(oldAnnotatedElementToSet);
			if (annotatedElementToSet != oldAnnotatedElementToSet) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET, oldAnnotatedElementToSet, annotatedElementToSet));
			}
		}
		return annotatedElementToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotatedElement basicGetAnnotatedElementToSet() {
		return annotatedElementToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotatedElementToSet(AnnotatedElement newAnnotatedElementToSet) {
		AnnotatedElement oldAnnotatedElementToSet = annotatedElementToSet;
		annotatedElementToSet = newAnnotatedElementToSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET, oldAnnotatedElementToSet, annotatedElementToSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PlatformAnnotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectResolvingEList<PlatformAnnotation>(PlatformAnnotation.class, this, AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET:
				if (resolve) return getAnnotatedElementToSet();
				return basicGetAnnotatedElementToSet();
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS:
				return getAnnotations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET:
				setAnnotatedElementToSet((AnnotatedElement)newValue);
				return;
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends PlatformAnnotation>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET:
				setAnnotatedElementToSet((AnnotatedElement)null);
				return;
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS:
				getAnnotations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET:
				return annotatedElementToSet != null;
			case AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SetAnnotatedElementImpl
