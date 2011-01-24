/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

public class EdapReferenceResolverSwitch implements edap.resource.edap.IEdapReferenceResolverSwitch {
	
	protected edap.resource.edap.analysis.EdapModelImportsReferenceResolver edapModelImportsReferenceResolver = new edap.resource.edap.analysis.EdapModelImportsReferenceResolver();
	protected edap.resource.edap.analysis.ComponentReceivesReferenceResolver componentReceivesReferenceResolver = new edap.resource.edap.analysis.ComponentReceivesReferenceResolver();
	protected edap.resource.edap.analysis.ComponentSendsReferenceResolver componentSendsReferenceResolver = new edap.resource.edap.analysis.ComponentSendsReferenceResolver();
	protected edap.resource.edap.analysis.SimulatorDeviceReferenceResolver simulatorDeviceReferenceResolver = new edap.resource.edap.analysis.SimulatorDeviceReferenceResolver();
	protected edap.resource.edap.analysis.PropertyTypeReferenceResolver propertyTypeReferenceResolver = new edap.resource.edap.analysis.PropertyTypeReferenceResolver();
	protected edap.resource.edap.analysis.DictionaryIndexTypeReferenceResolver dictionaryIndexTypeReferenceResolver = new edap.resource.edap.analysis.DictionaryIndexTypeReferenceResolver();
	protected edap.resource.edap.analysis.ParameterTypeReferenceResolver parameterTypeReferenceResolver = new edap.resource.edap.analysis.ParameterTypeReferenceResolver();
	protected edap.resource.edap.analysis.CompositeStateInitialReferenceResolver compositeStateInitialReferenceResolver = new edap.resource.edap.analysis.CompositeStateInitialReferenceResolver();
	protected edap.resource.edap.analysis.PropertyAssignmentPropertyReferenceResolver propertyAssignmentPropertyReferenceResolver = new edap.resource.edap.analysis.PropertyAssignmentPropertyReferenceResolver();
	protected edap.resource.edap.analysis.ComponentReferenceComponentReferenceResolver componentReferenceComponentReferenceResolver = new edap.resource.edap.analysis.ComponentReferenceComponentReferenceResolver();
	protected edap.resource.edap.analysis.EventReferenceMsgRefReferenceResolver eventReferenceMsgRefReferenceResolver = new edap.resource.edap.analysis.EventReferenceMsgRefReferenceResolver();
	protected edap.resource.edap.analysis.EventReferenceParamRefReferenceResolver eventReferenceParamRefReferenceResolver = new edap.resource.edap.analysis.EventReferenceParamRefReferenceResolver();
	protected edap.resource.edap.analysis.SendActionMessageReferenceResolver sendActionMessageReferenceResolver = new edap.resource.edap.analysis.SendActionMessageReferenceResolver();
	protected edap.resource.edap.analysis.SendActionPortReferenceResolver sendActionPortReferenceResolver = new edap.resource.edap.analysis.SendActionPortReferenceResolver();
	protected edap.resource.edap.analysis.TransitionTargetReferenceResolver transitionTargetReferenceResolver = new edap.resource.edap.analysis.TransitionTargetReferenceResolver();
	protected edap.resource.edap.analysis.ReceiveMessageMessageReferenceResolver receiveMessageMessageReferenceResolver = new edap.resource.edap.analysis.ReceiveMessageMessageReferenceResolver();
	protected edap.resource.edap.analysis.ConnectorPort1ReferenceResolver connectorPort1ReferenceResolver = new edap.resource.edap.analysis.ConnectorPort1ReferenceResolver();
	protected edap.resource.edap.analysis.ConnectorPort2ReferenceResolver connectorPort2ReferenceResolver = new edap.resource.edap.analysis.ConnectorPort2ReferenceResolver();
	protected edap.resource.edap.analysis.PropertyReferencePropertyReferenceResolver propertyReferencePropertyReferenceResolver = new edap.resource.edap.analysis.PropertyReferencePropertyReferenceResolver();
	
	public edap.resource.edap.analysis.EdapModelImportsReferenceResolver getEdapModelImportsReferenceResolver() {
		return edapModelImportsReferenceResolver;
	}
	
	public edap.resource.edap.analysis.ComponentReceivesReferenceResolver getComponentReceivesReferenceResolver() {
		return componentReceivesReferenceResolver;
	}
	
	public edap.resource.edap.analysis.ComponentSendsReferenceResolver getComponentSendsReferenceResolver() {
		return componentSendsReferenceResolver;
	}
	
	public edap.resource.edap.analysis.SimulatorDeviceReferenceResolver getSimulatorDeviceReferenceResolver() {
		return simulatorDeviceReferenceResolver;
	}
	
