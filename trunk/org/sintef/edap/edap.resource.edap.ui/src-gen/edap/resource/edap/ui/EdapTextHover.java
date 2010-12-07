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
 * A class to display the information of an element. Most of the code is taken
 * from <code>org.eclipse.jdt.internal.ui.text.java.hover.JavadocHover</code>.
 */
public class EdapTextHover implements org.eclipse.jface.text.ITextHover, org.eclipse.jface.text.ITextHoverExtension, org.eclipse.jface.text.ITextHoverExtension2{
	
	private static final String FONT = org.eclipse.jface.resource.JFaceResources.DIALOG_FONT;
	private edap.resource.edap.ui.EdapEditor editor;
	private edap.resource.edap.IEdapHoverTextProvider hoverTextProvider;
	/**
	 * The style sheet (css).
	 */
	private static String styleSheet;
	
	/**
	 * The hover control creator.
	 */
	private org.eclipse.jface.text.IInformationControlCreator hoverControlCreator;
	
	/**
	 * The presentation control creator.
	 */
	private org.eclipse.jface.text.IInformationControlCreator presenterControlCreator;
	
	/**
	 * A simple default implementation of a {@link
	 * org.eclipse.jface.viewers.ISelectionProvider}. It stores the selection and
	 * notifies all selection change listeners when the selection is set.
	 */
	public static class SimpleSelectionProvider implements org.eclipse.jface.viewers.ISelectionProvider {
		
		private final org.eclipse.core.runtime.ListenerList selectionChangedListeners;
		private org.eclipse.jface.viewers.ISelection selection;
		
		public SimpleSelectionProvider() {
			selectionChangedListeners = new org.eclipse.core.runtime.ListenerList();
		}
		
		public org.eclipse.jface.viewers.ISelection getSelection() {
			return selection;
		}
		
		public void setSelection(org.eclipse.jface.viewers.ISelection selection) {
			this.selection = selection;
			
			Object[] listeners = selectionChangedListeners.getListeners();
			for (int i = 0; i < listeners.length; i++) {
				((org.eclipse.jface.viewers.ISelectionChangedListener) listeners[i]).selectionChanged(new org.eclipse.jface.viewers.SelectionChangedEvent(this, selection));
			}
		}
		
		public void removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener listener) {
			selectionChangedListeners.remove(listener);
		}
		
