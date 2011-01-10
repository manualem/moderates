/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.ui;

public class Edap_aspectCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectEditor editor;
	
	public Edap_aspectCompletionProcessor(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectEditor editor) {
		this.editor = editor;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		
		org.eclipse.emf.ecore.resource.Resource resource = editor.getResource();
		smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource textResource = (smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource) resource;
		String content = viewer.getDocument().get();
		smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCodeCompletionHelper helper = new smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCodeCompletionHelper();
		smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectProposalPostProcessor proposalPostProcessor = new smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectProposalPostProcessor();
		java.util.List<smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCompletionProposal> finalProposalList = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCompletionProposal>();
		for (smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			org.eclipse.swt.graphics.Image image = proposal.getImage();
			org.eclipse.jface.text.contentassist.IContextInformation info;
			info = new org.eclipse.jface.text.contentassist.ContextInformation(image, proposalString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			// if a closing bracket was automatically inserted right before, we enlarge the
			// replacement length in order to overwrite the bracket.
			smartadapters4MODERATES.resource.edap_aspect.ui.IEdap_aspectBracketHandler bracketHandler = editor.getBracketHandler();
			String closingBracket = bracketHandler.getClosingBracket();
			if (bracketHandler.addedClosingBracket() && proposalString.endsWith(closingBracket)) {
				replacementLength += closingBracket.length();
			}
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
