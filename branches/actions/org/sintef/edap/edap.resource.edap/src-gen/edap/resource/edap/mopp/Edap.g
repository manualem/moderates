grammar Edap;

options {
	superClass = EdapANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package edap.resource.edap.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
	}
}
@header{
	package edap.resource.edap.mopp;
}

@members{
	private edap.resource.edap.IEdapTokenResolverFactory tokenResolverFactory = new edap.resource.edap.mopp.EdapTokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	private edap.resource.edap.mopp.EdapTokenResolveResult tokenResolveResult = new edap.resource.edap.mopp.EdapTokenResolveResult();
	
	/**
	 * A flag that indicates whether the parser should remember all expected elements.
	 * This flag is set to true when using the parse for code completion. Otherwise it
	 * is set to false.
	 */
	private boolean rememberExpectedElements = false;
	
	private Object parseToIndexTypeObject;
	private int lastTokenIndex = 0;
	
	/**
	 * A list of expected elements the were collected while parsing the input stream.
	 * This list is only filled if <code>rememberExpectedElements</code> is set to
	 * true.
	 */
	private java.util.List<edap.resource.edap.mopp.EdapExpectedTerminal> expectedElements = new java.util.ArrayList<edap.resource.edap.mopp.EdapExpectedTerminal>();
	
	private int mismatchedTokenRecoveryTries = 0;
	private java.util.Map<?, ?> options;
	/**
	 * A helper list to allow a lexer to pass errors to its parser
	 */
	protected java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>());
	
	/**
	 * Another helper list to allow a lexer to pass positions of errors to its parser
	 */
	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
	
	/**
	 * A stack for incomplete objects. This stack is used filled when the parser is
	 * used for code completion. Whenever the parser starts to read an object it is
	 * pushed on the stack. Once the element was parser completely it is popped from
	 * the stack.
	 */
	protected java.util.Stack<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	
	private int stopIncludingHiddenTokens;
	private int stopExcludingHiddenTokens;
	/**
	 * A flag to indicate that the parser should stop parsing as soon as possible. The
	 * flag is set to false before parsing starts. It can be set to true by invoking
	 * the terminateParsing() method from another thread. This feature is used, when
	 * documents are parsed in the background (i.e., while editing them). In order to
	 * cancel running parsers, the parsing process can be terminated. This is done
	 * whenever a document changes, because the previous content of the document is
	 * not valid anymore and parsing the old content is not necessary any longer.
	 */
	private boolean terminateParsing;
	
	private int tokenIndexOfLastCompleteElement;
	
	private int expectedElementsIndexOfLastCompleteElement;
	
	/**
	 * The offset indicating the cursor position when the parser is used for code
	 * completion by calling parseToExpectedElements().
	 */
	private int cursorOffset;
	
	/**
	 * The offset of the first hidden token of the last expected element. This offset
	 * is used to discard expected elements, which are not needed for code completion.
	 */
	private int lastStartIncludingHidden;
	
	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
		postParseCommands.add(new edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>() {
			public boolean execute(edap.resource.edap.IEdapTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new edap.resource.edap.IEdapProblem() {
					public edap.resource.edap.EdapEProblemSeverity getSeverity() {
						return edap.resource.edap.EdapEProblemSeverity.ERROR;
					}
					public edap.resource.edap.EdapEProblemType getType() {
						return edap.resource.edap.EdapEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<edap.resource.edap.IEdapQuickFix> getQuickFixes() {
						return null;
					}
				}, column, line, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(edap.resource.edap.IEdapExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
		if (!this.rememberExpectedElements) {
			return;
		}
		edap.resource.edap.mopp.EdapExpectedTerminal expectedElement = new edap.resource.edap.mopp.EdapExpectedTerminal(terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, edap.resource.edap.mopp.EdapDummyEObject dummy) {
		Object value = element.eGet(structuralFeature);
		Object mapKey = dummy.getValueByName("key");
		Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<Object, Object> valueMap = edap.resource.edap.util.EdapMapUtil.castToEMap(value);
			if (mapKey != null && mapValue != null) {
				valueMap.put(mapKey, mapValue);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	
	public boolean addObjectToList(org.eclipse.emf.ecore.EObject container, int featureID, Object object) {
		return ((java.util.List<Object>) container.eGet(container.eClass().getEStructuralFeature(featureID))).add(object);
	}
	
	@SuppressWarnings("unchecked")
	
	public boolean addObjectToList(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EStructuralFeature feature, Object object) {
		return ((java.util.List<Object>) container.eGet(feature)).add(object);
	}
	
	protected org.eclipse.emf.ecore.EObject apply(org.eclipse.emf.ecore.EObject target, java.util.List<org.eclipse.emf.ecore.EObject> dummyEObjects) {
		org.eclipse.emf.ecore.EObject currentTarget = target;
		for (org.eclipse.emf.ecore.EObject object : dummyEObjects) {
			assert(object instanceof edap.resource.edap.mopp.EdapDummyEObject);
			edap.resource.edap.mopp.EdapDummyEObject dummy = (edap.resource.edap.mopp.EdapDummyEObject) object;
			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>() {
			public boolean execute(edap.resource.edap.IEdapTextResource resource) {
				edap.resource.edap.IEdapLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharStart(target, locationMap.getCharStart(source));
				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
				locationMap.setColumn(target, locationMap.getColumn(source));
				locationMap.setLine(target, locationMap.getLine(source));
				return true;
			}
		});
	}
	
	protected void copyLocalizationInfos(final org.antlr.runtime3_2_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>() {
			public boolean execute(edap.resource.edap.IEdapTextResource resource) {
				edap.resource.edap.IEdapLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				if (source == null) {
					return true;
				}
				locationMap.setCharStart(target, source.getStartIndex());
				locationMap.setCharEnd(target, source.getStopIndex());
				locationMap.setColumn(target, source.getCharPositionInLine());
				locationMap.setLine(target, source.getLine());
				return true;
			}
		});
	}
	
	/**
	 * Sets the end character index and the last line for the given object in the
	 * location map.
	 */
	protected void setLocalizationEnd(java.util.Collection<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		postParseCommands.add(new edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>() {
			public boolean execute(edap.resource.edap.IEdapTextResource resource) {
				edap.resource.edap.IEdapLocationMap locationMap = resource.getLocationMap();
				if (locationMap == null) {
					// the locationMap can be null if the parser is used for code completion
					return true;
				}
				locationMap.setCharEnd(object, endChar);
				locationMap.setLine(object, endLine);
				return true;
			}
		});
	}
	
	public edap.resource.edap.IEdapTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new EdapParser(new org.antlr.runtime3_2_0.CommonTokenStream(new EdapLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new EdapParser(new org.antlr.runtime3_2_0.CommonTokenStream(new EdapLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			edap.resource.edap.mopp.EdapPlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public EdapParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((EdapLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((EdapLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == edap.EdapModel.class) {
				return parse_edap_EdapModel();
			}
			if (type.getInstanceClass() == edap.Message.class) {
				return parse_edap_Message();
			}
			if (type.getInstanceClass() == edap.Device.class) {
				return parse_edap_Device();
			}
			if (type.getInstanceClass() == edap.SoftwareComponent.class) {
				return parse_edap_SoftwareComponent();
			}
			if (type.getInstanceClass() == edap.Simulator.class) {
				return parse_edap_Simulator();
			}
			if (type.getInstanceClass() == edap.Property.class) {
				return parse_edap_Property();
			}
			if (type.getInstanceClass() == edap.Dictionary.class) {
				return parse_edap_Dictionary();
			}
			if (type.getInstanceClass() == edap.Parameter.class) {
				return parse_edap_Parameter();
			}
			if (type.getInstanceClass() == edap.PrimitiveType.class) {
				return parse_edap_PrimitiveType();
			}
			if (type.getInstanceClass() == edap.Enumeration.class) {
				return parse_edap_Enumeration();
			}
			if (type.getInstanceClass() == edap.EnumerationLiteral.class) {
				return parse_edap_EnumerationLiteral();
			}
			if (type.getInstanceClass() == edap.PlatformAnnotation.class) {
				return parse_edap_PlatformAnnotation();
			}
			if (type.getInstanceClass() == edap.StateMachine.class) {
				return parse_edap_StateMachine();
			}
			if (type.getInstanceClass() == edap.State.class) {
				return parse_edap_State();
			}
			if (type.getInstanceClass() == edap.CompositeState.class) {
				return parse_edap_CompositeState();
			}
			if (type.getInstanceClass() == edap.EventReference.class) {
				return parse_edap_EventReference();
			}
			if (type.getInstanceClass() == edap.Unicast.class) {
				return parse_edap_Unicast();
			}
			if (type.getInstanceClass() == edap.Broadcast.class) {
				return parse_edap_Broadcast();
			}
			if (type.getInstanceClass() == edap.Transition.class) {
				return parse_edap_Transition();
			}
			if (type.getInstanceClass() == edap.ReceiveMessage.class) {
				return parse_edap_ReceiveMessage();
			}
			if (type.getInstanceClass() == edap.PropertyAssignment.class) {
				return parse_edap_PropertyAssignment();
			}
			if (type.getInstanceClass() == edap.ActionBlock.class) {
				return parse_edap_ActionBlock();
			}
			if (type.getInstanceClass() == edap.ExternStatement.class) {
				return parse_edap_ExternStatement();
			}
			if (type.getInstanceClass() == edap.ConditionalAction.class) {
				return parse_edap_ConditionalAction();
			}
			if (type.getInstanceClass() == edap.LoopAction.class) {
				return parse_edap_LoopAction();
			}
			if (type.getInstanceClass() == edap.PrintAction.class) {
				return parse_edap_PrintAction();
			}
			if (type.getInstanceClass() == edap.ErrorAction.class) {
				return parse_edap_ErrorAction();
			}
		}
		throw new edap.resource.edap.mopp.EdapUnexpectedContentTypeException(typeObject);
	}
	
	private edap.resource.edap.mopp.EdapTokenResolveResult getFreshTokenResolveResult() {
		tokenResolveResult.clear();
		return tokenResolveResult;
	}
	
	public int getMismatchedTokenRecoveryTries() {
		return mismatchedTokenRecoveryTries;
	}
	
	public Object getMissingSymbol(org.antlr.runtime3_2_0.IntStream arg0, org.antlr.runtime3_2_0.RecognitionException arg1, int arg2, org.antlr.runtime3_2_0.BitSet arg3) {
		mismatchedTokenRecoveryTries++;
		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
	}
	
	protected java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public edap.resource.edap.mopp.EdapMetaInformation getMetaInformation() {
		return new edap.resource.edap.mopp.EdapMetaInformation();
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected edap.resource.edap.mopp.EdapReferenceResolverSwitch getReferenceResolverSwitch() {
		return (edap.resource.edap.mopp.EdapReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(edap.resource.edap.IEdapOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public edap.resource.edap.IEdapParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>>();
		edap.resource.edap.mopp.EdapParseResult parseResult = new edap.resource.edap.mopp.EdapParseResult();
		try {
			org.eclipse.emf.ecore.EObject result =  doParse();
			if (lexerExceptions.isEmpty()) {
				parseResult.setRoot(result);
			}
		} catch (org.antlr.runtime3_2_0.RecognitionException re) {
			reportError(re);
		} catch (java.lang.IllegalArgumentException iae) {
			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
				// can be caused if a null is set on EMF models where not allowed. this will just
				// happen if other errors occurred before
			} else {
				iae.printStackTrace();
			}
		}
		for (org.antlr.runtime3_2_0.RecognitionException re : lexerExceptions) {
			reportLexicalError(re);
		}
		parseResult.getPostParseCommands().addAll(postParseCommands);
		return parseResult;
	}
	
	public java.util.List<edap.resource.edap.mopp.EdapExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, edap.resource.edap.IEdapTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
		edap.resource.edap.IEdapParseResult result = parse();
		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
			org.antlr.runtime3_2_0.Lexer lexer = (org.antlr.runtime3_2_0.Lexer) tokenStream.getTokenSource();
			int endChar = lexer.getCharIndex();
			int endLine = lexer.getLine();
			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
		}
		if (result != null) {
			org.eclipse.emf.ecore.EObject root = result.getRoot();
			if (root != null) {
				dummyResource.getContentsInternal().add(root);
			}
			for (edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<edap.resource.edap.mopp.EdapExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<edap.resource.edap.mopp.EdapExpectedTerminal>();
		java.util.List<edap.resource.edap.mopp.EdapExpectedTerminal> newFollowSet = new java.util.ArrayList<edap.resource.edap.mopp.EdapExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			edap.resource.edap.mopp.EdapExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 307;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (edap.resource.edap.mopp.EdapExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (edap.resource.edap.mopp.EdapExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<edap.resource.edap.util.EdapPair<edap.resource.edap.IEdapExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (edap.resource.edap.util.EdapPair<edap.resource.edap.IEdapExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
							edap.resource.edap.IEdapExpectedElement newFollower = newFollowerPair.getLeft();
							edap.resource.edap.mopp.EdapExpectedTerminal newFollowTerminal = new edap.resource.edap.mopp.EdapExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
							newFollowSet.add(newFollowTerminal);
							expectedElements.add(newFollowTerminal);
						}
					}
				}
				currentFollowSet.clear();
				currentFollowSet.addAll(newFollowSet);
			}
			followSetID++;
		}
		// after the last token in the stream we must set the position for the elements
		// that were added during the last iteration of the loop
		for (edap.resource.edap.mopp.EdapExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(edap.resource.edap.mopp.EdapExpectedTerminal expectedElement, int tokenIndex) {
		int currentIndex = Math.max(0, tokenIndex);
		for (int index = lastTokenIndex; index < currentIndex; index++) {
			if (index >= input.size()) {
				break;
			}
			org.antlr.runtime3_2_0.CommonToken tokenAtIndex = (org.antlr.runtime3_2_0.CommonToken) input.get(index);
			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			if (tokenAtIndex.getChannel() != 99) {
				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
			}
		}
		lastTokenIndex = Math.max(0, currentIndex);
		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
	}
	
	public Object recoverFromMismatchedToken(org.antlr.runtime3_2_0.IntStream input, int ttype, org.antlr.runtime3_2_0.BitSet follow) throws org.antlr.runtime3_2_0.RecognitionException {
		if (!rememberExpectedElements) {
			return super.recoverFromMismatchedToken(input, ttype, follow);
		} else {
			return null;
		}
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			String expectedTokenName = formatTokenName(mte.expecting);
			String actualTokenName = formatTokenName(e.token.getType());
			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_2_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_2_0.MismatchedTreeNodeException) e;
			String expectedTokenName = formatTokenName(mtne.expecting);
			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
		} else if (e instanceof org.antlr.runtime3_2_0.NoViableAltException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
		} else if (e instanceof org.antlr.runtime3_2_0.EarlyExitException) {
			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
		}
		// the resource may be null if the parse is used for code completion
		final String finalMessage = message;
		if (e.token instanceof org.antlr.runtime3_2_0.CommonToken) {
			final org.antlr.runtime3_2_0.CommonToken ct = (org.antlr.runtime3_2_0.CommonToken) e.token;
			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
		} else {
			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
		}
	}
	
	/**
	 * Translates errors thrown by the lexer into human readable messages.
	 */
	public void reportLexicalError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		String message = "";
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.NoViableAltException) {
			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
		} else if (e instanceof org.antlr.runtime3_2_0.EarlyExitException) {
			org.antlr.runtime3_2_0.EarlyExitException eee = (org.antlr.runtime3_2_0.EarlyExitException) e;
			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedRangeException) {
			org.antlr.runtime3_2_0.MismatchedRangeException mre = (org.antlr.runtime3_2_0.MismatchedRangeException) e;
			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
	}
	
	private String formatTokenName(int tokenType)  {
		String tokenName = "<unknown>";
		if (tokenType == org.antlr.runtime3_2_0.Token.EOF) {
			tokenName = "EOF";
		} else {
			if (tokenType < 0) {
				return tokenName;
			}
			tokenName = getTokenNames()[tokenType];
			tokenName = edap.resource.edap.util.EdapStringUtil.formatTokenName(tokenName);
		}
		return tokenName;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public void terminate() {
		terminateParsing = true;
	}
	
	protected void completedElement(Object object, boolean isContainment) {
		if (isContainment && !this.incompleteObjects.isEmpty()) {
			this.incompleteObjects.pop();
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
		}
	}
	
	/**
	 * Creates a dynamic Java proxy that mimics the interface of the given class.
	 */
	@SuppressWarnings("unchecked")
	
	public <T> T createDynamicProxy(Class<T> clazz) {
		Object proxy = java.lang.reflect.Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class<?>[]{clazz, org.eclipse.emf.ecore.EObject.class, org.eclipse.emf.ecore.InternalEObject.class}, new java.lang.reflect.InvocationHandler() {
			
			private org.eclipse.emf.ecore.EObject dummyObject = new org.eclipse.emf.ecore.impl.EObjectImpl() {};
			
			public Object invoke(Object object, java.lang.reflect.Method method, Object[] args) throws Throwable {
				// search in dummyObject for the requested method
				java.lang.reflect.Method[] methodsInDummy = dummyObject.getClass().getMethods();
				for (java.lang.reflect.Method methodInDummy : methodsInDummy) {
					boolean matches = true;
					if (methodInDummy.getName().equals(method.getName())) {
						Class<?>[] parameterTypes = method.getParameterTypes();
						Class<?>[] parameterTypesInDummy = methodInDummy.getParameterTypes();
						if (parameterTypes.length == parameterTypesInDummy.length) {
							for (int p = 0; p < parameterTypes.length; p++) {
								Class<?> parameterType = parameterTypes[p];
								Class<?> parameterTypeInDummy = parameterTypesInDummy[p];
								if (!parameterType.equals(parameterTypeInDummy)) {
									matches = false;
								}
							}
						} else {
							matches = false;
						}
					} else {
						matches = false;
					}
					if (matches) {
						return methodInDummy.invoke(dummyObject, args);
					}
				}
				return null;
			}
		});
		return (T) proxy;
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_0, 0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 0, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 0, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 0, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 0, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 0, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 0, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 0, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 0, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 0, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_edap_EdapModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_edap_EdapModel returns [edap.EdapModel element = null]
@init{
}
:
	(
		(
			a0 = 'import' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createEdapModel();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_0_0_0_0_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_10, 1);
			}
			
			(
				a1 = STRING_LITERAL				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createEdapModel();
						incompleteObjects.push(element);
					}
					if (a1 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.EDAP_MODEL__IMPORTS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edap.EdapModel proxy = edap.EdapFactory.eINSTANCE.createEdapModel();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.EdapModel, edap.EdapModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEdapModelImportsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.EDAP_MODEL__IMPORTS), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edap.EdapPackage.EDAP_MODEL__IMPORTS, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_0_0_0_0_0_0_3, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_0, 2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 2, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 2, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 2, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 2, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 2, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 2, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 2, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 2, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 2, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_0, 3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 3, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 3, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 3, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 3, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 3, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 3, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 3, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 3, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 3, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
	}
	
	(
		(
			(
				(
					a2_0 = parse_edap_Type					{
						if (terminateParsing) {
							throw new edap.resource.edap.mopp.EdapTerminateParsingException();
						}
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createEdapModel();
							incompleteObjects.push(element);
						}
						if (a2_0 != null) {
							if (a2_0 != null) {
								Object value = a2_0;
								addObjectToList(element, edap.EdapPackage.EDAP_MODEL__TYPES, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_0_0_0_1_0_0_1_0_0_0, a2_0, true);
							copyLocalizationInfos(a2_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 4, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 4, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 4, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 4, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 4, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 4, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 4, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 4, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 4, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 5, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 5, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 5, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 5, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 5, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 5, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 5, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 5, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 5, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 6, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 6, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 6, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 6, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 6, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 6, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 6, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 6, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 6, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
	}
	
;

parse_edap_Message returns [edap.Message element = null]
@init{
}
:
	(
		(
			(
				a0 = T_MULTICAST				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createMessage();
						incompleteObjects.push(element);
					}
					if (a0 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("T_MULTICAST");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__ALLOW_MULTICAST), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
						}
						java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__ALLOW_MULTICAST), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 7);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 8);
	}
	
	a1 = 'message' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createMessage();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_13, 9);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createMessage();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_14, 10);
	}
	
	a3 = '(' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createMessage();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_15, 11, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_1);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 11);
	}
	
	(
		(
			(
				a4_0 = parse_edap_Parameter				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createMessage();
						incompleteObjects.push(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edap.EdapPackage.MESSAGE__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_5_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_17, 12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 12);
			}
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createMessage();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_5_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_15, 13, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_1);
					}
					
					(
						a6_0 = parse_edap_Parameter						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createMessage();
								incompleteObjects.push(element);
							}
							if (a6_0 != null) {
								if (a6_0 != null) {
									Object value = a6_0;
									addObjectToList(element, edap.EdapPackage.MESSAGE__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_5_0_0_1_0_0_1, a6_0, true);
								copyLocalizationInfos(a6_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_17, 14);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 14);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_17, 15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 15);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 16);
	}
	
	a7 = ')' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createMessage();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 17, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_19, 17);
	}
	
	(
		(
			(
				a8_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createMessage();
						incompleteObjects.push(element);
					}
					if (a8_0 != null) {
						if (a8_0 != null) {
							Object value = a8_0;
							addObjectToList(element, edap.EdapPackage.MESSAGE__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_7_0_0_0, a8_0, true);
						copyLocalizationInfos(a8_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_19, 18);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 19, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_19, 19);
	}
	
	a9 = ';' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createMessage();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 20);
	}
	
;

parse_edap_Device returns [edap.Device element = null]
@init{
}
:
	(
		(
			(
				a0 = T_ASPECT				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDevice();
						incompleteObjects.push(element);
					}
					if (a0 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("T_ASPECT");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__PARTIAL), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
						}
						java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__PARTIAL), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 21);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 21);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 22);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 22);
	}
	
	(
		(
			(
				a1 = T_SINGLETON				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDevice();
						incompleteObjects.push(element);
					}
					if (a1 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("T_SINGLETON");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SINGLETON), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
						}
						java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SINGLETON), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 23);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 24);
	}
	
	a2 = 'device' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDevice();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 25);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createDevice();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 26, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 26);
	}
	
	(
		(
			(
				a4_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDevice();
						incompleteObjects.push(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edap.EdapPackage.DEVICE__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_5_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 27, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 27);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 28, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 28);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDevice();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 29);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 29);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 29, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 29);
	}
	
	(
		(
			(
				a6_0 = parse_edap_Message				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDevice();
						incompleteObjects.push(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							addObjectToList(element, edap.EdapPackage.DEVICE__MESSAGES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_0_0, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 30);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 30);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 30, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 30);
			}
			
			
			|			(
				a7_0 = parse_edap_Property				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDevice();
						incompleteObjects.push(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, edap.EdapPackage.DEVICE__PROPERTIES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_1_0, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 31);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 31);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 31, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 31);
			}
			
			
			|			a8 = 'receives' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createDevice();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_35, 32);
			}
			
			(
				a9 = TEXT				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDevice();
						incompleteObjects.push(element);
					}
					if (a9 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edap.EdapPackage.DEVICE__RECEIVES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_2, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 33);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 33);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 33);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 33, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 33);
			}
			
			(
				(
					a10 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createDevice();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_3_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_37, 34);
					}
					
					(
						a11 = TEXT						
						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createDevice();
								incompleteObjects.push(element);
							}
							if (a11 != null) {
								edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a11).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__RECEIVES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edap.EdapPackage.DEVICE__RECEIVES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_3_0_0_2, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 35);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 35);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 35);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 35, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 35);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 36);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 36);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 36);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 36, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 36);
			}
			
			
			|			a12 = 'sends' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createDevice();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_38, 37);
			}
			
			(
				a13 = TEXT				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDevice();
						incompleteObjects.push(element);
					}
					if (a13 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a13).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edap.EdapPackage.DEVICE__SENDS, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_2, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_39, 38);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 38);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 38);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 38, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 38);
			}
			
			(
				(
					a14 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createDevice();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_3_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_40, 39);
					}
					
					(
						a15 = TEXT						
						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createDevice();
								incompleteObjects.push(element);
							}
							if (a15 != null) {
								edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a15).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a15).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a15).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a15).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SENDS), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edap.EdapPackage.DEVICE__SENDS, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_3_0_0_2, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_39, 40);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 40);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 40);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 40, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 40);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_39, 41);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 41);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 41);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 41, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 41);
			}
			
			
			|			(
				(
					a16_0 = parse_edap_Component					{
						if (terminateParsing) {
							throw new edap.resource.edap.mopp.EdapTerminateParsingException();
						}
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createDevice();
							incompleteObjects.push(element);
						}
						if (a16_0 != null) {
							if (a16_0 != null) {
								Object value = a16_0;
								addObjectToList(element, edap.EdapPackage.DEVICE__COMPOSITE_COMPONENT, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_4_0_0_0_1, a16_0, true);
							copyLocalizationInfos(a16_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 42);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 42);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 42, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 42);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 43);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 43);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 43, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 43);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 44);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 44);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 44, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 44);
	}
	
	a17 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDevice();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a17, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 45);
	}
	
