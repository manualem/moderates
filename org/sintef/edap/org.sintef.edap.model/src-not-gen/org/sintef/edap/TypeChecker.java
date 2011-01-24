package org.sintef.edap;

import java.util.Hashtable;

import edap.AndExpression;
import edap.BooleanLitteral;
import edap.DictionaryNavigation;
import edap.DivExpression;
import edap.DoubleLitteral;
import edap.EqualsExpression;
import edap.Expression;
import edap.ExpressionGroup;
import edap.ExternExpression;
import edap.GreaterExpression;
import edap.IntegerLitteral;
import edap.LowerExpression;
import edap.MinusExpression;
import edap.ModExpression;
import edap.NotExpression;
import edap.OrExpression;
import edap.PlusExpression;
import edap.PropertyNavigation;
import edap.PropertyReference;
import edap.StringLitteral;
import edap.TimesExpression;
import edap.Type;
import edap.UnaryMinus;
import edap.util.EdapSwitch;

public class TypeChecker extends EdapSwitch<Type> {
	
	public static Type ANY_TYPE;
	public static Type INTEGER_TYPE;
	public static Type BOOLEAN_TYPE;
	public static Type STRING_TYPE;
	public static Type REAL_TYPE;
	
	public Hashtable<Expression, String> errors;
	
	
	public Type computeTypeOf(Expression exp) {
		Type result = null;
		try {
			result = doSwitch(exp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Type caseExternExpression(ExternExpression object) {
		return ANY_TYPE;
	}

	@Override
	public Type casePropertyNavigation(PropertyNavigation object) {
		return object.getProperty().getType();
	}

	@Override
	public Type caseDictionaryNavigation(DictionaryNavigation object) {
		// TODO: Check the type of the key
		return object.getProperty().getType();
	}

	@Override
	public Type caseIntegerLitteral(IntegerLitteral object) {
		return INTEGER_TYPE;
	}

	@Override
	public Type caseBooleanLitteral(BooleanLitteral object) {
		return BOOLEAN_TYPE;
	}

	@Override
	public Type caseStringLitteral(StringLitteral object) {
		return STRING_TYPE;
	}

	@Override
	public Type caseDoubleLitteral(DoubleLitteral object) {
		return REAL_TYPE;
	}

	@Override
	public Type caseNotExpression(NotExpression object) {
		Type t = computeTypeOf(object.getTerm());
		if (!t.equals(BOOLEAN_TYPE)) {
			errors.put(object.getTerm(), "Expected Boolean, found " + t.getName() + ".");
		}
		return BOOLEAN_TYPE;
	}

	@Override
	public Type caseUnaryMinus(UnaryMinus object) {
		Type t = computeTypeOf(object.getTerm());
		if (!t.equals(INTEGER_TYPE)) {
			errors.put(object.getTerm(), "Expected Integer, found " + t.getName() + ".");
		}
		return INTEGER_TYPE;
	}

	@Override
	public Type casePlusExpression(PlusExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		if (!t1.equals(INTEGER_TYPE)) {
			errors.put(object.getLhs(), "Expected Integer, found " + t1.getName() + ".");
		}
		if (!t2.equals(INTEGER_TYPE)) {
			errors.put(object.getRhs(), "Expected Integer, found " + t2.getName() + ".");
		}
		return INTEGER_TYPE;
	}

	@Override
	public Type caseMinusExpression(MinusExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		if (!t1.equals(INTEGER_TYPE)) {
			errors.put(object.getLhs(), "Expected Integer, found " + t1.getName() + ".");
		}
		if (!t2.equals(INTEGER_TYPE)) {
			errors.put(object.getRhs(), "Expected Integer, found " + t2.getName() + ".");
		}
		return INTEGER_TYPE;
	}

	@Override
	public Type caseTimesExpression(TimesExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		if (!t1.equals(INTEGER_TYPE)) {
			errors.put(object.getLhs(), "Expected Integer, found " + t1.getName() + ".");
		}
		if (!t2.equals(INTEGER_TYPE)) {
			errors.put(object.getRhs(), "Expected Integer, found " + t2.getName() + ".");
		}
		return INTEGER_TYPE;
	}

	@Override
	public Type caseDivExpression(DivExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		if (!t1.equals(INTEGER_TYPE)) {
			errors.put(object.getLhs(), "Expected Integer, found " + t1.getName() + ".");
		}
		if (!t2.equals(INTEGER_TYPE)) {
			errors.put(object.getRhs(), "Expected Integer, found " + t2.getName() + ".");
		}
		return INTEGER_TYPE;
	}

	@Override
	public Type caseModExpression(ModExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		if (!t1.equals(INTEGER_TYPE)) {
			errors.put(object.getLhs(), "Expected Integer, found " + t1.getName() + ".");
		}
		if (!t2.equals(INTEGER_TYPE)) {
			errors.put(object.getRhs(), "Expected Integer, found " + t2.getName() + ".");
		}
		return INTEGER_TYPE;
	}

	@Override
	public Type caseEqualsExpression(EqualsExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		// TODO: Check that the types are compatible
		return BOOLEAN_TYPE;
	}

	@Override
	public Type caseGreaterExpression(GreaterExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		if (!t1.equals(INTEGER_TYPE)) {
			errors.put(object.getLhs(), "Expected Integer, found " + t1.getName() + ".");
		}
		if (!t2.equals(INTEGER_TYPE)) {
			errors.put(object.getRhs(), "Expected Integer, found " + t2.getName() + ".");
		}
		return BOOLEAN_TYPE;
	}

	@Override
	public Type caseAndExpression(AndExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		if (!t1.equals(BOOLEAN_TYPE)) {
			errors.put(object.getLhs(), "Expected Integer, found " + t1.getName() + ".");
		}
		if (!t2.equals(BOOLEAN_TYPE)) {
			errors.put(object.getRhs(), "Expected Integer, found " + t2.getName() + ".");
		}
		return BOOLEAN_TYPE;
	}

	@Override
	public Type caseOrExpression(OrExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		if (!t1.equals(BOOLEAN_TYPE)) {
			errors.put(object.getLhs(), "Expected Integer, found " + t1.getName() + ".");
		}
		if (!t2.equals(BOOLEAN_TYPE)) {
			errors.put(object.getRhs(), "Expected Integer, found " + t2.getName() + ".");
		}
		return BOOLEAN_TYPE;
	}

	@Override
	public Type casePropertyReference(PropertyReference object) {
		return object.getProperty().getType();
	}

	@Override
	public Type caseExpressionGroup(ExpressionGroup object) {
		return computeTypeOf(object.getExp());
	}

	@Override
	public Type caseLowerExpression(LowerExpression object) {
		Type t1 = computeTypeOf(object.getLhs());
		Type t2 = computeTypeOf(object.getRhs());
		if (!t1.equals(INTEGER_TYPE)) {
			errors.put(object.getLhs(), "Expected Integer, found " + t1.getName() + ".");
		}
		if (!t2.equals(INTEGER_TYPE)) {
			errors.put(object.getRhs(), "Expected Integer, found " + t2.getName() + ".");
		}
		return BOOLEAN_TYPE;
	}
	
	

}
