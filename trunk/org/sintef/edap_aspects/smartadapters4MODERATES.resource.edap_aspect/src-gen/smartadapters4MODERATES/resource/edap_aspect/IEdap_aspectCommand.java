/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IEdap_aspectCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
