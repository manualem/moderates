/*******************************************************************************
 * Copyright (c) 2010 SINTEF
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SINTEF - initial API and implementation
 ******************************************************************************/
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.analysis;

public class ConnectorPort2ReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.Connector, edap.Port> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Connector, edap.Port> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Connector, edap.Port>();
	
	public void resolve(java.lang.String identifier, edap.Connector container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Port> result) {
		ConnectorPort1ReferenceResolver.checkConnectorPortRef(identifier, container, result, resolveFuzzy, 2);
	}
	
	public java.lang.String deResolve(edap.Port element, edap.Connector container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
