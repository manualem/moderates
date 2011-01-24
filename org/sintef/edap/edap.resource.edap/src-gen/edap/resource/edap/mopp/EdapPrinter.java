/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edap.resource.edap.mopp;

public class EdapPrinter implements edap.resource.edap.IEdapTextPrinter {
	
	protected edap.resource.edap.IEdapTokenResolverFactory tokenResolverFactory = new edap.resource.edap.mopp.EdapTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private edap.resource.edap.IEdapTextResource resource;
	
	private java.util.Map<?, ?> options;
	
	public EdapPrinter(java.io.OutputStream outputStream, edap.resource.edap.IEdapTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
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
		
		if (element instanceof edap.EdapModel) {
			print_edap_EdapModel((edap.EdapModel) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Message) {
			print_edap_Message((edap.Message) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Device) {
			print_edap_Device((edap.Device) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Simulator) {
			print_edap_Simulator((edap.Simulator) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Dictionary) {
			print_edap_Dictionary((edap.Dictionary) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Parameter) {
			print_edap_Parameter((edap.Parameter) element, globaltab, out);
			return;
		}
		if (element instanceof edap.PrimitiveType) {
			print_edap_PrimitiveType((edap.PrimitiveType) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Enumeration) {
			print_edap_Enumeration((edap.Enumeration) element, globaltab, out);
			return;
		}
		if (element instanceof edap.EnumerationLiteral) {
			print_edap_EnumerationLiteral((edap.EnumerationLiteral) element, globaltab, out);
			return;
		}
		if (element instanceof edap.PlatformAnnotation) {
			print_edap_PlatformAnnotation((edap.PlatformAnnotation) element, globaltab, out);
			return;
		}
		if (element instanceof edap.StateMachine) {
			print_edap_StateMachine((edap.StateMachine) element, globaltab, out);
			return;
		}
		if (element instanceof edap.CompositeState) {
			print_edap_CompositeState((edap.CompositeState) element, globaltab, out);
			return;
		}
		if (element instanceof edap.PropertyAssignment) {
			print_edap_PropertyAssignment((edap.PropertyAssignment) element, globaltab, out);
			return;
		}
		if (element instanceof edap.ComponentReference) {
			print_edap_ComponentReference((edap.ComponentReference) element, globaltab, out);
			return;
		}
		if (element instanceof edap.EventReference) {
			print_edap_EventReference((edap.EventReference) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Unicast) {
			print_edap_Unicast((edap.Unicast) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Broadcast) {
			print_edap_Broadcast((edap.Broadcast) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Transition) {
			print_edap_Transition((edap.Transition) element, globaltab, out);
			return;
		}
		if (element instanceof edap.ReceiveMessage) {
			print_edap_ReceiveMessage((edap.ReceiveMessage) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Connector) {
			print_edap_Connector((edap.Connector) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Port) {
			print_edap_Port((edap.Port) element, globaltab, out);
			return;
		}
		if (element instanceof edap.CreateAction) {
			print_edap_CreateAction((edap.CreateAction) element, globaltab, out);
			return;
		}
		if (element instanceof edap.ActionBlock) {
			print_edap_ActionBlock((edap.ActionBlock) element, globaltab, out);
			return;
		}
		if (element instanceof edap.ExternStatement) {
			print_edap_ExternStatement((edap.ExternStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edap.ConditionalAction) {
			print_edap_ConditionalAction((edap.ConditionalAction) element, globaltab, out);
			return;
		}
		if (element instanceof edap.LoopAction) {
			print_edap_LoopAction((edap.LoopAction) element, globaltab, out);
			return;
		}
		if (element instanceof edap.OrExpression) {
			print_edap_OrExpression((edap.OrExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.AndExpression) {
			print_edap_AndExpression((edap.AndExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.LowerExpression) {
			print_edap_LowerExpression((edap.LowerExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.GreaterExpression) {
			print_edap_GreaterExpression((edap.GreaterExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.EqualsExpression) {
			print_edap_EqualsExpression((edap.EqualsExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.PlusExpression) {
			print_edap_PlusExpression((edap.PlusExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.MinusExpression) {
			print_edap_MinusExpression((edap.MinusExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.TimesExpression) {
			print_edap_TimesExpression((edap.TimesExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.DivExpression) {
			print_edap_DivExpression((edap.DivExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.ModExpression) {
			print_edap_ModExpression((edap.ModExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.UnaryMinus) {
			print_edap_UnaryMinus((edap.UnaryMinus) element, globaltab, out);
			return;
		}
		if (element instanceof edap.NotExpression) {
			print_edap_NotExpression((edap.NotExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.ExpressionGroup) {
			print_edap_ExpressionGroup((edap.ExpressionGroup) element, globaltab, out);
			return;
		}
		if (element instanceof edap.PropertyReference) {
			print_edap_PropertyReference((edap.PropertyReference) element, globaltab, out);
			return;
		}
		if (element instanceof edap.IntegerLitteral) {
			print_edap_IntegerLitteral((edap.IntegerLitteral) element, globaltab, out);
			return;
		}
		if (element instanceof edap.StringLitteral) {
			print_edap_StringLitteral((edap.StringLitteral) element, globaltab, out);
			return;
		}
		if (element instanceof edap.BooleanLitteral) {
			print_edap_BooleanLitteral((edap.BooleanLitteral) element, globaltab, out);
			return;
		}
		if (element instanceof edap.ExternExpression) {
			print_edap_ExternExpression((edap.ExternExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap.SoftwareComponent) {
			print_edap_SoftwareComponent((edap.SoftwareComponent) element, globaltab, out);
			return;
		}
		if (element instanceof edap.Property) {
			print_edap_Property((edap.Property) element, globaltab, out);
			return;
		}
		if (element instanceof edap.State) {
			print_edap_State((edap.State) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected edap.resource.edap.mopp.EdapReferenceResolverSwitch getReferenceResolverSwitch() {
		return (edap.resource.edap.mopp.EdapReferenceResolverSwitch) new edap.resource.edap.mopp.EdapMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		edap.resource.edap.IEdapTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new edap.resource.edap.mopp.EdapProblem(errorMessage, edap.resource.edap.EdapEProblemType.PRINT_PROBLEM, edap.resource.edap.EdapEProblemSeverity.WARNING), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public edap.resource.edap.IEdapTextResource getResource() {
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
	
	public void print_edap_EdapModel(edap.EdapModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EDAP_MODEL__TYPES));
		printCountingMap.put("types", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EDAP_MODEL__IMPORTS));
		printCountingMap.put("imports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
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
			print_edap_EdapModel_0(element, localtab, out1, printCountingMap1);
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
			print_edap_EdapModel_1(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_EdapModel_0(edap.EdapModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EDAP_MODEL__IMPORTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEdapModelImportsReferenceResolver().deResolve((edap.EdapModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.EDAP_MODEL__IMPORTS)), element.eClass().getEStructuralFeature(edap.EdapPackage.EDAP_MODEL__IMPORTS), element));
			}
			printCountingMap.put("imports", count - 1);
		}
	}
	
	public void print_edap_EdapModel_1(edap.EdapModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edap_EdapModel_1_0(element, localtab, out, printCountingMap);
	}
	
	public void print_edap_EdapModel_1_0(edap.EdapModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("types");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EDAP_MODEL__TYPES));
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
			printCountingMap.put("types", count - 1);
		}
	}
	
	
	public void print_edap_Message(edap.Message element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__ALLOW_MULTICAST));
		printCountingMap.put("allowMulticast", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Message_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("message");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Message_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Message_2(element, localtab, out1, printCountingMap1);
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
		out.print(";");
	}
	
	public void print_edap_Message_0(edap.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("allowMulticast");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__ALLOW_MULTICAST));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_MULTICAST");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__ALLOW_MULTICAST), element));
			}
			printCountingMap.put("allowMulticast", count - 1);
		}
	}
	
	public void print_edap_Message_1(edap.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__PARAMETERS));
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
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Message_1_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_Message_1_0(edap.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__PARAMETERS));
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
			printCountingMap.put("parameters", count - 1);
		}
	}
	
	public void print_edap_Message_2(edap.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	
	public void print_edap_Device(edap.Device element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(11);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__COMPOSITE_COMPONENT));
		printCountingMap.put("compositeComponent", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__PARTIAL));
		printCountingMap.put("partial", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SINGLETON));
		printCountingMap.put("singleton", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES));
		printCountingMap.put("receives", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS));
		printCountingMap.put("sends", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__MESSAGES));
		printCountingMap.put("messages", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__CONNECTORS));
		printCountingMap.put("connectors", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__PORTS));
		printCountingMap.put("ports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Device_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Device_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("device");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Device_2(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Device_3(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	
	public void print_edap_Device_0(edap.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("partial");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__PARTIAL));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_ASPECT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__PARTIAL), element));
			}
			printCountingMap.put("partial", count - 1);
		}
	}
	
	public void print_edap_Device_1(edap.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("singleton");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SINGLETON));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_SINGLETON");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SINGLETON), element));
			}
			printCountingMap.put("singleton", count - 1);
		}
	}
	
	public void print_edap_Device_2(edap.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	public void print_edap_Device_3(edap.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"messages"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"receives"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"sends"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"compositeComponent"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("properties");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__PROPERTIES));
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
			case 2:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CsString)
				out.print("receives");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("receives");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES)), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES), element));
					}
					printCountingMap.put("receives", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_Device_3_0(element, localtab, out1, printCountingMap1);
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
			break;
			case 3:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CsString)
				out.print("sends");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("sends");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS)), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS), element));
					}
					printCountingMap.put("sends", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_Device_3_1(element, localtab, out1, printCountingMap1);
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
			break;
			case 4:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_edap_Device_3_2(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("messages");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__MESSAGES));
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
	}
	
	public void print_edap_Device_3_0(edap.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("receives");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES)), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES), element));
			}
			printCountingMap.put("receives", count - 1);
		}
	}
	
	public void print_edap_Device_3_1(edap.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("sends");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS)), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS), element));
			}
			printCountingMap.put("sends", count - 1);
		}
	}
	
	public void print_edap_Device_3_2(edap.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("compositeComponent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__COMPOSITE_COMPONENT));
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
			printCountingMap.put("compositeComponent", count - 1);
		}
	}
	
	
	public void print_edap_SoftwareComponent(edap.SoftwareComponent element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(12);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__COMPOSITE_COMPONENT));
		printCountingMap.put("compositeComponent", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PARTIAL));
		printCountingMap.put("partial", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SINGLETON));
		printCountingMap.put("singleton", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES));
		printCountingMap.put("receives", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS));
		printCountingMap.put("sends", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__MESSAGES));
		printCountingMap.put("messages", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__CONNECTORS));
		printCountingMap.put("connectors", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PORTS));
		printCountingMap.put("ports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__BEHAVIOUR));
		printCountingMap.put("behaviour", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_SoftwareComponent_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_SoftwareComponent_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("component");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_SoftwareComponent_2(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_SoftwareComponent_3(element, localtab, out1, printCountingMap1);
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
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_SoftwareComponent_4(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	
	public void print_edap_SoftwareComponent_0(edap.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("partial");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PARTIAL));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_ASPECT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PARTIAL), element));
			}
			printCountingMap.put("partial", count - 1);
		}
	}
	
	public void print_edap_SoftwareComponent_1(edap.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("singleton");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SINGLETON));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_SINGLETON");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SINGLETON), element));
			}
			printCountingMap.put("singleton", count - 1);
		}
	}
	
	public void print_edap_SoftwareComponent_2(edap.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	public void print_edap_SoftwareComponent_3(edap.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"ports"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"connectors"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"messages"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"receives"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"sends"		));
		if (tempMatchCount > matches) {
			alt = 5;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"compositeComponent"		));
		if (tempMatchCount > matches) {
			alt = 6;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("connectors");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__CONNECTORS));
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
					printCountingMap.put("connectors", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("messages");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__MESSAGES));
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
			case 3:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("properties");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PROPERTIES));
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
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CsString)
				out.print("receives");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("receives");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES)), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES), element));
					}
					printCountingMap.put("receives", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_SoftwareComponent_3_0(element, localtab, out1, printCountingMap1);
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
			break;
			case 5:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CsString)
				out.print("sends");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("sends");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS)), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS), element));
					}
					printCountingMap.put("sends", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_SoftwareComponent_3_1(element, localtab, out1, printCountingMap1);
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
			break;
			case 6:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_edap_SoftwareComponent_3_2(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("ports");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PORTS));
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
				printCountingMap.put("ports", count - 1);
			}
		}
	}
	
	public void print_edap_SoftwareComponent_3_0(edap.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("receives");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES)), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES), element));
			}
			printCountingMap.put("receives", count - 1);
		}
	}
	
	public void print_edap_SoftwareComponent_3_1(edap.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("sends");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS)), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS), element));
			}
			printCountingMap.put("sends", count - 1);
		}
	}
	
	public void print_edap_SoftwareComponent_3_2(edap.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("compositeComponent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__COMPOSITE_COMPONENT));
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
			printCountingMap.put("compositeComponent", count - 1);
		}
	}
	
	public void print_edap_SoftwareComponent_4(edap.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("behaviour");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__BEHAVIOUR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("behaviour", count - 1);
		}
	}
	
	
	public void print_edap_Simulator(edap.Simulator element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(13);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__COMPOSITE_COMPONENT));
		printCountingMap.put("compositeComponent", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__PARTIAL));
		printCountingMap.put("partial", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SINGLETON));
		printCountingMap.put("singleton", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES));
		printCountingMap.put("receives", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS));
		printCountingMap.put("sends", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__MESSAGES));
		printCountingMap.put("messages", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__CONNECTORS));
		printCountingMap.put("connectors", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__PORTS));
		printCountingMap.put("ports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__BEHAVIOUR));
		printCountingMap.put("behaviour", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__DEVICE));
		printCountingMap.put("device", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("simulator");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("for");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("device");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__DEVICE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSimulatorDeviceReferenceResolver().deResolve((edap.Device) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__DEVICE)), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__DEVICE), element));
			}
			printCountingMap.put("device", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Simulator_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Simulator_1(element, localtab, out1, printCountingMap1);
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
		print_edap_Simulator_2(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	
	public void print_edap_Simulator_0(edap.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	public void print_edap_Simulator_1(edap.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"messages"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"receives"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"sends"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"compositeComponent"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("properties");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__PROPERTIES));
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
			case 2:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CsString)
				out.print("receives");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("receives");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES)), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES), element));
					}
					printCountingMap.put("receives", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_Simulator_1_0(element, localtab, out1, printCountingMap1);
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
			break;
			case 3:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (CsString)
				out.print("sends");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("sends");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS)), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS), element));
					}
					printCountingMap.put("sends", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_Simulator_1_1(element, localtab, out1, printCountingMap1);
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
			break;
			case 4:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_edap_Simulator_1_2(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("messages");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__MESSAGES));
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
	}
	
	public void print_edap_Simulator_1_0(edap.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("receives");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES)), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES), element));
			}
			printCountingMap.put("receives", count - 1);
		}
	}
	
	public void print_edap_Simulator_1_1(edap.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("sends");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS)), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS), element));
			}
			printCountingMap.put("sends", count - 1);
		}
	}
	
	public void print_edap_Simulator_1_2(edap.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("compositeComponent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__COMPOSITE_COMPONENT));
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
			printCountingMap.put("compositeComponent", count - 1);
		}
	}
	
	public void print_edap_Simulator_2(edap.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("behaviour");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__BEHAVIOUR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("behaviour", count - 1);
		}
	}
	
	
	public void print_edap_Property(edap.Property element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__CHANGEABLE));
		printCountingMap.put("changeable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__LOWER_BOUND));
		printCountingMap.put("lowerBound", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__UPPER_BOUND));
		printCountingMap.put("upperBound", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Property_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("property");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__TYPE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyTypeReferenceResolver().deResolve((edap.Type) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__TYPE)), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__TYPE), element));
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Property_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Property_2(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_Property_0(edap.Property element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("changeable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__CHANGEABLE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_READONLY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__CHANGEABLE), element));
			}
			printCountingMap.put("changeable", count - 1);
		}
	}
	
	public void print_edap_Property_1(edap.Property element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("lowerBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__LOWER_BOUND));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__LOWER_BOUND), element));
			}
			printCountingMap.put("lowerBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("..");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("upperBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__UPPER_BOUND));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__UPPER_BOUND), element));
			}
			printCountingMap.put("upperBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
	}
	
	public void print_edap_Property_2(edap.Property element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	
	public void print_edap_Dictionary(edap.Dictionary element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__CHANGEABLE));
		printCountingMap.put("changeable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__LOWER_BOUND));
		printCountingMap.put("lowerBound", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__UPPER_BOUND));
		printCountingMap.put("upperBound", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__INDEX_TYPE));
		printCountingMap.put("indexType", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Dictionary_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("dictionary");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("indexType");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__INDEX_TYPE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getDictionaryIndexTypeReferenceResolver().deResolve((edap.Type) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__INDEX_TYPE)), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__INDEX_TYPE), element));
			}
			printCountingMap.put("indexType", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__TYPE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyTypeReferenceResolver().deResolve((edap.Type) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__TYPE)), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__TYPE), element));
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Dictionary_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Dictionary_2(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_Dictionary_0(edap.Dictionary element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("changeable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__CHANGEABLE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_READONLY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__CHANGEABLE), element));
			}
			printCountingMap.put("changeable", count - 1);
		}
	}
	
	public void print_edap_Dictionary_1(edap.Dictionary element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("lowerBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__LOWER_BOUND));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__LOWER_BOUND), element));
			}
			printCountingMap.put("lowerBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("..");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("upperBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__UPPER_BOUND));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__UPPER_BOUND), element));
			}
			printCountingMap.put("upperBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
	}
	
	public void print_edap_Dictionary_2(edap.Dictionary element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	
	public void print_edap_Parameter(edap.Parameter element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__TYPE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getParameterTypeReferenceResolver().deResolve((edap.Type) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__TYPE)), element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__TYPE), element));
			}
			printCountingMap.put("type", count - 1);
		}
	}
	
	
	public void print_edap_PrimitiveType(edap.PrimitiveType element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PRIMITIVE_TYPE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PRIMITIVE_TYPE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("datatype");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PRIMITIVE_TYPE__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.PRIMITIVE_TYPE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_PrimitiveType_0(element, localtab, out1, printCountingMap1);
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
		out.print(";");
	}
	
	public void print_edap_PrimitiveType_0(edap.PrimitiveType element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PRIMITIVE_TYPE__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	
	public void print_edap_Enumeration(edap.Enumeration element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("enumeration");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Enumeration_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Enumeration_1(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_Enumeration_0(edap.Enumeration element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	public void print_edap_Enumeration_1(edap.Enumeration element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__LITERALS));
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
			printCountingMap.put("literals", count - 1);
		}
	}
	
	
	public void print_edap_EnumerationLiteral(edap.EnumerationLiteral element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION_LITERAL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION_LITERAL__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION_LITERAL__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION_LITERAL__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_EnumerationLiteral_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_EnumerationLiteral_0(edap.EnumerationLiteral element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION_LITERAL__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	
	public void print_edap_PlatformAnnotation(edap.PlatformAnnotation element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__VALUE));
		printCountingMap.put("value", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("ANNOTATION");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__VALUE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__VALUE), element));
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	
	public void print_edap_StateMachine(edap.StateMachine element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(9);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__SUBSTATE));
		printCountingMap.put("substate", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__INITIAL));
		printCountingMap.put("initial", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("statechart");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("init");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("initial");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__INITIAL));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeStateInitialReferenceResolver().deResolve((edap.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__INITIAL)), element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__INITIAL), element));
			}
			printCountingMap.put("initial", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_StateMachine_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_StateMachine_1(element, localtab, out1, printCountingMap1);
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
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_StateMachine_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_StateMachine_3(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_StateMachine_4(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	
	public void print_edap_StateMachine_0(edap.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	public void print_edap_StateMachine_1(edap.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("properties");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__PROPERTIES));
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
	
	public void print_edap_StateMachine_2(edap.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("on");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("entry");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("entry");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__ENTRY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("entry", count - 1);
		}
	}
	
	public void print_edap_StateMachine_3(edap.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("on");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("exit");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("exit");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__EXIT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("exit", count - 1);
		}
	}
	
	public void print_edap_StateMachine_4(edap.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("substate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__SUBSTATE));
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
			printCountingMap.put("substate", count - 1);
		}
	}
	
	
	public void print_edap_State(edap.State element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("state");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_State_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_State_1(element, localtab, out1, printCountingMap1);
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
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_State_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_State_3(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_State_4(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	
	public void print_edap_State_0(edap.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	public void print_edap_State_1(edap.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("properties");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__PROPERTIES));
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
	
	public void print_edap_State_2(edap.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("on");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("entry");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("entry");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__ENTRY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("entry", count - 1);
		}
	}
	
	public void print_edap_State_3(edap.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("on");
		// DEFINITION PART BEGINS (CsString)
		out.print("exit");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("exit");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__EXIT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("exit", count - 1);
		}
	}
	
	public void print_edap_State_4(edap.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("outgoing");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__OUTGOING));
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
			printCountingMap.put("outgoing", count - 1);
		}
	}
	
	
	public void print_edap_CompositeState(edap.CompositeState element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(9);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__SUBSTATE));
		printCountingMap.put("substate", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__INITIAL));
		printCountingMap.put("initial", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("composite");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("state");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("init");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("initial");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__INITIAL));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeStateInitialReferenceResolver().deResolve((edap.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__INITIAL)), element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__INITIAL), element));
			}
			printCountingMap.put("initial", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_CompositeState_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_CompositeState_1(element, localtab, out1, printCountingMap1);
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
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_CompositeState_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_CompositeState_3(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_CompositeState_4(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	
	public void print_edap_CompositeState_0(edap.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	public void print_edap_CompositeState_1(edap.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("properties");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__PROPERTIES));
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
	
	public void print_edap_CompositeState_2(edap.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("on");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("entry");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("entry");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__ENTRY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("entry", count - 1);
		}
	}
	
	public void print_edap_CompositeState_3(edap.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("on");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("exit");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("exit");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__EXIT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("exit", count - 1);
		}
	}
	
	public void print_edap_CompositeState_4(edap.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		int alt = -1;
		alt = 0;
		int matches = 		matchCount(printCountingMap, java.util.Arrays.asList(		"outgoing"		));
		int tempMatchCount;
		tempMatchCount = 		matchCount(printCountingMap, java.util.Arrays.asList(		"substate"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_edap_CompositeState_4_0(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("outgoing");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__OUTGOING));
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
				printCountingMap.put("outgoing", count - 1);
			}
		}
	}
	
	public void print_edap_CompositeState_4_0(edap.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("substate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__SUBSTATE));
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
			printCountingMap.put("substate", count - 1);
		}
	}
	
	
	public void print_edap_PropertyAssignment(edap.PropertyAssignment element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__PROPERTY));
		printCountingMap.put("property", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("property");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__PROPERTY));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyAssignmentPropertyReferenceResolver().deResolve((edap.Property) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__PROPERTY)), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__PROPERTY), element));
			}
			printCountingMap.put("property", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expression", count - 1);
		}
	}
	
	
	public void print_edap_ComponentReference(edap.ComponentReference element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPONENT_REFERENCE__COMPONENT));
		printCountingMap.put("component", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("component");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPONENT_REFERENCE__COMPONENT));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReferenceComponentReferenceResolver().deResolve((edap.Component) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.COMPONENT_REFERENCE__COMPONENT)), element.eClass().getEStructuralFeature(edap.EdapPackage.COMPONENT_REFERENCE__COMPONENT), element));
			}
			printCountingMap.put("component", count - 1);
		}
	}
	
	
	public void print_edap_EventReference(edap.EventReference element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__MSG_REF));
		printCountingMap.put("msgRef", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__PARAM_REF));
		printCountingMap.put("paramRef", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("eventref");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("msgRef");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__MSG_REF));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEventReferenceMsgRefReferenceResolver().deResolve((edap.ReceiveMessage) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__MSG_REF)), element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__MSG_REF), element));
			}
			printCountingMap.put("msgRef", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("paramRef");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__PARAM_REF));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEventReferenceParamRefReferenceResolver().deResolve((edap.Parameter) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__PARAM_REF)), element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__PARAM_REF), element));
			}
			printCountingMap.put("paramRef", count - 1);
		}
	}
	
	
	public void print_edap_Unicast(edap.Unicast element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__MESSAGE));
		printCountingMap.put("message", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PORT));
		printCountingMap.put("port", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("send");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("#");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("message");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__MESSAGE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSendActionMessageReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__MESSAGE)), element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__MESSAGE), element));
			}
			printCountingMap.put("message", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Unicast_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Unicast_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Unicast_2(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_Unicast_0(edap.Unicast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PARAMETERS));
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
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Unicast_0_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_Unicast_0_0(edap.Unicast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PARAMETERS));
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
			printCountingMap.put("parameters", count - 1);
		}
	}
	
	public void print_edap_Unicast_1(edap.Unicast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("port");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("port");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PORT));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSendActionPortReferenceResolver().deResolve((edap.Port) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PORT)), element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PORT), element));
			}
			printCountingMap.put("port", count - 1);
		}
	}
	
	public void print_edap_Unicast_2(edap.Unicast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	
	public void print_edap_Broadcast(edap.Broadcast element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__MESSAGE));
		printCountingMap.put("message", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__PORT));
		printCountingMap.put("port", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("broadcast");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("#");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("message");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__MESSAGE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSendActionMessageReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__MESSAGE)), element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__MESSAGE), element));
			}
			printCountingMap.put("message", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Broadcast_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
	}
	
	public void print_edap_Broadcast_0(edap.Broadcast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__PARAMETERS));
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
			printCountingMap.put("parameters", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Broadcast_0_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_Broadcast_0_0(edap.Broadcast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__PARAMETERS));
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
			printCountingMap.put("parameters", count - 1);
		}
	}
	
	
	public void print_edap_Transition(edap.Transition element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__EVENT));
		printCountingMap.put("event", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__GUARD));
		printCountingMap.put("guard", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("transition");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__TARGET));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTransitionTargetReferenceResolver().deResolve((edap.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__TARGET)), element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__TARGET), element));
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Transition_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Transition_1(element, localtab, out1, printCountingMap1);
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
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Transition_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_Transition_3(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	
	public void print_edap_Transition_0(edap.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	public void print_edap_Transition_1(edap.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("event");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("event");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__EVENT));
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
			printCountingMap.put("event", count - 1);
		}
	}
	
	public void print_edap_Transition_2(edap.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("guard");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("guard");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__GUARD));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("guard", count - 1);
		}
	}
	
	public void print_edap_Transition_3(edap.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("action");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("action");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__ACTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("action", count - 1);
		}
	}
	
	
	public void print_edap_ReceiveMessage(edap.ReceiveMessage element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__DEVICE));
		printCountingMap.put("device", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__MESSAGE));
		printCountingMap.put("message", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("device");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__DEVICE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("device", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("#");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("message");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__MESSAGE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getReceiveMessageMessageReferenceResolver().deResolve((edap.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__MESSAGE)), element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__MESSAGE), element));
			}
			printCountingMap.put("message", count - 1);
		}
	}
	
	
	public void print_edap_Connector(edap.Connector element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT1));
		printCountingMap.put("port1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT2));
		printCountingMap.put("port2", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PROP1));
		printCountingMap.put("prop1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PROP2));
		printCountingMap.put("prop2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("connector");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("port1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT1));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectorPort1ReferenceResolver().deResolve((edap.Port) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT1)), element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT1), element));
			}
			printCountingMap.put("port1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("port2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT2));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectorPort2ReferenceResolver().deResolve((edap.Port) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT2)), element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT2), element));
			}
			printCountingMap.put("port2", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Connector_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_Connector_0(edap.Connector element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	
	public void print_edap_Port(edap.Port element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PORT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PORT__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PORT__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("port");
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PORT__NAME));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.PORT__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_Port_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_Port_0(edap.Port element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PORT__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	
	public void print_edap_CreateAction(edap.CreateAction element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CREATE_ACTION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CREATE_ACTION__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CREATE_ACTION__REF));
		printCountingMap.put("ref", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("create");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("ref");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CREATE_ACTION__REF));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("ref", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_CreateAction_0(element, localtab, out1, printCountingMap1);
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
	
	public void print_edap_CreateAction_0(edap.CreateAction element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CREATE_ACTION__ANNOTATIONS));
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
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	
	public void print_edap_ActionBlock(edap.ActionBlock element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ACTION_BLOCK__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ACTION_BLOCK__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ACTION_BLOCK__ACTIONS));
		printCountingMap.put("actions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_ActionBlock_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	
	public void print_edap_ActionBlock_0(edap.ActionBlock element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap) {
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("actions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.ACTION_BLOCK__ACTIONS));
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
			printCountingMap.put("actions", count - 1);
		}
	}
	
	
	public void print_edap_ExternStatement(edap.ExternStatement element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_STATEMENT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_STATEMENT__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_STATEMENT__STATEMENT));
		printCountingMap.put("statement", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("statement");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_STATEMENT__STATEMENT));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_EXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_STATEMENT__STATEMENT), element));
			}
			printCountingMap.put("statement", count - 1);
		}
	}
	
	
	public void print_edap_ConditionalAction(edap.ConditionalAction element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONDITIONAL_ACTION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONDITIONAL_ACTION__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONDITIONAL_ACTION__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONDITIONAL_ACTION__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("if");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONDITIONAL_ACTION__CONDITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("condition", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("action");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONDITIONAL_ACTION__ACTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("action", count - 1);
		}
	}
	
	
	public void print_edap_LoopAction(edap.LoopAction element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOOP_ACTION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOOP_ACTION__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOOP_ACTION__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOOP_ACTION__CONDITION));
		printCountingMap.put("condition", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("while");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("condition");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOOP_ACTION__CONDITION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("condition", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("action");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOOP_ACTION__ACTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("action", count - 1);
		}
	}
	
	
	public void print_edap_OrExpression(edap.OrExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.OR_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.OR_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.OR_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("or");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.OR_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_AndExpression(edap.AndExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.AND_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.AND_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.AND_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.AND_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_LowerExpression(edap.LowerExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOWER_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOWER_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOWER_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("<");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOWER_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_GreaterExpression(edap.GreaterExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.GREATER_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.GREATER_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.GREATER_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print(">");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.GREATER_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_EqualsExpression(edap.EqualsExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EQUALS_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EQUALS_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EQUALS_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("==");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EQUALS_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_PlusExpression(edap.PlusExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLUS_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLUS_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLUS_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("+");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLUS_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_MinusExpression(edap.MinusExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MINUS_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MINUS_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MINUS_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("-");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MINUS_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_TimesExpression(edap.TimesExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TIMES_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TIMES_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TIMES_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("*");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.TIMES_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_DivExpression(edap.DivExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DIV_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DIV_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DIV_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("/");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.DIV_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_ModExpression(edap.ModExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MOD_EXPRESSION__LHS));
		printCountingMap.put("lhs", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MOD_EXPRESSION__RHS));
		printCountingMap.put("rhs", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("lhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MOD_EXPRESSION__LHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("lhs", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("%");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("rhs");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.MOD_EXPRESSION__RHS));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("rhs", count - 1);
		}
	}
	
	
	public void print_edap_UnaryMinus(edap.UnaryMinus element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNARY_MINUS__TERM));
		printCountingMap.put("term", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("-");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("term");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNARY_MINUS__TERM));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("term", count - 1);
		}
	}
	
	
	public void print_edap_NotExpression(edap.NotExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.NOT_EXPRESSION__TERM));
		printCountingMap.put("term", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("not");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("term");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.NOT_EXPRESSION__TERM));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("term", count - 1);
		}
	}
	
	
	public void print_edap_ExpressionGroup(edap.ExpressionGroup element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXPRESSION_GROUP__EXP));
		printCountingMap.put("exp", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("exp");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXPRESSION_GROUP__EXP));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("exp", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
	}
	
	
	public void print_edap_PropertyReference(edap.PropertyReference element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_REFERENCE__PROPERTY));
		printCountingMap.put("property", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("property");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_REFERENCE__PROPERTY));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyReferencePropertyReferenceResolver().deResolve((edap.Property) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_REFERENCE__PROPERTY)), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_REFERENCE__PROPERTY), element));
			}
			printCountingMap.put("property", count - 1);
		}
	}
	
	
	public void print_edap_IntegerLitteral(edap.IntegerLitteral element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.INTEGER_LITTERAL__INT_VALUE));
		printCountingMap.put("intValue", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("intValue");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.INTEGER_LITTERAL__INT_VALUE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.INTEGER_LITTERAL__INT_VALUE), element));
			}
			printCountingMap.put("intValue", count - 1);
		}
	}
	
	
	public void print_edap_StringLitteral(edap.StringLitteral element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STRING_LITTERAL__STRING_VALUE));
		printCountingMap.put("stringValue", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("stringValue");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.STRING_LITTERAL__STRING_VALUE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.STRING_LITTERAL__STRING_VALUE), element));
			}
			printCountingMap.put("stringValue", count - 1);
		}
	}
	
	
	public void print_edap_BooleanLitteral(edap.BooleanLitteral element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BOOLEAN_LITTERAL__BOOL_VALUE));
		printCountingMap.put("boolValue", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("boolValue");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.BOOLEAN_LITTERAL__BOOL_VALUE));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.BOOLEAN_LITTERAL__BOOL_VALUE), element));
			}
			printCountingMap.put("boolValue", count - 1);
		}
	}
	
	
	public void print_edap_ExternExpression(edap.ExternExpression element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_EXPRESSION__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_EXPRESSION__EXPRESSION));
			if (o != null) {
				edap.resource.edap.IEdapTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_EXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_EXPRESSION__EXPRESSION), element));
			}
			printCountingMap.put("expression", count - 1);
		}
	}
	
	
}
