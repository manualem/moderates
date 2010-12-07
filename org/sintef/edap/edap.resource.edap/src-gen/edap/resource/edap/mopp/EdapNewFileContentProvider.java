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

public class EdapNewFileContentProvider {
	
	public edap.resource.edap.IEdapMetaInformation getMetaInformation() {
		return new edap.resource.edap.mopp.EdapMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			edap.EdapPackage.eINSTANCE.getEdapModel(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		String content = "";
		for (org.eclipse.emf.ecore.EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new edap.resource.edap.util.EdapMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		edap.resource.edap.IEdapTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			edap.resource.edap.mopp.EdapPlugin.logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public edap.resource.edap.IEdapTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new edap.resource.edap.mopp.EdapResource());
	}
	
}
