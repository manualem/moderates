// $ANTLR ${project.version} ${buildNumber}

	package edap.resource.edap.mopp;


import org.antlr.runtime3_2_0.*;

public class EdapLexer extends Lexer {
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int ANNOTATION=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__60=60;
    public static final int LINEBREAKS=16;
    public static final int EOF=-1;
    public static final int T_MULTICAST=5;
    public static final int T_READONLY=9;
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

    	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators

    public EdapLexer() {;} 
    public EdapLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public EdapLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "Edap.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:16:7: ( 'import' )
            // Edap.g:16:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:17:7: ( 'message' )
            // Edap.g:17:9: 'message'
            {
            match("message"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:18:7: ( '(' )
            // Edap.g:18:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:19:7: ( ',' )
            // Edap.g:19:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:20:7: ( ')' )
            // Edap.g:20:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:21:7: ( ';' )
            // Edap.g:21:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:22:7: ( 'device' )
            // Edap.g:22:9: 'device'
            {
            match("device"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:23:7: ( '{' )
            // Edap.g:23:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:24:7: ( 'receives' )
            // Edap.g:24:9: 'receives'
            {
            match("receives"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:25:7: ( 'sends' )
            // Edap.g:25:9: 'sends'
            {
            match("sends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:26:7: ( '}' )
            // Edap.g:26:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:27:7: ( 'component' )
            // Edap.g:27:9: 'component'
            {
            match("component"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:28:7: ( 'simulator' )
            // Edap.g:28:9: 'simulator'
            {
            match("simulator"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:29:7: ( 'for' )
            // Edap.g:29:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:30:7: ( 'property' )
            // Edap.g:30:9: 'property'
            {
            match("property"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:31:7: ( ':' )
            // Edap.g:31:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:32:7: ( '[' )
            // Edap.g:32:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:33:7: ( '..' )
            // Edap.g:33:9: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:34:7: ( ']' )
            // Edap.g:34:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:35:7: ( 'dictionary' )
            // Edap.g:35:9: 'dictionary'
            {
            match("dictionary"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:36:7: ( '->' )
            // Edap.g:36:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:37:7: ( 'datatype' )
            // Edap.g:37:9: 'datatype'
            {
            match("datatype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:38:7: ( 'enumeration' )
            // Edap.g:38:9: 'enumeration'
            {
            match("enumeration"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:39:7: ( 'statechart' )
            // Edap.g:39:9: 'statechart'
            {
            match("statechart"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:40:7: ( 'init' )
            // Edap.g:40:9: 'init'
            {
            match("init"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:41:7: ( 'on' )
            // Edap.g:41:9: 'on'
            {
            match("on"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:42:7: ( 'entry' )
            // Edap.g:42:9: 'entry'
            {
            match("entry"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:43:7: ( 'exit' )
            // Edap.g:43:9: 'exit'
            {
            match("exit"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:44:7: ( 'state' )
            // Edap.g:44:9: 'state'
            {
            match("state"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:45:7: ( 'composite' )
            // Edap.g:45:9: 'composite'
            {
            match("composite"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:46:7: ( 'set' )
            // Edap.g:46:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:47:7: ( '=' )
            // Edap.g:47:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:48:7: ( 'eventref' )
            // Edap.g:48:9: 'eventref'
            {
            match("eventref"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:49:7: ( '.' )
            // Edap.g:49:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:50:7: ( 'send' )
            // Edap.g:50:9: 'send'
            {
            match("send"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:51:7: ( 'port' )
            // Edap.g:51:9: 'port'
            {
            match("port"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:52:7: ( 'broadcast' )
            // Edap.g:52:9: 'broadcast'
            {
            match("broadcast"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:53:7: ( 'transition' )
            // Edap.g:53:9: 'transition'
            {
            match("transition"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:54:7: ( 'event' )
            // Edap.g:54:9: 'event'
            {
            match("event"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:55:7: ( 'guard' )
            // Edap.g:55:9: 'guard'
            {
            match("guard"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:56:7: ( 'action' )
            // Edap.g:56:9: 'action'
            {
            match("action"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:57:7: ( '#' )
            // Edap.g:57:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:58:7: ( 'connector' )
            // Edap.g:58:9: 'connector'
            {
            match("connector"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:59:7: ( 'create' )
            // Edap.g:59:9: 'create'
            {
            match("create"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9190:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Edap.g:9191:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Edap.g:9191:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Edap.g:9191:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 

            // Edap.g:9191:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Edap.g:9191:8: ~ ( '\\n' | '\\r' | '\\uffff' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9194:11: ( ( '/*' ( . )* '*/' ) )
            // Edap.g:9195:2: ( '/*' ( . )* '*/' )
            {
            // Edap.g:9195:2: ( '/*' ( . )* '*/' )
            // Edap.g:9195:3: '/*' ( . )* '*/'
            {
            match("/*"); 

            // Edap.g:9195:7: ( . )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='*') ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1=='/') ) {
                        alt2=2;
                    }
                    else if ( ((LA2_1>='\u0000' && LA2_1<='.')||(LA2_1>='0' && LA2_1<='\uFFFF')) ) {
                        alt2=1;
                    }


                }
                else if ( ((LA2_0>='\u0000' && LA2_0<=')')||(LA2_0>='+' && LA2_0<='\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Edap.g:9195:7: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            match("*/"); 


            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "ANNOTATION"
    public final void mANNOTATION() throws RecognitionException {
        try {
            int _type = ANNOTATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9198:11: ( ( '@' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Edap.g:9199:2: ( '@' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Edap.g:9199:2: ( '@' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Edap.g:9199:3: '@' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            match('@'); 
            // Edap.g:9199:6: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='-'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Edap.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANNOTATION"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9201:15: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"' ) )
            // Edap.g:9202:2: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"' )
            {
            // Edap.g:9202:2: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"' )
            // Edap.g:9202:3: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // Edap.g:9202:6: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )*
            loop4:
            do {
                int alt4=5;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    switch ( input.LA(2) ) {
                    case '\"':
                    case '\'':
                    case '\\':
                    case 'b':
                    case 'f':
                    case 'n':
                    case 'r':
                    case 't':
                        {
                        alt4=1;
                        }
                        break;
                    case 'u':
                        {
                        alt4=2;
                        }
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                        {
                        alt4=3;
                        }
                        break;

                    }

                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                    alt4=4;
                }


                switch (alt4) {
            	case 1 :
            	    // Edap.g:9202:7: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // Edap.g:9202:48: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    {
            	    // Edap.g:9202:48: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    // Edap.g:9202:49: '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            	    {
            	    match('\\'); 
            	    match('u'); 
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }


            	    }
            	    break;
            	case 3 :
            	    // Edap.g:9202:170: '\\\\' ( '0' .. '7' )
            	    {
            	    match('\\'); 
            	    // Edap.g:9202:174: ( '0' .. '7' )
            	    // Edap.g:9202:175: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }


            	    }
            	    break;
            	case 4 :
            	    // Edap.g:9202:185: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\"'); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "STRING_EXT"
    public final void mSTRING_EXT() throws RecognitionException {
        try {
            int _type = STRING_EXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9204:11: ( ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' ) )
            // Edap.g:9205:2: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            {
            // Edap.g:9205:2: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\\'' ) )* '\\'' )
            // Edap.g:9205:3: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\\'' ) )* '\\''
            {
            match('\''); 
            // Edap.g:9205:7: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\\'' ) )*
            loop5:
            do {
                int alt5=5;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    switch ( input.LA(2) ) {
                    case '\"':
                    case '\'':
                    case '\\':
                    case 'b':
                    case 'f':
                    case 'n':
                    case 'r':
                    case 't':
                        {
                        alt5=1;
                        }
                        break;
                    case 'u':
                        {
                        alt5=2;
                        }
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                        {
                        alt5=3;
                        }
                        break;

                    }

                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=4;
                }


                switch (alt5) {
            	case 1 :
            	    // Edap.g:9205:8: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // Edap.g:9205:49: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    {
            	    // Edap.g:9205:49: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    // Edap.g:9205:50: '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
            	    {
            	    match('\\'); 
            	    match('u'); 
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }


            	    }
            	    break;
            	case 3 :
            	    // Edap.g:9205:171: '\\\\' ( '0' .. '7' )
            	    {
            	    match('\\'); 
            	    // Edap.g:9205:175: ( '0' .. '7' )
            	    // Edap.g:9205:176: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }


            	    }
            	    break;
            	case 4 :
            	    // Edap.g:9205:186: ~ ( '\\\\' | '\\'' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('\''); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_EXT"

    // $ANTLR start "T_MULTICAST"
    public final void mT_MULTICAST() throws RecognitionException {
        try {
            int _type = T_MULTICAST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9207:12: ( ( 'multicast' ) )
            // Edap.g:9208:2: ( 'multicast' )
            {
            // Edap.g:9208:2: ( 'multicast' )
            // Edap.g:9208:3: 'multicast'
            {
            match("multicast"); 


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T_MULTICAST"

    // $ANTLR start "T_READONLY"
    public final void mT_READONLY() throws RecognitionException {
        try {
            int _type = T_READONLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9210:11: ( ( 'readonly' ) )
            // Edap.g:9211:2: ( 'readonly' )
            {
            // Edap.g:9211:2: ( 'readonly' )
            // Edap.g:9211:3: 'readonly'
            {
            match("readonly"); 


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T_READONLY"

    // $ANTLR start "T_ASPECT"
    public final void mT_ASPECT() throws RecognitionException {
        try {
            int _type = T_ASPECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9213:9: ( ( 'aspect' ) )
            // Edap.g:9214:2: ( 'aspect' )
            {
            // Edap.g:9214:2: ( 'aspect' )
            // Edap.g:9214:3: 'aspect'
            {
            match("aspect"); 


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T_ASPECT"

    // $ANTLR start "T_SINGLETON"
    public final void mT_SINGLETON() throws RecognitionException {
        try {
            int _type = T_SINGLETON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9216:12: ( ( 'singleton' ) )
            // Edap.g:9217:2: ( 'singleton' )
            {
            // Edap.g:9217:2: ( 'singleton' )
            // Edap.g:9217:3: 'singleton'
            {
            match("singleton"); 


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T_SINGLETON"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9219:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Edap.g:9220:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            // Edap.g:9220:2: ( ( ' ' | '\\t' | '\\f' ) )
            // Edap.g:9220:3: ( ' ' | '\\t' | '\\f' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAKS"
    public final void mLINEBREAKS() throws RecognitionException {
        try {
            int _type = LINEBREAKS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9223:11: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Edap.g:9224:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Edap.g:9224:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Edap.g:9224:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Edap.g:9224:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='\n') ) {
                    alt6=1;
                }
                else {
                    alt6=2;}
            }
            else if ( (LA6_0=='\n') ) {
                alt6=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // Edap.g:9224:4: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // Edap.g:9224:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Edap.g:9224:16: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }

             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINEBREAKS"

    // $ANTLR start "MULTIPLICITY"
    public final void mMULTIPLICITY() throws RecognitionException {
        try {
            int _type = MULTIPLICITY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9227:13: ( ( ( ( '*' ) | ( ( '0' .. '9' )+ ) ) ) )
            // Edap.g:9228:2: ( ( ( '*' ) | ( ( '0' .. '9' )+ ) ) )
            {
            // Edap.g:9228:2: ( ( ( '*' ) | ( ( '0' .. '9' )+ ) ) )
            // Edap.g:9228:3: ( ( '*' ) | ( ( '0' .. '9' )+ ) )
            {
            // Edap.g:9228:3: ( ( '*' ) | ( ( '0' .. '9' )+ ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='*') ) {
                alt8=1;
            }
            else if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // Edap.g:9228:5: ( '*' )
                    {
                    // Edap.g:9228:5: ( '*' )
                    // Edap.g:9228:6: '*'
                    {
                    match('*'); 

                    }


                    }
                    break;
                case 2 :
                    // Edap.g:9228:13: ( ( '0' .. '9' )+ )
                    {
                    // Edap.g:9228:13: ( ( '0' .. '9' )+ )
                    // Edap.g:9228:14: ( '0' .. '9' )+
                    {
                    // Edap.g:9228:14: ( '0' .. '9' )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // Edap.g:9228:15: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTIPLICITY"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Edap.g:9230:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )* ) )
            // Edap.g:9231:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )* )
            {
            // Edap.g:9231:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )* )
            // Edap.g:9231:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )*
            {
            // Edap.g:9231:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Edap.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            // Edap.g:9231:44: ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==':') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Edap.g:9231:45: ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
            	    {
            	    match(':'); 
            	    match(':'); 
            	    // Edap.g:9231:53: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // Edap.g:
            	    	    {
            	    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	    	        input.consume();

            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        recover(mse);
            	    	        throw mse;}


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT"

    public void mTokens() throws RecognitionException {
        // Edap.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | SL_COMMENT | ML_COMMENT | ANNOTATION | STRING_LITERAL | STRING_EXT | T_MULTICAST | T_READONLY | T_ASPECT | T_SINGLETON | WHITESPACE | LINEBREAKS | MULTIPLICITY | TEXT )
        int alt12=57;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // Edap.g:1:10: T__17
                {
                mT__17(); 

                }
                break;
            case 2 :
                // Edap.g:1:16: T__18
                {
                mT__18(); 

                }
                break;
            case 3 :
                // Edap.g:1:22: T__19
                {
                mT__19(); 

                }
                break;
            case 4 :
                // Edap.g:1:28: T__20
                {
                mT__20(); 

                }
                break;
            case 5 :
                // Edap.g:1:34: T__21
                {
                mT__21(); 

                }
                break;
            case 6 :
                // Edap.g:1:40: T__22
                {
                mT__22(); 

                }
                break;
            case 7 :
                // Edap.g:1:46: T__23
                {
                mT__23(); 

                }
                break;
            case 8 :
                // Edap.g:1:52: T__24
                {
                mT__24(); 

                }
                break;
            case 9 :
                // Edap.g:1:58: T__25
                {
                mT__25(); 

                }
                break;
            case 10 :
                // Edap.g:1:64: T__26
                {
                mT__26(); 

                }
                break;
            case 11 :
                // Edap.g:1:70: T__27
                {
                mT__27(); 

                }
                break;
            case 12 :
                // Edap.g:1:76: T__28
                {
                mT__28(); 

                }
                break;
            case 13 :
                // Edap.g:1:82: T__29
                {
                mT__29(); 

                }
                break;
            case 14 :
                // Edap.g:1:88: T__30
                {
                mT__30(); 

                }
                break;
            case 15 :
                // Edap.g:1:94: T__31
                {
                mT__31(); 

                }
                break;
            case 16 :
                // Edap.g:1:100: T__32
                {
                mT__32(); 

                }
                break;
            case 17 :
                // Edap.g:1:106: T__33
                {
                mT__33(); 

                }
                break;
            case 18 :
                // Edap.g:1:112: T__34
                {
                mT__34(); 

                }
                break;
            case 19 :
                // Edap.g:1:118: T__35
                {
                mT__35(); 

                }
                break;
            case 20 :
                // Edap.g:1:124: T__36
                {
                mT__36(); 

                }
                break;
            case 21 :
                // Edap.g:1:130: T__37
                {
                mT__37(); 

                }
                break;
            case 22 :
                // Edap.g:1:136: T__38
                {
                mT__38(); 

                }
                break;
            case 23 :
                // Edap.g:1:142: T__39
                {
                mT__39(); 

                }
                break;
            case 24 :
                // Edap.g:1:148: T__40
                {
                mT__40(); 

                }
                break;
            case 25 :
                // Edap.g:1:154: T__41
                {
                mT__41(); 

                }
                break;
            case 26 :
                // Edap.g:1:160: T__42
                {
                mT__42(); 

                }
                break;
            case 27 :
                // Edap.g:1:166: T__43
                {
                mT__43(); 

                }
                break;
            case 28 :
                // Edap.g:1:172: T__44
                {
                mT__44(); 

                }
                break;
            case 29 :
                // Edap.g:1:178: T__45
                {
                mT__45(); 

                }
                break;
            case 30 :
                // Edap.g:1:184: T__46
                {
                mT__46(); 

                }
                break;
            case 31 :
                // Edap.g:1:190: T__47
                {
                mT__47(); 

                }
                break;
            case 32 :
                // Edap.g:1:196: T__48
                {
                mT__48(); 

                }
                break;
            case 33 :
                // Edap.g:1:202: T__49
                {
                mT__49(); 

                }
                break;
            case 34 :
                // Edap.g:1:208: T__50
                {
                mT__50(); 

                }
                break;
            case 35 :
                // Edap.g:1:214: T__51
                {
                mT__51(); 

                }
                break;
            case 36 :
                // Edap.g:1:220: T__52
                {
                mT__52(); 

                }
                break;
            case 37 :
                // Edap.g:1:226: T__53
                {
                mT__53(); 

                }
                break;
            case 38 :
                // Edap.g:1:232: T__54
                {
                mT__54(); 

                }
                break;
            case 39 :
                // Edap.g:1:238: T__55
                {
                mT__55(); 

                }
                break;
            case 40 :
                // Edap.g:1:244: T__56
                {
                mT__56(); 

                }
                break;
            case 41 :
                // Edap.g:1:250: T__57
                {
                mT__57(); 

                }
                break;
            case 42 :
                // Edap.g:1:256: T__58
                {
                mT__58(); 

                }
                break;
            case 43 :
                // Edap.g:1:262: T__59
                {
                mT__59(); 

                }
                break;
            case 44 :
                // Edap.g:1:268: T__60
                {
                mT__60(); 

                }
                break;
            case 45 :
                // Edap.g:1:274: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 46 :
                // Edap.g:1:285: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 47 :
                // Edap.g:1:296: ANNOTATION
                {
                mANNOTATION(); 

                }
                break;
            case 48 :
                // Edap.g:1:307: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 49 :
                // Edap.g:1:322: STRING_EXT
                {
                mSTRING_EXT(); 

                }
                break;
            case 50 :
                // Edap.g:1:333: T_MULTICAST
                {
                mT_MULTICAST(); 

                }
                break;
            case 51 :
                // Edap.g:1:345: T_READONLY
                {
                mT_READONLY(); 

                }
                break;
            case 52 :
                // Edap.g:1:356: T_ASPECT
                {
                mT_ASPECT(); 

                }
                break;
            case 53 :
                // Edap.g:1:365: T_SINGLETON
                {
                mT_SINGLETON(); 

                }
                break;
            case 54 :
                // Edap.g:1:377: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 55 :
                // Edap.g:1:388: LINEBREAKS
                {
                mLINEBREAKS(); 

                }
                break;
            case 56 :
                // Edap.g:1:399: MULTIPLICITY
                {
                mMULTIPLICITY(); 

                }
                break;
            case 57 :
                // Edap.g:1:412: TEXT
                {
                mTEXT(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\2\44\4\uffff\1\44\1\uffff\2\44\1\uffff\3\44\2\uffff\1"+
        "\66\2\uffff\2\44\1\uffff\4\44\10\uffff\1\42\1\uffff\20\44\2\uffff"+
        "\3\44\1\132\5\44\2\uffff\12\44\1\152\6\44\1\161\6\44\1\uffff\6\44"+
        "\1\176\7\44\1\u0087\1\uffff\6\44\1\uffff\1\44\1\u008f\2\44\1\u0092"+
        "\7\44\1\uffff\7\44\1\u00a1\1\uffff\2\44\1\u00a5\4\44\1\uffff\1\44"+
        "\1\u00ac\1\uffff\1\u00ae\2\44\1\u00b1\2\44\1\u00b4\2\44\1\u00b7"+
        "\4\44\1\uffff\3\44\1\uffff\3\44\1\u00c2\2\44\1\uffff\1\44\1\uffff"+
        "\2\44\1\uffff\1\u00c8\1\u00c9\1\uffff\1\u00ca\1\44\1\uffff\12\44"+
        "\1\uffff\5\44\3\uffff\2\44\1\u00dd\1\u00de\1\u00df\6\44\1\u00e6"+
        "\1\44\1\u00e8\2\44\1\u00eb\1\44\3\uffff\1\u00ed\1\u00ee\1\44\1\u00f0"+
        "\1\u00f1\1\u00f2\1\uffff\1\44\1\uffff\1\u00f4\1\44\1\uffff\1\u00f6"+
        "\2\uffff\1\u00f7\3\uffff\1\44\1\uffff\1\u00f9\2\uffff\1\u00fa\2"+
        "\uffff";
    static final String DFA12_eofS =
        "\u00fb\uffff";
    static final String DFA12_minS =
        "\1\11\1\155\1\145\4\uffff\1\141\1\uffff\2\145\1\uffff\3\157\2\uffff"+
        "\1\56\2\uffff\2\156\1\uffff\2\162\1\165\1\143\1\uffff\1\52\6\uffff"+
        "\1\60\1\uffff\1\160\1\151\1\163\1\154\1\166\1\143\1\164\1\141\1"+
        "\156\1\155\1\141\1\155\1\145\1\162\1\157\1\162\2\uffff\1\164\1\151"+
        "\1\145\1\60\1\157\2\141\1\164\1\160\2\uffff\1\157\1\164\1\163\1"+
        "\164\1\151\1\164\1\141\1\145\2\144\1\60\1\165\1\147\1\164\1\160"+
        "\1\156\1\141\1\60\1\160\1\164\1\155\1\162\1\164\1\156\1\uffff\1"+
        "\141\1\156\1\162\1\151\1\145\1\162\1\60\1\141\1\151\1\143\1\151"+
        "\1\164\1\151\1\157\1\60\1\uffff\2\154\1\145\1\157\1\145\1\164\1"+
        "\uffff\1\145\1\60\1\145\1\171\1\60\1\164\1\144\1\163\1\144\1\157"+
        "\1\143\1\164\1\uffff\1\147\1\143\1\145\1\157\1\171\1\166\1\156\1"+
        "\60\1\uffff\1\141\1\145\1\60\1\156\1\143\1\145\1\162\1\uffff\1\162"+
        "\1\60\1\uffff\1\60\1\143\1\151\1\60\1\156\1\164\1\60\1\145\1\141"+
        "\1\60\1\156\1\160\1\145\1\154\1\uffff\2\164\1\150\1\uffff\1\145"+
        "\1\151\1\164\1\60\1\164\1\141\1\uffff\1\145\1\uffff\1\141\1\164"+
        "\1\uffff\2\60\1\uffff\1\60\1\163\1\uffff\1\141\1\145\1\163\1\171"+
        "\2\157\1\141\1\156\1\164\1\157\1\uffff\1\171\1\164\1\146\1\163\1"+
        "\151\3\uffff\1\164\1\162\3\60\1\162\1\156\1\162\1\164\1\145\1\162"+
        "\1\60\1\151\1\60\1\164\1\157\1\60\1\171\3\uffff\2\60\1\164\3\60"+
        "\1\uffff\1\157\1\uffff\1\60\1\156\1\uffff\1\60\2\uffff\1\60\3\uffff"+
        "\1\156\1\uffff\1\60\2\uffff\1\60\2\uffff";
    static final String DFA12_maxS =
        "\1\175\1\156\1\165\4\uffff\1\151\1\uffff\1\145\1\164\1\uffff\1"+
        "\162\1\157\1\162\2\uffff\1\56\2\uffff\1\170\1\156\1\uffff\2\162"+
        "\1\165\1\163\1\uffff\1\57\6\uffff\1\172\1\uffff\1\160\1\151\1\163"+
        "\1\154\1\166\1\143\1\164\1\143\1\164\1\156\1\141\1\156\1\145\1\162"+
        "\1\157\1\162\2\uffff\1\165\1\151\1\145\1\172\1\157\2\141\1\164\1"+
        "\160\2\uffff\1\157\1\164\1\163\1\164\1\151\1\164\1\141\1\145\2\144"+
        "\1\172\1\165\1\147\1\164\1\160\1\156\1\141\1\172\1\160\1\164\1\155"+
        "\1\162\1\164\1\156\1\uffff\1\141\1\156\1\162\1\151\1\145\1\162\1"+
        "\172\1\141\1\151\1\143\1\151\1\164\1\151\1\157\1\172\1\uffff\2\154"+
        "\1\145\1\157\1\145\1\164\1\uffff\1\145\1\172\1\145\1\171\1\172\1"+
        "\164\1\144\1\163\1\144\1\157\1\143\1\164\1\uffff\1\147\1\143\1\145"+
        "\1\157\1\171\1\166\1\156\1\172\1\uffff\1\141\1\145\1\172\1\163\1"+
        "\143\1\145\1\162\1\uffff\1\162\1\172\1\uffff\1\172\1\143\1\151\1"+
        "\172\1\156\1\164\1\172\1\145\1\141\1\172\1\156\1\160\1\145\1\154"+
        "\1\uffff\2\164\1\150\1\uffff\1\145\1\151\1\164\1\172\1\164\1\141"+
        "\1\uffff\1\145\1\uffff\1\141\1\164\1\uffff\2\172\1\uffff\1\172\1"+
        "\163\1\uffff\1\141\1\145\1\163\1\171\2\157\1\141\1\156\1\164\1\157"+
        "\1\uffff\1\171\1\164\1\146\1\163\1\151\3\uffff\1\164\1\162\3\172"+
        "\1\162\1\156\1\162\1\164\1\145\1\162\1\172\1\151\1\172\1\164\1\157"+
        "\1\172\1\171\3\uffff\2\172\1\164\3\172\1\uffff\1\157\1\uffff\1\172"+
        "\1\156\1\uffff\1\172\2\uffff\1\172\3\uffff\1\156\1\uffff\1\172\2"+
        "\uffff\1\172\2\uffff";
    static final String DFA12_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\uffff\1\10\2\uffff\1\13\3\uffff\1\20"+
        "\1\21\1\uffff\1\23\1\25\2\uffff\1\40\4\uffff\1\52\1\uffff\1\57\1"+
        "\60\1\61\1\66\1\67\1\70\1\uffff\1\71\20\uffff\1\22\1\42\11\uffff"+
        "\1\55\1\56\30\uffff\1\32\17\uffff\1\37\6\uffff\1\16\14\uffff\1\31"+
        "\10\uffff\1\43\7\uffff\1\44\2\uffff\1\34\16\uffff\1\12\3\uffff\1"+
        "\35\6\uffff\1\33\1\uffff\1\47\2\uffff\1\50\2\uffff\1\1\2\uffff\1"+
        "\7\12\uffff\1\54\5\uffff\1\51\1\64\1\2\22\uffff\1\26\1\11\1\63\6"+
        "\uffff\1\17\1\uffff\1\41\2\uffff\1\62\1\uffff\1\15\1\65\1\uffff"+
        "\1\14\1\36\1\53\1\uffff\1\45\1\uffff\1\24\1\30\1\uffff\1\46\1\27";
    static final String DFA12_specialS =
        "\u00fb\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\40\1\41\1\uffff\1\40\1\41\22\uffff\1\40\1\uffff\1\36\1\33"+
            "\3\uffff\1\37\1\3\1\5\1\42\1\uffff\1\4\1\23\1\21\1\34\12\43"+
            "\1\17\1\6\1\uffff\1\26\2\uffff\1\35\32\44\1\20\1\uffff\1\22"+
            "\1\uffff\1\44\1\uffff\1\32\1\27\1\14\1\7\1\24\1\15\1\31\1\44"+
            "\1\1\3\44\1\2\1\44\1\25\1\16\1\44\1\11\1\12\1\30\6\44\1\10\1"+
            "\uffff\1\13",
            "\1\45\1\46",
            "\1\47\17\uffff\1\50",
            "",
            "",
            "",
            "",
            "\1\53\3\uffff\1\51\3\uffff\1\52",
            "",
            "\1\54",
            "\1\55\3\uffff\1\56\12\uffff\1\57",
            "",
            "\1\60\2\uffff\1\61",
            "\1\62",
            "\1\64\2\uffff\1\63",
            "",
            "",
            "\1\65",
            "",
            "",
            "\1\67\7\uffff\1\71\1\uffff\1\70",
            "\1\72",
            "",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76\17\uffff\1\77",
            "",
            "\1\101\4\uffff\1\100",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\43\1\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\112\1\uffff\1\111",
            "\1\113\5\uffff\1\114",
            "\1\115\1\116",
            "\1\117",
            "\1\120\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "",
            "",
            "\1\127\1\126",
            "\1\130",
            "\1\131",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\22\44\1\u0086\7"+
            "\44",
            "",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "",
            "\1\u008e",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0090",
            "\1\u0091",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\u00a2",
            "\1\u00a3",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\2\44\1\u00a4\27"+
            "\44",
            "\1\u00a6\4\uffff\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "",
            "\1\u00ab",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\21\44\1\u00ad\10"+
            "\44",
            "\1\u00af",
            "\1\u00b0",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00b2",
            "\1\u00b3",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00b5",
            "\1\u00b6",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00c3",
            "\1\u00c4",
            "",
            "\1\u00c5",
            "",
            "\1\u00c6",
            "\1\u00c7",
            "",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00cb",
            "",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "",
            "",
            "",
            "\1\u00db",
            "\1\u00dc",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\1\u00e5",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00e7",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00e9",
            "\1\u00ea",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00ec",
            "",
            "",
            "",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00ef",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\1\u00f3",
            "",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00f5",
            "",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "",
            "\1\u00f8",
            "",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\13\44\6\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | SL_COMMENT | ML_COMMENT | ANNOTATION | STRING_LITERAL | STRING_EXT | T_MULTICAST | T_READONLY | T_ASPECT | T_SINGLETON | WHITESPACE | LINEBREAKS | MULTIPLICITY | TEXT );";
        }
    }
 

}