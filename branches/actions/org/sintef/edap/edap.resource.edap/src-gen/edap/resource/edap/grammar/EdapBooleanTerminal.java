/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class EdapBooleanTerminal extends edap.resource.edap.grammar.EdapTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public EdapBooleanTerminal(org.eclipse.emf.ecore.EStructuralFeature attribute, String trueLiteral, String falseLiteral, edap.resource.edap.grammar.EdapCardinality cardinality, int mandatoryOccurrencesAfter) {
		super(attribute, cardinality, mandatoryOccurrencesAfter);
		assert attribute instanceof org.eclipse.emf.ecore.EAttribute;
		this.trueLiteral = trueLiteral;
		this.falseLiteral = falseLiteral;
	}
	
	public String getTrueLiteral() {
		return trueLiteral;
	}
	
	public String getFalseLiteral() {
		return falseLiteral;
	}
	
	public org.eclipse.emf.ecore.EAttribute getAttribute() {
		return (org.eclipse.emf.ecore.EAttribute) getFeature();
	}
	
}
