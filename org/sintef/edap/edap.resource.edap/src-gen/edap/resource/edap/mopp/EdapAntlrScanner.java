/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

public class EdapAntlrScanner implements edap.resource.edap.IEdapTextScanner {
	
	private org.antlr.runtime3_2_0.Lexer antlrLexer;
	
	public EdapAntlrScanner(org.antlr.runtime3_2_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public edap.resource.edap.IEdapTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_2_0.Token current = antlrLexer.nextToken();
		edap.resource.edap.IEdapTextToken result = new edap.resource.edap.mopp.EdapTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_2_0.ANTLRStringStream(text));
	}
	
}