	public edap.resource.edap.analysis.PropertyTypeReferenceResolver getPropertyTypeReferenceResolver() {
		return propertyTypeReferenceResolver;
	}
	
	public edap.resource.edap.analysis.DictionaryIndexTypeReferenceResolver getDictionaryIndexTypeReferenceResolver() {
		return dictionaryIndexTypeReferenceResolver;
	}
	
	public edap.resource.edap.analysis.ParameterTypeReferenceResolver getParameterTypeReferenceResolver() {
		return parameterTypeReferenceResolver;
	}
	
	public edap.resource.edap.analysis.CompositeStateInitialReferenceResolver getCompositeStateInitialReferenceResolver() {
		return compositeStateInitialReferenceResolver;
	}
	
	public edap.resource.edap.analysis.PropertyAssignmentPropertyReferenceResolver getPropertyAssignmentPropertyReferenceResolver() {
		return propertyAssignmentPropertyReferenceResolver;
	}
	
	public edap.resource.edap.analysis.ComponentReferenceComponentReferenceResolver getComponentReferenceComponentReferenceResolver() {
		return componentReferenceComponentReferenceResolver;
	}
	
	public edap.resource.edap.analysis.EventReferenceMsgRefReferenceResolver getEventReferenceMsgRefReferenceResolver() {
		return eventReferenceMsgRefReferenceResolver;
	}
	
	public edap.resource.edap.analysis.EventReferenceParamRefReferenceResolver getEventReferenceParamRefReferenceResolver() {
		return eventReferenceParamRefReferenceResolver;
	}
	
	public edap.resource.edap.analysis.SendActionMessageReferenceResolver getSendActionMessageReferenceResolver() {
		return sendActionMessageReferenceResolver;
	}
	
	public edap.resource.edap.analysis.SendActionPortReferenceResolver getSendActionPortReferenceResolver() {
		return sendActionPortReferenceResolver;
	}
	
	public edap.resource.edap.analysis.TransitionTargetReferenceResolver getTransitionTargetReferenceResolver() {
		return transitionTargetReferenceResolver;
	}
	
	public edap.resource.edap.analysis.ReceiveMessageMessageReferenceResolver getReceiveMessageMessageReferenceResolver() {
		return receiveMessageMessageReferenceResolver;
	}
	
	public edap.resource.edap.analysis.ConnectorPort1ReferenceResolver getConnectorPort1ReferenceResolver() {
		return connectorPort1ReferenceResolver;
	}
	
	public edap.resource.edap.analysis.ConnectorPort2ReferenceResolver getConnectorPort2ReferenceResolver() {
		return connectorPort2ReferenceResolver;
	}
	
