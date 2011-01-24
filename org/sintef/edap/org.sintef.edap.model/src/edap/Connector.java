/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap.Connector#getOwner <em>Owner</em>}</li>
 *   <li>{@link edap.Connector#getPort1 <em>Port1</em>}</li>
 *   <li>{@link edap.Connector#getPort2 <em>Port2</em>}</li>
 *   <li>{@link edap.Connector#getProp1 <em>Prop1</em>}</li>
 *   <li>{@link edap.Connector#getProp2 <em>Prop2</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap.EdapPackage#getConnector()
 * @model
 * @generated
 */
public interface Connector extends AnnotatedElement {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edap.Component#getConnectors <em>Connectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Component)
	 * @see edap.EdapPackage#getConnector_Owner()
	 * @see edap.Component#getConnectors
	 * @model opposite="connectors" transient="false"
	 * @generated
	 */
	Component getOwner();

	/**
	 * Sets the value of the '{@link edap.Connector#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Component value);

	/**
	 * Returns the value of the '<em><b>Port1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port1</em>' reference.
	 * @see #setPort1(Port)
	 * @see edap.EdapPackage#getConnector_Port1()
	 * @model required="true"
	 * @generated
	 */
	Port getPort1();

	/**
	 * Sets the value of the '{@link edap.Connector#getPort1 <em>Port1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port1</em>' reference.
	 * @see #getPort1()
	 * @generated
	 */
	void setPort1(Port value);

	/**
	 * Returns the value of the '<em><b>Port2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port2</em>' reference.
	 * @see #setPort2(Port)
	 * @see edap.EdapPackage#getConnector_Port2()
	 * @model required="true"
	 * @generated
	 */
	Port getPort2();

	/**
	 * Sets the value of the '{@link edap.Connector#getPort2 <em>Port2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port2</em>' reference.
	 * @see #getPort2()
	 * @generated
	 */
	void setPort2(Port value);

	/**
	 * Returns the value of the '<em><b>Prop1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prop1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prop1</em>' reference.
	 * @see #setProp1(Property)
	 * @see edap.EdapPackage#getConnector_Prop1()
	 * @model
	 * @generated
	 */
	Property getProp1();

	/**
	 * Sets the value of the '{@link edap.Connector#getProp1 <em>Prop1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prop1</em>' reference.
	 * @see #getProp1()
	 * @generated
	 */
	void setProp1(Property value);

	/**
	 * Returns the value of the '<em><b>Prop2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prop2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prop2</em>' reference.
	 * @see #setProp2(Property)
	 * @see edap.EdapPackage#getConnector_Prop2()
	 * @model
	 * @generated
	 */
	Property getProp2();

	/**
	 * Sets the value of the '{@link edap.Connector#getProp2 <em>Prop2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prop2</em>' reference.
	 * @see #getProp2()
	 * @generated
	 */
	void setProp2(Property value);

} // Connector
