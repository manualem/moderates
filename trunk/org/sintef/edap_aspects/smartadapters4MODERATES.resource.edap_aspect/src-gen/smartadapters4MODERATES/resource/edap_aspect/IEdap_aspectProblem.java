/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect;

public interface IEdap_aspectProblem {
	public String getMessage();
	public smartadapters4MODERATES.resource.edap_aspect.Edap_aspectEProblemType getType();
	public java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectQuickFix> getQuickFixes();
}
