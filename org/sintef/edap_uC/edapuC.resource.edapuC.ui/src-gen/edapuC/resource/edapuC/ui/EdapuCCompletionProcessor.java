/*******************************************************************************
 * Copyright (c) 2010 SINTEF
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SINTEF - initial API and implementation
 ******************************************************************************/
 
package edapuC.resource.edapuC.ui;

public class EdapuCCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private edapuC.resource.edapuC.ui.EdapuCEditor editor;
	
	public EdapuCCompletionProcessor(edapuC.resource.edapuC.ui.EdapuCEditor editor) {
		this.editor = editor;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		
		org.eclipse.emf.ecore.resource.Resource resource = editor.getResource();
		edapuC.resource.edapuC.IEdapuCTextResource textResource = (edapuC.resource.edapuC.IEdapuCTextResource) resource;
		String content = viewer.getDocument().get();
		edapuC.resource.edapuC.ui.EdapuCCodeCompletionHelper helper = new edapuC.resource.edapuC.ui.EdapuCCodeCompletionHelper();
		edapuC.resource.edapuC.ui.EdapuCCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		edapuC.resource.edapuC.ui.EdapuCProposalPostProcessor proposalPostProcessor = new edapuC.resource.edapuC.ui.EdapuCProposalPostProcessor();
		java.util.List<edapuC.resource.edapuC.ui.EdapuCCompletionProposal> computedProposalList = java.util.Arrays.asList(computedProposals);
		java.util.List<edapuC.resource.edapuC.ui.EdapuCCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = java.util.Collections.emptyList();
		}
		java.util.List<edapuC.resource.edapuC.ui.EdapuCCompletionProposal> finalProposalList = new java.util.ArrayList<edapuC.resource.edapuC.ui.EdapuCCompletionProposal>();
		for (edapuC.resource.edapuC.ui.EdapuCCompletionProposal proposal : extendedProposalList) {
			if (proposal.getMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (edapuC.resource.edapuC.ui.EdapuCCompletionProposal proposal : finalProposalList) {
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
			edapuC.resource.edapuC.ui.IEdapuCBracketHandler bracketHandler = editor.getBracketHandler();
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
