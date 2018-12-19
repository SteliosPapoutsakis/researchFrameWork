// Generated from C:/research/javalib/FSM/src/Framework\FSM.g4 by ANTLR 4.7
package Framework;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FSMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, Clk=12, RESET=13, EQUALS=14, GREATERTHAN=15, LESSTHAN=16, 
		NOT=17, INPUT=18, OUTPUT=19, ASSIGN=20, COMMA=21, REG=22, VAR=23, NAME=24, 
		STATENUMBER=25, NEGATIVEINT=26, INT=27, WHITESPACE=28, NEWLINE=29;
	public static final int
		RULE_fsm = 0, RULE_next_state = 1, RULE_condition = 2, RULE_state = 3, 
		RULE_register_assign = 4, RULE_adder_assign = 5, RULE_integer = 6, RULE_component = 7, 
		RULE_register = 8, RULE_var = 9, RULE_var_assign = 10, RULE_var_assigment = 11, 
		RULE_sub_assignment = 12, RULE_mult_assigment = 13, RULE_div_assigment = 14, 
		RULE_reg_assigment = 15, RULE_inputs = 16, RULE_outputs = 17;
	public static final String[] ruleNames = {
		"fsm", "next_state", "condition", "state", "register_assign", "adder_assign", 
		"integer", "component", "register", "var", "var_assign", "var_assigment", 
		"sub_assignment", "mult_assigment", "div_assigment", "reg_assigment", 
		"inputs", "outputs"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Start FSM'", "'End FSM'", "'Next State'", "'if'", "'Define'", 
		"'End'", "'+'", "'Size'", "'-'", "'*'", "'/'", "'C_'", "'R_'", "'equals'", 
		null, null, null, "'input'", "'output'", null, "','", "'Reg'", "'Var'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"Clk", "RESET", "EQUALS", "GREATERTHAN", "LESSTHAN", "NOT", "INPUT", "OUTPUT", 
		"ASSIGN", "COMMA", "REG", "VAR", "NAME", "STATENUMBER", "NEGATIVEINT", 
		"INT", "WHITESPACE", "NEWLINE"
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
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterFsm(this);
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
			setState(36);
			match(T__0);
			setState(37);
			inputs();
			setState(38);
			outputs();
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				state();
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STATENUMBER );
			setState(44);
			match(T__1);
			setState(45);
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
			setState(47);
			match(T__2);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(48);
				condition();
				}
			}

			setState(51);
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
		public ComponentContext component() {
			return getRuleContext(ComponentContext.class,0);
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
			setState(53);
			match(T__3);
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(54);
				register();
				}
				break;
			case 2:
				{
				setState(55);
				var();
				}
				break;
			}
			setState(58);
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
			setState(59);
			component();
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
			setState(61);
			match(STATENUMBER);
			setState(62);
			match(T__4);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << ASSIGN) | (1L << REG) | (1L << VAR))) != 0)) {
				{
				setState(66);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					{
					setState(63);
					register_assign();
					}
					}
					break;
				case 2:
					{
					{
					setState(64);
					adder_assign();
					}
					}
					break;
				case 3:
					{
					setState(65);
					var_assign();
					}
					break;
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(71);
				next_state();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
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
			setState(79);
			register();
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(80);
				reg_assigment();
				}
				break;
			case 2:
				{
				setState(81);
				adder_assign();
				}
				break;
			case 3:
				{
				setState(82);
				sub_assignment();
				}
				break;
			case 4:
				{
				setState(83);
				mult_assigment();
				}
				break;
			case 5:
				{
				setState(84);
				div_assigment();
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
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
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
			setState(87);
			match(ASSIGN);
			setState(88);
			component();
			setState(89);
			match(T__6);
			setState(90);
			component();
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
		enterRule(_localctx, 12, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
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

	public static class ComponentContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).enterComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FSMListener ) ((FSMListener)listener).exitComponent(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_component);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(94);
				integer();
				}
				break;
			case 2:
				{
				setState(95);
				register();
				}
				break;
			case 3:
				{
				setState(96);
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
		enterRule(_localctx, 16, RULE_register);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(99);
				match(T__7);
				setState(100);
				match(INT);
				}
			}

			setState(103);
			match(REG);
			setState(104);
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
		enterRule(_localctx, 18, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(106);
				match(T__7);
				setState(107);
				match(INT);
				}
			}

			setState(110);
			match(VAR);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Clk) {
				{
				setState(111);
				match(Clk);
				}
			}

			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RESET) {
				{
				setState(114);
				match(RESET);
				}
			}

			setState(117);
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
		enterRule(_localctx, 20, RULE_var_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			var();
			{
			setState(120);
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
		enterRule(_localctx, 22, RULE_var_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ASSIGN);
			{
			setState(123);
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
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
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
		enterRule(_localctx, 24, RULE_sub_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(ASSIGN);
			setState(126);
			component();
			setState(127);
			match(T__8);
			setState(128);
			component();
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
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
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
		enterRule(_localctx, 26, RULE_mult_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(ASSIGN);
			setState(131);
			component();
			setState(132);
			match(T__9);
			setState(133);
			component();
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
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
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
		enterRule(_localctx, 28, RULE_div_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(ASSIGN);
			setState(136);
			component();
			setState(137);
			match(T__10);
			setState(138);
			component();
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
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public RegisterContext register() {
			return getRuleContext(RegisterContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
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
		enterRule(_localctx, 30, RULE_reg_assigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(ASSIGN);
			setState(144);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(141);
				integer();
				}
				break;
			case 2:
				{
				setState(142);
				register();
				}
				break;
			case 3:
				{
				setState(143);
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
		enterRule(_localctx, 32, RULE_inputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(INPUT);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << REG) | (1L << VAR))) != 0)) {
				{
				setState(149);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(147);
					register();
					}
					break;
				case 2:
					{
					setState(148);
					var();
					}
					break;
				}
				}
				setState(153);
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
		enterRule(_localctx, 34, RULE_outputs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(OUTPUT);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << REG) | (1L << VAR))) != 0)) {
				{
				setState(157);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(155);
					register();
					}
					break;
				case 2:
					{
					setState(156);
					var();
					}
					break;
				}
				}
				setState(161);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u00a5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\6\2+\n\2\r\2\16\2,\3\2\3\2\3\2\3\3\3\3\5\3"+
		"\64\n\3\3\3\3\3\3\4\3\4\3\4\5\4;\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\7"+
		"\5E\n\5\f\5\16\5H\13\5\3\5\7\5K\n\5\f\5\16\5N\13\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6X\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\5\td\n\t"+
		"\3\n\3\n\5\nh\n\n\3\n\3\n\3\n\3\13\3\13\5\13o\n\13\3\13\3\13\5\13s\n\13"+
		"\3\13\5\13v\n\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\5\21\u0093\n\21\3\22\3\22\3\22\7\22\u0098\n\22\f\22\16\22\u009b"+
		"\13\22\3\23\3\23\3\23\7\23\u00a0\n\23\f\23\16\23\u00a3\13\23\3\23\2\2"+
		"\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\3\2\20\23\3\2\34\35"+
		"\2\u00a9\2&\3\2\2\2\4\61\3\2\2\2\6\67\3\2\2\2\b?\3\2\2\2\nQ\3\2\2\2\f"+
		"Y\3\2\2\2\16^\3\2\2\2\20c\3\2\2\2\22g\3\2\2\2\24n\3\2\2\2\26y\3\2\2\2"+
		"\30|\3\2\2\2\32\177\3\2\2\2\34\u0084\3\2\2\2\36\u0089\3\2\2\2 \u008e\3"+
		"\2\2\2\"\u0094\3\2\2\2$\u009c\3\2\2\2&\'\7\3\2\2\'(\5\"\22\2(*\5$\23\2"+
		")+\5\b\5\2*)\3\2\2\2+,\3\2\2\2,*\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\4\2\2"+
		"/\60\7\2\2\3\60\3\3\2\2\2\61\63\7\5\2\2\62\64\5\6\4\2\63\62\3\2\2\2\63"+
		"\64\3\2\2\2\64\65\3\2\2\2\65\66\7\33\2\2\66\5\3\2\2\2\67:\7\6\2\28;\5"+
		"\22\n\29;\5\24\13\2:8\3\2\2\2:9\3\2\2\2;<\3\2\2\2<=\t\2\2\2=>\5\20\t\2"+
		">\7\3\2\2\2?@\7\33\2\2@F\7\7\2\2AE\5\n\6\2BE\5\f\7\2CE\5\26\f\2DA\3\2"+
		"\2\2DB\3\2\2\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GL\3\2\2\2HF\3\2"+
		"\2\2IK\5\4\3\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2"+
		"\2\2OP\7\b\2\2P\t\3\2\2\2QW\5\22\n\2RX\5 \21\2SX\5\f\7\2TX\5\32\16\2U"+
		"X\5\34\17\2VX\5\36\20\2WR\3\2\2\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2"+
		"\2\2X\13\3\2\2\2YZ\7\26\2\2Z[\5\20\t\2[\\\7\t\2\2\\]\5\20\t\2]\r\3\2\2"+
		"\2^_\t\3\2\2_\17\3\2\2\2`d\5\16\b\2ad\5\22\n\2bd\5\24\13\2c`\3\2\2\2c"+
		"a\3\2\2\2cb\3\2\2\2d\21\3\2\2\2ef\7\n\2\2fh\7\35\2\2ge\3\2\2\2gh\3\2\2"+
		"\2hi\3\2\2\2ij\7\30\2\2jk\7\32\2\2k\23\3\2\2\2lm\7\n\2\2mo\7\35\2\2nl"+
		"\3\2\2\2no\3\2\2\2op\3\2\2\2pr\7\31\2\2qs\7\16\2\2rq\3\2\2\2rs\3\2\2\2"+
		"su\3\2\2\2tv\7\17\2\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\7\32\2\2x\25\3\2"+
		"\2\2yz\5\24\13\2z{\5\30\r\2{\27\3\2\2\2|}\7\26\2\2}~\5\16\b\2~\31\3\2"+
		"\2\2\177\u0080\7\26\2\2\u0080\u0081\5\20\t\2\u0081\u0082\7\13\2\2\u0082"+
		"\u0083\5\20\t\2\u0083\33\3\2\2\2\u0084\u0085\7\26\2\2\u0085\u0086\5\20"+
		"\t\2\u0086\u0087\7\f\2\2\u0087\u0088\5\20\t\2\u0088\35\3\2\2\2\u0089\u008a"+
		"\7\26\2\2\u008a\u008b\5\20\t\2\u008b\u008c\7\r\2\2\u008c\u008d\5\20\t"+
		"\2\u008d\37\3\2\2\2\u008e\u0092\7\26\2\2\u008f\u0093\5\16\b\2\u0090\u0093"+
		"\5\22\n\2\u0091\u0093\5\24\13\2\u0092\u008f\3\2\2\2\u0092\u0090\3\2\2"+
		"\2\u0092\u0091\3\2\2\2\u0093!\3\2\2\2\u0094\u0099\7\24\2\2\u0095\u0098"+
		"\5\22\n\2\u0096\u0098\5\24\13\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2\2"+
		"\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a#"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u00a1\7\25\2\2\u009d\u00a0\5\22\n\2"+
		"\u009e\u00a0\5\24\13\2\u009f\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3"+
		"\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2%\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\23,\63:DFLWcgnru\u0092\u0097\u0099\u009f\u00a1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}