/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

public class Edap_aspectTXTIDTokenResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver {
	
	private smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectDefaultTokenResolver defaultTokenResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		result = '<' + result + '>';
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolveResult result) {
		assert lexem.charAt(0) == '<';
		assert lexem.charAt(lexem.length() - 1) == '>';
		lexem = lexem.substring(1, lexem.length() - 1);
		result.setResolvedToken(lexem);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
