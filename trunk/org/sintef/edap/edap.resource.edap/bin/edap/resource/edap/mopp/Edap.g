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
	
	/**
	 * the index of the last token that was handled by retrieveLayoutInformation()
	 */
	private int lastPosition2;
	
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
	 * A collection that is filled with commands to be executed after parsing. This
	 * collection is cleared before parsing starts and returned as part of the parse
	 * result object.
	 */
	private java.util.Collection<edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>> postParseCommands;
	
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
	 * a collection to store all anonymous tokens
	 */
	private java.util.List<org.antlr.runtime3_2_0.CommonToken> anonymousTokens = new java.util.ArrayList<org.antlr.runtime3_2_0.CommonToken>();
	
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
	
	protected void addErrorToResource(final String errorMessage, final int line, final int charPositionInLine, final int startIndex, final int stopIndex) {
		postParseCommands.add(new edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>() {
			public boolean execute(edap.resource.edap.IEdapTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new edap.resource.edap.IEdapProblem() {
					public edap.resource.edap.EdapEProblemType getType() {
						return edap.resource.edap.EdapEProblemType.ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<edap.resource.edap.IEdapQuickFix> getQuickFixes() {
						return null;
					}
				}, line, charPositionInLine, startIndex, stopIndex);
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
			if (type.getInstanceClass() == edap.ActionBlock.class) {
				return parse_edap_ActionBlock();
			}
			if (type.getInstanceClass() == edap.ExternStatement.class) {
				return parse_edap_ExternStatement();
			}
			if (type.getInstanceClass() == edap.PropertyAssignment.class) {
				return parse_edap_PropertyAssignment();
			}
			if (type.getInstanceClass() == edap.ExternExpression.class) {
				return parse_edap_ExternExpression();
			}
			if (type.getInstanceClass() == edap.ComponentReference.class) {
				return parse_edap_ComponentReference();
			}
			if (type.getInstanceClass() == edap.EventReference.class) {
				return parse_edap_EventReference();
			}
			if (type.getInstanceClass() == edap.PropertyNavigation.class) {
				return parse_edap_PropertyNavigation();
			}
			if (type.getInstanceClass() == edap.DictionaryNavigation.class) {
				return parse_edap_DictionaryNavigation();
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
			if (type.getInstanceClass() == edap.Connector.class) {
				return parse_edap_Connector();
			}
			if (type.getInstanceClass() == edap.Port.class) {
				return parse_edap_Port();
			}
			if (type.getInstanceClass() == edap.CreateAction.class) {
				return parse_edap_CreateAction();
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
				dummyResource.getContents().add(root);
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
		int followSetID = 299;
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
	
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
		postParseCommands.add(new edap.resource.edap.IEdapCommand<edap.resource.edap.IEdapTextResource>() {
			public boolean execute(edap.resource.edap.IEdapTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.registerContextDependentProxy(factory, element, reference, id, proxy);
				return true;
			}
		});
	}
	
	/**
	 * Translates errors thrown by the parser into human readable messages.
	 */
	public void reportError(final org.antlr.runtime3_2_0.RecognitionException e)  {
		String message = e.getMessage();
		if (e instanceof org.antlr.runtime3_2_0.MismatchedTokenException) {
			org.antlr.runtime3_2_0.MismatchedTokenException mte = (org.antlr.runtime3_2_0.MismatchedTokenException) e;
			String tokenName = "<unknown>";
			if (mte.expecting == Token.EOF) {
				tokenName = "EOF";
			} else {
				tokenName = getTokenNames()[mte.expecting];
				tokenName = edap.resource.edap.util.EdapStringUtil.formatTokenName(tokenName);
			}
			message = "Syntax error on token \"" + e.token.getText() + "\", \"" + tokenName + "\" expected";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedTreeNodeException) {
			org.antlr.runtime3_2_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_2_0.MismatchedTreeNodeException) e;
			String tokenName = "<unknown>";
			if (mtne.expecting == Token.EOF) {
				tokenName = "EOF";
			} else {
				tokenName = getTokenNames()[mtne.expecting];
			}
			message = "mismatched tree node: " + "xxx" + "; expecting " + tokenName;
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
			message ="required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedSetException) {
			org.antlr.runtime3_2_0.MismatchedSetException mse = (org.antlr.runtime3_2_0.MismatchedSetException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedNotSetException) {
			org.antlr.runtime3_2_0.MismatchedNotSetException mse = (org.antlr.runtime3_2_0.MismatchedNotSetException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
		} else if (e instanceof org.antlr.runtime3_2_0.MismatchedRangeException) {
			org.antlr.runtime3_2_0.MismatchedRangeException mre = (org.antlr.runtime3_2_0.MismatchedRangeException) e;
			message ="mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
		} else if (e instanceof org.antlr.runtime3_2_0.FailedPredicateException) {
			org.antlr.runtime3_2_0.FailedPredicateException fpe = (org.antlr.runtime3_2_0.FailedPredicateException) e;
			message ="rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
		}
		addErrorToResource(message, e.index, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
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
	
	protected void retrieveLayoutInformation(org.eclipse.emf.ecore.EObject element, edap.resource.edap.grammar.EdapSyntaxElement syntaxElement, Object object) {
		if (!(syntaxElement instanceof edap.resource.edap.grammar.EdapPlaceholder) && !(syntaxElement instanceof edap.resource.edap.grammar.EdapKeyword)) {
			return;
		}
		edap.resource.edap.mopp.EdapLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(element);
		for (org.antlr.runtime3_2_0.CommonToken anonymousToken : anonymousTokens) {
			layoutInformationAdapter.addLayoutInformation(new edap.resource.edap.mopp.EdapLayoutInformation(syntaxElement, object, anonymousToken.getStartIndex(), anonymousToken.getText(), ""));
		}
		anonymousTokens.clear();
		int currentPos = getTokenStream().index();
		if (currentPos == 0) {
			return;
		}
		int endPos = currentPos - 1;
		for (; endPos >= this.lastPosition2; endPos--) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(endPos);
			int _channel = token.getChannel();
			if (_channel != 99) {
				break;
			}
		}
		StringBuilder hiddenTokenText = new StringBuilder();
		StringBuilder visibleTokenText = new StringBuilder();
		org.antlr.runtime3_2_0.CommonToken firstToken = null;
		for (int pos = this.lastPosition2; pos <= endPos; pos++) {
			org.antlr.runtime3_2_0.Token token = getTokenStream().get(pos);
			if (firstToken == null) {
				firstToken = (org.antlr.runtime3_2_0.CommonToken) token;
			}
			int _channel = token.getChannel();
			if (_channel == 99) {
				hiddenTokenText.append(token.getText());
			} else {
				visibleTokenText.append(token.getText());
			}
		}
		int offset = -1;
		if (firstToken != null) {
			offset = firstToken.getStartIndex();
		}
		layoutInformationAdapter.addLayoutInformation(new edap.resource.edap.mopp.EdapLayoutInformation(syntaxElement, object, offset, hiddenTokenText.toString(), visibleTokenText.toString()));
		this.lastPosition2 = (endPos < 0 ? 0 : endPos + 1);
	}
	
	protected edap.resource.edap.mopp.EdapLayoutInformationAdapter getLayoutInformationAdapter(org.eclipse.emf.ecore.EObject element) {
		for (org.eclipse.emf.common.notify.Adapter adapter : element.eAdapters()) {
			if (adapter instanceof edap.resource.edap.mopp.EdapLayoutInformationAdapter) {
				return (edap.resource.edap.mopp.EdapLayoutInformationAdapter) adapter;
			}
		}
		edap.resource.edap.mopp.EdapLayoutInformationAdapter newAdapter = new edap.resource.edap.mopp.EdapLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
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
		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
	}
	(
		c0 = parse_edap_EdapModel{ element = c0; }
	)
	EOF	
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
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_0_0_0_0_0_0_1, null);
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
						// initialize boolean attributes
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
							addObjectToList(element, edap.EdapPackage.EDAP_MODEL__IMPORTS, proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_0_0_0_0_0_0_3, proxy);
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
							// initialize boolean attributes
						}
						if (a2_0 != null) {
							if (a2_0 != null) {
								addObjectToList(element, edap.EdapPackage.EDAP_MODEL__TYPES, a2_0);
								completedElement(a2_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_0_0_0_1_0_0_1_0_0_0, a2_0);
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
						// initialize boolean attributes
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
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__ALLOW_MULTICAST), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_0_0_0_0, resolved);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_1, null);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.MESSAGE__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_3, resolved);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_4, null);
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
						// initialize boolean attributes
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							addObjectToList(element, edap.EdapPackage.MESSAGE__PARAMETERS, a4_0);
							completedElement(a4_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_5_0_0_0, a4_0);
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
							// initialize boolean attributes
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_5_0_0_1_0_0_0, null);
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
								// initialize boolean attributes
							}
							if (a6_0 != null) {
								if (a6_0 != null) {
									addObjectToList(element, edap.EdapPackage.MESSAGE__PARAMETERS, a6_0);
									completedElement(a6_0, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_5_0_0_1_0_0_1, a6_0);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_6, null);
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
						// initialize boolean attributes
					}
					if (a8_0 != null) {
						if (a8_0 != null) {
							addObjectToList(element, edap.EdapPackage.MESSAGE__ANNOTATIONS, a8_0);
							completedElement(a8_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_7_0_0_0, a8_0);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_8, null);
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
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 20, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 20);
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
						// initialize boolean attributes
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
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__PARTIAL), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_0_0_0_0, resolved);
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
						// initialize boolean attributes
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
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__SINGLETON), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_1_0_0_0, resolved);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_35, 25);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DEVICE__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_4, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 26, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 26);
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
						// initialize boolean attributes
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							addObjectToList(element, edap.EdapPackage.DEVICE__ANNOTATIONS, a4_0);
							completedElement(a4_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_5_0_0_0, a4_0);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 27, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 27);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 28, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 28);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDevice();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_7, null);
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
						// initialize boolean attributes
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							addObjectToList(element, edap.EdapPackage.DEVICE__MESSAGES, a6_0);
							completedElement(a6_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_0_0, a6_0);
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
						// initialize boolean attributes
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							addObjectToList(element, edap.EdapPackage.DEVICE__PROPERTIES, a7_0);
							completedElement(a7_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_1_0, a7_0);
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
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_37, 32);
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
						// initialize boolean attributes
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
							addObjectToList(element, edap.EdapPackage.DEVICE__RECEIVES, proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_2, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_38, 33);
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
							// initialize boolean attributes
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_3_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_39, 34);
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
								// initialize boolean attributes
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
									addObjectToList(element, edap.EdapPackage.DEVICE__RECEIVES, proxy);
									completedElement(proxy, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_3_0_0_2, proxy);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_38, 35);
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
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_38, 36);
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
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_40, 37);
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
						// initialize boolean attributes
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
							addObjectToList(element, edap.EdapPackage.DEVICE__SENDS, proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_2, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_41, 38);
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
							// initialize boolean attributes
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_3_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_42, 39);
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
								// initialize boolean attributes
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
									addObjectToList(element, edap.EdapPackage.DEVICE__SENDS, proxy);
									completedElement(proxy, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_3_0_0_2, proxy);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_41, 40);
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
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_41, 41);
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
							// initialize boolean attributes
						}
						if (a16_0 != null) {
							if (a16_0 != null) {
								addObjectToList(element, edap.EdapPackage.DEVICE__COMPOSITE_COMPONENT, a16_0);
								completedElement(a16_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_4_0_0_0_1, a16_0);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_10, null);
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
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 45, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 45);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 45);
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
						// initialize boolean attributes
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
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__PARTIAL), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_0_0_0_0, resolved);
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
						// initialize boolean attributes
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
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SINGLETON), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_1_0_0_0, resolved);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_43, 50);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_4, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 51, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 51);
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
						// initialize boolean attributes
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__ANNOTATIONS, a4_0);
							completedElement(a4_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_5_0_0_0, a4_0);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 52, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 52);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 53, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 53);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_7, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 54);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 54);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 54, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 54);
	}
	
	(
		(
			(
				a6_0 = parse_edap_Port				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__PORTS, a6_0);
							completedElement(a6_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_0_0, a6_0);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 55);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 55);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 55, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 55);
			}
			
			
			|			(
				a7_0 = parse_edap_Connector				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__CONNECTORS, a7_0);
							completedElement(a7_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_1_0, a7_0);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 56);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 56);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 56, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 56);
			}
			
			
			|			(
				a8_0 = parse_edap_Message				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a8_0 != null) {
						if (a8_0 != null) {
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__MESSAGES, a8_0);
							completedElement(a8_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_2_0, a8_0);
						copyLocalizationInfos(a8_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 57);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 57);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 57, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 57);
			}
			
			
			|			(
				a9_0 = parse_edap_Property				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a9_0 != null) {
						if (a9_0 != null) {
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__PROPERTIES, a9_0);
							completedElement(a9_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_3_0, a9_0);
						copyLocalizationInfos(a9_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 58);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 58);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 58, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 58);
			}
			
			
			|			a10 = 'receives' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_4_0, null);
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
						// initialize boolean attributes
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
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES, proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_4_2, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_46, 60);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 60);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 60);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 60, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 60);
			}
			
			(
				(
					a12 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_4_3_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_47, 61);
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
								// initialize boolean attributes
							}
							if (a13 != null) {
								edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a13.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a13).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a13).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a13).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a13).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReceivesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES), resolved, proxy);
								if (proxy != null) {
									addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__RECEIVES, proxy);
									completedElement(proxy, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_4_3_0_0_2, proxy);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_46, 62);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 62);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 62);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 62, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 62);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_46, 63);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 63);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 63);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 63, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 63);
			}
			
			
			|			a14 = 'sends' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_5_0, null);
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
						// initialize boolean attributes
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
							addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__SENDS, proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_5_2, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_49, 65);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 65);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 65);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 65, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 65);
			}
			
			(
				(
					a16 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_5_3_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_50, 66);
					}
					
					(
						a17 = TEXT						
						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
								incompleteObjects.push(element);
								// initialize boolean attributes
							}
							if (a17 != null) {
								edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a17.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a17).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a17).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a17).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a17).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
								collectHiddenTokens(element);
								registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Component, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentSendsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__SENDS), resolved, proxy);
								if (proxy != null) {
									addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__SENDS, proxy);
									completedElement(proxy, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_5_3_0_0_2, proxy);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a17, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a17, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_49, 67);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 67);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 67);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 67, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 67);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_49, 68);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 68);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 68);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 68, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 68);
			}
			
			
			|			(
				(
					a18_0 = parse_edap_Component					{
						if (terminateParsing) {
							throw new edap.resource.edap.mopp.EdapTerminateParsingException();
						}
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a18_0 != null) {
							if (a18_0 != null) {
								addObjectToList(element, edap.EdapPackage.SOFTWARE_COMPONENT__COMPOSITE_COMPONENT, a18_0);
								completedElement(a18_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_6_0_0_0_1, a18_0);
							copyLocalizationInfos(a18_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 69);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 69);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 69, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 69);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 70);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 70);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 70, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 70);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 71);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 71);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 71, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 71);
	}
	
	(
		(
			(
				a19_0 = parse_edap_StateMachine				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a19_0 != null) {
						if (a19_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SOFTWARE_COMPONENT__BEHAVIOUR), a19_0);
							completedElement(a19_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_9_0_0_1, a19_0);
						copyLocalizationInfos(a19_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 72);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 73);
	}
	
	a20 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_11, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a20, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 74);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 74);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 74);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 74);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 74);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 74, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 74);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 74);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 74);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_51, 75);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_2, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_52, 76);
	}
	
	a2 = 'for' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSimulator();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_53, 77);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__DEVICE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_4, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 78, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 78);
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
						// initialize boolean attributes
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							addObjectToList(element, edap.EdapPackage.SIMULATOR__ANNOTATIONS, a4_0);
							completedElement(a4_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_5_0_0_0, a4_0);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 79);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 80);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSimulator();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_7, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 81);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 81);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 81, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
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
						// initialize boolean attributes
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							addObjectToList(element, edap.EdapPackage.SIMULATOR__MESSAGES, a6_0);
							completedElement(a6_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_0_0, a6_0);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 82);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 82);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 82, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
			}
			
			
			|			(
				a7_0 = parse_edap_Property				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createSimulator();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							addObjectToList(element, edap.EdapPackage.SIMULATOR__PROPERTIES, a7_0);
							completedElement(a7_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_1_0, a7_0);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 83);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 83);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 83, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
			}
			
			
			|			a8 = 'receives' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createSimulator();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_55, 84);
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
						// initialize boolean attributes
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
							addObjectToList(element, edap.EdapPackage.SIMULATOR__RECEIVES, proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_2, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a9, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_56, 85);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 85);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 85);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 85, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
			}
			
			(
				(
					a10 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSimulator();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_3_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_57, 86);
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
								// initialize boolean attributes
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
									addObjectToList(element, edap.EdapPackage.SIMULATOR__RECEIVES, proxy);
									completedElement(proxy, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_3_0_0_2, proxy);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a11, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_56, 87);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 87);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 87);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 87, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_56, 88);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 88);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 88);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 88, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
			}
			
			
			|			a12 = 'sends' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createSimulator();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_58, 89);
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
						// initialize boolean attributes
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
							addObjectToList(element, edap.EdapPackage.SIMULATOR__SENDS, proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_2, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a13, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_59, 90);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 90);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 90);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 90, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
			}
			
			(
				(
					a14 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createSimulator();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_3_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_60, 91);
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
								// initialize boolean attributes
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
									addObjectToList(element, edap.EdapPackage.SIMULATOR__SENDS, proxy);
									completedElement(proxy, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_3_0_0_2, proxy);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, element);
								copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a15, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_59, 92);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 92);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 92);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 92, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_59, 93);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 93);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 93);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 93, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
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
							// initialize boolean attributes
						}
						if (a16_0 != null) {
							if (a16_0 != null) {
								addObjectToList(element, edap.EdapPackage.SIMULATOR__COMPOSITE_COMPONENT, a16_0);
								completedElement(a16_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_4_0_0_0_1, a16_0);
							copyLocalizationInfos(a16_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 94);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 94);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 94, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 95);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 95);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 95, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 96);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 96);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 96, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
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
					// initialize boolean attributes
				}
				if (a17_0 != null) {
					if (a17_0 != null) {
						element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.SIMULATOR__BEHAVIOUR), a17_0);
						completedElement(a17_0, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_9_0_0_1, a17_0);
					copyLocalizationInfos(a17_0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_61, 97);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_61, 98);
	}
	
	a18 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createSimulator();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_11, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a18, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 99);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 99);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 99);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 99);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 99);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 99, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 99);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 99);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 99);
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
						// initialize boolean attributes
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
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__CHANGEABLE), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_1_0_0_0, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 100);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 101);
	}
	
	a1 = 'property' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createProperty();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_62, 102);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_4, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_63, 103);
	}
	
	a3 = ':' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createProperty();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 104);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__TYPE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_6, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_65, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 105, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 105);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 105);
	}
	
	(
		(
			a5 = '[' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createProperty();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_78, 106);
			}
			
			(
				a6 = MULTIPLICITY				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createProperty();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a6 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MULTIPLICITY");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__LOWER_BOUND), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a6).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__LOWER_BOUND), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_1, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_79, 107);
			}
			
			a7 = '..' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createProperty();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_2, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_80, 108);
			}
			
			(
				a8 = MULTIPLICITY				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createProperty();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a8 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MULTIPLICITY");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__UPPER_BOUND), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY__UPPER_BOUND), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_3, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_81, 109);
			}
			
			a9 = ']' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createProperty();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_4, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
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
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 110, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 110);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 110);
			}
			
		)
		
	)?	{
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
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 111, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 111);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 111);
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
						// initialize boolean attributes
					}
					if (a10_0 != null) {
						if (a10_0 != null) {
							addObjectToList(element, edap.EdapPackage.PROPERTY__ANNOTATIONS, a10_0);
							completedElement(a10_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_8_0_0_0, a10_0);
						copyLocalizationInfos(a10_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 112, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 112);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 112);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 113, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 113);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 113);
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
						// initialize boolean attributes
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
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__CHANGEABLE), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_1_0_0_0, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 114);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 115);
	}
	
	a1 = 'dictionary' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDictionary();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_82, 116);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_4, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_83, 117);
	}
	
	a3 = ':' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDictionary();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_84, 118);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__INDEX_TYPE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_6, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_85, 119);
	}
	
	a5 = '->' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDictionary();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_7, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_86, 120);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__TYPE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_8, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a6, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_87, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 121, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 121);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 121);
	}
	
	(
		(
			a7 = '[' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createDictionary();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_88, 122);
			}
			
			(
				a8 = MULTIPLICITY				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDictionary();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a8 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MULTIPLICITY");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__LOWER_BOUND), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a8).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__LOWER_BOUND), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_1, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a8, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_89, 123);
			}
			
			a9 = '..' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createDictionary();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_2, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_90, 124);
			}
			
			(
				a10 = MULTIPLICITY				
				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createDictionary();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a10 != null) {
						edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("MULTIPLICITY");
						tokenResolver.setOptions(getOptions());
						edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a10.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__UPPER_BOUND), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a10).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a10).getStopIndex());
						}
						java.lang.Integer resolved = (java.lang.Integer)resolvedObject;
						if (resolved != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY__UPPER_BOUND), resolved);
							completedElement(resolved, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_3, resolved);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_91, 125);
			}
			
			a11 = ']' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createDictionary();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_4, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
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
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 126, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 126);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 126);
			}
			
		)
		
	)?	{
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
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 127, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 127);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 127);
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
						// initialize boolean attributes
					}
					if (a12_0 != null) {
						if (a12_0 != null) {
							addObjectToList(element, edap.EdapPackage.DICTIONARY__ANNOTATIONS, a12_0);
							completedElement(a12_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_10_0_0_0, a12_0);
						copyLocalizationInfos(a12_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 128, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 128);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 128);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_24, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_25, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_26, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_33, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_34, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 129, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 129);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 129);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_7_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_92, 130);
	}
	
	a1 = ':' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createParameter();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_7_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_93, 131);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PARAMETER__TYPE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_7_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_17, 132);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 132);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_94, 133);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PRIMITIVE_TYPE__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_2, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 134, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 134);
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
						// initialize boolean attributes
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							addObjectToList(element, edap.EdapPackage.PRIMITIVE_TYPE__ANNOTATIONS, a2_0);
							completedElement(a2_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_3_0_0_0, a2_0);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 135);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 136, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 136);
	}
	
	a3 = ';' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createPrimitiveType();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_4, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 137, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_96, 138);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_2, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 139, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 139);
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
						// initialize boolean attributes
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							addObjectToList(element, edap.EdapPackage.ENUMERATION__ANNOTATIONS, a2_0);
							completedElement(a2_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_3_0_0_0, a2_0);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 140, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 140);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 141, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 141);
	}
	
	a3 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createEnumeration();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 142, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 142);
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
						// initialize boolean attributes
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							addObjectToList(element, edap.EdapPackage.ENUMERATION__LITERALS, a4_0);
							completedElement(a4_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_6_0_0_0, a4_0);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 143);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 144, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 144);
	}
	
	a5 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createEnumeration();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_7, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_8, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_9, 145, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_0);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.ENUMERATION_LITERAL__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_10_0_0_1, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 146, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 146, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 146);
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
						// initialize boolean attributes
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							addObjectToList(element, edap.EdapPackage.ENUMERATION_LITERAL__ANNOTATIONS, a1_0);
							completedElement(a1_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_10_0_0_2_0_0_0, a1_0);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 147, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 147, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 147);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 148);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_11_0_0_1, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 149);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PLATFORM_ANNOTATION__VALUE), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_11_0_0_3, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_19, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 150, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 150);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 150);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 151);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_2, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_110, 152);
	}
	
	a2 = 'init' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createStateMachine();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_4, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_111, 153);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__INITIAL), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_6, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 154, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_112, 154);
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
						// initialize boolean attributes
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							addObjectToList(element, edap.EdapPackage.STATE_MACHINE__ANNOTATIONS, a4_0);
							completedElement(a4_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_7_0_0_0, a4_0);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 155, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_112, 155);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 156, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_112, 156);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createStateMachine();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_9, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 157);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 157);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 157, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 157);
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
						// initialize boolean attributes
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							addObjectToList(element, edap.EdapPackage.STATE_MACHINE__PROPERTIES, a6_0);
							completedElement(a6_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_10_0_0_1, a6_0);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 158, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 158, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 158, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 158, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 158);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 158);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 158, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 158, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 158, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 158);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_66, 159);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 159);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 159, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 159);
	}
	
	(
		(
			a7 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createStateMachine();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_11_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_113, 160);
			}
			
			a8 = 'entry' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createStateMachine();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_11_0_0_3, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
			}
			
			(
				a9_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createStateMachine();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a9_0 != null) {
						if (a9_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__ENTRY), a9_0);
							completedElement(a9_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_11_0_0_5, a9_0);
						copyLocalizationInfos(a9_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 162);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 162, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 162, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 162, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 162);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 163);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 163);
	}
	
	(
		(
			a10 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createStateMachine();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_12_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_114, 164);
			}
			
			a11 = 'exit' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createStateMachine();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_12_0_0_3, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
			}
			
			(
				a12_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createStateMachine();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a12_0 != null) {
						if (a12_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE_MACHINE__EXIT), a12_0);
							completedElement(a12_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_12_0_0_5, a12_0);
						copyLocalizationInfos(a12_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 166, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 166, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 166, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 166);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 167, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 167, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 167, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 167);
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
						// initialize boolean attributes
					}
					if (a13_0 != null) {
						if (a13_0 != null) {
							addObjectToList(element, edap.EdapPackage.STATE_MACHINE__SUBSTATE, a13_0);
							completedElement(a13_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_13_0_0_1, a13_0);
						copyLocalizationInfos(a13_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 168);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 169, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 169, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 169, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 169);
	}
	
	a14 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createStateMachine();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_15, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 170);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_61, 170);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 170, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 170, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 170, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 170);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 170, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 170);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_115, 171);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_2, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 172, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_116, 172);
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
						// initialize boolean attributes
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							addObjectToList(element, edap.EdapPackage.STATE__ANNOTATIONS, a2_0);
							completedElement(a2_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_3_0_0_0, a2_0);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 173, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_116, 173);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 174, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_116, 174);
	}
	
	a3 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createState();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 175);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 175);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 175, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 175);
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
						// initialize boolean attributes
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							addObjectToList(element, edap.EdapPackage.STATE__PROPERTIES, a4_0);
							completedElement(a4_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_6_0_0_1, a4_0);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 176, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 176, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 176, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 176, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 176);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 176);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 176, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 176);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_71, 177);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 177);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 177, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 177);
	}
	
	(
		(
			a5 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createState();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_7_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_117, 178);
			}
			
			a6 = 'entry' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createState();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_7_0_0_3, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
			}
			
			(
				a7_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createState();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__ENTRY), a7_0);
							completedElement(a7_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_7_0_0_4, a7_0);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 180);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 180, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 180);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 181);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 181);
	}
	
	(
		(
			a8 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createState();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_8_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_118, 182);
			}
			
			a9 = 'exit' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createState();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_8_0_0_2, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
			}
			
			(
				a10_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createState();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a10_0 != null) {
						if (a10_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.STATE__EXIT), a10_0);
							completedElement(a10_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_8_0_0_3, a10_0);
						copyLocalizationInfos(a10_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 184, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 184);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 185, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 185);
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
						// initialize boolean attributes
					}
					if (a11_0 != null) {
						if (a11_0 != null) {
							addObjectToList(element, edap.EdapPackage.STATE__OUTGOING, a11_0);
							completedElement(a11_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_9_0_0_0, a11_0);
						copyLocalizationInfos(a11_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 186, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 186);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 187, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 187);
	}
	
	a12 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createState();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_11, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 188, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 188, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 188, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 188);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 188, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 188);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_119, 189);
	}
	
	a1 = 'state' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCompositeState();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_120, 190);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_4, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_121, 191);
	}
	
	a3 = 'init' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCompositeState();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_6, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_122, 192);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__INITIAL), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_8, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 193, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_123, 193);
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
						// initialize boolean attributes
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							addObjectToList(element, edap.EdapPackage.COMPOSITE_STATE__ANNOTATIONS, a5_0);
							completedElement(a5_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_9_0_0_0, a5_0);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_123, 194);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_123, 195);
	}
	
	a6 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCompositeState();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_11, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 196);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 196);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 196, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 196);
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
						// initialize boolean attributes
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							addObjectToList(element, edap.EdapPackage.COMPOSITE_STATE__PROPERTIES, a7_0);
							completedElement(a7_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_12_0_0_1, a7_0);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 197, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 197, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 197, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 197, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 197);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 197);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 197, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 197, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 197, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 197, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 197);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_12);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_75, 198);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 198);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 198, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 198);
	}
	
	(
		(
			a8 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createCompositeState();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_13_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_124, 199);
			}
			
			a9 = 'entry' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createCompositeState();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_13_0_0_3, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
			}
			
			(
				a10_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createCompositeState();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a10_0 != null) {
						if (a10_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__ENTRY), a10_0);
							completedElement(a10_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_13_0_0_5, a10_0);
						copyLocalizationInfos(a10_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 201);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 201, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 201, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 201, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 201, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 201);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 202);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 202);
	}
	
	(
		(
			a11 = 'on' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createCompositeState();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_14_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_125, 203);
			}
			
			a12 = 'exit' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createCompositeState();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_14_0_0_3, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
			}
			
			(
				a13_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createCompositeState();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a13_0 != null) {
						if (a13_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPOSITE_STATE__EXIT), a13_0);
							completedElement(a13_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_14_0_0_5, a13_0);
						copyLocalizationInfos(a13_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 205);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 206);
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
						// initialize boolean attributes
					}
					if (a14_0 != null) {
						if (a14_0 != null) {
							addObjectToList(element, edap.EdapPackage.COMPOSITE_STATE__OUTGOING, a14_0);
							completedElement(a14_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_15_0_0_0, a14_0);
						copyLocalizationInfos(a14_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 207);
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
							// initialize boolean attributes
						}
						if (a15_0 != null) {
							if (a15_0 != null) {
								addObjectToList(element, edap.EdapPackage.COMPOSITE_STATE__SUBSTATE, a15_0);
								completedElement(a15_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_15_0_1_0_0_0_1, a15_0);
							copyLocalizationInfos(a15_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 208);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 209);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 210, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 210, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 210, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 210, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 210);
	}
	
	a16 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCompositeState();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_17, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 211, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 211, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 211, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 211);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 211, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 211);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edap_StateMachine{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edap_ActionBlock returns [edap.ActionBlock element = null]
@init{
}
:
	a0 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createActionBlock();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_15_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 212);
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
						// initialize boolean attributes
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							addObjectToList(element, edap.EdapPackage.ACTION_BLOCK__ACTIONS, a1_0);
							completedElement(a1_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_15_0_0_1_0_0_1, a1_0);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 213);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 214);
	}
	
	a2 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createActionBlock();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_15_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 215);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 215);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 215);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 215);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 215);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 215);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 215, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 215);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 215);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_STATEMENT__STATEMENT), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_16_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 216);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 216);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 216);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 216);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 216);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 216);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 216, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 216);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 216);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_126, 217);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__PROPERTY), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 218);
	}
	
	a2 = '=' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createPropertyAssignment();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_4, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 219, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 219, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 219, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16);
	}
	
	(
		a3_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createPropertyAssignment();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_ASSIGNMENT__EXPRESSION), a3_0);
					completedElement(a3_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_6, a3_0);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 220);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 220);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 220);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 220);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 220);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 220);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 220, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 220);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 220);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EXTERN_EXPRESSION__EXPRESSION), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_18_0_0_0, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 221, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 221);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 221);
	}
	
