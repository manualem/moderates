/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectAntlrScanner implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextScanner {
	
	private org.antlr.runtime3_2_0.Lexer antlrLexer;
	
	public Edap_aspectAntlrScanner(org.antlr.runtime3_2_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_2_0.Token current = antlrLexer.nextToken();
		smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextToken result = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_2_0.ANTLRStringStream(text));
	}
	
}
