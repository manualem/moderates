/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

import java.util.ArrayList;

import org.sintef.edap.EDAPHelpers;


import edap.EdapModel;
import edap.Message;

public class TransitionEventReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.Transition, Message> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Transition, Message> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Transition, Message>();
	
	public void resolve(java.lang.String identifier, edap.Transition container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<Message> result) {
		String[] ids = identifier.split("::");
		
		if (ids.length != 2) return;
		
		String device = ids[ids.length - 2];
		String message = ids[ids.length - 1];

		
		EdapModel root = EDAPHelpers.findRoot(container);
		
		ArrayList<EdapModel> models = new ArrayList<EdapModel>();
		models.add(root);
					
		for ( EdapModel d : root.getImports()) {
			Message m = EDAPHelpers.findMessage(device, message, d);
			if (m != null && m instanceof Message) {
				result.addMapping(identifier, m);
				break;
			}
		}
	}
	
	public java.lang.String deResolve(Message element, edap.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
}