	public edap.resource.edap.analysis.PropertyReferencePropertyReferenceResolver getPropertyReferencePropertyReferenceResolver() {
		return propertyReferencePropertyReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		edapModelImportsReferenceResolver.setOptions(options);
		componentReceivesReferenceResolver.setOptions(options);
		componentSendsReferenceResolver.setOptions(options);
		simulatorDeviceReferenceResolver.setOptions(options);
		propertyTypeReferenceResolver.setOptions(options);
		dictionaryIndexTypeReferenceResolver.setOptions(options);
		parameterTypeReferenceResolver.setOptions(options);
		compositeStateInitialReferenceResolver.setOptions(options);
		propertyAssignmentPropertyReferenceResolver.setOptions(options);
		componentReferenceComponentReferenceResolver.setOptions(options);
		eventReferenceMsgRefReferenceResolver.setOptions(options);
		eventReferenceParamRefReferenceResolver.setOptions(options);
		sendActionMessageReferenceResolver.setOptions(options);
		sendActionPortReferenceResolver.setOptions(options);
		transitionTargetReferenceResolver.setOptions(options);
		receiveMessageMessageReferenceResolver.setOptions(options);
		connectorPort1ReferenceResolver.setOptions(options);
		connectorPort2ReferenceResolver.setOptions(options);
		propertyReferencePropertyReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, edap.resource.edap.IEdapReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (edap.EdapPackage.eINSTANCE.getEdapModel().isInstance(container)) {
			EdapFuzzyResolveResult<edap.EdapModel> frr = new EdapFuzzyResolveResult<edap.EdapModel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("imports")) {
				edapModelImportsReferenceResolver.resolve(identifier, (edap.EdapModel) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getComponent().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Message> frr = new EdapFuzzyResolveResult<edap.Message>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("receives")) {
				componentReceivesReferenceResolver.resolve(identifier, (edap.Component) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getComponent().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Message> frr = new EdapFuzzyResolveResult<edap.Message>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("sends")) {
				componentSendsReferenceResolver.resolve(identifier, (edap.Component) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getSimulator().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Device> frr = new EdapFuzzyResolveResult<edap.Device>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("device")) {
				simulatorDeviceReferenceResolver.resolve(identifier, (edap.Simulator) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getProperty().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Type> frr = new EdapFuzzyResolveResult<edap.Type>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				propertyTypeReferenceResolver.resolve(identifier, (edap.Property) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getDictionary().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Type> frr = new EdapFuzzyResolveResult<edap.Type>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("indexType")) {
				dictionaryIndexTypeReferenceResolver.resolve(identifier, (edap.Dictionary) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getParameter().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Type> frr = new EdapFuzzyResolveResult<edap.Type>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				parameterTypeReferenceResolver.resolve(identifier, (edap.Parameter) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getCompositeState().isInstance(container)) {
			EdapFuzzyResolveResult<edap.State> frr = new EdapFuzzyResolveResult<edap.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("initial")) {
				compositeStateInitialReferenceResolver.resolve(identifier, (edap.CompositeState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getPropertyAssignment().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Property> frr = new EdapFuzzyResolveResult<edap.Property>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("property")) {
				propertyAssignmentPropertyReferenceResolver.resolve(identifier, (edap.PropertyAssignment) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getComponentReference().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Component> frr = new EdapFuzzyResolveResult<edap.Component>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("component")) {
				componentReferenceComponentReferenceResolver.resolve(identifier, (edap.ComponentReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getEventReference().isInstance(container)) {
			EdapFuzzyResolveResult<edap.ReceiveMessage> frr = new EdapFuzzyResolveResult<edap.ReceiveMessage>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("msgRef")) {
				eventReferenceMsgRefReferenceResolver.resolve(identifier, (edap.EventReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getEventReference().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Parameter> frr = new EdapFuzzyResolveResult<edap.Parameter>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("paramRef")) {
				eventReferenceParamRefReferenceResolver.resolve(identifier, (edap.EventReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getSendAction().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Message> frr = new EdapFuzzyResolveResult<edap.Message>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("message")) {
				sendActionMessageReferenceResolver.resolve(identifier, (edap.SendAction) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getSendAction().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Port> frr = new EdapFuzzyResolveResult<edap.Port>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("port")) {
				sendActionPortReferenceResolver.resolve(identifier, (edap.SendAction) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getTransition().isInstance(container)) {
			EdapFuzzyResolveResult<edap.State> frr = new EdapFuzzyResolveResult<edap.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				transitionTargetReferenceResolver.resolve(identifier, (edap.Transition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getReceiveMessage().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Message> frr = new EdapFuzzyResolveResult<edap.Message>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("message")) {
				receiveMessageMessageReferenceResolver.resolve(identifier, (edap.ReceiveMessage) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getConnector().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Port> frr = new EdapFuzzyResolveResult<edap.Port>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("port1")) {
				connectorPort1ReferenceResolver.resolve(identifier, (edap.Connector) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getConnector().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Port> frr = new EdapFuzzyResolveResult<edap.Port>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("port2")) {
				connectorPort2ReferenceResolver.resolve(identifier, (edap.Connector) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap.EdapPackage.eINSTANCE.getPropertyReference().isInstance(container)) {
			EdapFuzzyResolveResult<edap.Property> frr = new EdapFuzzyResolveResult<edap.Property>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("property")) {
				propertyReferencePropertyReferenceResolver.resolve(identifier, (edap.PropertyReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public edap.resource.edap.IEdapReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == edap.EdapPackage.eINSTANCE.getEdapModel_Imports()) {
			return edapModelImportsReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getComponent_Receives()) {
			return componentReceivesReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getComponent_Sends()) {
			return componentSendsReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getSimulator_Device()) {
			return simulatorDeviceReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getProperty_Type()) {
			return propertyTypeReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getDictionary_IndexType()) {
			return dictionaryIndexTypeReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getParameter_Type()) {
			return parameterTypeReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getCompositeState_Initial()) {
			return compositeStateInitialReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getPropertyAssignment_Property()) {
			return propertyAssignmentPropertyReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getComponentReference_Component()) {
			return componentReferenceComponentReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getEventReference_MsgRef()) {
			return eventReferenceMsgRefReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getEventReference_ParamRef()) {
			return eventReferenceParamRefReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getSendAction_Message()) {
			return sendActionMessageReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getSendAction_Port()) {
			return sendActionPortReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getTransition_Target()) {
			return transitionTargetReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getReceiveMessage_Message()) {
			return receiveMessageMessageReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getConnector_Port1()) {
			return connectorPort1ReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getConnector_Port2()) {
			return connectorPort2ReferenceResolver;
		}
		if (reference == edap.EdapPackage.eINSTANCE.getPropertyReference_Property()) {
			return propertyReferencePropertyReferenceResolver;
		}
		return null;
	}
	
}
