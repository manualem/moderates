/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IEdapResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public edap.resource.edap.IEdapResourcePostProcessor getResourcePostProcessor();
	
}
