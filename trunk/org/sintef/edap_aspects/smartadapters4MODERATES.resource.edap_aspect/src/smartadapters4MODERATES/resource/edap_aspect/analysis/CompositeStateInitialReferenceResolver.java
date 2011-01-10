/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

import smartadapters4MODERATES.resource.edap_aspect.analysis.utils.IntraPatternResolverDelegate;

public class CompositeStateInitialReferenceResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<edap_relaxed.CompositeState, edap_relaxed.State> {
	
	private IntraPatternResolverDelegate<edap_relaxed.CompositeState, edap_relaxed.State> delegate = new IntraPatternResolverDelegate<edap_relaxed.CompositeState, edap_relaxed.State>();
	
	public void resolve(String identifier, edap_relaxed.CompositeState container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<edap_relaxed.State> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap_relaxed.State element, edap_relaxed.CompositeState container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
