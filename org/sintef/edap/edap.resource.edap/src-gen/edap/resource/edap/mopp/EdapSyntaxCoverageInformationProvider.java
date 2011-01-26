/**
 * <copyright>
 * </copyright>
 *
 * 
 */
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
			edap.EdapPackage.eINSTANCE.getPropertyAssignment(),
			edap.EdapPackage.eINSTANCE.getComponentReference(),
			edap.EdapPackage.eINSTANCE.getEventReference(),
			edap.EdapPackage.eINSTANCE.getUnicast(),
			edap.EdapPackage.eINSTANCE.getBroadcast(),
			edap.EdapPackage.eINSTANCE.getTransition(),
			edap.EdapPackage.eINSTANCE.getReceiveMessage(),
			edap.EdapPackage.eINSTANCE.getConnector(),
			edap.EdapPackage.eINSTANCE.getPort(),
			edap.EdapPackage.eINSTANCE.getCreateAction(),
			edap.EdapPackage.eINSTANCE.getActionBlock(),
			edap.EdapPackage.eINSTANCE.getExternStatement(),
			edap.EdapPackage.eINSTANCE.getConditionalAction(),
			edap.EdapPackage.eINSTANCE.getLoopAction(),
			edap.EdapPackage.eINSTANCE.getPrintAction(),
			edap.EdapPackage.eINSTANCE.getErrorAction(),
			edap.EdapPackage.eINSTANCE.getOrExpression(),
			edap.EdapPackage.eINSTANCE.getAndExpression(),
			edap.EdapPackage.eINSTANCE.getLowerExpression(),
			edap.EdapPackage.eINSTANCE.getGreaterExpression(),
			edap.EdapPackage.eINSTANCE.getEqualsExpression(),
			edap.EdapPackage.eINSTANCE.getPlusExpression(),
			edap.EdapPackage.eINSTANCE.getMinusExpression(),
			edap.EdapPackage.eINSTANCE.getTimesExpression(),
			edap.EdapPackage.eINSTANCE.getDivExpression(),
			edap.EdapPackage.eINSTANCE.getModExpression(),
			edap.EdapPackage.eINSTANCE.getUnaryMinus(),
			edap.EdapPackage.eINSTANCE.getNotExpression(),
			edap.EdapPackage.eINSTANCE.getExpressionGroup(),
			edap.EdapPackage.eINSTANCE.getPropertyReference(),
			edap.EdapPackage.eINSTANCE.getIntegerLitteral(),
			edap.EdapPackage.eINSTANCE.getStringLitteral(),
			edap.EdapPackage.eINSTANCE.getBooleanLitteral(),
			edap.EdapPackage.eINSTANCE.getExternExpression(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			edap.EdapPackage.eINSTANCE.getEdapModel(),
		};
	}
	
}
