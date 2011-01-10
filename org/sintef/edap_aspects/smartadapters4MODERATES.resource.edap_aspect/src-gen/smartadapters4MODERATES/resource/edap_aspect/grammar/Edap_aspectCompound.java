/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.grammar;

public class Edap_aspectCompound extends smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement {
	
	public Edap_aspectCompound(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectChoice choice, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality) {
		super(cardinality, new smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
