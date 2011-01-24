/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.grammar;

public class EdapLineBreak extends edap.resource.edap.grammar.EdapFormattingElement {
	
	private final int tabs;
	
	public EdapLineBreak(edap.resource.edap.grammar.EdapCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
