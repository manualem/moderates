/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.grammar;

public class Edap_aspectSequence extends smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement {
	
	public Edap_aspectSequence(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectStringUtil.explode(getChildren(), " ");
	}
	
}
