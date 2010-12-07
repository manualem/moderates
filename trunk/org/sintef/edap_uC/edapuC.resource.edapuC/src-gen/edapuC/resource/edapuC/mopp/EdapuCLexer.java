// $ANTLR ${project.version} ${buildNumber}

	package edapuC.resource.edapuC.mopp;


import org.antlr.runtime3_2_0.*;

public class EdapuCLexer extends Lexer {
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
    public static final int EOF=-1;
    public static final int LINEBREAKS=12;
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

    	public java.util.List<org.antlr.runtime3_2_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_2_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_2_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_2_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators

    public EdapuCLexer() {;} 
    public EdapuCLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public EdapuCLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "EdapuC.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:16:7: ( 'import' )
            // EdapuC.g:16:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:17:7: ( 'edap' )
            // EdapuC.g:17:9: 'edap'
            {
            match("edap"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:18:7: ( 'device' )
            // EdapuC.g:18:9: 'device'
            {
            match("device"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:19:7: ( '{' )
            // EdapuC.g:19:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:20:7: ( 'init' )
            // EdapuC.g:20:9: 'init'
            {
            match("init"); 


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
            // EdapuC.g:21:7: ( 'poll' )
            // EdapuC.g:21:9: 'poll'
            {
            match("poll"); 


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
            // EdapuC.g:22:7: ( 'global' )
            // EdapuC.g:22:9: 'global'
            {
            match("global"); 


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
            // EdapuC.g:23:7: ( '}' )
            // EdapuC.g:23:9: '}'
            {
            match('}'); 

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
            // EdapuC.g:24:7: ( 'application' )
            // EdapuC.g:24:9: 'application'
            {
            match("application"); 


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
            // EdapuC.g:25:7: ( 'headers' )
            // EdapuC.g:25:9: 'headers'
            {
            match("headers"); 


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
            // EdapuC.g:26:7: ( 'message' )
            // EdapuC.g:26:9: 'message'
            {
            match("message"); 


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
            // EdapuC.g:27:7: ( 'send' )
            // EdapuC.g:27:9: 'send'
            {
            match("send"); 


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
            // EdapuC.g:28:7: ( 'property' )
            // EdapuC.g:28:9: 'property'
            {
            match("property"); 


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
            // EdapuC.g:29:7: ( '=' )
            // EdapuC.g:29:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:2037:11: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // EdapuC.g:2038:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // EdapuC.g:2038:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // EdapuC.g:2038:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 

            // EdapuC.g:2038:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // EdapuC.g:2038:8: ~ ( '\\n' | '\\r' | '\\uffff' )
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
            // EdapuC.g:2041:11: ( ( '/*' ( . )* '*/' ) )
            // EdapuC.g:2042:2: ( '/*' ( . )* '*/' )
            {
            // EdapuC.g:2042:2: ( '/*' ( . )* '*/' )
            // EdapuC.g:2042:3: '/*' ( . )* '*/'
            {
            match("/*"); 

            // EdapuC.g:2042:7: ( . )*
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
            	    // EdapuC.g:2042:7: .
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
            // EdapuC.g:2045:11: ( ( '@' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // EdapuC.g:2046:2: ( '@' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // EdapuC.g:2046:2: ( '@' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // EdapuC.g:2046:3: '@' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            match('@'); 
            // EdapuC.g:2046:6: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
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
            	    // EdapuC.g:
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

             _channel = 99; 

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
            // EdapuC.g:2049:15: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"' ) )
            // EdapuC.g:2050:2: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"' )
            {
            // EdapuC.g:2050:2: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"' )
            // EdapuC.g:2050:3: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // EdapuC.g:2050:6: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ) | '\\\\' ( '0' .. '7' ) | ~ ( '\\\\' | '\"' ) )*
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
            	    // EdapuC.g:2050:7: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
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
            	    // EdapuC.g:2050:48: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    {
            	    // EdapuC.g:2050:48: ( '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            	    // EdapuC.g:2050:49: '\\\\' 'u' ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
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
            	    // EdapuC.g:2050:170: '\\\\' ( '0' .. '7' )
            	    {
            	    match('\\'); 
            	    // EdapuC.g:2050:174: ( '0' .. '7' )
            	    // EdapuC.g:2050:175: '0' .. '7'
            	    {
            	    matchRange('0','7'); 

            	    }


            	    }
            	    break;
            	case 4 :
            	    // EdapuC.g:2050:185: ~ ( '\\\\' | '\"' )
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

    // $ANTLR start "TEMPLATE"
    public final void mTEMPLATE() throws RecognitionException {
        try {
            int _type = TEMPLATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:2052:9: ( ( '<template>' ( . )* '</template>' ) )
            // EdapuC.g:2053:2: ( '<template>' ( . )* '</template>' )
            {
            // EdapuC.g:2053:2: ( '<template>' ( . )* '</template>' )
            // EdapuC.g:2053:3: '<template>' ( . )* '</template>'
            {
            match("<template>"); 

            // EdapuC.g:2053:15: ( . )*
            loop5:
            do {
                int alt5=2;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // EdapuC.g:2053:15: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match("</template>"); 


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEMPLATE"

    // $ANTLR start "GENERATOR"
    public final void mGENERATOR() throws RecognitionException {
        try {
            int _type = GENERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:2055:10: ( ( '<generator>' ( . )* '</generator>' ) )
            // EdapuC.g:2056:2: ( '<generator>' ( . )* '</generator>' )
            {
            // EdapuC.g:2056:2: ( '<generator>' ( . )* '</generator>' )
            // EdapuC.g:2056:3: '<generator>' ( . )* '</generator>'
            {
            match("<generator>"); 

            // EdapuC.g:2056:16: ( . )*
            loop6:
            do {
                int alt6=2;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // EdapuC.g:2056:16: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("</generator>"); 


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GENERATOR"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:2058:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // EdapuC.g:2059:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            // EdapuC.g:2059:2: ( ( ' ' | '\\t' | '\\f' ) )
            // EdapuC.g:2059:3: ( ' ' | '\\t' | '\\f' )
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
            // EdapuC.g:2062:11: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // EdapuC.g:2063:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // EdapuC.g:2063:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // EdapuC.g:2063:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // EdapuC.g:2063:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='\n') ) {
                    alt7=1;
                }
                else {
                    alt7=2;}
            }
            else if ( (LA7_0=='\n') ) {
                alt7=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // EdapuC.g:2063:4: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // EdapuC.g:2063:11: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // EdapuC.g:2063:16: '\\n'
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

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // EdapuC.g:2066:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )* ) )
            // EdapuC.g:2067:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )* )
            {
            // EdapuC.g:2067:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )* )
            // EdapuC.g:2067:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )*
            {
            // EdapuC.g:2067:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // EdapuC.g:
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            // EdapuC.g:2067:44: ( ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==':') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // EdapuC.g:2067:45: ':' ':' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
            	    {
            	    match(':'); 
            	    match(':'); 
            	    // EdapuC.g:2067:53: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' )+
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
            	    	    // EdapuC.g:
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


            	    }
            	    break;

            	default :
            	    break loop10;
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
        // EdapuC.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | SL_COMMENT | ML_COMMENT | ANNOTATION | STRING_LITERAL | TEMPLATE | GENERATOR | WHITESPACE | LINEBREAKS | TEXT )
        int alt11=23;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // EdapuC.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // EdapuC.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // EdapuC.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // EdapuC.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // EdapuC.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // EdapuC.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // EdapuC.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // EdapuC.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // EdapuC.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // EdapuC.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // EdapuC.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // EdapuC.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // EdapuC.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // EdapuC.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // EdapuC.g:1:94: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 16 :
                // EdapuC.g:1:105: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 17 :
                // EdapuC.g:1:116: ANNOTATION
                {
                mANNOTATION(); 

                }
                break;
            case 18 :
                // EdapuC.g:1:127: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 19 :
                // EdapuC.g:1:142: TEMPLATE
                {
                mTEMPLATE(); 

                }
                break;
            case 20 :
                // EdapuC.g:1:151: GENERATOR
                {
                mGENERATOR(); 

                }
                break;
            case 21 :
                // EdapuC.g:1:161: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 22 :
                // EdapuC.g:1:172: LINEBREAKS
                {
                mLINEBREAKS(); 

                }
                break;
            case 23 :
                // EdapuC.g:1:183: TEXT
                {
                mTEXT(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA5_eotS =
        "\15\uffff";
    static final String DFA5_eofS =
        "\15\uffff";
    static final String DFA5_minS =
        "\2\0\1\uffff\11\0\1\uffff";
    static final String DFA5_maxS =
        "\2\uffff\1\uffff\11\uffff\1\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\1\11\uffff\1\2";
    static final String DFA5_specialS =
        "\1\12\1\5\1\uffff\1\4\1\7\1\6\1\1\1\0\1\3\1\2\1\11\1\10\1\uffff}>";
    static final String[] DFA5_transitionS = {
            "\74\2\1\1\uffc3\2",
            "\57\2\1\3\uffd0\2",
            "",
            "\164\2\1\4\uff8b\2",
            "\145\2\1\5\uff9a\2",
            "\155\2\1\6\uff92\2",
            "\160\2\1\7\uff8f\2",
            "\154\2\1\10\uff93\2",
            "\141\2\1\11\uff9e\2",
            "\164\2\1\12\uff8b\2",
            "\145\2\1\13\uff9a\2",
            "\76\2\1\14\uffc1\2",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 2053:15: ( . )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_7 = input.LA(1);

                        s = -1;
                        if ( (LA5_7=='l') ) {s = 8;}

                        else if ( ((LA5_7>='\u0000' && LA5_7<='k')||(LA5_7>='m' && LA5_7<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_6 = input.LA(1);

                        s = -1;
                        if ( (LA5_6=='p') ) {s = 7;}

                        else if ( ((LA5_6>='\u0000' && LA5_6<='o')||(LA5_6>='q' && LA5_6<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA5_9 = input.LA(1);

                        s = -1;
                        if ( (LA5_9=='t') ) {s = 10;}

                        else if ( ((LA5_9>='\u0000' && LA5_9<='s')||(LA5_9>='u' && LA5_9<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA5_8 = input.LA(1);

                        s = -1;
                        if ( (LA5_8=='a') ) {s = 9;}

                        else if ( ((LA5_8>='\u0000' && LA5_8<='`')||(LA5_8>='b' && LA5_8<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA5_3 = input.LA(1);

                        s = -1;
                        if ( (LA5_3=='t') ) {s = 4;}

                        else if ( ((LA5_3>='\u0000' && LA5_3<='s')||(LA5_3>='u' && LA5_3<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA5_1 = input.LA(1);

                        s = -1;
                        if ( (LA5_1=='/') ) {s = 3;}

                        else if ( ((LA5_1>='\u0000' && LA5_1<='.')||(LA5_1>='0' && LA5_1<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA5_5 = input.LA(1);

                        s = -1;
                        if ( (LA5_5=='m') ) {s = 6;}

                        else if ( ((LA5_5>='\u0000' && LA5_5<='l')||(LA5_5>='n' && LA5_5<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA5_4 = input.LA(1);

                        s = -1;
                        if ( (LA5_4=='e') ) {s = 5;}

                        else if ( ((LA5_4>='\u0000' && LA5_4<='d')||(LA5_4>='f' && LA5_4<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA5_11 = input.LA(1);

                        s = -1;
                        if ( (LA5_11=='>') ) {s = 12;}

                        else if ( ((LA5_11>='\u0000' && LA5_11<='=')||(LA5_11>='?' && LA5_11<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA5_10 = input.LA(1);

                        s = -1;
                        if ( (LA5_10=='e') ) {s = 11;}

                        else if ( ((LA5_10>='\u0000' && LA5_10<='d')||(LA5_10>='f' && LA5_10<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA5_0 = input.LA(1);

                        s = -1;
                        if ( (LA5_0=='<') ) {s = 1;}

                        else if ( ((LA5_0>='\u0000' && LA5_0<=';')||(LA5_0>='=' && LA5_0<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA6_eotS =
        "\16\uffff";
    static final String DFA6_eofS =
        "\16\uffff";
    static final String DFA6_minS =
        "\2\0\1\uffff\12\0\1\uffff";
    static final String DFA6_maxS =
        "\2\uffff\1\uffff\12\uffff\1\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\1\12\uffff\1\2";
    static final String DFA6_specialS =
        "\1\0\1\10\1\uffff\1\11\1\12\1\13\1\4\1\5\1\6\1\7\1\1\1\2\1\3\1"+
        "\uffff}>";
    static final String[] DFA6_transitionS = {
            "\74\2\1\1\uffc3\2",
            "\57\2\1\3\uffd0\2",
            "",
            "\147\2\1\4\uff98\2",
            "\145\2\1\5\uff9a\2",
            "\156\2\1\6\uff91\2",
            "\145\2\1\7\uff9a\2",
            "\162\2\1\10\uff8d\2",
            "\141\2\1\11\uff9e\2",
            "\164\2\1\12\uff8b\2",
            "\157\2\1\13\uff90\2",
            "\162\2\1\14\uff8d\2",
            "\76\2\1\15\uffc1\2",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()* loopback of 2056:16: ( . )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA6_0 = input.LA(1);

                        s = -1;
                        if ( (LA6_0=='<') ) {s = 1;}

                        else if ( ((LA6_0>='\u0000' && LA6_0<=';')||(LA6_0>='=' && LA6_0<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA6_10 = input.LA(1);

                        s = -1;
                        if ( (LA6_10=='o') ) {s = 11;}

                        else if ( ((LA6_10>='\u0000' && LA6_10<='n')||(LA6_10>='p' && LA6_10<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA6_11 = input.LA(1);

                        s = -1;
                        if ( (LA6_11=='r') ) {s = 12;}

                        else if ( ((LA6_11>='\u0000' && LA6_11<='q')||(LA6_11>='s' && LA6_11<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA6_12 = input.LA(1);

                        s = -1;
                        if ( (LA6_12=='>') ) {s = 13;}

                        else if ( ((LA6_12>='\u0000' && LA6_12<='=')||(LA6_12>='?' && LA6_12<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA6_6 = input.LA(1);

                        s = -1;
                        if ( (LA6_6=='e') ) {s = 7;}

                        else if ( ((LA6_6>='\u0000' && LA6_6<='d')||(LA6_6>='f' && LA6_6<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA6_7 = input.LA(1);

                        s = -1;
                        if ( (LA6_7=='r') ) {s = 8;}

                        else if ( ((LA6_7>='\u0000' && LA6_7<='q')||(LA6_7>='s' && LA6_7<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA6_8 = input.LA(1);

                        s = -1;
                        if ( (LA6_8=='a') ) {s = 9;}

                        else if ( ((LA6_8>='\u0000' && LA6_8<='`')||(LA6_8>='b' && LA6_8<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA6_9 = input.LA(1);

                        s = -1;
                        if ( (LA6_9=='t') ) {s = 10;}

                        else if ( ((LA6_9>='\u0000' && LA6_9<='s')||(LA6_9>='u' && LA6_9<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA6_1 = input.LA(1);

                        s = -1;
                        if ( (LA6_1=='/') ) {s = 3;}

                        else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA6_3 = input.LA(1);

                        s = -1;
                        if ( (LA6_3=='g') ) {s = 4;}

                        else if ( ((LA6_3>='\u0000' && LA6_3<='f')||(LA6_3>='h' && LA6_3<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA6_4 = input.LA(1);

                        s = -1;
                        if ( (LA6_4=='e') ) {s = 5;}

                        else if ( ((LA6_4>='\u0000' && LA6_4<='d')||(LA6_4>='f' && LA6_4<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA6_5 = input.LA(1);

                        s = -1;
                        if ( (LA6_5=='n') ) {s = 6;}

                        else if ( ((LA6_5>='\u0000' && LA6_5<='m')||(LA6_5>='o' && LA6_5<='\uFFFF')) ) {s = 2;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 6, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA11_eotS =
        "\1\uffff\3\23\1\uffff\2\23\1\uffff\4\23\10\uffff\13\23\4\uffff"+
        "\14\23\1\72\1\73\1\23\1\75\5\23\1\103\1\23\2\uffff\1\23\1\uffff"+
        "\5\23\1\uffff\1\113\1\114\1\23\1\116\3\23\2\uffff\1\23\1\uffff\1"+
        "\23\1\124\1\125\1\126\1\23\3\uffff\2\23\1\132\1\uffff";
    static final String DFA11_eofS =
        "\133\uffff";
    static final String DFA11_minS =
        "\1\11\1\155\1\144\1\145\1\uffff\1\157\1\154\1\uffff\1\160\3\145"+
        "\1\uffff\1\52\2\uffff\1\147\3\uffff\1\160\1\151\1\141\1\166\1\154"+
        "\2\157\1\160\1\141\1\163\1\156\4\uffff\1\157\1\164\1\160\1\151\1"+
        "\154\1\160\1\142\1\154\1\144\1\163\1\144\1\162\2\60\1\143\1\60\1"+
        "\145\1\141\1\151\1\145\1\141\1\60\1\164\2\uffff\1\145\1\uffff\1"+
        "\162\1\154\1\143\1\162\1\147\1\uffff\2\60\1\164\1\60\1\141\1\163"+
        "\1\145\2\uffff\1\171\1\uffff\1\164\3\60\1\151\3\uffff\1\157\1\156"+
        "\1\60\1\uffff";
    static final String DFA11_maxS =
        "\1\175\1\156\1\144\1\145\1\uffff\1\162\1\154\1\uffff\1\160\3\145"+
        "\1\uffff\1\57\2\uffff\1\164\3\uffff\1\160\1\151\1\141\1\166\1\154"+
        "\2\157\1\160\1\141\1\163\1\156\4\uffff\1\157\1\164\1\160\1\151\1"+
        "\154\1\160\1\142\1\154\1\144\1\163\1\144\1\162\2\172\1\143\1\172"+
        "\1\145\1\141\1\151\1\145\1\141\1\172\1\164\2\uffff\1\145\1\uffff"+
        "\1\162\1\154\1\143\1\162\1\147\1\uffff\2\172\1\164\1\172\1\141\1"+
        "\163\1\145\2\uffff\1\171\1\uffff\1\164\3\172\1\151\3\uffff\1\157"+
        "\1\156\1\172\1\uffff";
    static final String DFA11_acceptS =
        "\4\uffff\1\4\2\uffff\1\10\4\uffff\1\16\1\uffff\1\21\1\22\1\uffff"+
        "\1\25\1\26\1\27\13\uffff\1\17\1\20\1\23\1\24\27\uffff\1\5\1\2\1"+
        "\uffff\1\6\5\uffff\1\14\7\uffff\1\1\1\3\1\uffff\1\7\5\uffff\1\12"+
        "\1\13\1\15\3\uffff\1\11";
    static final String DFA11_specialS =
        "\133\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\21\1\22\1\uffff\1\21\1\22\22\uffff\1\21\1\uffff\1\17\14"+
            "\uffff\1\15\12\23\2\uffff\1\20\1\14\2\uffff\1\16\32\23\4\uffff"+
            "\1\23\1\uffff\1\10\2\23\1\3\1\2\1\23\1\6\1\11\1\1\3\23\1\12"+
            "\2\23\1\5\2\23\1\13\7\23\1\4\1\uffff\1\7",
            "\1\24\1\25",
            "\1\26",
            "\1\27",
            "",
            "\1\30\2\uffff\1\31",
            "\1\32",
            "",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "",
            "\1\40\4\uffff\1\37",
            "",
            "",
            "\1\42\14\uffff\1\41",
            "",
            "",
            "",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\46",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "",
            "",
            "",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\74",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\104",
            "",
            "",
            "\1\105",
            "",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\115",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\117",
            "\1\120",
            "\1\121",
            "",
            "",
            "\1\122",
            "",
            "\1\123",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\127",
            "",
            "",
            "",
            "\1\130",
            "\1\131",
            "\13\23\6\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | SL_COMMENT | ML_COMMENT | ANNOTATION | STRING_LITERAL | TEMPLATE | GENERATOR | WHITESPACE | LINEBREAKS | TEXT );";
        }
    }
 

}