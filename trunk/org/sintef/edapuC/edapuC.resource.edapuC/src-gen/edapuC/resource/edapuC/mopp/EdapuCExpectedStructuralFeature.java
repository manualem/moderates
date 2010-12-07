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
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class EdapuCExpectedStructuralFeature extends edapuC.resource.edapuC.mopp.EdapuCAbstractExpectedElement {
	
	private edapuC.resource.edapuC.grammar.EdapuCPlaceholder placeholder;
	
	public EdapuCExpectedStructuralFeature(edapuC.resource.edapuC.grammar.EdapuCPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof EdapuCExpectedStructuralFeature) {
			return getFeature().equals(((EdapuCExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
