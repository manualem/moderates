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

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class EdapuCExpectedCsString extends edapuC.resource.edapuC.mopp.EdapuCAbstractExpectedElement {
	
	private edapuC.resource.edapuC.grammar.EdapuCKeyword keyword;
	
	public EdapuCExpectedCsString(edapuC.resource.edapuC.grammar.EdapuCKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof EdapuCExpectedCsString) {
			return getValue().equals(((EdapuCExpectedCsString) o).getValue());
		}
		return false;
	}
	
}
