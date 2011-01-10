/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class Edap_aspectExpectedBooleanTerminal extends smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectAbstractExpectedElement {
	
	private smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectBooleanTerminal booleanTerminal;
	
	public Edap_aspectExpectedBooleanTerminal(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	private org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Edap_aspectExpectedBooleanTerminal) {
			return getFeature().equals(((Edap_aspectExpectedBooleanTerminal) o).getFeature());
		}
		return false;
	}
	
	public java.util.Set<String> getTokenNames() {
		// BooleanTerminals are associated with two or one token(s)
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>(2);
		String trueLiteral = booleanTerminal.getTrueLiteral();
		if (!"".equals(trueLiteral)) {
			tokenNames.add("'" + trueLiteral + "'");
		}
		String falseLiteral = booleanTerminal.getFalseLiteral();
		if (!"".equals(falseLiteral)) {
			tokenNames.add("'" + falseLiteral + "'");
		}
		return tokenNames;
	}
	
}
