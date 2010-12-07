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

import org.eclipse.emf.ecore.EObject;

import edap.Event;
import edap.Message;
import edap.ReceiveMessage;
import edap.Transition;

public class EventReferenceMsgRefReferenceResolver implements edap.resource.edap.IEdapReferenceResolver<edap.EventReference, edap.ReceiveMessage> {
	
	private edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.EventReference, edap.ReceiveMessage> delegate = new edap.resource.edap.analysis.EdapDefaultResolverDelegate<edap.EventReference, edap.ReceiveMessage>();
	
	public void resolve(String identifier, edap.EventReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edap.resource.edap.IEdapReferenceResolveResult<edap.ReceiveMessage> result) {
		// get the transition object
		Transition t = null;
		EObject parent = container.eContainer();
		while (!(parent instanceof Transition))
			parent = parent.eContainer();
		t = (Transition) parent;
		
		for (Event ev : t.getEvent()) {	
			if (ev instanceof ReceiveMessage) {
				ReceiveMessage rm = (ReceiveMessage)ev;
				Message msg = rm.getMessage();
				// TODO is fuzzy mod
				if (resolveFuzzy) {
					if (msg.getName().startsWith(identifier))
						result.addMapping(msg.getName(), rm);
				} else {
					if (msg.getName().equalsIgnoreCase(identifier))
						result.addMapping(msg.getName(), rm);
				}
			}
		}		
		if (!result.wasResolved())
			result.setErrorMessage("Cannot resolve receive message(event): " + identifier);
		// delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edap.ReceiveMessage element, edap.EventReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
