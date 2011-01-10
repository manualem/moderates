/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IEdap_aspectResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectResourcePostProcessor getResourcePostProcessor();
	
}
