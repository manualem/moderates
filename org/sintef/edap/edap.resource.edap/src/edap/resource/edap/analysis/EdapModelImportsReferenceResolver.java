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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import edap.EdapModel;

public class EdapModelImportsReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.EdapModel, edap.EdapModel> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.EdapModel, edap.EdapModel> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.EdapModel, edap.EdapModel>();
	
	public void resolve(java.lang.String identifier, edap.EdapModel container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.EdapModel> result) {
		try {
			URI uri = URI.createURI(identifier).resolve(container.eResource().getURI());
			Resource r = container.eResource().getResourceSet().getResource(uri, true);
			r.load(null);
			EdapModel m = (EdapModel)r.getContents().get(0);
			result.addMapping(identifier, m);
		} catch (ClassCastException e) {
			result.setErrorMessage("The given URI contains a model with a wrong type");
		} catch (Exception e) {
			result.setErrorMessage("Unable to load model with uri: " + identifier);
		}
	}
	
	public java.lang.String deResolve(edap.EdapModel element, edap.EdapModel container, org.eclipse.emf.ecore.EReference reference) {
		return element.eResource().getURI().toString();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
