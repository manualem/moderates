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
 * A class to represent placeholders in a grammar.
 */
public class EdapuCPlaceholder extends edapuC.resource.edapuC.grammar.EdapuCTerminal {
	
	private final String tokenName;
	
	public EdapuCPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, edapuC.resource.edapuC.grammar.EdapuCCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
