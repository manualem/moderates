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
 
package edapuC.resource.edapuC.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class EdapuCKeyword extends edapuC.resource.edapuC.grammar.EdapuCSyntaxElement {
	
	private final String value;
	
	public EdapuCKeyword(String value, edapuC.resource.edapuC.grammar.EdapuCCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
