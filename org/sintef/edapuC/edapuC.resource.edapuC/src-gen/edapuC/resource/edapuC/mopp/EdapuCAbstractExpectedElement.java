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
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class EdapuCAbstractExpectedElement implements edapuC.resource.edapuC.IEdapuCExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	private java.util.Set<edapuC.resource.edapuC.util.EdapuCPair<edapuC.resource.edapuC.IEdapuCExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> followers = new java.util.LinkedHashSet<edapuC.resource.edapuC.util.EdapuCPair<edapuC.resource.edapuC.IEdapuCExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>>();
	
	public EdapuCAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(edapuC.resource.edapuC.IEdapuCExpectedElement follower, org.eclipse.emf.ecore.EStructuralFeature[] path) {
		followers.add(new edapuC.resource.edapuC.util.EdapuCPair<edapuC.resource.edapuC.IEdapuCExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>(follower, path));
	}
	
	public java.util.Collection<edapuC.resource.edapuC.util.EdapuCPair<edapuC.resource.edapuC.IEdapuCExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> getFollowers() {
		return followers;
	}
	
}
