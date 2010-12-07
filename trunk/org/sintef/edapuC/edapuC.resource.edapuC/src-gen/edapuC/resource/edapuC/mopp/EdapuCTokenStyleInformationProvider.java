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
 
package edapuC.resource.edapuC.mopp;

public class EdapuCTokenStyleInformationProvider {
	
	public edapuC.resource.edapuC.IEdapuCTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("import".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("edap".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("property".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x00, 0x55, 0xbb}, null, true, false, false, false);
		}
		if ("init".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("poll".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("global".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("device".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("message".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("STRING_LITERAL".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x00, 0x55, 0xbb}, null, false, false, false, false);
		}
		if ("TEMPLATE".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x70, 0x70, 0x70}, null, false, false, false, false);
		}
		if ("GENERATOR".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0xef, 0x8f, 0x49}, null, false, false, false, false);
		}
		if ("application".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("headers".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("send".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(new int[] {0x3F, 0x80, 0x5D}, null, false, false, false, false);
		}
		return null;
	}
	
}
