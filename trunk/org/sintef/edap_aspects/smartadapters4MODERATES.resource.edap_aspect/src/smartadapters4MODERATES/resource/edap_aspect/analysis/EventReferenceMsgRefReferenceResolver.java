/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

import smartadapters4MODERATES.resource.edap_aspect.analysis.utils.IntraPatternResolverDelegate;

public class EventReferenceMsgRefReferenceResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<edap_relaxed.EventReference, edap_relaxed.ReceiveMessage> {
	
	private IntraPatternResolverDelegate<edap_relaxed.EventReference, edap_relaxed.ReceiveMessage> delegate = new IntraPatternResolverDelegate<edap_relaxed.EventReference, edap_relaxed.ReceiveMessage>();
	
	public void resolve(String identifier, edap_relaxed.EventReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<edap_relaxed.ReceiveMessage> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap_relaxed.ReceiveMessage element, edap_relaxed.EventReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
