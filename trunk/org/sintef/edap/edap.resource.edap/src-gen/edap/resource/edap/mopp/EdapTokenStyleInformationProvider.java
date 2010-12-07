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
 
package edap.resource.edap.mopp;

public class EdapTokenStyleInformationProvider {
	
	public edap.resource.edap.IEdapTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("TEXT".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x00, 0x00, 0x00}, null, false, false, false, false);
		}
		if ("T_MULTICAST".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("T_READONLY".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("SL_COMMENT".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x00, 0xaa, 0x33}, null, false, false, false, false);
		}
		if ("ML_COMMENT".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x00, 0xaa, 0x33}, null, false, false, false, false);
		}
		if ("ANNOTATION".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x00, 0x55, 0xbb}, null, true, false, false, false);
		}
		if ("STRING_LITERAL".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x00, 0x55, 0xbb}, null, false, false, false, false);
		}
		if ("device".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("datatype".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("enumeration".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("T_ASPECT".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("T_SINGLETON".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("sends".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("receives".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("STRING_EXT".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x00, 0x55, 0xbb}, null, false, false, false, false);
		}
		if ("state".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("composite".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("statechart".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("component".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("event".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("eventref".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("guard".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("action".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("on".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("entry".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("exit".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("send".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("transition".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("init".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("connector".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("port".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("import".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x7F, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("->".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0xCC, 0x80, 0x00}, null, true, false, false, false);
		}
		if ("(".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if (")".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("{".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("}".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("[".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("]".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x44, 0x44, 0x44}, null, true, false, false, false);
		}
		if ("message".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("simulator".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("for".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("property".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("dictionary".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("set".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("broadcast".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("create".equals(tokenName)) {
			return new edap.resource.edap.mopp.EdapTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		return null;
	}
	
}
