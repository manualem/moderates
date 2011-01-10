/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private Edap_aspectSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public Edap_aspectSyntaxElementDecorator(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement decoratedElement, Edap_aspectSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public Edap_aspectSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