;

parse_edap_SoftwareComponent returns [edap.SoftwareComponent element = null]
@init{
}
:
	(
		(
			(
				a0 = T_ASPECT				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
					}
					if (a0 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("T_ASPECT");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PARTIAL), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
						}
						java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PARTIAL), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 46);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 46);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 47);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 47);
	}
	
	(
		(
			(
				a1 = T_SINGLETON				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
					}
					if (a1 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("T_SINGLETON");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SINGLETON), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
						}
						java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SINGLETON), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 48);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 49);
	}
	
	a2 = 'component' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_41, 50);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 51, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_42, 51);
	}
	
	(
		(
			(
				a4_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_5_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 52, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_42, 52);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 53, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_42, 53);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 54);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 54);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 54);
	}
	
	(
		(
			(
				a6_0 = parse_edap_Message				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__MESSAGES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_0_0, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 55);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 55);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 55);
			}
			
			
			|			(
				a7_0 = parse_edap_Property				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__PROPERTIES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_1_0, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 56);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 56);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 56);
			}
			
			
			|			a8 = 'receives' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_2_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_43, 57);
			}
			
			(
				a9 = TEXT				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
					}
					if (a9 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_2_2, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 58);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 58);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 58);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 58);
			}
			
			(
				(
					a10 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_2_3_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_45, 59);
					}
					
					(
						a11 = TEXT						
						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
								incompleteObjects.push(element);
							}
							if (a11 != null) {
								edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a11).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_2_3_0_0_2, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 60);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 60);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 60);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 60);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 61);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 61);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 61);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 61, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 61);
			}
			
			
			|			a12 = 'sends' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_3_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_46, 62);
			}
			
			(
				a13 = TEXT				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
					}
					if (a13 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a13).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__SENDS, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_3_2, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_47, 63);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 63);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 63);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 63);
			}
			
			(
				(
					a14 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_3_3_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_48, 64);
					}
					
					(
						a15 = TEXT						
						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
								incompleteObjects.push(element);
							}
							if (a15 != null) {
								edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a15).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a15).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a15).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a15).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__SENDS, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_3_3_0_0_2, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_47, 65);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 65);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 65);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 65);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_47, 66);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 66);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 66);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 66, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 66);
			}
			
			
			|			(
				(
					a16_0 = parse_edap_Component					{
						if (terminateParsing) {
							throw new edap.resource.edap.mopp.EdapTerminateParsingException();
						}
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
							incompleteObjects.push(element);
						}
						if (a16_0 != null) {
							if (a16_0 != null) {
								Object value = a16_0;
								addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__COMPOSITE_COMPONENT, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_4_0_0_0_1, a16_0, true);
							copyLocalizationInfos(a16_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 67);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 67);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 67);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 68);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 68);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 68);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 69);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 69);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 69);
	}
	
	(
		(
			(
				a17_0 = parse_edap_StateMachine				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
					}
					if (a17_0 != null) {
						if (a17_0 != null) {
							Object value = a17_0;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__BEHAVIOUR), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_9_0_0_1, a17_0, true);
						copyLocalizationInfos(a17_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 70);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 71);
	}
	
	a18 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a18, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 72);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 72);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 72);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 72);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 72);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 72, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 72);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 72);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 72);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edap_Simulator{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edap_Simulator returns [edap.Simulator element = null]
@init{
}
:
	a0 = 'simulator' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSimulator();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_49, 73);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createSimulator();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_50, 74);
	}
	
	a2 = 'for' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSimulator();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_51, 75);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createSimulator();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__DEVICE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Device proxy = edap.EdapFactory.eINSTANCE.createDevice();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Simulator, edap.Device>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSimulatorDeviceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__DEVICE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__DEVICE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 76, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_52, 76);
	}
	
	(
		(
			(
				a4_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSimulator();
						incompleteObjects.push(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edap.EdapPackage.SIMULATOR__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_5_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 77, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_52, 77);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 78, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_52, 78);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSimulator();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 79);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 79);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
	}
	
	(
		(
			(
				a6_0 = parse_edap_Message				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSimulator();
						incompleteObjects.push(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							addObjectToList(element, edap.EdapPackage.SIMULATOR__MESSAGES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_0_0, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 80);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 80);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
			}
			
			
			|			(
				a7_0 = parse_edap_Property				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSimulator();
						incompleteObjects.push(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, edap.EdapPackage.SIMULATOR__PROPERTIES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_1_0, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 81);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 81);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
			}
			
			
			|			a8 = 'receives' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createSimulator();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_53, 82);
			}
			
			(
				a9 = TEXT				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSimulator();
						incompleteObjects.push(element);
					}
					if (a9 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a9).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edap.EdapPackage.SIMULATOR__RECEIVES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_2, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 83);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 83);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 83);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
			}
			
			(
				(
					a10 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSimulator();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_3_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_55, 84);
					}
					
					(
						a11 = TEXT						
						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createSimulator();
								incompleteObjects.push(element);
							}
							if (a11 != null) {
								edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a11.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a11).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a11).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a11).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a11).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__RECEIVES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edap.EdapPackage.SIMULATOR__RECEIVES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_3_0_0_2, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 85);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 85);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 85);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 86);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 86);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 86);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 86, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
			}
			
			
			|			a12 = 'sends' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createSimulator();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_56, 87);
			}
			
			(
				a13 = TEXT				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSimulator();
						incompleteObjects.push(element);
					}
					if (a13 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a13).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, edap.EdapPackage.SIMULATOR__SENDS, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_2, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_57, 88);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 88);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 88);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
			}
			
			(
				(
					a14 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSimulator();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_3_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_58, 89);
					}
					
					(
						a15 = TEXT						
						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createSimulator();
								incompleteObjects.push(element);
							}
							if (a15 != null) {
								edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a15.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a15).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a15).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a15).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a15).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__SENDS), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, edap.EdapPackage.SIMULATOR__SENDS, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_3_0_0_2, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_57, 90);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 90);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 90);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_57, 91);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 91);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 91);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 91, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
			}
			
			
			|			(
				(
					a16_0 = parse_edap_Component					{
						if (terminateParsing) {
							throw new edap.resource.edap.mopp.EdapTerminateParsingException();
						}
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSimulator();
							incompleteObjects.push(element);
						}
						if (a16_0 != null) {
							if (a16_0 != null) {
								Object value = a16_0;
								addObjectToList(element, edap.EdapPackage.SIMULATOR__COMPOSITE_COMPONENT, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_4_0_0_0_1, a16_0, true);
							copyLocalizationInfos(a16_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 92);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 92);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 93);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 93);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 94);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 94);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
	}
	
	(
		(
			a17_0 = parse_edap_StateMachine			{
				if (terminateParsing) {
					throw new edap.resource.edap.mopp.EdapTerminateParsingException();
				}
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createSimulator();
					incompleteObjects.push(element);
				}
				if (a17_0 != null) {
					if (a17_0 != null) {
						Object value = a17_0;
						element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__BEHAVIOUR), value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_9_0_0_1, a17_0, true);
					copyLocalizationInfos(a17_0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_59, 95);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_59, 96);
	}
	
	a18 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSimulator();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a18, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 97);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 97);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 97);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 97);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 97);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 97, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 97);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 97);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 97);
	}
	
