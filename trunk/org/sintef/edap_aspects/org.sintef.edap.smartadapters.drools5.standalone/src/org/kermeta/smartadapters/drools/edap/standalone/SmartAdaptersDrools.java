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
package org.kermeta.smartadapters.drools.edap.standalone;

import java.io.IOException;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.kermeta.smartadapters.drools.edap.utils.TreeIterable;

public class SmartAdaptersDrools {

	/**
	 * @param args
	 * arg[0] = URI to the base model
	 * arg[1] = URI to the woven model
	 * arg[i>1] = URI to an aspect (drl file)
	 */
	public static void main(String[] args){
		System.out.println("START");
		if(args.length == 3){
			String baseEDAP = args[0];
			String resultEDAP = args[1];
			String droolsScript = args[2];
			
			long time;

			SmartAdaptersDrools sad = new SmartAdaptersDrools();

			System.out.println("Loading base model...");
			time = System.currentTimeMillis();
			sad.loadEdapModel(baseEDAP);
			time = System.currentTimeMillis() - time;
			System.out.println("Done! ("+time+" ms)");
			System.out.println();


			System.out.println("Weaving...");
			time = System.currentTimeMillis();
			sad.process(droolsScript);
			time = System.currentTimeMillis() - time;
			System.out.println("Done! ("+time+" ms)");

			System.out.println();
			System.out.println("Saving woven model...");
			time = System.currentTimeMillis();
			sad.saveEdapModel(resultEDAP);
			time = System.currentTimeMillis() - time;
			System.out.println("Done! ("+time+" ms)");
		}
		System.out.println("STOP");
	}

	private org.eclipse.emf.ecore.resource.Resource resource;
	private KnowledgeBase kbase;

	public SmartAdaptersDrools(){
		kbase = KnowledgeBaseFactory.newKnowledgeBase();
	}

	void process(String drl){	
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		kbuilder.add(ResourceFactory.newFileResource(drl), ResourceType.DRL);

		if ( kbuilder.hasErrors() ) {
			java.lang.System.err.println( kbuilder.getErrors().toString() );
		}
		kbase.getKnowledgePackages().clear();
		kbase.addKnowledgePackages( kbuilder.getKnowledgePackages() );

		StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();		

		java.util.Map<String,EObject> uniqueobjects = new java.util.HashMap<String,EObject>();
		ksession.setGlobal("uniqueobjects", uniqueobjects);
		
		java.util.Map<java.util.Set<Object>, java.util.Map<String, Object>> perElem = new java.util.HashMap<java.util.Set<Object>, java.util.Map<String,Object>>();
		ksession.setGlobal("perElem", perElem);
		
		java.util.Map<java.util.Map<String, Object>, java.util.Map<String, Object>> perRole = new java.util.HashMap<java.util.Map<String, Object>, java.util.Map<String,Object>>();
		ksession.setGlobal("perRole", perRole);
		
		ksession.execute(new TreeIterable<EObject>(resource.getAllContents()));
	}

	edap.StateMachine loadEdapModel(String uri){
		ResourceSetImpl rs = new ResourceSetImpl(); 
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry f = rs.getResourceFactoryRegistry();

		java.util.Map<String,Object> m = f.getExtensionToFactoryMap();
		m.put("ecore",new EcoreResourceFactoryImpl());
		m.put("*",new XMIResourceFactoryImpl());
		
		rs.getPackageRegistry().put(edap.EdapPackage.eNS_URI, edap.EdapPackage.eINSTANCE);

		URI uri1  = URI.createURI(uri);//.replace("platform:/resource/",EcorePackages.workspaceURI).replace("platform:/plugin/",EcorePackages.pluginURI ));
		resource = rs.getResource(uri1,true);

		edap.StateMachine s = (edap.StateMachine) resource.getContents().get(0);
		return s;
	}

	void saveEdapModel(String uri){
		ResourceSetImpl rs = new ResourceSetImpl(); 
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry f = rs.getResourceFactoryRegistry();

		java.util.Map<String,Object> m = f.getExtensionToFactoryMap();
		m.put("ecore",new EcoreResourceFactoryImpl());
		m.put("*",new XMIResourceFactoryImpl());


		rs.getPackageRegistry().put(edap.EdapPackage.eNS_URI, edap.EdapPackage.eINSTANCE);

		URI uri1  = URI.createURI(uri);
		resource.setURI(uri1);

		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}}
