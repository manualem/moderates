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
 
package edapuC.resource.edapuC.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class EdapuCProposalPostProcessor {
	
	public java.util.List<edapuC.resource.edapuC.ui.EdapuCCompletionProposal> process(java.util.List<edapuC.resource.edapuC.ui.EdapuCCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