;

parse_edap_Property returns [edap.Property element = null]
@init{
}
:
	(
		(
			(
				a0 = T_READONLY				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createProperty();
						incompleteObjects.push(element);
					}
					if (a0 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("T_READONLY");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__CHANGEABLE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
						}
						java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__CHANGEABLE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 98);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 99);
	}
	
	a1 = 'property' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createProperty();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_60, 100);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createProperty();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_61, 101);
	}
	
	a3 = ':' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createProperty();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_62, 102);
	}
	
	(
		a4 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createProperty();
				incompleteObjects.push(element);
			}
			if (a4 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Type proxy = edap.EdapFactory.eINSTANCE.createEnumeration();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Property, edap.Type>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_6, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_63, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 103, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 103);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 103);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createProperty();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 104);
			}
			
			(
				a6 = INTEGER_LITERAL				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createProperty();
						incompleteObjects.push(element);
					}
					if (a6 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__LOWER_BOUND), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__LOWER_BOUND), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 105);
			}
			
			a7 = '..' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createProperty();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_78, 106);
			}
			
			(
				a8 = INTEGER_LITERAL				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createProperty();
						incompleteObjects.push(element);
					}
					if (a8 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__UPPER_BOUND), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__UPPER_BOUND), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_3, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_79, 107);
			}
			
			a9 = ']' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createProperty();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 108, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 108);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 108);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 109, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 109);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 109);
	}
	
	(
		(
			(
				a10_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createProperty();
						incompleteObjects.push(element);
					}
					if (a10_0 != null) {
						if (a10_0 != null) {
							Object value = a10_0;
							addObjectToList(element, edap.EdapPackage.PROPERTY__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_8_0_0_0, a10_0, true);
						copyLocalizationInfos(a10_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 110);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 111);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edap_Dictionary{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edap_Dictionary returns [edap.Dictionary element = null]
@init{
}
:
	(
		(
			(
				a0 = T_READONLY				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDictionary();
						incompleteObjects.push(element);
					}
					if (a0 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("T_READONLY");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__CHANGEABLE), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
						}
						java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__CHANGEABLE), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_1_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 112);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 113);
	}
	
	a1 = 'dictionary' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDictionary();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_80, 114);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createDictionary();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_81, 115);
	}
	
	a3 = ':' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDictionary();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_82, 116);
	}
	
	(
		a4 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createDictionary();
				incompleteObjects.push(element);
			}
			if (a4 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__INDEX_TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Type proxy = edap.EdapFactory.eINSTANCE.createEnumeration();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Dictionary, edap.Type>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getDictionaryIndexTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__INDEX_TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__INDEX_TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_6, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_83, 117);
	}
	
	a5 = '->' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDictionary();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_84, 118);
	}
	
	(
		a6 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createDictionary();
				incompleteObjects.push(element);
			}
			if (a6 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Type proxy = edap.EdapFactory.eINSTANCE.createEnumeration();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Property, edap.Type>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_8, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_85, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 119, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 119);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 119);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createDictionary();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_86, 120);
			}
			
			(
				a8 = INTEGER_LITERAL				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDictionary();
						incompleteObjects.push(element);
					}
					if (a8 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__LOWER_BOUND), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__LOWER_BOUND), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_1, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_87, 121);
			}
			
			a9 = '..' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createDictionary();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_88, 122);
			}
			
			(
				a10 = INTEGER_LITERAL				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDictionary();
						incompleteObjects.push(element);
					}
					if (a10 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__UPPER_BOUND), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__UPPER_BOUND), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_3, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_89, 123);
			}
			
			a11 = ']' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createDictionary();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 124, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 124);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 124);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 125, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 125);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 125);
	}
	
	(
		(
			(
				a12_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDictionary();
						incompleteObjects.push(element);
					}
					if (a12_0 != null) {
						if (a12_0 != null) {
							Object value = a12_0;
							addObjectToList(element, edap.EdapPackage.DICTIONARY__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_10_0_0_0, a12_0, true);
						copyLocalizationInfos(a12_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 126);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 127);
	}
	
;

parse_edap_Parameter returns [edap.Parameter element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createParameter();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_7_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_90, 128);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createParameter();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_7_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_91, 129);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createParameter();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__TYPE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Type proxy = edap.EdapFactory.eINSTANCE.createEnumeration();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Parameter, edap.Type>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getParameterTypeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__TYPE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__TYPE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_7_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_17, 130);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 130);
	}
	
