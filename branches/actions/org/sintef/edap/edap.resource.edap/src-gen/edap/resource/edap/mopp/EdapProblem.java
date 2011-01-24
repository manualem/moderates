/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

public class EdapProblem implements edap.resource.edap.IEdapProblem {
	
	private String message;
	private edap.resource.edap.EdapEProblemType type;
	private edap.resource.edap.EdapEProblemSeverity severity;
	private java.util.Collection<edap.resource.edap.IEdapQuickFix> quickFixes;
	
	public EdapProblem(String message, edap.resource.edap.EdapEProblemType type, edap.resource.edap.EdapEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<edap.resource.edap.IEdapQuickFix>emptySet());
	}
	
	public EdapProblem(String message, edap.resource.edap.EdapEProblemType type, edap.resource.edap.EdapEProblemSeverity severity, edap.resource.edap.IEdapQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public EdapProblem(String message, edap.resource.edap.EdapEProblemType type, edap.resource.edap.EdapEProblemSeverity severity, java.util.Collection<edap.resource.edap.IEdapQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<edap.resource.edap.IEdapQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public edap.resource.edap.EdapEProblemType getType() {
		return type;
	}
	
	public edap.resource.edap.EdapEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<edap.resource.edap.IEdapQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
