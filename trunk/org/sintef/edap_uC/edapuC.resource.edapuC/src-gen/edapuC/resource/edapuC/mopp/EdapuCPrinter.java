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
 
package edapuC.resource.edapuC.mopp;

public class EdapuCPrinter implements edapuC.resource.edapuC.IEdapuCTextPrinter {
	
	protected edapuC.resource.edapuC.IEdapuCTokenResolverFactory tokenResolverFactory = new edapuC.resource.edapuC.mopp.EdapuCTokenResolverFactory();
	protected java.io.OutputStream outputStream;
	/**
	 * Holds the resource that is associated with this printer. may be null if the
	 * printer is used stand alone.
	 */
	private edapuC.resource.edapuC.IEdapuCTextResource resource;
	private java.util.Map<?, ?> options;
	
	public EdapuCPrinter(java.io.OutputStream outputStream, edapuC.resource.edapuC.IEdapuCTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected static int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed){
		int pos = 0;
		int neg = 0;
		
		for(String featureName:featureCounter.keySet()){
			if(needed.contains(featureName)){
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof edapuC.UCGenerator) {
			print_edapuC_UCGenerator((edapuC.UCGenerator) element, globaltab, out);
			return;
		}
		if (element instanceof edapuC.UCDevice) {
			print_edapuC_UCDevice((edapuC.UCDevice) element, globaltab, out);
			return;
		}
		if (element instanceof edapuC.UCApplication) {
			print_edapuC_UCApplication((edapuC.UCApplication) element, globaltab, out);
			return;
		}
		if (element instanceof edapuC.UCMessage) {
			print_edapuC_UCMessage((edapuC.UCMessage) element, globaltab, out);
			return;
		}
		if (element instanceof edapuC.Template) {
			print_edapuC_Template((edapuC.Template) element, globaltab, out);
			return;
		}
		if (element instanceof edapuC.StaticProperty) {
			print_edapuC_StaticProperty((edapuC.StaticProperty) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected edapuC.resource.edapuC.mopp.EdapuCReferenceResolverSwitch getReferenceResolverSwitch() {
		return (edapuC.resource.edapuC.mopp.EdapuCReferenceResolverSwitch) new edapuC.resource.edapuC.mopp.EdapuCMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		edapuC.resource.edapuC.IEdapuCTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new edapuC.resource.edapuC.mopp.EdapuCProblem(errorMessage, edapuC.resource.edapuC.EdapuCEProblemType.ERROR), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public edapuC.resource.edapuC.IEdapuCTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_edapuC_UCGenerator(edapuC.UCGenerator element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__DEVICES));
		printCountingMap.put("devices", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__IMPORTS));
		printCountingMap.put("imports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__EDAP));
		printCountingMap.put("edap", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__APPLICATION));
		printCountingMap.put("application", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edapuC_UCGenerator_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edapuC_UCGenerator_1(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edapuC_UCGenerator_2(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
	}
	public void print_edapuC_UCGenerator_0(edapuC.UCGenerator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("import");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("imports");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__IMPORTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCGeneratorImportsReferenceResolver().deResolve((edapuC.UCGenerator) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__IMPORTS)), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__IMPORTS), element));
			}
			printCountingMap.put("imports", count - 1);
		}
	}
	public void print_edapuC_UCGenerator_1(edapuC.UCGenerator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("edap");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("edap");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__EDAP));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCGeneratorEdapReferenceResolver().deResolve((edap.EdapModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__EDAP)), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__EDAP), element));
			}
			printCountingMap.put("edap", count - 1);
		}
	}
	public void print_edapuC_UCGenerator_2(edapuC.UCGenerator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edapuC_UCGenerator_2_0(element, localtab, out, printCountingMap);
	}
	public void print_edapuC_UCGenerator_2_0(edapuC.UCGenerator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"devices"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"application"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("devices");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__DEVICES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("devices", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("application");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__APPLICATION));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("application", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("properties");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__PROPERTIES));
				java.util.List<?> list = (java.util.List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
				}
				printCountingMap.put("properties", count - 1);
			}
		}
	}
	
	public void print_edapuC_UCDevice(edapuC.UCDevice element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__MESSAGES));
		printCountingMap.put("messages", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__DEVICE));
		printCountingMap.put("device", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__INIT));
		printCountingMap.put("init", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__POLL));
		printCountingMap.put("poll", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__GLOBAL));
		printCountingMap.put("global", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("device");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("device");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__DEVICE));
			if (o != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCDeviceDeviceReferenceResolver().deResolve((edap.Component) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__DEVICE)), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__DEVICE), element));
			}
			printCountingMap.put("device", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edapuC_UCDevice_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	public void print_edapuC_UCDevice_0(edapuC.UCDevice element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edapuC_UCDevice_0_0(element, localtab, out, printCountingMap);
	}
	public void print_edapuC_UCDevice_0_0(edapuC.UCDevice element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"init"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"poll"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"global"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"messages"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("poll");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("poll");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__POLL));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("poll", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("global");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("global");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__GLOBAL));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("global", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("properties");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__PROPERTIES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("properties", count - 1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("messages");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__MESSAGES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("messages", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("init");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("init");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__INIT));
				if (o != null) {
					doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
				}
				printCountingMap.put("init", count - 1);
			}
		}
	}
	
	public void print_edapuC_UCApplication(edapuC.UCApplication element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__STATE_MACHINE));
		printCountingMap.put("state_machine", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__HEADERS));
		printCountingMap.put("headers", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__INIT));
		printCountingMap.put("init", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__POLL));
		printCountingMap.put("poll", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__GLOBAL));
		printCountingMap.put("global", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("application");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("state_machine");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__STATE_MACHINE));
			if (o != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCApplicationState_machineReferenceResolver().deResolve((edap.Component) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__STATE_MACHINE)), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__STATE_MACHINE), element));
			}
			printCountingMap.put("state_machine", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edapuC_UCApplication_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	public void print_edapuC_UCApplication_0(edapuC.UCApplication element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edapuC_UCApplication_0_0(element, localtab, out, printCountingMap);
	}
	public void print_edapuC_UCApplication_0_0(edapuC.UCApplication element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"init"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"poll"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"global"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"headers"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("poll");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("poll");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__POLL));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("poll", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("global");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("global");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__GLOBAL));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("global", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("headers");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("headers");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__HEADERS));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("headers", count - 1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("properties");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__PROPERTIES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("properties", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("init");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("init");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__INIT));
				if (o != null) {
					doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
				}
				printCountingMap.put("init", count - 1);
			}
		}
	}
	
	public void print_edapuC_UCMessage(edapuC.UCMessage element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__MESSAGE));
		printCountingMap.put("message", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__SEND));
		printCountingMap.put("send", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("message");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("message");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__MESSAGE));
			if (o != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCMessageMessageReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__MESSAGE)), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__MESSAGE), element));
			}
			printCountingMap.put("message", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edapuC_UCMessage_0(element, localtab, out1, printCountingMap1);
			if (printCountingMap.equals(printCountingMap1)) {
				iterate = false;
				out1.close();
			} else {
				out1.flush();
				out1.close();
				out.print(sWriter.toString());
				printCountingMap.putAll(printCountingMap1);
			}
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	public void print_edapuC_UCMessage_0(edapuC.UCMessage element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edapuC_UCMessage_0_0(element, localtab, out, printCountingMap);
	}
	public void print_edapuC_UCMessage_0_0(edapuC.UCMessage element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"send"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CsString)
				out.print("send");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("send");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__SEND));
					if (o != null) {
						doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
					}
					printCountingMap.put("send", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("properties");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__PROPERTIES));
				java.util.List<?> list = (java.util.List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
				}
				printCountingMap.put("properties", count - 1);
			}
		}
	}
	
	public void print_edapuC_Template(edapuC.Template element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__TEXT));
		printCountingMap.put("text", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__GENERATOR));
		printCountingMap.put("generator", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("generator");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__GENERATOR));
			if (o != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver resolver = tokenResolverFactory.createTokenResolver("GENERATOR");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__GENERATOR), element));
			}
			printCountingMap.put("generator", count - 1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("text");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__TEXT));
			if (o != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEMPLATE");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__TEXT), element));
			}
			printCountingMap.put("text", count - 1);
		}
	}
	
	public void print_edapuC_StaticProperty(edapuC.StaticProperty element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("property");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__NAME));
			if (o != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__VALUE));
			if (o != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__VALUE), element));
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
}
