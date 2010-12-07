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
 * A representation for a range in a document where a terminal (i.e., a
 * placeholder or a keyword) is expected. The range is expressed using two
 * integers denoting the start of the range including hidden tokens (e.g.,
 * whitespace) and excluding those token (i.e., the part of the document
 * containing the relevant characters).
 */
public class EdapuCExpectedTerminal {
	
	private int followSetID;
	private edapuC.resource.edapuC.IEdapuCExpectedElement terminal;
	private int startIncludingHiddenTokens;
	private int startExcludingHiddenTokens;
	private String prefix;
	private org.eclipse.emf.ecore.EStructuralFeature[] containmentTrace;
	
	public EdapuCExpectedTerminal(edapuC.resource.edapuC.IEdapuCExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
		super();
		this.terminal = terminal;
		this.followSetID = followSetID;
		this.containmentTrace = containmentTrace;
	}
	
	public int getFollowSetID() {
		return followSetID;
	}
	
	public edapuC.resource.edapuC.IEdapuCExpectedElement getTerminal() {
		return terminal;
	}
	
	public String toString() {
		return terminal == null ? "null" : terminal.toString();
	}
	
	public boolean equals(Object o) {
		return this.terminal.equals(((EdapuCExpectedTerminal) o).terminal);
	}
	
	public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens) {
		assert startExcludingHiddenTokens <= startExcludingHiddenTokens;
		assert startIncludingHiddenTokens <= startExcludingHiddenTokens;
		this.startIncludingHiddenTokens = startIncludingHiddenTokens;
		this.startExcludingHiddenTokens = startExcludingHiddenTokens;
	}
	
	public int getStartIncludingHiddenTokens() {
		return startIncludingHiddenTokens;
	}
	
	public int getStartExcludingHiddenTokens() {
		return startExcludingHiddenTokens;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature[] getContainmentTrace() {
		return containmentTrace;
	}
	
}
