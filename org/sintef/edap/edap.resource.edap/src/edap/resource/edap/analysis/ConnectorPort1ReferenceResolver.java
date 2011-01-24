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

public class ConnectorPort1ReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.Connector, edap.Port> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Connector, edap.Port> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Connector, edap.Port>();
	
	public void resolve(java.lang.String identifier, edap.Connector container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Port> result) {
		checkConnectorPortRef(identifier, container, result, resolveFuzzy, 1);
	}
	
	
	/**
	 * 
	 * @param id
	 * @param connector
	 * @param result
	 * @param fuzzy
	 */
	public static void checkConnectorPortRef (String id, 
			edap.Connector connector, 
			final edap.resource.edap.IEdapReferenceResolveResult<edap.Port> result, 
			boolean fuzzy,
			int portNo) {
		Component owner = connector.getOwner();
		checkPorts(id, owner, connector, null, result, fuzzy, portNo);

		for (Property p : owner.getProperties()) {
			if (p.getType() instanceof Component){
				Component c = (Component)p.getType();
				checkPorts(id, c, connector, p, result, fuzzy, portNo);
			}
		}
		if(!result.wasResolved()) result.setErrorMessage("Cannot resolve type " + id);		
	}
	
	/**
	 * 
	 * @param id
	 * @param c
	 * @param conn
	 * @param p
	 * @param result
	 * @param fuzzy
	 */
	public static void checkPorts (String id, 
			Component c,
			Connector conn,
			Property p, 
			final edap.resource.edap.IEdapReferenceResolveResult<edap.Port> result,
			boolean fuzzy,
			int portNo) {
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
					if (p != null && portNo == 1) {
						conn.setProp1(p);
					} else if (p != null && portNo == 2) {
						conn.setProp2(p);
					}
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
