/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.ui;

/**
 * A helper class that decides which tokens can be used for custom syntax
 * highlighting.
 */
public class Edap_aspectAntlrTokenHelper {
	
	public boolean canBeUsedForSyntaxColoring(org.antlr.runtime3_2_0.Token token) {
		return canBeUsedForSyntaxColoring(token.getType());
	}
	
	public boolean canBeUsedForSyntaxColoring(int tokenType) {
		if (tokenType == org.antlr.runtime3_2_0.Token.EOF) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.UP) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.DOWN) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.EOR_TOKEN_TYPE) {
			return false;
		}
		if (tokenType == org.antlr.runtime3_2_0.Token.INVALID_TOKEN_TYPE) {
			return false;
		}
		return true;
	}
	
	public String getTokenName(String[] tokenNames, int index) {
		if (tokenNames == null) {
			return null;
		}
		String tokenName = tokenNames[index];
		if (tokenName != null && tokenName.startsWith("'")) {
			tokenName = tokenName.substring(1, tokenName.length() - 1).trim();
		}
		return tokenName;
	}
	
}
