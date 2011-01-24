/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class EdapExpectedEnumerationTerminal extends edap.resource.edap.mopp.EdapAbstractExpectedElement {
	
	private edap.resource.edap.grammar.EdapEnumerationTerminal enumerationTerminal;
	
	public EdapExpectedEnumerationTerminal(edap.resource.edap.grammar.EdapEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public edap.resource.edap.grammar.EdapEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
}
