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
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class EdapuCTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private edapuC.resource.edapuC.IEdapuCTextScanner lexer;
	private edapuC.resource.edapuC.IEdapuCTextToken currentToken;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private edapuC.resource.edapuC.ui.EdapuCColorManager colorManager;
	private edapuC.resource.edapuC.IEdapuCTextResource resource;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public EdapuCTokenScanner(edapuC.resource.edapuC.IEdapuCTextResource resource, edapuC.resource.edapuC.ui.EdapuCColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new edapuC.resource.edapuC.mopp.EdapuCMetaInformation().createLexer();
		this.languageId = new edapuC.resource.edapuC.mopp.EdapuCMetaInformation().getSyntaxName();
		this.store = edapuC.resource.edapuC.ui.EdapuCUIPlugin.getDefault().getPreferenceStore();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		edapuC.resource.edapuC.mopp.EdapuCDynamicTokenStyler dynamicTokenStyler = new edapuC.resource.edapuC.mopp.EdapuCDynamicTokenStyler();
		currentToken = lexer.getNextToken();
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		org.eclipse.jface.text.TextAttribute ta = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			String enableKey = edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.ENABLE);
			boolean enabled = store.getBoolean(enableKey);
			edapuC.resource.edapuC.IEdapuCTokenStyle staticStyle = null;
			if (enabled) {
				String colorKey = edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
				org.eclipse.swt.graphics.RGB backgroundRGB = null;
				boolean bold = store.getBoolean(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.BOLD));
				boolean italic = store.getBoolean(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.ITALIC));
				boolean strikethrough = store.getBoolean(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
				boolean underline = store.getBoolean(edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edapuC.resource.edapuC.ui.EdapuCSyntaxColoringHelper.StyleProperty.UNDERLINE));
				// now call dynamic token styler to allow to apply modifications to the static
				// style
				staticStyle = new edapuC.resource.edapuC.mopp.EdapuCTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
			}
			edapuC.resource.edapuC.IEdapuCTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
			if (dynamicStyle != null) {
				int[] foregroundColorArray = dynamicStyle.getColorAsRGB();
				org.eclipse.swt.graphics.Color foregroundColor = colorManager.getColor(new org.eclipse.swt.graphics.RGB(foregroundColorArray[0], foregroundColorArray[1], foregroundColorArray[2]));
				int[] backgroundColorArray = dynamicStyle.getBackgroundColorAsRGB();
				org.eclipse.swt.graphics.Color backgroundColor = null;
				if (backgroundColorArray != null) {
					org.eclipse.swt.graphics.RGB backgroundRGB = new org.eclipse.swt.graphics.RGB(backgroundColorArray[0], backgroundColorArray[1], backgroundColorArray[2]);
					backgroundColor = colorManager.getColor(backgroundRGB);
				}
				int style = org.eclipse.swt.SWT.NORMAL;
				if (dynamicStyle.isBold()) {
					style = style | org.eclipse.swt.SWT.BOLD;
				}
				if (dynamicStyle.isItalic()) {
					style = style | org.eclipse.swt.SWT.ITALIC;
				}
				if (dynamicStyle.isStrikethrough()) {
					style = style | org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
				}
				if (dynamicStyle.isUnderline()) {
					style = style | org.eclipse.jface.text.TextAttribute.UNDERLINE;
				}
				ta = new org.eclipse.jface.text.TextAttribute(foregroundColor, backgroundColor, style);
			}
		}
		return new org.eclipse.jface.text.rules.Token(ta);
	}
	
	public void setRange(org.eclipse.jface.text.IDocument document, int offset, int length) {
		this.offset = offset;
		try {
			lexer.setText(document.get(offset, length));
		} catch (org.eclipse.jface.text.BadLocationException e) {
			// ignore this error. It might occur during editing when locations are outdated
			// quickly.
		}
	}
	
	public String getTokenText() {
		return currentToken.getText();
	}
	
	public int[] convertToIntArray(org.eclipse.swt.graphics.RGB rgb) {
		if (rgb == null) {
			return null;
		}
		return new int[] {rgb.red, rgb.green, rgb.blue};
	}
	
}
