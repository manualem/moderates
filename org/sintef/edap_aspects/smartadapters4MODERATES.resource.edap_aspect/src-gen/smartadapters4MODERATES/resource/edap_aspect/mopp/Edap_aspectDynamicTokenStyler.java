/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenStyle getDynamicTokenStyle(smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextToken token, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
}
