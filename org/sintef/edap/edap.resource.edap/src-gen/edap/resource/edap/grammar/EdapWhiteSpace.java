/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

public class EdapWhiteSpace extends edap.resource.edap.grammar.EdapFormattingElement {
	
	private final int amount;
	
	public EdapWhiteSpace(int amount, edap.resource.edap.grammar.EdapCardinality cardinality) {
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
