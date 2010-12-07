grammar EdapuC;

options {
	superClass = EdapuCANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package edapuC.resource.edapuC.mopp;
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
	package edapuC.resource.edapuC.mopp;
}

@members{
	private edapuC.resource.edapuC.IEdapuCTokenResolverFactory tokenResolverFactory = new edapuC.resource.edapuC.mopp.EdapuCTokenResolverFactory();
	
	/**
	 * the index of the last token that was handled by collectHiddenTokens()
	 */
	private int lastPosition;
	
	/**
	 * the index of the last token that was handled by retrieveLayoutInformation()
	 */
	private int lastPosition2;
	
	private edapuC.resource.edapuC.mopp.EdapuCTokenResolveResult tokenResolveResult = new edapuC.resource.edapuC.mopp.EdapuCTokenResolveResult();
	
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
	private java.util.List<edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal> expectedElements = new java.util.ArrayList<edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal>();
	
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
	private java.util.Collection<edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>> postParseCommands;
	
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
		postParseCommands.add(new edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>() {
			public boolean execute(edapuC.resource.edapuC.IEdapuCTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new edapuC.resource.edapuC.IEdapuCProblem() {
					public edapuC.resource.edapuC.EdapuCEProblemType getType() {
						return edapuC.resource.edapuC.EdapuCEProblemType.ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<edapuC.resource.edapuC.IEdapuCQuickFix> getQuickFixes() {
						return null;
					}
				}, line, charPositionInLine, startIndex, stopIndex);
				return true;
			}
		});
	}
	
	public void addExpectedElement(edapuC.resource.edapuC.IEdapuCExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
		if (!this.rememberExpectedElements) {
			return;
		}
		edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal expectedElement = new edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal(terminal, followSetID, containmentTrace);
		setPosition(expectedElement, input.index());
		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
			// clear list of expected elements
			this.expectedElements.clear();
		}
		lastStartIncludingHidden = startIncludingHiddenTokens;
		this.expectedElements.add(expectedElement);
	}
	
	protected void addMapEntry(org.eclipse.emf.ecore.EObject element, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, edapuC.resource.edapuC.mopp.EdapuCDummyEObject dummy) {
		Object value = element.eGet(structuralFeature);
		Object mapKey = dummy.getValueByName("key");
		Object mapValue = dummy.getValueByName("value");
		if (value instanceof org.eclipse.emf.common.util.EMap<?, ?>) {
			org.eclipse.emf.common.util.EMap<Object, Object> valueMap = edapuC.resource.edapuC.util.EdapuCMapUtil.castToEMap(value);
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
			assert(object instanceof edapuC.resource.edapuC.mopp.EdapuCDummyEObject);
			edapuC.resource.edapuC.mopp.EdapuCDummyEObject dummy = (edapuC.resource.edapuC.mopp.EdapuCDummyEObject) object;
			org.eclipse.emf.ecore.EObject newEObject = dummy.applyTo(currentTarget);
			currentTarget = newEObject;
		}
		return currentTarget;
	}
	
	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
	}
	
	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
		postParseCommands.add(new edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>() {
			public boolean execute(edapuC.resource.edapuC.IEdapuCTextResource resource) {
				edapuC.resource.edapuC.IEdapuCLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>() {
			public boolean execute(edapuC.resource.edapuC.IEdapuCTextResource resource) {
				edapuC.resource.edapuC.IEdapuCLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		postParseCommands.add(new edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>() {
			public boolean execute(edapuC.resource.edapuC.IEdapuCTextResource resource) {
				edapuC.resource.edapuC.IEdapuCLocationMap locationMap = resource.getLocationMap();
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
	
	public edapuC.resource.edapuC.IEdapuCTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new EdapuCParser(new org.antlr.runtime3_2_0.CommonTokenStream(new EdapuCLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new EdapuCParser(new org.antlr.runtime3_2_0.CommonTokenStream(new EdapuCLexer(new org.antlr.runtime3_2_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			edapuC.resource.edapuC.mopp.EdapuCPlugin.logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public EdapuCParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_2_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((EdapuCLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((EdapuCLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == edapuC.UCGenerator.class) {
				return parse_edapuC_UCGenerator();
			}
			if (type.getInstanceClass() == edapuC.UCDevice.class) {
				return parse_edapuC_UCDevice();
			}
			if (type.getInstanceClass() == edapuC.UCApplication.class) {
				return parse_edapuC_UCApplication();
			}
			if (type.getInstanceClass() == edapuC.UCMessage.class) {
				return parse_edapuC_UCMessage();
			}
			if (type.getInstanceClass() == edapuC.Template.class) {
				return parse_edapuC_Template();
			}
			if (type.getInstanceClass() == edapuC.StaticProperty.class) {
				return parse_edapuC_StaticProperty();
			}
		}
		throw new edapuC.resource.edapuC.mopp.EdapuCUnexpectedContentTypeException(typeObject);
	}
	
	private edapuC.resource.edapuC.mopp.EdapuCTokenResolveResult getFreshTokenResolveResult() {
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
	
	public edapuC.resource.edapuC.mopp.EdapuCMetaInformation getMetaInformation() {
		return new edapuC.resource.edapuC.mopp.EdapuCMetaInformation();
	}
	
	public Object getParseToIndexTypeObject() {
		return parseToIndexTypeObject;
	}
	
	protected edapuC.resource.edapuC.mopp.EdapuCReferenceResolverSwitch getReferenceResolverSwitch() {
		return (edapuC.resource.edapuC.mopp.EdapuCReferenceResolverSwitch) getMetaInformation().getReferenceResolverSwitch();
	}
	
	protected Object getTypeObject() {
		Object typeObject = getParseToIndexTypeObject();
		if (typeObject != null) {
			return typeObject;
		}
		java.util.Map<?,?> options = getOptions();
		if (options != null) {
			typeObject = options.get(edapuC.resource.edapuC.IEdapuCOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public edapuC.resource.edapuC.IEdapuCParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>>();
		edapuC.resource.edapuC.mopp.EdapuCParseResult parseResult = new edapuC.resource.edapuC.mopp.EdapuCParseResult();
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
	
	public java.util.List<edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, edapuC.resource.edapuC.IEdapuCTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_2_0.CommonTokenStream tokenStream = (org.antlr.runtime3_2_0.CommonTokenStream) getTokenStream();
		edapuC.resource.edapuC.IEdapuCParseResult result = parse();
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
			for (edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal>();
		java.util.List<edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal> newFollowSet = new java.util.ArrayList<edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 56;
		int i;
		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
			org.antlr.runtime3_2_0.CommonToken nextToken = (org.antlr.runtime3_2_0.CommonToken) tokenStream.get(i);
			if (nextToken.getChannel() == 99) {
				// hidden tokens do not reduce the follow set
			} else {
				// now that we have found the next visible token the position for that expected
				// terminals can be set
				for (edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<edapuC.resource.edapuC.util.EdapuCPair<edapuC.resource.edapuC.IEdapuCExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (edapuC.resource.edapuC.util.EdapuCPair<edapuC.resource.edapuC.IEdapuCExpectedElement, org.eclipse.emf.ecore.EStructuralFeature[]> newFollowerPair : newFollowers) {
							edapuC.resource.edapuC.IEdapuCExpectedElement newFollower = newFollowerPair.getLeft();
							edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal newFollowTerminal = new edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal(newFollower, followSetID, newFollowerPair.getRight());
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
		for (edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(edapuC.resource.edapuC.mopp.EdapuCExpectedTerminal expectedElement, int tokenIndex) {
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
	
	protected <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> void registerContextDependentProxy(final edapuC.resource.edapuC.mopp.EdapuCContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, final ContainerType element, final org.eclipse.emf.ecore.EReference reference, final String id, final org.eclipse.emf.ecore.EObject proxy) {
		postParseCommands.add(new edapuC.resource.edapuC.IEdapuCCommand<edapuC.resource.edapuC.IEdapuCTextResource>() {
			public boolean execute(edapuC.resource.edapuC.IEdapuCTextResource resource) {
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
				tokenName = edapuC.resource.edapuC.util.EdapuCStringUtil.formatTokenName(tokenName);
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
	
	protected void retrieveLayoutInformation(org.eclipse.emf.ecore.EObject element, edapuC.resource.edapuC.grammar.EdapuCSyntaxElement syntaxElement, Object object) {
		if (!(syntaxElement instanceof edapuC.resource.edapuC.grammar.EdapuCPlaceholder) && !(syntaxElement instanceof edapuC.resource.edapuC.grammar.EdapuCKeyword)) {
			return;
		}
		edapuC.resource.edapuC.mopp.EdapuCLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(element);
		for (org.antlr.runtime3_2_0.CommonToken anonymousToken : anonymousTokens) {
			layoutInformationAdapter.addLayoutInformation(new edapuC.resource.edapuC.mopp.EdapuCLayoutInformation(syntaxElement, object, anonymousToken.getStartIndex(), anonymousToken.getText(), ""));
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
		layoutInformationAdapter.addLayoutInformation(new edapuC.resource.edapuC.mopp.EdapuCLayoutInformation(syntaxElement, object, offset, hiddenTokenText.toString(), visibleTokenText.toString()));
		this.lastPosition2 = (endPos < 0 ? 0 : endPos + 1);
	}
	
	protected edapuC.resource.edapuC.mopp.EdapuCLayoutInformationAdapter getLayoutInformationAdapter(org.eclipse.emf.ecore.EObject element) {
		for (org.eclipse.emf.common.notify.Adapter adapter : element.eAdapters()) {
			if (adapter instanceof edapuC.resource.edapuC.mopp.EdapuCLayoutInformationAdapter) {
				return (edapuC.resource.edapuC.mopp.EdapuCLayoutInformationAdapter) adapter;
			}
		}
		edapuC.resource.edapuC.mopp.EdapuCLayoutInformationAdapter newAdapter = new edapuC.resource.edapuC.mopp.EdapuCLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_0, 0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 0, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 0, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 0, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
	}
	(
		c0 = parse_edapuC_UCGenerator{ element = c0; }
	)
	EOF	
;

parse_edapuC_UCGenerator returns [edapuC.UCGenerator element = null]
@init{
}
:
	(
		(
			a0 = 'import' {
				if (element == null) {
					element = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_0_0_0_0_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_5, 1);
			}
			
			(
				a1 = STRING_LITERAL				
				{
					if (terminateParsing) {
						throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
					}
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a1 != null) {
						edapuC.resource.edapuC.IEdapuCTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
						tokenResolver.setOptions(getOptions());
						edapuC.resource.edapuC.IEdapuCTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__IMPORTS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edapuC.UCGenerator proxy = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edapuC.resource.edapuC.mopp.EdapuCContextDependentURIFragmentFactory<edapuC.UCGenerator, edapuC.UCGenerator>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCGeneratorImportsReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__IMPORTS), resolved, proxy);
						if (proxy != null) {
							addObjectToList(element, edapuC.EdapuCPackage.UC_GENERATOR__IMPORTS, proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_0_0_0_0_0_0_3, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_0, 2);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 2);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 2, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 2, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 2, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_0, 3);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 3);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 3, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 3, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 3, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
	}
	
	(
		(
			a2 = 'edap' {
				if (element == null) {
					element = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_0_0_0_1_0_0_1, null);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_6, 4);
			}
			
			(
				a3 = STRING_LITERAL				
				{
					if (terminateParsing) {
						throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
					}
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					if (a3 != null) {
						edapuC.resource.edapuC.IEdapuCTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
						tokenResolver.setOptions(getOptions());
						edapuC.resource.edapuC.IEdapuCTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__EDAP), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						edap.EdapModel proxy = edap.EdapFactory.eINSTANCE.createEdapModel();
						collectHiddenTokens(element);
						registerContextDependentProxy(new edapuC.resource.edapuC.mopp.EdapuCContextDependentURIFragmentFactory<edapuC.UCGenerator, edap.EdapModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCGeneratorEdapReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__EDAP), resolved, proxy);
						if (proxy != null) {
							addObjectToList(element, edapuC.EdapuCPackage.UC_GENERATOR__EDAP, proxy);
							completedElement(proxy, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_0_0_0_1_0_0_3, proxy);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 5);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 5, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 5, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 5, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 6);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 6, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 6, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 6, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
	}
	
	(
		(
			(
				(
					a4_0 = parse_edapuC_StaticProperty					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a4_0 != null) {
							if (a4_0 != null) {
								addObjectToList(element, edapuC.EdapuCPackage.UC_GENERATOR__PROPERTIES, a4_0);
								completedElement(a4_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_0_0_0_2_0_0_1_0_0_0, a4_0);
							copyLocalizationInfos(a4_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 7, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 7, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 7, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
				}
				
				
				|				(
					a5_0 = parse_edapuC_UCDevice					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a5_0 != null) {
							if (a5_0 != null) {
								addObjectToList(element, edapuC.EdapuCPackage.UC_GENERATOR__DEVICES, a5_0);
								completedElement(a5_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_0_0_0_2_0_0_1_0_1_0, a5_0);
							copyLocalizationInfos(a5_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 8, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 8, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 8, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
				}
				
				
				|				(
					a6_0 = parse_edapuC_UCApplication					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a6_0 != null) {
							if (a6_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_GENERATOR__APPLICATION), a6_0);
								completedElement(a6_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_0_0_0_2_0_0_1_0_2_0, a6_0);
							copyLocalizationInfos(a6_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 9, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 9, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 9, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 10, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 10, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 10, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 11, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 11, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 11, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
	}
	
;

parse_edapuC_UCDevice returns [edapuC.UCDevice element = null]
@init{
}
:
	a0 = 'device' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_7, 12);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
			}
			if (element == null) {
				element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1 != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edapuC.resource.edapuC.IEdapuCTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__DEVICE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Component proxy = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edapuC.resource.edapuC.mopp.EdapuCContextDependentURIFragmentFactory<edapuC.UCDevice, edap.Component>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCDeviceDeviceReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__DEVICE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__DEVICE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_8, 13);
	}
	
	a2 = '{' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 14);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 14);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 14);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 14, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 14, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 14);
	}
	
	(
		(
			(
				a3 = 'init' {
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_0_0, null);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 15, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_4);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 15, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_4);
				}
				
				(
					a4_0 = parse_edapuC_Template					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a4_0 != null) {
							if (a4_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__INIT), a4_0);
								completedElement(a4_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_0_2, a4_0);
							copyLocalizationInfos(a4_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 16);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 16);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 16);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 16, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 16, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 16);
				}
				
				
				|				a5 = 'poll' {
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_1_0, null);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 17, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_5);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 17, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_5);
				}
				
				(
					a6_0 = parse_edapuC_Template					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a6_0 != null) {
							if (a6_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__POLL), a6_0);
								completedElement(a6_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_1_2, a6_0);
							copyLocalizationInfos(a6_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 18);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 18);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 18);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 18, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 18, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 18);
				}
				
				
				|				a7 = 'global' {
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_2_0, null);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 19, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_6);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 19, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_6);
				}
				
				(
					a8_0 = parse_edapuC_Template					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a8_0 != null) {
							if (a8_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_DEVICE__GLOBAL), a8_0);
								completedElement(a8_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_2_2, a8_0);
							copyLocalizationInfos(a8_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 20);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 20);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 20);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 20, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 20, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 20);
				}
				
				
				|				(
					a9_0 = parse_edapuC_StaticProperty					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a9_0 != null) {
							if (a9_0 != null) {
								addObjectToList(element, edapuC.EdapuCPackage.UC_DEVICE__PROPERTIES, a9_0);
								completedElement(a9_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_3_0, a9_0);
							copyLocalizationInfos(a9_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 21);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 21);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 21);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 21, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 21, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 21);
				}
				
				
				|				(
					a10_0 = parse_edapuC_UCMessage					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a10_0 != null) {
							if (a10_0 != null) {
								addObjectToList(element, edapuC.EdapuCPackage.UC_DEVICE__MESSAGES, a10_0);
								completedElement(a10_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_4_0, a10_0);
							copyLocalizationInfos(a10_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 22);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 22);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 22);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 22, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 22, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 22);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 23);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 23);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 23);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 23, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 23, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 23);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 24);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 24);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 24);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 24, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 24, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 24);
	}
	
	a11 = '}' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 25, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 25, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 25, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
	}
	
