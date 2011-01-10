/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

import smartadapters4MODERATES.resource.edap_aspect.analysis.utils.IntraPatternResolverDelegate;

public class PropertyAssignmentPropertyReferenceResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<edap_relaxed.PropertyAssignment, edap_relaxed.Property> {
	
	private IntraPatternResolverDelegate<edap_relaxed.PropertyAssignment, edap_relaxed.Property> delegate = new IntraPatternResolverDelegate<edap_relaxed.PropertyAssignment, edap_relaxed.Property>();
	
	public void resolve(String identifier, edap_relaxed.PropertyAssignment container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<edap_relaxed.Property> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap_relaxed.Property element, edap_relaxed.PropertyAssignment container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
