/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IEdap_aspectParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectCommand<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource>> getPostParseCommands();
	
}