;

parse_edapuC_UCApplication returns [edapuC.UCApplication element = null]
@init{
}
:
	a0 = 'application' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_16, 26);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
			}
			if (element == null) {
				element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1 != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edapuC.resource.edapuC.IEdapuCTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__STATE_MACHINE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Component proxy = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edapuC.resource.edapuC.mopp.EdapuCContextDependentURIFragmentFactory<edapuC.UCApplication, edap.Component>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCApplicationState_machineReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__STATE_MACHINE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__STATE_MACHINE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_17, 27);
	}
	
	a2 = '{' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 28);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 28);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 28);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 28);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 28, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 28);
	}
	
	(
		(
			(
				a3 = 'init' {
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_0_0, null);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 29, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_7);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 29, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_7);
				}
				
				(
					a4_0 = parse_edapuC_Template					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a4_0 != null) {
							if (a4_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__INIT), a4_0);
								completedElement(a4_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_0_2, a4_0);
							copyLocalizationInfos(a4_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 30);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 30);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 30);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 30);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 30, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 30);
				}
				
				
				|				a5 = 'poll' {
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_1_0, null);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 31, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_8);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 31, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_8);
				}
				
				(
					a6_0 = parse_edapuC_Template					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a6_0 != null) {
							if (a6_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__POLL), a6_0);
								completedElement(a6_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_1_2, a6_0);
							copyLocalizationInfos(a6_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 32);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 32);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 32);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 32);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 32, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 32);
				}
				
				
				|				a7 = 'global' {
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_2_0, null);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 33, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_9);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 33, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_9);
				}
				
				(
					a8_0 = parse_edapuC_Template					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a8_0 != null) {
							if (a8_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__GLOBAL), a8_0);
								completedElement(a8_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_2_2, a8_0);
							copyLocalizationInfos(a8_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 34);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 34);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 34);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 34);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 34, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 34);
				}
				
				
				|				a9 = 'headers' {
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_3_0, null);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 35, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_10);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 35, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_10);
				}
				
				(
					a10_0 = parse_edapuC_Template					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a10_0 != null) {
							if (a10_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_APPLICATION__HEADERS), a10_0);
								completedElement(a10_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_3_2, a10_0);
							copyLocalizationInfos(a10_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 36);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 36);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 36);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 36);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 36, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 36);
				}
				
				
				|				(
					a11_0 = parse_edapuC_StaticProperty					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a11_0 != null) {
							if (a11_0 != null) {
								addObjectToList(element, edapuC.EdapuCPackage.UC_APPLICATION__PROPERTIES, a11_0);
								completedElement(a11_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_4_0, a11_0);
							copyLocalizationInfos(a11_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 37);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 37);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 37);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 37);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 37, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 37);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 38);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 38);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 38);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 38);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 38, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 38);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 39);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 39);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 39);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 39);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 39, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 39);
	}
	
	a12 = '}' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 40, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 40, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 40, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
	}
	
