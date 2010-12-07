// $ANTLR ${project.version} ${buildNumber}

	package edap.resource.edap.mopp;


import org.antlr.runtime3_2_0.*;
import java.util.HashMap;
@SuppressWarnings("unused")
public class EdapParser extends EdapANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING_LITERAL", "T_MULTICAST", "TEXT", "T_ASPECT", "T_SINGLETON", "T_READONLY", "MULTIPLICITY", "ANNOTATION", "STRING_EXT", "SL_COMMENT", "ML_COMMENT", "WHITESPACE", "LINEBREAKS", "'import'", "'message'", "'('", "','", "')'", "';'", "'device'", "'{'", "'receives'", "'sends'", "'}'", "'component'", "'simulator'", "'for'", "'property'", "':'", "'['", "'..'", "']'", "'dictionary'", "'->'", "'datatype'", "'enumeration'", "'statechart'", "'init'", "'on'", "'entry'", "'exit'", "'state'", "'composite'", "'set'", "'='", "'eventref'", "'.'", "'send'", "'port'", "'broadcast'", "'transition'", "'event'", "'guard'", "'action'", "'#'", "'connector'", "'create'"
    };
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int ANNOTATION=11;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int LINEBREAKS=16;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T_READONLY=9;
    public static final int T_MULTICAST=5;
    public static final int T__55=55;
    public static final int ML_COMMENT=14;
    public static final int MULTIPLICITY=10;
    public static final int T__19=19;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int STRING_LITERAL=4;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__18=18;
    public static final int T__53=53;
    public static final int T__17=17;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int T__50=50;
    public static final int STRING_EXT=12;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int WHITESPACE=15;
    public static final int T_ASPECT=7;
    public static final int TEXT=6;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int SL_COMMENT=13;
    public static final int T_SINGLETON=8;

    // delegates
    // delegators


        public EdapParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EdapParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[133+1];
             
             
        }
        

    public String[] getTokenNames() { return EdapParser.tokenNames; }
    public String getGrammarFileName() { return "Edap.g"; }


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
    	



    // $ANTLR start "start"
    // Edap.g:755:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_edap_EdapModel ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;
        int start_StartIndex = input.index();
        edap.EdapModel c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }
            // Edap.g:756:1: ( (c0= parse_edap_EdapModel ) EOF )
            // Edap.g:757:2: (c0= parse_edap_EdapModel ) EOF
            {
            if ( state.backtracking==0 ) {

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
            // Edap.g:771:2: (c0= parse_edap_EdapModel )
            // Edap.g:772:3: c0= parse_edap_EdapModel
            {
            pushFollow(FOLLOW_parse_edap_EdapModel_in_start82);
            c0=parse_edap_EdapModel();

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


    // $ANTLR start "parse_edap_EdapModel"
    // Edap.g:777:1: parse_edap_EdapModel returns [edap.EdapModel element = null] : ( (a0= 'import' (a1= STRING_LITERAL ) ) )* ( ( ( (a2_0= parse_edap_Type ) ) ) )* ;
    public final edap.EdapModel parse_edap_EdapModel() throws RecognitionException {
        edap.EdapModel element =  null;
        int parse_edap_EdapModel_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        edap.Type a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }
            // Edap.g:780:1: ( ( (a0= 'import' (a1= STRING_LITERAL ) ) )* ( ( ( (a2_0= parse_edap_Type ) ) ) )* )
            // Edap.g:781:2: ( (a0= 'import' (a1= STRING_LITERAL ) ) )* ( ( ( (a2_0= parse_edap_Type ) ) ) )*
            {
            // Edap.g:781:2: ( (a0= 'import' (a1= STRING_LITERAL ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Edap.g:782:3: (a0= 'import' (a1= STRING_LITERAL ) )
            	    {
            	    // Edap.g:782:3: (a0= 'import' (a1= STRING_LITERAL ) )
            	    // Edap.g:783:4: a0= 'import' (a1= STRING_LITERAL )
            	    {
            	    a0=(Token)match(input,17,FOLLOW_17_in_parse_edap_EdapModel121); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = edap.EdapFactory.eINSTANCE.createEdapModel();
            	      					incompleteObjects.push(element);
            	      					// initialize boolean attributes
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_0_0_0_0_0_0_1, null);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_10, 1);
            	      			
            	    }
            	    // Edap.g:798:4: (a1= STRING_LITERAL )
            	    // Edap.g:799:5: a1= STRING_LITERAL
            	    {
            	    a1=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_parse_edap_EdapModel147); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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
            // Edap.g:863:2: ( ( ( (a2_0= parse_edap_Type ) ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=T_ASPECT && LA2_0<=T_SINGLETON)||LA2_0==23||(LA2_0>=28 && LA2_0<=29)||(LA2_0>=38 && LA2_0<=39)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Edap.g:864:3: ( ( (a2_0= parse_edap_Type ) ) )
            	    {
            	    // Edap.g:864:3: ( ( (a2_0= parse_edap_Type ) ) )
            	    // Edap.g:865:4: ( (a2_0= parse_edap_Type ) )
            	    {
            	    // Edap.g:865:4: ( (a2_0= parse_edap_Type ) )
            	    // Edap.g:866:5: (a2_0= parse_edap_Type )
            	    {
            	    // Edap.g:866:5: (a2_0= parse_edap_Type )
            	    // Edap.g:867:6: a2_0= parse_edap_Type
            	    {
            	    pushFollow(FOLLOW_parse_edap_Type_in_parse_edap_EdapModel215);
            	    a2_0=parse_edap_Type();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, parse_edap_EdapModel_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_EdapModel"


    // $ANTLR start "parse_edap_Message"
    // Edap.g:931:1: parse_edap_Message returns [edap.Message element = null] : ( ( (a0= T_MULTICAST ) ) )? a1= 'message' (a2= TEXT ) a3= '(' ( ( (a4_0= parse_edap_Parameter ) ( (a5= ',' (a6_0= parse_edap_Parameter ) ) )* ) )? a7= ')' ( ( (a8_0= parse_edap_PlatformAnnotation ) ) )* a9= ';' ;
    public final edap.Message parse_edap_Message() throws RecognitionException {
        edap.Message element =  null;
        int parse_edap_Message_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a7=null;
        Token a9=null;
        edap.Parameter a4_0 = null;

        edap.Parameter a6_0 = null;

        edap.PlatformAnnotation a8_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }
            // Edap.g:934:1: ( ( ( (a0= T_MULTICAST ) ) )? a1= 'message' (a2= TEXT ) a3= '(' ( ( (a4_0= parse_edap_Parameter ) ( (a5= ',' (a6_0= parse_edap_Parameter ) ) )* ) )? a7= ')' ( ( (a8_0= parse_edap_PlatformAnnotation ) ) )* a9= ';' )
            // Edap.g:935:2: ( ( (a0= T_MULTICAST ) ) )? a1= 'message' (a2= TEXT ) a3= '(' ( ( (a4_0= parse_edap_Parameter ) ( (a5= ',' (a6_0= parse_edap_Parameter ) ) )* ) )? a7= ')' ( ( (a8_0= parse_edap_PlatformAnnotation ) ) )* a9= ';'
            {
            // Edap.g:935:2: ( ( (a0= T_MULTICAST ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==T_MULTICAST) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // Edap.g:936:3: ( (a0= T_MULTICAST ) )
                    {
                    // Edap.g:936:3: ( (a0= T_MULTICAST ) )
                    // Edap.g:937:4: (a0= T_MULTICAST )
                    {
                    // Edap.g:937:4: (a0= T_MULTICAST )
                    // Edap.g:938:5: a0= T_MULTICAST
                    {
                    a0=(Token)match(input,T_MULTICAST,FOLLOW_T_MULTICAST_in_parse_edap_Message304); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 7);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_12, 8);
              	
            }
            a1=(Token)match(input,18,FOLLOW_18_in_parse_edap_Message350); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createMessage();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_13, 9);
              	
            }
            // Edap.g:995:2: (a2= TEXT )
            // Edap.g:996:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Message368); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_14, 10);
              	
            }
            a3=(Token)match(input,19,FOLLOW_19_in_parse_edap_Message389); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createMessage();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_4, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_15, 11, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_1);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 11);
              	
            }
            // Edap.g:1047:2: ( ( (a4_0= parse_edap_Parameter ) ( (a5= ',' (a6_0= parse_edap_Parameter ) ) )* ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==TEXT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Edap.g:1048:3: ( (a4_0= parse_edap_Parameter ) ( (a5= ',' (a6_0= parse_edap_Parameter ) ) )* )
                    {
                    // Edap.g:1048:3: ( (a4_0= parse_edap_Parameter ) ( (a5= ',' (a6_0= parse_edap_Parameter ) ) )* )
                    // Edap.g:1049:4: (a4_0= parse_edap_Parameter ) ( (a5= ',' (a6_0= parse_edap_Parameter ) ) )*
                    {
                    // Edap.g:1049:4: (a4_0= parse_edap_Parameter )
                    // Edap.g:1050:5: a4_0= parse_edap_Parameter
                    {
                    pushFollow(FOLLOW_parse_edap_Parameter_in_parse_edap_Message418);
                    a4_0=parse_edap_Parameter();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_17, 12);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 12);
                      			
                    }
                    // Edap.g:1076:4: ( (a5= ',' (a6_0= parse_edap_Parameter ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==20) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // Edap.g:1077:5: (a5= ',' (a6_0= parse_edap_Parameter ) )
                    	    {
                    	    // Edap.g:1077:5: (a5= ',' (a6_0= parse_edap_Parameter ) )
                    	    // Edap.g:1078:6: a5= ',' (a6_0= parse_edap_Parameter )
                    	    {
                    	    a5=(Token)match(input,20,FOLLOW_20_in_parse_edap_Message459); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = edap.EdapFactory.eINSTANCE.createMessage();
                    	      							incompleteObjects.push(element);
                    	      							// initialize boolean attributes
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_5_0_0_1_0_0_0, null);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_15, 13, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_1);
                    	      					
                    	    }
                    	    // Edap.g:1093:6: (a6_0= parse_edap_Parameter )
                    	    // Edap.g:1094:7: a6_0= parse_edap_Parameter
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_Parameter_in_parse_edap_Message493);
                    	    a6_0=parse_edap_Parameter();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_17, 14);
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 14);
                    	      					
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
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_17, 15);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 15);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 16);
              	
            }
            a7=(Token)match(input,21,FOLLOW_21_in_parse_edap_Message567); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createMessage();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_6, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 17, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_19, 17);
              	
            }
            // Edap.g:1151:2: ( ( (a8_0= parse_edap_PlatformAnnotation ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ANNOTATION) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Edap.g:1152:3: ( (a8_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:1152:3: ( (a8_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:1153:4: (a8_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:1153:4: (a8_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:1154:5: a8_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Message596);
            	    a8_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 18, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_19, 18);
            	      			
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
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 19, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_19, 19);
              	
            }
            a9=(Token)match(input,22,FOLLOW_22_in_parse_edap_Message637); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createMessage();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_1_0_0_8, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, parse_edap_Message_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Message"


    // $ANTLR start "parse_edap_Device"
    // Edap.g:1228:1: parse_edap_Device returns [edap.Device element = null] : ( ( (a0= T_ASPECT ) ) )? ( ( (a1= T_SINGLETON ) ) )? a2= 'device' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) ) )* a17= '}' ;
    public final edap.Device parse_edap_Device() throws RecognitionException {
        edap.Device element =  null;
        int parse_edap_Device_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a17=null;
        edap.PlatformAnnotation a4_0 = null;

        edap.Message a6_0 = null;

        edap.Property a7_0 = null;

        edap.Component a16_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }
            // Edap.g:1231:1: ( ( ( (a0= T_ASPECT ) ) )? ( ( (a1= T_SINGLETON ) ) )? a2= 'device' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) ) )* a17= '}' )
            // Edap.g:1232:2: ( ( (a0= T_ASPECT ) ) )? ( ( (a1= T_SINGLETON ) ) )? a2= 'device' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) ) )* a17= '}'
            {
            // Edap.g:1232:2: ( ( (a0= T_ASPECT ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==T_ASPECT) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // Edap.g:1233:3: ( (a0= T_ASPECT ) )
                    {
                    // Edap.g:1233:3: ( (a0= T_ASPECT ) )
                    // Edap.g:1234:4: (a0= T_ASPECT )
                    {
                    // Edap.g:1234:4: (a0= T_ASPECT )
                    // Edap.g:1235:5: a0= T_ASPECT
                    {
                    a0=(Token)match(input,T_ASPECT,FOLLOW_T_ASPECT_in_parse_edap_Device681); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 21);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 21);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_2, 22);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 22);
              	
            }
            // Edap.g:1279:2: ( ( (a1= T_SINGLETON ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==T_SINGLETON) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // Edap.g:1280:3: ( (a1= T_SINGLETON ) )
                    {
                    // Edap.g:1280:3: ( (a1= T_SINGLETON ) )
                    // Edap.g:1281:4: (a1= T_SINGLETON )
                    {
                    // Edap.g:1281:4: (a1= T_SINGLETON )
                    // Edap.g:1282:5: a1= T_SINGLETON
                    {
                    a1=(Token)match(input,T_SINGLETON,FOLLOW_T_SINGLETON_in_parse_edap_Device742); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 23);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_3, 24);
              	
            }
            a2=(Token)match(input,23,FOLLOW_23_in_parse_edap_Device788); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createDevice();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_2, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_35, 25);
              	
            }
            // Edap.g:1339:2: (a3= TEXT )
            // Edap.g:1340:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Device806); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 26, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 26);
              	
            }
            // Edap.g:1376:2: ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==ANNOTATION) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Edap.g:1377:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:1377:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:1378:4: (a4_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:1378:4: (a4_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:1379:5: a4_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Device842);
            	    a4_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 27, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 27);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 28, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_36, 28);
              	
            }
            a5=(Token)match(input,24,FOLLOW_24_in_parse_edap_Device883); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createDevice();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_7, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Edap.g:1443:2: ( ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==T_MULTICAST||(LA13_0>=T_ASPECT && LA13_0<=T_READONLY)||LA13_0==18||LA13_0==23||(LA13_0>=25 && LA13_0<=26)||(LA13_0>=28 && LA13_0<=29)||LA13_0==31||LA13_0==36) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Edap.g:1444:3: ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) )
            	    {
            	    // Edap.g:1444:3: ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) )
            	    int alt12=5;
            	    switch ( input.LA(1) ) {
            	    case T_MULTICAST:
            	    case 18:
            	        {
            	        alt12=1;
            	        }
            	        break;
            	    case T_READONLY:
            	    case 31:
            	    case 36:
            	        {
            	        alt12=2;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt12=3;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt12=4;
            	        }
            	        break;
            	    case T_ASPECT:
            	    case T_SINGLETON:
            	    case 23:
            	    case 28:
            	    case 29:
            	        {
            	        alt12=5;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 12, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt12) {
            	        case 1 :
            	            // Edap.g:1445:4: (a6_0= parse_edap_Message )
            	            {
            	            // Edap.g:1445:4: (a6_0= parse_edap_Message )
            	            // Edap.g:1446:5: a6_0= parse_edap_Message
            	            {
            	            pushFollow(FOLLOW_parse_edap_Message_in_parse_edap_Device912);
            	            a6_0=parse_edap_Message();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;
            	        case 2 :
            	            // Edap.g:1487:8: (a7_0= parse_edap_Property )
            	            {
            	            // Edap.g:1487:8: (a7_0= parse_edap_Property )
            	            // Edap.g:1488:5: a7_0= parse_edap_Property
            	            {
            	            pushFollow(FOLLOW_parse_edap_Property_in_parse_edap_Device954);
            	            a7_0=parse_edap_Property();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;
            	        case 3 :
            	            // Edap.g:1529:8: a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )*
            	            {
            	            a8=(Token)match(input,25,FOLLOW_25_in_parse_edap_Device990); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              				if (element == null) {
            	              					element = edap.EdapFactory.eINSTANCE.createDevice();
            	              					incompleteObjects.push(element);
            	              					// initialize boolean attributes
            	              				}
            	              				collectHiddenTokens(element);
            	              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_0, null);
            	              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
            	              			
            	            }
            	            if ( state.backtracking==0 ) {

            	              				// expected elements (follow set)
            	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_37, 32);
            	              			
            	            }
            	            // Edap.g:1544:4: (a9= TEXT )
            	            // Edap.g:1545:5: a9= TEXT
            	            {
            	            a9=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Device1016); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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
            	            // Edap.g:1600:4: ( (a10= ',' (a11= TEXT ) ) )*
            	            loop10:
            	            do {
            	                int alt10=2;
            	                int LA10_0 = input.LA(1);

            	                if ( (LA10_0==20) ) {
            	                    alt10=1;
            	                }


            	                switch (alt10) {
            	            	case 1 :
            	            	    // Edap.g:1601:5: (a10= ',' (a11= TEXT ) )
            	            	    {
            	            	    // Edap.g:1601:5: (a10= ',' (a11= TEXT ) )
            	            	    // Edap.g:1602:6: a10= ',' (a11= TEXT )
            	            	    {
            	            	    a10=(Token)match(input,20,FOLLOW_20_in_parse_edap_Device1062); if (state.failed) return element;
            	            	    if ( state.backtracking==0 ) {

            	            	      						if (element == null) {
            	            	      							element = edap.EdapFactory.eINSTANCE.createDevice();
            	            	      							incompleteObjects.push(element);
            	            	      							// initialize boolean attributes
            	            	      						}
            	            	      						collectHiddenTokens(element);
            	            	      						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_2_3_0_0_0, null);
            	            	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
            	            	      					
            	            	    }
            	            	    if ( state.backtracking==0 ) {

            	            	      						// expected elements (follow set)
            	            	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_39, 34);
            	            	      					
            	            	    }
            	            	    // Edap.g:1617:6: (a11= TEXT )
            	            	    // Edap.g:1618:7: a11= TEXT
            	            	    {
            	            	    a11=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Device1096); if (state.failed) return element;
            	            	    if ( state.backtracking==0 ) {

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

            	            	    }

            	            	    if ( state.backtracking==0 ) {

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

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop10;
            	                }
            	            } while (true);

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;
            	        case 4 :
            	            // Edap.g:1697:8: a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )*
            	            {
            	            a12=(Token)match(input,26,FOLLOW_26_in_parse_edap_Device1172); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              				if (element == null) {
            	              					element = edap.EdapFactory.eINSTANCE.createDevice();
            	              					incompleteObjects.push(element);
            	              					// initialize boolean attributes
            	              				}
            	              				collectHiddenTokens(element);
            	              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_0, null);
            	              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
            	              			
            	            }
            	            if ( state.backtracking==0 ) {

            	              				// expected elements (follow set)
            	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_40, 37);
            	              			
            	            }
            	            // Edap.g:1712:4: (a13= TEXT )
            	            // Edap.g:1713:5: a13= TEXT
            	            {
            	            a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Device1198); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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
            	            // Edap.g:1768:4: ( (a14= ',' (a15= TEXT ) ) )*
            	            loop11:
            	            do {
            	                int alt11=2;
            	                int LA11_0 = input.LA(1);

            	                if ( (LA11_0==20) ) {
            	                    alt11=1;
            	                }


            	                switch (alt11) {
            	            	case 1 :
            	            	    // Edap.g:1769:5: (a14= ',' (a15= TEXT ) )
            	            	    {
            	            	    // Edap.g:1769:5: (a14= ',' (a15= TEXT ) )
            	            	    // Edap.g:1770:6: a14= ',' (a15= TEXT )
            	            	    {
            	            	    a14=(Token)match(input,20,FOLLOW_20_in_parse_edap_Device1244); if (state.failed) return element;
            	            	    if ( state.backtracking==0 ) {

            	            	      						if (element == null) {
            	            	      							element = edap.EdapFactory.eINSTANCE.createDevice();
            	            	      							incompleteObjects.push(element);
            	            	      							// initialize boolean attributes
            	            	      						}
            	            	      						collectHiddenTokens(element);
            	            	      						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_8_0_3_3_0_0_0, null);
            	            	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
            	            	      					
            	            	    }
            	            	    if ( state.backtracking==0 ) {

            	            	      						// expected elements (follow set)
            	            	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_42, 39);
            	            	      					
            	            	    }
            	            	    // Edap.g:1785:6: (a15= TEXT )
            	            	    // Edap.g:1786:7: a15= TEXT
            	            	    {
            	            	    a15=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Device1278); if (state.failed) return element;
            	            	    if ( state.backtracking==0 ) {

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

            	            	    }

            	            	    if ( state.backtracking==0 ) {

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

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop11;
            	                }
            	            } while (true);

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;
            	        case 5 :
            	            // Edap.g:1865:8: ( (a16_0= parse_edap_Component ) )
            	            {
            	            // Edap.g:1865:8: ( (a16_0= parse_edap_Component ) )
            	            // Edap.g:1866:5: (a16_0= parse_edap_Component )
            	            {
            	            // Edap.g:1866:5: (a16_0= parse_edap_Component )
            	            // Edap.g:1867:6: a16_0= parse_edap_Component
            	            {
            	            pushFollow(FOLLOW_parse_edap_Component_in_parse_edap_Device1367);
            	            a16_0=parse_edap_Component();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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
            a17=(Token)match(input,27,FOLLOW_27_in_parse_edap_Device1426); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createDevice();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_2_0_0_10, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a17, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, parse_edap_Device_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Device"


    // $ANTLR start "parse_edap_SoftwareComponent"
    // Edap.g:1992:1: parse_edap_SoftwareComponent returns [edap.SoftwareComponent element = null] : ( ( ( (a0= T_ASPECT ) ) )? ( ( (a1= T_SINGLETON ) ) )? a2= 'component' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Port ) | (a7_0= parse_edap_Connector ) | (a8_0= parse_edap_Message ) | (a9_0= parse_edap_Property ) | a10= 'receives' (a11= TEXT ) ( (a12= ',' (a13= TEXT ) ) )* | a14= 'sends' (a15= TEXT ) ( (a16= ',' (a17= TEXT ) ) )* | ( (a18_0= parse_edap_Component ) ) ) )* ( ( (a19_0= parse_edap_StateMachine ) ) )? a20= '}' | c0= parse_edap_Simulator );
    public final edap.SoftwareComponent parse_edap_SoftwareComponent() throws RecognitionException {
        edap.SoftwareComponent element =  null;
        int parse_edap_SoftwareComponent_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a16=null;
        Token a17=null;
        Token a20=null;
        edap.PlatformAnnotation a4_0 = null;

        edap.Port a6_0 = null;

        edap.Connector a7_0 = null;

        edap.Message a8_0 = null;

        edap.Property a9_0 = null;

        edap.Component a18_0 = null;

        edap.StateMachine a19_0 = null;

        edap.Simulator c0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }
            // Edap.g:1995:1: ( ( ( (a0= T_ASPECT ) ) )? ( ( (a1= T_SINGLETON ) ) )? a2= 'component' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Port ) | (a7_0= parse_edap_Connector ) | (a8_0= parse_edap_Message ) | (a9_0= parse_edap_Property ) | a10= 'receives' (a11= TEXT ) ( (a12= ',' (a13= TEXT ) ) )* | a14= 'sends' (a15= TEXT ) ( (a16= ',' (a17= TEXT ) ) )* | ( (a18_0= parse_edap_Component ) ) ) )* ( ( (a19_0= parse_edap_StateMachine ) ) )? a20= '}' | c0= parse_edap_Simulator )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=T_ASPECT && LA22_0<=T_SINGLETON)||LA22_0==28) ) {
                alt22=1;
            }
            else if ( (LA22_0==29) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // Edap.g:1996:2: ( ( (a0= T_ASPECT ) ) )? ( ( (a1= T_SINGLETON ) ) )? a2= 'component' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Port ) | (a7_0= parse_edap_Connector ) | (a8_0= parse_edap_Message ) | (a9_0= parse_edap_Property ) | a10= 'receives' (a11= TEXT ) ( (a12= ',' (a13= TEXT ) ) )* | a14= 'sends' (a15= TEXT ) ( (a16= ',' (a17= TEXT ) ) )* | ( (a18_0= parse_edap_Component ) ) ) )* ( ( (a19_0= parse_edap_StateMachine ) ) )? a20= '}'
                    {
                    // Edap.g:1996:2: ( ( (a0= T_ASPECT ) ) )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==T_ASPECT) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // Edap.g:1997:3: ( (a0= T_ASPECT ) )
                            {
                            // Edap.g:1997:3: ( (a0= T_ASPECT ) )
                            // Edap.g:1998:4: (a0= T_ASPECT )
                            {
                            // Edap.g:1998:4: (a0= T_ASPECT )
                            // Edap.g:1999:5: a0= T_ASPECT
                            {
                            a0=(Token)match(input,T_ASPECT,FOLLOW_T_ASPECT_in_parse_edap_SoftwareComponent1470); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 46);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 46);
                              			
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_5, 47);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 47);
                      	
                    }
                    // Edap.g:2043:2: ( ( (a1= T_SINGLETON ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==T_SINGLETON) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // Edap.g:2044:3: ( (a1= T_SINGLETON ) )
                            {
                            // Edap.g:2044:3: ( (a1= T_SINGLETON ) )
                            // Edap.g:2045:4: (a1= T_SINGLETON )
                            {
                            // Edap.g:2045:4: (a1= T_SINGLETON )
                            // Edap.g:2046:5: a1= T_SINGLETON
                            {
                            a1=(Token)match(input,T_SINGLETON,FOLLOW_T_SINGLETON_in_parse_edap_SoftwareComponent1531); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 48);
                              			
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_6, 49);
                      	
                    }
                    a2=(Token)match(input,28,FOLLOW_28_in_parse_edap_SoftwareComponent1577); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_2, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_43, 50);
                      	
                    }
                    // Edap.g:2103:2: (a3= TEXT )
                    // Edap.g:2104:3: a3= TEXT
                    {
                    a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_SoftwareComponent1595); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 51, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 51);
                      	
                    }
                    // Edap.g:2140:2: ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==ANNOTATION) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // Edap.g:2141:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
                    	    {
                    	    // Edap.g:2141:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
                    	    // Edap.g:2142:4: (a4_0= parse_edap_PlatformAnnotation )
                    	    {
                    	    // Edap.g:2142:4: (a4_0= parse_edap_PlatformAnnotation )
                    	    // Edap.g:2143:5: a4_0= parse_edap_PlatformAnnotation
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_SoftwareComponent1631);
                    	    a4_0=parse_edap_PlatformAnnotation();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      				// expected elements (follow set)
                    	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 52, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
                    	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 52);
                    	      			
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 53, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_44, 53);
                      	
                    }
                    a5=(Token)match(input,24,FOLLOW_24_in_parse_edap_SoftwareComponent1672); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_7, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

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
                    // Edap.g:2210:2: ( ( (a6_0= parse_edap_Port ) | (a7_0= parse_edap_Connector ) | (a8_0= parse_edap_Message ) | (a9_0= parse_edap_Property ) | a10= 'receives' (a11= TEXT ) ( (a12= ',' (a13= TEXT ) ) )* | a14= 'sends' (a15= TEXT ) ( (a16= ',' (a17= TEXT ) ) )* | ( (a18_0= parse_edap_Component ) ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==T_MULTICAST||(LA20_0>=T_ASPECT && LA20_0<=T_READONLY)||LA20_0==18||LA20_0==23||(LA20_0>=25 && LA20_0<=26)||(LA20_0>=28 && LA20_0<=29)||LA20_0==31||LA20_0==36||LA20_0==52||LA20_0==59) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // Edap.g:2211:3: ( (a6_0= parse_edap_Port ) | (a7_0= parse_edap_Connector ) | (a8_0= parse_edap_Message ) | (a9_0= parse_edap_Property ) | a10= 'receives' (a11= TEXT ) ( (a12= ',' (a13= TEXT ) ) )* | a14= 'sends' (a15= TEXT ) ( (a16= ',' (a17= TEXT ) ) )* | ( (a18_0= parse_edap_Component ) ) )
                    	    {
                    	    // Edap.g:2211:3: ( (a6_0= parse_edap_Port ) | (a7_0= parse_edap_Connector ) | (a8_0= parse_edap_Message ) | (a9_0= parse_edap_Property ) | a10= 'receives' (a11= TEXT ) ( (a12= ',' (a13= TEXT ) ) )* | a14= 'sends' (a15= TEXT ) ( (a16= ',' (a17= TEXT ) ) )* | ( (a18_0= parse_edap_Component ) ) )
                    	    int alt19=7;
                    	    switch ( input.LA(1) ) {
                    	    case 52:
                    	        {
                    	        alt19=1;
                    	        }
                    	        break;
                    	    case 59:
                    	        {
                    	        alt19=2;
                    	        }
                    	        break;
                    	    case T_MULTICAST:
                    	    case 18:
                    	        {
                    	        alt19=3;
                    	        }
                    	        break;
                    	    case T_READONLY:
                    	    case 31:
                    	    case 36:
                    	        {
                    	        alt19=4;
                    	        }
                    	        break;
                    	    case 25:
                    	        {
                    	        alt19=5;
                    	        }
                    	        break;
                    	    case 26:
                    	        {
                    	        alt19=6;
                    	        }
                    	        break;
                    	    case T_ASPECT:
                    	    case T_SINGLETON:
                    	    case 23:
                    	    case 28:
                    	    case 29:
                    	        {
                    	        alt19=7;
                    	        }
                    	        break;
                    	    default:
                    	        if (state.backtracking>0) {state.failed=true; return element;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 19, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt19) {
                    	        case 1 :
                    	            // Edap.g:2212:4: (a6_0= parse_edap_Port )
                    	            {
                    	            // Edap.g:2212:4: (a6_0= parse_edap_Port )
                    	            // Edap.g:2213:5: a6_0= parse_edap_Port
                    	            {
                    	            pushFollow(FOLLOW_parse_edap_Port_in_parse_edap_SoftwareComponent1701);
                    	            a6_0=parse_edap_Port();

                    	            state._fsp--;
                    	            if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

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

                    	            }
                    	            break;
                    	        case 2 :
                    	            // Edap.g:2257:8: (a7_0= parse_edap_Connector )
                    	            {
                    	            // Edap.g:2257:8: (a7_0= parse_edap_Connector )
                    	            // Edap.g:2258:5: a7_0= parse_edap_Connector
                    	            {
                    	            pushFollow(FOLLOW_parse_edap_Connector_in_parse_edap_SoftwareComponent1743);
                    	            a7_0=parse_edap_Connector();

                    	            state._fsp--;
                    	            if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

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

                    	            }
                    	            break;
                    	        case 3 :
                    	            // Edap.g:2302:8: (a8_0= parse_edap_Message )
                    	            {
                    	            // Edap.g:2302:8: (a8_0= parse_edap_Message )
                    	            // Edap.g:2303:5: a8_0= parse_edap_Message
                    	            {
                    	            pushFollow(FOLLOW_parse_edap_Message_in_parse_edap_SoftwareComponent1785);
                    	            a8_0=parse_edap_Message();

                    	            state._fsp--;
                    	            if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

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

                    	            }
                    	            break;
                    	        case 4 :
                    	            // Edap.g:2347:8: (a9_0= parse_edap_Property )
                    	            {
                    	            // Edap.g:2347:8: (a9_0= parse_edap_Property )
                    	            // Edap.g:2348:5: a9_0= parse_edap_Property
                    	            {
                    	            pushFollow(FOLLOW_parse_edap_Property_in_parse_edap_SoftwareComponent1827);
                    	            a9_0=parse_edap_Property();

                    	            state._fsp--;
                    	            if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

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

                    	            }
                    	            break;
                    	        case 5 :
                    	            // Edap.g:2392:8: a10= 'receives' (a11= TEXT ) ( (a12= ',' (a13= TEXT ) ) )*
                    	            {
                    	            a10=(Token)match(input,25,FOLLOW_25_in_parse_edap_SoftwareComponent1863); if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

                    	              				if (element == null) {
                    	              					element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
                    	              					incompleteObjects.push(element);
                    	              					// initialize boolean attributes
                    	              				}
                    	              				collectHiddenTokens(element);
                    	              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_4_0, null);
                    	              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
                    	              			
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              				// expected elements (follow set)
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_45, 59);
                    	              			
                    	            }
                    	            // Edap.g:2407:4: (a11= TEXT )
                    	            // Edap.g:2408:5: a11= TEXT
                    	            {
                    	            a11=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_SoftwareComponent1889); if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

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
                    	            // Edap.g:2466:4: ( (a12= ',' (a13= TEXT ) ) )*
                    	            loop17:
                    	            do {
                    	                int alt17=2;
                    	                int LA17_0 = input.LA(1);

                    	                if ( (LA17_0==20) ) {
                    	                    alt17=1;
                    	                }


                    	                switch (alt17) {
                    	            	case 1 :
                    	            	    // Edap.g:2467:5: (a12= ',' (a13= TEXT ) )
                    	            	    {
                    	            	    // Edap.g:2467:5: (a12= ',' (a13= TEXT ) )
                    	            	    // Edap.g:2468:6: a12= ',' (a13= TEXT )
                    	            	    {
                    	            	    a12=(Token)match(input,20,FOLLOW_20_in_parse_edap_SoftwareComponent1935); if (state.failed) return element;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      						if (element == null) {
                    	            	      							element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
                    	            	      							incompleteObjects.push(element);
                    	            	      							// initialize boolean attributes
                    	            	      						}
                    	            	      						collectHiddenTokens(element);
                    	            	      						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_4_3_0_0_0, null);
                    	            	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
                    	            	      					
                    	            	    }
                    	            	    if ( state.backtracking==0 ) {

                    	            	      						// expected elements (follow set)
                    	            	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_47, 61);
                    	            	      					
                    	            	    }
                    	            	    // Edap.g:2483:6: (a13= TEXT )
                    	            	    // Edap.g:2484:7: a13= TEXT
                    	            	    {
                    	            	    a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_SoftwareComponent1969); if (state.failed) return element;
                    	            	    if ( state.backtracking==0 ) {

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

                    	            	    }

                    	            	    if ( state.backtracking==0 ) {

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

                    	            	    }


                    	            	    }
                    	            	    break;

                    	            	default :
                    	            	    break loop17;
                    	                }
                    	            } while (true);

                    	            if ( state.backtracking==0 ) {

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

                    	            }
                    	            break;
                    	        case 6 :
                    	            // Edap.g:2569:8: a14= 'sends' (a15= TEXT ) ( (a16= ',' (a17= TEXT ) ) )*
                    	            {
                    	            a14=(Token)match(input,26,FOLLOW_26_in_parse_edap_SoftwareComponent2045); if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

                    	              				if (element == null) {
                    	              					element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
                    	              					incompleteObjects.push(element);
                    	              					// initialize boolean attributes
                    	              				}
                    	              				collectHiddenTokens(element);
                    	              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_5_0, null);
                    	              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
                    	              			
                    	            }
                    	            if ( state.backtracking==0 ) {

                    	              				// expected elements (follow set)
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_48, 64);
                    	              			
                    	            }
                    	            // Edap.g:2584:4: (a15= TEXT )
                    	            // Edap.g:2585:5: a15= TEXT
                    	            {
                    	            a15=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_SoftwareComponent2071); if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

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
                    	            // Edap.g:2643:4: ( (a16= ',' (a17= TEXT ) ) )*
                    	            loop18:
                    	            do {
                    	                int alt18=2;
                    	                int LA18_0 = input.LA(1);

                    	                if ( (LA18_0==20) ) {
                    	                    alt18=1;
                    	                }


                    	                switch (alt18) {
                    	            	case 1 :
                    	            	    // Edap.g:2644:5: (a16= ',' (a17= TEXT ) )
                    	            	    {
                    	            	    // Edap.g:2644:5: (a16= ',' (a17= TEXT ) )
                    	            	    // Edap.g:2645:6: a16= ',' (a17= TEXT )
                    	            	    {
                    	            	    a16=(Token)match(input,20,FOLLOW_20_in_parse_edap_SoftwareComponent2117); if (state.failed) return element;
                    	            	    if ( state.backtracking==0 ) {

                    	            	      						if (element == null) {
                    	            	      							element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
                    	            	      							incompleteObjects.push(element);
                    	            	      							// initialize boolean attributes
                    	            	      						}
                    	            	      						collectHiddenTokens(element);
                    	            	      						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_8_0_5_3_0_0_0, null);
                    	            	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
                    	            	      					
                    	            	    }
                    	            	    if ( state.backtracking==0 ) {

                    	            	      						// expected elements (follow set)
                    	            	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_50, 66);
                    	            	      					
                    	            	    }
                    	            	    // Edap.g:2660:6: (a17= TEXT )
                    	            	    // Edap.g:2661:7: a17= TEXT
                    	            	    {
                    	            	    a17=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_SoftwareComponent2151); if (state.failed) return element;
                    	            	    if ( state.backtracking==0 ) {

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

                    	            	    }

                    	            	    if ( state.backtracking==0 ) {

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

                    	            	    }


                    	            	    }
                    	            	    break;

                    	            	default :
                    	            	    break loop18;
                    	                }
                    	            } while (true);

                    	            if ( state.backtracking==0 ) {

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

                    	            }
                    	            break;
                    	        case 7 :
                    	            // Edap.g:2746:8: ( (a18_0= parse_edap_Component ) )
                    	            {
                    	            // Edap.g:2746:8: ( (a18_0= parse_edap_Component ) )
                    	            // Edap.g:2747:5: (a18_0= parse_edap_Component )
                    	            {
                    	            // Edap.g:2747:5: (a18_0= parse_edap_Component )
                    	            // Edap.g:2748:6: a18_0= parse_edap_Component
                    	            {
                    	            pushFollow(FOLLOW_parse_edap_Component_in_parse_edap_SoftwareComponent2240);
                    	            a18_0=parse_edap_Component();

                    	            state._fsp--;
                    	            if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

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

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

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
                    // Edap.g:2840:2: ( ( (a19_0= parse_edap_StateMachine ) ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==40) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // Edap.g:2841:3: ( (a19_0= parse_edap_StateMachine ) )
                            {
                            // Edap.g:2841:3: ( (a19_0= parse_edap_StateMachine ) )
                            // Edap.g:2842:4: (a19_0= parse_edap_StateMachine )
                            {
                            // Edap.g:2842:4: (a19_0= parse_edap_StateMachine )
                            // Edap.g:2843:5: a19_0= parse_edap_StateMachine
                            {
                            pushFollow(FOLLOW_parse_edap_StateMachine_in_parse_edap_SoftwareComponent2314);
                            a19_0=parse_edap_StateMachine();

                            state._fsp--;
                            if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 72);
                              			
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_32, 73);
                      	
                    }
                    a20=(Token)match(input,27,FOLLOW_27_in_parse_edap_SoftwareComponent2355); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createSoftwareComponent();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_3_0_0_11, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a20, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

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

                    }
                    break;
                case 2 :
                    // Edap.g:2917:2: c0= parse_edap_Simulator
                    {
                    pushFollow(FOLLOW_parse_edap_Simulator_in_parse_edap_SoftwareComponent2374);
                    c0=parse_edap_Simulator();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, parse_edap_SoftwareComponent_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_SoftwareComponent"


    // $ANTLR start "parse_edap_Simulator"
    // Edap.g:2921:1: parse_edap_Simulator returns [edap.Simulator element = null] : a0= 'simulator' (a1= TEXT ) a2= 'for' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) ) )* ( (a17_0= parse_edap_StateMachine ) ) a18= '}' ;
    public final edap.Simulator parse_edap_Simulator() throws RecognitionException {
        edap.Simulator element =  null;
        int parse_edap_Simulator_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        Token a12=null;
        Token a13=null;
        Token a14=null;
        Token a15=null;
        Token a18=null;
        edap.PlatformAnnotation a4_0 = null;

        edap.Message a6_0 = null;

        edap.Property a7_0 = null;

        edap.Component a16_0 = null;

        edap.StateMachine a17_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }
            // Edap.g:2924:1: (a0= 'simulator' (a1= TEXT ) a2= 'for' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) ) )* ( (a17_0= parse_edap_StateMachine ) ) a18= '}' )
            // Edap.g:2925:2: a0= 'simulator' (a1= TEXT ) a2= 'for' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) ) )* ( (a17_0= parse_edap_StateMachine ) ) a18= '}'
            {
            a0=(Token)match(input,29,FOLLOW_29_in_parse_edap_Simulator2399); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createSimulator();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_51, 75);
              	
            }
            // Edap.g:2940:2: (a1= TEXT )
            // Edap.g:2941:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Simulator2417); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_52, 76);
              	
            }
            a2=(Token)match(input,30,FOLLOW_30_in_parse_edap_Simulator2438); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createSimulator();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_53, 77);
              	
            }
            // Edap.g:2991:2: (a3= TEXT )
            // Edap.g:2992:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Simulator2456); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 78, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 78);
              	
            }
            // Edap.g:3032:2: ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==ANNOTATION) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // Edap.g:3033:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:3033:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:3034:4: (a4_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:3034:4: (a4_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:3035:5: a4_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Simulator2492);
            	    a4_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 79, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 79);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 80, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_54, 80);
              	
            }
            a5=(Token)match(input,24,FOLLOW_24_in_parse_edap_Simulator2533); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createSimulator();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_7, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Edap.g:3099:2: ( ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==T_MULTICAST||(LA27_0>=T_ASPECT && LA27_0<=T_READONLY)||LA27_0==18||LA27_0==23||(LA27_0>=25 && LA27_0<=26)||(LA27_0>=28 && LA27_0<=29)||LA27_0==31||LA27_0==36) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // Edap.g:3100:3: ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) )
            	    {
            	    // Edap.g:3100:3: ( (a6_0= parse_edap_Message ) | (a7_0= parse_edap_Property ) | a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )* | a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )* | ( (a16_0= parse_edap_Component ) ) )
            	    int alt26=5;
            	    switch ( input.LA(1) ) {
            	    case T_MULTICAST:
            	    case 18:
            	        {
            	        alt26=1;
            	        }
            	        break;
            	    case T_READONLY:
            	    case 31:
            	    case 36:
            	        {
            	        alt26=2;
            	        }
            	        break;
            	    case 25:
            	        {
            	        alt26=3;
            	        }
            	        break;
            	    case 26:
            	        {
            	        alt26=4;
            	        }
            	        break;
            	    case T_ASPECT:
            	    case T_SINGLETON:
            	    case 23:
            	    case 28:
            	    case 29:
            	        {
            	        alt26=5;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return element;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt26) {
            	        case 1 :
            	            // Edap.g:3101:4: (a6_0= parse_edap_Message )
            	            {
            	            // Edap.g:3101:4: (a6_0= parse_edap_Message )
            	            // Edap.g:3102:5: a6_0= parse_edap_Message
            	            {
            	            pushFollow(FOLLOW_parse_edap_Message_in_parse_edap_Simulator2562);
            	            a6_0=parse_edap_Message();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;
            	        case 2 :
            	            // Edap.g:3143:8: (a7_0= parse_edap_Property )
            	            {
            	            // Edap.g:3143:8: (a7_0= parse_edap_Property )
            	            // Edap.g:3144:5: a7_0= parse_edap_Property
            	            {
            	            pushFollow(FOLLOW_parse_edap_Property_in_parse_edap_Simulator2604);
            	            a7_0=parse_edap_Property();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;
            	        case 3 :
            	            // Edap.g:3185:8: a8= 'receives' (a9= TEXT ) ( (a10= ',' (a11= TEXT ) ) )*
            	            {
            	            a8=(Token)match(input,25,FOLLOW_25_in_parse_edap_Simulator2640); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              				if (element == null) {
            	              					element = edap.EdapFactory.eINSTANCE.createSimulator();
            	              					incompleteObjects.push(element);
            	              					// initialize boolean attributes
            	              				}
            	              				collectHiddenTokens(element);
            	              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_0, null);
            	              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
            	              			
            	            }
            	            if ( state.backtracking==0 ) {

            	              				// expected elements (follow set)
            	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_55, 84);
            	              			
            	            }
            	            // Edap.g:3200:4: (a9= TEXT )
            	            // Edap.g:3201:5: a9= TEXT
            	            {
            	            a9=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Simulator2666); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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
            	            // Edap.g:3256:4: ( (a10= ',' (a11= TEXT ) ) )*
            	            loop24:
            	            do {
            	                int alt24=2;
            	                int LA24_0 = input.LA(1);

            	                if ( (LA24_0==20) ) {
            	                    alt24=1;
            	                }


            	                switch (alt24) {
            	            	case 1 :
            	            	    // Edap.g:3257:5: (a10= ',' (a11= TEXT ) )
            	            	    {
            	            	    // Edap.g:3257:5: (a10= ',' (a11= TEXT ) )
            	            	    // Edap.g:3258:6: a10= ',' (a11= TEXT )
            	            	    {
            	            	    a10=(Token)match(input,20,FOLLOW_20_in_parse_edap_Simulator2712); if (state.failed) return element;
            	            	    if ( state.backtracking==0 ) {

            	            	      						if (element == null) {
            	            	      							element = edap.EdapFactory.eINSTANCE.createSimulator();
            	            	      							incompleteObjects.push(element);
            	            	      							// initialize boolean attributes
            	            	      						}
            	            	      						collectHiddenTokens(element);
            	            	      						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_2_3_0_0_0, null);
            	            	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
            	            	      					
            	            	    }
            	            	    if ( state.backtracking==0 ) {

            	            	      						// expected elements (follow set)
            	            	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_57, 86);
            	            	      					
            	            	    }
            	            	    // Edap.g:3273:6: (a11= TEXT )
            	            	    // Edap.g:3274:7: a11= TEXT
            	            	    {
            	            	    a11=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Simulator2746); if (state.failed) return element;
            	            	    if ( state.backtracking==0 ) {

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

            	            	    }

            	            	    if ( state.backtracking==0 ) {

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

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop24;
            	                }
            	            } while (true);

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;
            	        case 4 :
            	            // Edap.g:3353:8: a12= 'sends' (a13= TEXT ) ( (a14= ',' (a15= TEXT ) ) )*
            	            {
            	            a12=(Token)match(input,26,FOLLOW_26_in_parse_edap_Simulator2822); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

            	              				if (element == null) {
            	              					element = edap.EdapFactory.eINSTANCE.createSimulator();
            	              					incompleteObjects.push(element);
            	              					// initialize boolean attributes
            	              				}
            	              				collectHiddenTokens(element);
            	              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_0, null);
            	              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
            	              			
            	            }
            	            if ( state.backtracking==0 ) {

            	              				// expected elements (follow set)
            	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_58, 89);
            	              			
            	            }
            	            // Edap.g:3368:4: (a13= TEXT )
            	            // Edap.g:3369:5: a13= TEXT
            	            {
            	            a13=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Simulator2848); if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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
            	            // Edap.g:3424:4: ( (a14= ',' (a15= TEXT ) ) )*
            	            loop25:
            	            do {
            	                int alt25=2;
            	                int LA25_0 = input.LA(1);

            	                if ( (LA25_0==20) ) {
            	                    alt25=1;
            	                }


            	                switch (alt25) {
            	            	case 1 :
            	            	    // Edap.g:3425:5: (a14= ',' (a15= TEXT ) )
            	            	    {
            	            	    // Edap.g:3425:5: (a14= ',' (a15= TEXT ) )
            	            	    // Edap.g:3426:6: a14= ',' (a15= TEXT )
            	            	    {
            	            	    a14=(Token)match(input,20,FOLLOW_20_in_parse_edap_Simulator2894); if (state.failed) return element;
            	            	    if ( state.backtracking==0 ) {

            	            	      						if (element == null) {
            	            	      							element = edap.EdapFactory.eINSTANCE.createSimulator();
            	            	      							incompleteObjects.push(element);
            	            	      							// initialize boolean attributes
            	            	      						}
            	            	      						collectHiddenTokens(element);
            	            	      						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_8_0_3_3_0_0_0, null);
            	            	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
            	            	      					
            	            	    }
            	            	    if ( state.backtracking==0 ) {

            	            	      						// expected elements (follow set)
            	            	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_60, 91);
            	            	      					
            	            	    }
            	            	    // Edap.g:3441:6: (a15= TEXT )
            	            	    // Edap.g:3442:7: a15= TEXT
            	            	    {
            	            	    a15=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Simulator2928); if (state.failed) return element;
            	            	    if ( state.backtracking==0 ) {

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

            	            	    }

            	            	    if ( state.backtracking==0 ) {

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

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop25;
            	                }
            	            } while (true);

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;
            	        case 5 :
            	            // Edap.g:3521:8: ( (a16_0= parse_edap_Component ) )
            	            {
            	            // Edap.g:3521:8: ( (a16_0= parse_edap_Component ) )
            	            // Edap.g:3522:5: (a16_0= parse_edap_Component )
            	            {
            	            // Edap.g:3522:5: (a16_0= parse_edap_Component )
            	            // Edap.g:3523:6: a16_0= parse_edap_Component
            	            {
            	            pushFollow(FOLLOW_parse_edap_Component_in_parse_edap_Simulator3017);
            	            a16_0=parse_edap_Component();

            	            state._fsp--;
            	            if (state.failed) return element;
            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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

            	            }

            	            if ( state.backtracking==0 ) {

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

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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
            // Edap.g:3606:2: ( (a17_0= parse_edap_StateMachine ) )
            // Edap.g:3607:3: (a17_0= parse_edap_StateMachine )
            {
            // Edap.g:3607:3: (a17_0= parse_edap_StateMachine )
            // Edap.g:3608:4: a17_0= parse_edap_StateMachine
            {
            pushFollow(FOLLOW_parse_edap_StateMachine_in_parse_edap_Simulator3085);
            a17_0=parse_edap_StateMachine();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              			// expected elements (follow set)
              			addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_61, 97);
              		
            }

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_61, 98);
              	
            }
            a18=(Token)match(input,27,FOLLOW_27_in_parse_edap_Simulator3115); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createSimulator();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_4_0_0_11, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a18, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, parse_edap_Simulator_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Simulator"


    // $ANTLR start "parse_edap_Property"
    // Edap.g:3681:1: parse_edap_Property returns [edap.Property element = null] : ( ( ( (a0= T_READONLY ) ) )? a1= 'property' (a2= TEXT ) a3= ':' (a4= TEXT ) ( (a5= '[' (a6= MULTIPLICITY ) a7= '..' (a8= MULTIPLICITY ) a9= ']' ) )? ( ( (a10_0= parse_edap_PlatformAnnotation ) ) )* | c0= parse_edap_Dictionary );
    public final edap.Property parse_edap_Property() throws RecognitionException {
        edap.Property element =  null;
        int parse_edap_Property_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        edap.PlatformAnnotation a10_0 = null;

        edap.Dictionary c0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }
            // Edap.g:3684:1: ( ( ( (a0= T_READONLY ) ) )? a1= 'property' (a2= TEXT ) a3= ':' (a4= TEXT ) ( (a5= '[' (a6= MULTIPLICITY ) a7= '..' (a8= MULTIPLICITY ) a9= ']' ) )? ( ( (a10_0= parse_edap_PlatformAnnotation ) ) )* | c0= parse_edap_Dictionary )
            int alt31=2;
            switch ( input.LA(1) ) {
            case T_READONLY:
                {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==36) ) {
                    alt31=2;
                }
                else if ( (LA31_1==31) ) {
                    alt31=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
                }
                break;
            case 31:
                {
                alt31=1;
                }
                break;
            case 36:
                {
                alt31=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // Edap.g:3685:2: ( ( (a0= T_READONLY ) ) )? a1= 'property' (a2= TEXT ) a3= ':' (a4= TEXT ) ( (a5= '[' (a6= MULTIPLICITY ) a7= '..' (a8= MULTIPLICITY ) a9= ']' ) )? ( ( (a10_0= parse_edap_PlatformAnnotation ) ) )*
                    {
                    // Edap.g:3685:2: ( ( (a0= T_READONLY ) ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==T_READONLY) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // Edap.g:3686:3: ( (a0= T_READONLY ) )
                            {
                            // Edap.g:3686:3: ( (a0= T_READONLY ) )
                            // Edap.g:3687:4: (a0= T_READONLY )
                            {
                            // Edap.g:3687:4: (a0= T_READONLY )
                            // Edap.g:3688:5: a0= T_READONLY
                            {
                            a0=(Token)match(input,T_READONLY,FOLLOW_T_READONLY_in_parse_edap_Property3159); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 100);
                              			
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_21, 101);
                      	
                    }
                    a1=(Token)match(input,31,FOLLOW_31_in_parse_edap_Property3205); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createProperty();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_2, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_62, 102);
                      	
                    }
                    // Edap.g:3745:2: (a2= TEXT )
                    // Edap.g:3746:3: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Property3223); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_63, 103);
                      	
                    }
                    a3=(Token)match(input,32,FOLLOW_32_in_parse_edap_Property3244); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createProperty();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_5, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_64, 104);
                      	
                    }
                    // Edap.g:3796:2: (a4= TEXT )
                    // Edap.g:3797:3: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Property3262); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

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
                    // Edap.g:3873:2: ( (a5= '[' (a6= MULTIPLICITY ) a7= '..' (a8= MULTIPLICITY ) a9= ']' ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==33) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // Edap.g:3874:3: (a5= '[' (a6= MULTIPLICITY ) a7= '..' (a8= MULTIPLICITY ) a9= ']' )
                            {
                            // Edap.g:3874:3: (a5= '[' (a6= MULTIPLICITY ) a7= '..' (a8= MULTIPLICITY ) a9= ']' )
                            // Edap.g:3875:4: a5= '[' (a6= MULTIPLICITY ) a7= '..' (a8= MULTIPLICITY ) a9= ']'
                            {
                            a5=(Token)match(input,33,FOLLOW_33_in_parse_edap_Property3292); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createProperty();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_0, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_78, 106);
                              			
                            }
                            // Edap.g:3890:4: (a6= MULTIPLICITY )
                            // Edap.g:3891:5: a6= MULTIPLICITY
                            {
                            a6=(Token)match(input,MULTIPLICITY,FOLLOW_MULTIPLICITY_in_parse_edap_Property3318); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_79, 107);
                              			
                            }
                            a7=(Token)match(input,34,FOLLOW_34_in_parse_edap_Property3351); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createProperty();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_2, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_80, 108);
                              			
                            }
                            // Edap.g:3941:4: (a8= MULTIPLICITY )
                            // Edap.g:3942:5: a8= MULTIPLICITY
                            {
                            a8=(Token)match(input,MULTIPLICITY,FOLLOW_MULTIPLICITY_in_parse_edap_Property3377); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_81, 109);
                              			
                            }
                            a9=(Token)match(input,35,FOLLOW_35_in_parse_edap_Property3410); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createProperty();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_5_0_0_7_0_0_4, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

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

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

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
                    // Edap.g:4071:2: ( ( (a10_0= parse_edap_PlatformAnnotation ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==ANNOTATION) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // Edap.g:4072:3: ( (a10_0= parse_edap_PlatformAnnotation ) )
                    	    {
                    	    // Edap.g:4072:3: ( (a10_0= parse_edap_PlatformAnnotation ) )
                    	    // Edap.g:4073:4: (a10_0= parse_edap_PlatformAnnotation )
                    	    {
                    	    // Edap.g:4073:4: (a10_0= parse_edap_PlatformAnnotation )
                    	    // Edap.g:4074:5: a10_0= parse_edap_PlatformAnnotation
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Property3458);
                    	    a10_0=parse_edap_PlatformAnnotation();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

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

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

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

                    }
                    break;
                case 2 :
                    // Edap.g:4180:2: c0= parse_edap_Dictionary
                    {
                    pushFollow(FOLLOW_parse_edap_Dictionary_in_parse_edap_Property3504);
                    c0=parse_edap_Dictionary();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, parse_edap_Property_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Property"


    // $ANTLR start "parse_edap_Dictionary"
    // Edap.g:4184:1: parse_edap_Dictionary returns [edap.Dictionary element = null] : ( ( (a0= T_READONLY ) ) )? a1= 'dictionary' (a2= TEXT ) a3= ':' (a4= TEXT ) a5= '->' (a6= TEXT ) ( (a7= '[' (a8= MULTIPLICITY ) a9= '..' (a10= MULTIPLICITY ) a11= ']' ) )? ( ( (a12_0= parse_edap_PlatformAnnotation ) ) )* ;
    public final edap.Dictionary parse_edap_Dictionary() throws RecognitionException {
        edap.Dictionary element =  null;
        int parse_edap_Dictionary_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        Token a6=null;
        Token a7=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        Token a11=null;
        edap.PlatformAnnotation a12_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }
            // Edap.g:4187:1: ( ( ( (a0= T_READONLY ) ) )? a1= 'dictionary' (a2= TEXT ) a3= ':' (a4= TEXT ) a5= '->' (a6= TEXT ) ( (a7= '[' (a8= MULTIPLICITY ) a9= '..' (a10= MULTIPLICITY ) a11= ']' ) )? ( ( (a12_0= parse_edap_PlatformAnnotation ) ) )* )
            // Edap.g:4188:2: ( ( (a0= T_READONLY ) ) )? a1= 'dictionary' (a2= TEXT ) a3= ':' (a4= TEXT ) a5= '->' (a6= TEXT ) ( (a7= '[' (a8= MULTIPLICITY ) a9= '..' (a10= MULTIPLICITY ) a11= ']' ) )? ( ( (a12_0= parse_edap_PlatformAnnotation ) ) )*
            {
            // Edap.g:4188:2: ( ( (a0= T_READONLY ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==T_READONLY) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // Edap.g:4189:3: ( (a0= T_READONLY ) )
                    {
                    // Edap.g:4189:3: ( (a0= T_READONLY ) )
                    // Edap.g:4190:4: (a0= T_READONLY )
                    {
                    // Edap.g:4190:4: (a0= T_READONLY )
                    // Edap.g:4191:5: a0= T_READONLY
                    {
                    a0=(Token)match(input,T_READONLY,FOLLOW_T_READONLY_in_parse_edap_Dictionary3544); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 114);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_23, 115);
              	
            }
            a1=(Token)match(input,36,FOLLOW_36_in_parse_edap_Dictionary3590); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createDictionary();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_2, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_82, 116);
              	
            }
            // Edap.g:4248:2: (a2= TEXT )
            // Edap.g:4249:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Dictionary3608); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_83, 117);
              	
            }
            a3=(Token)match(input,32,FOLLOW_32_in_parse_edap_Dictionary3629); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createDictionary();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_84, 118);
              	
            }
            // Edap.g:4299:2: (a4= TEXT )
            // Edap.g:4300:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Dictionary3647); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_85, 119);
              	
            }
            a5=(Token)match(input,37,FOLLOW_37_in_parse_edap_Dictionary3668); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createDictionary();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_7, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_86, 120);
              	
            }
            // Edap.g:4354:2: (a6= TEXT )
            // Edap.g:4355:3: a6= TEXT
            {
            a6=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Dictionary3686); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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
            // Edap.g:4431:2: ( (a7= '[' (a8= MULTIPLICITY ) a9= '..' (a10= MULTIPLICITY ) a11= ']' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==33) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // Edap.g:4432:3: (a7= '[' (a8= MULTIPLICITY ) a9= '..' (a10= MULTIPLICITY ) a11= ']' )
                    {
                    // Edap.g:4432:3: (a7= '[' (a8= MULTIPLICITY ) a9= '..' (a10= MULTIPLICITY ) a11= ']' )
                    // Edap.g:4433:4: a7= '[' (a8= MULTIPLICITY ) a9= '..' (a10= MULTIPLICITY ) a11= ']'
                    {
                    a7=(Token)match(input,33,FOLLOW_33_in_parse_edap_Dictionary3716); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createDictionary();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_0, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_88, 122);
                      			
                    }
                    // Edap.g:4448:4: (a8= MULTIPLICITY )
                    // Edap.g:4449:5: a8= MULTIPLICITY
                    {
                    a8=(Token)match(input,MULTIPLICITY,FOLLOW_MULTIPLICITY_in_parse_edap_Dictionary3742); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_89, 123);
                      			
                    }
                    a9=(Token)match(input,34,FOLLOW_34_in_parse_edap_Dictionary3775); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createDictionary();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_2, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_90, 124);
                      			
                    }
                    // Edap.g:4499:4: (a10= MULTIPLICITY )
                    // Edap.g:4500:5: a10= MULTIPLICITY
                    {
                    a10=(Token)match(input,MULTIPLICITY,FOLLOW_MULTIPLICITY_in_parse_edap_Dictionary3801); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_91, 125);
                      			
                    }
                    a11=(Token)match(input,35,FOLLOW_35_in_parse_edap_Dictionary3834); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createDictionary();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_6_0_0_9_0_0_4, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
            // Edap.g:4629:2: ( ( (a12_0= parse_edap_PlatformAnnotation ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==ANNOTATION) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Edap.g:4630:3: ( (a12_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:4630:3: ( (a12_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:4631:4: (a12_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:4631:4: (a12_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:4632:5: a12_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Dictionary3882);
            	    a12_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, parse_edap_Dictionary_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Dictionary"


    // $ANTLR start "parse_edap_Parameter"
    // Edap.g:4738:1: parse_edap_Parameter returns [edap.Parameter element = null] : (a0= TEXT ) a1= ':' (a2= TEXT ) ;
    public final edap.Parameter parse_edap_Parameter() throws RecognitionException {
        edap.Parameter element =  null;
        int parse_edap_Parameter_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }
            // Edap.g:4741:1: ( (a0= TEXT ) a1= ':' (a2= TEXT ) )
            // Edap.g:4742:2: (a0= TEXT ) a1= ':' (a2= TEXT )
            {
            // Edap.g:4742:2: (a0= TEXT )
            // Edap.g:4743:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Parameter3942); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_92, 130);
              	
            }
            a1=(Token)match(input,32,FOLLOW_32_in_parse_edap_Parameter3963); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createParameter();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_7_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_93, 131);
              	
            }
            // Edap.g:4793:2: (a2= TEXT )
            // Edap.g:4794:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Parameter3981); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_17, 132);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_16, 132);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, parse_edap_Parameter_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Parameter"


    // $ANTLR start "parse_edap_PrimitiveType"
    // Edap.g:4836:1: parse_edap_PrimitiveType returns [edap.PrimitiveType element = null] : a0= 'datatype' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* a3= ';' ;
    public final edap.PrimitiveType parse_edap_PrimitiveType() throws RecognitionException {
        edap.PrimitiveType element =  null;
        int parse_edap_PrimitiveType_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        edap.PlatformAnnotation a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }
            // Edap.g:4839:1: (a0= 'datatype' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* a3= ';' )
            // Edap.g:4840:2: a0= 'datatype' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* a3= ';'
            {
            a0=(Token)match(input,38,FOLLOW_38_in_parse_edap_PrimitiveType4017); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createPrimitiveType();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_94, 133);
              	
            }
            // Edap.g:4855:2: (a1= TEXT )
            // Edap.g:4856:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_PrimitiveType4035); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 134, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 134);
              	
            }
            // Edap.g:4892:2: ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==ANNOTATION) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // Edap.g:4893:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:4893:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:4894:4: (a2_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:4894:4: (a2_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:4895:5: a2_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_PrimitiveType4071);
            	    a2_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 135, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 135);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 136, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_95, 136);
              	
            }
            a3=(Token)match(input,22,FOLLOW_22_in_parse_edap_PrimitiveType4112); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createPrimitiveType();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_8_0_0_4, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, parse_edap_PrimitiveType_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_PrimitiveType"


    // $ANTLR start "parse_edap_Enumeration"
    // Edap.g:4954:1: parse_edap_Enumeration returns [edap.Enumeration element = null] : a0= 'enumeration' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* a3= '{' ( ( (a4_0= parse_edap_EnumerationLiteral ) ) )* a5= '}' ;
    public final edap.Enumeration parse_edap_Enumeration() throws RecognitionException {
        edap.Enumeration element =  null;
        int parse_edap_Enumeration_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        edap.PlatformAnnotation a2_0 = null;

        edap.EnumerationLiteral a4_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }
            // Edap.g:4957:1: (a0= 'enumeration' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* a3= '{' ( ( (a4_0= parse_edap_EnumerationLiteral ) ) )* a5= '}' )
            // Edap.g:4958:2: a0= 'enumeration' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* a3= '{' ( ( (a4_0= parse_edap_EnumerationLiteral ) ) )* a5= '}'
            {
            a0=(Token)match(input,39,FOLLOW_39_in_parse_edap_Enumeration4141); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createEnumeration();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_96, 138);
              	
            }
            // Edap.g:4973:2: (a1= TEXT )
            // Edap.g:4974:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Enumeration4159); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 139, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 139);
              	
            }
            // Edap.g:5010:2: ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==ANNOTATION) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Edap.g:5011:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:5011:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:5012:4: (a2_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:5012:4: (a2_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:5013:5: a2_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Enumeration4195);
            	    a2_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 140, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 140);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 141, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_97, 141);
              	
            }
            a3=(Token)match(input,24,FOLLOW_24_in_parse_edap_Enumeration4236); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createEnumeration();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 142, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 142);
              	
            }
            // Edap.g:5063:2: ( ( (a4_0= parse_edap_EnumerationLiteral ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==TEXT) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // Edap.g:5064:3: ( (a4_0= parse_edap_EnumerationLiteral ) )
            	    {
            	    // Edap.g:5064:3: ( (a4_0= parse_edap_EnumerationLiteral ) )
            	    // Edap.g:5065:4: (a4_0= parse_edap_EnumerationLiteral )
            	    {
            	    // Edap.g:5065:4: (a4_0= parse_edap_EnumerationLiteral )
            	    // Edap.g:5066:5: a4_0= parse_edap_EnumerationLiteral
            	    {
            	    pushFollow(FOLLOW_parse_edap_EnumerationLiteral_in_parse_edap_Enumeration4265);
            	    a4_0=parse_edap_EnumerationLiteral();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 143, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 143);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 144, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 144);
              	
            }
            a5=(Token)match(input,27,FOLLOW_27_in_parse_edap_Enumeration4306); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createEnumeration();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_9_0_0_7, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, parse_edap_Enumeration_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Enumeration"


    // $ANTLR start "parse_edap_EnumerationLiteral"
    // Edap.g:5125:1: parse_edap_EnumerationLiteral returns [edap.EnumerationLiteral element = null] : (a0= TEXT ) ( ( (a1_0= parse_edap_PlatformAnnotation ) ) )* ;
    public final edap.EnumerationLiteral parse_edap_EnumerationLiteral() throws RecognitionException {
        edap.EnumerationLiteral element =  null;
        int parse_edap_EnumerationLiteral_StartIndex = input.index();
        Token a0=null;
        edap.PlatformAnnotation a1_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }
            // Edap.g:5128:1: ( (a0= TEXT ) ( ( (a1_0= parse_edap_PlatformAnnotation ) ) )* )
            // Edap.g:5129:2: (a0= TEXT ) ( ( (a1_0= parse_edap_PlatformAnnotation ) ) )*
            {
            // Edap.g:5129:2: (a0= TEXT )
            // Edap.g:5130:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_EnumerationLiteral4339); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 146, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 146, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 146);
              	
            }
            // Edap.g:5167:2: ( ( (a1_0= parse_edap_PlatformAnnotation ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==ANNOTATION) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // Edap.g:5168:3: ( (a1_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:5168:3: ( (a1_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:5169:4: (a1_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:5169:4: (a1_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:5170:5: a1_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_EnumerationLiteral4375);
            	    a1_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 147, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 147, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 147);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_98, 148, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_11);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_99, 148);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, parse_edap_EnumerationLiteral_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_EnumerationLiteral"


    // $ANTLR start "parse_edap_PlatformAnnotation"
    // Edap.g:5208:1: parse_edap_PlatformAnnotation returns [edap.PlatformAnnotation element = null] : (a0= ANNOTATION ) (a1= STRING_LITERAL ) ;
    public final edap.PlatformAnnotation parse_edap_PlatformAnnotation() throws RecognitionException {
        edap.PlatformAnnotation element =  null;
        int parse_edap_PlatformAnnotation_StartIndex = input.index();
        Token a0=null;
        Token a1=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }
            // Edap.g:5211:1: ( (a0= ANNOTATION ) (a1= STRING_LITERAL ) )
            // Edap.g:5212:2: (a0= ANNOTATION ) (a1= STRING_LITERAL )
            {
            // Edap.g:5212:2: (a0= ANNOTATION )
            // Edap.g:5213:3: a0= ANNOTATION
            {
            a0=(Token)match(input,ANNOTATION,FOLLOW_ANNOTATION_in_parse_edap_PlatformAnnotation4435); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_100, 149);
              	
            }
            // Edap.g:5248:2: (a1= STRING_LITERAL )
            // Edap.g:5249:3: a1= STRING_LITERAL
            {
            a1=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_parse_edap_PlatformAnnotation4460); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, parse_edap_PlatformAnnotation_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_PlatformAnnotation"


    // $ANTLR start "parse_edap_StateMachine"
    // Edap.g:5317:1: parse_edap_StateMachine returns [edap.StateMachine element = null] : a0= 'statechart' (a1= TEXT ) a2= 'init' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Property ) ) )* ( (a7= 'on' a8= 'entry' (a9_0= parse_edap_Action ) ) )? ( (a10= 'on' a11= 'exit' (a12_0= parse_edap_Action ) ) )? ( ( (a13_0= parse_edap_State ) ) )* a14= '}' ;
    public final edap.StateMachine parse_edap_StateMachine() throws RecognitionException {
        edap.StateMachine element =  null;
        int parse_edap_StateMachine_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a7=null;
        Token a8=null;
        Token a10=null;
        Token a11=null;
        Token a14=null;
        edap.PlatformAnnotation a4_0 = null;

        edap.Property a6_0 = null;

        edap.Action a9_0 = null;

        edap.Action a12_0 = null;

        edap.State a13_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }
            // Edap.g:5320:1: (a0= 'statechart' (a1= TEXT ) a2= 'init' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Property ) ) )* ( (a7= 'on' a8= 'entry' (a9_0= parse_edap_Action ) ) )? ( (a10= 'on' a11= 'exit' (a12_0= parse_edap_Action ) ) )? ( ( (a13_0= parse_edap_State ) ) )* a14= '}' )
            // Edap.g:5321:2: a0= 'statechart' (a1= TEXT ) a2= 'init' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( ( (a6_0= parse_edap_Property ) ) )* ( (a7= 'on' a8= 'entry' (a9_0= parse_edap_Action ) ) )? ( (a10= 'on' a11= 'exit' (a12_0= parse_edap_Action ) ) )? ( ( (a13_0= parse_edap_State ) ) )* a14= '}'
            {
            a0=(Token)match(input,40,FOLLOW_40_in_parse_edap_StateMachine4496); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createStateMachine();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_109, 151);
              	
            }
            // Edap.g:5336:2: (a1= TEXT )
            // Edap.g:5337:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_StateMachine4514); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_110, 152);
              	
            }
            a2=(Token)match(input,41,FOLLOW_41_in_parse_edap_StateMachine4535); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createStateMachine();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_4, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_111, 153);
              	
            }
            // Edap.g:5387:2: (a3= TEXT )
            // Edap.g:5388:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_StateMachine4553); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 154, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_112, 154);
              	
            }
            // Edap.g:5428:2: ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==ANNOTATION) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // Edap.g:5429:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:5429:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:5430:4: (a4_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:5430:4: (a4_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:5431:5: a4_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_StateMachine4589);
            	    a4_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 155, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_112, 155);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 156, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_112, 156);
              	
            }
            a5=(Token)match(input,24,FOLLOW_24_in_parse_edap_StateMachine4630); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createStateMachine();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_9, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Edap.g:5489:2: ( ( (a6_0= parse_edap_Property ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==T_READONLY||LA40_0==31||LA40_0==36) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // Edap.g:5490:3: ( (a6_0= parse_edap_Property ) )
            	    {
            	    // Edap.g:5490:3: ( (a6_0= parse_edap_Property ) )
            	    // Edap.g:5491:4: (a6_0= parse_edap_Property )
            	    {
            	    // Edap.g:5491:4: (a6_0= parse_edap_Property )
            	    // Edap.g:5492:5: a6_0= parse_edap_Property
            	    {
            	    pushFollow(FOLLOW_parse_edap_Property_in_parse_edap_StateMachine4659);
            	    a6_0=parse_edap_Property();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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
            // Edap.g:5542:2: ( (a7= 'on' a8= 'entry' (a9_0= parse_edap_Action ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==42) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==43) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // Edap.g:5543:3: (a7= 'on' a8= 'entry' (a9_0= parse_edap_Action ) )
                    {
                    // Edap.g:5543:3: (a7= 'on' a8= 'entry' (a9_0= parse_edap_Action ) )
                    // Edap.g:5544:4: a7= 'on' a8= 'entry' (a9_0= parse_edap_Action )
                    {
                    a7=(Token)match(input,42,FOLLOW_42_in_parse_edap_StateMachine4709); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createStateMachine();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_11_0_0_1, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a7, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_113, 160);
                      			
                    }
                    a8=(Token)match(input,43,FOLLOW_43_in_parse_edap_StateMachine4729); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createStateMachine();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_11_0_0_3, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 161, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                      			
                    }
                    // Edap.g:5579:4: (a9_0= parse_edap_Action )
                    // Edap.g:5580:5: a9_0= parse_edap_Action
                    {
                    pushFollow(FOLLOW_parse_edap_Action_in_parse_edap_StateMachine4755);
                    a9_0=parse_edap_Action();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 162);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 162, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 162, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 162, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 162);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_67, 163);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 163, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 163);
              	
            }
            // Edap.g:5620:2: ( (a10= 'on' a11= 'exit' (a12_0= parse_edap_Action ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==42) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // Edap.g:5621:3: (a10= 'on' a11= 'exit' (a12_0= parse_edap_Action ) )
                    {
                    // Edap.g:5621:3: (a10= 'on' a11= 'exit' (a12_0= parse_edap_Action ) )
                    // Edap.g:5622:4: a10= 'on' a11= 'exit' (a12_0= parse_edap_Action )
                    {
                    a10=(Token)match(input,42,FOLLOW_42_in_parse_edap_StateMachine4805); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createStateMachine();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_12_0_0_1, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_114, 164);
                      			
                    }
                    a11=(Token)match(input,44,FOLLOW_44_in_parse_edap_StateMachine4825); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createStateMachine();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_12_0_0_3, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 165, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                      			
                    }
                    // Edap.g:5657:4: (a12_0= parse_edap_Action )
                    // Edap.g:5658:5: a12_0= parse_edap_Action
                    {
                    pushFollow(FOLLOW_parse_edap_Action_in_parse_edap_StateMachine4851);
                    a12_0=parse_edap_Action();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 166, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 166, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 166, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 166);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 167, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 167, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 167, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 167);
              	
            }
            // Edap.g:5696:2: ( ( (a13_0= parse_edap_State ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==40||(LA43_0>=45 && LA43_0<=46)) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // Edap.g:5697:3: ( (a13_0= parse_edap_State ) )
            	    {
            	    // Edap.g:5697:3: ( (a13_0= parse_edap_State ) )
            	    // Edap.g:5698:4: (a13_0= parse_edap_State )
            	    {
            	    // Edap.g:5698:4: (a13_0= parse_edap_State )
            	    // Edap.g:5699:5: a13_0= parse_edap_State
            	    {
            	    pushFollow(FOLLOW_parse_edap_State_in_parse_edap_StateMachine4907);
            	    a13_0=parse_edap_State();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 168, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 168);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 169, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 169, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 169, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 169);
              	
            }
            a14=(Token)match(input,27,FOLLOW_27_in_parse_edap_StateMachine4948); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createStateMachine();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_12_0_0_15, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a14, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, parse_edap_StateMachine_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_StateMachine"


    // $ANTLR start "parse_edap_State"
    // Edap.g:5761:1: parse_edap_State returns [edap.State element = null] : (a0= 'state' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* a3= '{' ( ( (a4_0= parse_edap_Property ) ) )* ( (a5= 'on' a6= 'entry' (a7_0= parse_edap_Action ) ) )? ( (a8= 'on' a9= 'exit' (a10_0= parse_edap_Action ) ) )? ( ( (a11_0= parse_edap_Transition ) ) )* a12= '}' | c0= parse_edap_StateMachine | c1= parse_edap_CompositeState );
    public final edap.State parse_edap_State() throws RecognitionException {
        edap.State element =  null;
        int parse_edap_State_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        Token a9=null;
        Token a12=null;
        edap.PlatformAnnotation a2_0 = null;

        edap.Property a4_0 = null;

        edap.Action a7_0 = null;

        edap.Action a10_0 = null;

        edap.Transition a11_0 = null;

        edap.StateMachine c0 = null;

        edap.CompositeState c1 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }
            // Edap.g:5764:1: (a0= 'state' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* a3= '{' ( ( (a4_0= parse_edap_Property ) ) )* ( (a5= 'on' a6= 'entry' (a7_0= parse_edap_Action ) ) )? ( (a8= 'on' a9= 'exit' (a10_0= parse_edap_Action ) ) )? ( ( (a11_0= parse_edap_Transition ) ) )* a12= '}' | c0= parse_edap_StateMachine | c1= parse_edap_CompositeState )
            int alt49=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt49=1;
                }
                break;
            case 40:
                {
                int LA49_2 = input.LA(2);

                if ( (synpred61_Edap()) ) {
                    alt49=2;
                }
                else if ( (true) ) {
                    alt49=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 2, input);

                    throw nvae;
                }
                }
                break;
            case 46:
                {
                alt49=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // Edap.g:5765:2: a0= 'state' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* a3= '{' ( ( (a4_0= parse_edap_Property ) ) )* ( (a5= 'on' a6= 'entry' (a7_0= parse_edap_Action ) ) )? ( (a8= 'on' a9= 'exit' (a10_0= parse_edap_Action ) ) )? ( ( (a11_0= parse_edap_Transition ) ) )* a12= '}'
                    {
                    a0=(Token)match(input,45,FOLLOW_45_in_parse_edap_State4977); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createState();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_0, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_115, 171);
                      	
                    }
                    // Edap.g:5780:2: (a1= TEXT )
                    // Edap.g:5781:3: a1= TEXT
                    {
                    a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_State4995); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 172, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_116, 172);
                      	
                    }
                    // Edap.g:5817:2: ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==ANNOTATION) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // Edap.g:5818:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
                    	    {
                    	    // Edap.g:5818:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
                    	    // Edap.g:5819:4: (a2_0= parse_edap_PlatformAnnotation )
                    	    {
                    	    // Edap.g:5819:4: (a2_0= parse_edap_PlatformAnnotation )
                    	    // Edap.g:5820:5: a2_0= parse_edap_PlatformAnnotation
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_State5031);
                    	    a2_0=parse_edap_PlatformAnnotation();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      				// expected elements (follow set)
                    	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 173, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
                    	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_116, 173);
                    	      			
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 174, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_116, 174);
                      	
                    }
                    a3=(Token)match(input,24,FOLLOW_24_in_parse_edap_State5072); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createState();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_5, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

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
                    // Edap.g:5876:2: ( ( (a4_0= parse_edap_Property ) ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==T_READONLY||LA45_0==31||LA45_0==36) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // Edap.g:5877:3: ( (a4_0= parse_edap_Property ) )
                    	    {
                    	    // Edap.g:5877:3: ( (a4_0= parse_edap_Property ) )
                    	    // Edap.g:5878:4: (a4_0= parse_edap_Property )
                    	    {
                    	    // Edap.g:5878:4: (a4_0= parse_edap_Property )
                    	    // Edap.g:5879:5: a4_0= parse_edap_Property
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_Property_in_parse_edap_State5101);
                    	    a4_0=parse_edap_Property();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

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

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

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
                    // Edap.g:5925:2: ( (a5= 'on' a6= 'entry' (a7_0= parse_edap_Action ) ) )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==42) ) {
                        int LA46_1 = input.LA(2);

                        if ( (LA46_1==43) ) {
                            alt46=1;
                        }
                    }
                    switch (alt46) {
                        case 1 :
                            // Edap.g:5926:3: (a5= 'on' a6= 'entry' (a7_0= parse_edap_Action ) )
                            {
                            // Edap.g:5926:3: (a5= 'on' a6= 'entry' (a7_0= parse_edap_Action ) )
                            // Edap.g:5927:4: a5= 'on' a6= 'entry' (a7_0= parse_edap_Action )
                            {
                            a5=(Token)match(input,42,FOLLOW_42_in_parse_edap_State5151); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createState();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_7_0_0_1, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_117, 178);
                              			
                            }
                            a6=(Token)match(input,43,FOLLOW_43_in_parse_edap_State5171); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createState();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_7_0_0_3, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 179, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              			
                            }
                            // Edap.g:5962:4: (a7_0= parse_edap_Action )
                            // Edap.g:5963:5: a7_0= parse_edap_Action
                            {
                            pushFollow(FOLLOW_parse_edap_Action_in_parse_edap_State5197);
                            a7_0=parse_edap_Action();

                            state._fsp--;
                            if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 180);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 180, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 180);
                              			
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_72, 181);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 181, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 181);
                      	
                    }
                    // Edap.g:5999:2: ( (a8= 'on' a9= 'exit' (a10_0= parse_edap_Action ) ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==42) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // Edap.g:6000:3: (a8= 'on' a9= 'exit' (a10_0= parse_edap_Action ) )
                            {
                            // Edap.g:6000:3: (a8= 'on' a9= 'exit' (a10_0= parse_edap_Action ) )
                            // Edap.g:6001:4: a8= 'on' a9= 'exit' (a10_0= parse_edap_Action )
                            {
                            a8=(Token)match(input,42,FOLLOW_42_in_parse_edap_State5247); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createState();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_8_0_0_1, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_118, 182);
                              			
                            }
                            a9=(Token)match(input,44,FOLLOW_44_in_parse_edap_State5267); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createState();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_8_0_0_2, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 183, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              			
                            }
                            // Edap.g:6036:4: (a10_0= parse_edap_Action )
                            // Edap.g:6037:5: a10_0= parse_edap_Action
                            {
                            pushFollow(FOLLOW_parse_edap_Action_in_parse_edap_State5293);
                            a10_0=parse_edap_Action();

                            state._fsp--;
                            if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 184, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 184);
                              			
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 185, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 185);
                      	
                    }
                    // Edap.g:6071:2: ( ( (a11_0= parse_edap_Transition ) ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==54) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // Edap.g:6072:3: ( (a11_0= parse_edap_Transition ) )
                    	    {
                    	    // Edap.g:6072:3: ( (a11_0= parse_edap_Transition ) )
                    	    // Edap.g:6073:4: (a11_0= parse_edap_Transition )
                    	    {
                    	    // Edap.g:6073:4: (a11_0= parse_edap_Transition )
                    	    // Edap.g:6074:5: a11_0= parse_edap_Transition
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_Transition_in_parse_edap_State5349);
                    	    a11_0=parse_edap_Transition();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      				// expected elements (follow set)
                    	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 186, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                    	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 186);
                    	      			
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 187, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 187);
                      	
                    }
                    a12=(Token)match(input,27,FOLLOW_27_in_parse_edap_State5390); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createState();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_13_0_0_11, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 188, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 188, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 188, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 188);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 188, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 188);
                      	
                    }

                    }
                    break;
                case 2 :
                    // Edap.g:6130:2: c0= parse_edap_StateMachine
                    {
                    pushFollow(FOLLOW_parse_edap_StateMachine_in_parse_edap_State5409);
                    c0=parse_edap_StateMachine();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Edap.g:6131:4: c1= parse_edap_CompositeState
                    {
                    pushFollow(FOLLOW_parse_edap_CompositeState_in_parse_edap_State5419);
                    c1=parse_edap_CompositeState();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, parse_edap_State_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_State"


    // $ANTLR start "parse_edap_CompositeState"
    // Edap.g:6135:1: parse_edap_CompositeState returns [edap.CompositeState element = null] : (a0= 'composite' a1= 'state' (a2= TEXT ) a3= 'init' (a4= TEXT ) ( ( (a5_0= parse_edap_PlatformAnnotation ) ) )* a6= '{' ( ( (a7_0= parse_edap_Property ) ) )* ( (a8= 'on' a9= 'entry' (a10_0= parse_edap_Action ) ) )? ( (a11= 'on' a12= 'exit' (a13_0= parse_edap_Action ) ) )? ( ( (a14_0= parse_edap_Transition ) | ( (a15_0= parse_edap_State ) ) ) )* a16= '}' | c0= parse_edap_StateMachine );
    public final edap.CompositeState parse_edap_CompositeState() throws RecognitionException {
        edap.CompositeState element =  null;
        int parse_edap_CompositeState_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        Token a8=null;
        Token a9=null;
        Token a11=null;
        Token a12=null;
        Token a16=null;
        edap.PlatformAnnotation a5_0 = null;

        edap.Property a7_0 = null;

        edap.Action a10_0 = null;

        edap.Action a13_0 = null;

        edap.Transition a14_0 = null;

        edap.State a15_0 = null;

        edap.StateMachine c0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }
            // Edap.g:6138:1: (a0= 'composite' a1= 'state' (a2= TEXT ) a3= 'init' (a4= TEXT ) ( ( (a5_0= parse_edap_PlatformAnnotation ) ) )* a6= '{' ( ( (a7_0= parse_edap_Property ) ) )* ( (a8= 'on' a9= 'entry' (a10_0= parse_edap_Action ) ) )? ( (a11= 'on' a12= 'exit' (a13_0= parse_edap_Action ) ) )? ( ( (a14_0= parse_edap_Transition ) | ( (a15_0= parse_edap_State ) ) ) )* a16= '}' | c0= parse_edap_StateMachine )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==46) ) {
                alt56=1;
            }
            else if ( (LA56_0==40) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // Edap.g:6139:2: a0= 'composite' a1= 'state' (a2= TEXT ) a3= 'init' (a4= TEXT ) ( ( (a5_0= parse_edap_PlatformAnnotation ) ) )* a6= '{' ( ( (a7_0= parse_edap_Property ) ) )* ( (a8= 'on' a9= 'entry' (a10_0= parse_edap_Action ) ) )? ( (a11= 'on' a12= 'exit' (a13_0= parse_edap_Action ) ) )? ( ( (a14_0= parse_edap_Transition ) | ( (a15_0= parse_edap_State ) ) ) )* a16= '}'
                    {
                    a0=(Token)match(input,46,FOLLOW_46_in_parse_edap_CompositeState5444); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createCompositeState();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_0, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_119, 189);
                      	
                    }
                    a1=(Token)match(input,45,FOLLOW_45_in_parse_edap_CompositeState5458); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createCompositeState();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_2, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_120, 190);
                      	
                    }
                    // Edap.g:6169:2: (a2= TEXT )
                    // Edap.g:6170:3: a2= TEXT
                    {
                    a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_CompositeState5476); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_121, 191);
                      	
                    }
                    a3=(Token)match(input,41,FOLLOW_41_in_parse_edap_CompositeState5497); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createCompositeState();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_6, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_122, 192);
                      	
                    }
                    // Edap.g:6220:2: (a4= TEXT )
                    // Edap.g:6221:3: a4= TEXT
                    {
                    a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_CompositeState5515); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 193, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_123, 193);
                      	
                    }
                    // Edap.g:6261:2: ( ( (a5_0= parse_edap_PlatformAnnotation ) ) )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==ANNOTATION) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // Edap.g:6262:3: ( (a5_0= parse_edap_PlatformAnnotation ) )
                    	    {
                    	    // Edap.g:6262:3: ( (a5_0= parse_edap_PlatformAnnotation ) )
                    	    // Edap.g:6263:4: (a5_0= parse_edap_PlatformAnnotation )
                    	    {
                    	    // Edap.g:6263:4: (a5_0= parse_edap_PlatformAnnotation )
                    	    // Edap.g:6264:5: a5_0= parse_edap_PlatformAnnotation
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_CompositeState5551);
                    	    a5_0=parse_edap_PlatformAnnotation();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      				// expected elements (follow set)
                    	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 194, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
                    	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_123, 194);
                    	      			
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 195, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_123, 195);
                      	
                    }
                    a6=(Token)match(input,24,FOLLOW_24_in_parse_edap_CompositeState5592); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createCompositeState();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_11, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

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
                    // Edap.g:6323:2: ( ( (a7_0= parse_edap_Property ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==T_READONLY||LA51_0==31||LA51_0==36) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // Edap.g:6324:3: ( (a7_0= parse_edap_Property ) )
                    	    {
                    	    // Edap.g:6324:3: ( (a7_0= parse_edap_Property ) )
                    	    // Edap.g:6325:4: (a7_0= parse_edap_Property )
                    	    {
                    	    // Edap.g:6325:4: (a7_0= parse_edap_Property )
                    	    // Edap.g:6326:5: a7_0= parse_edap_Property
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_Property_in_parse_edap_CompositeState5621);
                    	    a7_0=parse_edap_Property();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

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

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop51;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

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
                    // Edap.g:6378:2: ( (a8= 'on' a9= 'entry' (a10_0= parse_edap_Action ) ) )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==42) ) {
                        int LA52_1 = input.LA(2);

                        if ( (LA52_1==43) ) {
                            alt52=1;
                        }
                    }
                    switch (alt52) {
                        case 1 :
                            // Edap.g:6379:3: (a8= 'on' a9= 'entry' (a10_0= parse_edap_Action ) )
                            {
                            // Edap.g:6379:3: (a8= 'on' a9= 'entry' (a10_0= parse_edap_Action ) )
                            // Edap.g:6380:4: a8= 'on' a9= 'entry' (a10_0= parse_edap_Action )
                            {
                            a8=(Token)match(input,42,FOLLOW_42_in_parse_edap_CompositeState5671); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createCompositeState();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_13_0_0_1, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_124, 199);
                              			
                            }
                            a9=(Token)match(input,43,FOLLOW_43_in_parse_edap_CompositeState5691); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createCompositeState();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_13_0_0_3, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 200, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_14);
                              			
                            }
                            // Edap.g:6415:4: (a10_0= parse_edap_Action )
                            // Edap.g:6416:5: a10_0= parse_edap_Action
                            {
                            pushFollow(FOLLOW_parse_edap_Action_in_parse_edap_CompositeState5717);
                            a10_0=parse_edap_Action();

                            state._fsp--;
                            if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 201);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 201, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 201, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 201, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 201, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 201);
                              			
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_76, 202);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 202, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 202);
                      	
                    }
                    // Edap.g:6458:2: ( (a11= 'on' a12= 'exit' (a13_0= parse_edap_Action ) ) )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( (LA53_0==42) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // Edap.g:6459:3: (a11= 'on' a12= 'exit' (a13_0= parse_edap_Action ) )
                            {
                            // Edap.g:6459:3: (a11= 'on' a12= 'exit' (a13_0= parse_edap_Action ) )
                            // Edap.g:6460:4: a11= 'on' a12= 'exit' (a13_0= parse_edap_Action )
                            {
                            a11=(Token)match(input,42,FOLLOW_42_in_parse_edap_CompositeState5767); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createCompositeState();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_14_0_0_1, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a11, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_125, 203);
                              			
                            }
                            a12=(Token)match(input,44,FOLLOW_44_in_parse_edap_CompositeState5787); if (state.failed) return element;
                            if ( state.backtracking==0 ) {

                              				if (element == null) {
                              					element = edap.EdapFactory.eINSTANCE.createCompositeState();
                              					incompleteObjects.push(element);
                              					// initialize boolean attributes
                              				}
                              				collectHiddenTokens(element);
                              				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_14_0_0_3, null);
                              				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
                              			
                            }
                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 204, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_15);
                              			
                            }
                            // Edap.g:6495:4: (a13_0= parse_edap_Action )
                            // Edap.g:6496:5: a13_0= parse_edap_Action
                            {
                            pushFollow(FOLLOW_parse_edap_Action_in_parse_edap_CompositeState5813);
                            a13_0=parse_edap_Action();

                            state._fsp--;
                            if (state.failed) return element;
                            if ( state.backtracking==0 ) {

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

                            }

                            if ( state.backtracking==0 ) {

                              				// expected elements (follow set)
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 205, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 205);
                              			
                            }

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 206, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 206);
                      	
                    }
                    // Edap.g:6536:2: ( ( (a14_0= parse_edap_Transition ) | ( (a15_0= parse_edap_State ) ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==40||(LA55_0>=45 && LA55_0<=46)||LA55_0==54) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // Edap.g:6537:3: ( (a14_0= parse_edap_Transition ) | ( (a15_0= parse_edap_State ) ) )
                    	    {
                    	    // Edap.g:6537:3: ( (a14_0= parse_edap_Transition ) | ( (a15_0= parse_edap_State ) ) )
                    	    int alt54=2;
                    	    int LA54_0 = input.LA(1);

                    	    if ( (LA54_0==54) ) {
                    	        alt54=1;
                    	    }
                    	    else if ( (LA54_0==40||(LA54_0>=45 && LA54_0<=46)) ) {
                    	        alt54=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return element;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 54, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt54) {
                    	        case 1 :
                    	            // Edap.g:6538:4: (a14_0= parse_edap_Transition )
                    	            {
                    	            // Edap.g:6538:4: (a14_0= parse_edap_Transition )
                    	            // Edap.g:6539:5: a14_0= parse_edap_Transition
                    	            {
                    	            pushFollow(FOLLOW_parse_edap_Transition_in_parse_edap_CompositeState5869);
                    	            a14_0=parse_edap_Transition();

                    	            state._fsp--;
                    	            if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

                    	              				// expected elements (follow set)
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 207, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 207);
                    	              			
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // Edap.g:6569:8: ( (a15_0= parse_edap_State ) )
                    	            {
                    	            // Edap.g:6569:8: ( (a15_0= parse_edap_State ) )
                    	            // Edap.g:6570:5: (a15_0= parse_edap_State )
                    	            {
                    	            // Edap.g:6570:5: (a15_0= parse_edap_State )
                    	            // Edap.g:6571:6: a15_0= parse_edap_State
                    	            {
                    	            pushFollow(FOLLOW_parse_edap_State_in_parse_edap_CompositeState5918);
                    	            a15_0=parse_edap_State();

                    	            state._fsp--;
                    	            if (state.failed) return element;
                    	            if ( state.backtracking==0 ) {

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

                    	            }

                    	            if ( state.backtracking==0 ) {

                    	              					// expected elements (follow set)
                    	              					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                    	              					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                    	              					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                    	              					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 208, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                    	              					addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 208);
                    	              				
                    	            }

                    	            }

                    	            if ( state.backtracking==0 ) {

                    	              				// expected elements (follow set)
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 209, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                    	              				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 209);
                    	              			
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 210, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 210, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 210, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 210, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 210);
                      	
                    }
                    a16=(Token)match(input,27,FOLLOW_27_in_parse_edap_CompositeState5977); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createCompositeState();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_14_0_0_17, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a16, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 211, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 211, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 211, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_70, 211);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 211, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 211);
                      	
                    }

                    }
                    break;
                case 2 :
                    // Edap.g:6643:2: c0= parse_edap_StateMachine
                    {
                    pushFollow(FOLLOW_parse_edap_StateMachine_in_parse_edap_CompositeState5996);
                    c0=parse_edap_StateMachine();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, parse_edap_CompositeState_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_CompositeState"


    // $ANTLR start "parse_edap_ActionBlock"
    // Edap.g:6647:1: parse_edap_ActionBlock returns [edap.ActionBlock element = null] : a0= '{' ( ( (a1_0= parse_edap_Action ) ) )* a2= '}' ;
    public final edap.ActionBlock parse_edap_ActionBlock() throws RecognitionException {
        edap.ActionBlock element =  null;
        int parse_edap_ActionBlock_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        edap.Action a1_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }
            // Edap.g:6650:1: (a0= '{' ( ( (a1_0= parse_edap_Action ) ) )* a2= '}' )
            // Edap.g:6651:2: a0= '{' ( ( (a1_0= parse_edap_Action ) ) )* a2= '}'
            {
            a0=(Token)match(input,24,FOLLOW_24_in_parse_edap_ActionBlock6021); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createActionBlock();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_15_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 212, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 212);
              	
            }
            // Edap.g:6672:2: ( ( (a1_0= parse_edap_Action ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==STRING_EXT||LA57_0==24||LA57_0==47||LA57_0==51||LA57_0==53||LA57_0==60) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // Edap.g:6673:3: ( (a1_0= parse_edap_Action ) )
            	    {
            	    // Edap.g:6673:3: ( (a1_0= parse_edap_Action ) )
            	    // Edap.g:6674:4: (a1_0= parse_edap_Action )
            	    {
            	    // Edap.g:6674:4: (a1_0= parse_edap_Action )
            	    // Edap.g:6675:5: a1_0= parse_edap_Action
            	    {
            	    pushFollow(FOLLOW_parse_edap_Action_in_parse_edap_ActionBlock6050);
            	    a1_0=parse_edap_Action();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 213, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 213);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 214, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_13);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_107, 214);
              	
            }
            a2=(Token)match(input,27,FOLLOW_27_in_parse_edap_ActionBlock6091); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createActionBlock();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_15_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, parse_edap_ActionBlock_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_ActionBlock"


    // $ANTLR start "parse_edap_ExternStatement"
    // Edap.g:6753:1: parse_edap_ExternStatement returns [edap.ExternStatement element = null] : (a0= STRING_EXT ) ;
    public final edap.ExternStatement parse_edap_ExternStatement() throws RecognitionException {
        edap.ExternStatement element =  null;
        int parse_edap_ExternStatement_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }
            // Edap.g:6756:1: ( (a0= STRING_EXT ) )
            // Edap.g:6757:2: (a0= STRING_EXT )
            {
            // Edap.g:6757:2: (a0= STRING_EXT )
            // Edap.g:6758:3: a0= STRING_EXT
            {
            a0=(Token)match(input,STRING_EXT,FOLLOW_STRING_EXT_in_parse_edap_ExternStatement6124); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, parse_edap_ExternStatement_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_ExternStatement"


    // $ANTLR start "parse_edap_PropertyAssignment"
    // Edap.g:6812:1: parse_edap_PropertyAssignment returns [edap.PropertyAssignment element = null] : a0= 'set' (a1= TEXT ) a2= '=' (a3_0= parse_edap_Expression ) ;
    public final edap.PropertyAssignment parse_edap_PropertyAssignment() throws RecognitionException {
        edap.PropertyAssignment element =  null;
        int parse_edap_PropertyAssignment_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        edap.Expression a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }
            // Edap.g:6815:1: (a0= 'set' (a1= TEXT ) a2= '=' (a3_0= parse_edap_Expression ) )
            // Edap.g:6816:2: a0= 'set' (a1= TEXT ) a2= '=' (a3_0= parse_edap_Expression )
            {
            a0=(Token)match(input,47,FOLLOW_47_in_parse_edap_PropertyAssignment6160); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createPropertyAssignment();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_126, 217);
              	
            }
            // Edap.g:6831:2: (a1= TEXT )
            // Edap.g:6832:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_PropertyAssignment6178); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_127, 218);
              	
            }
            a2=(Token)match(input,48,FOLLOW_48_in_parse_edap_PropertyAssignment6199); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createPropertyAssignment();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_17_0_0_4, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 219, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 219, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 219, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_16);
              	
            }
            // Edap.g:6888:2: (a3_0= parse_edap_Expression )
            // Edap.g:6889:3: a3_0= parse_edap_Expression
            {
            pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_PropertyAssignment6217);
            a3_0=parse_edap_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, parse_edap_PropertyAssignment_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_PropertyAssignment"


    // $ANTLR start "parse_edap_ExternExpression"
    // Edap.g:6933:1: parse_edap_ExternExpression returns [edap.ExternExpression element = null] : (a0= STRING_EXT ) ;
    public final edap.ExternExpression parse_edap_ExternExpression() throws RecognitionException {
        edap.ExternExpression element =  null;
        int parse_edap_ExternExpression_StartIndex = input.index();
        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }
            // Edap.g:6936:1: ( (a0= STRING_EXT ) )
            // Edap.g:6937:2: (a0= STRING_EXT )
            {
            // Edap.g:6937:2: (a0= STRING_EXT )
            // Edap.g:6938:3: a0= STRING_EXT
            {
            a0=(Token)match(input,STRING_EXT,FOLLOW_STRING_EXT_in_parse_edap_ExternExpression6254); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, parse_edap_ExternExpression_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_ExternExpression"


    // $ANTLR start "parse_edap_ComponentReference"
    // Edap.g:6996:1: parse_edap_ComponentReference returns [edap.ComponentReference element = null] : (a0= TEXT ) ( ( (a1_0= parse_edap_PropertyNavigation ) ) )* ;
    public final edap.ComponentReference parse_edap_ComponentReference() throws RecognitionException {
        edap.ComponentReference element =  null;
        int parse_edap_ComponentReference_StartIndex = input.index();
        Token a0=null;
        edap.PropertyNavigation a1_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }
            // Edap.g:6999:1: ( (a0= TEXT ) ( ( (a1_0= parse_edap_PropertyNavigation ) ) )* )
            // Edap.g:7000:2: (a0= TEXT ) ( ( (a1_0= parse_edap_PropertyNavigation ) ) )*
            {
            // Edap.g:7000:2: (a0= TEXT )
            // Edap.g:7001:3: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_ComponentReference6294); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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
            // Edap.g:7064:2: ( ( (a1_0= parse_edap_PropertyNavigation ) ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==50) ) {
                    int LA58_2 = input.LA(2);

                    if ( (LA58_2==TEXT) ) {
                        int LA58_3 = input.LA(3);

                        if ( (LA58_3==EOF||(LA58_3>=ANNOTATION && LA58_3<=STRING_EXT)||(LA58_3>=20 && LA58_3<=21)||LA58_3==24||LA58_3==27||LA58_3==33||LA58_3==35||LA58_3==40||LA58_3==42||(LA58_3>=45 && LA58_3<=47)||(LA58_3>=50 && LA58_3<=51)||(LA58_3>=53 && LA58_3<=54)||(LA58_3>=57 && LA58_3<=58)||LA58_3==60) ) {
                            alt58=1;
                        }


                    }


                }


                switch (alt58) {
            	case 1 :
            	    // Edap.g:7065:3: ( (a1_0= parse_edap_PropertyNavigation ) )
            	    {
            	    // Edap.g:7065:3: ( (a1_0= parse_edap_PropertyNavigation ) )
            	    // Edap.g:7066:4: (a1_0= parse_edap_PropertyNavigation )
            	    {
            	    // Edap.g:7066:4: (a1_0= parse_edap_PropertyNavigation )
            	    // Edap.g:7067:5: a1_0= parse_edap_PropertyNavigation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PropertyNavigation_in_parse_edap_ComponentReference6330);
            	    a1_0=parse_edap_PropertyNavigation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, parse_edap_ComponentReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_ComponentReference"


    // $ANTLR start "parse_edap_EventReference"
    // Edap.g:7149:1: parse_edap_EventReference returns [edap.EventReference element = null] : a0= 'eventref' (a1= TEXT ) a2= '.' (a3= TEXT ) ;
    public final edap.EventReference parse_edap_EventReference() throws RecognitionException {
        edap.EventReference element =  null;
        int parse_edap_EventReference_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }
            // Edap.g:7152:1: (a0= 'eventref' (a1= TEXT ) a2= '.' (a3= TEXT ) )
            // Edap.g:7153:2: a0= 'eventref' (a1= TEXT ) a2= '.' (a3= TEXT )
            {
            a0=(Token)match(input,49,FOLLOW_49_in_parse_edap_EventReference6386); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createEventReference();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_137, 225);
              	
            }
            // Edap.g:7168:2: (a1= TEXT )
            // Edap.g:7169:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_EventReference6404); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_138, 226);
              	
            }
            a2=(Token)match(input,50,FOLLOW_50_in_parse_edap_EventReference6425); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createEventReference();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_20_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_139, 227);
              	
            }
            // Edap.g:7223:2: (a3= TEXT )
            // Edap.g:7224:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_EventReference6443); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, parse_edap_EventReference_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_EventReference"


    // $ANTLR start "parse_edap_PropertyNavigation"
    // Edap.g:7286:1: parse_edap_PropertyNavigation returns [edap.PropertyNavigation element = null] : (a0= '.' (a1= TEXT ) | c0= parse_edap_DictionaryNavigation );
    public final edap.PropertyNavigation parse_edap_PropertyNavigation() throws RecognitionException {
        edap.PropertyNavigation element =  null;
        int parse_edap_PropertyNavigation_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        edap.DictionaryNavigation c0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }
            // Edap.g:7289:1: (a0= '.' (a1= TEXT ) | c0= parse_edap_DictionaryNavigation )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==50) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==TEXT) ) {
                    int LA59_2 = input.LA(3);

                    if ( (LA59_2==EOF||(LA59_2>=ANNOTATION && LA59_2<=STRING_EXT)||(LA59_2>=20 && LA59_2<=21)||LA59_2==24||LA59_2==27||LA59_2==35||LA59_2==40||LA59_2==42||(LA59_2>=45 && LA59_2<=47)||(LA59_2>=50 && LA59_2<=51)||(LA59_2>=53 && LA59_2<=54)||(LA59_2>=57 && LA59_2<=58)||LA59_2==60) ) {
                        alt59=1;
                    }
                    else if ( (LA59_2==33) ) {
                        alt59=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return element;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // Edap.g:7290:2: a0= '.' (a1= TEXT )
                    {
                    a0=(Token)match(input,50,FOLLOW_50_in_parse_edap_PropertyNavigation6479); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      		if (element == null) {
                      			element = edap.EdapFactory.eINSTANCE.createPropertyNavigation();
                      			incompleteObjects.push(element);
                      			// initialize boolean attributes
                      		}
                      		collectHiddenTokens(element);
                      		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_21_0_0_0, null);
                      		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
                      	
                    }
                    if ( state.backtracking==0 ) {

                      		// expected elements (follow set)
                      		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_140, 229);
                      	
                    }
                    // Edap.g:7305:2: (a1= TEXT )
                    // Edap.g:7306:3: a1= TEXT
                    {
                    a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_PropertyNavigation6497); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

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

                    }
                    break;
                case 2 :
                    // Edap.g:7371:2: c0= parse_edap_DictionaryNavigation
                    {
                    pushFollow(FOLLOW_parse_edap_DictionaryNavigation_in_parse_edap_PropertyNavigation6523);
                    c0=parse_edap_DictionaryNavigation();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, parse_edap_PropertyNavigation_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_PropertyNavigation"


    // $ANTLR start "parse_edap_DictionaryNavigation"
    // Edap.g:7375:1: parse_edap_DictionaryNavigation returns [edap.DictionaryNavigation element = null] : a0= '.' (a1= TEXT ) a2= '[' (a3_0= parse_edap_Expression ) a4= ']' ;
    public final edap.DictionaryNavigation parse_edap_DictionaryNavigation() throws RecognitionException {
        edap.DictionaryNavigation element =  null;
        int parse_edap_DictionaryNavigation_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a4=null;
        edap.Expression a3_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }
            // Edap.g:7378:1: (a0= '.' (a1= TEXT ) a2= '[' (a3_0= parse_edap_Expression ) a4= ']' )
            // Edap.g:7379:2: a0= '.' (a1= TEXT ) a2= '[' (a3_0= parse_edap_Expression ) a4= ']'
            {
            a0=(Token)match(input,50,FOLLOW_50_in_parse_edap_DictionaryNavigation6548); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createDictionaryNavigation();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_22_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_141, 231);
              	
            }
            // Edap.g:7394:2: (a1= TEXT )
            // Edap.g:7395:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_DictionaryNavigation6566); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_142, 232);
              	
            }
            a2=(Token)match(input,33,FOLLOW_33_in_parse_edap_DictionaryNavigation6587); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createDictionaryNavigation();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_22_0_0_2, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 233, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 233, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 233, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_18);
              	
            }
            // Edap.g:7451:2: (a3_0= parse_edap_Expression )
            // Edap.g:7452:3: a3_0= parse_edap_Expression
            {
            pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_DictionaryNavigation6605);
            a3_0=parse_edap_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_131, 234);
              	
            }
            a4=(Token)match(input,35,FOLLOW_35_in_parse_edap_DictionaryNavigation6623); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createDictionaryNavigation();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_22_0_0_4, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, parse_edap_DictionaryNavigation_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_DictionaryNavigation"


    // $ANTLR start "parse_edap_Unicast"
    // Edap.g:7518:1: parse_edap_Unicast returns [edap.Unicast element = null] : a0= 'send' (a1_0= parse_edap_Expression ) a2= '.' (a3= TEXT ) a4= '(' ( ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* ) )? a8= ')' ( (a9= 'port' (a10= TEXT ) ) )? ( ( (a11_0= parse_edap_PlatformAnnotation ) ) )* ;
    public final edap.Unicast parse_edap_Unicast() throws RecognitionException {
        edap.Unicast element =  null;
        int parse_edap_Unicast_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        Token a8=null;
        Token a9=null;
        Token a10=null;
        edap.Expression a1_0 = null;

        edap.Expression a5_0 = null;

        edap.Expression a7_0 = null;

        edap.PlatformAnnotation a11_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }
            // Edap.g:7521:1: (a0= 'send' (a1_0= parse_edap_Expression ) a2= '.' (a3= TEXT ) a4= '(' ( ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* ) )? a8= ')' ( (a9= 'port' (a10= TEXT ) ) )? ( ( (a11_0= parse_edap_PlatformAnnotation ) ) )* )
            // Edap.g:7522:2: a0= 'send' (a1_0= parse_edap_Expression ) a2= '.' (a3= TEXT ) a4= '(' ( ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* ) )? a8= ')' ( (a9= 'port' (a10= TEXT ) ) )? ( ( (a11_0= parse_edap_PlatformAnnotation ) ) )*
            {
            a0=(Token)match(input,51,FOLLOW_51_in_parse_edap_Unicast6652); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createUnicast();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 236, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
              	
            }
            // Edap.g:7539:2: (a1_0= parse_edap_Expression )
            // Edap.g:7540:3: a1_0= parse_edap_Expression
            {
            pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_Unicast6670);
            a1_0=parse_edap_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_132, 237);
              	
            }
            a2=(Token)match(input,50,FOLLOW_50_in_parse_edap_Unicast6688); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createUnicast();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_143, 238);
              	
            }
            // Edap.g:7580:2: (a3= TEXT )
            // Edap.g:7581:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Unicast6706); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_144, 239);
              	
            }
            a4=(Token)match(input,19,FOLLOW_19_in_parse_edap_Unicast6727); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createUnicast();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 240, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 240);
              	
            }
            // Edap.g:7638:2: ( ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==TEXT||LA61_0==STRING_EXT||LA61_0==49) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // Edap.g:7639:3: ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* )
                    {
                    // Edap.g:7639:3: ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* )
                    // Edap.g:7640:4: (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )*
                    {
                    // Edap.g:7640:4: (a5_0= parse_edap_Expression )
                    // Edap.g:7641:5: a5_0= parse_edap_Expression
                    {
                    pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_Unicast6756);
                    a5_0=parse_edap_Expression();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 241);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 241);
                      			
                    }
                    // Edap.g:7667:4: ( (a6= ',' (a7_0= parse_edap_Expression ) ) )*
                    loop60:
                    do {
                        int alt60=2;
                        int LA60_0 = input.LA(1);

                        if ( (LA60_0==20) ) {
                            alt60=1;
                        }


                        switch (alt60) {
                    	case 1 :
                    	    // Edap.g:7668:5: (a6= ',' (a7_0= parse_edap_Expression ) )
                    	    {
                    	    // Edap.g:7668:5: (a6= ',' (a7_0= parse_edap_Expression ) )
                    	    // Edap.g:7669:6: a6= ',' (a7_0= parse_edap_Expression )
                    	    {
                    	    a6=(Token)match(input,20,FOLLOW_20_in_parse_edap_Unicast6797); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = edap.EdapFactory.eINSTANCE.createUnicast();
                    	      							incompleteObjects.push(element);
                    	      							// initialize boolean attributes
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_6_0_0_1_0_0_0, null);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 242, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 242, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 242, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
                    	      					
                    	    }
                    	    // Edap.g:7686:6: (a7_0= parse_edap_Expression )
                    	    // Edap.g:7687:7: a7_0= parse_edap_Expression
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_Unicast6831);
                    	    a7_0=parse_edap_Expression();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 243);
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 243);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_146, 244);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 244);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_145, 245);
              	
            }
            a8=(Token)match(input,21,FOLLOW_21_in_parse_edap_Unicast6905); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createUnicast();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_7, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Edap.g:7762:2: ( (a9= 'port' (a10= TEXT ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==52) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // Edap.g:7763:3: (a9= 'port' (a10= TEXT ) )
                    {
                    // Edap.g:7763:3: (a9= 'port' (a10= TEXT ) )
                    // Edap.g:7764:4: a9= 'port' (a10= TEXT )
                    {
                    a9=(Token)match(input,52,FOLLOW_52_in_parse_edap_Unicast6928); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createUnicast();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_23_0_0_8_0_0_0, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a9, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_148, 247);
                      			
                    }
                    // Edap.g:7779:4: (a10= TEXT )
                    // Edap.g:7780:5: a10= TEXT
                    {
                    a10=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Unicast6954); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

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

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

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
            // Edap.g:7862:2: ( ( (a11_0= parse_edap_PlatformAnnotation ) ) )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==ANNOTATION) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // Edap.g:7863:3: ( (a11_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:7863:3: ( (a11_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:7864:4: (a11_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:7864:4: (a11_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:7865:5: a11_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Unicast7015);
            	    a11_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop63;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, parse_edap_Unicast_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Unicast"


    // $ANTLR start "parse_edap_Broadcast"
    // Edap.g:7935:1: parse_edap_Broadcast returns [edap.Broadcast element = null] : a0= 'broadcast' (a1_0= parse_edap_Expression ) a2= '.' (a3= TEXT ) a4= '(' ( ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* ) )? a8= ')' ;
    public final edap.Broadcast parse_edap_Broadcast() throws RecognitionException {
        edap.Broadcast element =  null;
        int parse_edap_Broadcast_StartIndex = input.index();
        Token a0=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a6=null;
        Token a8=null;
        edap.Expression a1_0 = null;

        edap.Expression a5_0 = null;

        edap.Expression a7_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }
            // Edap.g:7938:1: (a0= 'broadcast' (a1_0= parse_edap_Expression ) a2= '.' (a3= TEXT ) a4= '(' ( ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* ) )? a8= ')' )
            // Edap.g:7939:2: a0= 'broadcast' (a1_0= parse_edap_Expression ) a2= '.' (a3= TEXT ) a4= '(' ( ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* ) )? a8= ')'
            {
            a0=(Token)match(input,53,FOLLOW_53_in_parse_edap_Broadcast7071); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createBroadcast();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 252, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 252, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 252, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_19);
              	
            }
            // Edap.g:7956:2: (a1_0= parse_edap_Expression )
            // Edap.g:7957:3: a1_0= parse_edap_Expression
            {
            pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_Broadcast7089);
            a1_0=parse_edap_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_133, 253);
              	
            }
            a2=(Token)match(input,50,FOLLOW_50_in_parse_edap_Broadcast7107); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createBroadcast();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_149, 254);
              	
            }
            // Edap.g:7997:2: (a3= TEXT )
            // Edap.g:7998:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Broadcast7125); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_150, 255);
              	
            }
            a4=(Token)match(input,19,FOLLOW_19_in_parse_edap_Broadcast7146); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createBroadcast();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a4, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 256, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 256, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 256, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 256);
              	
            }
            // Edap.g:8055:2: ( ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==TEXT||LA65_0==STRING_EXT||LA65_0==49) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // Edap.g:8056:3: ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* )
                    {
                    // Edap.g:8056:3: ( (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )* )
                    // Edap.g:8057:4: (a5_0= parse_edap_Expression ) ( (a6= ',' (a7_0= parse_edap_Expression ) ) )*
                    {
                    // Edap.g:8057:4: (a5_0= parse_edap_Expression )
                    // Edap.g:8058:5: a5_0= parse_edap_Expression
                    {
                    pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_Broadcast7175);
                    a5_0=parse_edap_Expression();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 257);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 257);
                      			
                    }
                    // Edap.g:8084:4: ( (a6= ',' (a7_0= parse_edap_Expression ) ) )*
                    loop64:
                    do {
                        int alt64=2;
                        int LA64_0 = input.LA(1);

                        if ( (LA64_0==20) ) {
                            alt64=1;
                        }


                        switch (alt64) {
                    	case 1 :
                    	    // Edap.g:8085:5: (a6= ',' (a7_0= parse_edap_Expression ) )
                    	    {
                    	    // Edap.g:8085:5: (a6= ',' (a7_0= parse_edap_Expression ) )
                    	    // Edap.g:8086:6: a6= ',' (a7_0= parse_edap_Expression )
                    	    {
                    	    a6=(Token)match(input,20,FOLLOW_20_in_parse_edap_Broadcast7216); if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

                    	      						if (element == null) {
                    	      							element = edap.EdapFactory.eINSTANCE.createBroadcast();
                    	      							incompleteObjects.push(element);
                    	      							// initialize boolean attributes
                    	      						}
                    	      						collectHiddenTokens(element);
                    	      						retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_6_0_0_1_0_0_0, null);
                    	      						copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 258, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 258, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 258, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_20);
                    	      					
                    	    }
                    	    // Edap.g:8103:6: (a7_0= parse_edap_Expression )
                    	    // Edap.g:8104:7: a7_0= parse_edap_Expression
                    	    {
                    	    pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_Broadcast7250);
                    	    a7_0=parse_edap_Expression();

                    	    state._fsp--;
                    	    if (state.failed) return element;
                    	    if ( state.backtracking==0 ) {

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

                    	    }

                    	    if ( state.backtracking==0 ) {

                    	      						// expected elements (follow set)
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 259);
                    	      						addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 259);
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop64;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_152, 260);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 260);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_151, 261);
              	
            }
            a8=(Token)match(input,21,FOLLOW_21_in_parse_edap_Broadcast7324); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createBroadcast();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_24_0_0_7, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
              	
            }
            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, parse_edap_Broadcast_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Broadcast"


    // $ANTLR start "parse_edap_Transition"
    // Edap.g:8179:1: parse_edap_Transition returns [edap.Transition element = null] : a0= 'transition' (a1= TEXT ) a2= '->' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( (a6= 'event' (a7_0= parse_edap_Event ) ) )* ( (a8= 'guard' (a9_0= parse_edap_Expression ) ) )? ( (a10= 'action' (a11_0= parse_edap_Action ) ) )? a12= '}' ;
    public final edap.Transition parse_edap_Transition() throws RecognitionException {
        edap.Transition element =  null;
        int parse_edap_Transition_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a5=null;
        Token a6=null;
        Token a8=null;
        Token a10=null;
        Token a12=null;
        edap.PlatformAnnotation a4_0 = null;

        edap.Event a7_0 = null;

        edap.Expression a9_0 = null;

        edap.Action a11_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }
            // Edap.g:8182:1: (a0= 'transition' (a1= TEXT ) a2= '->' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( (a6= 'event' (a7_0= parse_edap_Event ) ) )* ( (a8= 'guard' (a9_0= parse_edap_Expression ) ) )? ( (a10= 'action' (a11_0= parse_edap_Action ) ) )? a12= '}' )
            // Edap.g:8183:2: a0= 'transition' (a1= TEXT ) a2= '->' (a3= TEXT ) ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )* a5= '{' ( (a6= 'event' (a7_0= parse_edap_Event ) ) )* ( (a8= 'guard' (a9_0= parse_edap_Expression ) ) )? ( (a10= 'action' (a11_0= parse_edap_Action ) ) )? a12= '}'
            {
            a0=(Token)match(input,54,FOLLOW_54_in_parse_edap_Transition7353); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createTransition();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_153, 263);
              	
            }
            // Edap.g:8198:2: (a1= TEXT )
            // Edap.g:8199:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Transition7371); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_154, 264);
              	
            }
            a2=(Token)match(input,37,FOLLOW_37_in_parse_edap_Transition7392); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createTransition();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a2, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_155, 265);
              	
            }
            // Edap.g:8249:2: (a3= TEXT )
            // Edap.g:8250:3: a3= TEXT
            {
            a3=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Transition7410); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 266, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_156, 266);
              	
            }
            // Edap.g:8290:2: ( ( (a4_0= parse_edap_PlatformAnnotation ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==ANNOTATION) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // Edap.g:8291:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:8291:3: ( (a4_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:8292:4: (a4_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:8292:4: (a4_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:8293:5: a4_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Transition7446);
            	    a4_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 267, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_156, 267);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop66;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_18, 268, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_2);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_156, 268);
              	
            }
            a5=(Token)match(input,24,FOLLOW_24_in_parse_edap_Transition7487); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createTransition();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_10, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 269);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 269);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 269);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 269);
              	
            }
            // Edap.g:8345:2: ( (a6= 'event' (a7_0= parse_edap_Event ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==55) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // Edap.g:8346:3: (a6= 'event' (a7_0= parse_edap_Event ) )
            	    {
            	    // Edap.g:8346:3: (a6= 'event' (a7_0= parse_edap_Event ) )
            	    // Edap.g:8347:4: a6= 'event' (a7_0= parse_edap_Event )
            	    {
            	    a6=(Token)match(input,55,FOLLOW_55_in_parse_edap_Transition7510); if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

            	      				if (element == null) {
            	      					element = edap.EdapFactory.eINSTANCE.createTransition();
            	      					incompleteObjects.push(element);
            	      					// initialize boolean attributes
            	      				}
            	      				collectHiddenTokens(element);
            	      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_11_0_0_1, null);
            	      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a6, element);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 270, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 270, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 270, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_21, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_22);
            	      			
            	    }
            	    // Edap.g:8364:4: (a7_0= parse_edap_Event )
            	    // Edap.g:8365:5: a7_0= parse_edap_Event
            	    {
            	    pushFollow(FOLLOW_parse_edap_Event_in_parse_edap_Transition7536);
            	    a7_0=parse_edap_Event();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

            	      				// expected elements (follow set)
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 271);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 271);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 271);
            	      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 271);
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 272);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 272);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 272);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 272);
              	
            }
            // Edap.g:8403:2: ( (a8= 'guard' (a9_0= parse_edap_Expression ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==56) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // Edap.g:8404:3: (a8= 'guard' (a9_0= parse_edap_Expression ) )
                    {
                    // Edap.g:8404:3: (a8= 'guard' (a9_0= parse_edap_Expression ) )
                    // Edap.g:8405:4: a8= 'guard' (a9_0= parse_edap_Expression )
                    {
                    a8=(Token)match(input,56,FOLLOW_56_in_parse_edap_Transition7586); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createTransition();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_12_0_0_1, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a8, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_128, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_130, 273, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_23);
                      			
                    }
                    // Edap.g:8422:4: (a9_0= parse_edap_Expression )
                    // Edap.g:8423:5: a9_0= parse_edap_Expression
                    {
                    pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_Transition7612);
                    a9_0=parse_edap_Expression();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 274);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 274);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 275);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 275);
              	
            }
            // Edap.g:8457:2: ( (a10= 'action' (a11_0= parse_edap_Action ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==57) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // Edap.g:8458:3: (a10= 'action' (a11_0= parse_edap_Action ) )
                    {
                    // Edap.g:8458:3: (a10= 'action' (a11_0= parse_edap_Action ) )
                    // Edap.g:8459:4: a10= 'action' (a11_0= parse_edap_Action )
                    {
                    a10=(Token)match(input,57,FOLLOW_57_in_parse_edap_Transition7662); if (state.failed) return element;
                    if ( state.backtracking==0 ) {

                      				if (element == null) {
                      					element = edap.EdapFactory.eINSTANCE.createTransition();
                      					incompleteObjects.push(element);
                      					// initialize boolean attributes
                      				}
                      				collectHiddenTokens(element);
                      				retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_13_0_0_1, null);
                      				copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a10, element);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_101, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_102, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_103, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_104, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_105, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_106, 276, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_24);
                      			
                    }
                    // Edap.g:8479:4: (a11_0= parse_edap_Action )
                    // Edap.g:8480:5: a11_0= parse_edap_Action
                    {
                    pushFollow(FOLLOW_parse_edap_Action_in_parse_edap_Transition7688);
                    a11_0=parse_edap_Action();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {

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

                    }

                    if ( state.backtracking==0 ) {

                      				// expected elements (follow set)
                      				addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 277);
                      			
                    }

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 278);
              	
            }
            a12=(Token)match(input,27,FOLLOW_27_in_parse_edap_Transition7729); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createTransition();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_25_0_0_15, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a12, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_73, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_10);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_74, 279);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_31, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_68, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_69, 279, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_9);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_77, 279);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, parse_edap_Transition_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Transition"


    // $ANTLR start "parse_edap_ReceiveMessage"
    // Edap.g:8534:1: parse_edap_ReceiveMessage returns [edap.ReceiveMessage element = null] : (a0_0= parse_edap_Expression ) a1= '#' (a2= TEXT ) ;
    public final edap.ReceiveMessage parse_edap_ReceiveMessage() throws RecognitionException {
        edap.ReceiveMessage element =  null;
        int parse_edap_ReceiveMessage_StartIndex = input.index();
        Token a1=null;
        Token a2=null;
        edap.Expression a0_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }
            // Edap.g:8537:1: ( (a0_0= parse_edap_Expression ) a1= '#' (a2= TEXT ) )
            // Edap.g:8538:2: (a0_0= parse_edap_Expression ) a1= '#' (a2= TEXT )
            {
            // Edap.g:8538:2: (a0_0= parse_edap_Expression )
            // Edap.g:8539:3: a0_0= parse_edap_Expression
            {
            pushFollow(FOLLOW_parse_edap_Expression_in_parse_edap_ReceiveMessage7762);
            a0_0=parse_edap_Expression();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_134, 280);
              	
            }
            a1=(Token)match(input,58,FOLLOW_58_in_parse_edap_ReceiveMessage7780); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createReceiveMessage();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_26_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_160, 281);
              	
            }
            // Edap.g:8579:2: (a2= TEXT )
            // Edap.g:8580:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_ReceiveMessage7798); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_157, 282);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_158, 282);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_159, 282);
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_108, 282);
              	
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, parse_edap_ReceiveMessage_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_ReceiveMessage"


    // $ANTLR start "parse_edap_Connector"
    // Edap.g:8624:1: parse_edap_Connector returns [edap.Connector element = null] : a0= 'connector' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ')' ( ( (a6_0= parse_edap_PlatformAnnotation ) ) )* ;
    public final edap.Connector parse_edap_Connector() throws RecognitionException {
        edap.Connector element =  null;
        int parse_edap_Connector_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        Token a2=null;
        Token a3=null;
        Token a4=null;
        Token a5=null;
        edap.PlatformAnnotation a6_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }
            // Edap.g:8627:1: (a0= 'connector' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ')' ( ( (a6_0= parse_edap_PlatformAnnotation ) ) )* )
            // Edap.g:8628:2: a0= 'connector' a1= '(' (a2= TEXT ) a3= ',' (a4= TEXT ) a5= ')' ( ( (a6_0= parse_edap_PlatformAnnotation ) ) )*
            {
            a0=(Token)match(input,59,FOLLOW_59_in_parse_edap_Connector7834); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createConnector();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_161, 283);
              	
            }
            a1=(Token)match(input,19,FOLLOW_19_in_parse_edap_Connector7848); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createConnector();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_1, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a1, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_162, 284);
              	
            }
            // Edap.g:8658:2: (a2= TEXT )
            // Edap.g:8659:3: a2= TEXT
            {
            a2=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Connector7866); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_163, 285);
              	
            }
            a3=(Token)match(input,20,FOLLOW_20_in_parse_edap_Connector7887); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createConnector();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_3, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a3, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_164, 286);
              	
            }
            // Edap.g:8713:2: (a4= TEXT )
            // Edap.g:8714:3: a4= TEXT
            {
            a4=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Connector7905); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_165, 287);
              	
            }
            a5=(Token)match(input,21,FOLLOW_21_in_parse_edap_Connector7926); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createConnector();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_27_0_0_5, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a5, element);
              	
            }
            if ( state.backtracking==0 ) {

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
            // Edap.g:8787:2: ( ( (a6_0= parse_edap_PlatformAnnotation ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==ANNOTATION) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // Edap.g:8788:3: ( (a6_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:8788:3: ( (a6_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:8789:4: (a6_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:8789:4: (a6_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:8790:5: a6_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Connector7955);
            	    a6_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, parse_edap_Connector_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Connector"


    // $ANTLR start "parse_edap_Port"
    // Edap.g:8862:1: parse_edap_Port returns [edap.Port element = null] : a0= 'port' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* ;
    public final edap.Port parse_edap_Port() throws RecognitionException {
        edap.Port element =  null;
        int parse_edap_Port_StartIndex = input.index();
        Token a0=null;
        Token a1=null;
        edap.PlatformAnnotation a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }
            // Edap.g:8865:1: (a0= 'port' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* )
            // Edap.g:8866:2: a0= 'port' (a1= TEXT ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )*
            {
            a0=(Token)match(input,52,FOLLOW_52_in_parse_edap_Port8011); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createPort();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_28_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_166, 291);
              	
            }
            // Edap.g:8881:2: (a1= TEXT )
            // Edap.g:8882:3: a1= TEXT
            {
            a1=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_edap_Port8029); if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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
            // Edap.g:8936:2: ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==ANNOTATION) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // Edap.g:8937:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:8937:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:8938:4: (a2_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:8938:4: (a2_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:8939:5: a2_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Port8065);
            	    a2_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, parse_edap_Port_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Port"


    // $ANTLR start "parse_edap_CreateAction"
    // Edap.g:9011:1: parse_edap_CreateAction returns [edap.CreateAction element = null] : a0= 'create' (a1_0= parse_edap_ComponentReference ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* ;
    public final edap.CreateAction parse_edap_CreateAction() throws RecognitionException {
        edap.CreateAction element =  null;
        int parse_edap_CreateAction_StartIndex = input.index();
        Token a0=null;
        edap.ComponentReference a1_0 = null;

        edap.PlatformAnnotation a2_0 = null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }
            // Edap.g:9014:1: (a0= 'create' (a1_0= parse_edap_ComponentReference ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )* )
            // Edap.g:9015:2: a0= 'create' (a1_0= parse_edap_ComponentReference ) ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )*
            {
            a0=(Token)match(input,60,FOLLOW_60_in_parse_edap_CreateAction8121); if (state.failed) return element;
            if ( state.backtracking==0 ) {

              		if (element == null) {
              			element = edap.EdapFactory.eINSTANCE.createCreateAction();
              			incompleteObjects.push(element);
              			// initialize boolean attributes
              		}
              		collectHiddenTokens(element);
              		retrieveLayoutInformation(element, edap.resource.edap.grammar.EdapGrammarInformationProvider.EDAP_29_0_0_0, null);
              		copyLocalizationInfos((org.antlr.runtime3_2_0.CommonToken)a0, element);
              	
            }
            if ( state.backtracking==0 ) {

              		// expected elements (follow set)
              		addExpectedElement(edap.resource.edap.grammar.EdapFollowSetProvider.TERMINAL_129, 295, edap.resource.edap.grammar.EdapFollowSetProvider.FEATURE_25);
              	
            }
            // Edap.g:9030:2: (a1_0= parse_edap_ComponentReference )
            // Edap.g:9031:3: a1_0= parse_edap_ComponentReference
            {
            pushFollow(FOLLOW_parse_edap_ComponentReference_in_parse_edap_CreateAction8139);
            a1_0=parse_edap_ComponentReference();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {

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

            }

            if ( state.backtracking==0 ) {

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
            // Edap.g:9074:2: ( ( (a2_0= parse_edap_PlatformAnnotation ) ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==ANNOTATION) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // Edap.g:9075:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
            	    {
            	    // Edap.g:9075:3: ( (a2_0= parse_edap_PlatformAnnotation ) )
            	    // Edap.g:9076:4: (a2_0= parse_edap_PlatformAnnotation )
            	    {
            	    // Edap.g:9076:4: (a2_0= parse_edap_PlatformAnnotation )
            	    // Edap.g:9077:5: a2_0= parse_edap_PlatformAnnotation
            	    {
            	    pushFollow(FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_CreateAction8172);
            	    a2_0=parse_edap_PlatformAnnotation();

            	    state._fsp--;
            	    if (state.failed) return element;
            	    if ( state.backtracking==0 ) {

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

            	    }

            	    if ( state.backtracking==0 ) {

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

            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            if ( state.backtracking==0 ) {

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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, parse_edap_CreateAction_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_CreateAction"


    // $ANTLR start "parse_edap_Type"
    // Edap.g:9147:1: parse_edap_Type returns [edap.Type element = null] : (c0= parse_edap_Device | c1= parse_edap_SoftwareComponent | c2= parse_edap_Simulator | c3= parse_edap_PrimitiveType | c4= parse_edap_Enumeration );
    public final edap.Type parse_edap_Type() throws RecognitionException {
        edap.Type element =  null;
        int parse_edap_Type_StartIndex = input.index();
        edap.Device c0 = null;

        edap.SoftwareComponent c1 = null;

        edap.Simulator c2 = null;

        edap.PrimitiveType c3 = null;

        edap.Enumeration c4 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return element; }
            // Edap.g:9148:1: (c0= parse_edap_Device | c1= parse_edap_SoftwareComponent | c2= parse_edap_Simulator | c3= parse_edap_PrimitiveType | c4= parse_edap_Enumeration )
            int alt73=5;
            switch ( input.LA(1) ) {
            case T_ASPECT:
                {
                int LA73_1 = input.LA(2);

                if ( (synpred85_Edap()) ) {
                    alt73=1;
                }
                else if ( (synpred86_Edap()) ) {
                    alt73=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 1, input);

                    throw nvae;
                }
                }
                break;
            case T_SINGLETON:
                {
                int LA73_2 = input.LA(2);

                if ( (synpred85_Edap()) ) {
                    alt73=1;
                }
                else if ( (synpred86_Edap()) ) {
                    alt73=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 2, input);

                    throw nvae;
                }
                }
                break;
            case 23:
                {
                alt73=1;
                }
                break;
            case 28:
                {
                alt73=2;
                }
                break;
            case 29:
                {
                int LA73_5 = input.LA(2);

                if ( (synpred86_Edap()) ) {
                    alt73=2;
                }
                else if ( (synpred87_Edap()) ) {
                    alt73=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 5, input);

                    throw nvae;
                }
                }
                break;
            case 38:
                {
                alt73=4;
                }
                break;
            case 39:
                {
                alt73=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // Edap.g:9149:2: c0= parse_edap_Device
                    {
                    pushFollow(FOLLOW_parse_edap_Device_in_parse_edap_Type8224);
                    c0=parse_edap_Device();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Edap.g:9150:4: c1= parse_edap_SoftwareComponent
                    {
                    pushFollow(FOLLOW_parse_edap_SoftwareComponent_in_parse_edap_Type8234);
                    c1=parse_edap_SoftwareComponent();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Edap.g:9151:4: c2= parse_edap_Simulator
                    {
                    pushFollow(FOLLOW_parse_edap_Simulator_in_parse_edap_Type8244);
                    c2=parse_edap_Simulator();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 4 :
                    // Edap.g:9152:4: c3= parse_edap_PrimitiveType
                    {
                    pushFollow(FOLLOW_parse_edap_PrimitiveType_in_parse_edap_Type8254);
                    c3=parse_edap_PrimitiveType();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 5 :
                    // Edap.g:9153:4: c4= parse_edap_Enumeration
                    {
                    pushFollow(FOLLOW_parse_edap_Enumeration_in_parse_edap_Type8264);
                    c4=parse_edap_Enumeration();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, parse_edap_Type_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Type"


    // $ANTLR start "parse_edap_Component"
    // Edap.g:9157:1: parse_edap_Component returns [edap.Component element = null] : (c0= parse_edap_Device | c1= parse_edap_SoftwareComponent | c2= parse_edap_Simulator );
    public final edap.Component parse_edap_Component() throws RecognitionException {
        edap.Component element =  null;
        int parse_edap_Component_StartIndex = input.index();
        edap.Device c0 = null;

        edap.SoftwareComponent c1 = null;

        edap.Simulator c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return element; }
            // Edap.g:9158:1: (c0= parse_edap_Device | c1= parse_edap_SoftwareComponent | c2= parse_edap_Simulator )
            int alt74=3;
            switch ( input.LA(1) ) {
            case T_ASPECT:
                {
                int LA74_1 = input.LA(2);

                if ( (synpred89_Edap()) ) {
                    alt74=1;
                }
                else if ( (synpred90_Edap()) ) {
                    alt74=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 1, input);

                    throw nvae;
                }
                }
                break;
            case T_SINGLETON:
                {
                int LA74_2 = input.LA(2);

                if ( (synpred89_Edap()) ) {
                    alt74=1;
                }
                else if ( (synpred90_Edap()) ) {
                    alt74=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 2, input);

                    throw nvae;
                }
                }
                break;
            case 23:
                {
                alt74=1;
                }
                break;
            case 28:
                {
                alt74=2;
                }
                break;
            case 29:
                {
                int LA74_5 = input.LA(2);

                if ( (synpred90_Edap()) ) {
                    alt74=2;
                }
                else if ( (true) ) {
                    alt74=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 74, 5, input);

                    throw nvae;
                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // Edap.g:9159:2: c0= parse_edap_Device
                    {
                    pushFollow(FOLLOW_parse_edap_Device_in_parse_edap_Component8285);
                    c0=parse_edap_Device();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Edap.g:9160:4: c1= parse_edap_SoftwareComponent
                    {
                    pushFollow(FOLLOW_parse_edap_SoftwareComponent_in_parse_edap_Component8295);
                    c1=parse_edap_SoftwareComponent();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Edap.g:9161:4: c2= parse_edap_Simulator
                    {
                    pushFollow(FOLLOW_parse_edap_Simulator_in_parse_edap_Component8305);
                    c2=parse_edap_Simulator();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, parse_edap_Component_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Component"


    // $ANTLR start "parse_edap_Action"
    // Edap.g:9165:1: parse_edap_Action returns [edap.Action element = null] : (c0= parse_edap_ActionBlock | c1= parse_edap_ExternStatement | c2= parse_edap_PropertyAssignment | c3= parse_edap_Unicast | c4= parse_edap_Broadcast | c5= parse_edap_CreateAction );
    public final edap.Action parse_edap_Action() throws RecognitionException {
        edap.Action element =  null;
        int parse_edap_Action_StartIndex = input.index();
        edap.ActionBlock c0 = null;

        edap.ExternStatement c1 = null;

        edap.PropertyAssignment c2 = null;

        edap.Unicast c3 = null;

        edap.Broadcast c4 = null;

        edap.CreateAction c5 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return element; }
            // Edap.g:9166:1: (c0= parse_edap_ActionBlock | c1= parse_edap_ExternStatement | c2= parse_edap_PropertyAssignment | c3= parse_edap_Unicast | c4= parse_edap_Broadcast | c5= parse_edap_CreateAction )
            int alt75=6;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt75=1;
                }
                break;
            case STRING_EXT:
                {
                alt75=2;
                }
                break;
            case 47:
                {
                alt75=3;
                }
                break;
            case 51:
                {
                alt75=4;
                }
                break;
            case 53:
                {
                alt75=5;
                }
                break;
            case 60:
                {
                alt75=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }

            switch (alt75) {
                case 1 :
                    // Edap.g:9167:2: c0= parse_edap_ActionBlock
                    {
                    pushFollow(FOLLOW_parse_edap_ActionBlock_in_parse_edap_Action8326);
                    c0=parse_edap_ActionBlock();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Edap.g:9168:4: c1= parse_edap_ExternStatement
                    {
                    pushFollow(FOLLOW_parse_edap_ExternStatement_in_parse_edap_Action8336);
                    c1=parse_edap_ExternStatement();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Edap.g:9169:4: c2= parse_edap_PropertyAssignment
                    {
                    pushFollow(FOLLOW_parse_edap_PropertyAssignment_in_parse_edap_Action8346);
                    c2=parse_edap_PropertyAssignment();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 4 :
                    // Edap.g:9170:4: c3= parse_edap_Unicast
                    {
                    pushFollow(FOLLOW_parse_edap_Unicast_in_parse_edap_Action8356);
                    c3=parse_edap_Unicast();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c3; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 5 :
                    // Edap.g:9171:4: c4= parse_edap_Broadcast
                    {
                    pushFollow(FOLLOW_parse_edap_Broadcast_in_parse_edap_Action8366);
                    c4=parse_edap_Broadcast();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c4; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 6 :
                    // Edap.g:9172:4: c5= parse_edap_CreateAction
                    {
                    pushFollow(FOLLOW_parse_edap_CreateAction_in_parse_edap_Action8376);
                    c5=parse_edap_CreateAction();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c5; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, parse_edap_Action_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Action"


    // $ANTLR start "parse_edap_Expression"
    // Edap.g:9176:1: parse_edap_Expression returns [edap.Expression element = null] : (c0= parse_edap_ExternExpression | c1= parse_edap_ComponentReference | c2= parse_edap_EventReference );
    public final edap.Expression parse_edap_Expression() throws RecognitionException {
        edap.Expression element =  null;
        int parse_edap_Expression_StartIndex = input.index();
        edap.ExternExpression c0 = null;

        edap.ComponentReference c1 = null;

        edap.EventReference c2 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return element; }
            // Edap.g:9177:1: (c0= parse_edap_ExternExpression | c1= parse_edap_ComponentReference | c2= parse_edap_EventReference )
            int alt76=3;
            switch ( input.LA(1) ) {
            case STRING_EXT:
                {
                alt76=1;
                }
                break;
            case TEXT:
                {
                alt76=2;
                }
                break;
            case 49:
                {
                alt76=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // Edap.g:9178:2: c0= parse_edap_ExternExpression
                    {
                    pushFollow(FOLLOW_parse_edap_ExternExpression_in_parse_edap_Expression8397);
                    c0=parse_edap_ExternExpression();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c0; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 2 :
                    // Edap.g:9179:4: c1= parse_edap_ComponentReference
                    {
                    pushFollow(FOLLOW_parse_edap_ComponentReference_in_parse_edap_Expression8407);
                    c1=parse_edap_ComponentReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c1; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;
                case 3 :
                    // Edap.g:9180:4: c2= parse_edap_EventReference
                    {
                    pushFollow(FOLLOW_parse_edap_EventReference_in_parse_edap_Expression8417);
                    c2=parse_edap_EventReference();

                    state._fsp--;
                    if (state.failed) return element;
                    if ( state.backtracking==0 ) {
                       element = c2; /* this is a subclass or primitive expression choice */ 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, parse_edap_Expression_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Expression"


    // $ANTLR start "parse_edap_Event"
    // Edap.g:9184:1: parse_edap_Event returns [edap.Event element = null] : c0= parse_edap_ReceiveMessage ;
    public final edap.Event parse_edap_Event() throws RecognitionException {
        edap.Event element =  null;
        int parse_edap_Event_StartIndex = input.index();
        edap.ReceiveMessage c0 = null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return element; }
            // Edap.g:9185:1: (c0= parse_edap_ReceiveMessage )
            // Edap.g:9186:2: c0= parse_edap_ReceiveMessage
            {
            pushFollow(FOLLOW_parse_edap_ReceiveMessage_in_parse_edap_Event8438);
            c0=parse_edap_ReceiveMessage();

            state._fsp--;
            if (state.failed) return element;
            if ( state.backtracking==0 ) {
               element = c0; /* this is a subclass or primitive expression choice */ 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, parse_edap_Event_StartIndex); }
        }
        return element;
    }
    // $ANTLR end "parse_edap_Event"

    // $ANTLR start synpred61_Edap
    public final void synpred61_Edap_fragment() throws RecognitionException {   
        edap.StateMachine c0 = null;


        // Edap.g:6130:2: (c0= parse_edap_StateMachine )
        // Edap.g:6130:2: c0= parse_edap_StateMachine
        {
        pushFollow(FOLLOW_parse_edap_StateMachine_in_synpred61_Edap5409);
        c0=parse_edap_StateMachine();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_Edap

    // $ANTLR start synpred85_Edap
    public final void synpred85_Edap_fragment() throws RecognitionException {   
        edap.Device c0 = null;


        // Edap.g:9149:2: (c0= parse_edap_Device )
        // Edap.g:9149:2: c0= parse_edap_Device
        {
        pushFollow(FOLLOW_parse_edap_Device_in_synpred85_Edap8224);
        c0=parse_edap_Device();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred85_Edap

    // $ANTLR start synpred86_Edap
    public final void synpred86_Edap_fragment() throws RecognitionException {   
        edap.SoftwareComponent c1 = null;


        // Edap.g:9150:4: (c1= parse_edap_SoftwareComponent )
        // Edap.g:9150:4: c1= parse_edap_SoftwareComponent
        {
        pushFollow(FOLLOW_parse_edap_SoftwareComponent_in_synpred86_Edap8234);
        c1=parse_edap_SoftwareComponent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_Edap

    // $ANTLR start synpred87_Edap
    public final void synpred87_Edap_fragment() throws RecognitionException {   
        edap.Simulator c2 = null;


        // Edap.g:9151:4: (c2= parse_edap_Simulator )
        // Edap.g:9151:4: c2= parse_edap_Simulator
        {
        pushFollow(FOLLOW_parse_edap_Simulator_in_synpred87_Edap8244);
        c2=parse_edap_Simulator();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred87_Edap

    // $ANTLR start synpred89_Edap
    public final void synpred89_Edap_fragment() throws RecognitionException {   
        edap.Device c0 = null;


        // Edap.g:9159:2: (c0= parse_edap_Device )
        // Edap.g:9159:2: c0= parse_edap_Device
        {
        pushFollow(FOLLOW_parse_edap_Device_in_synpred89_Edap8285);
        c0=parse_edap_Device();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred89_Edap

    // $ANTLR start synpred90_Edap
    public final void synpred90_Edap_fragment() throws RecognitionException {   
        edap.SoftwareComponent c1 = null;


        // Edap.g:9160:4: (c1= parse_edap_SoftwareComponent )
        // Edap.g:9160:4: c1= parse_edap_SoftwareComponent
        {
        pushFollow(FOLLOW_parse_edap_SoftwareComponent_in_synpred90_Edap8295);
        c1=parse_edap_SoftwareComponent();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_Edap

    // Delegated rules

    public final boolean synpred87_Edap() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_Edap_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_Edap() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_Edap_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_Edap() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_Edap_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_Edap() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_Edap_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_Edap() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_Edap_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_Edap() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_Edap_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_edap_EdapModel_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_parse_edap_EdapModel121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_parse_edap_EdapModel147 = new BitSet(new long[]{0x000000C030820182L});
    public static final BitSet FOLLOW_parse_edap_Type_in_parse_edap_EdapModel215 = new BitSet(new long[]{0x000000C030800182L});
    public static final BitSet FOLLOW_T_MULTICAST_in_parse_edap_Message304 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_parse_edap_Message350 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Message368 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_edap_Message389 = new BitSet(new long[]{0x0000000000200040L});
    public static final BitSet FOLLOW_parse_edap_Parameter_in_parse_edap_Message418 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_parse_edap_Message459 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_edap_Parameter_in_parse_edap_Message493 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_parse_edap_Message567 = new BitSet(new long[]{0x0000000000400800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Message596 = new BitSet(new long[]{0x0000000000400800L});
    public static final BitSet FOLLOW_22_in_parse_edap_Message637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_ASPECT_in_parse_edap_Device681 = new BitSet(new long[]{0x0000000000800100L});
    public static final BitSet FOLLOW_T_SINGLETON_in_parse_edap_Device742 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_parse_edap_Device788 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Device806 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Device842 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_24_in_parse_edap_Device883 = new BitSet(new long[]{0x00000010BE8403A0L});
    public static final BitSet FOLLOW_parse_edap_Message_in_parse_edap_Device912 = new BitSet(new long[]{0x00000010BE8403A0L});
    public static final BitSet FOLLOW_parse_edap_Property_in_parse_edap_Device954 = new BitSet(new long[]{0x00000010BE8403A0L});
    public static final BitSet FOLLOW_25_in_parse_edap_Device990 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Device1016 = new BitSet(new long[]{0x00000010BE9403A0L});
    public static final BitSet FOLLOW_20_in_parse_edap_Device1062 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Device1096 = new BitSet(new long[]{0x00000010BE9403A0L});
    public static final BitSet FOLLOW_26_in_parse_edap_Device1172 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Device1198 = new BitSet(new long[]{0x00000010BE9403A0L});
    public static final BitSet FOLLOW_20_in_parse_edap_Device1244 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Device1278 = new BitSet(new long[]{0x00000010BE9403A0L});
    public static final BitSet FOLLOW_parse_edap_Component_in_parse_edap_Device1367 = new BitSet(new long[]{0x00000010BE8403A0L});
    public static final BitSet FOLLOW_27_in_parse_edap_Device1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_ASPECT_in_parse_edap_SoftwareComponent1470 = new BitSet(new long[]{0x0000000010000100L});
    public static final BitSet FOLLOW_T_SINGLETON_in_parse_edap_SoftwareComponent1531 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_parse_edap_SoftwareComponent1577 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_SoftwareComponent1595 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_SoftwareComponent1631 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_24_in_parse_edap_SoftwareComponent1672 = new BitSet(new long[]{0x08100110BE8403A0L});
    public static final BitSet FOLLOW_parse_edap_Port_in_parse_edap_SoftwareComponent1701 = new BitSet(new long[]{0x08100110BE8403A0L});
    public static final BitSet FOLLOW_parse_edap_Connector_in_parse_edap_SoftwareComponent1743 = new BitSet(new long[]{0x08100110BE8403A0L});
    public static final BitSet FOLLOW_parse_edap_Message_in_parse_edap_SoftwareComponent1785 = new BitSet(new long[]{0x08100110BE8403A0L});
    public static final BitSet FOLLOW_parse_edap_Property_in_parse_edap_SoftwareComponent1827 = new BitSet(new long[]{0x08100110BE8403A0L});
    public static final BitSet FOLLOW_25_in_parse_edap_SoftwareComponent1863 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_SoftwareComponent1889 = new BitSet(new long[]{0x08100110BE9403A0L});
    public static final BitSet FOLLOW_20_in_parse_edap_SoftwareComponent1935 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_SoftwareComponent1969 = new BitSet(new long[]{0x08100110BE9403A0L});
    public static final BitSet FOLLOW_26_in_parse_edap_SoftwareComponent2045 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_SoftwareComponent2071 = new BitSet(new long[]{0x08100110BE9403A0L});
    public static final BitSet FOLLOW_20_in_parse_edap_SoftwareComponent2117 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_SoftwareComponent2151 = new BitSet(new long[]{0x08100110BE9403A0L});
    public static final BitSet FOLLOW_parse_edap_Component_in_parse_edap_SoftwareComponent2240 = new BitSet(new long[]{0x08100110BE8403A0L});
    public static final BitSet FOLLOW_parse_edap_StateMachine_in_parse_edap_SoftwareComponent2314 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_edap_SoftwareComponent2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Simulator_in_parse_edap_SoftwareComponent2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_parse_edap_Simulator2399 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Simulator2417 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_parse_edap_Simulator2438 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Simulator2456 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Simulator2492 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_24_in_parse_edap_Simulator2533 = new BitSet(new long[]{0x00000110B68403A0L});
    public static final BitSet FOLLOW_parse_edap_Message_in_parse_edap_Simulator2562 = new BitSet(new long[]{0x00000110B68403A0L});
    public static final BitSet FOLLOW_parse_edap_Property_in_parse_edap_Simulator2604 = new BitSet(new long[]{0x00000110B68403A0L});
    public static final BitSet FOLLOW_25_in_parse_edap_Simulator2640 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Simulator2666 = new BitSet(new long[]{0x00000110B69403A0L});
    public static final BitSet FOLLOW_20_in_parse_edap_Simulator2712 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Simulator2746 = new BitSet(new long[]{0x00000110B69403A0L});
    public static final BitSet FOLLOW_26_in_parse_edap_Simulator2822 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Simulator2848 = new BitSet(new long[]{0x00000110B69403A0L});
    public static final BitSet FOLLOW_20_in_parse_edap_Simulator2894 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Simulator2928 = new BitSet(new long[]{0x00000110B69403A0L});
    public static final BitSet FOLLOW_parse_edap_Component_in_parse_edap_Simulator3017 = new BitSet(new long[]{0x00000110B68403A0L});
    public static final BitSet FOLLOW_parse_edap_StateMachine_in_parse_edap_Simulator3085 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_edap_Simulator3115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_READONLY_in_parse_edap_Property3159 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_parse_edap_Property3205 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Property3223 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_edap_Property3244 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Property3262 = new BitSet(new long[]{0x0000000200000802L});
    public static final BitSet FOLLOW_33_in_parse_edap_Property3292 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MULTIPLICITY_in_parse_edap_Property3318 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_parse_edap_Property3351 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MULTIPLICITY_in_parse_edap_Property3377 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edap_Property3410 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Property3458 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_edap_Dictionary_in_parse_edap_Property3504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_READONLY_in_parse_edap_Dictionary3544 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_parse_edap_Dictionary3590 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Dictionary3608 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_edap_Dictionary3629 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Dictionary3647 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_edap_Dictionary3668 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Dictionary3686 = new BitSet(new long[]{0x0000000200000802L});
    public static final BitSet FOLLOW_33_in_parse_edap_Dictionary3716 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MULTIPLICITY_in_parse_edap_Dictionary3742 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_parse_edap_Dictionary3775 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_MULTIPLICITY_in_parse_edap_Dictionary3801 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edap_Dictionary3834 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Dictionary3882 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Parameter3942 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_parse_edap_Parameter3963 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Parameter3981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_parse_edap_PrimitiveType4017 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_PrimitiveType4035 = new BitSet(new long[]{0x0000000000400800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_PrimitiveType4071 = new BitSet(new long[]{0x0000000000400800L});
    public static final BitSet FOLLOW_22_in_parse_edap_PrimitiveType4112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_parse_edap_Enumeration4141 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Enumeration4159 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Enumeration4195 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_24_in_parse_edap_Enumeration4236 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_parse_edap_EnumerationLiteral_in_parse_edap_Enumeration4265 = new BitSet(new long[]{0x0000000008000040L});
    public static final BitSet FOLLOW_27_in_parse_edap_Enumeration4306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_EnumerationLiteral4339 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_EnumerationLiteral4375 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ANNOTATION_in_parse_edap_PlatformAnnotation4435 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_parse_edap_PlatformAnnotation4460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_parse_edap_StateMachine4496 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_StateMachine4514 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_edap_StateMachine4535 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_StateMachine4553 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_StateMachine4589 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_24_in_parse_edap_StateMachine4630 = new BitSet(new long[]{0x0000651088000200L});
    public static final BitSet FOLLOW_parse_edap_Property_in_parse_edap_StateMachine4659 = new BitSet(new long[]{0x0000651088000200L});
    public static final BitSet FOLLOW_42_in_parse_edap_StateMachine4709 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_parse_edap_StateMachine4729 = new BitSet(new long[]{0x1028800001001000L});
    public static final BitSet FOLLOW_parse_edap_Action_in_parse_edap_StateMachine4755 = new BitSet(new long[]{0x0000650008000000L});
    public static final BitSet FOLLOW_42_in_parse_edap_StateMachine4805 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_edap_StateMachine4825 = new BitSet(new long[]{0x1028800001001000L});
    public static final BitSet FOLLOW_parse_edap_Action_in_parse_edap_StateMachine4851 = new BitSet(new long[]{0x0000610008000000L});
    public static final BitSet FOLLOW_parse_edap_State_in_parse_edap_StateMachine4907 = new BitSet(new long[]{0x0000610008000000L});
    public static final BitSet FOLLOW_27_in_parse_edap_StateMachine4948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_parse_edap_State4977 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_State4995 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_State5031 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_24_in_parse_edap_State5072 = new BitSet(new long[]{0x0040041088000200L});
    public static final BitSet FOLLOW_parse_edap_Property_in_parse_edap_State5101 = new BitSet(new long[]{0x0040041088000200L});
    public static final BitSet FOLLOW_42_in_parse_edap_State5151 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_parse_edap_State5171 = new BitSet(new long[]{0x1028800001001000L});
    public static final BitSet FOLLOW_parse_edap_Action_in_parse_edap_State5197 = new BitSet(new long[]{0x0040040008000000L});
    public static final BitSet FOLLOW_42_in_parse_edap_State5247 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_edap_State5267 = new BitSet(new long[]{0x1028800001001000L});
    public static final BitSet FOLLOW_parse_edap_Action_in_parse_edap_State5293 = new BitSet(new long[]{0x0040000008000000L});
    public static final BitSet FOLLOW_parse_edap_Transition_in_parse_edap_State5349 = new BitSet(new long[]{0x0040000008000000L});
    public static final BitSet FOLLOW_27_in_parse_edap_State5390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_StateMachine_in_parse_edap_State5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_CompositeState_in_parse_edap_State5419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_parse_edap_CompositeState5444 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_parse_edap_CompositeState5458 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_CompositeState5476 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_parse_edap_CompositeState5497 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_CompositeState5515 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_CompositeState5551 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_24_in_parse_edap_CompositeState5592 = new BitSet(new long[]{0x0040651088000200L});
    public static final BitSet FOLLOW_parse_edap_Property_in_parse_edap_CompositeState5621 = new BitSet(new long[]{0x0040651088000200L});
    public static final BitSet FOLLOW_42_in_parse_edap_CompositeState5671 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_parse_edap_CompositeState5691 = new BitSet(new long[]{0x1028800001001000L});
    public static final BitSet FOLLOW_parse_edap_Action_in_parse_edap_CompositeState5717 = new BitSet(new long[]{0x0040650008000000L});
    public static final BitSet FOLLOW_42_in_parse_edap_CompositeState5767 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_parse_edap_CompositeState5787 = new BitSet(new long[]{0x1028800001001000L});
    public static final BitSet FOLLOW_parse_edap_Action_in_parse_edap_CompositeState5813 = new BitSet(new long[]{0x0040610008000000L});
    public static final BitSet FOLLOW_parse_edap_Transition_in_parse_edap_CompositeState5869 = new BitSet(new long[]{0x0040610008000000L});
    public static final BitSet FOLLOW_parse_edap_State_in_parse_edap_CompositeState5918 = new BitSet(new long[]{0x0040610008000000L});
    public static final BitSet FOLLOW_27_in_parse_edap_CompositeState5977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_StateMachine_in_parse_edap_CompositeState5996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_parse_edap_ActionBlock6021 = new BitSet(new long[]{0x1028800009001000L});
    public static final BitSet FOLLOW_parse_edap_Action_in_parse_edap_ActionBlock6050 = new BitSet(new long[]{0x1028800009001000L});
    public static final BitSet FOLLOW_27_in_parse_edap_ActionBlock6091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_EXT_in_parse_edap_ExternStatement6124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_parse_edap_PropertyAssignment6160 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_PropertyAssignment6178 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_parse_edap_PropertyAssignment6199 = new BitSet(new long[]{0x0002000000001040L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_PropertyAssignment6217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_EXT_in_parse_edap_ExternExpression6254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_ComponentReference6294 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_parse_edap_PropertyNavigation_in_parse_edap_ComponentReference6330 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_49_in_parse_edap_EventReference6386 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_EventReference6404 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_parse_edap_EventReference6425 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_EventReference6443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_parse_edap_PropertyNavigation6479 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_PropertyNavigation6497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_DictionaryNavigation_in_parse_edap_PropertyNavigation6523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_parse_edap_DictionaryNavigation6548 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_DictionaryNavigation6566 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_parse_edap_DictionaryNavigation6587 = new BitSet(new long[]{0x0002000000001040L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_DictionaryNavigation6605 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parse_edap_DictionaryNavigation6623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_parse_edap_Unicast6652 = new BitSet(new long[]{0x0002000000001040L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_Unicast6670 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_parse_edap_Unicast6688 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Unicast6706 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_edap_Unicast6727 = new BitSet(new long[]{0x0002000000201040L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_Unicast6756 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_parse_edap_Unicast6797 = new BitSet(new long[]{0x0002000000001040L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_Unicast6831 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_parse_edap_Unicast6905 = new BitSet(new long[]{0x0010000000000802L});
    public static final BitSet FOLLOW_52_in_parse_edap_Unicast6928 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Unicast6954 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Unicast7015 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_53_in_parse_edap_Broadcast7071 = new BitSet(new long[]{0x0002000000001040L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_Broadcast7089 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_parse_edap_Broadcast7107 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Broadcast7125 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_edap_Broadcast7146 = new BitSet(new long[]{0x0002000000201040L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_Broadcast7175 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_20_in_parse_edap_Broadcast7216 = new BitSet(new long[]{0x0002000000001040L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_Broadcast7250 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_21_in_parse_edap_Broadcast7324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_parse_edap_Transition7353 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Transition7371 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_parse_edap_Transition7392 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Transition7410 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Transition7446 = new BitSet(new long[]{0x0000000001000800L});
    public static final BitSet FOLLOW_24_in_parse_edap_Transition7487 = new BitSet(new long[]{0x0380000008000000L});
    public static final BitSet FOLLOW_55_in_parse_edap_Transition7510 = new BitSet(new long[]{0x0002000000001040L});
    public static final BitSet FOLLOW_parse_edap_Event_in_parse_edap_Transition7536 = new BitSet(new long[]{0x0380000008000000L});
    public static final BitSet FOLLOW_56_in_parse_edap_Transition7586 = new BitSet(new long[]{0x0002000000001040L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_Transition7612 = new BitSet(new long[]{0x0200000008000000L});
    public static final BitSet FOLLOW_57_in_parse_edap_Transition7662 = new BitSet(new long[]{0x1028800001001000L});
    public static final BitSet FOLLOW_parse_edap_Action_in_parse_edap_Transition7688 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_parse_edap_Transition7729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Expression_in_parse_edap_ReceiveMessage7762 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_parse_edap_ReceiveMessage7780 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_ReceiveMessage7798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_parse_edap_Connector7834 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_parse_edap_Connector7848 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Connector7866 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_parse_edap_Connector7887 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Connector7905 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_parse_edap_Connector7926 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Connector7955 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_52_in_parse_edap_Port8011 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_TEXT_in_parse_edap_Port8029 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_Port8065 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_60_in_parse_edap_CreateAction8121 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_parse_edap_ComponentReference_in_parse_edap_CreateAction8139 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_edap_PlatformAnnotation_in_parse_edap_CreateAction8172 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_edap_Device_in_parse_edap_Type8224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_SoftwareComponent_in_parse_edap_Type8234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Simulator_in_parse_edap_Type8244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_PrimitiveType_in_parse_edap_Type8254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Enumeration_in_parse_edap_Type8264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Device_in_parse_edap_Component8285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_SoftwareComponent_in_parse_edap_Component8295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Simulator_in_parse_edap_Component8305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_ActionBlock_in_parse_edap_Action8326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_ExternStatement_in_parse_edap_Action8336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_PropertyAssignment_in_parse_edap_Action8346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Unicast_in_parse_edap_Action8356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Broadcast_in_parse_edap_Action8366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_CreateAction_in_parse_edap_Action8376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_ExternExpression_in_parse_edap_Expression8397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_ComponentReference_in_parse_edap_Expression8407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_EventReference_in_parse_edap_Expression8417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_ReceiveMessage_in_parse_edap_Event8438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_StateMachine_in_synpred61_Edap5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Device_in_synpred85_Edap8224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_SoftwareComponent_in_synpred86_Edap8234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Simulator_in_synpred87_Edap8244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_Device_in_synpred89_Edap8285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_edap_SoftwareComponent_in_synpred90_Edap8295 = new BitSet(new long[]{0x0000000000000002L});

}