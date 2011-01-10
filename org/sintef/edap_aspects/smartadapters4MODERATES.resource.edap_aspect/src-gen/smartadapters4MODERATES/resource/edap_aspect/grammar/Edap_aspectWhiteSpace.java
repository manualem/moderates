/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.grammar;

public class Edap_aspectWhiteSpace extends smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement {
	
	private final int amount;
	
	public Edap_aspectWhiteSpace(int amount, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
