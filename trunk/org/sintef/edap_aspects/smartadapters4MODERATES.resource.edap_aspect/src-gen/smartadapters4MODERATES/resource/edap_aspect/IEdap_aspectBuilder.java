/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect;

public interface IEdap_aspectBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
