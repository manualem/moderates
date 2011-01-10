/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package smartadapters4MODERATES.resource.edap_aspect.mopp;

public class Edap_aspectPrinter2 implements smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextPrinter {
	
	private class PrintToken {
		
		private String text;
		private String tokenName;
		
		public PrintToken(String text, String tokenName) {
			this.text = text;
			this.tokenName = tokenName;
		}
		
		public String getText() {
			return text;
		}
		
		public String getTokenName() {
			return tokenName;
		}
		
	}
	
	public final static String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	
	/**
	 * Holds the resource that is associated with this printer. May be null if the
	 * printer is used stand alone.
	 */
	private smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource;
	
	private java.util.Map<?, ?> options;
	private java.io.OutputStream outputStream;
	private java.util.List<PrintToken> tokenOutputStream;
	private smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolverFactory tokenResolverFactory = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectTokenResolverFactory();
	private boolean handleTokenSpaceAutomatically = false;
	private int tokenSpace = 0;
	/**
	 * A flag that indicates whether token have already been printed for the some
	 * object. The flag is set to false whenever printing of an EObject tree is
	 * started. The status of the flag is used to avoid printing default token space
	 * in front of the root object.
	 */
	private boolean startedPrintingObject = false;
	/**
	 * The number of tab characters that were printed before the current line. This
	 * number is used to calculate the relative indentation when printing contained
	 * objects, because all contained objects must start with this indentation
	 * (tabsBeforeCurrentObject + currentTabs).
	 */
	private int currentTabs;
	/**
	 * The number of tab characters that must be printed before the current object.
	 * This number is used to calculate the indentation of new lines, when line breaks
	 * are printed within one object.
	 */
	private int tabsBeforeCurrentObject;
	private int newTabsBeforeCurrentObject;
	
