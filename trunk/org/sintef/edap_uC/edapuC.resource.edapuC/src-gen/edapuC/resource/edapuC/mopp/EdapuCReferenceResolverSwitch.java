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

public class EdapuCReferenceResolverSwitch implements edapuC.resource.edapuC.IEdapuCReferenceResolverSwitch {
	
	protected edapuC.resource.edapuC.analysis.UCGeneratorImportsReferenceResolver uCGeneratorImportsReferenceResolver = new edapuC.resource.edapuC.analysis.UCGeneratorImportsReferenceResolver();
	protected edapuC.resource.edapuC.analysis.UCGeneratorEdapReferenceResolver uCGeneratorEdapReferenceResolver = new edapuC.resource.edapuC.analysis.UCGeneratorEdapReferenceResolver();
	protected edapuC.resource.edapuC.analysis.UCDeviceDeviceReferenceResolver uCDeviceDeviceReferenceResolver = new edapuC.resource.edapuC.analysis.UCDeviceDeviceReferenceResolver();
	protected edapuC.resource.edapuC.analysis.UCApplicationState_machineReferenceResolver uCApplicationState_machineReferenceResolver = new edapuC.resource.edapuC.analysis.UCApplicationState_machineReferenceResolver();
	protected edapuC.resource.edapuC.analysis.UCMessageMessageReferenceResolver uCMessageMessageReferenceResolver = new edapuC.resource.edapuC.analysis.UCMessageMessageReferenceResolver();
	
	public edapuC.resource.edapuC.analysis.UCGeneratorImportsReferenceResolver getUCGeneratorImportsReferenceResolver() {
		return uCGeneratorImportsReferenceResolver;
	}
	
	public edapuC.resource.edapuC.analysis.UCGeneratorEdapReferenceResolver getUCGeneratorEdapReferenceResolver() {
		return uCGeneratorEdapReferenceResolver;
	}
	
	public edapuC.resource.edapuC.analysis.UCDeviceDeviceReferenceResolver getUCDeviceDeviceReferenceResolver() {
		return uCDeviceDeviceReferenceResolver;
	}
	
	public edapuC.resource.edapuC.analysis.UCApplicationState_machineReferenceResolver getUCApplicationState_machineReferenceResolver() {
		return uCApplicationState_machineReferenceResolver;
	}
	
	public edapuC.resource.edapuC.analysis.UCMessageMessageReferenceResolver getUCMessageMessageReferenceResolver() {
		return uCMessageMessageReferenceResolver;
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		uCGeneratorImportsReferenceResolver.setOptions(options);
		uCGeneratorEdapReferenceResolver.setOptions(options);
		uCDeviceDeviceReferenceResolver.setOptions(options);
		uCApplicationState_machineReferenceResolver.setOptions(options);
		uCMessageMessageReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, edapuC.resource.edapuC.IEdapuCReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (edapuC.EdapuCPackage.eINSTANCE.getUCGenerator().isInstance(container)) {
			EdapuCFuzzyResolveResult<edapuC.UCGenerator> frr = new EdapuCFuzzyResolveResult<edapuC.UCGenerator>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("imports")) {
				uCGeneratorImportsReferenceResolver.resolve(identifier, (edapuC.UCGenerator) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edapuC.EdapuCPackage.eINSTANCE.getUCGenerator().isInstance(container)) {
			EdapuCFuzzyResolveResult<edap.EdapModel> frr = new EdapuCFuzzyResolveResult<edap.EdapModel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("edap")) {
				uCGeneratorEdapReferenceResolver.resolve(identifier, (edapuC.UCGenerator) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edapuC.EdapuCPackage.eINSTANCE.getUCDevice().isInstance(container)) {
			EdapuCFuzzyResolveResult<edap.Component> frr = new EdapuCFuzzyResolveResult<edap.Component>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("device")) {
				uCDeviceDeviceReferenceResolver.resolve(identifier, (edapuC.UCDevice) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edapuC.EdapuCPackage.eINSTANCE.getUCApplication().isInstance(container)) {
			EdapuCFuzzyResolveResult<edap.Component> frr = new EdapuCFuzzyResolveResult<edap.Component>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("state_machine")) {
				uCApplicationState_machineReferenceResolver.resolve(identifier, (edapuC.UCApplication) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edapuC.EdapuCPackage.eINSTANCE.getUCMessage().isInstance(container)) {
			EdapuCFuzzyResolveResult<edap.Message> frr = new EdapuCFuzzyResolveResult<edap.Message>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("message")) {
				uCMessageMessageReferenceResolver.resolve(identifier, (edapuC.UCMessage) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public edapuC.resource.edapuC.IEdapuCReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == edapuC.EdapuCPackage.eINSTANCE.getUCGenerator_Imports()) {
			return uCGeneratorImportsReferenceResolver;
		}
		if (reference == edapuC.EdapuCPackage.eINSTANCE.getUCGenerator_Edap()) {
			return uCGeneratorEdapReferenceResolver;
		}
		if (reference == edapuC.EdapuCPackage.eINSTANCE.getUCDevice_Device()) {
			return uCDeviceDeviceReferenceResolver;
		}
		if (reference == edapuC.EdapuCPackage.eINSTANCE.getUCApplication_State_machine()) {
			return uCApplicationState_machineReferenceResolver;
		}
		if (reference == edapuC.EdapuCPackage.eINSTANCE.getUCMessage_Message()) {
			return uCMessageMessageReferenceResolver;
		}
		return null;
	}
	
}
