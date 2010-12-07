/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package smartadapters4MODERATES.adaptations;

import edap_relaxed.AnnotatedElement;
import edap_relaxed.PlatformAnnotation;

import org.eclipse.emf.common.util.EList;

import smartadapters4MODERATES.SetAdaptation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Annotated Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetAnnotatedElement#getAnnotatedElementToSet <em>Annotated Element To Set</em>}</li>
 *   <li>{@link smartadapters4MODERATES.adaptations.SetAnnotatedElement#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetAnnotatedElement()
 * @model
 * @generated
 */
public interface SetAnnotatedElement extends SetAdaptation {
	/**
	 * Returns the value of the '<em><b>Annotated Element To Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated Element To Set</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated Element To Set</em>' reference.
	 * @see #setAnnotatedElementToSet(AnnotatedElement)
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetAnnotatedElement_AnnotatedElementToSet()
	 * @model required="true"
	 * @generated
	 */
	AnnotatedElement getAnnotatedElementToSet();

	/**
	 * Sets the value of the '{@link smartadapters4MODERATES.adaptations.SetAnnotatedElement#getAnnotatedElementToSet <em>Annotated Element To Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotated Element To Set</em>' reference.
	 * @see #getAnnotatedElementToSet()
	 * @generated
	 */
	void setAnnotatedElementToSet(AnnotatedElement value);

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.PlatformAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' reference list.
	 * @see smartadapters4MODERATES.adaptations.AdaptationsPackage#getSetAnnotatedElement_Annotations()
	 * @model
	 * @generated
	 */
	EList<PlatformAnnotation> getAnnotations();

} // SetAnnotatedElement
