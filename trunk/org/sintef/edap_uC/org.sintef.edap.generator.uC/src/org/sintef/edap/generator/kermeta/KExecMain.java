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
package org.sintef.edap.generator.kermeta;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.kermeta.interpreter.api.Interpreter;
import org.kermeta.interpreter.api.InterpreterMode;
import org.osgi.framework.Bundle;

import fr.irisa.triskell.eclipse.console.IOConsole;
import fr.irisa.triskell.eclipse.console.messages.ConsoleMessage;
import fr.irisa.triskell.eclipse.plugin.Activator;
import fr.irisa.triskell.kermeta.exceptions.NotRegisteredURIException;
import fr.irisa.triskell.kermeta.exceptions.URIMalformedException;
import fr.irisa.triskell.kermeta.runtime.RuntimeObject;

public class KExecMain {
	public static final String DIVA_KERMETA_CODE = "platform:/plugin/org.sintef.edap.generator.UC/kermeta/AVRGenerator.kmt";
	
	
	public static String run(String kmt, String cls,  String op, String fileURI, String path, IOConsole console) throws NotRegisteredURIException, IOException, URIMalformedException  {

		Interpreter interpreter = new Interpreter(kmt, InterpreterMode.RUN, null);
	    interpreter.setStreams(console);		
	    interpreter.setEntryPoint(cls, op);
		String[] parameters = new String[2];
		parameters[0] = fileURI;
		parameters[1] = path;
		interpreter.setParameters(parameters);
		// And we launch the interpreter
		
		// Add some URL to the classloader of the interpreter : needed if your code use some extra java classes (via extern for example)
		// use a set for building the URL (in case some may fail due to malformed URL
		// Note : URL must end with a / if this is a directory, if not, this is considered as a jar by the classloader
		//Set<URL> urlsSet = new LinkedHashSet<URL>();
		// URL used when run in a runtimeworkbench, this allows to debug the plugin
		// safeAddURLAsString(urlsSet, "file://" + Platform.resolve(Platform.getPlugin("diva.model").getDescriptor().getInstallURL()).getFile() + "bin/");
		// add this plugin as a deployed plugin
		/*
		Bundle bundle = org.eclipse.core.runtime.Platform.getBundle("diva.model");
		if(bundle != null){
			urlsSet.add(FileLocator.resolve(bundle.getEntry("/")));
			
			// for the runtime workbench
			try { 
			urlsSet.add(FileLocator.resolve(bundle.getEntry("/bin"))); 
			} catch(NullPointerException e) {}
			urlsSet.add(FileLocator.resolve(bundle.getEntry("/lib/alloy4.jar")));

		}
		
		bundle = org.eclipse.core.runtime.Platform.getBundle("fr.univartois.cril.alloyplugin.launch");
		if(bundle != null){
			urlsSet.add(FileLocator.resolve(bundle.getEntry("/alloy4.jar")));
		}
		
	
		
		// convert the set into an array
		URL[] urls = new URL[urlsSet.size()];
		int i = 0;
		for (URL url : urlsSet) {
			urls[i] = url;
			i++;
		}
		URLClassLoader cl = new URLClassLoader(urls, interpreter.getClass().getClassLoader());
		Thread.currentThread().setContextClassLoader(cl);
		*/
		RuntimeObject o = interpreter.launch();
		if (o != null) return fr.irisa.triskell.kermeta.runtime.basetypes.String.getValue(o);
		return null;

	}
	
	/**
	 * add a new URL to the set
	 * Doesn't fail if the URL is malformed, in that case, only a warning is raised, 
	 * @param urlsSet : set that will contain the URL built
	 * @param url : String of the URL to build
	 */
	private static void safeAddURLAsString(Set<URL> urlsSet, String url){
		try{
			urlsSet.add(new URL(url));
		} catch (MalformedURLException e) {
			Activator.logWarningMessage(
					"problem adding an entry of the classpath, "
					+ url + " cannot be added in classloader", e);
		}
	}

}
