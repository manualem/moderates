/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

public class EdapResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public EdapResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new edap.resource.edap.mopp.EdapResource(uri);
	}
	
}
