/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

public class Edap_aspectTEXTTokenResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver {
	
	private smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectDefaultTokenResolver defaultTokenResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
