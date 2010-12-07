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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IGraphContentProvider;
import org.eclipse.zest.core.viewers.ISelfStyleProvider;
import org.eclipse.zest.core.viewers.IConnectionStyleBezierExtension;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutBendPoint;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import edap.CompositeState;
import edap.EdapElement;
import edap.SoftwareComponent;
import edap.State;
import edap.StateMachine;
import edap.Transition;



public class ApplicationVisulizer {
	
	private GraphViewer viewer = null;
    private Shell shell = null;

	public ApplicationVisulizer() {
		// TODO Auto-generated constructor stub
	}

	static class MyContentProvider implements IGraphContentProvider{
		
		
		private StateMachine application = null;
		private CompositeState compositeState = null;
		//private StateMachine stateMachine = null;
	
		
		public Object getDestination(Object rel) {
			Transition t = (Transition)rel;
			return t.getTarget();
			
		}

		public Object[] getElements(Object input) {
			if(input instanceof StateMachine){
				StateMachine a = (StateMachine)input;
				application = a;
				
				EList <State> states = a.getSubstate();
				ArrayList <Transition> transnitions = new ArrayList<Transition>(); 
				for (Object element : states) {
					State state = (State) element;
					transnitions.addAll(state.getOutgoing());
				}
				return transnitions.toArray();
			}
			else if (input instanceof CompositeState){
				CompositeState cS = (CompositeState) input;
				EList <State> states = cS.getSubstate();
				ArrayList <Transition> transnitions = new ArrayList<Transition>(); 
				for (Object element : states) {
					State state = (State) element;
					transnitions.addAll(state.getOutgoing());
				}
				return transnitions.toArray();
			}
			return null;
		}

		public Object getSource(Object rel) {
			Transition t = (Transition)rel;
			return t.eContainer();
			
		}

		public double getWeight(Object connection) {
			return 0;
		}

		public void dispose() {
		
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
		}

		

	}

	static class MyLabelProvider extends LabelProvider implements ISelfStyleProvider, IConnectionStyleBezierExtension {
		final Image image = Display.getDefault().getSystemImage(SWT.ICON_SEARCH);

		public Image getImage(Object element) {
			if (element instanceof State) {
				return image;
			}
			return null;
		}

		public String getText(Object element) {
			if(element instanceof EdapElement){
				return ((EdapElement)element).getName();
			}
			else{
				return "Error";
			}
		}
		@Override
		public void selfStyleConnection(Object element,GraphConnection connection) {
			if(connection.getDestination() == connection.getSource()){
				connection.setCurveDepth(70);
				//connection.g
				//connection.setLineStyle(ZestStyles.)
			}
			
		}

		@Override
		public void selfStyleNode(Object element, GraphNode node) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public double getEndAngle(Object rel) {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public double getEndDistance(Object rel) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getStartAngle(Object rel) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getStartDistance(Object rel) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	

	/**
	 * @param app
	 */
	public void createApplicationGraph(SoftwareComponent app) {
		Display d = Display.getCurrent();
		shell = new Shell(d);
		shell.setText("Application Visulizer for "+app.getName());
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		shell.setSize(400, 400);
		createViewer(app);
		shell.open();
		while (!shell.isDisposed()) {
			while (!d.readAndDispatch()) {
				d.sleep();
			}
		}

	}
	public void createApplicationGraph(CompositeState cS) {
		Display d = Display.getCurrent();
		shell = new Shell(d);
		shell.setText("CompositeState Visulizer for "+cS.getName());
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		shell.setSize(400, 400);
		createViewer(cS);
		shell.open();
		while (!shell.isDisposed()) {
			while (!d.readAndDispatch()) {
				d.sleep();
			}
		}
	}
	public void createViewer(Object input){
		viewer = new GraphViewer(shell, SWT.NONE);
		viewer.setContentProvider(new MyContentProvider());
		viewer.setLabelProvider(new MyLabelProvider());
		viewer.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				System.out.println("Selection Changed: " + selectionToString((StructuredSelection) event.getSelection()));
			}

			private String selectionToString(StructuredSelection selection) {
				StringBuffer stringBuffer = new StringBuffer();
				Iterator iterator = selection.iterator();
				boolean first = true;
				while (iterator.hasNext()) {
					if (first) {
						first = false;
					} else {
						stringBuffer.append(" : ");
					}
					stringBuffer.append(iterator.next());
				}
				return stringBuffer.toString();
			}

		});

		
		viewer.setInput(input);
	}
}


