grammar Regex;

@header {
   package it.unicam.cs.cmp.parser.generated;
}

expr
:
	union EOF	# unionEOF
;

union
:
	union PLUS concat	# unionMatch
	| concat # unionConcat
;

concat
:
	concat kleene # concatMatch
	| kleene # concatKleene
;

kleene
:
	term KLEENE	# kleeneMatch
	| term # kleeneTerm
;

term
:
	LETTER		# termLetter
	| DIGIT			# termDigit
	| EPSILON		# termEpsilon
	| '(' union ')'	# termParenthesis
;

EPSILON:	'epsilon' ;
LETTER:		[a-zA-Z] ;
DIGIT:		[0-9];
PLUS:		'+';
KLEENE:		'*';
WS
:
	[ \t\r\n]+ -> skip
; // toss out whitespace
