/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectParseResult implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectCommand<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource>> commands = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectCommand<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource>>();
	
	public Edap_aspectParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectCommand<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
