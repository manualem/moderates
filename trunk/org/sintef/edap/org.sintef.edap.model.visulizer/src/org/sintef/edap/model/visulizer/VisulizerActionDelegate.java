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
package org.sintef.edap.model.visulizer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.sintef.edap.model.visulizer.views.GraphView;

import edap.CompositeState;
import edap.EdapElement;
import edap.SoftwareComponent;
import edap.StateMachine;




public class VisulizerActionDelegate implements IActionDelegate {
	
	private EdapElement selectedEdapElement= null;
	
	public VisulizerActionDelegate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run(IAction action) {
		if(action.getId().equalsIgnoreCase("org.sintef.edap.model.visulizer.external")){
			ApplicationVisulizer appViz = new ApplicationVisulizer();
			if(selectedEdapElement instanceof SoftwareComponent)
				appViz.createApplicationGraph((SoftwareComponent)selectedEdapElement);
			else if (selectedEdapElement instanceof CompositeState)
				appViz.createApplicationGraph((CompositeState)selectedEdapElement);
		}
		else if (action.getId().equalsIgnoreCase("org.sintef.edap.model.visulizer.doState")){
			System.out.println("Testing");
			
		}
		else if (action.getId().equalsIgnoreCase("org.sintef.edap.model.visulizer.inView")){
			GraphView.updateViewer(selectedEdapElement);
		}
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		IStructuredSelection sel = (StructuredSelection)selection;	
		selectedEdapElement= (EdapElement)sel.getFirstElement();
	}

}
