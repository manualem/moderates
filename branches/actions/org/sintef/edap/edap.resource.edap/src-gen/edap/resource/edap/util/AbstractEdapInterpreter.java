/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.util;

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
public class AbstractEdapInterpreter<ResultType, ContextType> {
	
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
		if (object instanceof edap.ExpressionGroup) {
			result = interprete_edap_ExpressionGroup((edap.ExpressionGroup) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.PropertyReference) {
			result = interprete_edap_PropertyReference((edap.PropertyReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.ConditionalAction) {
			result = interprete_edap_ConditionalAction((edap.ConditionalAction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.LoopAction) {
			result = interprete_edap_LoopAction((edap.LoopAction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.ControlStructure) {
			result = interprete_edap_ControlStructure((edap.ControlStructure) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.OrExpression) {
			result = interprete_edap_OrExpression((edap.OrExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.AndExpression) {
			result = interprete_edap_AndExpression((edap.AndExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.LowerExpression) {
			result = interprete_edap_LowerExpression((edap.LowerExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.GreaterExpression) {
			result = interprete_edap_GreaterExpression((edap.GreaterExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.EqualsExpression) {
			result = interprete_edap_EqualsExpression((edap.EqualsExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.ModExpression) {
			result = interprete_edap_ModExpression((edap.ModExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.DivExpression) {
			result = interprete_edap_DivExpression((edap.DivExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.TimesExpression) {
			result = interprete_edap_TimesExpression((edap.TimesExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.MinusExpression) {
			result = interprete_edap_MinusExpression((edap.MinusExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.PlusExpression) {
			result = interprete_edap_PlusExpression((edap.PlusExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.BinaryExpression) {
			result = interprete_edap_BinaryExpression((edap.BinaryExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.UnaryMinus) {
			result = interprete_edap_UnaryMinus((edap.UnaryMinus) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.NotExpression) {
			result = interprete_edap_NotExpression((edap.NotExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.UnaryExpression) {
			result = interprete_edap_UnaryExpression((edap.UnaryExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.DoubleLitteral) {
			result = interprete_edap_DoubleLitteral((edap.DoubleLitteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.StringLitteral) {
			result = interprete_edap_StringLitteral((edap.StringLitteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.BooleanLitteral) {
			result = interprete_edap_BooleanLitteral((edap.BooleanLitteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.IntegerLitteral) {
			result = interprete_edap_IntegerLitteral((edap.IntegerLitteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Litteral) {
			result = interprete_edap_Litteral((edap.Litteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.EventReference) {
			result = interprete_edap_EventReference((edap.EventReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.CreateAction) {
			result = interprete_edap_CreateAction((edap.CreateAction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Port) {
			result = interprete_edap_Port((edap.Port) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Connector) {
			result = interprete_edap_Connector((edap.Connector) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.DictionaryNavigation) {
			result = interprete_edap_DictionaryNavigation((edap.DictionaryNavigation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.PropertyNavigation) {
			result = interprete_edap_PropertyNavigation((edap.PropertyNavigation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.ComponentReference) {
			result = interprete_edap_ComponentReference((edap.ComponentReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Dictionary) {
			result = interprete_edap_Dictionary((edap.Dictionary) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Simulator) {
			result = interprete_edap_Simulator((edap.Simulator) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.ReceiveMessage) {
			result = interprete_edap_ReceiveMessage((edap.ReceiveMessage) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Event) {
			result = interprete_edap_Event((edap.Event) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Device) {
			result = interprete_edap_Device((edap.Device) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.SoftwareComponent) {
			result = interprete_edap_SoftwareComponent((edap.SoftwareComponent) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.PropertyAssignment) {
			result = interprete_edap_PropertyAssignment((edap.PropertyAssignment) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Unicast) {
			result = interprete_edap_Unicast((edap.Unicast) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Broadcast) {
			result = interprete_edap_Broadcast((edap.Broadcast) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.SendAction) {
			result = interprete_edap_SendAction((edap.SendAction) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.ExternExpression) {
			result = interprete_edap_ExternExpression((edap.ExternExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Expression) {
			result = interprete_edap_Expression((edap.Expression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.ExternStatement) {
			result = interprete_edap_ExternStatement((edap.ExternStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.ActionBlock) {
			result = interprete_edap_ActionBlock((edap.ActionBlock) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Action) {
			result = interprete_edap_Action((edap.Action) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.CompositeState) {
			result = interprete_edap_CompositeState((edap.CompositeState) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Transition) {
			result = interprete_edap_Transition((edap.Transition) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.StateMachine) {
			result = interprete_edap_StateMachine((edap.StateMachine) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.State) {
			result = interprete_edap_State((edap.State) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.EnumerationLiteral) {
			result = interprete_edap_EnumerationLiteral((edap.EnumerationLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.PrimitiveType) {
			result = interprete_edap_PrimitiveType((edap.PrimitiveType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Enumeration) {
			result = interprete_edap_Enumeration((edap.Enumeration) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Property) {
			result = interprete_edap_Property((edap.Property) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Component) {
			result = interprete_edap_Component((edap.Component) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Type) {
			result = interprete_edap_Type((edap.Type) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.AnnotatedElement) {
			result = interprete_edap_AnnotatedElement((edap.AnnotatedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.PlatformAnnotation) {
			result = interprete_edap_PlatformAnnotation((edap.PlatformAnnotation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Parameter) {
			result = interprete_edap_Parameter((edap.Parameter) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.Message) {
			result = interprete_edap_Message((edap.Message) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.EdapElement) {
			result = interprete_edap_EdapElement((edap.EdapElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edap.EdapModel) {
			result = interprete_edap_EdapModel((edap.EdapModel) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_edap_EdapModel(edap.EdapModel object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Message(edap.Message object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Component(edap.Component object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Parameter(edap.Parameter object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_EdapElement(edap.EdapElement object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Type(edap.Type object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Property(edap.Property object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_PlatformAnnotation(edap.PlatformAnnotation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Enumeration(edap.Enumeration object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_PrimitiveType(edap.PrimitiveType object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_EnumerationLiteral(edap.EnumerationLiteral object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_AnnotatedElement(edap.AnnotatedElement object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_StateMachine(edap.StateMachine object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Transition(edap.Transition object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_State(edap.State object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_CompositeState(edap.CompositeState object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Action(edap.Action object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_ActionBlock(edap.ActionBlock object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_ExternStatement(edap.ExternStatement object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Expression(edap.Expression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_ExternExpression(edap.ExternExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_SendAction(edap.SendAction object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Broadcast(edap.Broadcast object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Unicast(edap.Unicast object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_PropertyAssignment(edap.PropertyAssignment object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_SoftwareComponent(edap.SoftwareComponent object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Device(edap.Device object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Event(edap.Event object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_ReceiveMessage(edap.ReceiveMessage object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Simulator(edap.Simulator object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Dictionary(edap.Dictionary object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_ComponentReference(edap.ComponentReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_PropertyNavigation(edap.PropertyNavigation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_DictionaryNavigation(edap.DictionaryNavigation object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Connector(edap.Connector object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Port(edap.Port object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_CreateAction(edap.CreateAction object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_EventReference(edap.EventReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_Litteral(edap.Litteral object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_IntegerLitteral(edap.IntegerLitteral object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_BooleanLitteral(edap.BooleanLitteral object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_StringLitteral(edap.StringLitteral object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_DoubleLitteral(edap.DoubleLitteral object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_UnaryExpression(edap.UnaryExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_NotExpression(edap.NotExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_UnaryMinus(edap.UnaryMinus object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_BinaryExpression(edap.BinaryExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_PlusExpression(edap.PlusExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_MinusExpression(edap.MinusExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_TimesExpression(edap.TimesExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_DivExpression(edap.DivExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_ModExpression(edap.ModExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_EqualsExpression(edap.EqualsExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_GreaterExpression(edap.GreaterExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_LowerExpression(edap.LowerExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_AndExpression(edap.AndExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_OrExpression(edap.OrExpression object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_ControlStructure(edap.ControlStructure object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_LoopAction(edap.LoopAction object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_ConditionalAction(edap.ConditionalAction object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_PropertyReference(edap.PropertyReference object, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edap_ExpressionGroup(edap.ExpressionGroup object, ContextType context) {
		return null;
	}
	
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
}
