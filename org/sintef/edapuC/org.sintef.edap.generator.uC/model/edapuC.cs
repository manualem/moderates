SYNTAXDEF edapuC
FOR <http://edapuC>
START UCGenerator


IMPORTS {
	edap:<http://edap>
}
OPTIONS {
	memoize = "true";
	tokenspace = "0";
	usePredefinedTokens = "false";

	defaultTokenName="TEXT";
	generateCodeFromGeneratorModel="false";

	backtracking="true";

	reloadGeneratorModel="true";
	
	licenceHeader="license.txt";
	
}

TOKENS{
		DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
		DEFINE ML_COMMENT $'/*'.*'*/'$ ;
		
		DEFINE ANNOTATION $'@'('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+$;
		
		DEFINE STRING_LITERAL $'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'$;
		
		DEFINE TEMPLATE $'<template>'.*'</template>'$ ;
		
		DEFINE GENERATOR $'<generator>'.*'</generator>'$ ;
		
		DEFINE WHITESPACE $(' '|'\t'|'\f')$;
		DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;

		DEFINE TEXT $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' )+ (':' ':' ('A'..'Z' | 'a'..'z' | '0'..'9' | '_')+ )* $;
}
TOKENSTYLES {

	"import" COLOR #7F0055, BOLD;
	"edap" COLOR #7F0055, BOLD;
	
	"property" COLOR #0055bb, BOLD;
 	
	"init" COLOR #7F0055, BOLD;
	"poll" COLOR #7F0055, BOLD;
	"global" COLOR #7F0055, BOLD;
	
	"device" COLOR #CC8000, BOLD;

	"message" COLOR #7F0055, BOLD;
	
	"STRING_LITERAL" COLOR #0055bb;
	
	"TEMPLATE" COLOR #707070;
	
	"GENERATOR" COLOR #ef8f49;
	
	"application" COLOR #CC8000, BOLD;
	
	
}
			
RULES {
	UCGenerator ::= ( !0 "import" #1 imports[STRING_LITERAL] )*  ( !0 "edap" #1 edap[STRING_LITERAL] )* (!0 (properties | devices | application) )* ;
	
	UCDevice ::= "device" #1 device[] "{" ( !0 ("init" #1 init | "poll" #1 poll | "global" #1 global | properties |  messages) )* "}" ;
	
	UCApplication ::= "application" #1 state_machine[] "{" ( !0 ("init" #1 init | "poll" #1 poll | "global" #1 global | "headers" #1 headers | properties) )* "}" ;
	
	UCMessage ::= "message" #1 message[] "{" ( !0 (properties | "send" #1 send) )* "}"  ;
	
	Template ::= generator[GENERATOR]? text[TEMPLATE]  ;
	
	StaticProperty ::= "property" #1 name[] #1 "=" #1 value[STRING_LITERAL]  ;
	
}