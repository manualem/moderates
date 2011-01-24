/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

import edap.Component;
import edap.Connector;
import edap.Port;
import edap.Property;

public class ConnectorPortsReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.Connector, edap.Port> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Connector, edap.Port> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Connector, edap.Port>();
	
	public void resolve(java.lang.String identifier, edap.Connector container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Port> result) {
		Component owner = container.getOwner();
		checkPorts(identifier, owner, container, null, result, resolveFuzzy);

		for (Property p : owner.getProperties()) {
			if (p.getType() instanceof Component){
				Component c = (Component)p.getType();
				checkPorts(identifier, c, container, p, result, resolveFuzzy);
			}
		}
		if(!result.wasResolved()) result.setErrorMessage("Cannot resolve type " + identifier);
	}
	
	
	public static void checkPorts (String id, 
			Component c,
			Connector conn,
			Property p, 
			final edap.resource.edap.IEdapReferenceResolveResult<edap.Port> result,
			boolean fuzzy) {
		String propName = "" ;
		String lookFor;
		if (p != null) propName = p.getName() + "_";
		
		for (Port port : c.getPorts()) {
			lookFor  = propName + port.getName(); 
			if (fuzzy) {				
				if (lookFor.startsWith(id))
					result.addMapping(lookFor, port);
			} else {
				if (lookFor.equalsIgnoreCase(id)) {
					result.addMapping(lookFor, port);
				}
			}
		}
	}	
	
	public java.lang.String deResolve(edap.Port element, edap.Connector container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
