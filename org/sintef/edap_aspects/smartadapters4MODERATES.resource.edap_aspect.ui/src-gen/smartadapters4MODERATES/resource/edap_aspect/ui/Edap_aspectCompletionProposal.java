/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.ui;

/**
 * A proposal for completing an incomplete document.
 */
public class Edap_aspectCompletionProposal implements java.lang.Comparable<Edap_aspectCompletionProposal> {
	private String insertString;
	private String displayString;
	private String prefix;
	private boolean matchesPrefix;
	private org.eclipse.emf.ecore.EStructuralFeature structuralFeature;
	private org.eclipse.emf.ecore.EObject container;
	private org.eclipse.swt.graphics.Image image;
	
	public Edap_aspectCompletionProposal(String insertString, String prefix, boolean matchesPrefix, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.eclipse.emf.ecore.EObject container) {
		super();
		this.insertString = insertString;
		this.prefix = prefix;
		this.matchesPrefix = matchesPrefix;
		this.structuralFeature = structuralFeature;
		this.container = container;
	}
	
	public Edap_aspectCompletionProposal(String insertString, String prefix, boolean startsWithPrefix, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.eclipse.emf.ecore.EObject container, org.eclipse.swt.graphics.Image image) {
		this(insertString, prefix, startsWithPrefix, structuralFeature, container);
		this.image = image;
	}
	
	public Edap_aspectCompletionProposal(String insertString, String prefix, boolean startsWithPrefix, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.eclipse.emf.ecore.EObject container, org.eclipse.swt.graphics.Image image, String displayString) {
		this(insertString, prefix, startsWithPrefix, structuralFeature, container, image);
		this.displayString = displayString;
	}
	
	public String getInsertString() {
		return insertString;
	}
	
	public String getDisplayString() {
		return displayString;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	/**
	 * Returns true if this proposal matched the prefix. This does not imply that the
	 * proposal exactly starts with the prefix, it can also match case-insensitive or
	 * using the camel case style. Only proposals that return true will be considered
	 * for the final list of proposals that is presented in the editor.
	 */
	public boolean getMatchesPrefix() {
		return matchesPrefix;
	}
	
	public org.eclipse.swt.graphics.Image getImage() {
		return image;
	}
	
	public boolean isStructuralFeature() {
		return structuralFeature != null;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getStructuralFeature() {
		return structuralFeature;
	}
	
	public org.eclipse.emf.ecore.EObject getContainer() {
		return container;
	}
	
	public boolean equals(Object object) {
		if (object instanceof Edap_aspectCompletionProposal) {
			Edap_aspectCompletionProposal other = (Edap_aspectCompletionProposal) object;
			return other.getInsertString().equals(getInsertString());
		}
		return false;
	}
	
	public int hashCode() {
		return getInsertString().hashCode();
	}
	
	public int compareTo(Edap_aspectCompletionProposal object) {
		if (object instanceof Edap_aspectCompletionProposal) {
			Edap_aspectCompletionProposal other = (Edap_aspectCompletionProposal) object;
			// proposals that start with the prefix are preferred over the ones that do not
			int startCompare = (matchesPrefix ? 1 : 0) - (other.getMatchesPrefix() ? 1 : 0);
			// if both proposals start with the prefix of both do not the insert string is
			// compared
			return startCompare == 0 ? getInsertString().compareTo(other.getInsertString()) : -startCompare;
		}
		return -1;
	}
	
}
