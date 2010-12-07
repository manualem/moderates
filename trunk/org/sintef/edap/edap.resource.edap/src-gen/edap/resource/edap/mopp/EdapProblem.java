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

public class EdapProblem implements edap.resource.edap.IEdapProblem {
	
	private String message;
	private edap.resource.edap.EdapEProblemType type;
	private java.util.Collection<edap.resource.edap.IEdapQuickFix> quickFixes;
	
	public EdapProblem(String message, edap.resource.edap.EdapEProblemType type) {
		this(message, type, java.util.Collections.<edap.resource.edap.IEdapQuickFix>emptySet());
	}
	
	public EdapProblem(String message, edap.resource.edap.EdapEProblemType type, edap.resource.edap.IEdapQuickFix quickFix) {
		this(message, type, java.util.Collections.singleton(quickFix));
	}
	
	public EdapProblem(String message, edap.resource.edap.EdapEProblemType type, java.util.Collection<edap.resource.edap.IEdapQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.quickFixes = new java.util.LinkedHashSet<edap.resource.edap.IEdapQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public edap.resource.edap.EdapEProblemType getType() {
		return type;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<edap.resource.edap.IEdapQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
