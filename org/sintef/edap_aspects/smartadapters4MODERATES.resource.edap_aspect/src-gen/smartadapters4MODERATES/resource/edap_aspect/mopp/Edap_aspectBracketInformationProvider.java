/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectBracketInformationProvider {
	
	public class BracketPair implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectBracketPair> getBracketPairs() {
		java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectBracketPair> result = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectBracketPair>();
		result.add(new BracketPair("{", "}", true));
		result.add(new BracketPair("(", ")", true));
		result.add(new BracketPair("[", "]", true));
		return result;
	}
	
}
