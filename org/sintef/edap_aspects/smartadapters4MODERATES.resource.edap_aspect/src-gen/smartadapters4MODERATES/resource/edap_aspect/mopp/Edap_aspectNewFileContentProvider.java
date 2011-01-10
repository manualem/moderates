/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectNewFileContentProvider {
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectMetaInformation getMetaInformation() {
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			smartadapters4MODERATES.Smartadapters4MODERATESPackage.eINSTANCE.getAspect(),
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
		org.eclipse.emf.ecore.EObject root = new smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectPlugin.logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectResource());
	}
	
}
