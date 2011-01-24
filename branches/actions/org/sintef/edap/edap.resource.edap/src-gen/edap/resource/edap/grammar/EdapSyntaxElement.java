/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class EdapSyntaxElement {
	
	private EdapSyntaxElement[] children;
	private EdapSyntaxElement parent;
	private edap.resource.edap.grammar.EdapCardinality cardinality;
	
	public EdapSyntaxElement(edap.resource.edap.grammar.EdapCardinality cardinality, EdapSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (EdapSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	public void setParent(EdapSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public EdapSyntaxElement[] getChildren() {
		if (children == null) {
			return new EdapSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public edap.resource.edap.grammar.EdapCardinality getCardinality() {
		return cardinality;
	}
	
}
