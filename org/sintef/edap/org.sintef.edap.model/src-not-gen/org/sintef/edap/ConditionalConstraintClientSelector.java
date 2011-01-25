package org.sintef.edap;

import org.eclipse.emf.validation.model.IClientSelector;

import edap.ConditionalAction;

public class ConditionalConstraintClientSelector implements IClientSelector {

	@Override
	public boolean selects(Object object) {
		return (object instanceof ConditionalAction);
	}

}
