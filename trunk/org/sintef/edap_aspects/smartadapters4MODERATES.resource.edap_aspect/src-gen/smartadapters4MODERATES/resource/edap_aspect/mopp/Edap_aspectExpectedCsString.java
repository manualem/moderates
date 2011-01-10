/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class Edap_aspectExpectedCsString extends smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectAbstractExpectedElement {
	
	private smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectKeyword keyword;
	
	public Edap_aspectExpectedCsString(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectKeyword keyword) {
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
		if (o instanceof Edap_aspectExpectedCsString) {
			return getValue().equals(((Edap_aspectExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
