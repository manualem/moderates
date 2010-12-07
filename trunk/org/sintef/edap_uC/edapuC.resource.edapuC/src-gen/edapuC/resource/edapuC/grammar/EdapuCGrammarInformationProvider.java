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
 
package edapuC.resource.edapuC.grammar;

public class EdapuCGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public static class Rule extends edapuC.resource.edapuC.grammar.EdapuCSyntaxElement {
		
		private final org.eclipse.emf.ecore.EClass metaclass;
		
		public Rule(org.eclipse.emf.ecore.EClass metaclass, edapuC.resource.edapuC.grammar.EdapuCChoice choice, edapuC.resource.edapuC.grammar.EdapuCCardinality cardinality) {
			super(cardinality, new edapuC.resource.edapuC.grammar.EdapuCSyntaxElement[] {choice});
			this.metaclass = metaclass;
		}
		
		public org.eclipse.emf.ecore.EClass getMetaclass() {
			return metaclass;
		}
		
		public edapuC.resource.edapuC.grammar.EdapuCChoice getDefinition() {
			return (edapuC.resource.edapuC.grammar.EdapuCChoice) getChildren()[0];
		}
	}
	
	public final static edapuC.resource.edapuC.grammar.EdapuCLineBreak EDAPUC_0_0_0_0_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCLineBreak(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_0_0_0_0_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("import", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_0_0_0_0_0_0_2 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCPlaceholder EDAPUC_0_0_0_0_0_0_3 = new edapuC.resource.edapuC.grammar.EdapuCPlaceholder(edapuC.EdapuCPackage.eINSTANCE.getUCGenerator().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__IMPORTS), "STRING_LITERAL", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_0_0_0_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_0_0_0_0, EDAPUC_0_0_0_0_0_0_1, EDAPUC_0_0_0_0_0_0_2, EDAPUC_0_0_0_0_0_0_3);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_0_0_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_0_0_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_0_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_0_0_0_0_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.STAR);
	public final static edapuC.resource.edapuC.grammar.EdapuCLineBreak EDAPUC_0_0_0_1_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCLineBreak(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_0_0_0_1_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("edap", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_0_0_0_1_0_0_2 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCPlaceholder EDAPUC_0_0_0_1_0_0_3 = new edapuC.resource.edapuC.grammar.EdapuCPlaceholder(edapuC.EdapuCPackage.eINSTANCE.getUCGenerator().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__EDAP), "STRING_LITERAL", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_0_0_0_1_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_1_0_0_0, EDAPUC_0_0_0_1_0_0_1, EDAPUC_0_0_0_1_0_0_2, EDAPUC_0_0_0_1_0_0_3);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_0_0_0_1_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_1_0_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_0_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_0_0_0_1_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.STAR);
	public final static edapuC.resource.edapuC.grammar.EdapuCLineBreak EDAPUC_0_0_0_2_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCLineBreak(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_0_0_0_2_0_0_1_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCGenerator().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__PROPERTIES), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_0_0_0_2_0_0_1_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_2_0_0_1_0_0_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_0_0_0_2_0_0_1_0_1_0 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCGenerator().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__DEVICES), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_0_0_0_2_0_0_1_0_1 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_2_0_0_1_0_1_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_0_0_0_2_0_0_1_0_2_0 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCGenerator().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__APPLICATION), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_0_0_0_2_0_0_1_0_2 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_2_0_0_1_0_2_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_0_0_0_2_0_0_1_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_2_0_0_1_0_0, EDAPUC_0_0_0_2_0_0_1_0_1, EDAPUC_0_0_0_2_0_0_1_0_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_0_0_0_2_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_0_0_0_2_0_0_1_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_0_0_0_2_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_2_0_0_0, EDAPUC_0_0_0_2_0_0_1);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_0_0_0_2_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_2_0_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_0_0_0_2 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_0_0_0_2_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.STAR);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0_0, EDAPUC_0_0_0_1, EDAPUC_0_0_0_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_0_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_0_0_0);
	public final static Rule EDAPUC_0 = new Rule(edapuC.EdapuCPackage.eINSTANCE.getUCGenerator(), EDAPUC_0_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_1_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("device", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_1_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCPlaceholder EDAPUC_1_0_0_2 = new edapuC.resource.edapuC.grammar.EdapuCPlaceholder(edapuC.EdapuCPackage.eINSTANCE.getUCDevice().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__DEVICE), "TEXT", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_1_0_0_3 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("{", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCLineBreak EDAPUC_1_0_0_4_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCLineBreak(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_1_0_0_4_0_0_1_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("init", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_1_0_0_4_0_0_1_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_1_0_0_4_0_0_1_0_0_2 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCDevice().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__INIT), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_1_0_0_4_0_0_1_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0_4_0_0_1_0_0_0, EDAPUC_1_0_0_4_0_0_1_0_0_1, EDAPUC_1_0_0_4_0_0_1_0_0_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_1_0_0_4_0_0_1_0_1_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("poll", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_1_0_0_4_0_0_1_0_1_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_1_0_0_4_0_0_1_0_1_2 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCDevice().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__POLL), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_1_0_0_4_0_0_1_0_1 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0_4_0_0_1_0_1_0, EDAPUC_1_0_0_4_0_0_1_0_1_1, EDAPUC_1_0_0_4_0_0_1_0_1_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_1_0_0_4_0_0_1_0_2_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("global", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_1_0_0_4_0_0_1_0_2_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_1_0_0_4_0_0_1_0_2_2 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCDevice().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__GLOBAL), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_1_0_0_4_0_0_1_0_2 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0_4_0_0_1_0_2_0, EDAPUC_1_0_0_4_0_0_1_0_2_1, EDAPUC_1_0_0_4_0_0_1_0_2_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_1_0_0_4_0_0_1_0_3_0 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCDevice().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__PROPERTIES), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_1_0_0_4_0_0_1_0_3 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0_4_0_0_1_0_3_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_1_0_0_4_0_0_1_0_4_0 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCDevice().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__MESSAGES), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_1_0_0_4_0_0_1_0_4 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0_4_0_0_1_0_4_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_1_0_0_4_0_0_1_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0_4_0_0_1_0_0, EDAPUC_1_0_0_4_0_0_1_0_1, EDAPUC_1_0_0_4_0_0_1_0_2, EDAPUC_1_0_0_4_0_0_1_0_3, EDAPUC_1_0_0_4_0_0_1_0_4);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_1_0_0_4_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_1_0_0_4_0_0_1_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_1_0_0_4_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0_4_0_0_0, EDAPUC_1_0_0_4_0_0_1);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_1_0_0_4_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0_4_0_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_1_0_0_4 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_1_0_0_4_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.STAR);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_1_0_0_5 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("}", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_1_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0_0, EDAPUC_1_0_0_1, EDAPUC_1_0_0_2, EDAPUC_1_0_0_3, EDAPUC_1_0_0_4, EDAPUC_1_0_0_5);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_1_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_1_0_0);
	public final static Rule EDAPUC_1 = new Rule(edapuC.EdapuCPackage.eINSTANCE.getUCDevice(), EDAPUC_1_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_2_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("application", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_2_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCPlaceholder EDAPUC_2_0_0_2 = new edapuC.resource.edapuC.grammar.EdapuCPlaceholder(edapuC.EdapuCPackage.eINSTANCE.getUCApplication().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__STATE_MACHINE), "TEXT", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_2_0_0_3 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("{", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCLineBreak EDAPUC_2_0_0_4_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCLineBreak(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_2_0_0_4_0_0_1_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("init", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_2_0_0_4_0_0_1_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_2_0_0_4_0_0_1_0_0_2 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCApplication().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__INIT), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_2_0_0_4_0_0_1_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0_4_0_0_1_0_0_0, EDAPUC_2_0_0_4_0_0_1_0_0_1, EDAPUC_2_0_0_4_0_0_1_0_0_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_2_0_0_4_0_0_1_0_1_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("poll", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_2_0_0_4_0_0_1_0_1_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_2_0_0_4_0_0_1_0_1_2 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCApplication().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__POLL), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_2_0_0_4_0_0_1_0_1 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0_4_0_0_1_0_1_0, EDAPUC_2_0_0_4_0_0_1_0_1_1, EDAPUC_2_0_0_4_0_0_1_0_1_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_2_0_0_4_0_0_1_0_2_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("global", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_2_0_0_4_0_0_1_0_2_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_2_0_0_4_0_0_1_0_2_2 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCApplication().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__GLOBAL), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_2_0_0_4_0_0_1_0_2 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0_4_0_0_1_0_2_0, EDAPUC_2_0_0_4_0_0_1_0_2_1, EDAPUC_2_0_0_4_0_0_1_0_2_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_2_0_0_4_0_0_1_0_3_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("headers", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_2_0_0_4_0_0_1_0_3_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_2_0_0_4_0_0_1_0_3_2 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCApplication().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__HEADERS), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_2_0_0_4_0_0_1_0_3 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0_4_0_0_1_0_3_0, EDAPUC_2_0_0_4_0_0_1_0_3_1, EDAPUC_2_0_0_4_0_0_1_0_3_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_2_0_0_4_0_0_1_0_4_0 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCApplication().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__PROPERTIES), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_2_0_0_4_0_0_1_0_4 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0_4_0_0_1_0_4_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_2_0_0_4_0_0_1_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0_4_0_0_1_0_0, EDAPUC_2_0_0_4_0_0_1_0_1, EDAPUC_2_0_0_4_0_0_1_0_2, EDAPUC_2_0_0_4_0_0_1_0_3, EDAPUC_2_0_0_4_0_0_1_0_4);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_2_0_0_4_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_2_0_0_4_0_0_1_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_2_0_0_4_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0_4_0_0_0, EDAPUC_2_0_0_4_0_0_1);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_2_0_0_4_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0_4_0_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_2_0_0_4 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_2_0_0_4_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.STAR);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_2_0_0_5 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("}", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_2_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0_0, EDAPUC_2_0_0_1, EDAPUC_2_0_0_2, EDAPUC_2_0_0_3, EDAPUC_2_0_0_4, EDAPUC_2_0_0_5);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_2_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_2_0_0);
	public final static Rule EDAPUC_2 = new Rule(edapuC.EdapuCPackage.eINSTANCE.getUCApplication(), EDAPUC_2_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_3_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("message", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_3_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCPlaceholder EDAPUC_3_0_0_2 = new edapuC.resource.edapuC.grammar.EdapuCPlaceholder(edapuC.EdapuCPackage.eINSTANCE.getUCMessage().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__MESSAGE), "TEXT", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_3_0_0_3 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("{", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCLineBreak EDAPUC_3_0_0_4_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCLineBreak(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_3_0_0_4_0_0_1_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCMessage().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__PROPERTIES), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_3_0_0_4_0_0_1_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_3_0_0_4_0_0_1_0_0_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_3_0_0_4_0_0_1_0_1_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("send", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_3_0_0_4_0_0_1_0_1_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCContainment EDAPUC_3_0_0_4_0_0_1_0_1_2 = new edapuC.resource.edapuC.grammar.EdapuCContainment(edapuC.EdapuCPackage.eINSTANCE.getUCMessage().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__SEND), edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_3_0_0_4_0_0_1_0_1 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_3_0_0_4_0_0_1_0_1_0, EDAPUC_3_0_0_4_0_0_1_0_1_1, EDAPUC_3_0_0_4_0_0_1_0_1_2);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_3_0_0_4_0_0_1_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_3_0_0_4_0_0_1_0_0, EDAPUC_3_0_0_4_0_0_1_0_1);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_3_0_0_4_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_3_0_0_4_0_0_1_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_3_0_0_4_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_3_0_0_4_0_0_0, EDAPUC_3_0_0_4_0_0_1);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_3_0_0_4_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_3_0_0_4_0_0);
	public final static edapuC.resource.edapuC.grammar.EdapuCCompound EDAPUC_3_0_0_4 = new edapuC.resource.edapuC.grammar.EdapuCCompound(EDAPUC_3_0_0_4_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.STAR);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_3_0_0_5 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("}", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_3_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_3_0_0_0, EDAPUC_3_0_0_1, EDAPUC_3_0_0_2, EDAPUC_3_0_0_3, EDAPUC_3_0_0_4, EDAPUC_3_0_0_5);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_3_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_3_0_0);
	public final static Rule EDAPUC_3 = new Rule(edapuC.EdapuCPackage.eINSTANCE.getUCMessage(), EDAPUC_3_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCPlaceholder EDAPUC_4_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCPlaceholder(edapuC.EdapuCPackage.eINSTANCE.getTemplate().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__GENERATOR), "GENERATOR", edapuC.resource.edapuC.grammar.EdapuCCardinality.QUESTIONMARK, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCPlaceholder EDAPUC_4_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCPlaceholder(edapuC.EdapuCPackage.eINSTANCE.getTemplate().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__TEXT), "TEMPLATE", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_4_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_4_0_0_0, EDAPUC_4_0_0_1);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_4_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_4_0_0);
	public final static Rule EDAPUC_4 = new Rule(edapuC.EdapuCPackage.eINSTANCE.getTemplate(), EDAPUC_4_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_5_0_0_0 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("property", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_5_0_0_1 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCPlaceholder EDAPUC_5_0_0_2 = new edapuC.resource.edapuC.grammar.EdapuCPlaceholder(edapuC.EdapuCPackage.eINSTANCE.getStaticProperty().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__NAME), "TEXT", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_5_0_0_3 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCKeyword EDAPUC_5_0_0_4 = new edapuC.resource.edapuC.grammar.EdapuCKeyword("=", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCWhiteSpace EDAPUC_5_0_0_5 = new edapuC.resource.edapuC.grammar.EdapuCWhiteSpace(1, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
	public final static edapuC.resource.edapuC.grammar.EdapuCPlaceholder EDAPUC_5_0_0_6 = new edapuC.resource.edapuC.grammar.EdapuCPlaceholder(edapuC.EdapuCPackage.eINSTANCE.getStaticProperty().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__VALUE), "STRING_LITERAL", edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, 0);
	public final static edapuC.resource.edapuC.grammar.EdapuCSequence EDAPUC_5_0_0 = new edapuC.resource.edapuC.grammar.EdapuCSequence(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_5_0_0_0, EDAPUC_5_0_0_1, EDAPUC_5_0_0_2, EDAPUC_5_0_0_3, EDAPUC_5_0_0_4, EDAPUC_5_0_0_5, EDAPUC_5_0_0_6);
	public final static edapuC.resource.edapuC.grammar.EdapuCChoice EDAPUC_5_0 = new edapuC.resource.edapuC.grammar.EdapuCChoice(edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE, EDAPUC_5_0_0);
	public final static Rule EDAPUC_5 = new Rule(edapuC.EdapuCPackage.eINSTANCE.getStaticProperty(), EDAPUC_5_0, edapuC.resource.edapuC.grammar.EdapuCCardinality.ONE);
}
