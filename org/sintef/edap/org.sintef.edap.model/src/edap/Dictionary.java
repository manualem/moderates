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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dictionary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.Dictionary#getIndexType <em>Index Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getDictionary()
 * @model
 * @generated
 */
public interface Dictionary extends Property {
	/**
	 * Returns the value of the '<em><b>Index Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Type</em>' reference.
	 * @see #setIndexType(Type)
	 * @see edap.EdapPackage#getDictionary_IndexType()
	 * @model required="true"
	 * @generated
	 */
	Type getIndexType();

	/**
	 * Sets the value of the '{@link edap.Dictionary#getIndexType <em>Index Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Type</em>' reference.
	 * @see #getIndexType()
	 * @generated
	 */
	void setIndexType(Type value);

} // Dictionary