;

parse_edap_PrimitiveType returns [edap.PrimitiveType element = null]
@init{
}
:
	a0 = 'datatype' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createPrimitiveType();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_92, 131);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createPrimitiveType();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PRIMITIVE_TYPE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PRIMITIVE_TYPE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 132, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_93, 132);
	}
	
	(
		(
			(
				a2_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createPrimitiveType();
						incompleteObjects.push(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edap.EdapPackage.PRIMITIVE_TYPE__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_3_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 133, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_93, 133);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 134, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_93, 134);
	}
	
	a3 = ';' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createPrimitiveType();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
	}
	
;

parse_edap_Enumeration returns [edap.Enumeration element = null]
@init{
}
:
	a0 = 'enumeration' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createEnumeration();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_94, 136);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createEnumeration();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 137);
	}
	
	(
		(
			(
				a2_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createEnumeration();
						incompleteObjects.push(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edap.EdapPackage.ENUMERATION__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_3_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 138, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 138);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 139, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 139);
	}
	
	a3 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createEnumeration();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_96, 140, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 140);
	}
	
	(
		(
			(
				a4_0 = parse_edap_EnumerationLiteral				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createEnumeration();
						incompleteObjects.push(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edap.EdapPackage.ENUMERATION__LITERALS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_6_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_96, 141, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 141);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_96, 142, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 142);
	}
	
	a5 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createEnumeration();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
	}
	
;

parse_edap_EnumerationLiteral returns [edap.EnumerationLiteral element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createEnumerationLiteral();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION_LITERAL__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION_LITERAL__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_10_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 144, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_96, 144, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 144);
	}
	
	(
		(
			(
				a1_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createEnumerationLiteral();
						incompleteObjects.push(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, edap.EdapPackage.ENUMERATION_LITERAL__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_10_0_0_2_0_0_0, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_96, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 145);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 146, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_96, 146, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 146);
	}
	
;

parse_edap_PlatformAnnotation returns [edap.PlatformAnnotation element = null]
@init{
}
:
	(
		a0 = ANNOTATION		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createPlatformAnnotation();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("ANNOTATION");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_11_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 147);
	}
	
	(
		a1 = STRING_LITERAL		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createPlatformAnnotation();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_11_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_19, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_42, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_52, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_93, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 148);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 148);
	}
	
;

