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
 
package edap.resource.edap.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class EdapPlaceholder extends edap.resource.edap.grammar.EdapTerminal {
	
	private final String tokenName;
	
	public EdapPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, edap.resource.edap.grammar.EdapCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
