/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap;

public interface IEdapBuilder {
	
	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri);
	
	public org.eclipse.core.runtime.IStatus build(edap.resource.edap.mopp.EdapResource resource, org.eclipse.core.runtime.IProgressMonitor monitor);
}
