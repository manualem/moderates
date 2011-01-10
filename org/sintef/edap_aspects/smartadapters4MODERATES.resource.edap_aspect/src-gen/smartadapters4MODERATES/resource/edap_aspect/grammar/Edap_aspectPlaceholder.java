/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class Edap_aspectPlaceholder extends smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectTerminal {
	
	private final String tokenName;
	
	public Edap_aspectPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
