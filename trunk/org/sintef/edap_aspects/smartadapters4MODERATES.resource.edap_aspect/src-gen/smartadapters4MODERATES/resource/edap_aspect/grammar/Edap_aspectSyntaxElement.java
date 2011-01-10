/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class Edap_aspectSyntaxElement {
	
	private Edap_aspectSyntaxElement[] children;
	private Edap_aspectSyntaxElement parent;
	private smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality;
	
	public Edap_aspectSyntaxElement(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality, Edap_aspectSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (Edap_aspectSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	public void setParent(Edap_aspectSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public Edap_aspectSyntaxElement[] getChildren() {
		if (children == null) {
			return new Edap_aspectSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality getCardinality() {
		return cardinality;
	}
	
}
