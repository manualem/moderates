/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IEdapCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