;

parse_edap_ComponentReference returns [edap.ComponentReference element = null]
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
				element = edap.EdapFactory.eINSTANCE.createComponentReference();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a0 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.COMPONENT_REFERENCE__COMPONENT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Component proxy = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.ComponentReference, edap.Component>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getComponentReferenceComponentReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.COMPONENT_REFERENCE__COMPONENT), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.COMPONENT_REFERENCE__COMPONENT), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_19_0_0_0, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 222);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 222, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
	}
	
	(
		(
			(
				a1_0 = parse_edap_PropertyNavigation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createComponentReference();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a1_0 != null) {
						if (a1_0 != null) {
							addObjectToList(element, edap.EdapPackage.COMPONENT_REFERENCE__PROPERTY_NAVIGATIONS, a1_0);
							completedElement(a1_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_19_0_0_1_0_0_0, a1_0);
						copyLocalizationInfos(a1_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 223);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 223, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 224);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 224, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
	}
	
;

parse_edap_EventReference returns [edap.EventReference element = null]
@init{
}
:
	a0 = 'eventref' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createEventReference();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 225);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__MSG_REF), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 226);
	}
	
	a2 = '.' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createEventReference();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 227);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.EVENT_REFERENCE__PARAM_REF), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_4, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 228, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 228);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 228);
	}
	
