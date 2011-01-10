/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class Edap_aspectTokenResolveResult implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public Edap_aspectTokenResolveResult() {
		super();
		clear();
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Object getResolvedToken() {
		return resolvedToken;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void setResolvedToken(Object resolvedToken) {
		this.resolvedToken = resolvedToken;
	}
	
	public void clear() {
		errorMessage = "Can't resolve token.";
		resolvedToken = null;
	}
	
}
