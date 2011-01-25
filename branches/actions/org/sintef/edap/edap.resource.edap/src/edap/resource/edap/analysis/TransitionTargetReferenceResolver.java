/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

import edap.CompositeState;
import edap.State;

public class TransitionTargetReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.Transition, edap.State> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Transition, edap.State> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Transition, edap.State>();
	
	public void resolve(java.lang.String identifier, edap.Transition container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.State> result) {
		State s = container.getSource();
		if (s != null) {
			if (s.eContainer() instanceof CompositeState) {
				CompositeState cs = (CompositeState)s.eContainer();
				for(State t : cs.getSubstate()) {
					if (t.getName().startsWith(identifier))
						if (resolveFuzzy || t.getName().equals(identifier))
							result.addMapping(t.getName(), t);
				}
			}
		}
		if (!result.wasResolved())
			result.setErrorMessage("Cannot resolve target state " + identifier);
	}
	
	public java.lang.String deResolve(edap.State element, edap.Transition container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