		public void addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener listener) {
			selectionChangedListeners.add(listener);
		}
		
	}
	
	/**
	 * This action will be activated if the button in the hover window is pushed to
	 * jump to the declaration.
	 */
	public static class OpenDeclarationAction extends org.eclipse.jface.action.Action {
		
		private final edap.resource.edap.ui.EdapBrowserInformationControl infoControl;
		
		/**
		 * Creates the action to jump to the declaration.
		 * 
		 * @param infoControl the info control holds the hover information and the target
		 * element
		 */
		public OpenDeclarationAction(edap.resource.edap.ui.EdapBrowserInformationControl infoControl) {
			this.infoControl = infoControl;
			setText("Open Declaration");
			org.eclipse.ui.ISharedImages images = org.eclipse.ui.PlatformUI.getWorkbench().getSharedImages();
			setImageDescriptor(images.getImageDescriptor(org.eclipse.ui.ISharedImages.IMG_ETOOL_HOME_NAV));
		}
		
		/**
		 * Creates, sets, activates a hyperlink.
		 */
		public void run() {
			edap.resource.edap.ui.EdapDocBrowserInformationControlInput infoInput = (edap.resource.edap.ui.EdapDocBrowserInformationControlInput) infoControl.getInput();
			infoControl.notifyDelayedInputChange(null);
			infoControl.dispose();
			if (infoInput.getInputElement() instanceof org.eclipse.emf.ecore.EObject) {
				org.eclipse.emf.ecore.EObject decEO = (org.eclipse.emf.ecore.EObject) infoInput.getInputElement();
				if (decEO != null && decEO.eResource() != null) {
					edap.resource.edap.ui.EdapHyperlink hyperlink = new edap.resource.edap.ui.EdapHyperlink(null, decEO, infoInput.getTokenText());
					hyperlink.open();
				}
			}
		}
	}
	
	/**
	 * Presenter control creator. Creates a hover control after focus.
	 */
	public static final class PresenterControlCreator extends org.eclipse.jface.text.AbstractReusableInformationControlCreator {
		
		public org.eclipse.jface.text.IInformationControl doCreateInformationControl(org.eclipse.swt.widgets.Shell parent) {
			if (edap.resource.edap.ui.EdapBrowserInformationControl.isAvailable(parent)) {
				org.eclipse.jface.action.ToolBarManager tbm = new org.eclipse.jface.action.ToolBarManager(org.eclipse.swt.SWT.FLAT);
				edap.resource.edap.ui.EdapBrowserInformationControl iControl = new edap.resource.edap.ui.EdapBrowserInformationControl(parent, FONT, tbm);
				final OpenDeclarationAction openDeclarationAction = new OpenDeclarationAction(iControl);
				tbm.add(openDeclarationAction);
				final SimpleSelectionProvider selectionProvider = new SimpleSelectionProvider();
				
				org.eclipse.jface.text.IInputChangedListener inputChangeListener = new org.eclipse.jface.text.IInputChangedListener() {
					public void inputChanged(Object newInput) {
						if (newInput == null) {
							selectionProvider.setSelection(new org.eclipse.jface.viewers.StructuredSelection());
						} else if (newInput instanceof edap.resource.edap.ui.EdapDocBrowserInformationControlInput) {
							edap.resource.edap.ui.EdapDocBrowserInformationControlInput input = (edap.resource.edap.ui.EdapDocBrowserInformationControlInput) newInput;
							Object inputElement = input.getInputElement();
							selectionProvider.setSelection(new org.eclipse.jface.viewers.StructuredSelection(inputElement));
							// If there is an element of type EObject in the input element, the button to open
							// the declaration will be set enable
							boolean isEObjectInput = inputElement instanceof org.eclipse.emf.ecore.EObject;
							openDeclarationAction.setEnabled(isEObjectInput);
							if (isEObjectInput) {
								String simpleName = inputElement.getClass().getSimpleName();
								simpleName = simpleName.substring(0, simpleName.length() - 4);
								openDeclarationAction.setText("Open " + simpleName);
							} else							openDeclarationAction.setText("Open Declaration");
						}
					}
				};
				iControl.addInputChangeListener(inputChangeListener);
				
				tbm.update(true);
				return iControl;
			} else {
				return new org.eclipse.jface.text.DefaultInformationControl(parent, true);
			}
		}
	}
	
	/**
	 * Hover control creator. Creates a hover control before focus.
	 */
	public static final class HoverControlCreator extends org.eclipse.jface.text.AbstractReusableInformationControlCreator {
		
		/**
		 * The information presenter control creator.
		 */
		private final org.eclipse.jface.text.IInformationControlCreator fInformationPresenterControlCreator;
		
		/**
		 * 
		 * @param informationPresenterControlCreator control creator for enriched hover
		 */
		public HoverControlCreator(org.eclipse.jface.text.IInformationControlCreator informationPresenterControlCreator) {
			fInformationPresenterControlCreator = informationPresenterControlCreator;
		}
		
		public org.eclipse.jface.text.IInformationControl doCreateInformationControl(org.eclipse.swt.widgets.Shell parent) {
			String tooltipAffordanceString = org.eclipse.ui.editors.text.EditorsUI.getTooltipAffordanceString();
			if (edap.resource.edap.ui.EdapBrowserInformationControl.isAvailable(parent)) {
				edap.resource.edap.ui.EdapBrowserInformationControl iControl = new edap.resource.edap.ui.EdapBrowserInformationControl(parent, FONT, tooltipAffordanceString) {
					public org.eclipse.jface.text.IInformationControlCreator getInformationPresenterControlCreator() {
						return fInformationPresenterControlCreator;
					}
				};
				return iControl;
			} else {
				return new org.eclipse.jface.text.DefaultInformationControl(parent, tooltipAffordanceString);
			}
		}
		
		public boolean canReuse(org.eclipse.jface.text.IInformationControl control) {
			if (!super.canReuse(control)) {
				return false;
			}
			
			if (control instanceof org.eclipse.jface.text.IInformationControlExtension4) {
				String tooltipAffordanceString = org.eclipse.ui.editors.text.EditorsUI.getTooltipAffordanceString();
				((org.eclipse.jface.text.IInformationControlExtension4) control).setStatusText(tooltipAffordanceString);
			}
			
			return true;
		}
	}
	
	/**
	 * Creates a new TextHover to collect the information about the hovered element.
	 */
	public EdapTextHover(edap.resource.edap.ui.EdapEditor editor) {
		super();
		this.editor = editor;
		hoverTextProvider = new edap.resource.edap.ui.EdapUIMetaInformation().getHoverTextProvider();
	}
	
	public String getHoverInfo(org.eclipse.jface.text.ITextViewer textViewer, org.eclipse.jface.text.IRegion hoverRegion) {
		return ((edap.resource.edap.ui.EdapDocBrowserInformationControlInput) getHoverInfo2(textViewer, hoverRegion)).getHtml();
	}
	
	public org.eclipse.jface.text.IRegion getHoverRegion(org.eclipse.jface.text.ITextViewer textViewer, int offset) {
		org.eclipse.swt.graphics.Point selection = textViewer.getSelectedRange();
		if (selection.x <= offset && offset < selection.x + selection.y) {
			return new org.eclipse.jface.text.Region(selection.x, selection.y);
		}
		return new org.eclipse.jface.text.Region(offset, 0);
	}
	
	public org.eclipse.jface.text.IInformationControlCreator getHoverControlCreator() {
		if (hoverControlCreator == null) {
			hoverControlCreator = new HoverControlCreator(			getInformationPresenterControlCreator());
		}
		return hoverControlCreator;
	}
	
	public org.eclipse.jface.text.IInformationControlCreator getInformationPresenterControlCreator() {
		if (presenterControlCreator == null) {
			presenterControlCreator = new PresenterControlCreator();
		}
		return presenterControlCreator;
	}
	
	public Object getHoverInfo2(org.eclipse.jface.text.ITextViewer textViewer, org.eclipse.jface.text.IRegion hoverRegion) {
		return hoverTextProvider == null ? null : internalGetHoverInfo(textViewer, hoverRegion);
	}
	
	private edap.resource.edap.ui.EdapDocBrowserInformationControlInput internalGetHoverInfo(org.eclipse.jface.text.ITextViewer textViewer, org.eclipse.jface.text.IRegion hoverRegion) {
		edap.resource.edap.IEdapTextResource textResource = editor.getResource();
		edap.resource.edap.IEdapLocationMap locationMap = textResource.getLocationMap();
		java.util.List<org.eclipse.emf.ecore.EObject> elementsAtOffset = locationMap.getElementsAt(hoverRegion.getOffset());
		if (elementsAtOffset == null || elementsAtOffset.size() == 0) {
			return null;
		}
		return getHoverInfo(elementsAtOffset, textViewer, null);
	}
	
	/**
	 * Computes the hover info.
	 * 
	 * @param elements the resolved elements
	 * @param constantValue a constant value iff result contains exactly 1 constant
	 * field, or <code>null</code>
	 * @param previousInput the previous input, or <code>null</code>
	 * 
	 * @return the HTML hover info for the given element(s) or <code>null</code> if no
	 * information is available
	 */
	private edap.resource.edap.ui.EdapDocBrowserInformationControlInput getHoverInfo(java.util.List<org.eclipse.emf.ecore.EObject> elements, org.eclipse.jface.text.ITextViewer textViewer, edap.resource.edap.ui.EdapDocBrowserInformationControlInput previousInput) {
		StringBuffer buffer = new StringBuffer();
		org.eclipse.emf.ecore.EObject proxyObject = getFirstProxy(elements);
		org.eclipse.emf.ecore.EObject declarationObject = null;
		// get the token text, which is hovered. It is needed to jump to the declaration.
		String tokenText = "";
		if (proxyObject != null) {
			edap.resource.edap.IEdapTextResource textResource = editor.getResource();
			edap.resource.edap.IEdapLocationMap locationMap = textResource.getLocationMap();
			int offset = locationMap.getCharStart(proxyObject);
			int length = locationMap.getCharEnd(proxyObject) + 1 - offset;
			try {
				tokenText = textViewer.getDocument().get(offset, length);
			} catch (org.eclipse.jface.text.BadLocationException e) {
			}
			declarationObject = org.eclipse.emf.ecore.util.EcoreUtil.resolve(proxyObject, editor.getResource());
			if (declarationObject != null) {
				edap.resource.edap.ui.EdapHTMLPrinter.addParagraph(buffer, hoverTextProvider.getHoverText(declarationObject));
			}
		} else {
			edap.resource.edap.ui.EdapHTMLPrinter.addParagraph(buffer, hoverTextProvider.getHoverText(elements.get(0)));
		}
		if (buffer.length() > 0) {
			edap.resource.edap.ui.EdapHTMLPrinter.insertPageProlog(buffer, 0, edap.resource.edap.ui.EdapTextHover.getStyleSheet());
			edap.resource.edap.ui.EdapHTMLPrinter.addPageEpilog(buffer);
			return new edap.resource.edap.ui.EdapDocBrowserInformationControlInput(previousInput, declarationObject, editor.getResource(), buffer.toString(), tokenText);
		}
		return null;
	}
	
	/**
	 * Sets the style sheet font.
	 * 
	 * @return the hover style sheet
	 */
	private static String getStyleSheet() {
		if (styleSheet == null) {
			styleSheet = loadStyleSheet();
		}
		String css = styleSheet;
		// Sets background color for the hover text window
		css += "body {background-color:#FFFFE1;}\n";
		if (css != null) {
			org.eclipse.swt.graphics.FontData fontData = org.eclipse.jface.resource.JFaceResources.getFontRegistry().getFontData(FONT)[0];
			css = edap.resource.edap.ui.EdapHTMLPrinter.convertTopLevelFont(css, fontData);
		}
		
		return css;
	}
	
	/**
	 * Loads and returns the hover style sheet.
	 * 
	 * @return the style sheet, or <code>null</code> if unable to load
	 */
	private static String loadStyleSheet() {
		org.osgi.framework.Bundle bundle = org.eclipse.core.runtime.Platform.getBundle(edap.resource.edap.ui.EdapUIPlugin.PLUGIN_ID);
		java.net.URL styleSheetURL = bundle.getEntry("/css/hover_style.css");
		if (styleSheetURL != null) {
			java.io.BufferedReader reader = null;
			try {
				reader = new java.io.BufferedReader(new java.io.InputStreamReader(styleSheetURL.openStream()));
				StringBuffer buffer = new StringBuffer();
				String line = reader.readLine();
				while (line != null) {
					buffer.append(line);
					buffer.append('\n');
					line = reader.readLine();
				}
				return buffer.toString();
			} catch (java.io.IOException ex) {
				ex.printStackTrace();
				return "";
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	private static org.eclipse.emf.ecore.EObject getFirstProxy(java.util.List<org.eclipse.emf.ecore.EObject> elements) {
		for (org.eclipse.emf.ecore.EObject object : elements) {
			if (object.eIsProxy()) {
				return object;
			}
		}
		return null;
	}
}
