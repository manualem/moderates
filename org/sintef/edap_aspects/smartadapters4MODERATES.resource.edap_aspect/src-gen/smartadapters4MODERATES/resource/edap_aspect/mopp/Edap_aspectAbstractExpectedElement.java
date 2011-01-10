/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class Edap_aspectAbstractExpectedElement implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	private java.util.Set<smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectPair<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> followers = new java.util.LinkedHashSet<smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectPair<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>>();
	
	public Edap_aspectAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path) {
		followers.add(new smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectPair<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>(follower, path));
	}
	
	public java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectPair<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers() {
		return followers;
	}
	
}
