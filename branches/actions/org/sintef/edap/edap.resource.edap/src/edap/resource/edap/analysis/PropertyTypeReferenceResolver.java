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
import edap.Type;

public class PropertyTypeReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.Property, edap.Type> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Property, edap.Type> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Property, edap.Type>();
	
	public void resolve(java.lang.String identifier, edap.Property container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Type> result) {
		EdapModel root = EDAPHelpers.findRoot(container);
		ArrayList<Type> ts = EDAPHelpers.allType(identifier, root);
		for (Type t : ts) {
			if (resolveFuzzy) result.addMapping(t.getName(), t);
			else if (t.getName().equals(identifier)) result.addMapping(t.getName(), t);
		}
		if(!result.wasResolved()) result.setErrorMessage("Cannot resolve type " + identifier);
	}
	
	
	public java.lang.String deResolve(edap.Type element, edap.Property container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
