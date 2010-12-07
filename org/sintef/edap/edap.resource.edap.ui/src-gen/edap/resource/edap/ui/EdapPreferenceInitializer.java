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
 
package edap.resource.edap.ui;

/**
 * A class used to initialize default preference values.
 */
public class EdapPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	private final static edap.resource.edap.ui.EdapAntlrTokenHelper tokenHelper = new edap.resource.edap.ui.EdapAntlrTokenHelper();
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = edap.resource.edap.ui.EdapUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(edap.resource.edap.ui.EdapPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(edap.resource.edap.ui.EdapPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = edap.resource.edap.ui.EdapUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new edap.resource.edap.mopp.EdapMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = edap.resource.edap.ui.EdapUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new edap.resource.edap.mopp.EdapMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, edap.resource.edap.IEdapMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		edap.resource.edap.ui.EdapBracketSet bracketSet = new edap.resource.edap.ui.EdapBracketSet(null, null);
		final java.util.Collection<edap.resource.edap.IEdapBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (edap.resource.edap.IEdapBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + edap.resource.edap.ui.EdapPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, edap.resource.edap.IEdapMetaInformation metaInformation) {
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
			edap.resource.edap.IEdapTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
