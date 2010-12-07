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

public class EdapMULTIPLICITYTokenResolver implements edap.resource.edap.IEdapTokenResolver {
	
	private edap.resource.edap.analysis.EdapDefaultTokenResolver defaultTokenResolver = new edap.resource.edap.analysis.EdapDefaultTokenResolver();
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		if (((Integer)value) < 0) return "*";
		else return value.toString();
	}
	
	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, edap.resource.edap.IEdapTokenResolveResult result) {
		if (lexem.equals("*")) result.setResolvedToken(-1);
		else result.setResolvedToken(Integer.parseInt(lexem));
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
