/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class EdapPlaceholder extends edap.resource.edap.grammar.EdapTerminal {
	
	private final String tokenName;
	
	public EdapPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, edap.resource.edap.grammar.EdapCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
