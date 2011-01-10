/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.ui;

/**
 * An adapter from the Eclipse
 * <code>org.eclipse.jface.text.rules.ITokenScanner</code> interface to the
 * generated lexer.
 */
public class Edap_aspectTokenScanner implements org.eclipse.jface.text.rules.ITokenScanner {
	
	private smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextScanner lexer;
	private smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextToken currentToken;
	private int offset;
	private String languageId;
	private org.eclipse.jface.preference.IPreferenceStore store;
	private smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectColorManager colorManager;
	private smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource;
	
	/**
	 * 
	 * @param colorManager A manager to obtain color objects
	 */
	public Edap_aspectTokenScanner(smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectColorManager colorManager) {
		this.resource = resource;
		this.colorManager = colorManager;
		this.lexer = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectMetaInformation().createLexer();
		this.languageId = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectMetaInformation().getSyntaxName();
		this.store = smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectUIPlugin.getDefault().getPreferenceStore();
	}
	
	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	public int getTokenOffset() {
		return offset + currentToken.getOffset();
	}
	
	public org.eclipse.jface.text.rules.IToken nextToken() {
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectDynamicTokenStyler dynamicTokenStyler = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectDynamicTokenStyler();
		currentToken = lexer.getNextToken();
		if (currentToken == null || !currentToken.canBeUsedForSyntaxHighlighting()) {
			return org.eclipse.jface.text.rules.Token.EOF;
		}
		org.eclipse.jface.text.TextAttribute ta = null;
		String tokenName = currentToken.getName();
		if (tokenName != null) {
			String enableKey = smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.ENABLE);
			boolean enabled = store.getBoolean(enableKey);
			smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenStyle staticStyle = null;
			if (enabled) {
				String colorKey = smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.COLOR);
				org.eclipse.swt.graphics.RGB foregroundRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(store, colorKey);
				org.eclipse.swt.graphics.RGB backgroundRGB = null;
				boolean bold = store.getBoolean(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.BOLD));
				boolean italic = store.getBoolean(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.ITALIC));
				boolean strikethrough = store.getBoolean(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.STRIKETHROUGH));
				boolean underline = store.getBoolean(smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.getPreferenceKey(languageId, tokenName, smartadapters4MODERATES.resource.edap_aspect.ui.Edap_aspectSyntaxColoringHelper.StyleProperty.UNDERLINE));
				// now call dynamic token styler to allow to apply modifications to the static
				// style
				staticStyle = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenStyle(convertToIntArray(foregroundRGB), convertToIntArray(backgroundRGB), bold, italic, strikethrough, underline);
			}
			smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenStyle dynamicStyle = dynamicTokenStyler.getDynamicTokenStyle(resource, currentToken, staticStyle);
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
