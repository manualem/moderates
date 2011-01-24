/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

public class PropertyReferencePropertyReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.PropertyReference, edap.Property> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.PropertyReference, edap.Property> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.PropertyReference, edap.Property>();
	
	public void resolve(String identifier, edap.PropertyReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Property> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap.Property element, edap.PropertyReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
