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
package org.sintef.thingml.protocol.generator;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import fr.irisa.triskell.eclipse.console.EclipseConsole;
import fr.irisa.triskell.eclipse.console.IOConsole;
import fr.irisa.triskell.eclipse.console.messages.ErrorMessage;
import fr.irisa.triskell.eclipse.console.messages.InfoMessage;
import fr.irisa.triskell.eclipse.console.messages.OKMessage;
import fr.irisa.triskell.eclipse.console.messages.ThrowableMessage;

public class GenerateScala implements IObjectActionDelegate {

	private Shell shell;
	protected StructuredSelection currentSelection;
    protected IFile file;
	
	/**
	 * Constructor for Action1.
	 */
	public GenerateScala() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		IOConsole console = new EclipseConsole("ThingML");
		console.println(new InfoMessage("Launching ThingML Scala Protocol Generator on : " + file.getLocation().toOSString() + "..."));
		
		try {			
			ResourceSet rs = new ResourceSetImpl();
			URI xmiuri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource artres = rs.getResource(xmiuri, true);
			artres.load(null);
			EcoreUtil.resolveAll(artres);
			
			URI new_uri = artres.getURI().trimFileExtension().appendFileExtension("xmi");
			Resource xmires = rs.createResource(new_uri);
			xmires.getContents().addAll(artres.getContents());
			xmires.save(null);
			
			String kmt = "platform:/plugin/org.sintef.thingML.protocol.generator/kermeta/mainScala.kmt";
			
			//String file_uri = "file:/" + file.getLocation().toOSString();
			file.getLocation().removeFileExtension().addFileExtension("xmi").toString();
			String file_uri = "file:/" + file.getLocation().removeFileExtension().addFileExtension("xmi").toString();
			String path = "file://" + file.getParent().getLocation().append("/java/").toOSString();
			
			KExecMain.run(kmt, "thingML::MainJavaProtocolGenerator", "mainJava", file_uri, path, console);
		    
			//KExecMain.run(kmt, "edap_devices::Main", "generateDevices", file_uri, path, console);
			
			console.println(new OKMessage("Execution terminated successfully."));
			file.getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
			
		} catch (Throwable e) {
			console.println(new ErrorMessage("Runtime error : "));
			console.println(new ThrowableMessage(e));
			e.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection)
		{
			currentSelection = (StructuredSelection)selection;
			Iterator it = currentSelection.iterator();

			while(it.hasNext()) {
				file = (IFile)it.next();
			}
		}

	}
	
	public static void main(String[] args) {
		
	}

}
