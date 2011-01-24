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
import edap.Type;

public class SendActionMessageReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.SendAction, edap.Message> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.SendAction, edap.Message> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.SendAction, edap.Message>();
	
	public void resolve(java.lang.String identifier, edap.SendAction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Message> result) {

		String message = identifier;
		Expression ref = container.getTarget();
		Type td = EDAPHelpers.getExpressionType(ref);
		
			if (td != null && td instanceof Component) {
			Component d = (Component)td;
			
			Component cd = EDAPHelpers.findContainingComponent(container);
			
			if (d == cd) {
				for (Message m : d.getSends()) {
					if (m.getName().startsWith(message) && m instanceof Message) {
						if (resolveFuzzy || m.getName().equals(message))
							result.addMapping(m.getName(), m);
					}
				}
			}
			else {
				for (Message m : d.getReceives()) {
					if (m.getName().startsWith(message) && m instanceof Message) {
						if (resolveFuzzy || m.getName().equals(message))
							result.addMapping(m.getName(), m);
					}
				}
			}
			if (!result.wasResolved())
				result.setErrorMessage("Cannot resolve message to send: " + identifier);
		}
		else {
			result.setErrorMessage("Unable to resolve target component");
		}
	}
	
	public java.lang.String deResolve(edap.Message element, edap.SendAction container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