parse_edap_StateMachine returns [edap.StateMachine element = null]
@init{
}
:
	a0 = 'statechart' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createStateMachine();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_110, 149);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createStateMachine();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_111, 150);
	}
	
	a2 = 'init' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createStateMachine();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_112, 151);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createStateMachine();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__INITIAL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.State proxy = edap.EdapFactory.eINSTANCE.createState();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.CompositeState, edap.State>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeStateInitialReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__INITIAL), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__INITIAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_6, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 152, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_113, 152);
	}
	
	(
		(
			(
				a4_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createStateMachine();
						incompleteObjects.push(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edap.EdapPackage.STATE_MACHINE__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_7_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 153, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_113, 153);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 154, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_113, 154);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createStateMachine();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 155, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 155, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 155, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 155, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 155);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 155);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 155, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 155, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 155, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 155);
	}
	
	(
		(
			(
				a6_0 = parse_edap_Property				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createStateMachine();
						incompleteObjects.push(element);
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							Object value = a6_0;
							addObjectToList(element, edap.EdapPackage.STATE_MACHINE__PROPERTIES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_10_0_0_1, a6_0, true);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 156, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 156, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 156, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 156, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 156);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 156);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 156, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 156, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 156, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 156);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 157);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 157);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 157);
	}
	
	(
		(
			a7 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createStateMachine();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_11_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_114, 158);
			}
			
			a8 = 'entry' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createStateMachine();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_11_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
			}
			
			(
				a9_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createStateMachine();
						incompleteObjects.push(element);
					}
					if (a9_0 != null) {
						if (a9_0 != null) {
							Object value = a9_0;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__ENTRY), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_11_0_0_5, a9_0, true);
						copyLocalizationInfos(a9_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 160);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 160, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 160, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 160, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 160);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 161);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 161);
	}
	
	(
		(
			a10 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createStateMachine();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_12_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_115, 162);
			}
			
			a11 = 'exit' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createStateMachine();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_12_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
			}
			
			(
				a12_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createStateMachine();
						incompleteObjects.push(element);
					}
					if (a12_0 != null) {
						if (a12_0 != null) {
							Object value = a12_0;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__EXIT), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_12_0_0_5, a12_0, true);
						copyLocalizationInfos(a12_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 164, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 164, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 164, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 164);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 165);
	}
	
	(
		(
			(
				a13_0 = parse_edap_State				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createStateMachine();
						incompleteObjects.push(element);
					}
					if (a13_0 != null) {
						if (a13_0 != null) {
							Object value = a13_0;
							addObjectToList(element, edap.EdapPackage.STATE_MACHINE__SUBSTATE, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_13_0_0_1, a13_0, true);
						copyLocalizationInfos(a13_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 166, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 166, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 166, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 166);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 167, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 167, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 167, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 167);
	}
	
	a14 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createStateMachine();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 168);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_59, 168);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 168);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 168);
	}
	
;

parse_edap_State returns [edap.State element = null]
@init{
}
:
	a0 = 'state' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createState();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_116, 169);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createState();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 170, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_117, 170);
	}
	
	(
		(
			(
				a2_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createState();
						incompleteObjects.push(element);
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							Object value = a2_0;
							addObjectToList(element, edap.EdapPackage.STATE__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_3_0_0_0, a2_0, true);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 171, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_117, 171);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 172, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_117, 172);
	}
	
	a3 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createState();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 173, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 173, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 173, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 173, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 173);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 173);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 173, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 173);
	}
	
	(
		(
			(
				a4_0 = parse_edap_Property				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createState();
						incompleteObjects.push(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edap.EdapPackage.STATE__PROPERTIES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_6_0_0_1, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 174, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 174, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 174, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 174, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 174);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 174);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 174, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 174);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 175);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 175);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 175);
	}
	
	(
		(
			a5 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createState();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_7_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_118, 176);
			}
			
			a6 = 'entry' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createState();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_7_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
			}
			
			(
				a7_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createState();
						incompleteObjects.push(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__ENTRY), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_7_0_0_4, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 178);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 178, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 178);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 179);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 179);
	}
	
	(
		(
			a8 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createState();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_8_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_119, 180);
			}
			
			a9 = 'exit' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createState();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_8_0_0_2, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
			}
			
			(
				a10_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createState();
						incompleteObjects.push(element);
					}
					if (a10_0 != null) {
						if (a10_0 != null) {
							Object value = a10_0;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__EXIT), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_8_0_0_3, a10_0, true);
						copyLocalizationInfos(a10_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 182, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 182);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 183);
	}
	
	(
		(
			(
				a11_0 = parse_edap_Transition				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createState();
						incompleteObjects.push(element);
					}
					if (a11_0 != null) {
						if (a11_0 != null) {
							Object value = a11_0;
							addObjectToList(element, edap.EdapPackage.STATE__OUTGOING, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_9_0_0_0, a11_0, true);
						copyLocalizationInfos(a11_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 184, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 184);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 185, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 185);
	}
	
	a12 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createState();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 186, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 186, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 186, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 186);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 186, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 186);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edap_StateMachine{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edap_CompositeState{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_edap_CompositeState returns [edap.CompositeState element = null]
@init{
}
:
	a0 = 'composite' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCompositeState();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_120, 187);
	}
	
	a1 = 'state' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCompositeState();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_121, 188);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createCompositeState();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_122, 189);
	}
	
	a3 = 'init' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCompositeState();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_123, 190);
	}
	
	(
		a4 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createCompositeState();
				incompleteObjects.push(element);
			}
			if (a4 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__INITIAL), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.State proxy = edap.EdapFactory.eINSTANCE.createState();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.CompositeState, edap.State>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getCompositeStateInitialReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__INITIAL), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__INITIAL), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_8, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 191, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_124, 191);
	}
	
	(
		(
			(
				a5_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createCompositeState();
						incompleteObjects.push(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edap.EdapPackage.COMPOSITE_STATE__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_9_0_0_0, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 192, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_124, 192);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 193, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_124, 193);
	}
	
	a6 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCompositeState();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_11, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 194);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 194);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 194);
	}
	
	(
		(
			(
				a7_0 = parse_edap_Property				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createCompositeState();
						incompleteObjects.push(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, edap.EdapPackage.COMPOSITE_STATE__PROPERTIES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_12_0_0_1, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 195);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 195);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 195);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 196);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 196);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 196);
	}
	
	(
		(
			a8 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createCompositeState();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_13_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_125, 197);
			}
			
			a9 = 'entry' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createCompositeState();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_13_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
			}
			
			(
				a10_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createCompositeState();
						incompleteObjects.push(element);
					}
					if (a10_0 != null) {
						if (a10_0 != null) {
							Object value = a10_0;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__ENTRY), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_13_0_0_5, a10_0, true);
						copyLocalizationInfos(a10_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 199);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 199, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 199, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 199, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 199, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 199);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 200);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 200);
	}
	
	(
		(
			a11 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createCompositeState();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_14_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_126, 201);
			}
			
			a12 = 'exit' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createCompositeState();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_14_0_0_3, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
			}
			
			(
				a13_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createCompositeState();
						incompleteObjects.push(element);
					}
					if (a13_0 != null) {
						if (a13_0 != null) {
							Object value = a13_0;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__EXIT), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_14_0_0_5, a13_0, true);
						copyLocalizationInfos(a13_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 203, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 203, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 203, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 203, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 203);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 204);
	}
	
	(
		(
			(
				a14_0 = parse_edap_Transition				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createCompositeState();
						incompleteObjects.push(element);
					}
					if (a14_0 != null) {
						if (a14_0 != null) {
							Object value = a14_0;
							addObjectToList(element, edap.EdapPackage.COMPOSITE_STATE__OUTGOING, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_15_0_0_0, a14_0, true);
						copyLocalizationInfos(a14_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 205);
			}
			
			
			|			(
				(
					a15_0 = parse_edap_State					{
						if (terminateParsing) {
							throw new edap.resource.edap.mopp.EdapTerminateParsingException();
						}
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createCompositeState();
							incompleteObjects.push(element);
						}
						if (a15_0 != null) {
							if (a15_0 != null) {
								Object value = a15_0;
								addObjectToList(element, edap.EdapPackage.COMPOSITE_STATE__SUBSTATE, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_15_0_1_0_0_0_1, a15_0, true);
							copyLocalizationInfos(a15_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 206);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 207);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 208);
	}
	
	a16 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCompositeState();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_17, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 209);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 209);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edap_StateMachine{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edap_EventReference returns [edap.EventReference element = null]
@init{
}
:
	a0 = 'eventref' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createEventReference();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_15_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 210);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createEventReference();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__MSG_REF), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.ReceiveMessage proxy = edap.EdapFactory.eINSTANCE.createReceiveMessage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.EventReference, edap.ReceiveMessage>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEventReferenceMsgRefReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__MSG_REF), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__MSG_REF), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_15_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 211);
	}
	
	a2 = '.' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createEventReference();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_15_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 212);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createEventReference();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__PARAM_REF), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Parameter proxy = edap.EdapFactory.eINSTANCE.createParameter();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.EventReference, edap.Parameter>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getEventReferenceParamRefReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__PARAM_REF), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__PARAM_REF), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_15_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 213);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 213);
	}
	
;

parse_edap_Unicast returns [edap.Unicast element = null]
@init{
}
:
	a0 = 'send' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createUnicast();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
	}
	
	(
		a1_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createUnicast();
				incompleteObjects.push(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 215);
	}
	
	a2 = '#' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createUnicast();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_155, 216);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createUnicast();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__MESSAGE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.SendAction, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSendActionMessageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__MESSAGE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__MESSAGE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_156, 217);
	}
	
	a4 = '(' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createUnicast();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 218, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 218, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 218, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 218, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 218, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 218, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 218, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 218, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 218, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 218);
	}
	
	(
		(
			(
				a5_0 = parse_edap_Expression				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createUnicast();
						incompleteObjects.push(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edap.EdapPackage.UNICAST__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_6_0_0_0, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 219);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 219);
			}
			
			(
				(
					a6 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createUnicast();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_6_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
					}
					
					(
						a7_0 = parse_edap_Expression						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createUnicast();
								incompleteObjects.push(element);
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									Object value = a7_0;
									addObjectToList(element, edap.EdapPackage.UNICAST__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_6_0_0_1_0_0_2, a7_0, true);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 221);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 221);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 222);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 222);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 223);
	}
	
	a8 = ')' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createUnicast();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 224);
	}
	
	(
		(
			a9 = 'port' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createUnicast();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_8_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_160, 225);
			}
			
			(
				a10 = TEXT				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createUnicast();
						incompleteObjects.push(element);
					}
					if (a10 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PORT), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edap.Port proxy = edap.EdapFactory.eINSTANCE.createPort();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.SendAction, edap.Port>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSendActionPortReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PORT), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PORT), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_8_0_0_1, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 226);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 226);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 226);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 226);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 226);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 226);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 226);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 226, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 226);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 227);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 227);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 227);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 227);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 227);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 227);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 227);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 227, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 227);
	}
	
	(
		(
			(
				a11_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createUnicast();
						incompleteObjects.push(element);
					}
					if (a11_0 != null) {
						if (a11_0 != null) {
							Object value = a11_0;
							addObjectToList(element, edap.EdapPackage.UNICAST__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_9_0_0_0, a11_0, true);
						copyLocalizationInfos(a11_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 228);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 228);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 228);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 228);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 228);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 228);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 228);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 228);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 229);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 229);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 229);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 229);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 229);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 229);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 229);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 229, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 229);
	}
	
