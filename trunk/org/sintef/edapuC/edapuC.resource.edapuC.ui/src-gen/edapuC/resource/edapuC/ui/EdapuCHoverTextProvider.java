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

public class EdapuCHoverTextProvider implements edapuC.resource.edapuC.IEdapuCHoverTextProvider {
	
	private edapuC.resource.edapuC.ui.EdapuCDefaultHoverTextProvider defaultProvider = new edapuC.resource.edapuC.ui.EdapuCDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
