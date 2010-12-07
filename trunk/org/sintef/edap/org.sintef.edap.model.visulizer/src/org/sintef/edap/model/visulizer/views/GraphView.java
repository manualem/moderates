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
package org.sintef.edap.model.visulizer.views;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IConnectionStyleBezierExtension;
import org.eclipse.zest.core.viewers.IGraphContentProvider;
import org.eclipse.zest.core.viewers.ISelfStyleProvider;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.HorizontalTreeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.SpringLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;
import org.eclipse.zest.layouts.algorithms.VerticalLayoutAlgorithm;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.util.EList;

//import edap.Action;
import edap.ActionBlock;
import edap.ComponentReference;
import edap.CompositeState;
import edap.EdapElement;
import edap.ExternExpression;
import edap.Message;
import edap.ReceiveMessage;
import edap.SendAction;
import edap.State;
import edap.StateMachine;
import edap.Transition;






public class GraphView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.sintef.edap.model.visulizer.views.GraphView";

	private static GraphViewer viewer;
	//private DrillDownAdapter drillDownAdapter;
	private Action navigateBackAction;
//	private Action changeCurveAction;
	private Action changeLayoytAction;
	private Action doubleClickAction;
	private static Object input;





	class NameSorter extends ViewerSorter {
	}
	
    public static class MyContentProvider implements IGraphContentProvider{
		
		
		private StateMachine stateMachine = null;
		private CompositeState compositeState = null;
	
		
		public Object getDestination(Object rel) {
			Transition t = (Transition)rel;
			return t.getTarget();
			
		}

		public Object[] getElements(Object input) {
			if(input instanceof StateMachine){
				stateMachine  = (StateMachine)input;
				
				EList <State> states = stateMachine.getSubstate();
				ArrayList <Transition> transnitions = new ArrayList<Transition>(); 
				for (State state : states) {
					transnitions.addAll(state.getOutgoing());
				}
				return transnitions.toArray();
			}
			else if (input instanceof CompositeState){
				CompositeState compositeState = (CompositeState) input;
				EList <State> states = compositeState.getSubstate();
				ArrayList <Transition> transnitions = new ArrayList<Transition>(); 
				for (State state: states) {
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

		private static Hashtable<String, Integer> cMap = new Hashtable<String, Integer>();
		
		public static void clearMap(){
			cMap.clear();
		}
		
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
			
			int selfCurve = 25;
			int normalCurve = 30;
			int addOn = 25;
			int curve = 0;
			
			if(element instanceof Transition){
				Transition t = (Transition) element;
				State source = t.getSource();
				State target = t.getTarget();
				
				String sName = source.getName();
				String tName = target.getName();
				String key = sName + tName;
				
				if(cMap.containsKey(key)){
					curve = cMap.get(key) + addOn;
					cMap.remove(key);
					cMap.put(key, curve);
				}
				else{
					curve = normalCurve;
					cMap.put(key, curve);
				}
				
				//String action = t.getAction().toString();
				String guard = "None";
				if(t.getGuard() != null)
					guard = ((ExternExpression) t.getGuard()).getExpression();
				String eventName = ((ReceiveMessage) t.getEvent()).getMessage().getName();
				String send = "";
				if(t.getAction() != null){
					edap.Action a = t.getAction();
					
					 send = "Send -> "; 
					if(a instanceof ActionBlock){
						ActionBlock aB = (ActionBlock)a;
						EList<edap.Action> aList = aB.getActions();
						for (Iterator iterator = aList.iterator(); iterator.hasNext();) {
							edap.Action myAction = (edap.Action) iterator.next();
							if(myAction instanceof SendAction){
								send.concat(((SendAction) myAction).getMessage().getName());
							}
							
						}
					}
					else if(a instanceof SendAction){
						SendAction sA = (SendAction)a; 
						Message m = sA.getMessage();
						String mName = m.getName();
						ComponentReference cF = (ComponentReference) sA.getTarget();
						String toName = cF.getComponent().getName();
						
						String temp = send + mName + "() to "+toName;
						send = temp;
						
					}
				}
				Label label = new Label();
				label.setText("Transition: "+t.getName()+"\n Event: "+ eventName+"\n Guard: "+guard+"\n Action: "+send);//+action);
			
				
				
				if(connection.getDestination() == connection.getSource()){
					connection.setCurveDepth(curve + 20);
				}
				
				else{
					connection.setCurveDepth(curve);
					connection.setWeight(1);
				}	
				connection.setTooltip(label);
			}
			
		}

		@Override
		public void selfStyleNode(Object element, GraphNode node) {
			Color c = ColorConstants.blue;
			
			if(element instanceof CompositeState){
				CompositeState cS = (CompositeState)element;
				//cS.getEntry()
				c = ColorConstants.lightGray;
				node.setTooltip(new Label("CompositeState: Double Click to view containment"));
				node.setForegroundColor(ColorConstants.black);
			}
			else if (element instanceof State){
				c = ColorConstants.darkGray;
				node.setForegroundColor(ColorConstants.white);
			}	
			node.setBackgroundColor(c);
			node.setSize(70.0, 50.0);
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
	 * The constructor.
	 */
	public GraphView() {
	}

	
	public static void updateViewer(Object inputObj){
		input = inputObj;
		MyLabelProvider.clearMap();
		viewer.setInput(input);
		viewer.refresh();
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		viewer = new GraphViewer(parent, SWT.NONE);
		viewer.setContentProvider(new MyContentProvider());
		viewer.setLabelProvider(new MyLabelProvider());
		//viewer.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
		//viewer.setLayoutAlgorithm(new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
		viewer.setLayoutAlgorithm(new VerticalLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING), true);
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
		hookContextMenu();
		hookDoubleClickAction();
		makeActions();
		contributeToActionBars();

		
		//viewer.setInput(input);
	}
		

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				GraphView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(navigateBackAction);
		manager.add(new Separator());
		manager.add(changeLayoytAction);
		manager.add(new Separator());
//		manager.add(changeCurveAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(navigateBackAction);
		manager.add(changeLayoytAction);
	//	manager.add(changeCurveAction);
		manager.add(new Separator());
	//	drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(navigateBackAction);
		manager.add(changeLayoytAction);
	//	manager.add(changeCurveAction);
		manager.add(new Separator());
//		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		navigateBackAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj instanceof State){
					State s = (State)obj;
					if(s.eContainer() instanceof StateMachine){
						showMessage("Outermost state already in display");
					}
					else{
						updateViewer(s.eContainer().eContainer());
					}
				}
			}
		};
		navigateBackAction.setText("Back to Parent");
		navigateBackAction.setToolTipText("Navigate Back to Parent");
		navigateBackAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_TOOL_BACK));
		
	
		changeLayoytAction = new Action() {
			public void run() {
				LayoutAlgorithm la = viewer.getGraphControl().getLayoutAlgorithm();
				if(la instanceof VerticalLayoutAlgorithm){
					viewer.setLayoutAlgorithm(new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
				}
				else if (la instanceof SpringLayoutAlgorithm){
					viewer.setLayoutAlgorithm(new VerticalLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING));
				}
				viewer.applyLayout();
				viewer.getGraphControl().applyLayout();
			}
		};
		changeLayoytAction.setText("Change Layout");
		changeLayoytAction.setToolTipText("Change Layout");
		changeLayoytAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		
	/*
		changeCurveAction = new Action(){
			public void run(){
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj instanceof Transition){
					Transition t = (Transition)obj;
					GraphConnection graphC = (GraphConnection) viewer.findGraphItem(t);
					graphC.setCurveDepth(130);
					graphC.setWeight(0.5);
					
					viewer.getGraphControl().update();

				}
			}
		};
		changeCurveAction.setText("Change Layout on Selected Transition");
		changeCurveAction.setToolTipText("Change the layout of overlapping transition");
		changeCurveAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_DEC_FIELD_WARNING));
	*/
		
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				if(obj instanceof CompositeState){
					updateViewer(obj);
				}
				else if (obj instanceof State){
					State s = (State)obj;
					showMessage(s.getName()+" is not a CompositeState that can be Navigated into");
				}
			}
		};
		doubleClickAction.setToolTipText("Navigate into");
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Graph View",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}
