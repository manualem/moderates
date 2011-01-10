/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect;

public interface IEdap_aspectReferenceCache {
	public Object get(String identifier);
	public void put(String identifier, Object target);
}
