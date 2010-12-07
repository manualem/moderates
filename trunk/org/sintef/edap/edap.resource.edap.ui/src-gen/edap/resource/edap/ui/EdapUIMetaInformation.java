/*******************************************************************************
 * Copyright (c) 2010 SINTEF
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SINTEF - initial API and implementation
 ******************************************************************************/
 
package edap.resource.edap.ui;

public class EdapUIMetaInformation extends edap.resource.edap.mopp.EdapMetaInformation {
	
	public edap.resource.edap.IEdapHoverTextProvider getHoverTextProvider() {
		return new edap.resource.edap.ui.EdapHoverTextProvider();
	}
	
	public edap.resource.edap.ui.EdapImageProvider getImageProvider() {
		return edap.resource.edap.ui.EdapImageProvider.INSTANCE;
	}
	
	public edap.resource.edap.ui.EdapColorManager createColorManager() {
		return new edap.resource.edap.ui.EdapColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(edap.resource.edap.IEdapTextResource,
	 * edap.resource.edap.ui.EdapColorManager) instead.
	 */
	public edap.resource.edap.ui.EdapTokenScanner createTokenScanner(edap.resource.edap.ui.EdapColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public edap.resource.edap.ui.EdapTokenScanner createTokenScanner(edap.resource.edap.IEdapTextResource resource, edap.resource.edap.ui.EdapColorManager colorManager) {
		return new edap.resource.edap.ui.EdapTokenScanner(resource, colorManager);
	}
	
	public edap.resource.edap.ui.EdapCodeCompletionHelper createCodeCompletionHelper() {
		return new edap.resource.edap.ui.EdapCodeCompletionHelper();
	}
	
}