	public Edap_aspectPrinter2(java.io.OutputStream outputStream, smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		tokenOutputStream = new java.util.ArrayList<PrintToken>();
		currentTabs = 0;
		tabsBeforeCurrentObject = 0;
		startedPrintingObject = true;
		doPrint(element, new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement>());
		java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.BufferedOutputStream(outputStream));
		if (handleTokenSpaceAutomatically) {
			printSmart(writer);
		} else {
			printBasic(writer);
		}
		writer.flush();
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (outputStream == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof smartadapters4MODERATES.Aspect) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_0, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.PointcutModel) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_1, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.AdviceModel) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_2, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.GlobalInstantiation) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_3, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.PerRoleMatch) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_4, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.PerElementMatch) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_5, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetCompositeState) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_6, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.UnsetCompositeState) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_7, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetState) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_8, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.UnsetState) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_9, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetTransition) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_10, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.UnsetTransition) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_11, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetAnnotatedElement) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_12, foundFormattingElements);
			return;
		}
		if (element instanceof smartadapters4MODERATES.adaptations.SetActionBlock) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_13, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.EdapModel) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_14, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Message) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_15, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Device) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_16, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Simulator) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_18, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Dictionary) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_20, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Parameter) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_21, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.PrimitiveType) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_22, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Enumeration) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_23, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.EnumerationLiteral) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_24, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.PlatformAnnotation) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_25, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.StateMachine) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_26, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.CompositeState) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_28, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.ActionBlock) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_29, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.ExternStatement) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_30, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.PropertyAssignment) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_31, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.ExternExpression) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_32, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.ComponentReference) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_33, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.EventReference) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_34, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.DictionaryNavigation) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_36, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Unicast) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_37, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Broadcast) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_38, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Transition) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_39, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.ReceiveMessage) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_40, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Connector) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_41, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Port) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_42, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.CreateAction) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_43, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.SoftwareComponent) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_17, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.Property) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_19, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.State) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_27, foundFormattingElements);
			return;
		}
		if (element instanceof edap_relaxed.PropertyNavigation) {
			printInternal(element, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.EDAP_ASPECT_35, foundFormattingElements);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void printInternal(org.eclipse.emf.ecore.EObject eObject, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement ruleElement, java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements) {
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// create a copy of the original list of layout information object in order to be
		// able to remove used informations during printing
		java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator decoratorTree = getDecoratorTree(ruleElement);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, foundFormattingElements, layoutInformations);
	}
	
	/**
	 * creates a tree of decorator objects which reflects the syntax tree that is
	 * attached to the given syntax element
	 */
	public smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator getDecoratorTree(smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement syntaxElement) {
		smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement[] children = syntaxElement.getChildren();
		int childCount = children.length;
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator[] childDecorators = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator[childCount];
		for (int i = 0; i < childCount; i++) {
			childDecorators[i] = getDecoratorTree(children[i]);
		}
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator decorator = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator(syntaxElement, childDecorators);
		return decorator;
	}
	
	public void decorateTree(smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject) {
		java.util.Map<String, Integer> printCountingMap = initializePrintCountingMap(eObject);
		java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator> keywordsToPrint = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator>();
		decorateTreeBasic(decorator, eObject, printCountingMap, keywordsToPrint);
		for (smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator keywordToPrint : keywordsToPrint) {
			// for keywords the concrete index does not matter, but we must add one to
			// indicate that the keyword needs to be printed here. Thus, we use 0 as index.
			keywordToPrint.addIndexToPrint(0);
		}
	}
	
	/**
	 * Tries to decorate the decorator with an attribute value, or reference holded by
	 * eObject. Returns true if an attribute value or reference was found.
	 */
	public boolean decorateTreeBasic(smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.Map<String, Integer> printCountingMap, java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator> keywordsToPrint) {
		boolean foundFeatureToPrint = false;
		smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement syntaxElement = decorator.getDecoratedElement();
		smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality = syntaxElement.getCardinality();
		boolean isFirstIteration = true;
		while (true) {
			java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator> subKeywordsToPrint = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator>();
			boolean keepDecorating = false;
			if (syntaxElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectKeyword) {
				subKeywordsToPrint.add(decorator);
			} else if (syntaxElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectTerminal) {
				smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectTerminal terminal = (smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectTerminal) syntaxElement;
				org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
				if (feature == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.ANONYMOUS_FEATURE) {
					return false;
				}
				int countLeft = printCountingMap.get(feature.getName());
				if (countLeft > terminal.getMandatoryOccurencesAfter()) {
					decorator.addIndexToPrint(countLeft);
					printCountingMap.put(feature.getName(), countLeft - 1);
					keepDecorating = true;
				}
			}
			if (syntaxElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectChoice) {
				// for choices we do print only the choice which does print at least one feature
				smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator childToPrint = null;
				for (smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
					// pick first choice as default, will be overridden if a choice that prints a
					// feature is found
					if (childToPrint == null) {
						childToPrint = childDecorator;
					}
					if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {
						childToPrint = childDecorator;
						break;
					}
				}
				keepDecorating |= decorateTreeBasic(childToPrint, eObject, printCountingMap, subKeywordsToPrint);
			} else {
				// for all other syntax element we do print all children
				for (smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
					keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);
				}
			}
			foundFeatureToPrint |= keepDecorating;
			// only print keywords if a feature was printed or the syntax element is mandatory
			if (cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.ONE) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			} else if (cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.PLUS) {
				if (isFirstIteration) {
					keywordsToPrint.addAll(subKeywordsToPrint);
				} else {
					if (keepDecorating) {
						keywordsToPrint.addAll(subKeywordsToPrint);
					}
				}
			} else if (keepDecorating && (cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.STAR || cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.QUESTIONMARK)) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			}
			if (cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.ONE || cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.QUESTIONMARK) {
				break;
			} else if (!keepDecorating) {
				break;
			}
			isFirstIteration = false;
		}
		return foundFeatureToPrint;
	}
	
	/**
	 * Checks whether decorating the given node will use at least one attribute value,
	 * or reference holded by eObject. Returns true if a printable attribute value or
	 * reference was found. This method is used to decide which choice to pick, when
	 * multiple choices are available. We pick the choice that prints at least one
	 * attribute or reference.
	 */
	public boolean doesPrintFeature(smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.Map<String, Integer> printCountingMap) {
		smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement syntaxElement = decorator.getDecoratedElement();
		if (syntaxElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectTerminal) {
			smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectTerminal terminal = (smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectTerminal) syntaxElement;
			org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
			if (feature == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectGrammarInformationProvider.ANONYMOUS_FEATURE) {
				return false;
			}
			int countLeft = printCountingMap.get(feature.getName());
			if (countLeft > terminal.getMandatoryOccurencesAfter()) {
				// found a feature to print
				return true;
			}
		}
		for (smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
			if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean printTree(smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements, java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations) {
		smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement printElement = decorator.getDecoratedElement();
		smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality cardinality = printElement.getCardinality();
		java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> cloned = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement>();
		cloned.addAll(foundFormattingElements);
		boolean foundSomethingAtAll = false;
		boolean foundSomethingToPrint;
		while (true) {
			foundSomethingToPrint = false;
			Integer indexToPrint = decorator.getNextIndexToPrint();
			if (indexToPrint != null) {
				if (printElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectKeyword) {
					printKeyword(eObject, (smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectKeyword) printElement, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectPlaceholder) {
					smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectPlaceholder placeholder = (smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectPlaceholder) printElement;
					printFeature(eObject, placeholder, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectContainment) {
					smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectContainment containment = (smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectContainment) printElement;
					printContainedObject(eObject, containment, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectBooleanTerminal) {
					smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectBooleanTerminal booleanTerminal = (smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectBooleanTerminal) printElement;
					printBooleanTerminal(eObject, booleanTerminal, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				}
			}
			if (foundSomethingToPrint) {
				foundSomethingAtAll = true;
			}
			if (printElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectWhiteSpace) {
				foundFormattingElements.add((smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectWhiteSpace) printElement);
			}
			if (printElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectLineBreak) {
				foundFormattingElements.add((smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectLineBreak) printElement);
			}
			for (smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				foundSomethingToPrint |= printTree(childDecorator, eObject, foundFormattingElements, layoutInformations);
				smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement decoratedElement = decorator.getDecoratedElement();
				if (foundSomethingToPrint && decoratedElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectChoice) {
					break;
				}
			}
			if (cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.ONE || cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.QUESTIONMARK) {
				break;
			} else if (!foundSomethingToPrint) {
				break;
			}
		}
		// only print formatting elements if a feature was printed or the syntax element
		// is mandatory
		if (!foundSomethingAtAll && (cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.STAR || cardinality == smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectCardinality.QUESTIONMARK)) {
			foundFormattingElements.clear();
			foundFormattingElements.addAll(cloned);
		}
		return foundSomethingToPrint;
	}
	
	public void printKeyword(org.eclipse.emf.ecore.EObject eObject, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectKeyword keyword, java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements, java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations) {
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, keyword, null, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		String value = keyword.getValue();
		tokenOutputStream.add(new PrintToken(value, "'" + smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectStringUtil.escapeToANTLRKeyword(value) + "'"));
	}
	
	public void printFeature(org.eclipse.emf.ecore.EObject eObject, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectPlaceholder placeholder, int count, java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements, java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature feature = placeholder.getFeature();
		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			printAttribute(eObject, (org.eclipse.emf.ecore.EAttribute) feature, placeholder, count, foundFormattingElements, layoutInformations);
		} else {
			printReference(eObject, (org.eclipse.emf.ecore.EReference) feature, placeholder, count, foundFormattingElements, layoutInformations);
		}
	}
	
	public void printAttribute(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EAttribute attribute, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectPlaceholder placeholder, int count, java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements, java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations) {
		String result;
		Object attributeValue = getValue(eObject, attribute, count);
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the attribute is deresolved to obtain its textual
			// representation
			smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());
			tokenResolver.setOptions(getOptions());
			String deResolvedValue = tokenResolver.deResolve(attributeValue, attribute, eObject);
			result = deResolvedValue;
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		}
		// write result to the output stream
		tokenOutputStream.add(new PrintToken(result, placeholder.getTokenName()));
	}
	
	public void printBooleanTerminal(org.eclipse.emf.ecore.EObject eObject, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectBooleanTerminal booleanTerminal, int count, java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements, java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EAttribute attribute = booleanTerminal.getAttribute();
		String result;
		Object attributeValue = getValue(eObject, attribute, count);
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, booleanTerminal, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(layoutInformation);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		} else {
			// if no text is available, the boolean attribute is converted to its textual
			// representation using the literals of the boolean terminal
			if (Boolean.TRUE.equals(attributeValue)) {
				result = booleanTerminal.getTrueLiteral();
			} else {
				result = booleanTerminal.getFalseLiteral();
			}
		}
		if (result != null && !"".equals(result)) {
			printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, "'" + smartadapters4MODERATES.resource.edap_aspect.util.Edap_aspectStringUtil.escapeToANTLRKeyword(result) + "'"));
		}
	}
	
	public void printContainedObject(org.eclipse.emf.ecore.EObject eObject, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectContainment containment, int count, java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements, java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature reference = containment.getFeature();
		Object o = getValue(eObject, reference, count);
		// save current number of tabs to restore them after printing the contained object
		int oldTabsBeforeCurrentObject = tabsBeforeCurrentObject;
		int oldCurrentTabs = currentTabs;
		// use current number of tabs to indent contained object. we do not directly set
		// 'tabsBeforeCurrentObject' because the first element of the new object must be
		// printed with the old number of tabs.
		newTabsBeforeCurrentObject = tabsBeforeCurrentObject + currentTabs;
		currentTabs = 0;
		doPrint((org.eclipse.emf.ecore.EObject) o, foundFormattingElements);
		// restore number of tabs after printing the contained object
		tabsBeforeCurrentObject = oldTabsBeforeCurrentObject;
		newTabsBeforeCurrentObject = tabsBeforeCurrentObject;
		currentTabs = oldCurrentTabs;
	}
	
	public void printFormattingElements(java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements, java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations, smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation layoutInformation) {
		String hiddenTokenText = getHiddenTokenText(layoutInformation);
		if (hiddenTokenText != null) {
			// removed used information
			layoutInformations.remove(layoutInformation);
			tokenOutputStream.add(new PrintToken(hiddenTokenText, null));
			foundFormattingElements.clear();
			startedPrintingObject = false;
			tabsBeforeCurrentObject = newTabsBeforeCurrentObject;
			return;
		}
		if (foundFormattingElements.size() > 0) {
			for (smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement foundFormattingElement : foundFormattingElements) {
				if (foundFormattingElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectWhiteSpace) {
					int amount = ((smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectWhiteSpace) foundFormattingElement).getAmount();
					for (int i = 0; i < amount; i++) {
						tokenOutputStream.add(new PrintToken(" ", null));
					}
				}
				if (foundFormattingElement instanceof smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectLineBreak) {
					currentTabs = ((smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectLineBreak) foundFormattingElement).getTabs();
					tokenOutputStream.add(new PrintToken(NEW_LINE, null));
					for (int i = 0; i < tabsBeforeCurrentObject + currentTabs; i++) {
						tokenOutputStream.add(new PrintToken("\t", null));
					}
				}
			}
			foundFormattingElements.clear();
			startedPrintingObject = false;
		} else {
			if (startedPrintingObject) {
				// if no elements have been printed yet, we do not add the default token space,
				// because spaces before the first element are not desired.
				startedPrintingObject = false;
			} else {
				if (!handleTokenSpaceAutomatically) {
					tokenOutputStream.add(new PrintToken(getWhiteSpaceString(tokenSpace), null));
				}
			}
		}
		// after printing the first element, we can use the new number of tabs.
		tabsBeforeCurrentObject = newTabsBeforeCurrentObject;
	}
	
	private Object getValue(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, int count) {
		// get value of feature
		Object o = eObject.eGet(feature);
		if (o instanceof java.util.List<?>) {
			java.util.List<?> list = (java.util.List<?>) o;
			int index = list.size() - count;
			o = list.get(index);
		}
		return o;
	}
	
	@SuppressWarnings("unchecked")	
	public void printReference(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EReference reference, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectPlaceholder placeholder, int count, java.util.List<smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectFormattingElement> foundFormattingElements, java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations) {
		Object referencedObject = getValue(eObject, reference, count);
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation layoutInformation = getLayoutInformation(layoutInformations, placeholder, referencedObject, eObject);
		printFormattingElements(foundFormattingElements, layoutInformations, layoutInformation);
		// NC-References must always be printed by deresolving the reference. We cannot
		// use the visible token information, because deresolving usually depends on
		// attribute values of the referenced object instead of the object itself.
		String tokenName = placeholder.getTokenName();
		smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
		tokenResolver.setOptions(getOptions());
		@SuppressWarnings("rawtypes")		
		smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectReferenceResolver referenceResolver = getReferenceResolverSwitch().getResolver(reference);
		referenceResolver.setOptions(getOptions());
		String deresolvedReference = referenceResolver.deResolve((org.eclipse.emf.ecore.EObject) referencedObject, eObject, reference);
		String deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);
		// write result to output stream
		tokenOutputStream.add(new PrintToken(deresolvedToken, tokenName));
	}
	
	public java.util.Map<String, Integer> initializePrintCountingMap(org.eclipse.emf.ecore.EObject eObject) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>();
		java.util.List<org.eclipse.emf.ecore.EStructuralFeature> features = eObject.eClass().getEAllStructuralFeatures();
		for (org.eclipse.emf.ecore.EStructuralFeature feature : features) {
			int count = 0;
			Object featureValue = eObject.eGet(feature);
			if (featureValue != null) {
				if (featureValue instanceof java.util.List<?>) {
					count = ((java.util.List<?>) featureValue).size();
				} else {
					count = 1;
				}
			}
			printCountingMap.put(feature.getName(), count);
		}
		return printCountingMap;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextResource getResource() {
		return resource;
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
	
	protected smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformationAdapter getLayoutInformationAdapter(org.eclipse.emf.ecore.EObject element) {
		for (org.eclipse.emf.common.notify.Adapter adapter : element.eAdapters()) {
			if (adapter instanceof smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformationAdapter) {
				return (smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformationAdapter) adapter;
			}
		}
		smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformationAdapter newAdapter = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
	private smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation getLayoutInformation(java.util.List<smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation> layoutInformations, smartadapters4MODERATES.resource.edap_aspect.grammar.Edap_aspectSyntaxElement syntaxElement, Object object, org.eclipse.emf.ecore.EObject container) {
		for (smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation layoutInformation : layoutInformations) {
			if (syntaxElement == layoutInformation.getSyntaxElement()) {
				if (object == null) {
					return layoutInformation;
				} else if (object == layoutInformation.getObject(container)) {
					return layoutInformation;
				}
			}
		}
		return null;
	}
	
	private String getHiddenTokenText(smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getHiddenTokenText();
		} else {
			return null;
		}
	}
	
	private String getVisibleTokenText(smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getVisibleTokenText();
		} else {
			return null;
		}
	}
	
	protected String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < count; i++) {
			result.append(character);
		}
		return result.toString();
	}
	
	public void setHandleTokenSpaceAutomatically(boolean handleTokenSpaceAutomatically) {
		this.handleTokenSpaceAutomatically = handleTokenSpaceAutomatically;
	}
	
	public void setTokenSpace(int tokenSpace) {
		this.tokenSpace = tokenSpace;
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer (as it is).
	 */
	public void printBasic(java.io.PrintWriter writer) throws java.io.IOException {
		for (PrintToken nextToken : tokenOutputStream) {
			writer.write(nextToken.getText());
		}
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer.
	 * 
	 * This methods implements smart whitespace printing. It does so by writing output
	 * to a token stream instead of printing the raw token text to a PrintWriter.
	 * Tokens in this stream hold both the text and the type of the token (i.e., its
	 * name).
	 * 
	 * To decide where whitespace is needed, sequences of successive tokens are
	 * searched that can be printed without separating whitespace. To determine such
	 * groups we start with two successive non-whitespace tokens, concatenate their
	 * text and use the generated ANTLR lexer to split the text. If the resulting
	 * token sequence of the concatenated text is exactly the same as the one that is
	 * to be printed, no whitespace is needed. The tokens in the sequence are checked
	 * both regarding their type and their text. If two tokens successfully form a
	 * group a third one is added and so on.
	 */
	public void printSmart(java.io.PrintWriter writer) throws java.io.IOException {
		// stores the text of the current group of tokens. this text is given to the lexer
		// to check whether it can be correctly scanned.
		StringBuilder currentBlock = new StringBuilder();
		// stores the index of the first token of the current group.
		int currentBlockStart = 0;
		// stores the text that was already successfully checked (i.e., is can be scanned
		// correctly and can thus be printed).
		String validBlock = "";
		for (int i = 0; i < tokenOutputStream.size(); i++) {
			PrintToken tokenI = tokenOutputStream.get(i);
			currentBlock.append(tokenI.getText());
			// if declared or preserved whitespace is found - print block
			if (tokenI.getTokenName() == null) {
				writer.write(currentBlock.toString());
				// reset all values
				currentBlock = new StringBuilder();
				currentBlockStart = i + 1;
				validBlock = "";
				continue;
			}
			// now check whether the current block can be scanned
			smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextScanner scanner = new smartadapters4MODERATES.resource.edap_aspect.mopp.Edap_aspectMetaInformation().createLexer();
			scanner.setText(currentBlock.toString());
			// retrieve all tokens from scanner and add them to list 'tempTokens'
			java.util.List<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextToken> tempTokens = new java.util.ArrayList<smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextToken>();
			smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextToken nextToken = scanner.getNextToken();
			while (nextToken != null && nextToken.getText() != null) {
				tempTokens.add(nextToken);
				nextToken = scanner.getNextToken();
			}
			boolean sequenceIsValid = true;
			// check whether the current block was scanned to the same token sequence
			for (int t = 0; t < tempTokens.size(); t++) {
				PrintToken printTokenT = tokenOutputStream.get(currentBlockStart + t);
				smartadapters4MODERATES.resource.edap_aspect.IEdap_aspectTextToken tempToken = tempTokens.get(t);
				if (!tempToken.getText().equals(printTokenT.getText())) {
					sequenceIsValid = false;
					break;
				}
				String commonTokenName = tempToken.getName();
				String printTokenName = printTokenT.getTokenName();
				if (printTokenName.length() > 2 && printTokenName.startsWith("'") && printTokenName.endsWith("'")) {
					printTokenName = printTokenName.substring(1, printTokenName.length() - 1);
				}
				if (!commonTokenName.equals(printTokenName)) {
					sequenceIsValid = false;
					break;
				}
			}
			if (sequenceIsValid) {
				// sequence is still valid, try adding one more token in the next iteration of the
				// loop
				validBlock += tokenI.getText();
			} else {
				// sequence is not valid, must print whitespace to separate tokens
				// print text that is valid so far
				writer.write(validBlock);
				// print separating whitespace
				writer.write(" ");
				// add current token as initial value for next iteration
				currentBlock = new StringBuilder(tokenI.getText());
				currentBlockStart = i;
				validBlock = tokenI.getText();
			}
		}
		// flush remaining valid text to writer
		writer.write(validBlock);
	}
	
}