;

parse_edapuC_UCMessage returns [edapuC.UCMessage element = null]
@init{
}
:
	a0 = 'message' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_23, 41);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
			}
			if (element == null) {
				element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1 != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edapuC.resource.edapuC.IEdapuCTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__MESSAGE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				edap.Message proxy = edap.EdapFactory.eINSTANCE.createMessage();
				collectHiddenTokens(element);
				registerContextDependentProxy(new edapuC.resource.edapuC.mopp.EdapuCContextDependentURIFragmentFactory<edapuC.UCMessage, edap.Message>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getUCMessageMessageReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__MESSAGE), resolved, proxy);
				if (proxy != null) {
					element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__MESSAGE), proxy);
					completedElement(proxy, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_2, proxy);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_24, 42);
	}
	
	a2 = '{' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_3, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 43, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 43);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 43);
	}
	
	(
		(
			(
				(
					a3_0 = parse_edapuC_StaticProperty					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a3_0 != null) {
							if (a3_0 != null) {
								addObjectToList(element, edapuC.EdapuCPackage.UC_MESSAGE__PROPERTIES, a3_0);
								completedElement(a3_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_4_0_0_1_0_0_0, a3_0);
							copyLocalizationInfos(a3_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 44, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 44);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 44);
				}
				
				
				|				a4 = 'send' {
					if (element == null) {
						element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
						incompleteObjects.push(element);
						// initialize boolean attributes
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_4_0_0_1_0_1_0, null);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 45, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_11);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 45, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_11);
				}
				
				(
					a5_0 = parse_edapuC_Template					{
						if (terminateParsing) {
							throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
						}
						if (element == null) {
							element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
							incompleteObjects.push(element);
							// initialize boolean attributes
						}
						if (a5_0 != null) {
							if (a5_0 != null) {
								element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.UC_MESSAGE__SEND), a5_0);
								completedElement(a5_0, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_4_0_0_1_0_1_2, a5_0);
							copyLocalizationInfos(a5_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 46, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 46);
					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 46);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 47, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 47);
				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 47);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 48, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 48);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 48);
	}
	
	a6 = '}' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_5, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 49);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 49);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 49);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 49, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 49, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 49);
	}
	
