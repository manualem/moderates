/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.ui;

public class Edap_aspectUIMetaInformation extends smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectMetaInformation {
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectHoverTextProvider getHoverTextProvider() {
		return new smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectHoverTextProvider();
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectImageProvider getImageProvider() {
		return smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectImageProvider.INSTANCE;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectColorManager createColorManager() {
		return new smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectText
	 * Resource,
	 * smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectColorManager)
	 * instead.
	 */
	public smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectTokenScanner createTokenScanner(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectTokenScanner createTokenScanner(smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectColorManager colorManager) {
		return new smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectTokenScanner(resource, colorManager);
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCodeCompletionHelper createCodeCompletionHelper() {
		return new smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCodeCompletionHelper();
	}
	
}
