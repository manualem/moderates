/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.analysis;

/**
 * A default implementation for token resolvers. It tries to resolve lexems using
 * Java methods.
 */
public class Edap_aspectDefaultTokenResolver implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver {
	
	private java.util.Map<?, ?> options;
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (value == null) {
			return "null";
		}
		return value.toString();
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolveResult result) {
		
		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			if (feature.getEType() instanceof org.eclipse.emf.ecore.EEnum) {
				org.eclipse.emf.ecore.EEnumLiteral literal = ((org.eclipse.emf.ecore.EEnum) feature.getEType()).getEEnumLiteralByLiteral(lexem);
				if (literal != null) {
					result.setResolvedToken(literal.getInstance());
					return;
				} else {
					result.setErrorMessage("Could not map lexem '" + lexem + "' to enum '" + feature.getEType().getName() + "'.");
					return;
				}
			} else if (feature.getEType() instanceof org.eclipse.emf.ecore.EDataType) {
				try {
					result.setResolvedToken(org.eclipse.emf.ecore.util.EcoreUtil.createFromString((org.eclipse.emf.ecore.EDataType) feature.getEType(), lexem));
				} catch (Exception e) {
					result.setErrorMessage("Could not convert '" + lexem + "' to '" + feature.getEType().getName() + "'.");
				}
				String typeName = feature.getEType().getInstanceClassName();
				if (typeName.equals("boolean") || java.lang.Boolean.class.getName().equals(typeName)) {
					String featureName = feature.getName();
					boolean featureNameMatchesLexem = featureName.equals(lexem);
					if (featureName.length() > 2 && featureName.startsWith("is")) {
						featureNameMatchesLexem |= (featureName.substring(2, 3).toLowerCase() + featureName.substring(3)).equals(lexem);
					}
					result.setResolvedToken(Boolean.parseBoolean(lexem) || featureNameMatchesLexem);
					return;
				}
			} else {
				assert false;
			}
		} else {
			result.setResolvedToken(lexem);
			return;
		}
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		this.options = options;
	}
	
	public java.util.Map<?, ?> getOptions() {
		return options;
	}
}
