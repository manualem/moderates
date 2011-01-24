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
import edap.Device;
import edap.EdapModel;

public class SimulatorDeviceReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.Simulator, edap.Device> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Simulator, edap.Device> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Simulator, edap.Device>();
	
	public void resolve(java.lang.String identifier, edap.Simulator container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Device> result) {
		EdapModel root = EDAPHelpers.findRoot(container);
		
		String device = identifier;
		
		for ( EdapModel d : EDAPHelpers.allEdapModels(root)) {
			ArrayList<Component> devs = EDAPHelpers.allComponents(device, d);
			for(Component dev : devs) 
				if (dev instanceof Device)
					result.addMapping(dev.getName(), (Device)dev);
		}
		
		if (!result.wasResolved())
			result.setErrorMessage("Cannot resolve device " + identifier);
	}
	
	public java.lang.String deResolve(edap.Device element, edap.Simulator container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
