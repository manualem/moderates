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

public class EdapuCParseResult implements edapuC.resource.edapuC.IEdapuCParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>> commands = new java.util.ArrayList<edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>>();
	
	public EdapuCParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
