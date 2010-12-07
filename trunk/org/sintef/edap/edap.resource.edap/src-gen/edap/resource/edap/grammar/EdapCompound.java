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

public class EdapCompound extends edap.resource.edap.grammar.EdapSyntaxElement {
	
	public EdapCompound(edap.resource.edap.grammar.EdapChoice choice, edap.resource.edap.grammar.EdapCardinality cardinality) {
		super(cardinality, new edap.resource.edap.grammar.EdapSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
