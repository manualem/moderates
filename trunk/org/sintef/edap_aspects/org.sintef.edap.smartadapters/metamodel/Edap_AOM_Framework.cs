SYNTAXDEF edap_aspect
FOR <http://SmartAdapters4MODERATES>
START Aspect

IMPORTS{
	adaptations:<http://SmartAdapters4ART/smartadapters/core/adaptations>
	edap:<http://edap_relaxed>
}

OPTIONS {
	memoize = "true";
	tokenspace = "0";
	usePredefinedTokens = "false";
}

TOKENS{
		DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
		DEFINE ML_COMMENT $'/*'.*'*/'$ ;
		
		DEFINE ANNOTATION $'@'('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+$;
		
		DEFINE STRING_LITERAL $'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'$;

		DEFINE STRING_EXT $'\''('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'\''))*'\''$;
		
		DEFINE T_MULTICAST $'multicast'$;
		DEFINE T_READONLY $'readonly'$;
		
		DEFINE T_ASPECT $'aspect'$;
		DEFINE T_SINGLETON $'singleton'$;
		
		DEFINE WHITESPACE $(' '|'\t'|'\f')$;
		DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
		
		DEFINE MULTIPLICITY $( ('*') | (('0'..'9')+) )$;
		
		DEFINE TXTID $'<'('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '*')+ (':' ':' ('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '*')+ )*'>'$;
	
		//DEFINE TEXT $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+$;
		DEFINE TEXT $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' )+ (':' ':' ('A'..'Z' | 'a'..'z' | '0'..'9' | '_')+ )* $;
}

TOKENSTYLES{
	"TEXT" COLOR #000000;
	
	"T_MULTICAST" COLOR #7F0055, BOLD;
	"T_READONLY" COLOR #7F0055, BOLD;

	"SL_COMMENT"  COLOR #00aa33;
	"ML_COMMENT"  COLOR #00aa33;
	
	"ANNOTATION" COLOR #0055bb , BOLD;
	"STRING_LITERAL" COLOR #0055bb;
	
	"device" COLOR #CC8000, BOLD;
	"datatype" COLOR #CC8000, BOLD;
	"enumeration" COLOR #CC8000, BOLD;
	"T_ASPECT" COLOR #CC8000, BOLD;
	"T_SINGLETON" COLOR #CC8000, BOLD;
	
	"sends" COLOR #7F0055, BOLD;
	"receives" COLOR #7F0055, BOLD;
	
	"STRING_EXT" COLOR #0055bb;
	
	"state" COLOR #CC8000, BOLD;
	"composite" COLOR #CC8000, BOLD;
	"statechart" COLOR #CC8000, BOLD;
	"component" COLOR #CC8000, BOLD;
	"event" COLOR #7F0055, BOLD;	
	"eventref" COLOR #7F0055, BOLD;
	"guard" COLOR #7F0055, BOLD;
	"action" COLOR #7F0055, BOLD;
	"on" COLOR #7F0055, BOLD;
	"entry" COLOR #7F0055, BOLD;
	"exit" COLOR #7F0055, BOLD;
	"send" COLOR #7F0055, BOLD;
	"transition" COLOR #CC8000, BOLD;
	"init" COLOR #CC8000, BOLD;
	"connector" COLOR #CC8000, BOLD;
	"port" COLOR #CC8000, BOLD;	
	"import" COLOR #7F0055, BOLD;
	"->" COLOR #CC8000, BOLD;
	
	"(" COLOR #444444, BOLD;
	")" COLOR #444444, BOLD;
	"{" COLOR #444444, BOLD;
	"}" COLOR #444444, BOLD;
	"[" COLOR #444444, BOLD;
	"]" COLOR #444444, BOLD;
}


