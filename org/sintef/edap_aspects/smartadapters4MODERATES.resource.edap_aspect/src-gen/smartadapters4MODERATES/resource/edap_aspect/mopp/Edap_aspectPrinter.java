/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectPrinter implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextPrinter {
	
	protected smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolverFactory tokenResolverFactory = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenResolverFactory();
	protected java.io.OutputStream outputStream;
	/**
	 * Holds the resource that is associated with this printer. may be null if the
	 * printer is used stand alone.
	 */
	private smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource;
	private java.util.Map<?, ?> options;
	
	public Edap_aspectPrinter(java.io.OutputStream outputStream, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource) {
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
		
		if (element instanceof smartadapters4MODERATES.Aspect) {
			print_smartadapters4MODERATES_Aspect((smartadapters4MODERATES.Aspect) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.PointcutModel) {
			print_smartadapters4MODERATES_PointcutModel((smartadapters4MODERATES.PointcutModel) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.AdviceModel) {
			print_smartadapters4MODERATES_AdviceModel((smartadapters4MODERATES.AdviceModel) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.GlobalInstantiation) {
			print_smartadapters4MODERATES_GlobalInstantiation((smartadapters4MODERATES.GlobalInstantiation) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.PerRoleMatch) {
			print_smartadapters4MODERATES_PerRoleMatch((smartadapters4MODERATES.PerRoleMatch) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.PerElementMatch) {
			print_smartadapters4MODERATES_PerElementMatch((smartadapters4MODERATES.PerElementMatch) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetCompositeState) {
			print_smartadapters4MODERATES_adaptations_SetCompositeState((smartadapters4MODERATES.adaptations.SetCompositeState) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.UnsetCompositeState) {
			print_smartadapters4MODERATES_adaptations_UnsetCompositeState((smartadapters4MODERATES.adaptations.UnsetCompositeState) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetState) {
			print_smartadapters4MODERATES_adaptations_SetState((smartadapters4MODERATES.adaptations.SetState) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.UnsetState) {
			print_smartadapters4MODERATES_adaptations_UnsetState((smartadapters4MODERATES.adaptations.UnsetState) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetTransition) {
			print_smartadapters4MODERATES_adaptations_SetTransition((smartadapters4MODERATES.adaptations.SetTransition) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.UnsetTransition) {
			print_smartadapters4MODERATES_adaptations_UnsetTransition((smartadapters4MODERATES.adaptations.UnsetTransition) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetAnnotatedElement) {
			print_smartadapters4MODERATES_adaptations_SetAnnotatedElement((smartadapters4MODERATES.adaptations.SetAnnotatedElement) element, globaltab, out);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetActionBlock) {
			print_smartadapters4MODERATES_adaptations_SetActionBlock((smartadapters4MODERATES.adaptations.SetActionBlock) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.EdapModel) {
			print_edap_005frelaxed_EdapModel((edap_relaxed.EdapModel) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Message) {
			print_edap_005frelaxed_Message((edap_relaxed.Message) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Device) {
			print_edap_005frelaxed_Device((edap_relaxed.Device) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Simulator) {
			print_edap_005frelaxed_Simulator((edap_relaxed.Simulator) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Dictionary) {
			print_edap_005frelaxed_Dictionary((edap_relaxed.Dictionary) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Parameter) {
			print_edap_005frelaxed_Parameter((edap_relaxed.Parameter) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.PrimitiveType) {
			print_edap_005frelaxed_PrimitiveType((edap_relaxed.PrimitiveType) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Enumeration) {
			print_edap_005frelaxed_Enumeration((edap_relaxed.Enumeration) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.EnumerationLiteral) {
			print_edap_005frelaxed_EnumerationLiteral((edap_relaxed.EnumerationLiteral) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.PlatformAnnotation) {
			print_edap_005frelaxed_PlatformAnnotation((edap_relaxed.PlatformAnnotation) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.StateMachine) {
			print_edap_005frelaxed_StateMachine((edap_relaxed.StateMachine) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.CompositeState) {
			print_edap_005frelaxed_CompositeState((edap_relaxed.CompositeState) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.ActionBlock) {
			print_edap_005frelaxed_ActionBlock((edap_relaxed.ActionBlock) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.ExternStatement) {
			print_edap_005frelaxed_ExternStatement((edap_relaxed.ExternStatement) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.PropertyAssignment) {
			print_edap_005frelaxed_PropertyAssignment((edap_relaxed.PropertyAssignment) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.ExternExpression) {
			print_edap_005frelaxed_ExternExpression((edap_relaxed.ExternExpression) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.ComponentReference) {
			print_edap_005frelaxed_ComponentReference((edap_relaxed.ComponentReference) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.EventReference) {
			print_edap_005frelaxed_EventReference((edap_relaxed.EventReference) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.DictionaryNavigation) {
			print_edap_005frelaxed_DictionaryNavigation((edap_relaxed.DictionaryNavigation) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Unicast) {
			print_edap_005frelaxed_Unicast((edap_relaxed.Unicast) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Broadcast) {
			print_edap_005frelaxed_Broadcast((edap_relaxed.Broadcast) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Transition) {
			print_edap_005frelaxed_Transition((edap_relaxed.Transition) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.ReceiveMessage) {
			print_edap_005frelaxed_ReceiveMessage((edap_relaxed.ReceiveMessage) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Connector) {
			print_edap_005frelaxed_Connector((edap_relaxed.Connector) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Port) {
			print_edap_005frelaxed_Port((edap_relaxed.Port) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.CreateAction) {
			print_edap_005frelaxed_CreateAction((edap_relaxed.CreateAction) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.SoftwareComponent) {
			print_edap_005frelaxed_SoftwareComponent((edap_relaxed.SoftwareComponent) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.Property) {
			print_edap_005frelaxed_Property((edap_relaxed.Property) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.State) {
			print_edap_005frelaxed_State((edap_relaxed.State) element, globaltab, out);
			return;
		}
		if (element instanceof edap_relaxed.PropertyNavigation) {
			print_edap_005frelaxed_PropertyNavigation((edap_relaxed.PropertyNavigation) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	protected smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectReferenceResolverSwitch getReferenceResolverSwitch() {
		return (smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectReferenceResolverSwitch) new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectProblem(errorMessage, smartadapters4MODERATES.resource.edap_aspect.Edap_aspectEProblemType.ERROR), cause);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource getResource() {
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
	
	public void print_smartadapters4MODERATES_Aspect(smartadapters4MODERATES.Aspect element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__POINTCUT));
		printCountingMap.put("pointcut", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__ADVICE));
		printCountingMap.put("advice", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__STRATEGIES));
		printCountingMap.put("strategies", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__ADAPT));
		printCountingMap.put("adapt", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
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
		print_smartadapters4MODERATES_Aspect_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("pointcut");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("pointcut");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__POINTCUT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("pointcut", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("advice");
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_smartadapters4MODERATES_Aspect_1(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_smartadapters4MODERATES_Aspect_2(element, localtab, out1, printCountingMap1);
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
		out.print("protocol");
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
			print_smartadapters4MODERATES_Aspect_3(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_Aspect_0(smartadapters4MODERATES.Aspect element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("aspect");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_smartadapters4MODERATES_Aspect_1(smartadapters4MODERATES.Aspect element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("advice");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__ADVICE));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("advice", count - 1);
		}
	}
	public void print_smartadapters4MODERATES_Aspect_2(smartadapters4MODERATES.Aspect element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("strategies");
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
			print_smartadapters4MODERATES_Aspect_2_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_Aspect_2_0(smartadapters4MODERATES.Aspect element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("strategies");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__STRATEGIES));
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
			printCountingMap.put("strategies", count - 1);
		}
	}
	public void print_smartadapters4MODERATES_Aspect_3(smartadapters4MODERATES.Aspect element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("adapt");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ASPECT__ADAPT));
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
			printCountingMap.put("adapt", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_PointcutModel(smartadapters4MODERATES.PointcutModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.POINTCUT_MODEL__CONTENT));
		printCountingMap.put("content", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
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
			print_smartadapters4MODERATES_PointcutModel_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_PointcutModel_0(smartadapters4MODERATES.PointcutModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("content");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.POINTCUT_MODEL__CONTENT));
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
			printCountingMap.put("content", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_smartadapters4MODERATES_AdviceModel(smartadapters4MODERATES.AdviceModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ADVICE_MODEL__CONTENT));
		printCountingMap.put("content", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
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
			print_smartadapters4MODERATES_AdviceModel_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_AdviceModel_0(smartadapters4MODERATES.AdviceModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("content");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.ADVICE_MODEL__CONTENT));
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
			printCountingMap.put("content", count - 1);
		}
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
	}
	
	public void print_smartadapters4MODERATES_GlobalInstantiation(smartadapters4MODERATES.GlobalInstantiation element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.GLOBAL_INSTANTIATION__ADVICE_ELEMENTS));
		printCountingMap.put("adviceElements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("global");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("adviceElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.GLOBAL_INSTANTIATION__ADVICE_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getInstantiationStrategyAdviceElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.GLOBAL_INSTANTIATION__ADVICE_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.GLOBAL_INSTANTIATION__ADVICE_ELEMENTS), element));
			}
			printCountingMap.put("adviceElements", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_smartadapters4MODERATES_GlobalInstantiation_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_GlobalInstantiation_0(smartadapters4MODERATES.GlobalInstantiation element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("adviceElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.GLOBAL_INSTANTIATION__ADVICE_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getInstantiationStrategyAdviceElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.GLOBAL_INSTANTIATION__ADVICE_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.GLOBAL_INSTANTIATION__ADVICE_ELEMENTS), element));
			}
			printCountingMap.put("adviceElements", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_PerRoleMatch(smartadapters4MODERATES.PerRoleMatch element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__ADVICE_ELEMENTS));
		printCountingMap.put("adviceElements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__POINTCUT_ELEMENTS));
		printCountingMap.put("pointcutElements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("per");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("role");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("pointcutElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__POINTCUT_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getScopedInstantiationPointcutElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__POINTCUT_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__POINTCUT_ELEMENTS), element));
			}
			printCountingMap.put("pointcutElements", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_smartadapters4MODERATES_PerRoleMatch_0(element, localtab, out1, printCountingMap1);
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
		out.print(":");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("adviceElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__ADVICE_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getInstantiationStrategyAdviceElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__ADVICE_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__ADVICE_ELEMENTS), element));
			}
			printCountingMap.put("adviceElements", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_smartadapters4MODERATES_PerRoleMatch_1(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_PerRoleMatch_0(smartadapters4MODERATES.PerRoleMatch element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("pointcutElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__POINTCUT_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getScopedInstantiationPointcutElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__POINTCUT_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__POINTCUT_ELEMENTS), element));
			}
			printCountingMap.put("pointcutElements", count - 1);
		}
	}
	public void print_smartadapters4MODERATES_PerRoleMatch_1(smartadapters4MODERATES.PerRoleMatch element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("adviceElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__ADVICE_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getInstantiationStrategyAdviceElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__ADVICE_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ROLE_MATCH__ADVICE_ELEMENTS), element));
			}
			printCountingMap.put("adviceElements", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_PerElementMatch(smartadapters4MODERATES.PerElementMatch element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__ADVICE_ELEMENTS));
		printCountingMap.put("adviceElements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__POINTCUT_ELEMENTS));
		printCountingMap.put("pointcutElements", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("per");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("elements");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("pointcutElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__POINTCUT_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getScopedInstantiationPointcutElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__POINTCUT_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__POINTCUT_ELEMENTS), element));
			}
			printCountingMap.put("pointcutElements", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_smartadapters4MODERATES_PerElementMatch_0(element, localtab, out1, printCountingMap1);
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
		out.print(":");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("adviceElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__ADVICE_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getInstantiationStrategyAdviceElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__ADVICE_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__ADVICE_ELEMENTS), element));
			}
			printCountingMap.put("adviceElements", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_smartadapters4MODERATES_PerElementMatch_1(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_PerElementMatch_0(smartadapters4MODERATES.PerElementMatch element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("pointcutElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__POINTCUT_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getScopedInstantiationPointcutElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__POINTCUT_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__POINTCUT_ELEMENTS), element));
			}
			printCountingMap.put("pointcutElements", count - 1);
		}
	}
	public void print_smartadapters4MODERATES_PerElementMatch_1(smartadapters4MODERATES.PerElementMatch element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("adviceElements");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__ADVICE_ELEMENTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getInstantiationStrategyAdviceElementsReferenceResolver().deResolve((edap_relaxed.AspectModelElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__ADVICE_ELEMENTS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.Smartadapters4MODERATESPackage.PER_ELEMENT_MATCH__ADVICE_ELEMENTS), element));
			}
			printCountingMap.put("adviceElements", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_adaptations_SetCompositeState(smartadapters4MODERATES.adaptations.SetCompositeState element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET));
		printCountingMap.put("CompositeStateToSet", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE));
		printCountingMap.put("substate", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL));
		printCountingMap.put("initial", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("composite");
		// DEFINITION PART BEGINS (CsString)
		out.print("state");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("CompositeStateToSet");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetCompositeStateCompositeStateToSetReferenceResolver().deResolve((edap_relaxed.CompositeState) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__COMPOSITE_STATE_TO_SET), element));
			}
			printCountingMap.put("CompositeStateToSet", count - 1);
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
			print_smartadapters4MODERATES_adaptations_SetCompositeState_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_SetCompositeState_0(smartadapters4MODERATES.adaptations.SetCompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"initial"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"substate"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("substate");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("+=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("substate");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetCompositeStateSubstateReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE), element));
					}
					printCountingMap.put("substate", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_smartadapters4MODERATES_adaptations_SetCompositeState_0_0(element, localtab, out1, printCountingMap1);
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
			default:			// DEFINITION PART BEGINS (LineBreak)
			localtab += "	";
			out.println();
			out.print(localtab);
			// DEFINITION PART BEGINS (CsString)
			out.print("initial");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print("=");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
			count = printCountingMap.get("initial");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL));
				if (o != null) {
					smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetCompositeStateInitialReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__INITIAL), element));
				}
				printCountingMap.put("initial", count - 1);
			}
		}
	}
	public void print_smartadapters4MODERATES_adaptations_SetCompositeState_0_0(smartadapters4MODERATES.adaptations.SetCompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("substate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetCompositeStateSubstateReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_COMPOSITE_STATE__SUBSTATE), element));
			}
			printCountingMap.put("substate", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_adaptations_UnsetCompositeState(smartadapters4MODERATES.adaptations.UnsetCompositeState element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET));
		printCountingMap.put("CompositeStateToUnset", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE));
		printCountingMap.put("substate", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL));
		printCountingMap.put("initial", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("composite");
		// DEFINITION PART BEGINS (CsString)
		out.print("state");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("CompositeStateToUnset");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetCompositeStateCompositeStateToUnsetReferenceResolver().deResolve((edap_relaxed.CompositeState) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__COMPOSITE_STATE_TO_UNSET), element));
			}
			printCountingMap.put("CompositeStateToUnset", count - 1);
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
			print_smartadapters4MODERATES_adaptations_UnsetCompositeState_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_UnsetCompositeState_0(smartadapters4MODERATES.adaptations.UnsetCompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"initial"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"substate"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("substate");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("+=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("substate");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetCompositeStateSubstateReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE), element));
					}
					printCountingMap.put("substate", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_smartadapters4MODERATES_adaptations_UnsetCompositeState_0_0(element, localtab, out1, printCountingMap1);
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
			default:			// DEFINITION PART BEGINS (LineBreak)
			localtab += "	";
			out.println();
			out.print(localtab);
			// DEFINITION PART BEGINS (CsString)
			out.print("initial");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print("=");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
			count = printCountingMap.get("initial");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL));
				if (o != null) {
					smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetCompositeStateInitialReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__INITIAL), element));
				}
				printCountingMap.put("initial", count - 1);
			}
		}
	}
	public void print_smartadapters4MODERATES_adaptations_UnsetCompositeState_0_0(smartadapters4MODERATES.adaptations.UnsetCompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("substate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetCompositeStateSubstateReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_COMPOSITE_STATE__SUBSTATE), element));
			}
			printCountingMap.put("substate", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_adaptations_SetState(smartadapters4MODERATES.adaptations.SetState element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__STATE_TO_SET));
		printCountingMap.put("StateToSet", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("state");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("StateToSet");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__STATE_TO_SET));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetStateStateToSetReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__STATE_TO_SET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__STATE_TO_SET), element));
			}
			printCountingMap.put("StateToSet", count - 1);
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
			print_smartadapters4MODERATES_adaptations_SetState_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_SetState_0(smartadapters4MODERATES.adaptations.SetState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"outgoing"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"incoming"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"entry"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"exit"		));
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
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("incoming");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("+=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("incoming");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__INCOMING));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetStateIncomingReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__INCOMING)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__INCOMING), element));
					}
					printCountingMap.put("incoming", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_smartadapters4MODERATES_adaptations_SetState_0_1(element, localtab, out1, printCountingMap1);
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
			case 2:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("entry");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("entry");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__ENTRY));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetStateEntryReferenceResolver().deResolve((edap_relaxed.Action) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__ENTRY)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__ENTRY), element));
					}
					printCountingMap.put("entry", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("exit");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("exit");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__EXIT));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetStateExitReferenceResolver().deResolve((edap_relaxed.Action) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__EXIT)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__EXIT), element));
					}
					printCountingMap.put("exit", count - 1);
				}
			}
			break;
			case 4:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("properties");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("+=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("properties");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__PROPERTIES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetStatePropertiesReferenceResolver().deResolve((edap_relaxed.Property) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__PROPERTIES)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__PROPERTIES), element));
					}
					printCountingMap.put("properties", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_smartadapters4MODERATES_adaptations_SetState_0_2(element, localtab, out1, printCountingMap1);
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
			default:			boolean iterate = true;
			java.io.StringWriter sWriter = null;
			java.io.PrintWriter out1 = null;
			java.util.Map<String, Integer> printCountingMap1 = null;
			// DEFINITION PART BEGINS (LineBreak)
			localtab += "	";
			out.println();
			out.print(localtab);
			// DEFINITION PART BEGINS (CsString)
			out.print("outgoing");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print("+=");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
			count = printCountingMap.get("outgoing");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__OUTGOING));
				java.util.List<?> list = (java.util.List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetStateOutgoingReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__OUTGOING)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__OUTGOING), element));
				}
				printCountingMap.put("outgoing", count - 1);
			}
			// DEFINITION PART BEGINS (CompoundDefinition)
			iterate = true;
			while (iterate) {
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_smartadapters4MODERATES_adaptations_SetState_0_0(element, localtab, out1, printCountingMap1);
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
	}
	public void print_smartadapters4MODERATES_adaptations_SetState_0_0(smartadapters4MODERATES.adaptations.SetState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("outgoing");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__OUTGOING));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetStateOutgoingReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__OUTGOING)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__OUTGOING), element));
			}
			printCountingMap.put("outgoing", count - 1);
		}
	}
	public void print_smartadapters4MODERATES_adaptations_SetState_0_1(smartadapters4MODERATES.adaptations.SetState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("incoming");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__INCOMING));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetStateIncomingReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__INCOMING)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__INCOMING), element));
			}
			printCountingMap.put("incoming", count - 1);
		}
	}
	public void print_smartadapters4MODERATES_adaptations_SetState_0_2(smartadapters4MODERATES.adaptations.SetState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("properties");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__PROPERTIES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetStatePropertiesReferenceResolver().deResolve((edap_relaxed.Property) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__PROPERTIES)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_STATE__PROPERTIES), element));
			}
			printCountingMap.put("properties", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_adaptations_UnsetState(smartadapters4MODERATES.adaptations.UnsetState element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__STATE_TO_UNSET));
		printCountingMap.put("StateToUnset", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("state");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("StateToUnset");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__STATE_TO_UNSET));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetStateStateToUnsetReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__STATE_TO_UNSET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__STATE_TO_UNSET), element));
			}
			printCountingMap.put("StateToUnset", count - 1);
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
			print_smartadapters4MODERATES_adaptations_UnsetState_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_UnsetState_0(smartadapters4MODERATES.adaptations.UnsetState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"outgoing"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"incoming"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"entry"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"exit"		));
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
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("incoming");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("+=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("incoming");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__INCOMING));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetStateIncomingReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__INCOMING)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__INCOMING), element));
					}
					printCountingMap.put("incoming", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_smartadapters4MODERATES_adaptations_UnsetState_0_1(element, localtab, out1, printCountingMap1);
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
			case 2:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("entry");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("entry");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__ENTRY));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetStateEntryReferenceResolver().deResolve((edap_relaxed.Action) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__ENTRY)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__ENTRY), element));
					}
					printCountingMap.put("entry", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("exit");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("exit");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__EXIT));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetStateExitReferenceResolver().deResolve((edap_relaxed.Action) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__EXIT)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__EXIT), element));
					}
					printCountingMap.put("exit", count - 1);
				}
			}
			break;
			case 4:			{
				boolean iterate = true;
				java.io.StringWriter sWriter = null;
				java.io.PrintWriter out1 = null;
				java.util.Map<String, Integer> printCountingMap1 = null;
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("properties");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("+=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("properties");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__PROPERTIES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetStatePropertiesReferenceResolver().deResolve((edap_relaxed.Property) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__PROPERTIES)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__PROPERTIES), element));
					}
					printCountingMap.put("properties", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_smartadapters4MODERATES_adaptations_UnsetState_0_2(element, localtab, out1, printCountingMap1);
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
			default:			boolean iterate = true;
			java.io.StringWriter sWriter = null;
			java.io.PrintWriter out1 = null;
			java.util.Map<String, Integer> printCountingMap1 = null;
			// DEFINITION PART BEGINS (LineBreak)
			localtab += "	";
			out.println();
			out.print(localtab);
			// DEFINITION PART BEGINS (CsString)
			out.print("outgoing");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print("+=");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
			count = printCountingMap.get("outgoing");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__OUTGOING));
				java.util.List<?> list = (java.util.List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetStateOutgoingReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__OUTGOING)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__OUTGOING), element));
				}
				printCountingMap.put("outgoing", count - 1);
			}
			// DEFINITION PART BEGINS (CompoundDefinition)
			iterate = true;
			while (iterate) {
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_smartadapters4MODERATES_adaptations_UnsetState_0_0(element, localtab, out1, printCountingMap1);
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
	}
	public void print_smartadapters4MODERATES_adaptations_UnsetState_0_0(smartadapters4MODERATES.adaptations.UnsetState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("outgoing");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__OUTGOING));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetStateOutgoingReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__OUTGOING)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__OUTGOING), element));
			}
			printCountingMap.put("outgoing", count - 1);
		}
	}
	public void print_smartadapters4MODERATES_adaptations_UnsetState_0_1(smartadapters4MODERATES.adaptations.UnsetState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("incoming");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__INCOMING));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetStateIncomingReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__INCOMING)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__INCOMING), element));
			}
			printCountingMap.put("incoming", count - 1);
		}
	}
	public void print_smartadapters4MODERATES_adaptations_UnsetState_0_2(smartadapters4MODERATES.adaptations.UnsetState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("properties");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__PROPERTIES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetStatePropertiesReferenceResolver().deResolve((edap_relaxed.Property) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__PROPERTIES)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_STATE__PROPERTIES), element));
			}
			printCountingMap.put("properties", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_adaptations_SetTransition(smartadapters4MODERATES.adaptations.SetTransition element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET));
		printCountingMap.put("TransitionToSet", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__EVENT));
		printCountingMap.put("event", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__GUARD));
		printCountingMap.put("guard", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("transition");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("TransitionToSet");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetTransitionTransitionToSetReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__TRANSITION_TO_SET), element));
			}
			printCountingMap.put("TransitionToSet", count - 1);
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
			print_smartadapters4MODERATES_adaptations_SetTransition_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_SetTransition_0(smartadapters4MODERATES.adaptations.SetTransition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"event"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"guard"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"action"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"target"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"source"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("guard");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("guard");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__GUARD));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetTransitionGuardReferenceResolver().deResolve((edap_relaxed.Expression) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__GUARD)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__GUARD), element));
					}
					printCountingMap.put("guard", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("action");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("action");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__ACTION));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetTransitionActionReferenceResolver().deResolve((edap_relaxed.Action) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__ACTION)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__ACTION), element));
					}
					printCountingMap.put("action", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("target");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("target");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__TARGET));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetTransitionTargetReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__TARGET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__TARGET), element));
					}
					printCountingMap.put("target", count - 1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("source");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("source");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__SOURCE));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetTransitionSourceReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__SOURCE)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__SOURCE), element));
					}
					printCountingMap.put("source", count - 1);
				}
			}
			break;
			default:			boolean iterate = true;
			java.io.StringWriter sWriter = null;
			java.io.PrintWriter out1 = null;
			java.util.Map<String, Integer> printCountingMap1 = null;
			// DEFINITION PART BEGINS (LineBreak)
			localtab += "	";
			out.println();
			out.print(localtab);
			// DEFINITION PART BEGINS (CsString)
			out.print("event");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print("+=");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
			count = printCountingMap.get("event");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__EVENT));
				java.util.List<?> list = (java.util.List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetTransitionEventReferenceResolver().deResolve((edap_relaxed.Event) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__EVENT)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__EVENT), element));
				}
				printCountingMap.put("event", count - 1);
			}
			// DEFINITION PART BEGINS (CompoundDefinition)
			iterate = true;
			while (iterate) {
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_smartadapters4MODERATES_adaptations_SetTransition_0_0(element, localtab, out1, printCountingMap1);
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
	}
	public void print_smartadapters4MODERATES_adaptations_SetTransition_0_0(smartadapters4MODERATES.adaptations.SetTransition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("event");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__EVENT));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetTransitionEventReferenceResolver().deResolve((edap_relaxed.Event) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__EVENT)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_TRANSITION__EVENT), element));
			}
			printCountingMap.put("event", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_adaptations_UnsetTransition(smartadapters4MODERATES.adaptations.UnsetTransition element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(6);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__TRANSITION_TO_UNSET));
		printCountingMap.put("TransitionToUnset", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__EVENT));
		printCountingMap.put("event", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__GUARD));
		printCountingMap.put("guard", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("transition");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("TransitionToUnset");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__TRANSITION_TO_UNSET));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetTransitionTransitionToUnsetReferenceResolver().deResolve((edap_relaxed.Transition) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__TRANSITION_TO_UNSET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__TRANSITION_TO_UNSET), element));
			}
			printCountingMap.put("TransitionToUnset", count - 1);
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
			print_smartadapters4MODERATES_adaptations_UnsetTransition_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_UnsetTransition_0(smartadapters4MODERATES.adaptations.UnsetTransition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"event"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"guard"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"action"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"target"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"source"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("guard");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("guard");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__GUARD));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetTransitionGuardReferenceResolver().deResolve((edap_relaxed.Expression) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__GUARD)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__GUARD), element));
					}
					printCountingMap.put("guard", count - 1);
				}
			}
			break;
			case 2:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("action");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("action");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__ACTION));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetTransitionActionReferenceResolver().deResolve((edap_relaxed.Action) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__ACTION)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__ACTION), element));
					}
					printCountingMap.put("action", count - 1);
				}
			}
			break;
			case 3:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("target");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("target");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__TARGET));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetTransitionTargetReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__TARGET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__TARGET), element));
					}
					printCountingMap.put("target", count - 1);
				}
			}
			break;
			case 4:			{
				// DEFINITION PART BEGINS (LineBreak)
				localtab += "	";
				out.println();
				out.print(localtab);
				// DEFINITION PART BEGINS (CsString)
				out.print("source");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (CsString)
				out.print("=");
				// DEFINITION PART BEGINS (WhiteSpaces)
				out.print(" ");
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("source");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__SOURCE));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetTransitionSourceReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__SOURCE)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__SOURCE), element));
					}
					printCountingMap.put("source", count - 1);
				}
			}
			break;
			default:			boolean iterate = true;
			java.io.StringWriter sWriter = null;
			java.io.PrintWriter out1 = null;
			java.util.Map<String, Integer> printCountingMap1 = null;
			// DEFINITION PART BEGINS (LineBreak)
			localtab += "	";
			out.println();
			out.print(localtab);
			// DEFINITION PART BEGINS (CsString)
			out.print("event");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (CsString)
			out.print("+=");
			// DEFINITION PART BEGINS (WhiteSpaces)
			out.print(" ");
			// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
			count = printCountingMap.get("event");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__EVENT));
				java.util.List<?> list = (java.util.List<?>) o;
				int index = list.size() - count;
				if (index >= 0) {
					o = list.get(index);
				} else {
					o = null;
				}
				if (o != null) {
					smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
					resolver.setOptions(getOptions());
					out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetTransitionEventReferenceResolver().deResolve((edap_relaxed.Event) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__EVENT)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__EVENT), element));
				}
				printCountingMap.put("event", count - 1);
			}
			// DEFINITION PART BEGINS (CompoundDefinition)
			iterate = true;
			while (iterate) {
				sWriter = new java.io.StringWriter();
				out1 = new java.io.PrintWriter(sWriter);
				printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
				print_smartadapters4MODERATES_adaptations_UnsetTransition_0_0(element, localtab, out1, printCountingMap1);
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
	}
	public void print_smartadapters4MODERATES_adaptations_UnsetTransition_0_0(smartadapters4MODERATES.adaptations.UnsetTransition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("event");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__EVENT));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUnsetTransitionEventReferenceResolver().deResolve((edap_relaxed.Event) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__EVENT)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.UNSET_TRANSITION__EVENT), element));
			}
			printCountingMap.put("event", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_adaptations_SetAnnotatedElement(smartadapters4MODERATES.adaptations.SetAnnotatedElement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET));
		printCountingMap.put("AnnotatedElementToSet", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("element");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("AnnotatedElementToSet");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetAnnotatedElementAnnotatedElementToSetReferenceResolver().deResolve((edap_relaxed.AnnotatedElement) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATED_ELEMENT_TO_SET), element));
			}
			printCountingMap.put("AnnotatedElementToSet", count - 1);
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
			print_smartadapters4MODERATES_adaptations_SetAnnotatedElement_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_SetAnnotatedElement_0(smartadapters4MODERATES.adaptations.SetAnnotatedElement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
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
		out.print("annotations");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("+=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetAnnotatedElementAnnotationsReferenceResolver().deResolve((edap_relaxed.PlatformAnnotation) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS), element));
			}
			printCountingMap.put("annotations", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_smartadapters4MODERATES_adaptations_SetAnnotatedElement_0_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_SetAnnotatedElement_0_0(smartadapters4MODERATES.adaptations.SetAnnotatedElement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetAnnotatedElementAnnotationsReferenceResolver().deResolve((edap_relaxed.PlatformAnnotation) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ANNOTATED_ELEMENT__ANNOTATIONS), element));
			}
			printCountingMap.put("annotations", count - 1);
		}
	}
	
	public void print_smartadapters4MODERATES_adaptations_SetActionBlock(smartadapters4MODERATES.adaptations.SetActionBlock element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET));
		printCountingMap.put("blockToSet", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS));
		printCountingMap.put("actions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("block");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("blockToSet");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetActionBlockBlockToSetReferenceResolver().deResolve((edap_relaxed.ActionBlock) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__BLOCK_TO_SET), element));
			}
			printCountingMap.put("blockToSet", count - 1);
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
			print_smartadapters4MODERATES_adaptations_SetActionBlock_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_SetActionBlock_0(smartadapters4MODERATES.adaptations.SetActionBlock element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
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
		out.print("actions");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("+=");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("actions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetActionBlockActionsReferenceResolver().deResolve((edap_relaxed.Action) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS), element));
			}
			printCountingMap.put("actions", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_smartadapters4MODERATES_adaptations_SetActionBlock_0_0(element, localtab, out1, printCountingMap1);
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
	public void print_smartadapters4MODERATES_adaptations_SetActionBlock_0_0(smartadapters4MODERATES.adaptations.SetActionBlock element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("actions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSetActionBlockActionsReferenceResolver().deResolve((edap_relaxed.Action) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS)), element.eClass().getEStructuralFeature(smartadapters4MODERATES.adaptations.AdaptationsPackage.SET_ACTION_BLOCK__ACTIONS), element));
			}
			printCountingMap.put("actions", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_EdapModel(edap_relaxed.EdapModel element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EDAP_MODEL__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EDAP_MODEL__TYPES));
		printCountingMap.put("types", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EDAP_MODEL__IMPORTS));
		printCountingMap.put("imports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("model");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_005frelaxed_EdapModel_0(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_EdapModel_1(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_EdapModel_0(edap_relaxed.EdapModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EDAP_MODEL__IMPORTS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEdapModelImportsReferenceResolver().deResolve((edap_relaxed.EdapModel) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EDAP_MODEL__IMPORTS)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EDAP_MODEL__IMPORTS), element));
			}
			printCountingMap.put("imports", count - 1);
		}
	}
	public void print_edap_005frelaxed_EdapModel_1(edap_relaxed.EdapModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edap_005frelaxed_EdapModel_1_0(element, localtab, out, printCountingMap);
	}
	public void print_edap_005frelaxed_EdapModel_1_0(edap_relaxed.EdapModel element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("types");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EDAP_MODEL__TYPES));
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
	
	public void print_edap_005frelaxed_Message(edap_relaxed.Message element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__ALLOW_MULTICAST));
		printCountingMap.put("allowMulticast", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Message_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Message_1(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Message_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Message_3(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Message_4(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Message_0(edap_relaxed.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("allowMulticast");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__ALLOW_MULTICAST));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_MULTICAST");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__ALLOW_MULTICAST), element));
			}
			printCountingMap.put("allowMulticast", count - 1);
		}
	}
	public void print_edap_005frelaxed_Message_1(edap_relaxed.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_Message_2(edap_relaxed.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Message_3(edap_relaxed.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__PARAMETERS));
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
			print_edap_005frelaxed_Message_3_0(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Message_3_0(edap_relaxed.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__PARAMETERS));
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
	public void print_edap_005frelaxed_Message_4(edap_relaxed.Message element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.MESSAGE__ANNOTATIONS));
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
	
	public void print_edap_005frelaxed_Device(edap_relaxed.Device element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(12);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__COMPOSITE_COMPONENT));
		printCountingMap.put("compositeComponent", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__PARTIAL));
		printCountingMap.put("partial", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SINGLETON));
		printCountingMap.put("singleton", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__RECEIVES));
		printCountingMap.put("receives", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SENDS));
		printCountingMap.put("sends", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__MESSAGES));
		printCountingMap.put("messages", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__CONNECTORS));
		printCountingMap.put("connectors", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__PORTS));
		printCountingMap.put("ports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Device_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Device_1(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Device_2(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Device_3(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Device_4(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Device_5(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Device_0(edap_relaxed.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("partial");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__PARTIAL));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_ASPECT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__PARTIAL), element));
			}
			printCountingMap.put("partial", count - 1);
		}
	}
	public void print_edap_005frelaxed_Device_1(edap_relaxed.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("singleton");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SINGLETON));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_SINGLETON");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SINGLETON), element));
			}
			printCountingMap.put("singleton", count - 1);
		}
	}
	public void print_edap_005frelaxed_Device_2(edap_relaxed.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_Device_3(edap_relaxed.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Device_4(edap_relaxed.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__ANNOTATIONS));
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
	public void print_edap_005frelaxed_Device_5(edap_relaxed.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"messages"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"receives"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"sends"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"compositeComponent"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("properties");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__PROPERTIES));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__RECEIVES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__RECEIVES)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__RECEIVES), element));
					}
					printCountingMap.put("receives", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_005frelaxed_Device_5_0(element, localtab, out1, printCountingMap1);
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SENDS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SENDS)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SENDS), element));
					}
					printCountingMap.put("sends", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_005frelaxed_Device_5_1(element, localtab, out1, printCountingMap1);
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
				print_edap_005frelaxed_Device_5_2(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("messages");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__MESSAGES));
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
	public void print_edap_005frelaxed_Device_5_0(edap_relaxed.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("receives");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__RECEIVES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__RECEIVES)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__RECEIVES), element));
			}
			printCountingMap.put("receives", count - 1);
		}
	}
	public void print_edap_005frelaxed_Device_5_1(edap_relaxed.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("sends");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SENDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SENDS)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__SENDS), element));
			}
			printCountingMap.put("sends", count - 1);
		}
	}
	public void print_edap_005frelaxed_Device_5_2(edap_relaxed.Device element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("compositeComponent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DEVICE__COMPOSITE_COMPONENT));
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
	
	public void print_edap_005frelaxed_SoftwareComponent(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(13);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__COMPOSITE_COMPONENT));
		printCountingMap.put("compositeComponent", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__PARTIAL));
		printCountingMap.put("partial", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SINGLETON));
		printCountingMap.put("singleton", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__RECEIVES));
		printCountingMap.put("receives", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SENDS));
		printCountingMap.put("sends", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__MESSAGES));
		printCountingMap.put("messages", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__CONNECTORS));
		printCountingMap.put("connectors", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__PORTS));
		printCountingMap.put("ports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__BEHAVIOUR));
		printCountingMap.put("behaviour", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_SoftwareComponent_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_SoftwareComponent_1(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_SoftwareComponent_2(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_SoftwareComponent_3(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_SoftwareComponent_4(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_SoftwareComponent_5(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_SoftwareComponent_6(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_SoftwareComponent_0(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("partial");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__PARTIAL));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_ASPECT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__PARTIAL), element));
			}
			printCountingMap.put("partial", count - 1);
		}
	}
	public void print_edap_005frelaxed_SoftwareComponent_1(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("singleton");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SINGLETON));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_SINGLETON");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SINGLETON), element));
			}
			printCountingMap.put("singleton", count - 1);
		}
	}
	public void print_edap_005frelaxed_SoftwareComponent_2(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_SoftwareComponent_3(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_SoftwareComponent_4(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__ANNOTATIONS));
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
	public void print_edap_005frelaxed_SoftwareComponent_5(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"ports"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"connectors"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"messages"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"receives"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"sends"		));
		if (tempMatchCount > matches) {
			alt = 5;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"compositeComponent"		));
		if (tempMatchCount > matches) {
			alt = 6;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("connectors");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__CONNECTORS));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__MESSAGES));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__PROPERTIES));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__RECEIVES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__RECEIVES)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__RECEIVES), element));
					}
					printCountingMap.put("receives", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_005frelaxed_SoftwareComponent_5_0(element, localtab, out1, printCountingMap1);
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SENDS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SENDS)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SENDS), element));
					}
					printCountingMap.put("sends", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_005frelaxed_SoftwareComponent_5_1(element, localtab, out1, printCountingMap1);
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
				print_edap_005frelaxed_SoftwareComponent_5_2(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("ports");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__PORTS));
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
	public void print_edap_005frelaxed_SoftwareComponent_5_0(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("receives");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__RECEIVES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__RECEIVES)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__RECEIVES), element));
			}
			printCountingMap.put("receives", count - 1);
		}
	}
	public void print_edap_005frelaxed_SoftwareComponent_5_1(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("sends");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SENDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SENDS)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__SENDS), element));
			}
			printCountingMap.put("sends", count - 1);
		}
	}
	public void print_edap_005frelaxed_SoftwareComponent_5_2(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("compositeComponent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__COMPOSITE_COMPONENT));
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
	public void print_edap_005frelaxed_SoftwareComponent_6(edap_relaxed.SoftwareComponent element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("behaviour");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SOFTWARE_COMPONENT__BEHAVIOUR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("behaviour", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_Simulator(edap_relaxed.Simulator element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(14);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__COMPOSITE_COMPONENT));
		printCountingMap.put("compositeComponent", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__PARTIAL));
		printCountingMap.put("partial", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__SINGLETON));
		printCountingMap.put("singleton", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__RECEIVES));
		printCountingMap.put("receives", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__SENDS));
		printCountingMap.put("sends", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__MESSAGES));
		printCountingMap.put("messages", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__CONNECTORS));
		printCountingMap.put("connectors", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__PORTS));
		printCountingMap.put("ports", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__BEHAVIOUR));
		printCountingMap.put("behaviour", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__DEVICE));
		printCountingMap.put("device", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("simulator");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Simulator_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Simulator_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("for");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("device");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__DEVICE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSimulatorDeviceReferenceResolver().deResolve((edap_relaxed.Device) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__DEVICE)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__DEVICE), element));
			}
			printCountingMap.put("device", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_005frelaxed_Simulator_2(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Simulator_3(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Simulator_4(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (LineBreak)
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (CsString)
		out.print("}");
	}
	public void print_edap_005frelaxed_Simulator_0(edap_relaxed.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_Simulator_1(edap_relaxed.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Simulator_2(edap_relaxed.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__ANNOTATIONS));
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
	public void print_edap_005frelaxed_Simulator_3(edap_relaxed.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"messages"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"properties"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"receives"		));
		if (tempMatchCount > matches) {
			alt = 2;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"sends"		));
		if (tempMatchCount > matches) {
			alt = 3;
			matches = tempMatchCount;
		}
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"compositeComponent"		));
		if (tempMatchCount > matches) {
			alt = 4;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (Containment)
				count = printCountingMap.get("properties");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__PROPERTIES));
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__RECEIVES));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__RECEIVES)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__RECEIVES), element));
					}
					printCountingMap.put("receives", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_005frelaxed_Simulator_3_0(element, localtab, out1, printCountingMap1);
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
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__SENDS));
					java.util.List<?> list = (java.util.List<?>) o;
					int index = list.size() - count;
					if (index >= 0) {
						o = list.get(index);
					} else {
						o = null;
					}
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__SENDS)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__SENDS), element));
					}
					printCountingMap.put("sends", count - 1);
				}
				// DEFINITION PART BEGINS (CompoundDefinition)
				iterate = true;
				while (iterate) {
					sWriter = new java.io.StringWriter();
					out1 = new java.io.PrintWriter(sWriter);
					printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
					print_edap_005frelaxed_Simulator_3_1(element, localtab, out1, printCountingMap1);
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
				print_edap_005frelaxed_Simulator_3_2(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("messages");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__MESSAGES));
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
	public void print_edap_005frelaxed_Simulator_3_0(edap_relaxed.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("receives");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__RECEIVES));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__RECEIVES)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__RECEIVES), element));
			}
			printCountingMap.put("receives", count - 1);
		}
	}
	public void print_edap_005frelaxed_Simulator_3_1(edap_relaxed.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("sends");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__SENDS));
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			if (index >= 0) {
				o = list.get(index);
			} else {
				o = null;
			}
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__SENDS)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__SENDS), element));
			}
			printCountingMap.put("sends", count - 1);
		}
	}
	public void print_edap_005frelaxed_Simulator_3_2(edap_relaxed.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("compositeComponent");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__COMPOSITE_COMPONENT));
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
	public void print_edap_005frelaxed_Simulator_4(edap_relaxed.Simulator element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("behaviour");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.SIMULATOR__BEHAVIOUR));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("behaviour", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_Property(edap_relaxed.Property element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__CHANGEABLE));
		printCountingMap.put("changeable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__LOWER_BOUND));
		printCountingMap.put("lowerBound", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__UPPER_BOUND));
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
		print_edap_005frelaxed_Property_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Property_1(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Property_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__TYPE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyTypeReferenceResolver().deResolve((edap_relaxed.Type) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__TYPE)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__TYPE), element));
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Property_3(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Property_4(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Property_0(edap_relaxed.Property element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("changeable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__CHANGEABLE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_READONLY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__CHANGEABLE), element));
			}
			printCountingMap.put("changeable", count - 1);
		}
	}
	public void print_edap_005frelaxed_Property_1(edap_relaxed.Property element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_Property_2(edap_relaxed.Property element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Property_3(edap_relaxed.Property element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("lowerBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__LOWER_BOUND));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("MULTIPLICITY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__LOWER_BOUND), element));
			}
			printCountingMap.put("lowerBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("..");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("upperBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__UPPER_BOUND));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("MULTIPLICITY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__UPPER_BOUND), element));
			}
			printCountingMap.put("upperBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
	}
	public void print_edap_005frelaxed_Property_4(edap_relaxed.Property element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY__ANNOTATIONS));
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
	
	public void print_edap_005frelaxed_Dictionary(edap_relaxed.Dictionary element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__CHANGEABLE));
		printCountingMap.put("changeable", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__LOWER_BOUND));
		printCountingMap.put("lowerBound", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__UPPER_BOUND));
		printCountingMap.put("upperBound", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__INDEX_TYPE));
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
		print_edap_005frelaxed_Dictionary_0(element, localtab, out1, printCountingMap1);
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Dictionary_1(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Dictionary_2(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("indexType");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__INDEX_TYPE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getDictionaryIndexTypeReferenceResolver().deResolve((edap_relaxed.Type) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__INDEX_TYPE)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__INDEX_TYPE), element));
			}
			printCountingMap.put("indexType", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("type");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__TYPE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyTypeReferenceResolver().deResolve((edap_relaxed.Type) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__TYPE)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__TYPE), element));
			}
			printCountingMap.put("type", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Dictionary_3(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Dictionary_4(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Dictionary_0(edap_relaxed.Dictionary element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("changeable");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__CHANGEABLE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("T_READONLY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__CHANGEABLE), element));
			}
			printCountingMap.put("changeable", count - 1);
		}
	}
	public void print_edap_005frelaxed_Dictionary_1(edap_relaxed.Dictionary element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_Dictionary_2(edap_relaxed.Dictionary element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Dictionary_3(edap_relaxed.Dictionary element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("lowerBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__LOWER_BOUND));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("MULTIPLICITY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__LOWER_BOUND), element));
			}
			printCountingMap.put("lowerBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("..");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("upperBound");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__UPPER_BOUND));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("MULTIPLICITY");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__UPPER_BOUND), element));
			}
			printCountingMap.put("upperBound", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
	}
	public void print_edap_005frelaxed_Dictionary_4(edap_relaxed.Dictionary element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY__ANNOTATIONS));
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
	
	public void print_edap_005frelaxed_Parameter(edap_relaxed.Parameter element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PARAMETER__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PARAMETER__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PARAMETER__TYPE));
		printCountingMap.put("type", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PARAMETER__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PARAMETER__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(":");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edap_005frelaxed_Parameter_0(element, localtab, out, printCountingMap);
	}
	public void print_edap_005frelaxed_Parameter_0(edap_relaxed.Parameter element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"type"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("type");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PARAMETER__TYPE));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getParameterTypeReferenceResolver().deResolve((edap_relaxed.Type) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PARAMETER__TYPE)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PARAMETER__TYPE), element));
					}
					printCountingMap.put("type", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("?");
		}
	}
	
	public void print_edap_005frelaxed_PrimitiveType(edap_relaxed.PrimitiveType element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PRIMITIVE_TYPE__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PRIMITIVE_TYPE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PRIMITIVE_TYPE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("datatype");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_PrimitiveType_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_PrimitiveType_1(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_PrimitiveType_2(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_PrimitiveType_0(edap_relaxed.PrimitiveType element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PRIMITIVE_TYPE__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PRIMITIVE_TYPE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_PrimitiveType_1(edap_relaxed.PrimitiveType element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PRIMITIVE_TYPE__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PRIMITIVE_TYPE__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_PrimitiveType_2(edap_relaxed.PrimitiveType element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PRIMITIVE_TYPE__ANNOTATIONS));
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
	
	public void print_edap_005frelaxed_Enumeration(edap_relaxed.Enumeration element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__LITERALS));
		printCountingMap.put("literals", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("enumeration");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Enumeration_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Enumeration_1(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Enumeration_2(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Enumeration_3(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Enumeration_0(edap_relaxed.Enumeration element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_Enumeration_1(edap_relaxed.Enumeration element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Enumeration_2(edap_relaxed.Enumeration element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__ANNOTATIONS));
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
	public void print_edap_005frelaxed_Enumeration_3(edap_relaxed.Enumeration element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("literals");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION__LITERALS));
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
	
	public void print_edap_005frelaxed_EnumerationLiteral(edap_relaxed.EnumerationLiteral element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION_LITERAL__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION_LITERAL__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION_LITERAL__ANNOTATIONS));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION_LITERAL__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION_LITERAL__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_005frelaxed_EnumerationLiteral_0(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_EnumerationLiteral_0(edap_relaxed.EnumerationLiteral element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ENUMERATION_LITERAL__ANNOTATIONS));
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
	
	public void print_edap_005frelaxed_PlatformAnnotation(edap_relaxed.PlatformAnnotation element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PLATFORM_ANNOTATION__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PLATFORM_ANNOTATION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PLATFORM_ANNOTATION__VALUE));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PLATFORM_ANNOTATION__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("ANNOTATION");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PLATFORM_ANNOTATION__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("value");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PLATFORM_ANNOTATION__VALUE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PLATFORM_ANNOTATION__VALUE), element));
			}
			printCountingMap.put("value", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_StateMachine(edap_relaxed.StateMachine element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(10);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__SUBSTATE));
		printCountingMap.put("substate", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__INITIAL));
		printCountingMap.put("initial", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("statechart");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_StateMachine_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_StateMachine_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_StateMachine_2(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_StateMachine_3(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_StateMachine_4(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_StateMachine_5(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_StateMachine_6(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_StateMachine_7(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_StateMachine_0(edap_relaxed.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_StateMachine_1(edap_relaxed.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_StateMachine_2(edap_relaxed.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("init");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("initial");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__INITIAL));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeStateInitialReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__INITIAL)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__INITIAL), element));
			}
			printCountingMap.put("initial", count - 1);
		}
	}
	public void print_edap_005frelaxed_StateMachine_3(edap_relaxed.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__ANNOTATIONS));
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
	public void print_edap_005frelaxed_StateMachine_4(edap_relaxed.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("properties");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__PROPERTIES));
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
	public void print_edap_005frelaxed_StateMachine_5(edap_relaxed.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__ENTRY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("entry", count - 1);
		}
	}
	public void print_edap_005frelaxed_StateMachine_6(edap_relaxed.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__EXIT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("exit", count - 1);
		}
	}
	public void print_edap_005frelaxed_StateMachine_7(edap_relaxed.StateMachine element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("substate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE_MACHINE__SUBSTATE));
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
	
	public void print_edap_005frelaxed_State(edap_relaxed.State element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("state");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_State_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_State_1(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_State_2(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_State_3(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_State_4(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_State_5(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_State_6(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_State_0(edap_relaxed.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_State_1(edap_relaxed.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_State_2(edap_relaxed.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__ANNOTATIONS));
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
	public void print_edap_005frelaxed_State_3(edap_relaxed.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("properties");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__PROPERTIES));
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
	public void print_edap_005frelaxed_State_4(edap_relaxed.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__ENTRY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("entry", count - 1);
		}
	}
	public void print_edap_005frelaxed_State_5(edap_relaxed.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__EXIT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("exit", count - 1);
		}
	}
	public void print_edap_005frelaxed_State_6(edap_relaxed.State element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("outgoing");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.STATE__OUTGOING));
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
	
	public void print_edap_005frelaxed_CompositeState(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(10);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__OUTGOING));
		printCountingMap.put("outgoing", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__INCOMING));
		printCountingMap.put("incoming", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__ENTRY));
		printCountingMap.put("entry", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__EXIT));
		printCountingMap.put("exit", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__PROPERTIES));
		printCountingMap.put("properties", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__SUBSTATE));
		printCountingMap.put("substate", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__INITIAL));
		printCountingMap.put("initial", temp == null ? 0 : 1);
		// print collected hidden tokens
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_CompositeState_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_CompositeState_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_CompositeState_2(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_CompositeState_3(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_CompositeState_4(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_CompositeState_5(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_CompositeState_6(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_CompositeState_7(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_CompositeState_0(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_CompositeState_1(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_CompositeState_2(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("init");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("initial");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__INITIAL));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeStateInitialReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__INITIAL)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__INITIAL), element));
			}
			printCountingMap.put("initial", count - 1);
		}
	}
	public void print_edap_005frelaxed_CompositeState_3(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__ANNOTATIONS));
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
	public void print_edap_005frelaxed_CompositeState_4(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("properties");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__PROPERTIES));
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
	public void print_edap_005frelaxed_CompositeState_5(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__ENTRY));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("entry", count - 1);
		}
	}
	public void print_edap_005frelaxed_CompositeState_6(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__EXIT));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("exit", count - 1);
		}
	}
	public void print_edap_005frelaxed_CompositeState_7(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		int alt = -1;
		alt=0;
		int matches=		matchCount(printCountingMap, java.util.Arrays.asList(		"outgoing"		));
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"substate"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (CompoundDefinition)
				print_edap_005frelaxed_CompositeState_7_0(element, localtab, out, printCountingMap);
			}
			break;
			default:			// DEFINITION PART BEGINS (Containment)
			count = printCountingMap.get("outgoing");
			if (count > 0) {
				Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__OUTGOING));
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
	public void print_edap_005frelaxed_CompositeState_7_0(edap_relaxed.CompositeState element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("substate");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPOSITE_STATE__SUBSTATE));
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
	
	public void print_edap_005frelaxed_ActionBlock(edap_relaxed.ActionBlock element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ACTION_BLOCK__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ACTION_BLOCK__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ACTION_BLOCK__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ACTION_BLOCK__ACTIONS));
		printCountingMap.put("actions", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_ActionBlock_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("{");
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_005frelaxed_ActionBlock_1(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_ActionBlock_0(edap_relaxed.ActionBlock element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ACTION_BLOCK__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ACTION_BLOCK__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_ActionBlock_1(edap_relaxed.ActionBlock element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (LineBreak)
		localtab += "	";
		out.println();
		out.print(localtab);
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("actions");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.ACTION_BLOCK__ACTIONS));
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
	
	public void print_edap_005frelaxed_ExternStatement(edap_relaxed.ExternStatement element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_STATEMENT__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_STATEMENT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_STATEMENT__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_STATEMENT__STATEMENT));
		printCountingMap.put("statement", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_ExternStatement_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("statement");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_STATEMENT__STATEMENT));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_EXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_STATEMENT__STATEMENT), element));
			}
			printCountingMap.put("statement", count - 1);
		}
	}
	public void print_edap_005frelaxed_ExternStatement_0(edap_relaxed.ExternStatement element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_STATEMENT__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_STATEMENT__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_PropertyAssignment(edap_relaxed.PropertyAssignment element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(5);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__PROPERTY));
		printCountingMap.put("property", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_PropertyAssignment_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("set");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("property");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__PROPERTY));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyAssignmentPropertyReferenceResolver().deResolve((edap_relaxed.Property) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__PROPERTY)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__PROPERTY), element));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__EXPRESSION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("expression", count - 1);
		}
	}
	public void print_edap_005frelaxed_PropertyAssignment_0(edap_relaxed.PropertyAssignment element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_ASSIGNMENT__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_ExternExpression(edap_relaxed.ExternExpression element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_EXPRESSION__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_EXPRESSION__EXPRESSION));
		printCountingMap.put("expression", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_ExternExpression_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("expression");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_EXPRESSION__EXPRESSION));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("STRING_EXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_EXPRESSION__EXPRESSION), element));
			}
			printCountingMap.put("expression", count - 1);
		}
	}
	public void print_edap_005frelaxed_ExternExpression_0(edap_relaxed.ExternExpression element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_EXPRESSION__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EXTERN_EXPRESSION__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_ComponentReference(edap_relaxed.ComponentReference element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPONENT_REFERENCE__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT));
		printCountingMap.put("component", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS));
		printCountingMap.put("propertyNavigations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		// print collected hidden tokens
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("component");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReferenceComponentReferenceResolver().deResolve((edap_relaxed.Component) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPONENT_REFERENCE__COMPONENT), element));
			}
			printCountingMap.put("component", count - 1);
		}
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_005frelaxed_ComponentReference_0(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_ComponentReference_0(edap_relaxed.ComponentReference element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("propertyNavigations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS));
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
			printCountingMap.put("propertyNavigations", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_EventReference(edap_relaxed.EventReference element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__MSG_REF));
		printCountingMap.put("msgRef", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__PARAM_REF));
		printCountingMap.put("paramRef", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_EventReference_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("eventref");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("msgRef");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__MSG_REF));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEventReferenceMsgRefReferenceResolver().deResolve((edap_relaxed.ReceiveMessage) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__MSG_REF)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__MSG_REF), element));
			}
			printCountingMap.put("msgRef", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("paramRef");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__PARAM_REF));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEventReferenceParamRefReferenceResolver().deResolve((edap_relaxed.Parameter) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__PARAM_REF)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__PARAM_REF), element));
			}
			printCountingMap.put("paramRef", count - 1);
		}
	}
	public void print_edap_005frelaxed_EventReference_0(edap_relaxed.EventReference element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.EVENT_REFERENCE__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_PropertyNavigation(edap_relaxed.PropertyNavigation element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_NAVIGATION__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_NAVIGATION__PROPERTY));
		printCountingMap.put("property", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("property");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_NAVIGATION__PROPERTY));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyNavigationPropertyReferenceResolver().deResolve((edap_relaxed.Property) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_NAVIGATION__PROPERTY)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PROPERTY_NAVIGATION__PROPERTY), element));
			}
			printCountingMap.put("property", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_DictionaryNavigation(edap_relaxed.DictionaryNavigation element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY_NAVIGATION__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY_NAVIGATION__PROPERTY));
		printCountingMap.put("property", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY_NAVIGATION__INDEX));
		printCountingMap.put("index", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("property");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY_NAVIGATION__PROPERTY));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyNavigationPropertyReferenceResolver().deResolve((edap_relaxed.Property) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY_NAVIGATION__PROPERTY)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY_NAVIGATION__PROPERTY), element));
			}
			printCountingMap.put("property", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("[");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("index");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.DICTIONARY_NAVIGATION__INDEX));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("index", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("]");
	}
	
	public void print_edap_005frelaxed_Unicast(edap_relaxed.Unicast element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__MESSAGE));
		printCountingMap.put("message", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__PORT));
		printCountingMap.put("port", temp == null ? 0 : 1);
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
		print_edap_005frelaxed_Unicast_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("send");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("message");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__MESSAGE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSendActionMessageReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__MESSAGE)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__MESSAGE), element));
			}
			printCountingMap.put("message", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Unicast_1(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Unicast_2(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Unicast_3(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Unicast_0(edap_relaxed.Unicast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Unicast_1(edap_relaxed.Unicast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__PARAMETERS));
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
			print_edap_005frelaxed_Unicast_1_0(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Unicast_1_0(edap_relaxed.Unicast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__PARAMETERS));
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
	public void print_edap_005frelaxed_Unicast_2(edap_relaxed.Unicast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("port");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("port");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__PORT));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSendActionPortReferenceResolver().deResolve((edap_relaxed.Port) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__PORT)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__PORT), element));
			}
			printCountingMap.put("port", count - 1);
		}
	}
	public void print_edap_005frelaxed_Unicast_3(edap_relaxed.Unicast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.UNICAST__ANNOTATIONS));
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
	
	public void print_edap_005frelaxed_Broadcast(edap_relaxed.Broadcast element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(7);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__PARAMETERS));
		printCountingMap.put("parameters", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__MESSAGE));
		printCountingMap.put("message", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__PORT));
		printCountingMap.put("port", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Broadcast_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("broadcast");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("target");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__TARGET));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("target", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(".");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("message");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__MESSAGE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSendActionMessageReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__MESSAGE)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__MESSAGE), element));
			}
			printCountingMap.put("message", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Broadcast_1(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Broadcast_0(edap_relaxed.Broadcast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Broadcast_1(edap_relaxed.Broadcast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__PARAMETERS));
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
			print_edap_005frelaxed_Broadcast_1_0(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Broadcast_1_0(edap_relaxed.Broadcast element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("parameters");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.BROADCAST__PARAMETERS));
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
	
	public void print_edap_005frelaxed_Transition(edap_relaxed.Transition element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__EVENT));
		printCountingMap.put("event", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__GUARD));
		printCountingMap.put("guard", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__ACTION));
		printCountingMap.put("action", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__TARGET));
		printCountingMap.put("target", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__SOURCE));
		printCountingMap.put("source", temp == null ? 0 : 1);
		// print collected hidden tokens
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
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Transition_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Transition_1(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CsString)
		out.print("->");
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (CompoundDefinition)
		print_edap_005frelaxed_Transition_2(element, localtab, out, printCountingMap);
		// DEFINITION PART BEGINS (CompoundDefinition)
		iterate = true;
		while (iterate) {
			sWriter = new java.io.StringWriter();
			out1 = new java.io.PrintWriter(sWriter);
			printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
			print_edap_005frelaxed_Transition_3(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Transition_4(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Transition_5(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Transition_6(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Transition_0(edap_relaxed.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_Transition_1(edap_relaxed.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Transition_2(edap_relaxed.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		int alt = -1;
		alt=0;
		int matches=		0;
		int tempMatchCount;
		tempMatchCount=		matchCount(printCountingMap, java.util.Arrays.asList(		"target"		));
		if (tempMatchCount > matches) {
			alt = 1;
			matches = tempMatchCount;
		}
		switch(alt) {
			case 1:			{
				// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
				count = printCountingMap.get("target");
				if (count > 0) {
					Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__TARGET));
					if (o != null) {
						smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
						resolver.setOptions(getOptions());
						out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTransitionTargetReferenceResolver().deResolve((edap_relaxed.State) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__TARGET)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__TARGET), element));
					}
					printCountingMap.put("target", count - 1);
				}
			}
			break;
			default:			// DEFINITION PART BEGINS (CsString)
			out.print("?");
		}
	}
	public void print_edap_005frelaxed_Transition_3(edap_relaxed.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__ANNOTATIONS));
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
	public void print_edap_005frelaxed_Transition_4(edap_relaxed.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__EVENT));
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
	public void print_edap_005frelaxed_Transition_5(edap_relaxed.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__GUARD));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("guard", count - 1);
		}
	}
	public void print_edap_005frelaxed_Transition_6(edap_relaxed.Transition element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.TRANSITION__ACTION));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("action", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_ReceiveMessage(edap_relaxed.ReceiveMessage element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(3);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.RECEIVE_MESSAGE__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.RECEIVE_MESSAGE__DEVICE));
		printCountingMap.put("device", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.RECEIVE_MESSAGE__MESSAGE));
		printCountingMap.put("message", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("device");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.RECEIVE_MESSAGE__DEVICE));
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
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.RECEIVE_MESSAGE__MESSAGE));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getReceiveMessageMessageReferenceResolver().deResolve((edap_relaxed.Message) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.RECEIVE_MESSAGE__MESSAGE)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.RECEIVE_MESSAGE__MESSAGE), element));
			}
			printCountingMap.put("message", count - 1);
		}
	}
	
	public void print_edap_005frelaxed_Connector(edap_relaxed.Connector element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(8);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PORT1));
		printCountingMap.put("port1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PORT2));
		printCountingMap.put("port2", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PROP1));
		printCountingMap.put("prop1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PROP2));
		printCountingMap.put("prop2", temp == null ? 0 : 1);
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
		print_edap_005frelaxed_Connector_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("connector");
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("port1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PORT1));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectorPort1ReferenceResolver().deResolve((edap_relaxed.Port) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PORT1)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PORT1), element));
			}
			printCountingMap.put("port1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(",");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("port2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PORT2));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectorPort2ReferenceResolver().deResolve((edap_relaxed.Port) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PORT2)), element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__PORT2), element));
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
			print_edap_005frelaxed_Connector_1(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Connector_0(edap_relaxed.Connector element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Connector_1(edap_relaxed.Connector element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CONNECTOR__ANNOTATIONS));
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
	
	public void print_edap_005frelaxed_Port(edap_relaxed.Port element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PORT__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PORT__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PORT__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PORT__OWNER));
		printCountingMap.put("owner", temp == null ? 0 : 1);
		// print collected hidden tokens
		boolean iterate = true;
		java.io.StringWriter sWriter = null;
		java.io.PrintWriter out1 = null;
		java.util.Map<String, Integer> printCountingMap1 = null;
		// DEFINITION PART BEGINS (CsString)
		out.print("port");
		// DEFINITION PART BEGINS (CompoundDefinition)
		sWriter = new java.io.StringWriter();
		out1 = new java.io.PrintWriter(sWriter);
		printCountingMap1 = new java.util.LinkedHashMap<String, Integer>(printCountingMap);
		print_edap_005frelaxed_Port_0(element, localtab, out1, printCountingMap1);
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
		print_edap_005frelaxed_Port_1(element, localtab, out1, printCountingMap1);
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
			print_edap_005frelaxed_Port_2(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_Port_0(edap_relaxed.Port element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("name");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PORT__NAME));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PORT__NAME), element));
			}
			printCountingMap.put("name", count - 1);
		}
	}
	public void print_edap_005frelaxed_Port_1(edap_relaxed.Port element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PORT__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PORT__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_Port_2(edap_relaxed.Port element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.PORT__ANNOTATIONS));
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
	
	public void print_edap_005frelaxed_CreateAction(edap_relaxed.CreateAction element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(4);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CREATE_ACTION__ASPECT_ID));
		printCountingMap.put("aspectID", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CREATE_ACTION__NAME));
		printCountingMap.put("name", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CREATE_ACTION__ANNOTATIONS));
		printCountingMap.put("annotations", temp == null ? 0 : ((java.util.Collection<?>) temp).size());
		temp = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CREATE_ACTION__REF));
		printCountingMap.put("ref", temp == null ? 0 : 1);
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
		print_edap_005frelaxed_CreateAction_0(element, localtab, out1, printCountingMap1);
		if (printCountingMap.equals(printCountingMap1)) {
			out1.close();
		} else {
			out1.flush();
			out1.close();
			out.print(sWriter.toString());
			printCountingMap.putAll(printCountingMap1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("create");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("ref");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CREATE_ACTION__REF));
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
			print_edap_005frelaxed_CreateAction_1(element, localtab, out1, printCountingMap1);
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
	public void print_edap_005frelaxed_CreateAction_0(edap_relaxed.CreateAction element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		int count;
		// DEFINITION PART BEGINS (WhiteSpaces)
		out.print(" ");
		// DEFINITION PART BEGINS (PlaceholderUsingSpecifiedToken)
		count = printCountingMap.get("aspectID");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CREATE_ACTION__ASPECT_ID));
			if (o != null) {
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver resolver = tokenResolverFactory.createTokenResolver("TXTID");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve((Object) o, element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CREATE_ACTION__ASPECT_ID), element));
			}
			printCountingMap.put("aspectID", count - 1);
		}
	}
	public void print_edap_005frelaxed_CreateAction_1(edap_relaxed.CreateAction element, String outertab, java.io.PrintWriter out, java.util.Map<String, Integer> printCountingMap){
		String localtab = outertab;
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("annotations");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(edap_relaxed.Edap_relaxedPackage.CREATE_ACTION__ANNOTATIONS));
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
	
}
