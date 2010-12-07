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

public class EdapSyntaxColoringHelper {
	
	public static enum StyleProperty {
		
		BOLD("bold"),
		ITALIC("italic"),
		ENABLE("enable"),
		UNDERLINE("underline"),
		STRIKETHROUGH("strikethrough"),
		COLOR("color");
		
		private String suffix;
		
		private StyleProperty(String suffix) {
			this.suffix = suffix;
		}
		
		public String getSuffix() {
			return suffix;
		}
	}
	
	public static String getPreferenceKey(String languageID, String tokenName, StyleProperty styleProperty) {
		return languageID + "$" + tokenName + "$" + styleProperty.getSuffix();
	}
}
