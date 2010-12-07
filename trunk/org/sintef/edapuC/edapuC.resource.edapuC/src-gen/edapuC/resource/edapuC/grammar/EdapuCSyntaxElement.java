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
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class EdapuCSyntaxElement {
	
	private EdapuCSyntaxElement[] children;
	private EdapuCSyntaxElement parent;
	private edapuC.resource.edapuC.grammar.EdapuCCardinality cardinality;
	
	public EdapuCSyntaxElement(edapuC.resource.edapuC.grammar.EdapuCCardinality cardinality, EdapuCSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (EdapuCSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	public void setParent(EdapuCSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	public EdapuCSyntaxElement[] getChildren() {
		if (children == null) {
			return new EdapuCSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public edapuC.resource.edapuC.grammar.EdapuCCardinality getCardinality() {
		return cardinality;
	}
	
}
