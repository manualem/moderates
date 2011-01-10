/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectProblem implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectProblem {
	
	private String message;
	private smartadapters4MODERATES.resource.edap_aspect.Edap_aspectEProblemType type;
	private java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectQuickFix> quickFixes;
	
	public Edap_aspectProblem(String message, smartadapters4MODERATES.resource.edap_aspect.Edap_aspectEProblemType type) {
		this(message, type, java.util.Collections.<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectQuickFix>emptySet());
	}
	
	public Edap_aspectProblem(String message, smartadapters4MODERATES.resource.edap_aspect.Edap_aspectEProblemType type, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectQuickFix quickFix) {
		this(message, type, java.util.Collections.singleton(quickFix));
	}
	
	public Edap_aspectProblem(String message, smartadapters4MODERATES.resource.edap_aspect.Edap_aspectEProblemType type, java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.quickFixes = new java.util.LinkedHashSet<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.Edap_aspectEProblemType getType() {
		return type;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
