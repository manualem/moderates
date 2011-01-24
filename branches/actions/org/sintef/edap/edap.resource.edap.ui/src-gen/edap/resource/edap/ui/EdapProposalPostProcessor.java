/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class EdapProposalPostProcessor {
	
	public java.util.List<edap.resource.edap.ui.EdapCompletionProposal> process(java.util.List<edap.resource.edap.ui.EdapCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
