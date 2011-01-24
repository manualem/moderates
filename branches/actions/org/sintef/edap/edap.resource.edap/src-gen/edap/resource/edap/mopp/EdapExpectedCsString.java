/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class EdapExpectedCsString extends edap.resource.edap.mopp.EdapAbstractExpectedElement {
	
	private edap.resource.edap.grammar.EdapKeyword keyword;
	
	public EdapExpectedCsString(edap.resource.edap.grammar.EdapKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof EdapExpectedCsString) {
			return getValue().equals(((EdapExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
