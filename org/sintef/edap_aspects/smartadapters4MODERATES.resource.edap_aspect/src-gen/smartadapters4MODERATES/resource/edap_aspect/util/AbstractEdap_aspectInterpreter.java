/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractEdap_aspectInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		while (!interpretationStack.empty()) {
			org.eclipse.emf.ecore.EObject next = interpretationStack.pop();
			result = interprete(next, context);
			if (!continueInterpretation(result)) {
				break;
			}
		}
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof edap_relaxed.EventReference) {
			result = interprete_edap_005frelaxed_EventReference((edap_relaxed.EventReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.CreateAction) {
			result = interprete_edap_005frelaxed_CreateAction((edap_relaxed.CreateAction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Port) {
			result = interprete_edap_005frelaxed_Port((edap_relaxed.Port) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Connector) {
			result = interprete_edap_005frelaxed_Connector((edap_relaxed.Connector) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.DictionaryNavigation) {
			result = interprete_edap_005frelaxed_DictionaryNavigation((edap_relaxed.DictionaryNavigation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.PropertyNavigation) {
			result = interprete_edap_005frelaxed_PropertyNavigation((edap_relaxed.PropertyNavigation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.ComponentReference) {
			result = interprete_edap_005frelaxed_ComponentReference((edap_relaxed.ComponentReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Dictionary) {
			result = interprete_edap_005frelaxed_Dictionary((edap_relaxed.Dictionary) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Simulator) {
			result = interprete_edap_005frelaxed_Simulator((edap_relaxed.Simulator) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.ReceiveMessage) {
			result = interprete_edap_005frelaxed_ReceiveMessage((edap_relaxed.ReceiveMessage) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Event) {
			result = interprete_edap_005frelaxed_Event((edap_relaxed.Event) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Device) {
			result = interprete_edap_005frelaxed_Device((edap_relaxed.Device) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.SoftwareComponent) {
			result = interprete_edap_005frelaxed_SoftwareComponent((edap_relaxed.SoftwareComponent) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.PropertyAssignment) {
			result = interprete_edap_005frelaxed_PropertyAssignment((edap_relaxed.PropertyAssignment) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Unicast) {
			result = interprete_edap_005frelaxed_Unicast((edap_relaxed.Unicast) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Broadcast) {
			result = interprete_edap_005frelaxed_Broadcast((edap_relaxed.Broadcast) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.SendAction) {
			result = interprete_edap_005frelaxed_SendAction((edap_relaxed.SendAction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.ExternExpression) {
			result = interprete_edap_005frelaxed_ExternExpression((edap_relaxed.ExternExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Expression) {
			result = interprete_edap_005frelaxed_Expression((edap_relaxed.Expression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.ExternStatement) {
			result = interprete_edap_005frelaxed_ExternStatement((edap_relaxed.ExternStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.ActionBlock) {
			result = interprete_edap_005frelaxed_ActionBlock((edap_relaxed.ActionBlock) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Action) {
			result = interprete_edap_005frelaxed_Action((edap_relaxed.Action) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Transition) {
			result = interprete_edap_005frelaxed_Transition((edap_relaxed.Transition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.StateMachine) {
			result = interprete_edap_005frelaxed_StateMachine((edap_relaxed.StateMachine) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.CompositeState) {
			result = interprete_edap_005frelaxed_CompositeState((edap_relaxed.CompositeState) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.State) {
			result = interprete_edap_005frelaxed_State((edap_relaxed.State) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.EnumerationLiteral) {
			result = interprete_edap_005frelaxed_EnumerationLiteral((edap_relaxed.EnumerationLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.PrimitiveType) {
			result = interprete_edap_005frelaxed_PrimitiveType((edap_relaxed.PrimitiveType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Enumeration) {
			result = interprete_edap_005frelaxed_Enumeration((edap_relaxed.Enumeration) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.AnnotatedElement) {
			result = interprete_edap_005frelaxed_AnnotatedElement((edap_relaxed.AnnotatedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.PlatformAnnotation) {
			result = interprete_edap_005frelaxed_PlatformAnnotation((edap_relaxed.PlatformAnnotation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Property) {
			result = interprete_edap_005frelaxed_Property((edap_relaxed.Property) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Type) {
			result = interprete_edap_005frelaxed_Type((edap_relaxed.Type) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Parameter) {
			result = interprete_edap_005frelaxed_Parameter((edap_relaxed.Parameter) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Component) {
			result = interprete_edap_005frelaxed_Component((edap_relaxed.Component) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.Message) {
			result = interprete_edap_005frelaxed_Message((edap_relaxed.Message) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.EdapElement) {
			result = interprete_edap_005frelaxed_EdapElement((edap_relaxed.EdapElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.EdapModel) {
			result = interprete_edap_005frelaxed_EdapModel((edap_relaxed.EdapModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap_relaxed.AspectModelElement) {
			result = interprete_edap_005frelaxed_AspectModelElement((edap_relaxed.AspectModelElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.adaptations.SetActionBlock) {
			result = interprete_smartadapters4MODERATES_adaptations_SetActionBlock((smartadapters4MODERATES.adaptations.SetActionBlock) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.adaptations.SetAnnotatedElement) {
			result = interprete_smartadapters4MODERATES_adaptations_SetAnnotatedElement((smartadapters4MODERATES.adaptations.SetAnnotatedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.adaptations.UnsetTransition) {
			result = interprete_smartadapters4MODERATES_adaptations_UnsetTransition((smartadapters4MODERATES.adaptations.UnsetTransition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.adaptations.SetTransition) {
			result = interprete_smartadapters4MODERATES_adaptations_SetTransition((smartadapters4MODERATES.adaptations.SetTransition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.adaptations.UnsetState) {
			result = interprete_smartadapters4MODERATES_adaptations_UnsetState((smartadapters4MODERATES.adaptations.UnsetState) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.adaptations.SetState) {
			result = interprete_smartadapters4MODERATES_adaptations_SetState((smartadapters4MODERATES.adaptations.SetState) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.adaptations.UnsetCompositeState) {
			result = interprete_smartadapters4MODERATES_adaptations_UnsetCompositeState((smartadapters4MODERATES.adaptations.UnsetCompositeState) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.adaptations.SetCompositeState) {
			result = interprete_smartadapters4MODERATES_adaptations_SetCompositeState((smartadapters4MODERATES.adaptations.SetCompositeState) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.PerElementMatch) {
			result = interprete_smartadapters4MODERATES_PerElementMatch((smartadapters4MODERATES.PerElementMatch) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.PerRoleMatch) {
			result = interprete_smartadapters4MODERATES_PerRoleMatch((smartadapters4MODERATES.PerRoleMatch) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.ScopedInstantiation) {
			result = interprete_smartadapters4MODERATES_ScopedInstantiation((smartadapters4MODERATES.ScopedInstantiation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.GlobalInstantiation) {
			result = interprete_smartadapters4MODERATES_GlobalInstantiation((smartadapters4MODERATES.GlobalInstantiation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.InstantiationStrategy) {
			result = interprete_smartadapters4MODERATES_InstantiationStrategy((smartadapters4MODERATES.InstantiationStrategy) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.PointcutModel) {
			result = interprete_smartadapters4MODERATES_PointcutModel((smartadapters4MODERATES.PointcutModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.AdviceModel) {
			result = interprete_smartadapters4MODERATES_AdviceModel((smartadapters4MODERATES.AdviceModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.UnsetAdaptation) {
			result = interprete_smartadapters4MODERATES_UnsetAdaptation((smartadapters4MODERATES.UnsetAdaptation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.SetAdaptation) {
			result = interprete_smartadapters4MODERATES_SetAdaptation((smartadapters4MODERATES.SetAdaptation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.CreateAdaptation) {
			result = interprete_smartadapters4MODERATES_CreateAdaptation((smartadapters4MODERATES.CreateAdaptation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.CloneAdaptation) {
			result = interprete_smartadapters4MODERATES_CloneAdaptation((smartadapters4MODERATES.CloneAdaptation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.Adaptation) {
			result = interprete_smartadapters4MODERATES_Adaptation((smartadapters4MODERATES.Adaptation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof smartadapters4MODERATES.Aspect) {
			result = interprete_smartadapters4MODERATES_Aspect((smartadapters4MODERATES.Aspect) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_smartadapters4MODERATES_Aspect(smartadapters4MODERATES.Aspect object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_Adaptation(smartadapters4MODERATES.Adaptation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_CloneAdaptation(smartadapters4MODERATES.CloneAdaptation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_CreateAdaptation(smartadapters4MODERATES.CreateAdaptation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_SetAdaptation(smartadapters4MODERATES.SetAdaptation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_UnsetAdaptation(smartadapters4MODERATES.UnsetAdaptation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_AdviceModel(smartadapters4MODERATES.AdviceModel object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_PointcutModel(smartadapters4MODERATES.PointcutModel object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_InstantiationStrategy(smartadapters4MODERATES.InstantiationStrategy object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_GlobalInstantiation(smartadapters4MODERATES.GlobalInstantiation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_ScopedInstantiation(smartadapters4MODERATES.ScopedInstantiation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_PerRoleMatch(smartadapters4MODERATES.PerRoleMatch object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_PerElementMatch(smartadapters4MODERATES.PerElementMatch object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_adaptations_SetCompositeState(smartadapters4MODERATES.adaptations.SetCompositeState object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_adaptations_UnsetCompositeState(smartadapters4MODERATES.adaptations.UnsetCompositeState object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_adaptations_SetState(smartadapters4MODERATES.adaptations.SetState object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_adaptations_UnsetState(smartadapters4MODERATES.adaptations.UnsetState object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_adaptations_SetTransition(smartadapters4MODERATES.adaptations.SetTransition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_adaptations_UnsetTransition(smartadapters4MODERATES.adaptations.UnsetTransition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_adaptations_SetAnnotatedElement(smartadapters4MODERATES.adaptations.SetAnnotatedElement object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_smartadapters4MODERATES_adaptations_SetActionBlock(smartadapters4MODERATES.adaptations.SetActionBlock object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_EdapModel(edap_relaxed.EdapModel object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Message(edap_relaxed.Message object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Component(edap_relaxed.Component object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Parameter(edap_relaxed.Parameter object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_EdapElement(edap_relaxed.EdapElement object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Type(edap_relaxed.Type object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Property(edap_relaxed.Property object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_PlatformAnnotation(edap_relaxed.PlatformAnnotation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Enumeration(edap_relaxed.Enumeration object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_PrimitiveType(edap_relaxed.PrimitiveType object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_EnumerationLiteral(edap_relaxed.EnumerationLiteral object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_AnnotatedElement(edap_relaxed.AnnotatedElement object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_StateMachine(edap_relaxed.StateMachine object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Transition(edap_relaxed.Transition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_State(edap_relaxed.State object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_CompositeState(edap_relaxed.CompositeState object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Action(edap_relaxed.Action object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_ActionBlock(edap_relaxed.ActionBlock object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_ExternStatement(edap_relaxed.ExternStatement object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Expression(edap_relaxed.Expression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_ExternExpression(edap_relaxed.ExternExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_SendAction(edap_relaxed.SendAction object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Broadcast(edap_relaxed.Broadcast object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Unicast(edap_relaxed.Unicast object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_PropertyAssignment(edap_relaxed.PropertyAssignment object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_SoftwareComponent(edap_relaxed.SoftwareComponent object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Device(edap_relaxed.Device object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Event(edap_relaxed.Event object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_ReceiveMessage(edap_relaxed.ReceiveMessage object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Simulator(edap_relaxed.Simulator object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Dictionary(edap_relaxed.Dictionary object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_ComponentReference(edap_relaxed.ComponentReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_PropertyNavigation(edap_relaxed.PropertyNavigation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_DictionaryNavigation(edap_relaxed.DictionaryNavigation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Connector(edap_relaxed.Connector object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_Port(edap_relaxed.Port object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_CreateAction(edap_relaxed.CreateAction object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_EventReference(edap_relaxed.EventReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_005frelaxed_AspectModelElement(edap_relaxed.AspectModelElement object, ContextType context) {
		return null;
	}
	
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
}