RULES{
	
	// Generic Aspect Syntax
	
	Aspect::= ("aspect" #1 name[])? #1 "pointcut" !0 "{"  pointcut !0 "}" !0 "advice"  !0 "{" (!1 advice) !0 "}" (!0 "strategies"  !0 "{" (!1 strategies)* !0 "}")? !0 "protocol" !0 "{" (!1 adapt)* !0 "}"; //( !0 "unique elements"  ":" persistent[] ("," #1 persistent[])* )?
	
	PointcutModel ::= (content !0)*;
	
	AdviceModel ::= (content !0)*;
	
	GlobalInstantiation ::= "global" #1 adviceElements[] ("," #1 adviceElements[])* ;
	
	PerRoleMatch ::= "per" #1 "role" #1 pointcutElements[] ("," #1 pointcutElements[])*  #1 ":" #1 adviceElements[] ("," #1 adviceElements[])* ;
	
	PerElementMatch ::= "per" #1 "elements" #1 pointcutElements[] ("," #1 pointcutElements[])*  #1 ":" #1 adviceElements[] ("," #1 adviceElements[])* ;
	
	// EDAP adapters
	
	adaptations.SetCompositeState::= "set" #1 "composite" "state" #1 CompositeStateToSet[] !0 "{"  ( 
					!1 "initial" #1 "=" #1 initial[] | 
					!1 "substate" #1 "+=" #1 substate[] ("," #1 substate[])* 
				)* !0 "}"  ;
	
	adaptations.UnsetCompositeState::= "set" #1 "composite" "state" #1 CompositeStateToUnset[] !0 "{"  ( 
					!1 "initial" #1 "=" #1 initial[] | 
					!1 "substate" #1 "+=" #1 substate[] ("," #1 substate[])* 
				)* !0 "}"  ;
				
	adaptations.SetState::= "set" #1 "state" #1 StateToSet[] !0 "{"  ( 
					!1 "outgoing" #1 "+=" #1 outgoing[] ("," #1 outgoing[])* |
					!1 "incoming" #1 "+=" #1 incoming[] ("," #1 incoming[])* |
					!1 "entry" #1 "=" #1 entry[] | 
					!1 "exit" #1 "=" #1 exit[] | 
					!1 "properties" #1 "+=" #1 properties[] ("," #1 properties[])* 
				)* !0 "}"  ;
				
	adaptations.UnsetState::= "set" #1 "state" #1 StateToUnset[] !0 "{"  ( 
					!1 "outgoing" #1 "+=" #1 outgoing[] ("," #1 outgoing[])* |
					!1 "incoming" #1 "+=" #1 incoming[] ("," #1 incoming[])* |
					!1 "entry" #1 "=" #1 entry[] | 
					!1 "exit" #1 "=" #1 exit[] | 
					!1 "properties" #1 "+=" #1 properties[] ("," #1 properties[])* 
				)* !0 "}"  ;
				
	adaptations.SetTransition::= "set" #1 "transition" #1 TransitionToSet[] !0 "{"  ( 
					!1 "event" #1 "+=" #1 event[] ("," #1 event[])* |
					!1 "guard" #1 "=" #1 guard[] | 
					!1 "action" #1 "=" #1 action[] | 
					!1 "target" #1 "=" #1 target[] | 
					!1 "source" #1 "=" #1 source[]
				)* !0 "}"  ;
				
	adaptations.UnsetTransition::= "set" #1 "transition" #1 TransitionToUnset[] !0 "{"  ( 
					!1 "event" #1 "+=" #1 event[] ("," #1 event[])* |
					!1 "guard" #1 "=" #1 guard[] | 
					!1 "action" #1 "=" #1 action[] | 
					!1 "target" #1 "=" #1 target[] | 
					!1 "source" #1 "=" #1 source[]
				)* !0 "}"  ;
	
	adaptations.SetAnnotatedElement::= "set" #1 "element" #1 AnnotatedElementToSet[] !0 "{"  ( 
					!1 "annotations" #1 "+=" #1 annotations[] ("," #1 annotations[])* 
				)* !0 "}"  ;
				
	adaptations.SetActionBlock::= "set" #1 "block" #1 blockToSet[] !0 "{"  ( 
					!1 "actions" #1 "+=" #1 actions[] ("," #1 actions[])* 
				)* !0 "}"  ;
	
	// Relaxed EDAP Syntax
	
	edap.EdapModel::= "model" ( !0 "import" #1 imports[STRING_LITERAL] )* ( !0 (types) )* ;
		
	edap.Message ::= (allowMulticast[T_MULTICAST])? "message" (#1 name[])? ( #1 aspectID[TXTID])?  "(" (parameters (","  parameters)* )? ")"(annotations)* ";"  ;
	
	edap.Device::= (partial[T_ASPECT])? (singleton[T_SINGLETON])? "device" (#1 name[])? ( #1 aspectID[TXTID])? (annotations)*  !0 "{" ( messages | properties | "receives" #1 receives[] (","  #1 receives[])* | "sends" #1 sends[] (","  #1 sends[])* | (!1 compositeComponent) )* !0 "}" ;
	
	edap.SoftwareComponent ::= (partial[T_ASPECT])? (singleton[T_SINGLETON])? "component" (#1 name[])? ( #1 aspectID[TXTID])? (annotations)*  !0 "{" (ports | connectors | messages | properties | "receives" #1 receives[] (","  #1 receives[])* | "sends" #1 sends[] (","  #1 sends[])* | (!1 compositeComponent) )* (!1 behaviour)? !0 "}" ;
	
	edap.Simulator ::= "simulator" (#1 name[])? ( #1 aspectID[TXTID])? "for" device[] (annotations)* !0 "{" ( messages | properties |  "receives" #1 receives[] (","  #1 receives[])* | "sends" #1 sends[] (","  #1 sends[])* | (!1 compositeComponent) )* (!1 behaviour) !0 "}" ;

	edap.Property::= !1 (changeable[T_READONLY])? "property" (#1 name[])? ( #1 aspectID[TXTID])?  ":"  type[] ("[" lowerBound[MULTIPLICITY] ".." upperBound[MULTIPLICITY] "]")?(annotations)*;
	
	edap.Dictionary::= !1 (changeable[T_READONLY])? "dictionary" (#1 name[])? ( #1 aspectID[TXTID])?  ":"  indexType[] "->" type[] ("[" lowerBound[MULTIPLICITY] ".." upperBound[MULTIPLICITY] "]")?(annotations)*;
	
	edap.Parameter::= name[]  ":"  ("?" | type[]);
	
	edap.PrimitiveType::= "datatype" (#1 name[])? ( #1 aspectID[TXTID])? (annotations)* ";" ;
	
	edap.Enumeration::= "enumeration" (#1 name[])? ( #1 aspectID[TXTID])? (annotations)* !0 "{" (literals)* "}" ;
	
	edap.EnumerationLiteral ::= !1 name[] (annotations)* ;
	
	edap.PlatformAnnotation ::= !1 name[ANNOTATION] #1 value[STRING_LITERAL] ;
	
	edap.StateMachine::= "statechart" (#1 name[])? ( #1 aspectID[TXTID])? #1 ("init" #1 initial[])? (annotations)* #1 "{" ( !1 properties )* ( !1 "on" #1 "entry" #1 entry )? ( !1 "on" #1 "exit" #1 exit )?  (!1 substate)* !0 "}"  ;
	
	edap.State::= "state" (#1 name[])? ( #1 aspectID[TXTID])? (annotations)* #1 "{" ( !1 properties )* ( !1 "on" #1 "entry" entry )? ( !1 "on" "exit" exit )? ( outgoing )* !0 "}"  ;
	
	edap.CompositeState::= "composite" #1 "state" (#1 name[])? ( #1 aspectID[TXTID])? #1 ("init" #1 initial[])? (annotations)* #1 "{" ( !1 properties )* ( !1 "on" #1 "entry" #1 entry )? ( !1 "on" #1 "exit" #1 exit )? ( outgoing | (!1 substate) )* !0 "}"  ;
	
	edap.ActionBlock::= ( #1 aspectID[TXTID])? "{" ( !1 actions )* !0 "}"  ;
	
	edap.ExternStatement::= ( #1 aspectID[TXTID])? statement[STRING_EXT] ;
	
	edap.PropertyAssignment ::= ( #1 aspectID[TXTID])? "set" #1 property[] #1 "=" #1 expression ; 
	
	edap.ExternExpression::= ( #1 aspectID[TXTID])? expression[STRING_EXT] ;

	edap.ComponentReference ::= component[] (propertyNavigations)* ;
	
	edap.EventReference ::= ( #1 aspectID[TXTID])? "eventref" #1 msgRef[] "." paramRef[];	
	
	edap.PropertyNavigation ::= "." property[] ;
	
	edap.DictionaryNavigation ::= "." property[] "[" index "]";
	
	edap.Unicast::= ( #1 aspectID[TXTID])? "send" #1 target "." message[] "(" (parameters ("," #1 parameters)* )? ")"  ("port" port[])? (annotations)*;
	
	edap.Broadcast::= ( #1 aspectID[TXTID])? "broadcast" #1 target "." message[] "(" (parameters ("," #1 parameters)* )? ")"  ;	

	edap.Transition::= !1 "transition" (#1 name[])? ( #1 aspectID[TXTID])? #1 "->" #1 ("?" | target[]) (annotations)* #1 "{" ( !1 "event" #1 event )*  ( !1 "guard" #1 guard)? (!1 "action" #1 action)? !0 "}"  ;

	edap.ReceiveMessage ::= device "#" message[] ;
	
	edap.Connector ::= ( #1 aspectID[TXTID])? "connector" "(" port1[] "," port2[] ")" (annotations)* ;
	
	edap.Port ::= "port" (#1 name[])? ( #1 aspectID[TXTID])? (annotations)* ;
	
	edap.CreateAction ::= ( #1 aspectID[TXTID])? "create" ref (annotations)* ;

}