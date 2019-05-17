grammar FSM;

fsm: 'Start FSM' inputs outputs
(state )+ 'End FSM' EOF;

next_state: 'Next State' condition? STATENUMBER ;

condition: ('if' (register|var)
           opp=(GREATERTHAN|LESSTHAN|EQUALS|NOT) expression);

state: STATENUMBER 'Define' ((register_assign)
|(adder_assign)
 | var_assign)* next_state* 'End'
 ;

register_assign: register (reg_assigment|adder_assign|sub_assignment|mult_assigment|div_assigment|and_assigment|or_assigment);

adder_assign: ASSIGN  expression '+' expression;

and_assigment: ASSIGN expression AND expression;

or_assigment: ASSIGN expression OR expression;


integer: opp=(INT|NEGATIVEINT);

expression: (integer|register|var);
register: ('Size' INT)? 'Reg' NAME;

var: ('Size' INT)? 'Var'  Clk? RESET?  NAME;

var_assign: var (var_assigment);

var_assigment: ASSIGN (integer);

sub_assignment: ASSIGN expression '-' expression;

mult_assigment: ASSIGN expression'*' expression;

div_assigment: ASSIGN expression '/' expression;

reg_assigment: ASSIGN expression;

inputs:  INPUT (register|var)* ;
outputs: OUTPUT(register|var)*;

fragment UPPERCASE: ('A'..'Z');
fragment LOWERCASE: ('a'..'z');
AND: 'and' | 'And' | '&&';
OR: 'or' | 'Or' | '||';
Clk: 'C_';
RESET: 'R_';
EQUALS: 'equals' | '==';
GREATERTHAN: 'greater than' | '>';
LESSTHAN: 'less than' | '<';
NOT: 'not equals' | '~=';
INPUT: 'input';
OUTPUT: 'output';
ASSIGN: 'Assign' | '=';
COMMA: ',';
REG: 'Reg';
VAR: 'Var';
NAME: (UPPERCASE |LOWERCASE)+(INT)*;
STATENUMBER: 'State:' INT+;
NEGATIVEINT : '-'INT;
INT: ('0'..'9')+;


WHITESPACE: (' '|'\t') ->skip;
NEWLINE: ('\n'|'\r') ->skip;