;

parse_edap_Broadcast returns [edap.Broadcast element = null]
@init{
}
:
	a0 = 'broadcast' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createBroadcast();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
	}
	
	(
		a1_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createBroadcast();
				incompleteObjects.push(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__TARGET), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 231);
	}
	
	a2 = '#' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createBroadcast();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_161, 232);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createBroadcast();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__MESSAGE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.SendAction, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSendActionMessageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__MESSAGE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__MESSAGE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_162, 233);
	}
	
	a4 = '(' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createBroadcast();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 234, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 234, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 234, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 234, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 234, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 234, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 234, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 234, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 234, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_163, 234);
	}
	
	(
		(
			(
				a5_0 = parse_edap_Expression				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createBroadcast();
						incompleteObjects.push(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, edap.EdapPackage.BROADCAST__PARAMETERS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_6_0_0_0, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_164, 235);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_163, 235);
			}
			
			(
				(
					a6 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createBroadcast();
							incompleteObjects.push(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_6_0_0_1_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
					}
					
					(
						a7_0 = parse_edap_Expression						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createBroadcast();
								incompleteObjects.push(element);
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									Object value = a7_0;
									addObjectToList(element, edap.EdapPackage.BROADCAST__PARAMETERS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_6_0_0_1_0_0_2, a7_0, true);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_164, 237);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_163, 237);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_164, 238);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_163, 238);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_163, 239);
	}
	
	a8 = ')' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createBroadcast();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 240);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 240);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 240);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 240);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 240);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 240);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 240);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 240);
	}
	
;

parse_edap_Transition returns [edap.Transition element = null]
@init{
}
:
	a0 = 'transition' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createTransition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_165, 241);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createTransition();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_166, 242);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createTransition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_167, 243);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createTransition();
				incompleteObjects.push(element);
			}
			if (a3 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__TARGET), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.State proxy = edap.EdapFactory.eINSTANCE.createState();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Transition, edap.State>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getTransitionTargetReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__TARGET), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__TARGET), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_7, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 244, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_168, 244);
	}
	
	(
		(
			(
				a4_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createTransition();
						incompleteObjects.push(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, edap.EdapPackage.TRANSITION__ANNOTATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_8_0_0_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 245, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_168, 245);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_168, 246);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createTransition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_169, 247);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_170, 247);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 247);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 247);
	}
	
	(
		(
			a6 = 'event' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createTransition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_11_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
			}
			
			(
				a7_0 = parse_edap_Event				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createTransition();
						incompleteObjects.push(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, edap.EdapPackage.TRANSITION__EVENT, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_11_0_0_3, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_169, 249);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_170, 249);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 249);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 249);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_169, 250);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_170, 250);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 250);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 250);
	}
	
	(
		(
			a8 = 'guard' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createTransition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_12_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
			}
			
			(
				a9_0 = parse_edap_Expression				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createTransition();
						incompleteObjects.push(element);
					}
					if (a9_0 != null) {
						if (a9_0 != null) {
							Object value = a9_0;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__GUARD), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_12_0_0_3, a9_0, true);
						copyLocalizationInfos(a9_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 252);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 252);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 253);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 253);
	}
	
	(
		(
			a10 = 'action' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createTransition();
					incompleteObjects.push(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_13_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 254, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 254, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 254, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 254, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 254, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 254, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 254, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 254, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 254, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21);
			}
			
			(
				a11_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createTransition();
						incompleteObjects.push(element);
					}
					if (a11_0 != null) {
						if (a11_0 != null) {
							Object value = a11_0;
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__ACTION), value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_13_0_0_3, a11_0, true);
						copyLocalizationInfos(a11_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 255);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 256);
	}
	
	a12 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createTransition();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_15, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 257, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 257);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 257, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 257, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 257, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 257);
	}
	
;

parse_edap_ReceiveMessage returns [edap.ReceiveMessage element = null]
@init{
}
:
	(
		a0_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createReceiveMessage();
				incompleteObjects.push(element);
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					Object value = a0_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__DEVICE), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_19_0_0_0, a0_0, true);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 258);
	}
	
	a1 = '#' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createReceiveMessage();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_19_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_171, 259);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createReceiveMessage();
				incompleteObjects.push(element);
			}
			if (a2 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__MESSAGE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.ReceiveMessage, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getReceiveMessageMessageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__MESSAGE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__MESSAGE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_19_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_169, 260);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_170, 260);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 260);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 260);
	}
	
;

parse_edap_PropertyAssignment returns [edap.PropertyAssignment element = null]
@init{
}
:
	a0 = 'set' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createPropertyAssignment();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_172, 261);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createPropertyAssignment();
				incompleteObjects.push(element);
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__PROPERTY), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Property proxy = edap.EdapFactory.eINSTANCE.createProperty();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.PropertyAssignment, edap.Property>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyAssignmentPropertyReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__PROPERTY), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__PROPERTY), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_173, 262);
	}
	
	a2 = '=' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createPropertyAssignment();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 263, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 263, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 263, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 263, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 263, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 263, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 263, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 263, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 263, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
	}
	
	(
		a3_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createPropertyAssignment();
				incompleteObjects.push(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_6, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 264);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 264);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 264);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 264);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 264);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 264);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 264);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 264, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 264);
	}
	
;

parse_edap_ActionBlock returns [edap.ActionBlock element = null]
@init{
}
:
	a0 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createActionBlock();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_21_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 265, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 265, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 265, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 265, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 265, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 265, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 265, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 265, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 265, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 265);
	}
	
	(
		(
			(
				a1_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createActionBlock();
						incompleteObjects.push(element);
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							Object value = a1_0;
							addObjectToList(element, edap.EdapPackage.ACTION_BLOCK__ACTIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_21_0_0_1_0_0_1, a1_0, true);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 266);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 267);
	}
	
	a2 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createActionBlock();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_21_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 268);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 268);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 268);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 268);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 268);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 268);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 268);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 268);
	}
	
;

parse_edap_ExternStatement returns [edap.ExternStatement element = null]
@init{
}
:
	(
		a0 = STRING_EXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createExternStatement();
				incompleteObjects.push(element);
			}
			if (a0 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_EXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_STATEMENT__STATEMENT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_STATEMENT__STATEMENT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_22_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 269, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 269);
	}
	
;

parse_edap_ConditionalAction returns [edap.ConditionalAction element = null]
@init{
}
:
	a0 = 'if' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createConditionalAction();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_174, 270);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createConditionalAction();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 271, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 271, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 271, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 271, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 271, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 271, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 271, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 271, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 271, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
	}
	
	(
		a2_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createConditionalAction();
				incompleteObjects.push(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONDITIONAL_ACTION__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_4, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_175, 272);
	}
	
	a3 = ')' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createConditionalAction();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
	}
	
	(
		a4_0 = parse_edap_Action		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createConditionalAction();
				incompleteObjects.push(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONDITIONAL_ACTION__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_8, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 274);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 274);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 274);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 274);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 274);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 274);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 274);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 274, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 274);
	}
	
;

parse_edap_LoopAction returns [edap.LoopAction element = null]
@init{
}
:
	a0 = 'while' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createLoopAction();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_176, 275);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createLoopAction();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
	}
	
	(
		a2_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createLoopAction();
				incompleteObjects.push(element);
			}
			if (a2_0 != null) {
				if (a2_0 != null) {
					Object value = a2_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOOP_ACTION__CONDITION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_4, a2_0, true);
				copyLocalizationInfos(a2_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_177, 277);
	}
	
	a3 = ')' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createLoopAction();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 278, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 278, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 278, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 278, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 278, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 278, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 278, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 278, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 278, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
	}
	
	(
		a4_0 = parse_edap_Action		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createLoopAction();
				incompleteObjects.push(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOOP_ACTION__ACTION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_8, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 279);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 279);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 279);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 279);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 279);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 279);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 279);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 279);
	}
	
;

parse_edap_PrintAction returns [edap.PrintAction element = null]
@init{
}
:
	a0 = 'print' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createPrintAction();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 280, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 280, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 280, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 280, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 280, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 280, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 280, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 280, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 280, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
	}
	
	(
		a1_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createPrintAction();
				incompleteObjects.push(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PRINT_ACTION__MSG), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 281);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 281);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 281);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 281);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 281);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 281);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 281);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 281, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 281);
	}
	
;

parse_edap_ErrorAction returns [edap.ErrorAction element = null]
@init{
}
:
	a0 = 'error' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createErrorAction();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_26_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 282, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_26);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 282, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_26);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 282, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_26);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 282, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_26);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 282, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_26);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 282, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_26);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 282, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_26);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 282, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_26);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 282, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_26);
	}
	
	(
		a1_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createErrorAction();
				incompleteObjects.push(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.ERROR_ACTION__MSG), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_26_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 283);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 283);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 283);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 283);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 283);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 283);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 283);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 283, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 283);
	}
	
;

parseop_Expression_level_1 returns [edap.Expression element = null]
@init{
}
:
	leftArg = parseop_Expression_level_2	((
		()
		{ element = null; }
		a0 = 'or' {
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createOrExpression();
				incompleteObjects.push(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_2, null, true);
			copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 284, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 284, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 284, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 284, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 284, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 284, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 284, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 284, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 284, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
		}
		
		rightArg = parseop_Expression_level_2		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createOrExpression();
				incompleteObjects.push(element);
			}
			if (leftArg != null) {
				if (leftArg != null) {
					Object value = leftArg;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.OR_EXPRESSION__LHS), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_0, leftArg, true);
				copyLocalizationInfos(leftArg, element);
			}
		}
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createOrExpression();
				incompleteObjects.push(element);
			}
			if (rightArg != null) {
				if (rightArg != null) {
					Object value = rightArg;
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.OR_EXPRESSION__RHS), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_4, rightArg, true);
				copyLocalizationInfos(rightArg, element);
			}
		}
		{ leftArg = element; /* this may become an argument in the next iteration */ }
	)+ | /* epsilon */ { element = leftArg; }
	
)
;

