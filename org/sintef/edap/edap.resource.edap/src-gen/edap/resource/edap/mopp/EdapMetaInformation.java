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

public class EdapMetaInformation implements edap.resource.edap.IEdapMetaInformation {
	
	public String getSyntaxName() {
		return "edap";
	}
	
	public String getURI() {
		return "http://edap";
	}
	
	public edap.resource.edap.IEdapTextScanner createLexer() {
		return new edap.resource.edap.mopp.EdapAntlrScanner(new edap.resource.edap.mopp.EdapLexer());
	}
	
	public edap.resource.edap.IEdapTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new edap.resource.edap.mopp.EdapParser().createInstance(inputStream, encoding);
	}
	
	public edap.resource.edap.IEdapTextPrinter createPrinter(java.io.OutputStream outputStream, edap.resource.edap.IEdapTextResource resource) {
		return new edap.resource.edap.mopp.EdapPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new edap.resource.edap.mopp.EdapSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new edap.resource.edap.mopp.EdapSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public edap.resource.edap.IEdapReferenceResolverSwitch getReferenceResolverSwitch() {
		return new edap.resource.edap.mopp.EdapReferenceResolverSwitch();
	}
	
	public edap.resource.edap.IEdapTokenResolverFactory getTokenResolverFactory() {
		return new edap.resource.edap.mopp.EdapTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.sintef.edap.model/model/edap.cs";
	}
	
	public String[] getTokenNames() {
		return new edap.resource.edap.mopp.EdapParser(null).getTokenNames();
	}
	
	public edap.resource.edap.IEdapTokenStyle getDefaultTokenStyle(String tokenName) {
		return new edap.resource.edap.mopp.EdapTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<edap.resource.edap.IEdapBracketPair> getBracketPairs() {
		return new edap.resource.edap.mopp.EdapBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new edap.resource.edap.mopp.EdapFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new edap.resource.edap.mopp.EdapResourceFactory();
	}
	
	public edap.resource.edap.mopp.EdapNewFileContentProvider getNewFileContentProvider() {
		return new edap.resource.edap.mopp.EdapNewFileContentProvider();
	}
	
}
