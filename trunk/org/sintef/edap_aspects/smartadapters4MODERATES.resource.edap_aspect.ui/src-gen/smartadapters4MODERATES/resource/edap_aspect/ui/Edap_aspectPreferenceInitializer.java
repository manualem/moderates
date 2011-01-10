/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.ui;

/**
 * A class used to initialize default preference values.
 */
public class Edap_aspectPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	private final static smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectAntlrTokenHelper tokenHelper = new smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectAntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectBracketSet bracketSet = new smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectBracketSet(null, null);
		final java.util.Collection<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			if (!tokenHelper.canBeUsedForSyntaxColoring(i)) {
				continue;
			}
			
			String tokenName = tokenHelper.getTokenName(tokenNames, i);
			if (tokenName == null) {
				continue;
			}
			smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