;

parse_edap_PropertyNavigation returns [edap.PropertyNavigation element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createPropertyNavigation();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_21_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 229);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PROPERTY_NAVIGATION__PROPERTY), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_21_0_0_1, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 230);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 230, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
	}
	
	|//derived choice rules for sub-classes: 
	
	c0 = parse_edap_DictionaryNavigation{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

parse_edap_DictionaryNavigation returns [edap.DictionaryNavigation element = null]
@init{
}
:
	a0 = '.' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDictionaryNavigation();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_22_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 231);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createDictionaryNavigation();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY_NAVIGATION__PROPERTY), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Property proxy = edap.EdapFactory.eINSTANCE.createProperty();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.PropertyNavigation, edap.Property>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getPropertyNavigationPropertyReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY_NAVIGATION__PROPERTY), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY_NAVIGATION__PROPERTY), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_22_0_0_1, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 232);
	}
	
	a2 = '[' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDictionaryNavigation();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_22_0_0_2, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 233, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 233, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 233, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18);
	}
	
	(
		a3_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createDictionaryNavigation();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.DICTIONARY_NAVIGATION__INDEX), a3_0);
					completedElement(a3_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_22_0_0_3, a3_0);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 234);
	}
	
	a4 = ']' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createDictionaryNavigation();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_22_0_0_4, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_135, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_136, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_17);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 235);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 235, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
	}
	
	(
		a1_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createUnicast();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__TARGET), a1_0);
					completedElement(a1_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_2, a1_0);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 237);
	}
	
	a2 = '.' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createUnicast();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 238);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__MESSAGE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_4, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 239);
	}
	
	a4 = '(' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createUnicast();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 240);
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
						// initialize boolean attributes
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							addObjectToList(element, edap.EdapPackage.UNICAST__PARAMETERS, a5_0);
							completedElement(a5_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_6_0_0_0, a5_0);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 241);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 241);
			}
			
			(
				(
					a6 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createUnicast();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_6_0_0_1_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 242, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 242, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 242, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
					}
					
					(
						a7_0 = parse_edap_Expression						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createUnicast();
								incompleteObjects.push(element);
								// initialize boolean attributes
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									addObjectToList(element, edap.EdapPackage.UNICAST__PARAMETERS, a7_0);
									completedElement(a7_0, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_6_0_0_1_0_0_2, a7_0);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 243);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 243);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 244);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 244);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 245);
	}
	
	a8 = ')' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createUnicast();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_7, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_147, 246);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 246);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 246);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 246);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 246);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 246);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 246);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 246, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 246);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 246);
	}
	
	(
		(
			a9 = 'port' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createUnicast();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_8_0_0_0, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 247);
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
						// initialize boolean attributes
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
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.UNICAST__PORT), proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_8_0_0_1, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a10, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 248);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 248);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 248);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 248);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 248);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 248);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 248, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 248);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 248);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 249);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 249);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 249);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 249);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 249);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 249);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 249, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 249);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 249);
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
						// initialize boolean attributes
					}
					if (a11_0 != null) {
						if (a11_0 != null) {
							addObjectToList(element, edap.EdapPackage.UNICAST__ANNOTATIONS, a11_0);
							completedElement(a11_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_9_0_0_0, a11_0);
						copyLocalizationInfos(a11_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 250);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 250);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 250);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 250);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 250);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 250);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 250, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 250);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 250);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 251);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 251);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 251);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 251);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 251);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 251);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 251, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 251);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 251);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 252, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 252, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 252, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
	}
	
	(
		a1_0 = parse_edap_Expression		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createBroadcast();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__TARGET), a1_0);
					completedElement(a1_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_2, a1_0);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 253);
	}
	
	a2 = '.' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createBroadcast();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 254);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.BROADCAST__MESSAGE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_4, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 255);
	}
	
	a4 = '(' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createBroadcast();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 256, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 256, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 256, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 256);
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
						// initialize boolean attributes
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							addObjectToList(element, edap.EdapPackage.BROADCAST__PARAMETERS, a5_0);
							completedElement(a5_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_6_0_0_0, a5_0);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 257);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 257);
			}
			
			(
				(
					a6 = ',' {
						if (element == null) {
							element = edap.EdapFactory.eINSTANCE.createBroadcast();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_6_0_0_1_0_0_0, null);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 258, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 258, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 258, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
					}
					
					(
						a7_0 = parse_edap_Expression						{
							if (terminateParsing) {
								throw new edap.resource.edap.mopp.EdapTerminateParsingException();
							}
							if (element == null) {
								element = edap.EdapFactory.eINSTANCE.createBroadcast();
								incompleteObjects.push(element);
								// initialize boolean attributes
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									addObjectToList(element, edap.EdapPackage.BROADCAST__PARAMETERS, a7_0);
									completedElement(a7_0, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_6_0_0_1_0_0_2, a7_0);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 259);
						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 259);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 260);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 260);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 261);
	}
	
	a8 = ')' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createBroadcast();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_7, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 262);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 262);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 262);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 262);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 262);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 262);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 262, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 262);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 262);
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
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 263);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_3, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 264);
	}
	
	a2 = '->' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createTransition();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_155, 265);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__TARGET), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_7, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_156, 266);
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
						// initialize boolean attributes
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							addObjectToList(element, edap.EdapPackage.TRANSITION__ANNOTATIONS, a4_0);
							completedElement(a4_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_8_0_0_0, a4_0);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_156, 267);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_156, 268);
	}
	
	a5 = '{' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createTransition();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_10, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 269);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 269);
	}
	
	(
		(
			a6 = 'event' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createTransition();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_11_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 270, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 270, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 270, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
			}
			
			(
				a7_0 = parse_edap_Event				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createTransition();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							addObjectToList(element, edap.EdapPackage.TRANSITION__EVENT, a7_0);
							completedElement(a7_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_11_0_0_3, a7_0);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 271);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 271);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 271);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 271);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 272);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 272);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 272);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 272);
	}
	
	(
		(
			a8 = 'guard' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createTransition();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_12_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
			}
			
			(
				a9_0 = parse_edap_Expression				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createTransition();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a9_0 != null) {
						if (a9_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__GUARD), a9_0);
							completedElement(a9_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_12_0_0_3, a9_0);
						copyLocalizationInfos(a9_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 274);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 274);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 275);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 275);
	}
	
	(
		(
			a10 = 'action' {
				if (element == null) {
					element = edap.EdapFactory.eINSTANCE.createTransition();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_13_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
			}
			
			(
				a11_0 = parse_edap_Action				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createTransition();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a11_0 != null) {
						if (a11_0 != null) {
							element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.TRANSITION__ACTION), a11_0);
							completedElement(a11_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_13_0_0_3, a11_0);
						copyLocalizationInfos(a11_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 277);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 278);
	}
	
	a12 = '}' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createTransition();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_15, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 279);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 279);
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
				// initialize boolean attributes
			}
			if (a0_0 != null) {
				if (a0_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__DEVICE), a0_0);
					completedElement(a0_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_26_0_0_0, a0_0);
				copyLocalizationInfos(a0_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 280);
	}
	
	a1 = '#' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createReceiveMessage();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_26_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_160, 281);
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
				// initialize boolean attributes
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
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.RECEIVE_MESSAGE__MESSAGE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_26_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 282);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 282);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 282);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 282);
	}
	
