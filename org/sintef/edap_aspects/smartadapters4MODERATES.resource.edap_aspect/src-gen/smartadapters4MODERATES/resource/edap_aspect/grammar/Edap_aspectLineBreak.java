/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.grammar;

public class Edap_aspectLineBreak extends smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement {
	
	private final int tabs;
	
	public Edap_aspectLineBreak(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality, int tabs) {
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
