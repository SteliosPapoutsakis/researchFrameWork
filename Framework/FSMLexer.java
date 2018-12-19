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
		T__9=10, T__10=11, Clk=12, RESET=13, EQUALS=14, GREATERTHAN=15, LESSTHAN=16, 
		NOT=17, INPUT=18, OUTPUT=19, ASSIGN=20, COMMA=21, REG=22, VAR=23, NAME=24, 
		STATENUMBER=25, NEGATIVEINT=26, INT=27, WHITESPACE=28, NEWLINE=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "UPPERCASE", "LOWERCASE", "Clk", "RESET", "EQUALS", "GREATERTHAN", 
		"LESSTHAN", "NOT", "INPUT", "OUTPUT", "ASSIGN", "COMMA", "REG", "VAR", 
		"NAME", "STATENUMBER", "NEGATIVEINT", "INT", "WHITESPACE", "NEWLINE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00fb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0098\n\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00a4\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00b2\n\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u00c8\n\27\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\6\33\u00d6\n\33\r\33\16\33\u00d7\3\33\7\33\u00db\n\33\f\33\16\33"+
		"\u00de\13\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\6\34\u00e8\n\34\r"+
		"\34\16\34\u00e9\3\35\3\35\3\35\3\36\6\36\u00f0\n\36\r\36\16\36\u00f1\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\2\33\2\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27"+
		"\61\30\63\31\65\32\67\339\34;\35=\36?\37\3\2\4\4\2\13\13\"\"\4\2\f\f\17"+
		"\17\2\u0101\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\3A\3\2\2\2\5K\3\2\2\2\7S\3\2\2\2\t^\3\2\2\2\13a\3\2\2\2\r"+
		"h\3\2\2\2\17l\3\2\2\2\21n\3\2\2\2\23s\3\2\2\2\25u\3\2\2\2\27w\3\2\2\2"+
		"\31y\3\2\2\2\33{\3\2\2\2\35}\3\2\2\2\37\u0080\3\2\2\2!\u0083\3\2\2\2#"+
		"\u0097\3\2\2\2%\u00a3\3\2\2\2\'\u00b1\3\2\2\2)\u00b3\3\2\2\2+\u00b9\3"+
		"\2\2\2-\u00c7\3\2\2\2/\u00c9\3\2\2\2\61\u00cb\3\2\2\2\63\u00cf\3\2\2\2"+
		"\65\u00d5\3\2\2\2\67\u00df\3\2\2\29\u00eb\3\2\2\2;\u00ef\3\2\2\2=\u00f3"+
		"\3\2\2\2?\u00f7\3\2\2\2AB\7U\2\2BC\7v\2\2CD\7c\2\2DE\7t\2\2EF\7v\2\2F"+
		"G\7\"\2\2GH\7H\2\2HI\7U\2\2IJ\7O\2\2J\4\3\2\2\2KL\7G\2\2LM\7p\2\2MN\7"+
		"f\2\2NO\7\"\2\2OP\7H\2\2PQ\7U\2\2QR\7O\2\2R\6\3\2\2\2ST\7P\2\2TU\7g\2"+
		"\2UV\7z\2\2VW\7v\2\2WX\7\"\2\2XY\7U\2\2YZ\7v\2\2Z[\7c\2\2[\\\7v\2\2\\"+
		"]\7g\2\2]\b\3\2\2\2^_\7k\2\2_`\7h\2\2`\n\3\2\2\2ab\7F\2\2bc\7g\2\2cd\7"+
		"h\2\2de\7k\2\2ef\7p\2\2fg\7g\2\2g\f\3\2\2\2hi\7G\2\2ij\7p\2\2jk\7f\2\2"+
		"k\16\3\2\2\2lm\7-\2\2m\20\3\2\2\2no\7U\2\2op\7k\2\2pq\7|\2\2qr\7g\2\2"+
		"r\22\3\2\2\2st\7/\2\2t\24\3\2\2\2uv\7,\2\2v\26\3\2\2\2wx\7\61\2\2x\30"+
		"\3\2\2\2yz\4C\\\2z\32\3\2\2\2{|\4c|\2|\34\3\2\2\2}~\7E\2\2~\177\7a\2\2"+
		"\177\36\3\2\2\2\u0080\u0081\7T\2\2\u0081\u0082\7a\2\2\u0082 \3\2\2\2\u0083"+
		"\u0084\7g\2\2\u0084\u0085\7s\2\2\u0085\u0086\7w\2\2\u0086\u0087\7c\2\2"+
		"\u0087\u0088\7n\2\2\u0088\u0089\7u\2\2\u0089\"\3\2\2\2\u008a\u008b\7i"+
		"\2\2\u008b\u008c\7t\2\2\u008c\u008d\7g\2\2\u008d\u008e\7c\2\2\u008e\u008f"+
		"\7v\2\2\u008f\u0090\7g\2\2\u0090\u0091\7t\2\2\u0091\u0092\7\"\2\2\u0092"+
		"\u0093\7v\2\2\u0093\u0094\7j\2\2\u0094\u0095\7c\2\2\u0095\u0098\7p\2\2"+
		"\u0096\u0098\7@\2\2\u0097\u008a\3\2\2\2\u0097\u0096\3\2\2\2\u0098$\3\2"+
		"\2\2\u0099\u009a\7n\2\2\u009a\u009b\7g\2\2\u009b\u009c\7u\2\2\u009c\u009d"+
		"\7u\2\2\u009d\u009e\7\"\2\2\u009e\u009f\7v\2\2\u009f\u00a0\7j\2\2\u00a0"+
		"\u00a1\7c\2\2\u00a1\u00a4\7p\2\2\u00a2\u00a4\7>\2\2\u00a3\u0099\3\2\2"+
		"\2\u00a3\u00a2\3\2\2\2\u00a4&\3\2\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7"+
		"q\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7\"\2\2\u00a9\u00aa\7g\2\2\u00aa"+
		"\u00ab\7s\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7n\2\2"+
		"\u00ae\u00b2\7u\2\2\u00af\u00b0\7\u0080\2\2\u00b0\u00b2\7?\2\2\u00b1\u00a5"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2(\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5"+
		"\7p\2\2\u00b5\u00b6\7r\2\2\u00b6\u00b7\7w\2\2\u00b7\u00b8\7v\2\2\u00b8"+
		"*\3\2\2\2\u00b9\u00ba\7q\2\2\u00ba\u00bb\7w\2\2\u00bb\u00bc\7v\2\2\u00bc"+
		"\u00bd\7r\2\2\u00bd\u00be\7w\2\2\u00be\u00bf\7v\2\2\u00bf,\3\2\2\2\u00c0"+
		"\u00c1\7C\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7u\2\2\u00c3\u00c4\7k\2\2"+
		"\u00c4\u00c5\7i\2\2\u00c5\u00c8\7p\2\2\u00c6\u00c8\7?\2\2\u00c7\u00c0"+
		"\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8.\3\2\2\2\u00c9\u00ca\7.\2\2\u00ca\60"+
		"\3\2\2\2\u00cb\u00cc\7T\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7i\2\2\u00ce"+
		"\62\3\2\2\2\u00cf\u00d0\7X\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7t\2\2\u00d2"+
		"\64\3\2\2\2\u00d3\u00d6\5\31\r\2\u00d4\u00d6\5\33\16\2\u00d5\u00d3\3\2"+
		"\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00dc\3\2\2\2\u00d9\u00db\5;\36\2\u00da\u00d9\3\2"+
		"\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\66\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\7U\2\2\u00e0\u00e1\7v\2\2"+
		"\u00e1\u00e2\7c\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5"+
		"\7<\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e8\5;\36\2\u00e7\u00e6\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea8\3\2\2\2"+
		"\u00eb\u00ec\7/\2\2\u00ec\u00ed\5;\36\2\u00ed:\3\2\2\2\u00ee\u00f0\4\62"+
		";\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1"+
		"\u00f2\3\2\2\2\u00f2<\3\2\2\2\u00f3\u00f4\t\2\2\2\u00f4\u00f5\3\2\2\2"+
		"\u00f5\u00f6\b\37\2\2\u00f6>\3\2\2\2\u00f7\u00f8\t\3\2\2\u00f8\u00f9\3"+
		"\2\2\2\u00f9\u00fa\b \2\2\u00fa@\3\2\2\2\f\2\u0097\u00a3\u00b1\u00c7\u00d5"+
		"\u00d7\u00dc\u00e9\u00f1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}