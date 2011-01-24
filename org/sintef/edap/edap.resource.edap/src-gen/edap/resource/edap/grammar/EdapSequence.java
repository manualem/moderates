/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

public class EdapSequence extends edap.resource.edap.grammar.EdapSyntaxElement {
	
	public EdapSequence(edap.resource.edap.grammar.EdapCardinality cardinality, edap.resource.edap.grammar.EdapSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return edap.resource.edap.util.EdapStringUtil.explode(getChildren(), " ");
	}
	
}
