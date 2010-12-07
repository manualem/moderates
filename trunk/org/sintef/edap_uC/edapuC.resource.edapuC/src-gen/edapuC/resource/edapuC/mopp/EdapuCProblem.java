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

public class EdapuCProblem implements edapuC.resource.edapuC.IEdapuCProblem {
	
	private String message;
	private edapuC.resource.edapuC.EdapuCEProblemType type;
	private java.util.Collection<edapuC.resource.edapuC.IEdapuCQuickFix> quickFixes;
	
	public EdapuCProblem(String message, edapuC.resource.edapuC.EdapuCEProblemType type) {
		this(message, type, java.util.Collections.<edapuC.resource.edapuC.IEdapuCQuickFix>emptySet());
	}
	
	public EdapuCProblem(String message, edapuC.resource.edapuC.EdapuCEProblemType type, edapuC.resource.edapuC.IEdapuCQuickFix quickFix) {
		this(message, type, java.util.Collections.singleton(quickFix));
	}
	
	public EdapuCProblem(String message, edapuC.resource.edapuC.EdapuCEProblemType type, java.util.Collection<edapuC.resource.edapuC.IEdapuCQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.quickFixes = new java.util.LinkedHashSet<edapuC.resource.edapuC.IEdapuCQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public edapuC.resource.edapuC.EdapuCEProblemType getType() {
		return type;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<edapuC.resource.edapuC.IEdapuCQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
