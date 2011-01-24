/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class EdapKeyword extends edap.resource.edap.grammar.EdapSyntaxElement {
	
	private final String value;
	
	public EdapKeyword(String value, edap.resource.edap.grammar.EdapCardinality cardinality) {
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
