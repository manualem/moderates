/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap;

public interface IEdapProblem {
	public String getMessage();
	public edap.resource.edap.EdapEProblemSeverity getSeverity();
	public edap.resource.edap.EdapEProblemType getType();
	public java.util.Collection<edap.resource.edap.IEdapQuickFix> getQuickFixes();
}
