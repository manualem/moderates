/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.ui;

public class Edap_aspectMarkerAnnotation extends org.eclipse.ui.texteditor.MarkerAnnotation implements org.eclipse.jface.text.quickassist.IQuickFixableAnnotation {
	
	boolean quickFixableState;
	boolean isQuickFixable;
	
	public Edap_aspectMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		super(marker);
	}
	
	public void setQuickFixable(boolean state) {
		isQuickFixable = state;
		quickFixableState = true;
	}
	
	public boolean isQuickFixableStateSet() {
		return true;
		//return quickFixableState;
	}
	
	public boolean isQuickFixable() {
		try {
			return getMarker().getAttribute(org.eclipse.core.resources.IMarker.SOURCE_ID) != null;
		} catch (org.eclipse.core.runtime.CoreException e) {
			// ignore
		}
		return false;
	}
	
}
