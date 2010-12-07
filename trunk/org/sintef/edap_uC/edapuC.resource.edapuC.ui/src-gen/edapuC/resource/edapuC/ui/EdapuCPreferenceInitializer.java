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

/**
 * A class used to initialize default preference values.
 */
public class EdapuCPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	private final static edapuC.resource.edapuC.ui.EdapuCAntlrTokenHelper tokenHelper = new edapuC.resource.edapuC.ui.EdapuCAntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = edapuC.resource.edapuC.ui.EdapuCUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(edapuC.resource.edapuC.ui.EdapuCPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(edapuC.resource.edapuC.ui.EdapuCPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = edapuC.resource.edapuC.ui.EdapuCUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new edapuC.resource.edapuC.mopp.EdapuCMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = edapuC.resource.edapuC.ui.EdapuCUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new edapuC.resource.edapuC.mopp.EdapuCMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, edapuC.resource.edapuC.IEdapuCMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		edapuC.resource.edapuC.ui.EdapuCBracketSet bracketSet = new edapuC.resource.edapuC.ui.EdapuCBracketSet(null, null);
		final java.util.Collection<edapuC.resource.edapuC.IEdapuCBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (edapuC.resource.edapuC.IEdapuCBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + edapuC.resource.edapuC.ui.EdapuCPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, edapuC.resource.edapuC.IEdapuCMetaInformation metaInformation) {
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
			edapuC.resource.edapuC.IEdapuCTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
