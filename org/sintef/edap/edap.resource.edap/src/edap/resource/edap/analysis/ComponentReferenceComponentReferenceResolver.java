/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

import java.util.ArrayList;

import org.sintef.edap.EDAPHelpers;

import edap.Component;
import edap.EdapModel;

public class ComponentReferenceComponentReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.ComponentReference, edap.Component> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.ComponentReference, edap.Component> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.ComponentReference, edap.Component>();
	
	public void resolve(java.lang.String identifier, edap.ComponentReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Component> result) {
EdapModel root = EDAPHelpers.findRoot(container);
		
		String device = identifier;

		for ( EdapModel d : EDAPHelpers.allEdapModels(root)) {
			ArrayList<Component> comps = null;
			if (resolveFuzzy)
				comps = EDAPHelpers.allComponents(device, d);
			else
				comps = EDAPHelpers.allComponentsExact(device, d);
			for(Component comp : comps) 
				//if (comp.isSingleton()) result.addMapping(comp.getName(), comp);
				result.addMapping(comp.getName(), comp);
		}
		
		if (!result.wasResolved())
			result.setErrorMessage("Cannot resolve singleton device " + identifier);
	}
	
	public java.lang.String deResolve(edap.Component element, edap.ComponentReference container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
