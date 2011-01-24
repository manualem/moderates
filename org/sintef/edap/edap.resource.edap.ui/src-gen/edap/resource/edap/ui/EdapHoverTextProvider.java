/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.ui;

public class EdapHoverTextProvider implements edap.resource.edap.IEdapHoverTextProvider {
	
	private edap.resource.edap.ui.EdapDefaultHoverTextProvider defaultProvider = new edap.resource.edap.ui.EdapDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
