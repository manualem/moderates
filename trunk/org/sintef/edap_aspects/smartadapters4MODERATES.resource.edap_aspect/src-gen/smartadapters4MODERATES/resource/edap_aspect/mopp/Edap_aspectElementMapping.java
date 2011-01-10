/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

/**
 * A basic implementation of the
 * smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectElementMapping
 * interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class Edap_aspectElementMapping<ReferenceType> implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public Edap_aspectElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
