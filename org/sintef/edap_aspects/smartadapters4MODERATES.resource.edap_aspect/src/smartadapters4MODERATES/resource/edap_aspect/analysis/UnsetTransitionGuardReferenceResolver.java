/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

import smartadapters4MODERATES.resource.edap_aspect.analysis.utils.PIDResolverDelegate;

public class UnsetTransitionGuardReferenceResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<smartadapters4MODERATES.adaptations.UnsetTransition, edap_relaxed.Expression> {
	
	private PIDResolverDelegate<smartadapters4MODERATES.adaptations.UnsetTransition, edap_relaxed.Expression> delegate = new PIDResolverDelegate<smartadapters4MODERATES.adaptations.UnsetTransition, edap_relaxed.Expression>();
	
	public void resolve(String identifier, smartadapters4MODERATES.adaptations.UnsetTransition container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<edap_relaxed.Expression> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap_relaxed.Expression element, smartadapters4MODERATES.adaptations.UnsetTransition container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
