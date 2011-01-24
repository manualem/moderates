/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

public class EdapParseResult implements edap.resource.edap.IEdapParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>> commands = new java.util.ArrayList<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>>();
	
	public EdapParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
