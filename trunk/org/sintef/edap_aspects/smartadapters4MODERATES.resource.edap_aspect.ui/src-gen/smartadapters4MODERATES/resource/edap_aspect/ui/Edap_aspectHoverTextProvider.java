/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.ui;

public class Edap_aspectHoverTextProvider implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectHoverTextProvider {
	
	private smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectDefaultHoverTextProvider defaultProvider = new smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
