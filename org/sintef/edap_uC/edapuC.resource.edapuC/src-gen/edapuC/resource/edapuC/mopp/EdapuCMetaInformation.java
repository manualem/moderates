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

public class EdapuCMetaInformation implements edapuC.resource.edapuC.IEdapuCMetaInformation {
	
	public String getSyntaxName() {
		return "edapuC";
	}
	
	public String getURI() {
		return "http://edapuC";
	}
	
	public edapuC.resource.edapuC.IEdapuCTextScanner createLexer() {
		return new edapuC.resource.edapuC.mopp.EdapuCAntlrScanner(new edapuC.resource.edapuC.mopp.EdapuCLexer());
	}
	
	public edapuC.resource.edapuC.IEdapuCTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new edapuC.resource.edapuC.mopp.EdapuCParser().createInstance(inputStream, encoding);
	}
	
	public edapuC.resource.edapuC.IEdapuCTextPrinter createPrinter(java.io.OutputStream outputStream, edapuC.resource.edapuC.IEdapuCTextResource resource) {
		return new edapuC.resource.edapuC.mopp.EdapuCPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new edapuC.resource.edapuC.mopp.EdapuCSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new edapuC.resource.edapuC.mopp.EdapuCSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public edapuC.resource.edapuC.IEdapuCReferenceResolverSwitch getReferenceResolverSwitch() {
		return new edapuC.resource.edapuC.mopp.EdapuCReferenceResolverSwitch();
	}
	
	public edapuC.resource.edapuC.IEdapuCTokenResolverFactory getTokenResolverFactory() {
		return new edapuC.resource.edapuC.mopp.EdapuCTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.sintef.edap.generator.uC/model/edapuC.cs";
	}
	
	public String[] getTokenNames() {
		return new edapuC.resource.edapuC.mopp.EdapuCParser(null).getTokenNames();
	}
	
	public edapuC.resource.edapuC.IEdapuCTokenStyle getDefaultTokenStyle(String tokenName) {
		return new edapuC.resource.edapuC.mopp.EdapuCTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<edapuC.resource.edapuC.IEdapuCBracketPair> getBracketPairs() {
		return new edapuC.resource.edapuC.mopp.EdapuCBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new edapuC.resource.edapuC.mopp.EdapuCFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new edapuC.resource.edapuC.mopp.EdapuCResourceFactory();
	}
	
	public edapuC.resource.edapuC.mopp.EdapuCNewFileContentProvider getNewFileContentProvider() {
		return new edapuC.resource.edapuC.mopp.EdapuCNewFileContentProvider();
	}
	
}
