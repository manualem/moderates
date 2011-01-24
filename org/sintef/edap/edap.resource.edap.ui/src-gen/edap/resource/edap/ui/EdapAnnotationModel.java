/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.ui;

public class EdapAnnotationModel extends org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel implements org.eclipse.jface.text.source.IAnnotationModel {
	
	public EdapAnnotationModel(org.eclipse.core.resources.IResource resource) {
		super(resource);
	}
	
	protected org.eclipse.ui.texteditor.MarkerAnnotation createMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		return new edap.resource.edap.ui.EdapMarkerAnnotation(marker);
	}
	
}
