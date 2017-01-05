grammar DATR;

query : node NODE_SEPARATOR lhs WS? EOF;

// <theory> ::= <sentence> [<sentence>]*
theory : (WS? COMMENT)* (sentence ((NL WS?)+ sentence)*) EOF;

// <sentence> ::= <node> : [<equation>]*
sentence : node NODE_SEPARATOR ((NL WS?)? equation ((NL WS?) equation)*) DOT (WS? COMMENT)*;

// <equation> ::= <lhs> == <rhs>
equation : lhs WS? ASSIGN WS? rhs (WS? COMMENT)*;

// <lhs> ::= "<" [<atom>]* ">"
lhs : LPATH (WS? atom WS?)* RPATH;

// <rhs> ::= [<val_exp>]* | ( [<val_exp>]* )
rhs : (valueExpression WS?)* | LPAREN (WS? valueExpression WS?)* RPAREN;

// <val_exp> ::= atom | <descriptor> | " <descriptor> "
valueExpression : atom | descriptor | globalDescriptor;

// <descriptor> ::= <node> : <path> | <node> | <path>
descriptor : node NODE_SEPARATOR path | node | path;

globalDescriptor : lquote=DOUBLE_QUOTE descriptor rquote=DOUBLE_QUOTE;

// <path> ::= "<" [<val_exp>]* ">"
path : LPATH WS? (valueExpression (WS valueExpression)*)? WS? RPATH;

// <atom> ::= <atom_char> [<symbol_char>]* | ’ [<char>]* ’ | <variable>
atom : ATOM | lquote=SINGLE_QUOTE ~('\r' | '\n' | SINGLE_QUOTE)* rquote=SINGLE_QUOTE | variable;

// <variable> ::= $ [<symbol_char>]*
variable : VARIABLE;

// <node> ::= <node_char> [<symbol_char>]*
node : NODE ;

COMMENT : COMMENT_SEPARTOR ~('\r' | '\n')* ;

ATOM : ATOM_CHAR SYMBOL_CHAR* ;

VARIABLE : VAR_PREFIX SYMBOL_CHAR* ;

NODE : NODE_CHAR SYMBOL_CHAR* ;

NODE_CHAR : [A-Z] ;

ATOM_CHAR : [a-z0-9] ;

SYMBOL_CHAR : CHAR ;

CHAR : [a-zA-Z0-9äöüÄÖÜß] ;

SINGLE_QUOTE : '\'' ;

DOUBLE_QUOTE : '"' ;

VAR_PREFIX : '$' ;
NODE_SEPARATOR : ':' ;
COMMENT_SEPARTOR : '%' ;

LPAREN : '(' ;
RPAREN : ')' ;

LPATH : '<' ;
RPATH : '>' ;

ASSIGN : '==' ;

DOT : '.';

WS : (' ' | '\t')+;
NL : '\n';