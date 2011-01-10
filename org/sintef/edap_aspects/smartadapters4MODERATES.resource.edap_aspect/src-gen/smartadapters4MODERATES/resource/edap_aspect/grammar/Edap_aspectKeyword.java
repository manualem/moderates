/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class Edap_aspectKeyword extends smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement {
	
	private final String value;
	
	public Edap_aspectKeyword(String value, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
