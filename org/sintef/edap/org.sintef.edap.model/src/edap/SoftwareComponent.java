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
 * A representation of the model object '<em><b>Software Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.SoftwareComponent#getBehaviour <em>Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getSoftwareComponent()
 * @model
 * @generated
 */
public interface SoftwareComponent extends Component {
	/**
	 * Returns the value of the '<em><b>Behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behaviour</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behaviour</em>' containment reference.
	 * @see #setBehaviour(StateMachine)
	 * @see edap.EdapPackage#getSoftwareComponent_Behaviour()
	 * @model containment="true"
	 * @generated
	 */
	StateMachine getBehaviour();

	/**
	 * Sets the value of the '{@link edap.SoftwareComponent#getBehaviour <em>Behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behaviour</em>' containment reference.
	 * @see #getBehaviour()
	 * @generated
	 */
	void setBehaviour(StateMachine value);

} // SoftwareComponent
