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

import edap.Component;
import edap.Expression;
import edap.Message;
import edap.Message;
import edap.resource.edap.analysis.helper.EDAPHelpers;

public class ReceiveMessageMessageReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.ReceiveMessage, Message> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.ReceiveMessage, Message> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.ReceiveMessage, Message>();
	
	public void resolve(java.lang.String identifier, edap.ReceiveMessage container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<Message> result) {
		String message = identifier;
		Expression ref = container.getDevice();
		
		Component d = EDAPHelpers.getExpressionComponentType(ref);
		
		if (d != null) {
			
			Component cd = EDAPHelpers.findContainingComponent(container);
			
			if (d == cd) {
				for (Message m : d.getReceives()) {
					if (m.getName().startsWith(message) && m instanceof Message) {
						result.addMapping(m.getName(), m);
					}
				}
			}
			else {
				for (Message m : d.getSends()) {
					if (m.getName().startsWith(message) && m instanceof Message) {
						result.addMapping(m.getName(), m);
					}
				}
			}
		}
		
		if (!result.wasResolved())
			result.setErrorMessage("Cannot resolve outgoing message " + identifier);
	}
	
	public java.lang.String deResolve(Message element, edap.ReceiveMessage container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
