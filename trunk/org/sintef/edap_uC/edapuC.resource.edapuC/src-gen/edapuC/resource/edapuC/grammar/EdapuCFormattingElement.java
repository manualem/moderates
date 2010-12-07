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

public abstract class EdapuCFormattingElement extends edapuC.resource.edapuC.grammar.EdapuCSyntaxElement {
	
	public EdapuCFormattingElement(edapuC.resource.edapuC.grammar.EdapuCCardinality cardinality) {
		super(cardinality, null);
	}
	
}
