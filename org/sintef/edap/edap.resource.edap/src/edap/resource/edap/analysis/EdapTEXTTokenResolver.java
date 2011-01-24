/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

public class EdapTEXTTokenResolver implements edap.resource.edap.IEdapTokenResolver {
	
	private edap.resource.edap.analysis.EdapDefaultTokenResolver defaultTokenResolver = new edap.resource.edap.analysis.EdapDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, edap.resource.edap.IEdapTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
