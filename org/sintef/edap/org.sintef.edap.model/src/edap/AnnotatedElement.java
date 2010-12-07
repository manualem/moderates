/**
 *  Copyright (c) 2010 SINTEF
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      SINTEF - initial API and implementation
 */
package edap;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotated Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.AnnotatedElement#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getAnnotatedElement()
 * @model abstract="true"
 * @generated
 */
public interface AnnotatedElement extends EdapElement {
	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link edap.PlatformAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see edap.EdapPackage#getAnnotatedElement_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<PlatformAnnotation> getAnnotations();

} // AnnotatedElement
