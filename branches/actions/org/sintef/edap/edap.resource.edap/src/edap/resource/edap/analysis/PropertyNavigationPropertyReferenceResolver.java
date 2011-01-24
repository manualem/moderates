/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

import org.sintef.edap.EDAPHelpers;

import edap.Component;
import edap.ComponentReference;
import edap.Property;
import edap.PropertyNavigation;
import edap.Type;

public class PropertyNavigationPropertyReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.PropertyNavigation, edap.Property> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.PropertyNavigation, edap.Property> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.PropertyNavigation, edap.Property>();
	
	public void resolve(java.lang.String identifier, edap.PropertyNavigation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Property> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
		/*
		Component target = EDAPHelpers.getTargetType(container);
		
		if (target != null) {
		
			for(Property p : target.getProperties()) {
				if (p.getName().startsWith(identifier))
					result.addMapping(p.getName(), p);
			}
			
			if (!result.wasResolved())
				result.setErrorMessage("Cannot resolve property " + identifier + " in component " + target.getName());
		}
		else {
			result.setErrorMessage("Cannot resolve target component for property " + identifier );
		}
		*/
	}
	
	public java.lang.String deResolve(edap.Property element, edap.PropertyNavigation container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
	

	
}
