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
 
package edap.resource.edap;

public interface IEdapProblem {
	public String getMessage();
	public edap.resource.edap.EdapEProblemType getType();
	public java.util.Collection<edap.resource.edap.IEdapQuickFix> getQuickFixes();
}
