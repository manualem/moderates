/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IEdapParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>> getPostParseCommands();
	
}
