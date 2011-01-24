/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

public class EdapT_ASPECTTokenResolver implements edap.resource.edap.IEdapTokenResolver {
	
	private edap.resource.edap.analysis.EdapDefaultTokenResolver defaultTokenResolver = new edap.resource.edap.analysis.EdapDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = "";
		if (value.toString().equals("true")) {
			result = "aspect ";
		}
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, edap.resource.edap.IEdapTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
		result.setResolvedToken(lexem.equals("aspect"));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
