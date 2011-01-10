/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IEdap_aspectExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Adds an element that is a valid follower for this element
	 */
	public void addFollower(smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path);
	
	/**
	 * Returns all valid followers for this element
	 */
	public java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectPair<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers();
	
}
