// Generated from C:/research/javalib/FSM/src/Framework\FSM.g4 by ANTLR 4.7
package Framework;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FSMLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "UPPERCASE", "LOWERCASE", "AND", "OR", "Clk", "RESET", 
		"EQUALS", "GREATERTHAN", "LESSTHAN", "NOT", "INPUT", "OUTPUT", "ASSIGN", 
		"COMMA", "REG", "VAR", "NAME", "STATENUMBER", "NEGATIVEINT", "INT", "WHITESPACE", 
		"NEWLINE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'Start FSM'", "'End FSM'", "'Next State'", "'if'", "'Define'", 
		"'End'", "'+'", "'Size'", "'-'", "'*'", "'/'", null, null, "'C_'", "'R_'", 
		null, null, null, null, "'input'", "'output'", null, "','", "'Reg'", "'Var'"
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


	public FSMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FSM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u0114\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u008a\n\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0092"+
		"\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u00a2\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u00b1\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u00bd\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\5\26\u00cb\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00e1"+
		"\n\31\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\6\35"+
		"\u00ef\n\35\r\35\16\35\u00f0\3\35\7\35\u00f4\n\35\f\35\16\35\u00f7\13"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\6\36\u0101\n\36\r\36\16\36"+
		"\u0102\3\37\3\37\3\37\3 \6 \u0109\n \r \16 \u010a\3!\3!\3!\3!\3\"\3\""+
		"\3\"\3\"\2\2#\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\2"+
		"\33\2\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31\65\32\67"+
		"\339\34;\35=\36?\37A C!\3\2\4\4\2\13\13\"\"\4\2\f\f\17\17\2\u011f\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5O\3\2\2\2\7W\3\2\2\2\tb\3\2\2\2\13e\3"+
		"\2\2\2\rl\3\2\2\2\17p\3\2\2\2\21r\3\2\2\2\23w\3\2\2\2\25y\3\2\2\2\27{"+
		"\3\2\2\2\31}\3\2\2\2\33\177\3\2\2\2\35\u0089\3\2\2\2\37\u0091\3\2\2\2"+
		"!\u0093\3\2\2\2#\u0096\3\2\2\2%\u00a1\3\2\2\2\'\u00b0\3\2\2\2)\u00bc\3"+
		"\2\2\2+\u00ca\3\2\2\2-\u00cc\3\2\2\2/\u00d2\3\2\2\2\61\u00e0\3\2\2\2\63"+
		"\u00e2\3\2\2\2\65\u00e4\3\2\2\2\67\u00e8\3\2\2\29\u00ee\3\2\2\2;\u00f8"+
		"\3\2\2\2=\u0104\3\2\2\2?\u0108\3\2\2\2A\u010c\3\2\2\2C\u0110\3\2\2\2E"+
		"F\7U\2\2FG\7v\2\2GH\7c\2\2HI\7t\2\2IJ\7v\2\2JK\7\"\2\2KL\7H\2\2LM\7U\2"+
		"\2MN\7O\2\2N\4\3\2\2\2OP\7G\2\2PQ\7p\2\2QR\7f\2\2RS\7\"\2\2ST\7H\2\2T"+
		"U\7U\2\2UV\7O\2\2V\6\3\2\2\2WX\7P\2\2XY\7g\2\2YZ\7z\2\2Z[\7v\2\2[\\\7"+
		"\"\2\2\\]\7U\2\2]^\7v\2\2^_\7c\2\2_`\7v\2\2`a\7g\2\2a\b\3\2\2\2bc\7k\2"+
		"\2cd\7h\2\2d\n\3\2\2\2ef\7F\2\2fg\7g\2\2gh\7h\2\2hi\7k\2\2ij\7p\2\2jk"+
		"\7g\2\2k\f\3\2\2\2lm\7G\2\2mn\7p\2\2no\7f\2\2o\16\3\2\2\2pq\7-\2\2q\20"+
		"\3\2\2\2rs\7U\2\2st\7k\2\2tu\7|\2\2uv\7g\2\2v\22\3\2\2\2wx\7/\2\2x\24"+
		"\3\2\2\2yz\7,\2\2z\26\3\2\2\2{|\7\61\2\2|\30\3\2\2\2}~\4C\\\2~\32\3\2"+
		"\2\2\177\u0080\4c|\2\u0080\34\3\2\2\2\u0081\u0082\7c\2\2\u0082\u0083\7"+
		"p\2\2\u0083\u008a\7f\2\2\u0084\u0085\7C\2\2\u0085\u0086\7p\2\2\u0086\u008a"+
		"\7f\2\2\u0087\u0088\7(\2\2\u0088\u008a\7(\2\2\u0089\u0081\3\2\2\2\u0089"+
		"\u0084\3\2\2\2\u0089\u0087\3\2\2\2\u008a\36\3\2\2\2\u008b\u008c\7q\2\2"+
		"\u008c\u0092\7t\2\2\u008d\u008e\7Q\2\2\u008e\u0092\7t\2\2\u008f\u0090"+
		"\7~\2\2\u0090\u0092\7~\2\2\u0091\u008b\3\2\2\2\u0091\u008d\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092 \3\2\2\2\u0093\u0094\7E\2\2\u0094\u0095\7a\2\2\u0095"+
		"\"\3\2\2\2\u0096\u0097\7T\2\2\u0097\u0098\7a\2\2\u0098$\3\2\2\2\u0099"+
		"\u009a\7g\2\2\u009a\u009b\7s\2\2\u009b\u009c\7w\2\2\u009c\u009d\7c\2\2"+
		"\u009d\u009e\7n\2\2\u009e\u00a2\7u\2\2\u009f\u00a0\7?\2\2\u00a0\u00a2"+
		"\7?\2\2\u00a1\u0099\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2&\3\2\2\2\u00a3\u00a4"+
		"\7i\2\2\u00a4\u00a5\7t\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7c\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7\"\2"+
		"\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7c\2\2\u00ae\u00b1"+
		"\7p\2\2\u00af\u00b1\7@\2\2\u00b0\u00a3\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1"+
		"(\3\2\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7u\2\2\u00b5"+
		"\u00b6\7u\2\2\u00b6\u00b7\7\"\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7j\2"+
		"\2\u00b9\u00ba\7c\2\2\u00ba\u00bd\7p\2\2\u00bb\u00bd\7>\2\2\u00bc\u00b2"+
		"\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd*\3\2\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0"+
		"\7q\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2\7\"\2\2\u00c2\u00c3\7g\2\2\u00c3"+
		"\u00c4\7s\2\2\u00c4\u00c5\7w\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7n\2\2"+
		"\u00c7\u00cb\7u\2\2\u00c8\u00c9\7\u0080\2\2\u00c9\u00cb\7?\2\2\u00ca\u00be"+
		"\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb,\3\2\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce"+
		"\7p\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7w\2\2\u00d0\u00d1\7v\2\2\u00d1"+
		".\3\2\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7w\2\2\u00d4\u00d5\7v\2\2\u00d5"+
		"\u00d6\7r\2\2\u00d6\u00d7\7w\2\2\u00d7\u00d8\7v\2\2\u00d8\60\3\2\2\2\u00d9"+
		"\u00da\7C\2\2\u00da\u00db\7u\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7k\2\2"+
		"\u00dd\u00de\7i\2\2\u00de\u00e1\7p\2\2\u00df\u00e1\7?\2\2\u00e0\u00d9"+
		"\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\62\3\2\2\2\u00e2\u00e3\7.\2\2\u00e3"+
		"\64\3\2\2\2\u00e4\u00e5\7T\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7i\2\2\u00e7"+
		"\66\3\2\2\2\u00e8\u00e9\7X\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7t\2\2\u00eb"+
		"8\3\2\2\2\u00ec\u00ef\5\31\r\2\u00ed\u00ef\5\33\16\2\u00ee\u00ec\3\2\2"+
		"\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00f5\3\2\2\2\u00f2\u00f4\5? \2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6:\3\2\2\2"+
		"\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7U\2\2\u00f9\u00fa\7v\2\2\u00fa\u00fb"+
		"\7c\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7<\2\2\u00fe"+
		"\u0100\3\2\2\2\u00ff\u0101\5? \2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2"+
		"\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103<\3\2\2\2\u0104\u0105"+
		"\7/\2\2\u0105\u0106\5? \2\u0106>\3\2\2\2\u0107\u0109\4\62;\2\u0108\u0107"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"@\3\2\2\2\u010c\u010d\t\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\b!\2\2\u010f"+
		"B\3\2\2\2\u0110\u0111\t\3\2\2\u0111\u0112\3\2\2\2\u0112\u0113\b\"\2\2"+
		"\u0113D\3\2\2\2\17\2\u0089\u0091\u00a1\u00b0\u00bc\u00ca\u00e0\u00ee\u00f0"+
		"\u00f5\u0102\u010a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}