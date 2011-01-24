/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

public class EdapChoice extends edap.resource.edap.grammar.EdapSyntaxElement {
	
	public EdapChoice(edap.resource.edap.grammar.EdapCardinality cardinality, edap.resource.edap.grammar.EdapSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return edap.resource.edap.util.EdapStringUtil.explode(getChildren(), "|");
	}
	
}
