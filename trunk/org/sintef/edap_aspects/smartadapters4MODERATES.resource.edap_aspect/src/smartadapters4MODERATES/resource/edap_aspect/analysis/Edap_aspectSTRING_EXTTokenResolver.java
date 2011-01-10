/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

import smartadapters4MODERATES.resource.edap_aspect.analysis.utils.CharacterEscaper;


public class Edap_aspectSTRING_EXTTokenResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver {
	
	private smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectDefaultTokenResolver defaultTokenResolver = new smartadapters4MODERATES.resource.edap_aspect.analysis.Edap_aspectDefaultTokenResolver();
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		//escape escapes
		result = CharacterEscaper.escapeEscapedCharacters(result);
		
		result = '\'' + result + '\'';
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolveResult result) {
		// remove double quotes
		assert lexem.charAt(0) == '\'';
		assert lexem.charAt(lexem.length() - 1) == '\'';
		lexem = lexem.substring(1, lexem.length() - 1);
		// handle escaped characters: 
		// escape sequences: \b \t \n \f \r \" \' \\
		// octal characters: \0 to \377
		// unicode characters (e.g., \u0000)
		
		//TODO @mseifert: either implement escaping (inverse of unescapeEscapedCharacters) 
		//     for deResolve or leave the below .
		lexem = CharacterEscaper.unescapeEscapedCharacters(lexem);
		
		result.setResolvedToken(lexem);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
