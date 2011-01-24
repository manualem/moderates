/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap;

/**
 * A common interface for scanners to be used by EMFText. A scanner is initialized
 * with a text and delivers a sequence of tokens.
 */
public interface IEdapTextScanner {
	
	/**
	 * Sets the text that must be scanned.
	 */
	public void setText(String text);
	
	/**
	 * Returns the next token found in the text.
	 */
	public edap.resource.edap.IEdapTextToken getNextToken();
	
}
