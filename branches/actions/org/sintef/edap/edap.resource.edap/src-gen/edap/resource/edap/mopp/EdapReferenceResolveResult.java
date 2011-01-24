/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

/**
 * A basic implementation of the edap.resource.edap.IEdapReferenceResolveResult
 * interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class EdapReferenceResolveResult<ReferenceType> implements edap.resource.edap.IEdapReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<edap.resource.edap.IEdapReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<edap.resource.edap.IEdapQuickFix> quickFixes;
	
	public EdapReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<edap.resource.edap.IEdapQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<edap.resource.edap.IEdapQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(edap.resource.edap.IEdapQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<edap.resource.edap.IEdapQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<edap.resource.edap.IEdapReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<edap.resource.edap.IEdapReferenceMapping<ReferenceType>>();
		}
		mappings.add(new edap.resource.edap.mopp.EdapElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<edap.resource.edap.IEdapReferenceMapping<ReferenceType>>();
		}
		mappings.add(new edap.resource.edap.mopp.EdapURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
