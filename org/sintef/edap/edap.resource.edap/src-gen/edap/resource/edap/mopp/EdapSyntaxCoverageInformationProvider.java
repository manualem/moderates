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
 
package edap.resource.edap.mopp;

public class EdapSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			edap.EdapPackage.eINSTANCE.getEdapModel(),
			edap.EdapPackage.eINSTANCE.getMessage(),
			edap.EdapPackage.eINSTANCE.getDevice(),
			edap.EdapPackage.eINSTANCE.getSoftwareComponent(),
			edap.EdapPackage.eINSTANCE.getSimulator(),
			edap.EdapPackage.eINSTANCE.getProperty(),
			edap.EdapPackage.eINSTANCE.getDictionary(),
			edap.EdapPackage.eINSTANCE.getParameter(),
			edap.EdapPackage.eINSTANCE.getPrimitiveType(),
			edap.EdapPackage.eINSTANCE.getEnumeration(),
			edap.EdapPackage.eINSTANCE.getEnumerationLiteral(),
			edap.EdapPackage.eINSTANCE.getPlatformAnnotation(),
			edap.EdapPackage.eINSTANCE.getStateMachine(),
			edap.EdapPackage.eINSTANCE.getState(),
			edap.EdapPackage.eINSTANCE.getCompositeState(),
			edap.EdapPackage.eINSTANCE.getActionBlock(),
			edap.EdapPackage.eINSTANCE.getExternStatement(),
			edap.EdapPackage.eINSTANCE.getPropertyAssignment(),
			edap.EdapPackage.eINSTANCE.getExternExpression(),
			edap.EdapPackage.eINSTANCE.getComponentReference(),
			edap.EdapPackage.eINSTANCE.getEventReference(),
			edap.EdapPackage.eINSTANCE.getPropertyNavigation(),
			edap.EdapPackage.eINSTANCE.getDictionaryNavigation(),
			edap.EdapPackage.eINSTANCE.getUnicast(),
			edap.EdapPackage.eINSTANCE.getBroadcast(),
			edap.EdapPackage.eINSTANCE.getTransition(),
			edap.EdapPackage.eINSTANCE.getReceiveMessage(),
			edap.EdapPackage.eINSTANCE.getConnector(),
			edap.EdapPackage.eINSTANCE.getPort(),
			edap.EdapPackage.eINSTANCE.getCreateAction(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			edap.EdapPackage.eINSTANCE.getEdapModel(),
		};
	}
	
}
