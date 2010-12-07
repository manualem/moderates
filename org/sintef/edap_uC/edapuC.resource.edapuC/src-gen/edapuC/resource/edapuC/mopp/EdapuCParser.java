// $ANTLR ${project.version} ${buildNumber}

	package edapuC.resource.edapuC.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
@SuppressWarnings("unused")
public class EdapuCParser extends EdapuCANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING_LITERAL", "TEXT", "GENERATOR", "TEMPLATE", "SL_COMMENT", "ML_COMMENT", "ANNOTATION", "WHITESPACE", "LINEBREAKS", "'import'", "'edap'", "'device'", "'{'", "'init'", "'poll'", "'global'", "'}'", "'application'", "'headers'", "'message'", "'send'", "'property'", "'='"
    };
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int ANNOTATION=10;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int WHITESPACE=11;
    public static final int TEXT=5;
    public static final int LINEBREAKS=12;
    public static final int EOF=-1;
    public static final int ML_COMMENT=9;
    public static final int GENERATOR=6;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int STRING_LITERAL=4;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int TEMPLATE=7;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int SL_COMMENT=8;

    // delegates
    // delegators


        public EdapuCParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EdapuCParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[25+1];
             
             
        }
        

    public String[] getTokenNames() { return EdapuCParser.tokenNames; }
    public String getGrammarFileName() { return "EdapuC.g"; }


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
    	



    // $ANTLR start "start"
    // EdapuC.g:683:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_edapuC_UCGenerator ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        edapuC.UCGenerator c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // EdapuC.g:684:1: ( (c0= parse_edapuC_UCGenerator ) EOF )
            // EdapuC.g:685:2: (c0= parse_edapuC_UCGenerator ) EOF
            {
            if ( state.backtracking==0 ) {

              		// follow set for start rule(s)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_0, 0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 0, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 0, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 0, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
              		expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
              	
            }
            // EdapuC.g:694:2: (c0= parse_edapuC_UCGenerator )
            // EdapuC.g:695:3: c0= parse_edapuC_UCGenerator
            {
            pushFollow(FOLLOW_parse_edapuC_UCGenerator_in_start82);
            c0=parse_edapuC_UCGenerator();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; 
            }

            }

            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "start"


    // $ANTLR start "parse_edapuC_UCGenerator"
    // EdapuC.g:700:1: parse_edapuC_UCGenerator returns [edapuC.UCGenerator element = null] : ( (a0= 'import' (a1= STRING_LITERAL ) ) )* ( (a2= 'edap' (a3= STRING_LITERAL ) ) )* ( ( ( (a4_0= parse_edapuC_StaticProperty ) | (a5_0= parse_edapuC_UCDevice ) | (a6_0= parse_edapuC_UCApplication ) ) ) )* ;
    public final edapuC.UCGenerator parse_edapuC_UCGenerator() throws RecognitionException {
        edapuC.UCGenerator element =  null;
        int parse_edapuC_UCGenerator_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        edapuC.StaticProperty a4_0 = null;

        edapuC.UCDevice a5_0 = null;

        edapuC.UCApplication a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // EdapuC.g:703:1: ( ( (a0= 'import' (a1= STRING_LITERAL ) ) )* ( (a2= 'edap' (a3= STRING_LITERAL ) ) )* ( ( ( (a4_0= parse_edapuC_StaticProperty ) | (a5_0= parse_edapuC_UCDevice ) | (a6_0= parse_edapuC_UCApplication ) ) ) )* )
            // EdapuC.g:704:2: ( (a0= 'import' (a1= STRING_LITERAL ) ) )* ( (a2= 'edap' (a3= STRING_LITERAL ) ) )* ( ( ( (a4_0= parse_edapuC_StaticProperty ) | (a5_0= parse_edapuC_UCDevice ) | (a6_0= parse_edapuC_UCApplication ) ) ) )*
            {
            // EdapuC.g:704:2: ( (a0= 'import' (a1= STRING_LITERAL ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EdapuC.g:705:3: (a0= 'import' (a1= STRING_LITERAL ) )
            	    {
            	    // EdapuC.g:705:3: (a0= 'import' (a1= STRING_LITERAL ) )
            	    // EdapuC.g:706:4: a0= 'import' (a1= STRING_LITERAL )
            	    {
            	    a0=(Token)match(input,13,FOLLOW_13_in_parse_edapuC_UCGenerator121); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
            	      					incompleteObjects.push(element);
            	      					// initialize boolean attributes
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_0_0_0_0_0_0_1, null);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_5, 1);
            	      			
            	    }
            	    // EdapuC.g:721:4: (a1= STRING_LITERAL )
            	    // EdapuC.g:722:5: a1= STRING_LITERAL
            	    {
            	    a1=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_parse_edapuC_UCGenerator147); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_0, 2);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 2);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 2, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 2, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 2, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_0, 3);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 3);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 3, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 3, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 3, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
              	
            }
            // EdapuC.g:776:2: ( (a2= 'edap' (a3= STRING_LITERAL ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==14) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // EdapuC.g:777:3: (a2= 'edap' (a3= STRING_LITERAL ) )
            	    {
            	    // EdapuC.g:777:3: (a2= 'edap' (a3= STRING_LITERAL ) )
            	    // EdapuC.g:778:4: a2= 'edap' (a3= STRING_LITERAL )
            	    {
            	    a2=(Token)match(input,14,FOLLOW_14_in_parse_edapuC_UCGenerator202); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = edapuC.EdapuCFactory.eINSTANCE.createUCGenerator();
            	      					incompleteObjects.push(element);
            	      					// initialize boolean attributes
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_0_0_0_1_0_0_1, null);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_6, 4);
            	      			
            	    }
            	    // EdapuC.g:793:4: (a3= STRING_LITERAL )
            	    // EdapuC.g:794:5: a3= STRING_LITERAL
            	    {
            	    a3=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_parse_edapuC_UCGenerator228); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 5);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 5, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 5, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 5, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_1, 6);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 6, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 6, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 6, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
              	
            }
            // EdapuC.g:846:2: ( ( ( (a4_0= parse_edapuC_StaticProperty ) | (a5_0= parse_edapuC_UCDevice ) | (a6_0= parse_edapuC_UCApplication ) ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15||LA4_0==21||LA4_0==25) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // EdapuC.g:847:3: ( ( (a4_0= parse_edapuC_StaticProperty ) | (a5_0= parse_edapuC_UCDevice ) | (a6_0= parse_edapuC_UCApplication ) ) )
            	    {
            	    // EdapuC.g:847:3: ( ( (a4_0= parse_edapuC_StaticProperty ) | (a5_0= parse_edapuC_UCDevice ) | (a6_0= parse_edapuC_UCApplication ) ) )
            	    // EdapuC.g:848:4: ( (a4_0= parse_edapuC_StaticProperty ) | (a5_0= parse_edapuC_UCDevice ) | (a6_0= parse_edapuC_UCApplication ) )
            	    {
            	    // EdapuC.g:848:4: ( (a4_0= parse_edapuC_StaticProperty ) | (a5_0= parse_edapuC_UCDevice ) | (a6_0= parse_edapuC_UCApplication ) )
            	    int alt3=3;
            	    switch ( input.LA(1) ) {
            	    case 25:
            	        {
            	        alt3=1;
            	        }
            	        break;
            	    case 15:
            	        {
            	        alt3=2;
            	        }
            	        break;
            	    case 21:
            	        {
            	        alt3=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt3) {
            	        case 1 :
            	            // EdapuC.g:849:5: (a4_0= parse_edapuC_StaticProperty )
            	            {
            	            // EdapuC.g:849:5: (a4_0= parse_edapuC_StaticProperty )
            	            // EdapuC.g:850:6: a4_0= parse_edapuC_StaticProperty
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_StaticProperty_in_parse_edapuC_UCGenerator296);
            	            a4_0=parse_edapuC_StaticProperty();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 7, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 7, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 7, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EdapuC.g:878:10: (a5_0= parse_edapuC_UCDevice )
            	            {
            	            // EdapuC.g:878:10: (a5_0= parse_edapuC_UCDevice )
            	            // EdapuC.g:879:6: a5_0= parse_edapuC_UCDevice
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_UCDevice_in_parse_edapuC_UCGenerator346);
            	            a5_0=parse_edapuC_UCDevice();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 8, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 8, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 8, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
            	              				
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // EdapuC.g:907:10: (a6_0= parse_edapuC_UCApplication )
            	            {
            	            // EdapuC.g:907:10: (a6_0= parse_edapuC_UCApplication )
            	            // EdapuC.g:908:6: a6_0= parse_edapuC_UCApplication
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_UCApplication_in_parse_edapuC_UCGenerator396);
            	            a6_0=parse_edapuC_UCApplication();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 9, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 9, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 9, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 10, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 10, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 10, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 11, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 11, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 11, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_edapuC_UCGenerator_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edapuC_UCGenerator"


    // $ANTLR start "parse_edapuC_UCDevice"
    // EdapuC.g:954:1: parse_edapuC_UCDevice returns [edapuC.UCDevice element = null] : a0= 'device' (a1= TEXT ) a2= '{' ( ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | (a9_0= parse_edapuC_StaticProperty ) | (a10_0= parse_edapuC_UCMessage ) ) ) )* a11= '}' ;
    public final edapuC.UCDevice parse_edapuC_UCDevice() throws RecognitionException {
        edapuC.UCDevice element =  null;
        int parse_edapuC_UCDevice_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a7=null;
        Token a11=null;
        edapuC.Template a4_0 = null;

        edapuC.Template a6_0 = null;

        edapuC.Template a8_0 = null;

        edapuC.StaticProperty a9_0 = null;

        edapuC.UCMessage a10_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // EdapuC.g:957:1: (a0= 'device' (a1= TEXT ) a2= '{' ( ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | (a9_0= parse_edapuC_StaticProperty ) | (a10_0= parse_edapuC_UCMessage ) ) ) )* a11= '}' )
            // EdapuC.g:958:2: a0= 'device' (a1= TEXT ) a2= '{' ( ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | (a9_0= parse_edapuC_StaticProperty ) | (a10_0= parse_edapuC_UCMessage ) ) ) )* a11= '}'
            {
            a0=(Token)match(input,15,FOLLOW_15_in_parse_edapuC_UCDevice470); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_7, 12);
              	
            }
            // EdapuC.g:973:2: (a1= TEXT )
            // EdapuC.g:974:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edapuC_UCDevice488); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_8, 13);
              	
            }
            a2=(Token)match(input,16,FOLLOW_16_in_parse_edapuC_UCDevice509); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 14);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 14);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 14);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 14, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 14, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 14);
              	
            }
            // EdapuC.g:1033:2: ( ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | (a9_0= parse_edapuC_StaticProperty ) | (a10_0= parse_edapuC_UCMessage ) ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=17 && LA6_0<=19)||LA6_0==23||LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // EdapuC.g:1034:3: ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | (a9_0= parse_edapuC_StaticProperty ) | (a10_0= parse_edapuC_UCMessage ) ) )
            	    {
            	    // EdapuC.g:1034:3: ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | (a9_0= parse_edapuC_StaticProperty ) | (a10_0= parse_edapuC_UCMessage ) ) )
            	    // EdapuC.g:1035:4: (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | (a9_0= parse_edapuC_StaticProperty ) | (a10_0= parse_edapuC_UCMessage ) )
            	    {
            	    // EdapuC.g:1035:4: (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | (a9_0= parse_edapuC_StaticProperty ) | (a10_0= parse_edapuC_UCMessage ) )
            	    int alt5=5;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt5=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt5=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt5=3;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt5=4;
            	        }
            	        break;
            	    case 23:
            	        {
            	        alt5=5;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt5) {
            	        case 1 :
            	            // EdapuC.g:1036:5: a3= 'init' (a4_0= parse_edapuC_Template )
            	            {
            	            a3=(Token)match(input,17,FOLLOW_17_in_parse_edapuC_UCDevice538); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (element == null) {
            	              						element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
            	              						incompleteObjects.push(element);
            	              						// initialize boolean attributes
            	              					}
            	              					collectHiddenTokens(element);
            	              					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_0_0, null);
            	              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
            	              				
            	            }
            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 15, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_4);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 15, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_4);
            	              				
            	            }
            	            // EdapuC.g:1052:5: (a4_0= parse_edapuC_Template )
            	            // EdapuC.g:1053:6: a4_0= parse_edapuC_Template
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCDevice568);
            	            a4_0=parse_edapuC_Template();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 16);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 16);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 16);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 16, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 16, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 16);
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EdapuC.g:1084:10: a5= 'poll' (a6_0= parse_edapuC_Template )
            	            {
            	            a5=(Token)match(input,18,FOLLOW_18_in_parse_edapuC_UCDevice611); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (element == null) {
            	              						element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
            	              						incompleteObjects.push(element);
            	              						// initialize boolean attributes
            	              					}
            	              					collectHiddenTokens(element);
            	              					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_1_0, null);
            	              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
            	              				
            	            }
            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 17, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_5);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 17, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_5);
            	              				
            	            }
            	            // EdapuC.g:1100:5: (a6_0= parse_edapuC_Template )
            	            // EdapuC.g:1101:6: a6_0= parse_edapuC_Template
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCDevice641);
            	            a6_0=parse_edapuC_Template();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 18);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 18);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 18);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 18, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 18, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 18);
            	              				
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // EdapuC.g:1132:10: a7= 'global' (a8_0= parse_edapuC_Template )
            	            {
            	            a7=(Token)match(input,19,FOLLOW_19_in_parse_edapuC_UCDevice684); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (element == null) {
            	              						element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
            	              						incompleteObjects.push(element);
            	              						// initialize boolean attributes
            	              					}
            	              					collectHiddenTokens(element);
            	              					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_4_0_0_1_0_2_0, null);
            	              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
            	              				
            	            }
            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 19, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_6);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 19, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_6);
            	              				
            	            }
            	            // EdapuC.g:1148:5: (a8_0= parse_edapuC_Template )
            	            // EdapuC.g:1149:6: a8_0= parse_edapuC_Template
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCDevice714);
            	            a8_0=parse_edapuC_Template();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 20);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 20);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 20);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 20, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 20, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 20);
            	              				
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // EdapuC.g:1180:10: (a9_0= parse_edapuC_StaticProperty )
            	            {
            	            // EdapuC.g:1180:10: (a9_0= parse_edapuC_StaticProperty )
            	            // EdapuC.g:1181:6: a9_0= parse_edapuC_StaticProperty
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_StaticProperty_in_parse_edapuC_UCDevice764);
            	            a9_0=parse_edapuC_StaticProperty();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 21);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 21);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 21);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 21, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 21, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 21);
            	              				
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // EdapuC.g:1212:10: (a10_0= parse_edapuC_UCMessage )
            	            {
            	            // EdapuC.g:1212:10: (a10_0= parse_edapuC_UCMessage )
            	            // EdapuC.g:1213:6: a10_0= parse_edapuC_UCMessage
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_UCMessage_in_parse_edapuC_UCDevice814);
            	            a10_0=parse_edapuC_UCMessage();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 22);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 22);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 22);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 22, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 22, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 22);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 23);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 23);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 23);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 23, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 23, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 23);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 24);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 24);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 24);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 24, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 24, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 24);
              	
            }
            a11=(Token)match(input,20,FOLLOW_20_in_parse_edapuC_UCDevice873); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createUCDevice();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_1_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 25, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 25, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 25, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_edapuC_UCDevice_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edapuC_UCDevice"


    // $ANTLR start "parse_edapuC_UCApplication"
    // EdapuC.g:1285:1: parse_edapuC_UCApplication returns [edapuC.UCApplication element = null] : a0= 'application' (a1= TEXT ) a2= '{' ( ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | a9= 'headers' (a10_0= parse_edapuC_Template ) | (a11_0= parse_edapuC_StaticProperty ) ) ) )* a12= '}' ;
    public final edapuC.UCApplication parse_edapuC_UCApplication() throws RecognitionException {
        edapuC.UCApplication element =  null;
        int parse_edapuC_UCApplication_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a7=null;
        Token a9=null;
        Token a12=null;
        edapuC.Template a4_0 = null;

        edapuC.Template a6_0 = null;

        edapuC.Template a8_0 = null;

        edapuC.Template a10_0 = null;

        edapuC.StaticProperty a11_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // EdapuC.g:1288:1: (a0= 'application' (a1= TEXT ) a2= '{' ( ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | a9= 'headers' (a10_0= parse_edapuC_Template ) | (a11_0= parse_edapuC_StaticProperty ) ) ) )* a12= '}' )
            // EdapuC.g:1289:2: a0= 'application' (a1= TEXT ) a2= '{' ( ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | a9= 'headers' (a10_0= parse_edapuC_Template ) | (a11_0= parse_edapuC_StaticProperty ) ) ) )* a12= '}'
            {
            a0=(Token)match(input,21,FOLLOW_21_in_parse_edapuC_UCApplication902); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_16, 26);
              	
            }
            // EdapuC.g:1304:2: (a1= TEXT )
            // EdapuC.g:1305:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edapuC_UCApplication920); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_17, 27);
              	
            }
            a2=(Token)match(input,16,FOLLOW_16_in_parse_edapuC_UCApplication941); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 28);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 28);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 28);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 28);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 28, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 28);
              	
            }
            // EdapuC.g:1364:2: ( ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | a9= 'headers' (a10_0= parse_edapuC_Template ) | (a11_0= parse_edapuC_StaticProperty ) ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=17 && LA8_0<=19)||LA8_0==22||LA8_0==25) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // EdapuC.g:1365:3: ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | a9= 'headers' (a10_0= parse_edapuC_Template ) | (a11_0= parse_edapuC_StaticProperty ) ) )
            	    {
            	    // EdapuC.g:1365:3: ( (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | a9= 'headers' (a10_0= parse_edapuC_Template ) | (a11_0= parse_edapuC_StaticProperty ) ) )
            	    // EdapuC.g:1366:4: (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | a9= 'headers' (a10_0= parse_edapuC_Template ) | (a11_0= parse_edapuC_StaticProperty ) )
            	    {
            	    // EdapuC.g:1366:4: (a3= 'init' (a4_0= parse_edapuC_Template ) | a5= 'poll' (a6_0= parse_edapuC_Template ) | a7= 'global' (a8_0= parse_edapuC_Template ) | a9= 'headers' (a10_0= parse_edapuC_Template ) | (a11_0= parse_edapuC_StaticProperty ) )
            	    int alt7=5;
            	    switch ( input.LA(1) ) {
            	    case 17:
            	        {
            	        alt7=1;
            	        }
            	        break;
            	    case 18:
            	        {
            	        alt7=2;
            	        }
            	        break;
            	    case 19:
            	        {
            	        alt7=3;
            	        }
            	        break;
            	    case 22:
            	        {
            	        alt7=4;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt7=5;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt7) {
            	        case 1 :
            	            // EdapuC.g:1367:5: a3= 'init' (a4_0= parse_edapuC_Template )
            	            {
            	            a3=(Token)match(input,17,FOLLOW_17_in_parse_edapuC_UCApplication970); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (element == null) {
            	              						element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
            	              						incompleteObjects.push(element);
            	              						// initialize boolean attributes
            	              					}
            	              					collectHiddenTokens(element);
            	              					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_0_0, null);
            	              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
            	              				
            	            }
            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 29, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_7);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 29, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_7);
            	              				
            	            }
            	            // EdapuC.g:1383:5: (a4_0= parse_edapuC_Template )
            	            // EdapuC.g:1384:6: a4_0= parse_edapuC_Template
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCApplication1000);
            	            a4_0=parse_edapuC_Template();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 30);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 30);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 30);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 30);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 30, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 30);
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EdapuC.g:1415:10: a5= 'poll' (a6_0= parse_edapuC_Template )
            	            {
            	            a5=(Token)match(input,18,FOLLOW_18_in_parse_edapuC_UCApplication1043); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (element == null) {
            	              						element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
            	              						incompleteObjects.push(element);
            	              						// initialize boolean attributes
            	              					}
            	              					collectHiddenTokens(element);
            	              					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_1_0, null);
            	              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
            	              				
            	            }
            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 31, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_8);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 31, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_8);
            	              				
            	            }
            	            // EdapuC.g:1431:5: (a6_0= parse_edapuC_Template )
            	            // EdapuC.g:1432:6: a6_0= parse_edapuC_Template
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCApplication1073);
            	            a6_0=parse_edapuC_Template();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 32);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 32);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 32);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 32);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 32, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 32);
            	              				
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // EdapuC.g:1463:10: a7= 'global' (a8_0= parse_edapuC_Template )
            	            {
            	            a7=(Token)match(input,19,FOLLOW_19_in_parse_edapuC_UCApplication1116); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (element == null) {
            	              						element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
            	              						incompleteObjects.push(element);
            	              						// initialize boolean attributes
            	              					}
            	              					collectHiddenTokens(element);
            	              					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_2_0, null);
            	              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
            	              				
            	            }
            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 33, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_9);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 33, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_9);
            	              				
            	            }
            	            // EdapuC.g:1479:5: (a8_0= parse_edapuC_Template )
            	            // EdapuC.g:1480:6: a8_0= parse_edapuC_Template
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCApplication1146);
            	            a8_0=parse_edapuC_Template();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 34);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 34);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 34);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 34);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 34, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 34);
            	              				
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // EdapuC.g:1511:10: a9= 'headers' (a10_0= parse_edapuC_Template )
            	            {
            	            a9=(Token)match(input,22,FOLLOW_22_in_parse_edapuC_UCApplication1189); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (element == null) {
            	              						element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
            	              						incompleteObjects.push(element);
            	              						// initialize boolean attributes
            	              					}
            	              					collectHiddenTokens(element);
            	              					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_4_0_0_1_0_3_0, null);
            	              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
            	              				
            	            }
            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 35, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_10);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 35, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_10);
            	              				
            	            }
            	            // EdapuC.g:1527:5: (a10_0= parse_edapuC_Template )
            	            // EdapuC.g:1528:6: a10_0= parse_edapuC_Template
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCApplication1219);
            	            a10_0=parse_edapuC_Template();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 36);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 36);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 36);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 36);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 36, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 36);
            	              				
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // EdapuC.g:1559:10: (a11_0= parse_edapuC_StaticProperty )
            	            {
            	            // EdapuC.g:1559:10: (a11_0= parse_edapuC_StaticProperty )
            	            // EdapuC.g:1560:6: a11_0= parse_edapuC_StaticProperty
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_StaticProperty_in_parse_edapuC_UCApplication1269);
            	            a11_0=parse_edapuC_StaticProperty();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 37);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 37);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 37);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 37);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 37, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 37);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 38);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 38);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 38);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 38);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 38, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 38);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_18, 39);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_19, 39);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_20, 39);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_21, 39);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 39, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_22, 39);
              	
            }
            a12=(Token)match(input,20,FOLLOW_20_in_parse_edapuC_UCApplication1328); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createUCApplication();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_2_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 40, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_3, 40, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_1);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_4, 40, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_2);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_edapuC_UCApplication_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edapuC_UCApplication"


    // $ANTLR start "parse_edapuC_UCMessage"
    // EdapuC.g:1632:1: parse_edapuC_UCMessage returns [edapuC.UCMessage element = null] : a0= 'message' (a1= TEXT ) a2= '{' ( ( ( (a3_0= parse_edapuC_StaticProperty ) | a4= 'send' (a5_0= parse_edapuC_Template ) ) ) )* a6= '}' ;
    public final edapuC.UCMessage parse_edapuC_UCMessage() throws RecognitionException {
        edapuC.UCMessage element =  null;
        int parse_edapuC_UCMessage_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        Token a6=null;
        edapuC.StaticProperty a3_0 = null;

        edapuC.Template a5_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // EdapuC.g:1635:1: (a0= 'message' (a1= TEXT ) a2= '{' ( ( ( (a3_0= parse_edapuC_StaticProperty ) | a4= 'send' (a5_0= parse_edapuC_Template ) ) ) )* a6= '}' )
            // EdapuC.g:1636:2: a0= 'message' (a1= TEXT ) a2= '{' ( ( ( (a3_0= parse_edapuC_StaticProperty ) | a4= 'send' (a5_0= parse_edapuC_Template ) ) ) )* a6= '}'
            {
            a0=(Token)match(input,23,FOLLOW_23_in_parse_edapuC_UCMessage1357); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_23, 41);
              	
            }
            // EdapuC.g:1651:2: (a1= TEXT )
            // EdapuC.g:1652:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edapuC_UCMessage1375); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_24, 42);
              	
            }
            a2=(Token)match(input,16,FOLLOW_16_in_parse_edapuC_UCMessage1396); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 43, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 43);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 43);
              	
            }
            // EdapuC.g:1708:2: ( ( ( (a3_0= parse_edapuC_StaticProperty ) | a4= 'send' (a5_0= parse_edapuC_Template ) ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=24 && LA10_0<=25)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // EdapuC.g:1709:3: ( ( (a3_0= parse_edapuC_StaticProperty ) | a4= 'send' (a5_0= parse_edapuC_Template ) ) )
            	    {
            	    // EdapuC.g:1709:3: ( ( (a3_0= parse_edapuC_StaticProperty ) | a4= 'send' (a5_0= parse_edapuC_Template ) ) )
            	    // EdapuC.g:1710:4: ( (a3_0= parse_edapuC_StaticProperty ) | a4= 'send' (a5_0= parse_edapuC_Template ) )
            	    {
            	    // EdapuC.g:1710:4: ( (a3_0= parse_edapuC_StaticProperty ) | a4= 'send' (a5_0= parse_edapuC_Template ) )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==25) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==24) ) {
            	        alt9=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // EdapuC.g:1711:5: (a3_0= parse_edapuC_StaticProperty )
            	            {
            	            // EdapuC.g:1711:5: (a3_0= parse_edapuC_StaticProperty )
            	            // EdapuC.g:1712:6: a3_0= parse_edapuC_StaticProperty
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_StaticProperty_in_parse_edapuC_UCMessage1432);
            	            a3_0=parse_edapuC_StaticProperty();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 44, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 44);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 44);
            	              				
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // EdapuC.g:1740:10: a4= 'send' (a5_0= parse_edapuC_Template )
            	            {
            	            a4=(Token)match(input,24,FOLLOW_24_in_parse_edapuC_UCMessage1475); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              					if (element == null) {
            	              						element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
            	              						incompleteObjects.push(element);
            	              						// initialize boolean attributes
            	              					}
            	              					collectHiddenTokens(element);
            	              					retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_4_0_0_1_0_1_0, null);
            	              					copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
            	              				
            	            }
            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_14, 45, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_11);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 45, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_11);
            	              				
            	            }
            	            // EdapuC.g:1756:5: (a5_0= parse_edapuC_Template )
            	            // EdapuC.g:1757:6: a5_0= parse_edapuC_Template
            	            {
            	            pushFollow(FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCMessage1505);
            	            a5_0=parse_edapuC_Template();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

            	              					// expected elements (follow set)
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 46, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 46);
            	              					addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 46);
            	              				
            	            }

            	            }
            	            break;

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 47, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 47);
            	      				addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 47);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 48, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_25, 48);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_26, 48);
              	
            }
            a6=(Token)match(input,20,FOLLOW_20_in_parse_edapuC_UCMessage1564); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createUCMessage();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_3_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_9, 49);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_10, 49);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_11, 49);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_2, 49, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_0);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_12, 49, edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.FEATURE_3);
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_13, 49);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_edapuC_UCMessage_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edapuC_UCMessage"


    // $ANTLR start "parse_edapuC_Template"
    // EdapuC.g:1823:1: parse_edapuC_Template returns [edapuC.Template element = null] : ( (a0= GENERATOR ) )? (a1= TEMPLATE ) ;
    public final edapuC.Template parse_edapuC_Template() throws RecognitionException {
        edapuC.Template element =  null;
        int parse_edapuC_Template_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // EdapuC.g:1826:1: ( ( (a0= GENERATOR ) )? (a1= TEMPLATE ) )
            // EdapuC.g:1827:2: ( (a0= GENERATOR ) )? (a1= TEMPLATE )
            {
            // EdapuC.g:1827:2: ( (a0= GENERATOR ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==GENERATOR) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // EdapuC.g:1828:3: (a0= GENERATOR )
                    {
                    // EdapuC.g:1828:3: (a0= GENERATOR )
                    // EdapuC.g:1829:4: a0= GENERATOR
                    {
                    a0=(Token)match(input,GENERATOR,FOLLOW_GENERATOR_in_parse_edapuC_Template1602); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_15, 50);
              	
            }
            // EdapuC.g:1865:2: (a1= TEMPLATE )
            // EdapuC.g:1866:3: a1= TEMPLATE
            {
            a1=(Token)match(input,TEMPLATE,FOLLOW_TEMPLATE_in_parse_edapuC_Template1636); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_edapuC_Template_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edapuC_Template"


    // $ANTLR start "parse_edapuC_StaticProperty"
    // EdapuC.g:1915:1: parse_edapuC_StaticProperty returns [edapuC.StaticProperty element = null] : a0= 'property' (a1= TEXT ) a2= '=' (a3= STRING_LITERAL ) ;
    public final edapuC.StaticProperty parse_edapuC_StaticProperty() throws RecognitionException {
        edapuC.StaticProperty element =  null;
        int parse_edapuC_StaticProperty_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // EdapuC.g:1918:1: (a0= 'property' (a1= TEXT ) a2= '=' (a3= STRING_LITERAL ) )
            // EdapuC.g:1919:2: a0= 'property' (a1= TEXT ) a2= '=' (a3= STRING_LITERAL )
            {
            a0=(Token)match(input,25,FOLLOW_25_in_parse_edapuC_StaticProperty1672); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createStaticProperty();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_5_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_27, 52);
              	
            }
            // EdapuC.g:1934:2: (a1= TEXT )
            // EdapuC.g:1935:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edapuC_StaticProperty1690); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_28, 53);
              	
            }
            a2=(Token)match(input,26,FOLLOW_26_in_parse_edapuC_StaticProperty1711); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edapuC.EdapuCFactory.eINSTANCE.createStaticProperty();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edapuC.resource.edapuC.grammar.EdapuCGrammarInformationProvider.EDAPUC_5_0_0_4, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edapuC.resource.edapuC.grammar.EdapuCFollowSetProvider.TERMINAL_29, 54);
              	
            }
            // EdapuC.g:1985:2: (a3= STRING_LITERAL )
            // EdapuC.g:1986:3: a3= STRING_LITERAL
            {
            a3=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_parse_edapuC_StaticProperty1729); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_edapuC_StaticProperty_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edapuC_StaticProperty"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_edapuC_UCGenerator_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_parse_edapuC_UCGenerator121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_parse_edapuC_UCGenerator147 = new BitSet(new long[]{0x000000000220E002L});
    public static final BitSet FOLLOW_14_in_parse_edapuC_UCGenerator202 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_parse_edapuC_UCGenerator228 = new BitSet(new long[]{0x000000000220C002L});
    public static final BitSet FOLLOW_parse_edapuC_StaticProperty_in_parse_edapuC_UCGenerator296 = new BitSet(new long[]{0x0000000002208002L});
    public static final BitSet FOLLOW_parse_edapuC_UCDevice_in_parse_edapuC_UCGenerator346 = new BitSet(new long[]{0x0000000002208002L});
    public static final BitSet FOLLOW_parse_edapuC_UCApplication_in_parse_edapuC_UCGenerator396 = new BitSet(new long[]{0x0000000002208002L});
    public static final BitSet FOLLOW_15_in_parse_edapuC_UCDevice470 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_edapuC_UCDevice488 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edapuC_UCDevice509 = new BitSet(new long[]{0x00000000029E0000L});
    public static final BitSet FOLLOW_17_in_parse_edapuC_UCDevice538 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCDevice568 = new BitSet(new long[]{0x00000000029E0000L});
    public static final BitSet FOLLOW_18_in_parse_edapuC_UCDevice611 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCDevice641 = new BitSet(new long[]{0x00000000029E0000L});
    public static final BitSet FOLLOW_19_in_parse_edapuC_UCDevice684 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCDevice714 = new BitSet(new long[]{0x00000000029E0000L});
    public static final BitSet FOLLOW_parse_edapuC_StaticProperty_in_parse_edapuC_UCDevice764 = new BitSet(new long[]{0x00000000029E0000L});
    public static final BitSet FOLLOW_parse_edapuC_UCMessage_in_parse_edapuC_UCDevice814 = new BitSet(new long[]{0x00000000029E0000L});
    public static final BitSet FOLLOW_20_in_parse_edapuC_UCDevice873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_parse_edapuC_UCApplication902 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_edapuC_UCApplication920 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edapuC_UCApplication941 = new BitSet(new long[]{0x00000000025E0000L});
    public static final BitSet FOLLOW_17_in_parse_edapuC_UCApplication970 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCApplication1000 = new BitSet(new long[]{0x00000000025E0000L});
    public static final BitSet FOLLOW_18_in_parse_edapuC_UCApplication1043 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCApplication1073 = new BitSet(new long[]{0x00000000025E0000L});
    public static final BitSet FOLLOW_19_in_parse_edapuC_UCApplication1116 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCApplication1146 = new BitSet(new long[]{0x00000000025E0000L});
    public static final BitSet FOLLOW_22_in_parse_edapuC_UCApplication1189 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCApplication1219 = new BitSet(new long[]{0x00000000025E0000L});
    public static final BitSet FOLLOW_parse_edapuC_StaticProperty_in_parse_edapuC_UCApplication1269 = new BitSet(new long[]{0x00000000025E0000L});
    public static final BitSet FOLLOW_20_in_parse_edapuC_UCApplication1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_parse_edapuC_UCMessage1357 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_edapuC_UCMessage1375 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_parse_edapuC_UCMessage1396 = new BitSet(new long[]{0x0000000003100000L});
    public static final BitSet FOLLOW_parse_edapuC_StaticProperty_in_parse_edapuC_UCMessage1432 = new BitSet(new long[]{0x0000000003100000L});
    public static final BitSet FOLLOW_24_in_parse_edapuC_UCMessage1475 = new BitSet(new long[]{0x00000000000000C0L});
    public static final BitSet FOLLOW_parse_edapuC_Template_in_parse_edapuC_UCMessage1505 = new BitSet(new long[]{0x0000000003100000L});
    public static final BitSet FOLLOW_20_in_parse_edapuC_UCMessage1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GENERATOR_in_parse_edapuC_Template1602 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_TEMPLATE_in_parse_edapuC_Template1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_parse_edapuC_StaticProperty1672 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TEXT_in_parse_edapuC_StaticProperty1690 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_parse_edapuC_StaticProperty1711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_parse_edapuC_StaticProperty1729 = new BitSet(new long[]{0x0000000000000002L});

}