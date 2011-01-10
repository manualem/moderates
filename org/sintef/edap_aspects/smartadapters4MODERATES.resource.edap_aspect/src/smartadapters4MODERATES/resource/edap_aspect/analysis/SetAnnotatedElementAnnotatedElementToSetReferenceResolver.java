/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

import smartadapters4MODERATES.resource.edap_aspect.analysis.utils.PIDResolverDelegate;

public class SetAnnotatedElementAnnotatedElementToSetReferenceResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<smartadapters4MODERATES.adaptations.SetAnnotatedElement, edap_relaxed.AnnotatedElement> {
	
	private PIDResolverDelegate<smartadapters4MODERATES.adaptations.SetAnnotatedElement, edap_relaxed.AnnotatedElement> delegate = new PIDResolverDelegate<smartadapters4MODERATES.adaptations.SetAnnotatedElement, edap_relaxed.AnnotatedElement>();
	
	public void resolve(String identifier, smartadapters4MODERATES.adaptations.SetAnnotatedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<edap_relaxed.AnnotatedElement> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap_relaxed.AnnotatedElement element, smartadapters4MODERATES.adaptations.SetAnnotatedElement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
