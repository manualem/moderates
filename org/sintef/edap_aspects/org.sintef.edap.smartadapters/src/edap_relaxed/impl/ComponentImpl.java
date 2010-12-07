/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edap_relaxed.impl;

import edap_relaxed.Component;
import edap_relaxed.Connector;
import edap_relaxed.Edap_relaxedPackage;
import edap_relaxed.Message;
import edap_relaxed.Port;
import edap_relaxed.Property;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edap_relaxed.impl.ComponentImpl#getCompositeComponent <em>Composite Component</em>}</li>
 *   <li>{@link edap_relaxed.impl.ComponentImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link edap_relaxed.impl.ComponentImpl#isPartial <em>Partial</em>}</li>
 *   <li>{@link edap_relaxed.impl.ComponentImpl#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link edap_relaxed.impl.ComponentImpl#getReceives <em>Receives</em>}</li>
 *   <li>{@link edap_relaxed.impl.ComponentImpl#getSends <em>Sends</em>}</li>
 *   <li>{@link edap_relaxed.impl.ComponentImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link edap_relaxed.impl.ComponentImpl#getConnectors <em>Connectors</em>}</li>
 *   <li>{@link edap_relaxed.impl.ComponentImpl#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentImpl extends TypeImpl implements Component {
	/**
	 * The cached value of the '{@link #getCompositeComponent() <em>Composite Component</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositeComponent()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> compositeComponent;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * The default value of the '{@link #isPartial() <em>Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARTIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPartial() <em>Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartial()
	 * @generated
	 * @ordered
	 */
	protected boolean partial = PARTIAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SINGLETON_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected boolean singleton = SINGLETON_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReceives() <em>Receives</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceives()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> receives;

	/**
	 * The cached value of the '{@link #getSends() <em>Sends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSends()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> sends;

	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> messages;

	/**
	 * The cached value of the '{@link #getConnectors() <em>Connectors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectors()
	 * @generated
	 * @ordered
	 */
	protected EList<Connector> connectors;

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> ports;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Edap_relaxedPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getCompositeComponent() {
		if (compositeComponent == null) {
			compositeComponent = new EObjectContainmentEList<Component>(Component.class, this, Edap_relaxedPackage.COMPONENT__COMPOSITE_COMPONENT);
		}
		return compositeComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, Edap_relaxedPackage.COMPONENT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartial() {
		return partial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartial(boolean newPartial) {
		boolean oldPartial = partial;
		partial = newPartial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Edap_relaxedPackage.COMPONENT__PARTIAL, oldPartial, partial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSingleton() {
		return singleton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleton(boolean newSingleton) {
		boolean oldSingleton = singleton;
		singleton = newSingleton;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Edap_relaxedPackage.COMPONENT__SINGLETON, oldSingleton, singleton));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getReceives() {
		if (receives == null) {
			receives = new EObjectResolvingEList<Message>(Message.class, this, Edap_relaxedPackage.COMPONENT__RECEIVES);
		}
		return receives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getSends() {
		if (sends == null) {
			sends = new EObjectResolvingEList<Message>(Message.class, this, Edap_relaxedPackage.COMPONENT__SENDS);
		}
		return sends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentEList<Message>(Message.class, this, Edap_relaxedPackage.COMPONENT__MESSAGES);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connector> getConnectors() {
		if (connectors == null) {
			connectors = new EObjectContainmentWithInverseEList<Connector>(Connector.class, this, Edap_relaxedPackage.COMPONENT__CONNECTORS, Edap_relaxedPackage.CONNECTOR__OWNER);
		}
		return connectors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentWithInverseEList<Port>(Port.class, this, Edap_relaxedPackage.COMPONENT__PORTS, Edap_relaxedPackage.PORT__OWNER);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Edap_relaxedPackage.COMPONENT__CONNECTORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnectors()).basicAdd(otherEnd, msgs);
			case Edap_relaxedPackage.COMPONENT__PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPorts()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Edap_relaxedPackage.COMPONENT__COMPOSITE_COMPONENT:
				return ((InternalEList<?>)getCompositeComponent()).basicRemove(otherEnd, msgs);
			case Edap_relaxedPackage.COMPONENT__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case Edap_relaxedPackage.COMPONENT__MESSAGES:
				return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
			case Edap_relaxedPackage.COMPONENT__CONNECTORS:
				return ((InternalEList<?>)getConnectors()).basicRemove(otherEnd, msgs);
			case Edap_relaxedPackage.COMPONENT__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Edap_relaxedPackage.COMPONENT__COMPOSITE_COMPONENT:
				return getCompositeComponent();
			case Edap_relaxedPackage.COMPONENT__PROPERTIES:
				return getProperties();
			case Edap_relaxedPackage.COMPONENT__PARTIAL:
				return isPartial();
			case Edap_relaxedPackage.COMPONENT__SINGLETON:
				return isSingleton();
			case Edap_relaxedPackage.COMPONENT__RECEIVES:
				return getReceives();
			case Edap_relaxedPackage.COMPONENT__SENDS:
				return getSends();
			case Edap_relaxedPackage.COMPONENT__MESSAGES:
				return getMessages();
			case Edap_relaxedPackage.COMPONENT__CONNECTORS:
				return getConnectors();
			case Edap_relaxedPackage.COMPONENT__PORTS:
				return getPorts();
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
			case Edap_relaxedPackage.COMPONENT__COMPOSITE_COMPONENT:
				getCompositeComponent().clear();
				getCompositeComponent().addAll((Collection<? extends Component>)newValue);
				return;
			case Edap_relaxedPackage.COMPONENT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case Edap_relaxedPackage.COMPONENT__PARTIAL:
				setPartial((Boolean)newValue);
				return;
			case Edap_relaxedPackage.COMPONENT__SINGLETON:
				setSingleton((Boolean)newValue);
				return;
			case Edap_relaxedPackage.COMPONENT__RECEIVES:
				getReceives().clear();
				getReceives().addAll((Collection<? extends Message>)newValue);
				return;
			case Edap_relaxedPackage.COMPONENT__SENDS:
				getSends().clear();
				getSends().addAll((Collection<? extends Message>)newValue);
				return;
			case Edap_relaxedPackage.COMPONENT__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends Message>)newValue);
				return;
			case Edap_relaxedPackage.COMPONENT__CONNECTORS:
				getConnectors().clear();
				getConnectors().addAll((Collection<? extends Connector>)newValue);
				return;
			case Edap_relaxedPackage.COMPONENT__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends Port>)newValue);
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
			case Edap_relaxedPackage.COMPONENT__COMPOSITE_COMPONENT:
				getCompositeComponent().clear();
				return;
			case Edap_relaxedPackage.COMPONENT__PROPERTIES:
				getProperties().clear();
				return;
			case Edap_relaxedPackage.COMPONENT__PARTIAL:
				setPartial(PARTIAL_EDEFAULT);
				return;
			case Edap_relaxedPackage.COMPONENT__SINGLETON:
				setSingleton(SINGLETON_EDEFAULT);
				return;
			case Edap_relaxedPackage.COMPONENT__RECEIVES:
				getReceives().clear();
				return;
			case Edap_relaxedPackage.COMPONENT__SENDS:
				getSends().clear();
				return;
			case Edap_relaxedPackage.COMPONENT__MESSAGES:
				getMessages().clear();
				return;
			case Edap_relaxedPackage.COMPONENT__CONNECTORS:
				getConnectors().clear();
				return;
			case Edap_relaxedPackage.COMPONENT__PORTS:
				getPorts().clear();
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
			case Edap_relaxedPackage.COMPONENT__COMPOSITE_COMPONENT:
				return compositeComponent != null && !compositeComponent.isEmpty();
			case Edap_relaxedPackage.COMPONENT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case Edap_relaxedPackage.COMPONENT__PARTIAL:
				return partial != PARTIAL_EDEFAULT;
			case Edap_relaxedPackage.COMPONENT__SINGLETON:
				return singleton != SINGLETON_EDEFAULT;
			case Edap_relaxedPackage.COMPONENT__RECEIVES:
				return receives != null && !receives.isEmpty();
			case Edap_relaxedPackage.COMPONENT__SENDS:
				return sends != null && !sends.isEmpty();
			case Edap_relaxedPackage.COMPONENT__MESSAGES:
				return messages != null && !messages.isEmpty();
			case Edap_relaxedPackage.COMPONENT__CONNECTORS:
				return connectors != null && !connectors.isEmpty();
			case Edap_relaxedPackage.COMPONENT__PORTS:
				return ports != null && !ports.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (partial: ");
		result.append(partial);
		result.append(", singleton: ");
		result.append(singleton);
		result.append(')');
		return result.toString();
	}

} //ComponentImpl
