/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

import org.sintef.edap.EDAPHelpers;

import edap.Component;
import edap.Expression;
import edap.Message;
import edap.Message;
import edap.Type;

public class ReceiveMessageMessageReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.ReceiveMessage, Message> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.ReceiveMessage, Message> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.ReceiveMessage, Message>();
	
	public void resolve(java.lang.String identifier, edap.ReceiveMessage container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<Message> result) {
		
		try {
		
		String message = identifier;
		Expression ref = container.getDevice();
		Type td = EDAPHelpers.getExpressionType(ref);
		
		if (td != null && td instanceof Component) {
			Component d = (Component)td;
			
			Component cd = EDAPHelpers.findContainingComponent(container);
			
			if (d == cd) {
				for (Message m : d.getReceives()) {
					if (m.getName().startsWith(message) && m instanceof Message) {
						if (resolveFuzzy || m.getName().equals(message))
							result.addMapping(m.getName(), m);
					}
				}
			}
			else {
				for (Message m : d.getSends()) {
					if (m.getName().startsWith(message) && m instanceof Message) {
						if (resolveFuzzy || m.getName().equals(message))
							result.addMapping(m.getName(), m);
					}
				}
			}
			if (!result.wasResolved())
				result.setErrorMessage("Cannot resolve message: " + identifier);
		}
		else {
			result.setErrorMessage("Unable to resolve component");
		}
		
		}
		catch (Exception e) {
			result.setErrorMessage("Exception in resolver");
		}
	}
	
	public java.lang.String deResolve(Message element, edap.ReceiveMessage container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
