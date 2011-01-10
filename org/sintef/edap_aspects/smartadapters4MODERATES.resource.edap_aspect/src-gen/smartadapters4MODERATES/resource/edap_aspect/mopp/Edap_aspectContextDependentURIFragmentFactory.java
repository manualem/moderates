/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class Edap_aspectContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public Edap_aspectContextDependentURIFragmentFactory(smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
