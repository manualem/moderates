/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

import edap.State;

public class CompositeStateInitialReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.CompositeState, edap.State> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.CompositeState, edap.State> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.CompositeState, edap.State>();
	
	public void resolve(java.lang.String identifier, edap.CompositeState container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.State> result) {
		
		for(State s : container.getSubstate()) {
			if (s.getName().startsWith(identifier)) {
				result.addMapping(s.getName(), s);
			}
		}
		
		if (!result.wasResolved()) {
			result.setErrorMessage("Cannot resolve initial state " + identifier);
		}
		
	}
	
	public java.lang.String deResolve(edap.State element, edap.CompositeState container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