;

parse_edap_Connector returns [edap.Connector element = null]
@init{
}
:
	a0 = 'connector' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createConnector();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_161, 283);
	}
	
	a1 = '(' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createConnector();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_1, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_162, 284);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createConnector();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a2 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT1), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Port proxy = edap.EdapFactory.eINSTANCE.createPort();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Connector, edap.Port>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectorPort1ReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT1), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT1), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_163, 285);
	}
	
	a3 = ',' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createConnector();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_164, 286);
	}
	
	(
		a4 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createConnector();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a4 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT2), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Port proxy = edap.EdapFactory.eINSTANCE.createPort();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edap.resource.edap.mopp.EdapContextDependentURIFragmentFactory<edap.Connector, edap.Port>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getConnectorPort2ReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT2), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.CONNECTOR__PORT2), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_4, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_165, 287);
	}
	
	a5 = ')' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createConnector();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 288);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 288);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 288, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 288);
	}
	
	(
		(
			(
				a6_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createConnector();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a6_0 != null) {
						if (a6_0 != null) {
							addObjectToList(element, edap.EdapPackage.CONNECTOR__ANNOTATIONS, a6_0);
							completedElement(a6_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_6_0_0_0, a6_0);
						copyLocalizationInfos(a6_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 289);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 289);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 289, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 289);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 290);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 290);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 290, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 290);
	}
	
