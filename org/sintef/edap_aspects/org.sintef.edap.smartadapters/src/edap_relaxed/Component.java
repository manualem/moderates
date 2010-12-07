/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edap_relaxed.Component#getCompositeComponent <em>Composite Component</em>}</li>
 *   <li>{@link edap_relaxed.Component#getProperties <em>Properties</em>}</li>
 *   <li>{@link edap_relaxed.Component#isPartial <em>Partial</em>}</li>
 *   <li>{@link edap_relaxed.Component#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link edap_relaxed.Component#getReceives <em>Receives</em>}</li>
 *   <li>{@link edap_relaxed.Component#getSends <em>Sends</em>}</li>
 *   <li>{@link edap_relaxed.Component#getMessages <em>Messages</em>}</li>
 *   <li>{@link edap_relaxed.Component#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link edap_relaxed.Component#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see edap_relaxed.Edap_relaxedPackage#getComponent()
 * @model abstract="true"
 * @generated
 */
public interface Component extends Type {
	/**
	 * Returns the value of the '<em><b>Composite Component</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Component</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Component</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getComponent_CompositeComponent()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getCompositeComponent();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getComponent_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Partial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partial</em>' attribute.
	 * @see #setPartial(boolean)
	 * @see edap_relaxed.Edap_relaxedPackage#getComponent_Partial()
	 * @model
	 * @generated
	 */
	boolean isPartial();

	/**
	 * Sets the value of the '{@link edap_relaxed.Component#isPartial <em>Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partial</em>' attribute.
	 * @see #isPartial()
	 * @generated
	 */
	void setPartial(boolean value);

	/**
	 * Returns the value of the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singleton</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singleton</em>' attribute.
	 * @see #setSingleton(boolean)
	 * @see edap_relaxed.Edap_relaxedPackage#getComponent_Singleton()
	 * @model
	 * @generated
	 */
	boolean isSingleton();

	/**
	 * Sets the value of the '{@link edap_relaxed.Component#isSingleton <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleton</em>' attribute.
	 * @see #isSingleton()
	 * @generated
	 */
	void setSingleton(boolean value);

	/**
	 * Returns the value of the '<em><b>Receives</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receives</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receives</em>' reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getComponent_Receives()
	 * @model
	 * @generated
	 */
	EList<Message> getReceives();

	/**
	 * Returns the value of the '<em><b>Sends</b></em>' reference list.
	 * The list contents are of type {@link edap_relaxed.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sends</em>' reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getComponent_Sends()
	 * @model
	 * @generated
	 */
	EList<Message> getSends();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getComponent_Messages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Message> getMessages();

	/**
	 * Returns the value of the '<em><b>Connectors</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.Connector}.
	 * It is bidirectional and its opposite is '{@link edap_relaxed.Connector#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connectors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connectors</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getComponent_Connectors()
	 * @see edap_relaxed.Connector#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Connector> getConnectors();

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link edap_relaxed.Port}.
	 * It is bidirectional and its opposite is '{@link edap_relaxed.Port#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see edap_relaxed.Edap_relaxedPackage#getComponent_Ports()
	 * @see edap_relaxed.Port#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Port> getPorts();

} // Component
