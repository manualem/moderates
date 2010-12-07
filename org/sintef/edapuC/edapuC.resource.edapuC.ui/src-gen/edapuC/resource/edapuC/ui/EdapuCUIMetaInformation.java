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
 
package edapuC.resource.edapuC.ui;

public class EdapuCUIMetaInformation extends edapuC.resource.edapuC.mopp.EdapuCMetaInformation {
	
	public edapuC.resource.edapuC.IEdapuCHoverTextProvider getHoverTextProvider() {
		return new edapuC.resource.edapuC.ui.EdapuCHoverTextProvider();
	}
	
	public edapuC.resource.edapuC.ui.EdapuCImageProvider getImageProvider() {
		return edapuC.resource.edapuC.ui.EdapuCImageProvider.INSTANCE;
	}
	
	public edapuC.resource.edapuC.ui.EdapuCColorManager createColorManager() {
		return new edapuC.resource.edapuC.ui.EdapuCColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(edapuC.resource.edapuC.IEdapuCTextResource,
	 * edapuC.resource.edapuC.ui.EdapuCColorManager) instead.
	 */
	public edapuC.resource.edapuC.ui.EdapuCTokenScanner createTokenScanner(edapuC.resource.edapuC.ui.EdapuCColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public edapuC.resource.edapuC.ui.EdapuCTokenScanner createTokenScanner(edapuC.resource.edapuC.IEdapuCTextResource resource, edapuC.resource.edapuC.ui.EdapuCColorManager colorManager) {
		return new edapuC.resource.edapuC.ui.EdapuCTokenScanner(resource, colorManager);
	}
	
	public edapuC.resource.edapuC.ui.EdapuCCodeCompletionHelper createCodeCompletionHelper() {
		return new edapuC.resource.edapuC.ui.EdapuCCodeCompletionHelper();
	}
	
}
