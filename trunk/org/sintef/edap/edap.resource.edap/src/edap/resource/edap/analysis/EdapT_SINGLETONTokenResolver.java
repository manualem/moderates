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

public class EdapT_SINGLETONTokenResolver implements edap.resource.edap.IEdapTokenResolver {
	
	private edap.resource.edap.analysis.EdapDefaultTokenResolver defaultTokenResolver = new edap.resource.edap.analysis.EdapDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = "";
		if (value.toString().equals("true")) {
			result = "singleton ";
		}
		return result;
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, edap.resource.edap.IEdapTokenResolveResult result) {
		defaultTokenResolver.resolve(lexem, feature, result);
		result.setResolvedToken(lexem.equals("singleton"));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
