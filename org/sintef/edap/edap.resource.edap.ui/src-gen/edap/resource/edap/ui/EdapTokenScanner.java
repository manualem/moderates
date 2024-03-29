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
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class EdapTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private edap.resource.edap.IEdapTextScanner lexer;
	private edap.resource.edap.IEdapTextToken currentToken;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private edap.resource.edap.ui.EdapColorManager colorManager;
	private edap.resource.edap.IEdapTextResource resource;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public EdapTokenScanner(edap.resource.edap.IEdapTextResource resource, edap.resource.edap.ui.EdapColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new edap.resource.edap.mopp.EdapMetaInformation().createLexer();
		this.languageId = new edap.resource.edap.mopp.EdapMetaInformation().getSyntaxName();
		this.store = edap.resource.edap.ui.EdapUIPlugin.getDefault().getPreferenceStore();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		edap.resource.edap.mopp.EdapDynamicTokenStyler dynamicTokenStyler = new edap.resource.edap.mopp.EdapDynamicTokenStyler();
		currentToken = lexer.getNextToken();
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		org.eclipse.jface.text.TextAttribute ta = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			String enableKey = edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.ENABLE);
			boolean enabled = store.getBoolean(enableKey);
			edap.resource.edap.IEdapTokenStyle staticStyle = null;
			if (enabled) {
				String colorKey = edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
				org.eclipse.swt.graphics.RGB backgroundRGB = null;
				boolean bold = store.getBoolean(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.BOLD));
				boolean italic = store.getBoolean(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.ITALIC));
				boolean strikethrough = store.getBoolean(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
				boolean underline = store.getBoolean(edap.resource.edap.ui.EdapSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, edap.resource.edap.ui.EdapSyntaxColoringHelper.StyleProperty.UNDERLINE));
				// now call dynamic token styler to allow to apply modifications to the static
				// style
				staticStyle = new edap.resource.edap.mopp.EdapTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
			}
			edap.resource.edap.IEdapTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
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
