/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectReferenceResolverSwitch implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolverSwitch {
	
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.InstantiationStrategyAdviceElementsReferenceResolver instantiationStrategyAdviceElementsReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.InstantiationStrategyAdviceElementsReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.ScopedInstantiationPointcutElementsReferenceResolver scopedInstantiationPointcutElementsReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.ScopedInstantiationPointcutElementsReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetCompositeStateCompositeStateToSetReferenceResolver setCompositeStateCompositeStateToSetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetCompositeStateCompositeStateToSetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetCompositeStateInitialReferenceResolver setCompositeStateInitialReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetCompositeStateInitialReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetCompositeStateSubstateReferenceResolver setCompositeStateSubstateReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetCompositeStateSubstateReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetCompositeStateCompositeStateToUnsetReferenceResolver unsetCompositeStateCompositeStateToUnsetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetCompositeStateCompositeStateToUnsetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetCompositeStateInitialReferenceResolver unsetCompositeStateInitialReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetCompositeStateInitialReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetCompositeStateSubstateReferenceResolver unsetCompositeStateSubstateReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetCompositeStateSubstateReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateStateToSetReferenceResolver setStateStateToSetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateStateToSetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateOutgoingReferenceResolver setStateOutgoingReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateOutgoingReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateIncomingReferenceResolver setStateIncomingReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateIncomingReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateEntryReferenceResolver setStateEntryReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateEntryReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateExitReferenceResolver setStateExitReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateExitReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetStatePropertiesReferenceResolver setStatePropertiesReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetStatePropertiesReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateStateToUnsetReferenceResolver unsetStateStateToUnsetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateStateToUnsetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateOutgoingReferenceResolver unsetStateOutgoingReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateOutgoingReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateIncomingReferenceResolver unsetStateIncomingReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateIncomingReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateEntryReferenceResolver unsetStateEntryReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateEntryReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateExitReferenceResolver unsetStateExitReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateExitReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStatePropertiesReferenceResolver unsetStatePropertiesReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStatePropertiesReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionTransitionToSetReferenceResolver setTransitionTransitionToSetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionTransitionToSetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionEventReferenceResolver setTransitionEventReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionEventReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionGuardReferenceResolver setTransitionGuardReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionGuardReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionActionReferenceResolver setTransitionActionReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionActionReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionTargetReferenceResolver setTransitionTargetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionTargetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionSourceReferenceResolver setTransitionSourceReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionSourceReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionTransitionToUnsetReferenceResolver unsetTransitionTransitionToUnsetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionTransitionToUnsetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionEventReferenceResolver unsetTransitionEventReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionEventReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionGuardReferenceResolver unsetTransitionGuardReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionGuardReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionActionReferenceResolver unsetTransitionActionReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionActionReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionTargetReferenceResolver unsetTransitionTargetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionTargetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionSourceReferenceResolver unsetTransitionSourceReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionSourceReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetAnnotatedElementAnnotatedElementToSetReferenceResolver setAnnotatedElementAnnotatedElementToSetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetAnnotatedElementAnnotatedElementToSetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetAnnotatedElementAnnotationsReferenceResolver setAnnotatedElementAnnotationsReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetAnnotatedElementAnnotationsReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetActionBlockBlockToSetReferenceResolver setActionBlockBlockToSetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetActionBlockBlockToSetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SetActionBlockActionsReferenceResolver setActionBlockActionsReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SetActionBlockActionsReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.EdapModelImportsReferenceResolver edapModelImportsReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.EdapModelImportsReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.ComponentReceivesReferenceResolver componentReceivesReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.ComponentReceivesReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.ComponentSendsReferenceResolver componentSendsReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.ComponentSendsReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SimulatorDeviceReferenceResolver simulatorDeviceReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SimulatorDeviceReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.PropertyTypeReferenceResolver propertyTypeReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.PropertyTypeReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.DictionaryIndexTypeReferenceResolver dictionaryIndexTypeReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.DictionaryIndexTypeReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.ParameterTypeReferenceResolver parameterTypeReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.ParameterTypeReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.CompositeStateInitialReferenceResolver compositeStateInitialReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.CompositeStateInitialReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.PropertyAssignmentPropertyReferenceResolver propertyAssignmentPropertyReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.PropertyAssignmentPropertyReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.ComponentReferenceComponentReferenceResolver componentReferenceComponentReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.ComponentReferenceComponentReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.EventReferenceMsgRefReferenceResolver eventReferenceMsgRefReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.EventReferenceMsgRefReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.EventReferenceParamRefReferenceResolver eventReferenceParamRefReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.EventReferenceParamRefReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.PropertyNavigationPropertyReferenceResolver propertyNavigationPropertyReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.PropertyNavigationPropertyReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SendActionMessageReferenceResolver sendActionMessageReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SendActionMessageReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.SendActionPortReferenceResolver sendActionPortReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.SendActionPortReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.TransitionTargetReferenceResolver transitionTargetReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.TransitionTargetReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.ReceiveMessageMessageReferenceResolver receiveMessageMessageReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.ReceiveMessageMessageReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.ConnectorPort1ReferenceResolver connectorPort1ReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.ConnectorPort1ReferenceResolver();
	protected smartadapters4MODERATES.resource.edap_aspect.analysis.ConnectorPort2ReferenceResolver connectorPort2ReferenceResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.ConnectorPort2ReferenceResolver();
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.InstantiationStrategyAdviceElementsReferenceResolver getInstantiationStrategyAdviceElementsReferenceResolver() {
		return instantiationStrategyAdviceElementsReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.ScopedInstantiationPointcutElementsReferenceResolver getScopedInstantiationPointcutElementsReferenceResolver() {
		return scopedInstantiationPointcutElementsReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetCompositeStateCompositeStateToSetReferenceResolver getSetCompositeStateCompositeStateToSetReferenceResolver() {
		return setCompositeStateCompositeStateToSetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetCompositeStateInitialReferenceResolver getSetCompositeStateInitialReferenceResolver() {
		return setCompositeStateInitialReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetCompositeStateSubstateReferenceResolver getSetCompositeStateSubstateReferenceResolver() {
		return setCompositeStateSubstateReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetCompositeStateCompositeStateToUnsetReferenceResolver getUnsetCompositeStateCompositeStateToUnsetReferenceResolver() {
		return unsetCompositeStateCompositeStateToUnsetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetCompositeStateInitialReferenceResolver getUnsetCompositeStateInitialReferenceResolver() {
		return unsetCompositeStateInitialReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetCompositeStateSubstateReferenceResolver getUnsetCompositeStateSubstateReferenceResolver() {
		return unsetCompositeStateSubstateReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateStateToSetReferenceResolver getSetStateStateToSetReferenceResolver() {
		return setStateStateToSetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateOutgoingReferenceResolver getSetStateOutgoingReferenceResolver() {
		return setStateOutgoingReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateIncomingReferenceResolver getSetStateIncomingReferenceResolver() {
		return setStateIncomingReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateEntryReferenceResolver getSetStateEntryReferenceResolver() {
		return setStateEntryReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetStateExitReferenceResolver getSetStateExitReferenceResolver() {
		return setStateExitReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetStatePropertiesReferenceResolver getSetStatePropertiesReferenceResolver() {
		return setStatePropertiesReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateStateToUnsetReferenceResolver getUnsetStateStateToUnsetReferenceResolver() {
		return unsetStateStateToUnsetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateOutgoingReferenceResolver getUnsetStateOutgoingReferenceResolver() {
		return unsetStateOutgoingReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateIncomingReferenceResolver getUnsetStateIncomingReferenceResolver() {
		return unsetStateIncomingReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateEntryReferenceResolver getUnsetStateEntryReferenceResolver() {
		return unsetStateEntryReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStateExitReferenceResolver getUnsetStateExitReferenceResolver() {
		return unsetStateExitReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetStatePropertiesReferenceResolver getUnsetStatePropertiesReferenceResolver() {
		return unsetStatePropertiesReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionTransitionToSetReferenceResolver getSetTransitionTransitionToSetReferenceResolver() {
		return setTransitionTransitionToSetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionEventReferenceResolver getSetTransitionEventReferenceResolver() {
		return setTransitionEventReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionGuardReferenceResolver getSetTransitionGuardReferenceResolver() {
		return setTransitionGuardReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionActionReferenceResolver getSetTransitionActionReferenceResolver() {
		return setTransitionActionReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionTargetReferenceResolver getSetTransitionTargetReferenceResolver() {
		return setTransitionTargetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetTransitionSourceReferenceResolver getSetTransitionSourceReferenceResolver() {
		return setTransitionSourceReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionTransitionToUnsetReferenceResolver getUnsetTransitionTransitionToUnsetReferenceResolver() {
		return unsetTransitionTransitionToUnsetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionEventReferenceResolver getUnsetTransitionEventReferenceResolver() {
		return unsetTransitionEventReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionGuardReferenceResolver getUnsetTransitionGuardReferenceResolver() {
		return unsetTransitionGuardReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionActionReferenceResolver getUnsetTransitionActionReferenceResolver() {
		return unsetTransitionActionReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionTargetReferenceResolver getUnsetTransitionTargetReferenceResolver() {
		return unsetTransitionTargetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.UnsetTransitionSourceReferenceResolver getUnsetTransitionSourceReferenceResolver() {
		return unsetTransitionSourceReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetAnnotatedElementAnnotatedElementToSetReferenceResolver getSetAnnotatedElementAnnotatedElementToSetReferenceResolver() {
		return setAnnotatedElementAnnotatedElementToSetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetAnnotatedElementAnnotationsReferenceResolver getSetAnnotatedElementAnnotationsReferenceResolver() {
		return setAnnotatedElementAnnotationsReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetActionBlockBlockToSetReferenceResolver getSetActionBlockBlockToSetReferenceResolver() {
		return setActionBlockBlockToSetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SetActionBlockActionsReferenceResolver getSetActionBlockActionsReferenceResolver() {
		return setActionBlockActionsReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.EdapModelImportsReferenceResolver getEdapModelImportsReferenceResolver() {
		return edapModelImportsReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.ComponentReceivesReferenceResolver getComponentReceivesReferenceResolver() {
		return componentReceivesReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.ComponentSendsReferenceResolver getComponentSendsReferenceResolver() {
		return componentSendsReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SimulatorDeviceReferenceResolver getSimulatorDeviceReferenceResolver() {
		return simulatorDeviceReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.PropertyTypeReferenceResolver getPropertyTypeReferenceResolver() {
		return propertyTypeReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.DictionaryIndexTypeReferenceResolver getDictionaryIndexTypeReferenceResolver() {
		return dictionaryIndexTypeReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.ParameterTypeReferenceResolver getParameterTypeReferenceResolver() {
		return parameterTypeReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.CompositeStateInitialReferenceResolver getCompositeStateInitialReferenceResolver() {
		return compositeStateInitialReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.PropertyAssignmentPropertyReferenceResolver getPropertyAssignmentPropertyReferenceResolver() {
		return propertyAssignmentPropertyReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.ComponentReferenceComponentReferenceResolver getComponentReferenceComponentReferenceResolver() {
		return componentReferenceComponentReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.EventReferenceMsgRefReferenceResolver getEventReferenceMsgRefReferenceResolver() {
		return eventReferenceMsgRefReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.EventReferenceParamRefReferenceResolver getEventReferenceParamRefReferenceResolver() {
		return eventReferenceParamRefReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.PropertyNavigationPropertyReferenceResolver getPropertyNavigationPropertyReferenceResolver() {
		return propertyNavigationPropertyReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SendActionMessageReferenceResolver getSendActionMessageReferenceResolver() {
		return sendActionMessageReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.SendActionPortReferenceResolver getSendActionPortReferenceResolver() {
		return sendActionPortReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.TransitionTargetReferenceResolver getTransitionTargetReferenceResolver() {
		return transitionTargetReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.ReceiveMessageMessageReferenceResolver getReceiveMessageMessageReferenceResolver() {
		return receiveMessageMessageReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.ConnectorPort1ReferenceResolver getConnectorPort1ReferenceResolver() {
		return connectorPort1ReferenceResolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.analysis.ConnectorPort2ReferenceResolver getConnectorPort2ReferenceResolver() {
		return connectorPort2ReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		instantiationStrategyAdviceElementsReferenceResolver.setOptions(options);
		scopedInstantiationPointcutElementsReferenceResolver.setOptions(options);
		setCompositeStateCompositeStateToSetReferenceResolver.setOptions(options);
		setCompositeStateInitialReferenceResolver.setOptions(options);
		setCompositeStateSubstateReferenceResolver.setOptions(options);
		unsetCompositeStateCompositeStateToUnsetReferenceResolver.setOptions(options);
		unsetCompositeStateInitialReferenceResolver.setOptions(options);
		unsetCompositeStateSubstateReferenceResolver.setOptions(options);
		setStateStateToSetReferenceResolver.setOptions(options);
		setStateOutgoingReferenceResolver.setOptions(options);
		setStateIncomingReferenceResolver.setOptions(options);
		setStateEntryReferenceResolver.setOptions(options);
		setStateExitReferenceResolver.setOptions(options);
		setStatePropertiesReferenceResolver.setOptions(options);
		unsetStateStateToUnsetReferenceResolver.setOptions(options);
		unsetStateOutgoingReferenceResolver.setOptions(options);
		unsetStateIncomingReferenceResolver.setOptions(options);
		unsetStateEntryReferenceResolver.setOptions(options);
		unsetStateExitReferenceResolver.setOptions(options);
		unsetStatePropertiesReferenceResolver.setOptions(options);
		setTransitionTransitionToSetReferenceResolver.setOptions(options);
		setTransitionEventReferenceResolver.setOptions(options);
		setTransitionGuardReferenceResolver.setOptions(options);
		setTransitionActionReferenceResolver.setOptions(options);
		setTransitionTargetReferenceResolver.setOptions(options);
		setTransitionSourceReferenceResolver.setOptions(options);
		unsetTransitionTransitionToUnsetReferenceResolver.setOptions(options);
		unsetTransitionEventReferenceResolver.setOptions(options);
		unsetTransitionGuardReferenceResolver.setOptions(options);
		unsetTransitionActionReferenceResolver.setOptions(options);
		unsetTransitionTargetReferenceResolver.setOptions(options);
		unsetTransitionSourceReferenceResolver.setOptions(options);
		setAnnotatedElementAnnotatedElementToSetReferenceResolver.setOptions(options);
		setAnnotatedElementAnnotationsReferenceResolver.setOptions(options);
		setActionBlockBlockToSetReferenceResolver.setOptions(options);
		setActionBlockActionsReferenceResolver.setOptions(options);
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
		propertyNavigationPropertyReferenceResolver.setOptions(options);
		sendActionMessageReferenceResolver.setOptions(options);
		sendActionPortReferenceResolver.setOptions(options);
		transitionTargetReferenceResolver.setOptions(options);
		receiveMessageMessageReferenceResolver.setOptions(options);
		connectorPort1ReferenceResolver.setOptions(options);
		connectorPort2ReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (smartadapters4MODERATES.Smartadapters4MODERATESPackage.eINSTANCE.getInstantiationStrategy().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.AspectModelElement> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.AspectModelElement>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("adviceElements")) {
				instantiationStrategyAdviceElementsReferenceResolver.resolve(identifier, (smartadapters4MODERATES.InstantiationStrategy) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.Smartadapters4MODERATESPackage.eINSTANCE.getScopedInstantiation().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.AspectModelElement> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.AspectModelElement>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("pointcutElements")) {
				scopedInstantiationPointcutElementsReferenceResolver.resolve(identifier, (smartadapters4MODERATES.ScopedInstantiation) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetCompositeState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.CompositeState> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.CompositeState>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("CompositeStateToSet")) {
				setCompositeStateCompositeStateToSetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetCompositeState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetCompositeState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("initial")) {
				setCompositeStateInitialReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetCompositeState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetCompositeState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("substate")) {
				setCompositeStateSubstateReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetCompositeState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetCompositeState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.CompositeState> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.CompositeState>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("CompositeStateToUnset")) {
				unsetCompositeStateCompositeStateToUnsetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetCompositeState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetCompositeState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("initial")) {
				unsetCompositeStateInitialReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetCompositeState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetCompositeState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("substate")) {
				unsetCompositeStateSubstateReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetCompositeState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("StateToSet")) {
				setStateStateToSetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Transition> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Transition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("outgoing")) {
				setStateOutgoingReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Transition> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Transition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("incoming")) {
				setStateIncomingReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Action> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Action>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("entry")) {
				setStateEntryReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Action> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Action>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("exit")) {
				setStateExitReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Property> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Property>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("properties")) {
				setStatePropertiesReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("StateToUnset")) {
				unsetStateStateToUnsetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Transition> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Transition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("outgoing")) {
				unsetStateOutgoingReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Transition> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Transition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("incoming")) {
				unsetStateIncomingReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Action> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Action>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("entry")) {
				unsetStateEntryReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Action> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Action>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("exit")) {
				unsetStateExitReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Property> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Property>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("properties")) {
				unsetStatePropertiesReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Transition> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Transition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("TransitionToSet")) {
				setTransitionTransitionToSetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Event> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Event>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("event")) {
				setTransitionEventReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Expression> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Expression>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("guard")) {
				setTransitionGuardReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Action> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Action>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("action")) {
				setTransitionActionReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				setTransitionTargetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("source")) {
				setTransitionSourceReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Transition> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Transition>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("TransitionToUnset")) {
				unsetTransitionTransitionToUnsetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Event> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Event>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("event")) {
				unsetTransitionEventReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Expression> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Expression>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("guard")) {
				unsetTransitionGuardReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Action> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Action>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("action")) {
				unsetTransitionActionReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				unsetTransitionTargetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("source")) {
				unsetTransitionSourceReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.UnsetTransition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetAnnotatedElement().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.AnnotatedElement> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.AnnotatedElement>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("AnnotatedElementToSet")) {
				setAnnotatedElementAnnotatedElementToSetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetAnnotatedElement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetAnnotatedElement().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.PlatformAnnotation> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.PlatformAnnotation>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("annotations")) {
				setAnnotatedElementAnnotationsReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetAnnotatedElement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetActionBlock().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.ActionBlock> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.ActionBlock>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("blockToSet")) {
				setActionBlockBlockToSetReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetActionBlock) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetActionBlock().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Action> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Action>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("actions")) {
				setActionBlockActionsReferenceResolver.resolve(identifier, (smartadapters4MODERATES.adaptations.SetActionBlock) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getEdapModel().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.EdapModel> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.EdapModel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("imports")) {
				edapModelImportsReferenceResolver.resolve(identifier, (edap_relaxed.EdapModel) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getComponent().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Message> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Message>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("receives")) {
				componentReceivesReferenceResolver.resolve(identifier, (edap_relaxed.Component) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getComponent().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Message> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Message>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("sends")) {
				componentSendsReferenceResolver.resolve(identifier, (edap_relaxed.Component) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getSimulator().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Device> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Device>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("device")) {
				simulatorDeviceReferenceResolver.resolve(identifier, (edap_relaxed.Simulator) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getProperty().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Type> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Type>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				propertyTypeReferenceResolver.resolve(identifier, (edap_relaxed.Property) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getDictionary().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Type> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Type>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("indexType")) {
				dictionaryIndexTypeReferenceResolver.resolve(identifier, (edap_relaxed.Dictionary) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getParameter().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Type> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Type>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				parameterTypeReferenceResolver.resolve(identifier, (edap_relaxed.Parameter) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getCompositeState().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("initial")) {
				compositeStateInitialReferenceResolver.resolve(identifier, (edap_relaxed.CompositeState) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getPropertyAssignment().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Property> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Property>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("property")) {
				propertyAssignmentPropertyReferenceResolver.resolve(identifier, (edap_relaxed.PropertyAssignment) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getComponentReference().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Component> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Component>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("component")) {
				componentReferenceComponentReferenceResolver.resolve(identifier, (edap_relaxed.ComponentReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getEventReference().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.ReceiveMessage> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.ReceiveMessage>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("msgRef")) {
				eventReferenceMsgRefReferenceResolver.resolve(identifier, (edap_relaxed.EventReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getEventReference().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Parameter> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Parameter>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("paramRef")) {
				eventReferenceParamRefReferenceResolver.resolve(identifier, (edap_relaxed.EventReference) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getPropertyNavigation().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Property> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Property>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("property")) {
				propertyNavigationPropertyReferenceResolver.resolve(identifier, (edap_relaxed.PropertyNavigation) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getSendAction().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Message> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Message>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("message")) {
				sendActionMessageReferenceResolver.resolve(identifier, (edap_relaxed.SendAction) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getSendAction().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Port> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Port>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("port")) {
				sendActionPortReferenceResolver.resolve(identifier, (edap_relaxed.SendAction) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getTransition().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.State> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.State>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				transitionTargetReferenceResolver.resolve(identifier, (edap_relaxed.Transition) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getReceiveMessage().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Message> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Message>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("message")) {
				receiveMessageMessageReferenceResolver.resolve(identifier, (edap_relaxed.ReceiveMessage) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getConnector().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Port> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Port>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("port1")) {
				connectorPort1ReferenceResolver.resolve(identifier, (edap_relaxed.Connector) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edap_relaxed.Edap_relaxedPackage.eINSTANCE.getConnector().isInstance(container)) {
			Edap_aspectFuzzyResolveResult<edap_relaxed.Port> frr = new Edap_aspectFuzzyResolveResult<edap_relaxed.Port>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("port2")) {
				connectorPort2ReferenceResolver.resolve(identifier, (edap_relaxed.Connector) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == smartadapters4MODERATES.Smartadapters4MODERATESPackage.eINSTANCE.getInstantiationStrategy_AdviceElements()) {
			return instantiationStrategyAdviceElementsReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.Smartadapters4MODERATESPackage.eINSTANCE.getScopedInstantiation_PointcutElements()) {
			return scopedInstantiationPointcutElementsReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetCompositeState_CompositeStateToSet()) {
			return setCompositeStateCompositeStateToSetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetCompositeState_Initial()) {
			return setCompositeStateInitialReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetCompositeState_Substate()) {
			return setCompositeStateSubstateReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetCompositeState_CompositeStateToUnset()) {
			return unsetCompositeStateCompositeStateToUnsetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetCompositeState_Initial()) {
			return unsetCompositeStateInitialReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetCompositeState_Substate()) {
			return unsetCompositeStateSubstateReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState_StateToSet()) {
			return setStateStateToSetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState_Outgoing()) {
			return setStateOutgoingReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState_Incoming()) {
			return setStateIncomingReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState_Entry()) {
			return setStateEntryReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState_Exit()) {
			return setStateExitReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetState_Properties()) {
			return setStatePropertiesReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState_StateToUnset()) {
			return unsetStateStateToUnsetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState_Outgoing()) {
			return unsetStateOutgoingReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState_Incoming()) {
			return unsetStateIncomingReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState_Entry()) {
			return unsetStateEntryReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState_Exit()) {
			return unsetStateExitReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetState_Properties()) {
			return unsetStatePropertiesReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition_TransitionToSet()) {
			return setTransitionTransitionToSetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition_Event()) {
			return setTransitionEventReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition_Guard()) {
			return setTransitionGuardReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition_Action()) {
			return setTransitionActionReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition_Target()) {
			return setTransitionTargetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetTransition_Source()) {
			return setTransitionSourceReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition_TransitionToUnset()) {
			return unsetTransitionTransitionToUnsetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition_Event()) {
			return unsetTransitionEventReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition_Guard()) {
			return unsetTransitionGuardReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition_Action()) {
			return unsetTransitionActionReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition_Target()) {
			return unsetTransitionTargetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getUnsetTransition_Source()) {
			return unsetTransitionSourceReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetAnnotatedElement_AnnotatedElementToSet()) {
			return setAnnotatedElementAnnotatedElementToSetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetAnnotatedElement_Annotations()) {
			return setAnnotatedElementAnnotationsReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetActionBlock_BlockToSet()) {
			return setActionBlockBlockToSetReferenceResolver;
		}
		if (reference == smartadapters4MODERATES.adaptations.AdaptationsPackage.eINSTANCE.getSetActionBlock_Actions()) {
			return setActionBlockActionsReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getEdapModel_Imports()) {
			return edapModelImportsReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getComponent_Receives()) {
			return componentReceivesReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getComponent_Sends()) {
			return componentSendsReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getSimulator_Device()) {
			return simulatorDeviceReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getProperty_Type()) {
			return propertyTypeReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getDictionary_IndexType()) {
			return dictionaryIndexTypeReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getParameter_Type()) {
			return parameterTypeReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getCompositeState_Initial()) {
			return compositeStateInitialReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getPropertyAssignment_Property()) {
			return propertyAssignmentPropertyReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getComponentReference_Component()) {
			return componentReferenceComponentReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getEventReference_MsgRef()) {
			return eventReferenceMsgRefReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getEventReference_ParamRef()) {
			return eventReferenceParamRefReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getPropertyNavigation_Property()) {
			return propertyNavigationPropertyReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getSendAction_Message()) {
			return sendActionMessageReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getSendAction_Port()) {
			return sendActionPortReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getTransition_Target()) {
			return transitionTargetReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getReceiveMessage_Message()) {
			return receiveMessageMessageReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getConnector_Port1()) {
			return connectorPort1ReferenceResolver;
		}
		if (reference == edap_relaxed.Edap_relaxedPackage.eINSTANCE.getConnector_Port2()) {
			return connectorPort2ReferenceResolver;
		}
		return null;
	}
	
}
