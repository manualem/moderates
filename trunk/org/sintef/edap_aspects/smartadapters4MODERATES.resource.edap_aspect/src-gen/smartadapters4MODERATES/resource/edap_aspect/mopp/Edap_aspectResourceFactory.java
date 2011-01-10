/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public Edap_aspectResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectResource(uri);
	}
	
}
