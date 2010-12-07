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
 
package edap.resource.edap.mopp;

public class EdapParseResult implements edap.resource.edap.IEdapParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>> commands = new java.util.ArrayList<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>>();
	
	public EdapParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
