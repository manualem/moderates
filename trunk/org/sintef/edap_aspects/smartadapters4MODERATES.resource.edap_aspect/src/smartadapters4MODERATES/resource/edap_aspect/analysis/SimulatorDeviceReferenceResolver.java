/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

import smartadapters4MODERATES.resource.edap_aspect.analysis.utils.IntraPatternResolverDelegate;

public class SimulatorDeviceReferenceResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<edap_relaxed.Simulator, edap_relaxed.Device> {
	
	private IntraPatternResolverDelegate<edap_relaxed.Simulator, edap_relaxed.Device> delegate = new IntraPatternResolverDelegate<edap_relaxed.Simulator, edap_relaxed.Device>();
	
	public void resolve(String identifier, edap_relaxed.Simulator container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<edap_relaxed.Device> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap_relaxed.Device element, edap_relaxed.Simulator container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
