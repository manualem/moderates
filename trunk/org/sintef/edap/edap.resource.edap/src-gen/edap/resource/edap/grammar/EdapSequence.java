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

public class EdapSequence extends edap.resource.edap.grammar.EdapSyntaxElement {
	
	public EdapSequence(edap.resource.edap.grammar.EdapCardinality cardinality, edap.resource.edap.grammar.EdapSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return edap.resource.edap.util.EdapStringUtil.explode(getChildren(), " ");
	}
	
}