parseop_Expression_level_2 returns [edap.Expression element = null]
@init{
}
:
leftArg = parseop_Expression_level_3((
	()
	{ element = null; }
	a0 = 'and' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createAndExpression();
			incompleteObjects.push(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_28_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 285, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 285, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 285, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 285, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 285, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 285, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 285, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 285, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 285, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	}
	
	rightArg = parseop_Expression_level_3	{
		if (terminateParsing) {
			throw new edap.resource.edap.mopp.EdapTerminateParsingException();
		}
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createAndExpression();
			incompleteObjects.push(element);
		}
		if (leftArg != null) {
			if (leftArg != null) {
				Object value = leftArg;
				element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.AND_EXPRESSION__LHS), value);
				completedElement(value, true);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_28_0_0_0, leftArg, true);
			copyLocalizationInfos(leftArg, element);
		}
	}
	{
		if (terminateParsing) {
			throw new edap.resource.edap.mopp.EdapTerminateParsingException();
		}
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createAndExpression();
			incompleteObjects.push(element);
		}
		if (rightArg != null) {
			if (rightArg != null) {
				Object value = rightArg;
				element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.AND_EXPRESSION__RHS), value);
				completedElement(value, true);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_28_0_0_4, rightArg, true);
			copyLocalizationInfos(rightArg, element);
		}
	}
	{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_Expression_level_3 returns [edap.Expression element = null]
@init{
}
:
leftArg = parseop_Expression_level_4((
()
{ element = null; }
a0 = '<' {
	if (element == null) {
		element = edap.EdapFactory.eINSTANCE.createLowerExpression();
		incompleteObjects.push(element);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_29_0_0_2, null, true);
	copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
	// expected elements (follow set)
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 286, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 286, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 286, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 286, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 286, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 286, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 286, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 286, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 286, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
}

rightArg = parseop_Expression_level_4{
	if (terminateParsing) {
		throw new edap.resource.edap.mopp.EdapTerminateParsingException();
	}
	if (element == null) {
		element = edap.EdapFactory.eINSTANCE.createLowerExpression();
		incompleteObjects.push(element);
	}
	if (leftArg != null) {
		if (leftArg != null) {
			Object value = leftArg;
			element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOWER_EXPRESSION__LHS), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_29_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new edap.resource.edap.mopp.EdapTerminateParsingException();
	}
	if (element == null) {
		element = edap.EdapFactory.eINSTANCE.createLowerExpression();
		incompleteObjects.push(element);
	}
	if (rightArg != null) {
		if (rightArg != null) {
			Object value = rightArg;
			element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.LOWER_EXPRESSION__RHS), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_29_0_0_4, rightArg, true);
		copyLocalizationInfos(rightArg, element);
	}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '>' {
	if (element == null) {
		element = edap.EdapFactory.eINSTANCE.createGreaterExpression();
		incompleteObjects.push(element);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_30_0_0_2, null, true);
	copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
	// expected elements (follow set)
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 287, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 287, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 287, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 287, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 287, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 287, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 287, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 287, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 287, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
}

rightArg = parseop_Expression_level_4{
	if (terminateParsing) {
		throw new edap.resource.edap.mopp.EdapTerminateParsingException();
	}
	if (element == null) {
		element = edap.EdapFactory.eINSTANCE.createGreaterExpression();
		incompleteObjects.push(element);
	}
	if (leftArg != null) {
		if (leftArg != null) {
			Object value = leftArg;
			element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.GREATER_EXPRESSION__LHS), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_30_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new edap.resource.edap.mopp.EdapTerminateParsingException();
	}
	if (element == null) {
		element = edap.EdapFactory.eINSTANCE.createGreaterExpression();
		incompleteObjects.push(element);
	}
	if (rightArg != null) {
		if (rightArg != null) {
			Object value = rightArg;
			element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.GREATER_EXPRESSION__RHS), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_30_0_0_4, rightArg, true);
		copyLocalizationInfos(rightArg, element);
	}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '==' {
	if (element == null) {
		element = edap.EdapFactory.eINSTANCE.createEqualsExpression();
		incompleteObjects.push(element);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_31_0_0_2, null, true);
	copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
	// expected elements (follow set)
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
	addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
}

rightArg = parseop_Expression_level_4{
	if (terminateParsing) {
		throw new edap.resource.edap.mopp.EdapTerminateParsingException();
	}
	if (element == null) {
		element = edap.EdapFactory.eINSTANCE.createEqualsExpression();
		incompleteObjects.push(element);
	}
	if (leftArg != null) {
		if (leftArg != null) {
			Object value = leftArg;
			element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EQUALS_EXPRESSION__LHS), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_31_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new edap.resource.edap.mopp.EdapTerminateParsingException();
	}
	if (element == null) {
		element = edap.EdapFactory.eINSTANCE.createEqualsExpression();
		incompleteObjects.push(element);
	}
	if (rightArg != null) {
		if (rightArg != null) {
			Object value = rightArg;
			element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EQUALS_EXPRESSION__RHS), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_31_0_0_4, rightArg, true);
		copyLocalizationInfos(rightArg, element);
	}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_Expression_level_4 returns [edap.Expression element = null]
@init{
}
:
leftArg = parseop_Expression_level_5((
()
{ element = null; }
a0 = '+' {
if (element == null) {
	element = edap.EdapFactory.eINSTANCE.createPlusExpression();
	incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_32_0_0_2, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
}

rightArg = parseop_Expression_level_5{
if (terminateParsing) {
	throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
	element = edap.EdapFactory.eINSTANCE.createPlusExpression();
	incompleteObjects.push(element);
}
if (leftArg != null) {
	if (leftArg != null) {
		Object value = leftArg;
		element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLUS_EXPRESSION__LHS), value);
		completedElement(value, true);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_32_0_0_0, leftArg, true);
	copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
	throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
	element = edap.EdapFactory.eINSTANCE.createPlusExpression();
	incompleteObjects.push(element);
}
if (rightArg != null) {
	if (rightArg != null) {
		Object value = rightArg;
		element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLUS_EXPRESSION__RHS), value);
		completedElement(value, true);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_32_0_0_4, rightArg, true);
	copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '-' {
if (element == null) {
	element = edap.EdapFactory.eINSTANCE.createMinusExpression();
	incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_33_0_0_2, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
}

rightArg = parseop_Expression_level_5{
if (terminateParsing) {
	throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
	element = edap.EdapFactory.eINSTANCE.createMinusExpression();
	incompleteObjects.push(element);
}
if (leftArg != null) {
	if (leftArg != null) {
		Object value = leftArg;
		element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.MINUS_EXPRESSION__LHS), value);
		completedElement(value, true);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_33_0_0_0, leftArg, true);
	copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
	throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
	element = edap.EdapFactory.eINSTANCE.createMinusExpression();
	incompleteObjects.push(element);
}
if (rightArg != null) {
	if (rightArg != null) {
		Object value = rightArg;
		element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.MINUS_EXPRESSION__RHS), value);
		completedElement(value, true);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_33_0_0_4, rightArg, true);
	copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_Expression_level_5 returns [edap.Expression element = null]
@init{
}
:
leftArg = parseop_Expression_level_6((
()
{ element = null; }
a0 = '*' {
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createTimesExpression();
incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_34_0_0_2, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 291, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 291, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 291, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 291, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 291, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 291, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 291, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 291, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 291, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
}

rightArg = parseop_Expression_level_6{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createTimesExpression();
incompleteObjects.push(element);
}
if (leftArg != null) {
if (leftArg != null) {
	Object value = leftArg;
	element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TIMES_EXPRESSION__LHS), value);
	completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_34_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createTimesExpression();
incompleteObjects.push(element);
}
if (rightArg != null) {
if (rightArg != null) {
	Object value = rightArg;
	element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TIMES_EXPRESSION__RHS), value);
	completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_34_0_0_4, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '/' {
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createDivExpression();
incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_35_0_0_2, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
}

rightArg = parseop_Expression_level_6{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createDivExpression();
incompleteObjects.push(element);
}
if (leftArg != null) {
if (leftArg != null) {
	Object value = leftArg;
	element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DIV_EXPRESSION__LHS), value);
	completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_35_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createDivExpression();
incompleteObjects.push(element);
}
if (rightArg != null) {
if (rightArg != null) {
	Object value = rightArg;
	element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DIV_EXPRESSION__RHS), value);
	completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_35_0_0_4, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
a0 = '\u0025' {
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createModExpression();
incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_36_0_0_2, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_27);
}

rightArg = parseop_Expression_level_6{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createModExpression();
incompleteObjects.push(element);
}
if (leftArg != null) {
if (leftArg != null) {
	Object value = leftArg;
	element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.MOD_EXPRESSION__LHS), value);
	completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_36_0_0_0, leftArg, true);
copyLocalizationInfos(leftArg, element);
}
}
{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createModExpression();
incompleteObjects.push(element);
}
if (rightArg != null) {
if (rightArg != null) {
	Object value = rightArg;
	element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.MOD_EXPRESSION__RHS), value);
	completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_36_0_0_4, rightArg, true);
copyLocalizationInfos(rightArg, element);
}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_Expression_level_6 returns [edap.Expression element = null]
@init{
}
:
a0 = '-' {
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createUnaryMinus();
incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_37_0_0_0, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
}

arg = parseop_Expression_level_7{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createUnaryMinus();
incompleteObjects.push(element);
}
if (arg != null) {
if (arg != null) {
Object value = arg;
element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNARY_MINUS__TERM), value);
completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_37_0_0_2, arg, true);
copyLocalizationInfos(arg, element);
}
}
|
a0 = 'not' {
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createNotExpression();
incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_38_0_0_0, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_28);
}

arg = parseop_Expression_level_7{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createNotExpression();
incompleteObjects.push(element);
}
if (arg != null) {
if (arg != null) {
Object value = arg;
element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.NOT_EXPRESSION__TERM), value);
completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_38_0_0_2, arg, true);
copyLocalizationInfos(arg, element);
}
}
|

arg = parseop_Expression_level_7{ element = arg; }
;

