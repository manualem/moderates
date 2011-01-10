/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect;

/**
 * An interface for factories to create instances of
 * smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectContextDependentURIFrag
 * ment.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public interface IEdap_aspectContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> {
	
	/**
	 * Create a new instance of the
	 * smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectContextDependentURIFrag
	 * ment interface.
	 * 
	 * @param identifier the identifier that references an Object
	 * @param container the object that contains the reference
	 * @param reference the reference itself
	 * @param positionInReference the position of the identifier (if the reference is
	 * multiple)
	 * @param proxy the proxy that will be resolved later to the actual EObject
	 * 
	 * @return the new instance of
	 * smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectContextDependentURIFrag
	 * ment
	 */
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy);
}
