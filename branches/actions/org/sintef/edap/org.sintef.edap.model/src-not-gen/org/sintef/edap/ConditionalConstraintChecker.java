package org.sintef.edap;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import edap.AndExpression;
import edap.ConditionalAction;
import edap.ControlStructure;
import edap.EqualsExpression;
import edap.Expression;
import edap.ExternExpression;
import edap.NotExpression;
import edap.OrExpression;
import edap.Transition;
import edap.Type;

public class ConditionalConstraintChecker extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		
		// In the case of batch mode.
		// If our constraint provider extension is written correctly, 
		// we should never be called to perform a live validation.
		if (eType == EMFEventType.NULL) {
			
			if (eObj != null && eObj instanceof Expression) {
				Expression exp = (Expression)eObj;
				Type ct = EDAPHelpers.getExpressionType(exp);
				
				if (exp.eContainer() instanceof AndExpression || 
						exp.eContainer() instanceof OrExpression || 
						exp.eContainer() instanceof NotExpression ||
						exp.eContainer() instanceof ControlStructure ||
						exp.eContainer() instanceof Transition) {
					
					if (exp instanceof ExternExpression )
						return ctx.createSuccessStatus();
					
					
					if (ct != TypeChecker.BOOLEAN_TYPE) {
						return ctx.createFailureStatus(new Object[] {"Expecting Boolean, found " + ct.getName()});
					}
				}

				
			}
		}
		
		return ctx.createSuccessStatus();
	}

}
