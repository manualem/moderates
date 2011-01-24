/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

public class EdapContainment extends edap.resource.edap.grammar.EdapTerminal {
	
	public EdapContainment(org.eclipse.emf.ecore.EStructuralFeature feature, edap.resource.edap.grammar.EdapCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
	}
	
	public String toString() {
		return getFeature().getName();
	}
	
}
