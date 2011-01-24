/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

public class EdapCompound extends edap.resource.edap.grammar.EdapSyntaxElement {
	
	public EdapCompound(edap.resource.edap.grammar.EdapChoice choice, edap.resource.edap.grammar.EdapCardinality cardinality) {
		super(cardinality, new edap.resource.edap.grammar.EdapSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
