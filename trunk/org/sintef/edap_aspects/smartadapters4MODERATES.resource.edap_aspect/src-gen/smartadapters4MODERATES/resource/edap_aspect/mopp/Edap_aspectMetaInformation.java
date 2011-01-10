/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectMetaInformation implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectMetaInformation {
	
	public String getSyntaxName() {
		return "edap_aspect";
	}
	
	public String getURI() {
		return "http://SmartAdapters4MODERATES";
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextScanner createLexer() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectAntlrScanner(new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLexer());
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectParser().createInstance(inputStream, encoding);
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextPrinter createPrinter(java.io.OutputStream outputStream, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource) {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolverSwitch getReferenceResolverSwitch() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectReferenceResolverSwitch();
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolverFactory getTokenResolverFactory() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.sintef.edap.smartadapters/metamodel/Edap_AOM_Framework.cs";
	}
	
	public String[] getTokenNames() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectParser(null).getTokenNames();
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenStyle getDefaultTokenStyle(String tokenName) {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectBracketPair> getBracketPairs() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectResourceFactory();
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectNewFileContentProvider getNewFileContentProvider() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectNewFileContentProvider();
	}
	
}
