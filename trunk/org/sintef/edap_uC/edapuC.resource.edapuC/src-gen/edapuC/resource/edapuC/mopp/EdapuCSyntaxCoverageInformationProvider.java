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
 
package edapuC.resource.edapuC.mopp;

public class EdapuCSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			edapuC.EdapuCPackage.eINSTANCE.getUCGenerator(),
			edapuC.EdapuCPackage.eINSTANCE.getUCDevice(),
			edapuC.EdapuCPackage.eINSTANCE.getUCApplication(),
			edapuC.EdapuCPackage.eINSTANCE.getUCMessage(),
			edapuC.EdapuCPackage.eINSTANCE.getTemplate(),
			edapuC.EdapuCPackage.eINSTANCE.getStaticProperty(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			edapuC.EdapuCPackage.eINSTANCE.getUCGenerator(),
		};
	}
	
}
