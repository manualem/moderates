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
import edap.Property;
import edap.State;
import edap.Type;
import edap.resource.edap.analysis.helper.EDAPHelpers;

public class PropertyAssignmentPropertyReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.PropertyAssignment, edap.Property> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.PropertyAssignment, edap.Property> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.PropertyAssignment, edap.Property>();
	
	public void resolve(java.lang.String identifier, edap.PropertyAssignment container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.Property> result) {
		State s = EDAPHelpers.findContainingState(container);
		ArrayList<Property> ps = EDAPHelpers.allProperties(s, identifier);
		for(Property p : ps) {
			result.addMapping(p.getName(), p);
		}
		
		if (!result.wasResolved())
			result.setErrorMessage("Cannot resolve variable " + identifier);

	}
	
	public java.lang.String deResolve(edap.Property element, edap.PropertyAssignment container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
