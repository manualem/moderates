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

import edap.Device;
import edap.Message;
import edapuC.UCDevice;

public class UCMessageMessageReferenceResolver implements edapuC.resource.edapuC.IEdapuCReferenceResolver<edapuC.UCMessage, edap.Message> {
	
	private edapuC.resource.edapuC.analysis.EdapuCDefaultResolverDelegate<edapuC.UCMessage, edap.Message> delegate = new edapuC.resource.edapuC.analysis.EdapuCDefaultResolverDelegate<edapuC.UCMessage, edap.Message>();
	
	public void resolve(java.lang.String identifier, edapuC.UCMessage container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edapuC.resource.edapuC.IEdapuCReferenceResolveResult<edap.Message> result) {
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
		ArrayList<Message> msgs = UCGeneratorHelpers.findMessages(identifier, (UCDevice)container.eContainer());
		if (msgs.isEmpty()) {
			result.setErrorMessage("Cannot reslove message " + identifier);
			return;
		}
		for(Message m : msgs) {
			result.addMapping(m.getName(), m);
		}
	}
	
	public java.lang.String deResolve(edap.Message element, edapuC.UCMessage container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