parseop_Expression_level_7 returns [edap.Expression element = null]
@init{
}
:
arg = parseop_Expression_level_8(
(
a0 = '.' {
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createPropertyNavigation();
incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_39_0_0_2_0_0_0, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_178, 296);
}

(
a1 = TEXT
{
if (terminateParsing) {
	throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
	element = edap.EdapFactory.eINSTANCE.createPropertyNavigation();
	incompleteObjects.push(element);
}
if (a1 != null) {
	edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
	tokenResolver.setOptions(getOptions());
	edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
	tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_NAVIGATION__PROPERTY), result);
	Object resolvedObject = result.getResolvedToken();
	if (resolvedObject == null) {
		addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
	}
	String resolved = (String) resolvedObject;
	edap.Property proxy = edap.EdapFactory.eINSTANCE.createProperty();
	collectHiddenTokens(element);
	registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.PropertyNavigation, edap.Property>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyNavigationPropertyReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_NAVIGATION__PROPERTY), resolved, proxy);
	if (proxy != null) {
		Object value = proxy;
		element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_NAVIGATION__PROPERTY), value);
		completedElement(value, false);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_39_0_0_2_0_0_2, proxy, true);
	copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
	copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 297);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 297);
}

)
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 298);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 298);
}

{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createPropertyNavigation();
incompleteObjects.push(element);
}
if (arg != null) {
if (arg != null) {
Object value = arg;
element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_NAVIGATION__TARGET), value);
completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_39_0_0_0, arg, true);
copyLocalizationInfos(arg, element);
}
}
|
/* epsilon */ { element = arg; } 
)
;

parseop_Expression_level_8 returns [edap.Expression element = null]
@init{
}
:
c0 = parse_edap_ExpressionGroup{ element = c0; /* this is a subclass or primitive expression choice */ }
|c1 = parse_edap_PropertyReference{ element = c1; /* this is a subclass or primitive expression choice */ }
|c2 = parse_edap_IntegerLitteral{ element = c2; /* this is a subclass or primitive expression choice */ }
|c3 = parse_edap_StringLitteral{ element = c3; /* this is a subclass or primitive expression choice */ }
|c4 = parse_edap_BooleanLitteral{ element = c4; /* this is a subclass or primitive expression choice */ }
|c5 = parse_edap_ExternExpression{ element = c5; /* this is a subclass or primitive expression choice */ }
;

parse_edap_ExpressionGroup returns [edap.ExpressionGroup element = null]
@init{
}
:
a0 = '(' {
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createExpressionGroup();
incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_40_0_0_0, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 299, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_29);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 299, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_29);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 299, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_29);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 299, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_29);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 299, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_29);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 299, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_29);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 299, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_29);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 299, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_29);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 299, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_29);
}

(
a1_0 = parse_edap_Expression{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createExpressionGroup();
incompleteObjects.push(element);
}
if (a1_0 != null) {
if (a1_0 != null) {
Object value = a1_0;
element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXPRESSION_GROUP__EXP), value);
completedElement(value, true);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_40_0_0_1, a1_0, true);
copyLocalizationInfos(a1_0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 300);
}

a2 = ')' {
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createExpressionGroup();
incompleteObjects.push(element);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_40_0_0_2, null, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
}
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 301, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 301);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 301);
}

;

parse_edap_PropertyReference returns [edap.PropertyReference element = null]
@init{
}
:
(
a0 = TEXT
{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createPropertyReference();
incompleteObjects.push(element);
}
if (a0 != null) {
edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
tokenResolver.setOptions(getOptions());
edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_REFERENCE__PROPERTY), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
}
String resolved = (String) resolvedObject;
edap.Property proxy = edap.EdapFactory.eINSTANCE.createProperty();
collectHiddenTokens(element);
registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.PropertyReference, edap.Property>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyReferencePropertyReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_REFERENCE__PROPERTY), resolved, proxy);
if (proxy != null) {
Object value = proxy;
element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_REFERENCE__PROPERTY), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_41_0_0_0, proxy, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 302, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 302);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 302);
}

;

parse_edap_IntegerLitteral returns [edap.IntegerLitteral element = null]
@init{
}
:
(
a0 = INTEGER_LITERAL
{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createIntegerLitteral();
incompleteObjects.push(element);
}
if (a0 != null) {
edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
tokenResolver.setOptions(getOptions());
edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.INTEGER_LITTERAL__INT_VALUE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
}
java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
if (resolved != null) {
Object value = resolved;
element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.INTEGER_LITTERAL__INT_VALUE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_42_0_0_0, resolved, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 303, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 303);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 303);
}

;

parse_edap_StringLitteral returns [edap.StringLitteral element = null]
@init{
}
:
(
a0 = STRING_LITERAL
{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createStringLitteral();
incompleteObjects.push(element);
}
if (a0 != null) {
edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
tokenResolver.setOptions(getOptions());
edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.STRING_LITTERAL__STRING_VALUE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
}
java.lang.String resolved = (java.lang.String)resolvedObject;
if (resolved != null) {
Object value = resolved;
element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STRING_LITTERAL__STRING_VALUE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_43_0_0_0, resolved, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 304, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 304);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 304);
}

;

parse_edap_BooleanLitteral returns [edap.BooleanLitteral element = null]
@init{
}
:
(
a0 = BOOLEAN_LITERAL
{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createBooleanLitteral();
incompleteObjects.push(element);
}
if (a0 != null) {
edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("BOOLEAN_LITERAL");
tokenResolver.setOptions(getOptions());
edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.BOOLEAN_LITTERAL__BOOL_VALUE), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
}
java.lang.Boolean resolved = (java.lang.Boolean)resolvedObject;
if (resolved != null) {
Object value = resolved;
element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.BOOLEAN_LITTERAL__BOOL_VALUE), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_44_0_0_0, resolved, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 305, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 305);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 305);
}

;

parse_edap_ExternExpression returns [edap.ExternExpression element = null]
@init{
}
:
(
a0 = STRING_EXT
{
if (terminateParsing) {
throw new edap.resource.edap.mopp.EdapTerminateParsingException();
}
if (element == null) {
element = edap.EdapFactory.eINSTANCE.createExternExpression();
incompleteObjects.push(element);
}
if (a0 != null) {
edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_EXT");
tokenResolver.setOptions(getOptions());
edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_EXPRESSION__EXPRESSION), result);
Object resolvedObject = result.getResolvedToken();
if (resolvedObject == null) {
addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
}
java.lang.String resolved = (java.lang.String)resolvedObject;
if (resolved != null) {
Object value = resolved;
element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_EXPRESSION__EXPRESSION), value);
completedElement(value, false);
}
collectHiddenTokens(element);
retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_45_0_0_0, resolved, true);
copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
}
}
)
{
// expected elements (follow set)
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 306, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 306);
addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 306);
}

;

parse_edap_Type returns [edap.Type element = null]
:
c0 = parse_edap_Device{ element = c0; /* this is a subclass or primitive expression choice */ }
|c1 = parse_edap_SoftwareComponent{ element = c1; /* this is a subclass or primitive expression choice */ }
|c2 = parse_edap_Simulator{ element = c2; /* this is a subclass or primitive expression choice */ }
|c3 = parse_edap_PrimitiveType{ element = c3; /* this is a subclass or primitive expression choice */ }
|c4 = parse_edap_Enumeration{ element = c4; /* this is a subclass or primitive expression choice */ }

;

parse_edap_Component returns [edap.Component element = null]
:
c0 = parse_edap_Device{ element = c0; /* this is a subclass or primitive expression choice */ }
|c1 = parse_edap_SoftwareComponent{ element = c1; /* this is a subclass or primitive expression choice */ }
|c2 = parse_edap_Simulator{ element = c2; /* this is a subclass or primitive expression choice */ }

;

parse_edap_Action returns [edap.Action element = null]
:
c0 = parse_edap_Unicast{ element = c0; /* this is a subclass or primitive expression choice */ }
|c1 = parse_edap_Broadcast{ element = c1; /* this is a subclass or primitive expression choice */ }
|c2 = parse_edap_PropertyAssignment{ element = c2; /* this is a subclass or primitive expression choice */ }
|c3 = parse_edap_ActionBlock{ element = c3; /* this is a subclass or primitive expression choice */ }
|c4 = parse_edap_ExternStatement{ element = c4; /* this is a subclass or primitive expression choice */ }
|c5 = parse_edap_ConditionalAction{ element = c5; /* this is a subclass or primitive expression choice */ }
|c6 = parse_edap_LoopAction{ element = c6; /* this is a subclass or primitive expression choice */ }
|c7 = parse_edap_PrintAction{ element = c7; /* this is a subclass or primitive expression choice */ }
|c8 = parse_edap_ErrorAction{ element = c8; /* this is a subclass or primitive expression choice */ }

;

parse_edap_Expression returns [edap.Expression element = null]
:
c = parseop_Expression_level_1{ element = c; /* this rule is an expression root */ }

;

parse_edap_Event returns [edap.Event element = null]
:
c0 = parse_edap_ReceiveMessage{ element = c0; /* this is a subclass or primitive expression choice */ }

;

SL_COMMENT:
('//'(~('\n'|'\r'|'\uffff'))* )
{ _channel = 99; }
;
ML_COMMENT:
('/*'.*'*/')
{ _channel = 99; }
;
ANNOTATION:
('@'('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
;
BOOLEAN_LITERAL:
('true'|'false')
;
INTEGER_LITERAL:
(('1'..'9') ('0'..'9')* | '0')
;
STRING_LITERAL:
('"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"')
;
STRING_EXT:
('\''('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'\''))*'\'')
;
T_MULTICAST:
('multicast')
;
T_READONLY:
('readonly')
;
T_ASPECT:
('aspect')
;
T_SINGLETON:
('singleton')
;
WHITESPACE:
((' '|'\t'|'\f'))
{ _channel = 99; }
;
LINEBREAKS:
(('\r\n'|'\r'|'\n'))
{ _channel = 99; }
;
TEXT:
(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' )+ (':' ':' ('A'..'Z' | 'a'..'z' | '0'..'9' | '_')+ )* )
;

