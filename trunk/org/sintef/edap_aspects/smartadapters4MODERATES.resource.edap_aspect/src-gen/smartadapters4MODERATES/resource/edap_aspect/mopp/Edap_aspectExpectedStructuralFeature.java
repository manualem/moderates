/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class Edap_aspectExpectedStructuralFeature extends smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectAbstractExpectedElement {
	
	private smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectPlaceholder placeholder;
	
	public Edap_aspectExpectedStructuralFeature(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Edap_aspectExpectedStructuralFeature) {
			return getFeature().equals(((Edap_aspectExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
}