;

parse_edap_Port returns [edap.Port element = null]
@init{
}
:
	a0 = 'port' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createPort();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_28_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_166, 291);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createPort();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1 != null) {
				edap.resource.edap.IEdapTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edap.resource.edap.IEdapTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edap.EdapPackage.PORT__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.PORT__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_28_0_0_2, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 292);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 292);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 292, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 292);
	}
	
	(
		(
			(
				a2_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createPort();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							addObjectToList(element, edap.EdapPackage.PORT__ANNOTATIONS, a2_0);
							completedElement(a2_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_28_0_0_3_0_0_0, a2_0);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 293);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 293);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 293, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 293);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_27, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_6);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_28, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_7);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_11, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_3);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_20, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_22, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_4);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_29, 294);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_30, 294);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_1, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_4, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_7, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_5);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 294, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_8);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 294);
	}
	
;

parse_edap_CreateAction returns [edap.CreateAction element = null]
@init{
}
:
	a0 = 'create' {
		if (element == null) {
			element = edap.EdapFactory.eINSTANCE.createCreateAction();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_29_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
	}
	
	(
		a1_0 = parse_edap_ComponentReference		{
			if (terminateParsing) {
				throw new edap.resource.edap.mopp.EdapTerminateParsingException();
			}
			if (element == null) {
				element = edap.EdapFactory.eINSTANCE.createCreateAction();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					element.eSet(element.eClass().getEStructuralFeature(edap.EdapPackage.CREATE_ACTION__REF), a1_0);
					completedElement(a1_0, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_29_0_0_1, a1_0);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 296);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 296);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 296);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 296);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 296);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 296);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 296, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 296);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 296);
	}
	
	(
		(
			(
				a2_0 = parse_edap_PlatformAnnotation				{
					if (terminateParsing) {
						throw new edap.resource.edap.mopp.EdapTerminateParsingException();
					}
					if (element == null) {
						element = edap.EdapFactory.eINSTANCE.createCreateAction();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a2_0 != null) {
						if (a2_0 != null) {
							addObjectToList(element, edap.EdapPackage.CREATE_ACTION__ANNOTATIONS, a2_0);
							completedElement(a2_0, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_29_0_0_2_0_0_0, a2_0);
						copyLocalizationInfos(a2_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 297);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 297);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 297);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 297);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 297);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 297);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 297, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 297);
				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 297);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 298);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 298);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 298);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 298);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 298);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 298);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 298, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 298);
		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 298);
	}
	
;

parse_edap_Type returns [edap.Type element = null]
:
	c0 = parse_edap_Device{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edap_SoftwareComponent{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edap_Simulator{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edap_PrimitiveType{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edap_Enumeration{ element = c4; /* this is a subclass or primitive expression choice */ }
	
;

parse_edap_Component returns [edap.Component element = null]
:
	c0 = parse_edap_Device{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edap_SoftwareComponent{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edap_Simulator{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_edap_Action returns [edap.Action element = null]
:
	c0 = parse_edap_ActionBlock{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edap_ExternStatement{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edap_PropertyAssignment{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_edap_Unicast{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_edap_Broadcast{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_edap_CreateAction{ element = c5; /* this is a subclass or primitive expression choice */ }
	
;

parse_edap_Expression returns [edap.Expression element = null]
:
	c0 = parse_edap_ExternExpression{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_edap_ComponentReference{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_edap_EventReference{ element = c2; /* this is a subclass or primitive expression choice */ }
	
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
MULTIPLICITY:
	(( ('*') | (('0'..'9')+) ))
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' )+ (':' ':' ('A'..'Z' | 'a'..'z' | '0'..'9' | '_')+ )* )
;

