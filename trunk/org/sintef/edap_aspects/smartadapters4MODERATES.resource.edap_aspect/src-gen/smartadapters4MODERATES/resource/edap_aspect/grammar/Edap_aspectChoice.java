/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.grammar;

public class Edap_aspectChoice extends smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement {
	
	public Edap_aspectChoice(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectStringUtil.explode(getChildren(), "|");
	}
	
}