;

parse_edapuC_Template returns [edapuC.Template element = null]
@init{
}
:
	(
		(
			a0 = GENERATOR			
			{
				if (terminateParsing) {
					throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
				}
				if (element == null) {
					element = edapuC.EdapuCFactory.eINSTANCE.createTemplate();
					incompleteObjects.push(element);
					// initialize boolean attributes
				}
				if (a0 != null) {
					edapuC.resource.edapuC.IEdapuCTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("GENERATOR");
					tokenResolver.setOptions(getOptions());
					edapuC.resource.edapuC.IEdapuCTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__GENERATOR), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a0).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String)resolvedObject;
					if (resolved != null) {
						element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__GENERATOR), resolved);
						completedElement(resolved, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_4_0_0_0, resolved);
					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a0, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 50);
	}
	
	(
		a1 = TEMPLATE		
		{
			if (terminateParsing) {
				throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
			}
			if (element == null) {
				element = edapuC.EdapuCFactory.eINSTANCE.createTemplate();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1 != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEMPLATE");
				tokenResolver.setOptions(getOptions());
				edapuC.resource.edapuC.IEdapuCTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__TEXT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.TEMPLATE__TEXT), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_4_0_0_1, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 51, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 51, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 51);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 51);
	}
	
;

parse_edapuC_StaticProperty returns [edapuC.StaticProperty element = null]
@init{
}
:
	a0 = 'property' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createStaticProperty();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_5_0_0_0, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_27, 52);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
			}
			if (element == null) {
				element = edapuC.EdapuCFactory.eINSTANCE.createStaticProperty();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a1 != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				edapuC.resource.edapuC.IEdapuCTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__NAME), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_5_0_0_2, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_28, 53);
	}
	
	a2 = '=' {
		if (element == null) {
			element = edapuC.EdapuCFactory.eINSTANCE.createStaticProperty();
			incompleteObjects.push(element);
			// initialize boolean attributes
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_5_0_0_4, null);
		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_29, 54);
	}
	
	(
		a3 = STRING_LITERAL		
		{
			if (terminateParsing) {
				throw new edapuC.resource.edapuC.mopp.EdapuCTerminateParsingException();
			}
			if (element == null) {
				element = edapuC.EdapuCFactory.eINSTANCE.createStaticProperty();
				incompleteObjects.push(element);
				// initialize boolean attributes
			}
			if (a3 != null) {
				edapuC.resource.edapuC.IEdapuCTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("STRING_LITERAL");
				tokenResolver.setOptions(getOptions());
				edapuC.resource.edapuC.IEdapuCTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_2_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_2_0.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String)resolvedObject;
				if (resolved != null) {
					element.eSet(element.eClass().getEStructuralFeature(edapuC.EdapuCPackage.STATIC_PROPERTY__VALUE), resolved);
					completedElement(resolved, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_5_0_0_6, resolved);
				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 55, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 55, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 55, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 55, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 55);
		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 55);
	}
	
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
	{ _channel = 99; }
;
STRING_LITERAL:
	('"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"')
;
TEMPLATE:
	('<template>'.*'</template>')
;
GENERATOR:
	('<generator>'.*'</generator>')
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

