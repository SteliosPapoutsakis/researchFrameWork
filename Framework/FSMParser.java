package Framework;// Generated from C:/research/javalib/FSM/src/Framework\FSM.g4 by ANTLR 4.7

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FSMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, AND=12, OR=13, Clk=14, RESET=15, EQUALS=16, GREATERTHAN=17, 
		LESSTHAN=18, NOT=19, INPUT=20, OUTPUT=21, ASSIGN=22, COMMA=23, REG=24, 
		VAR=25, NAME=26, STATENUMBER=27, NEGATIVEINT=28, INT=29, WHITESPACE=30, 
		NEWLINE=31;
	public static final int
		RULE_fsm = 0, RULE_next_state = 1, RULE_condition = 2, RULE_state = 3, 
		RULE_register_assign = 4, RULE_adder_assign = 5, RULE_and_assigment = 6, 
		RULE_or_assigment = 7, RULE_integer = 8, RULE_expression = 9, RULE_register = 10, 
		RULE_var = 11, RULE_var_assign = 12, RULE_var_assigment = 13, RULE_sub_assignment = 14, 
		RULE_mult_assigment = 15, RULE_div_assigment = 16, RULE_reg_assigment = 17, 
		RULE_inputs = 18, RULE_outputs = 19;
	public static final String[] ruleNames = {
		"fsm", "next_state", "condition", "state", "register_assign", "adder_assign", 
		"and_assigment", "or_assigment", "integer", "expression", "register", 
		"var", "var_assign", "var_assigment", "sub_assignment", "mult_assigment", 
		"div_assigment", "reg_assigment", "inputs", "outputs"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Start FSM'", "'End FSM'", "'Next State'", "'if'", "'Define'", 
		"'End'", "'+'", "'Size'", "'-'", "'*'", "'/'", null, null, "'C_'", "'R_'", 
		"'equals'", null, null, null, "'input'", "'output'", null, "','", "'Reg'", 
		"'Var'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"AND", "OR", "Clk", "RESET", "EQUALS", "GREATERTHAN", "LESSTHAN", "NOT", 
		"INPUT", "OUTPUT", "ASSIGN", "COMMA", "REG", "VAR", "NAME", "STATENUMBER", 
		"NEGATIVEINT", "INT", "WHITESPACE", "NEWLINE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FSM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FSMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FsmContext extends ParserRuleContext {
		public InputsContext inputs() {
			return getRuleContext(InputsContext.class,0);
		}
		public OutputsContext outputs() {
			return getRuleContext(OutputsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FSMParser.EOF, 0); }
		public List<StateContext> state() {
			return getRuleContexts(StateContext.class);
		}
		public StateContext state(int i) {
			return getRuleContext(StateContext.class,i);
		}
		public FsmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fsm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener) ((FSMListener)listener).enterFsm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitFsm(this);
		}
	}

	public final FsmContext fsm() throws RecognitionException {
		FsmContext _localctx = new FsmContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fsm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__0);
			setState(41);
			inputs();
			setState(42);
			outputs();
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				state();
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STATENUMBER );
			setState(48);
			match(T__1);
			setState(49);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Next_stateContext extends ParserRuleContext {
		public TerminalNode STATENUMBER() { return getToken(FSMParser.STATENUMBER, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Next_stateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_next_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterNext_state(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitNext_state(this);
		}
	}

	public final Next_stateContext next_state() throws RecognitionException {
		Next_stateContext _localctx = new Next_stateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_next_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__2);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(52);
				condition();
				}
			}

			setState(55);
			match(STATENUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public Token opp;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode GREATERTHAN() { return getToken(FSMParser.GREATERTHAN, 0); }
		public TerminalNode LESSTHAN() { return getToken(FSMParser.LESSTHAN, 0); }
		public TerminalNode EQUALS() { return getToken(FSMParser.EQUALS, 0); }
		public TerminalNode NOT() { return getToken(FSMParser.NOT, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(57);
			match(T__3);
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(58);
				register();
				}
				break;
			case 2:
				{
				setState(59);
				var();
				}
				break;
			}
			setState(62);
			((ConditionContext)_localctx).opp = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << GREATERTHAN) | (1L << LESSTHAN) | (1L << NOT))) != 0)) ) {
				((ConditionContext)_localctx).opp = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(63);
			expression();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StateContext extends ParserRuleContext {
		public TerminalNode STATENUMBER() { return getToken(FSMParser.STATENUMBER, 0); }
		public List<Var_assignContext> var_assign() {
			return getRuleContexts(Var_assignContext.class);
		}
		public Var_assignContext var_assign(int i) {
			return getRuleContext(Var_assignContext.class,i);
		}
		public List<Next_stateContext> next_state() {
			return getRuleContexts(Next_stateContext.class);
		}
		public Next_stateContext next_state(int i) {
			return getRuleContext(Next_stateContext.class,i);
		}
		public List<Register_assignContext> register_assign() {
			return getRuleContexts(Register_assignContext.class);
		}
		public Register_assignContext register_assign(int i) {
			return getRuleContext(Register_assignContext.class,i);
		}
		public List<Adder_assignContext> adder_assign() {
			return getRuleContexts(Adder_assignContext.class);
		}
		public Adder_assignContext adder_assign(int i) {
			return getRuleContext(Adder_assignContext.class,i);
		}
		public StateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterState(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitState(this);
		}
	}

	public final StateContext state() throws RecognitionException {
		StateContext _localctx = new StateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_state);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(STATENUMBER);
			setState(66);
			match(T__4);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << ASSIGN) | (1L << REG) | (1L << VAR))) != 0)) {
				{
				setState(70);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					{
					setState(67);
					register_assign();
					}
					}
					break;
				case 2:
					{
					{
					setState(68);
					adder_assign();
					}
					}
					break;
				case 3:
					{
					setState(69);
					var_assign();
					}
					break;
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(75);
				next_state();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Register_assignContext extends ParserRuleContext {
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public Reg_assigmentContext reg_assigment() {
			return getRuleContext(Reg_assigmentContext.class,0);
		}
		public Adder_assignContext adder_assign() {
			return getRuleContext(Adder_assignContext.class,0);
		}
		public Sub_assignmentContext sub_assignment() {
			return getRuleContext(Sub_assignmentContext.class,0);
		}
		public Mult_assigmentContext mult_assigment() {
			return getRuleContext(Mult_assigmentContext.class,0);
		}
		public Div_assigmentContext div_assigment() {
			return getRuleContext(Div_assigmentContext.class,0);
		}
		public And_assigmentContext and_assigment() {
			return getRuleContext(And_assigmentContext.class,0);
		}
		public Or_assigmentContext or_assigment() {
			return getRuleContext(Or_assigmentContext.class,0);
		}
		public Register_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterRegister_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitRegister_assign(this);
		}
	}

	public final Register_assignContext register_assign() throws RecognitionException {
		Register_assignContext _localctx = new Register_assignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_register_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			register();
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(84);
				reg_assigment();
				}
				break;
			case 2:
				{
				setState(85);
				adder_assign();
				}
				break;
			case 3:
				{
				setState(86);
				sub_assignment();
				}
				break;
			case 4:
				{
				setState(87);
				mult_assigment();
				}
				break;
			case 5:
				{
				setState(88);
				div_assigment();
				}
				break;
			case 6:
				{
				setState(89);
				and_assigment();
				}
				break;
			case 7:
				{
				setState(90);
				or_assigment();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Adder_assignContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(FSMParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Adder_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adder_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterAdder_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitAdder_assign(this);
		}
	}

	public final Adder_assignContext adder_assign() throws RecognitionException {
		Adder_assignContext _localctx = new Adder_assignContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_adder_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(ASSIGN);
			setState(94);
			expression();
			setState(95);
			match(T__6);
			setState(96);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class And_assigmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(FSMParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(FSMParser.AND, 0); }
		public And_assigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_assigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterAnd_assigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitAnd_assigment(this);
		}
	}

	public final And_assigmentContext and_assigment() throws RecognitionException {
		And_assigmentContext _localctx = new And_assigmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_and_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(ASSIGN);
			setState(99);
			expression();
			setState(100);
			match(AND);
			setState(101);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_assigmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(FSMParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(FSMParser.OR, 0); }
		public Or_assigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_assigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterOr_assigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitOr_assigment(this);
		}
	}

	public final Or_assigmentContext or_assigment() throws RecognitionException {
		Or_assigmentContext _localctx = new Or_assigmentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_or_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(ASSIGN);
			setState(104);
			expression();
			setState(105);
			match(OR);
			setState(106);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public Token opp;
		public TerminalNode INT() { return getToken(FSMParser.INT, 0); }
		public TerminalNode NEGATIVEINT() { return getToken(FSMParser.NEGATIVEINT, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			((IntegerContext)_localctx).opp = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==NEGATIVEINT || _la==INT) ) {
				((IntegerContext)_localctx).opp = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(110);
				integer();
				}
				break;
			case 2:
				{
				setState(111);
				register();
				}
				break;
			case 3:
				{
				setState(112);
				var();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegisterContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(FSMParser.NAME, 0); }
		public TerminalNode INT() { return getToken(FSMParser.INT, 0); }
		public RegisterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_register; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterRegister(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitRegister(this);
		}
	}

	public final RegisterContext register() throws RecognitionException {
		RegisterContext _localctx = new RegisterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_register);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(115);
				match(T__7);
				setState(116);
				match(INT);
				}
			}

			setState(119);
			match(REG);
			setState(120);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(FSMParser.NAME, 0); }
		public TerminalNode INT() { return getToken(FSMParser.INT, 0); }
		public TerminalNode Clk() { return getToken(FSMParser.Clk, 0); }
		public TerminalNode RESET() { return getToken(FSMParser.RESET, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(122);
				match(T__7);
				setState(123);
				match(INT);
				}
			}

			setState(126);
			match(VAR);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Clk) {
				{
				setState(127);
				match(Clk);
				}
			}

			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RESET) {
				{
				setState(130);
				match(RESET);
				}
			}

			setState(133);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_assignContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public Var_assigmentContext var_assigment() {
			return getRuleContext(Var_assigmentContext.class,0);
		}
		public Var_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterVar_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitVar_assign(this);
		}
	}

	public final Var_assignContext var_assign() throws RecognitionException {
		Var_assignContext _localctx = new Var_assignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_var_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			var();
			{
			setState(136);
			var_assigment();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_assigmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(FSMParser.ASSIGN, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Var_assigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_assigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterVar_assigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitVar_assigment(this);
		}
	}

	public final Var_assigmentContext var_assigment() throws RecognitionException {
		Var_assigmentContext _localctx = new Var_assigmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_var_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(ASSIGN);
			{
			setState(139);
			integer();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sub_assignmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(FSMParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Sub_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sub_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterSub_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitSub_assignment(this);
		}
	}

	public final Sub_assignmentContext sub_assignment() throws RecognitionException {
		Sub_assignmentContext _localctx = new Sub_assignmentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sub_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(ASSIGN);
			setState(142);
			expression();
			setState(143);
			match(T__8);
			setState(144);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Mult_assigmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(FSMParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Mult_assigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult_assigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterMult_assigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitMult_assigment(this);
		}
	}

	public final Mult_assigmentContext mult_assigment() throws RecognitionException {
		Mult_assigmentContext _localctx = new Mult_assigmentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mult_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(ASSIGN);
			setState(147);
			expression();
			setState(148);
			match(T__9);
			setState(149);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Div_assigmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(FSMParser.ASSIGN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Div_assigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_div_assigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterDiv_assigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitDiv_assigment(this);
		}
	}

	public final Div_assigmentContext div_assigment() throws RecognitionException {
		Div_assigmentContext _localctx = new Div_assigmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_div_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(ASSIGN);
			setState(152);
			expression();
			setState(153);
			match(T__10);
			setState(154);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Reg_assigmentContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(FSMParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Reg_assigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reg_assigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterReg_assigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitReg_assigment(this);
		}
	}

	public final Reg_assigmentContext reg_assigment() throws RecognitionException {
		Reg_assigmentContext _localctx = new Reg_assigmentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_reg_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ASSIGN);
			setState(157);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputsContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(FSMParser.INPUT, 0); }
		public List<RegisterContext> register() {
			return getRuleContexts(RegisterContext.class);
		}
		public RegisterContext register(int i) {
			return getRuleContext(RegisterContext.class,i);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public InputsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterInputs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitInputs(this);
		}
	}

	public final InputsContext inputs() throws RecognitionException {
		InputsContext _localctx = new InputsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_inputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(INPUT);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << REG) | (1L << VAR))) != 0)) {
				{
				setState(162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(160);
					register();
					}
					break;
				case 2:
					{
					setState(161);
					var();
					}
					break;
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputsContext extends ParserRuleContext {
		public TerminalNode OUTPUT() { return getToken(FSMParser.OUTPUT, 0); }
		public List<RegisterContext> register() {
			return getRuleContexts(RegisterContext.class);
		}
		public RegisterContext register(int i) {
			return getRuleContext(RegisterContext.class,i);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public OutputsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterOutputs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitOutputs(this);
		}
	}

	public final OutputsContext outputs() throws RecognitionException {
		OutputsContext _localctx = new OutputsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_outputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(OUTPUT);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << REG) | (1L << VAR))) != 0)) {
				{
				setState(170);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(168);
					register();
					}
					break;
				case 2:
					{
					setState(169);
					var();
					}
					break;
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00b2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\6\2/\n\2\r\2\16\2\60\3"+
		"\2\3\2\3\2\3\3\3\3\5\38\n\3\3\3\3\3\3\4\3\4\3\4\5\4?\n\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\5\7\5O\n\5\f\5\16\5R\13\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6^\n\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\5\13t"+
		"\n\13\3\f\3\f\5\fx\n\f\3\f\3\f\3\f\3\r\3\r\5\r\177\n\r\3\r\3\r\5\r\u0083"+
		"\n\r\3\r\5\r\u0086\n\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\7\24\u00a5\n\24\f\24\16\24\u00a8\13\24\3\25"+
		"\3\25\3\25\7\25\u00ad\n\25\f\25\16\25\u00b0\13\25\3\25\2\2\26\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\4\3\2\22\25\3\2\36\37\2\u00b4"+
		"\2*\3\2\2\2\4\65\3\2\2\2\6;\3\2\2\2\bC\3\2\2\2\nU\3\2\2\2\f_\3\2\2\2\16"+
		"d\3\2\2\2\20i\3\2\2\2\22n\3\2\2\2\24s\3\2\2\2\26w\3\2\2\2\30~\3\2\2\2"+
		"\32\u0089\3\2\2\2\34\u008c\3\2\2\2\36\u008f\3\2\2\2 \u0094\3\2\2\2\"\u0099"+
		"\3\2\2\2$\u009e\3\2\2\2&\u00a1\3\2\2\2(\u00a9\3\2\2\2*+\7\3\2\2+,\5&\24"+
		"\2,.\5(\25\2-/\5\b\5\2.-\3\2\2\2/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2"+
		"\61\62\3\2\2\2\62\63\7\4\2\2\63\64\7\2\2\3\64\3\3\2\2\2\65\67\7\5\2\2"+
		"\668\5\6\4\2\67\66\3\2\2\2\678\3\2\2\289\3\2\2\29:\7\35\2\2:\5\3\2\2\2"+
		";>\7\6\2\2<?\5\26\f\2=?\5\30\r\2><\3\2\2\2>=\3\2\2\2?@\3\2\2\2@A\t\2\2"+
		"\2AB\5\24\13\2B\7\3\2\2\2CD\7\35\2\2DJ\7\7\2\2EI\5\n\6\2FI\5\f\7\2GI\5"+
		"\32\16\2HE\3\2\2\2HF\3\2\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K"+
		"P\3\2\2\2LJ\3\2\2\2MO\5\4\3\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2"+
		"QS\3\2\2\2RP\3\2\2\2ST\7\b\2\2T\t\3\2\2\2U]\5\26\f\2V^\5$\23\2W^\5\f\7"+
		"\2X^\5\36\20\2Y^\5 \21\2Z^\5\"\22\2[^\5\16\b\2\\^\5\20\t\2]V\3\2\2\2]"+
		"W\3\2\2\2]X\3\2\2\2]Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^\13\3\2\2"+
		"\2_`\7\30\2\2`a\5\24\13\2ab\7\t\2\2bc\5\24\13\2c\r\3\2\2\2de\7\30\2\2"+
		"ef\5\24\13\2fg\7\16\2\2gh\5\24\13\2h\17\3\2\2\2ij\7\30\2\2jk\5\24\13\2"+
		"kl\7\17\2\2lm\5\24\13\2m\21\3\2\2\2no\t\3\2\2o\23\3\2\2\2pt\5\22\n\2q"+
		"t\5\26\f\2rt\5\30\r\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2t\25\3\2\2\2uv\7\n"+
		"\2\2vx\7\37\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\32\2\2z{\7\34\2\2{\27"+
		"\3\2\2\2|}\7\n\2\2}\177\7\37\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080\u0082\7\33\2\2\u0081\u0083\7\20\2\2\u0082\u0081\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0086\7\21\2\2\u0085\u0084\3"+
		"\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\34\2\2\u0088"+
		"\31\3\2\2\2\u0089\u008a\5\30\r\2\u008a\u008b\5\34\17\2\u008b\33\3\2\2"+
		"\2\u008c\u008d\7\30\2\2\u008d\u008e\5\22\n\2\u008e\35\3\2\2\2\u008f\u0090"+
		"\7\30\2\2\u0090\u0091\5\24\13\2\u0091\u0092\7\13\2\2\u0092\u0093\5\24"+
		"\13\2\u0093\37\3\2\2\2\u0094\u0095\7\30\2\2\u0095\u0096\5\24\13\2\u0096"+
		"\u0097\7\f\2\2\u0097\u0098\5\24\13\2\u0098!\3\2\2\2\u0099\u009a\7\30\2"+
		"\2\u009a\u009b\5\24\13\2\u009b\u009c\7\r\2\2\u009c\u009d\5\24\13\2\u009d"+
		"#\3\2\2\2\u009e\u009f\7\30\2\2\u009f\u00a0\5\24\13\2\u00a0%\3\2\2\2\u00a1"+
		"\u00a6\7\26\2\2\u00a2\u00a5\5\26\f\2\u00a3\u00a5\5\30\r\2\u00a4\u00a2"+
		"\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\'\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ae\7\27\2"+
		"\2\u00aa\u00ad\5\26\f\2\u00ab\u00ad\5\30\r\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af)\3\2\2\2\u00b0\u00ae\3\2\2\2\22\60\67>HJP]sw~\u0082\u0085\u00a4"+
		"\u00a6\u00ac\u00ae";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}