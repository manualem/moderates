/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

import smartadapters4MODERATES.resource.edap_aspect.analysis.utils.IntraPatternResolverDelegate;

public class PropertyTypeReferenceResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<edap_relaxed.Property, edap_relaxed.Type> {
	
	private IntraPatternResolverDelegate<edap_relaxed.Property, edap_relaxed.Type> delegate = new IntraPatternResolverDelegate<edap_relaxed.Property, edap_relaxed.Type>();
	
	public void resolve(String identifier, edap_relaxed.Property container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<edap_relaxed.Type> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap_relaxed.Type element, edap_relaxed.Property container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
