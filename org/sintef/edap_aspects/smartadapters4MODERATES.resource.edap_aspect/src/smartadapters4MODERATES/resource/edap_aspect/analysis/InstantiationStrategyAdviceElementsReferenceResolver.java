/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

import smartadapters4MODERATES.resource.edap_aspect.analysis.utils.IntraPatternResolverDelegate;

public class InstantiationStrategyAdviceElementsReferenceResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<smartadapters4MODERATES.InstantiationStrategy, edap_relaxed.AspectModelElement> {
	
	private IntraPatternResolverDelegate<smartadapters4MODERATES.InstantiationStrategy, edap_relaxed.AspectModelElement> delegate = new IntraPatternResolverDelegate<smartadapters4MODERATES.InstantiationStrategy, edap_relaxed.AspectModelElement>();
	
	public void resolve(String identifier, smartadapters4MODERATES.InstantiationStrategy container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<edap_relaxed.AspectModelElement> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap_relaxed.AspectModelElement element, smartadapters4MODERATES.InstantiationStrategy container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
