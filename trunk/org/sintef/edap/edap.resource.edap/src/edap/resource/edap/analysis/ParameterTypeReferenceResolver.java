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

import java.util.ArrayList;

import edap.EdapModel;
import edap.Type;
import edap.resource.edap.analysis.helper.EDAPHelpers;

public class ParameterTypeReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.Parameter, edap.Type> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Parameter, edap.Type> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.Parameter, edap.Type>();
	
	public void resolve(java.lang.String identifier, edap.Parameter container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Type> result) {
		EdapModel root = EDAPHelpers.findRoot(container);
		ArrayList<Type> ts = EDAPHelpers.allType(identifier, root);
		for (Type t : ts) {
				
			if (t.getName().equals(identifier)) result.addMapping(t.getName(), t);
		}
		if(!result.wasResolved()) result.setErrorMessage("Cannot resolve type " + identifier);
	}
	
	public java.lang.String deResolve(edap.Type element, edap.Parameter container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
