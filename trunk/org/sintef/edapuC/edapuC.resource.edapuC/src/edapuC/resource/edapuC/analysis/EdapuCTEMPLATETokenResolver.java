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

public class EdapuCTEMPLATETokenResolver implements edapuC.resource.edapuC.IEdapuCTokenResolver {
	
	private edapuC.resource.edapuC.analysis.EdapuCDefaultTokenResolver defaultTokenResolver = new edapuC.resource.edapuC.analysis.EdapuCDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		java.lang.String result = defaultTokenResolver.deResolve(value, feature, container);
		return "<template>" + result + "</template>";
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, edapuC.resource.edapuC.IEdapuCTokenResolveResult result) {
		result.setResolvedToken(lexem.substring(10, lexem.length()-11));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
