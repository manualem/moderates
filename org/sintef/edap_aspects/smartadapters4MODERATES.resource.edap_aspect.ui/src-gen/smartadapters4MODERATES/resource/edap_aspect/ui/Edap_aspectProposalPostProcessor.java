/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class Edap_aspectProposalPostProcessor {
	
	public java.util.List<smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCompletionProposal> process(java.util.List<smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
