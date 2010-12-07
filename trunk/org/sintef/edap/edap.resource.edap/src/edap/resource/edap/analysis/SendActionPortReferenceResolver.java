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

public class SendActionPortReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.SendAction, edap.Port> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.SendAction, edap.Port> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.SendAction, edap.Port>();
	
	public void resolve(java.lang.String identifier, edap.SendAction container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Port> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(edap.Port element, edap.SendAction container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
