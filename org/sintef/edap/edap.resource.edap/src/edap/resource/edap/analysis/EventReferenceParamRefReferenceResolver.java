/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

import org.eclipse.emf.ecore.EObject;

import edap.Event;
import edap.Message;
import edap.Parameter;
import edap.ReceiveMessage;
import edap.Transition;

public class EventReferenceParamRefReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.EventReference, edap.Parameter> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.EventReference, edap.Parameter> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.EventReference, edap.Parameter>();
	
	public void resolve(String identifier, edap.EventReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Parameter> result) {
		// get the transition object
		ReceiveMessage rm = container.getMsgRef();
		if (rm != null) {
			Message m = rm.getMessage();
			for (Parameter p : m.getParameters()) {
				if (resolveFuzzy) {
					if (p.getName().startsWith(identifier))
						result.addMapping(p.getName(), p);
				} else {
					if (p.getName().equalsIgnoreCase(identifier))
						result.addMapping(p.getName(), p);					
				} 
			}
		}
		if (!result.wasResolved())
			result.setErrorMessage("Cannot resolve receive message(event) parameter: " + identifier);
		// delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);		
	}
	
	public String deResolve(edap.Parameter element, edap.EventReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
