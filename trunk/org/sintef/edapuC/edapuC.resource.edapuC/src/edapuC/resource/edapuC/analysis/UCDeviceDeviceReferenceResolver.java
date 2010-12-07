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

import java.util.ArrayList;

import edap.Component;
import edap.Device;

public class UCDeviceDeviceReferenceResolver implements edapuC.resource.edapuC.IEdapuCReferenceResolver<edapuC.UCDevice, edap.Component> {
	
	private edapuC.resource.edapuC.analysis.EdapuCDefaultResolverDelegate<edapuC.UCDevice, edap.Component> delegate = new edapuC.resource.edapuC.analysis.EdapuCDefaultResolverDelegate<edapuC.UCDevice, edap.Component>();
	
	public void resolve(java.lang.String identifier, edapuC.UCDevice container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edapuC.resource.edapuC.IEdapuCReferenceResolveResult<edap.Component> result) {
		ArrayList<Device> devices = UCGeneratorHelpers.resolveDevice(identifier, UCGeneratorHelpers.findRootUCGenerator(container));
		if (devices.isEmpty()) {
			result.setErrorMessage("Cannot reslove device " + identifier);
			return;
		}
		for(Component d : devices) {
			result.addMapping(d.getName(), d);
		}
	}
	
	public java.lang.String deResolve(edap.Component element, edapuC.UCDevice container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
