/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class EdapAbstractExpectedElement implements edap.resource.edap.IEdapExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	private java.util.Set<edap.resource.edap.util.EdapPair<edap.resource.edap.IEdapExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> followers = new java.util.LinkedHashSet<edap.resource.edap.util.EdapPair<edap.resource.edap.IEdapExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>>();
	
	public EdapAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(edap.resource.edap.IEdapExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path) {
		followers.add(new edap.resource.edap.util.EdapPair<edap.resource.edap.IEdapExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>(follower, path));
	}
	
	public java.util.Collection<edap.resource.edap.util.EdapPair<edap.resource.edap.IEdapExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers() {
		return followers;
	}
	
}
