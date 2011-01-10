/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

/**
 * A basic implementation of the
 * smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult
 * interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class Edap_aspectReferenceResolveResult<ReferenceType> implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	
	public Edap_aspectReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceMapping<ReferenceType>>();
		}
		mappings.add(new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceMapping<ReferenceType>>();
		}
		mappings.add(new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
