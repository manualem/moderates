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
package edapuC.resource.edapuC.analysis;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import edap.EdapModel;
import edapuC.UCGenerator;

public class UCGeneratorImportsReferenceResolver implements edapuC.resource.edapuC.IEdapuCReferenceResolver<edapuC.UCGenerator, edapuC.UCGenerator> {
	
	private edapuC.resource.edapuC.analysis.EdapuCDefaultResolverDelegate<edapuC.UCGenerator, edapuC.UCGenerator> delegate = new edapuC.resource.edapuC.analysis.EdapuCDefaultResolverDelegate<edapuC.UCGenerator, edapuC.UCGenerator>();
	
	public void resolve(java.lang.String identifier, edapuC.UCGenerator container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edapuC.resource.edapuC.IEdapuCReferenceResolveResult<edapuC.UCGenerator> result) {
		try {
			URI uri = URI.createURI(identifier).resolve(container.eResource().getURI());
			Resource r = container.eResource().getResourceSet().getResource(uri, true);
			r.load(null);
			UCGenerator m = (UCGenerator)r.getContents().get(0);
			result.addMapping(identifier, m);
		} catch (ClassCastException e) {
			result.setErrorMessage("The given URI contains a model with a wrong type");
		} catch (Exception e) {
			result.setErrorMessage("Unable to load model with uri: " + identifier);
		}
	}
	
	public java.lang.String deResolve(edapuC.UCGenerator element, edapuC.UCGenerator container, org.eclipse.emf.ecore.EReference reference) {
		return element.eResource().getURI().toString();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
