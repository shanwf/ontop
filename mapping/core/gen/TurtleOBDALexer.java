// Generated from /home/julien/workspace/ontop/ontop/mapping/core/src/main/antlr4/it/unibz/inf/ontop/spec/mapping/parser/impl/TurtleOBDA.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TurtleOBDALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		WS=10, STRING_WITH_CURLY_BRACKET=11, BOOLEAN_LITERAL=12, IRIREF_EXT=13, 
		IRIREF=14, PNAME_NS=15, PN_PREFIX=16, PREFIXED_NAME=17, PREFIXED_NAME_EXT=18, 
		BLANK_NODE_FUNCTION=19, BLANK_NODE_LABEL=20, LANGTAG=21, INTEGER=22, DECIMAL=23, 
		DOUBLE=24, EXPONENT=25, INTEGER_POSITIVE=26, INTEGER_NEGATIVE=27, DOUBLE_POSITIVE=28, 
		DOUBLE_NEGATIVE=29, DECIMAL_POSITIVE=30, DECIMAL_NEGATIVE=31, STRING_LITERAL_LONG_SINGLE_QUOTE=32, 
		STRING_LITERAL_LONG_QUOTE=33, STRING_LITERAL_QUOTE=34, STRING_LITERAL_SINGLE_QUOTE=35, 
		UCHAR=36, ECHAR=37, ANON_WS=38, ANON=39, PN_CHARS_BASE=40, PN_CHARS_U=41, 
		PN_CHARS=42, PN_LOCAL_EXT=43, PN_LOCAL=44, PLX=45, PERCENT=46, HEX=47, 
		PN_LOCAL_ESC=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"WS", "STRING_WITH_CURLY_BRACKET", "BOOLEAN_LITERAL", "IRIREF_EXT", "IRIREF", 
		"PNAME_NS", "PN_PREFIX", "PREFIXED_NAME", "PREFIXED_NAME_EXT", "BLANK_NODE_FUNCTION", 
		"BLANK_NODE_LABEL", "LANGTAG", "INTEGER", "DECIMAL", "DOUBLE", "EXPONENT", 
		"INTEGER_POSITIVE", "INTEGER_NEGATIVE", "DOUBLE_POSITIVE", "DOUBLE_NEGATIVE", 
		"DECIMAL_POSITIVE", "DECIMAL_NEGATIVE", "STRING_LITERAL_LONG_SINGLE_QUOTE", 
		"STRING_LITERAL_LONG_QUOTE", "STRING_LITERAL_QUOTE", "STRING_LITERAL_SINGLE_QUOTE", 
		"UCHAR", "ECHAR", "ANON_WS", "ANON", "PN_CHARS_BASE", "PN_CHARS_U", "PN_CHARS", 
		"PN_LOCAL_EXT", "PN_LOCAL", "PLX", "PERCENT", "HEX", "PN_LOCAL_ESC", "RIGHT_PART_FIRST_CHAR", 
		"RIGHT_PART_FIRST_CHAR_EXT", "RIGHT_PART_CHAR", "RIGHT_PART_CHAR_EXT", 
		"RIGHT_PART_END_CHAR", "RIGHT_PART_END_CHAR_EXT", "RIGHT_PART_TAIL", "RIGHT_PART_TAIL_EXT", 
		"RIGHT_PART_TAIL_EXT_MAND", "IRIREF_INNER_CHAR", "IRIREF_INNER_CHAR_EXT", 
		"VARIABLE_CHAR"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'.'", "'@prefix'", "'@PREFIX'", "'@base'", "'@BASE'", "';'", "','", 
		"'a'", "'^^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "WS", "STRING_WITH_CURLY_BRACKET", 
		"BOOLEAN_LITERAL", "IRIREF_EXT", "IRIREF", "PNAME_NS", "PN_PREFIX", "PREFIXED_NAME", 
		"PREFIXED_NAME_EXT", "BLANK_NODE_FUNCTION", "BLANK_NODE_LABEL", "LANGTAG", 
		"INTEGER", "DECIMAL", "DOUBLE", "EXPONENT", "INTEGER_POSITIVE", "INTEGER_NEGATIVE", 
		"DOUBLE_POSITIVE", "DOUBLE_NEGATIVE", "DECIMAL_POSITIVE", "DECIMAL_NEGATIVE", 
		"STRING_LITERAL_LONG_SINGLE_QUOTE", "STRING_LITERAL_LONG_QUOTE", "STRING_LITERAL_QUOTE", 
		"STRING_LITERAL_SINGLE_QUOTE", "UCHAR", "ECHAR", "ANON_WS", "ANON", "PN_CHARS_BASE", 
		"PN_CHARS_U", "PN_CHARS", "PN_LOCAL_EXT", "PN_LOCAL", "PLX", "PERCENT", 
		"HEX", "PN_LOCAL_ESC"
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


	public TurtleOBDALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TurtleOBDA.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u024e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\n\3\13\6\13\u00a4\n\13\r\13\16\13\u00a5\3\13\3\13\3\f"+
		"\3\f\6\f\u00ac\n\f\r\f\16\f\u00ad\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00cd\n\r\3\16\3\16\7\16\u00d1\n\16\f\16\16\16\u00d4\13"+
		"\16\3\16\3\16\6\16\u00d8\n\16\r\16\16\16\u00d9\3\16\3\16\3\17\3\17\7\17"+
		"\u00e0\n\17\f\17\16\17\u00e3\13\17\3\17\3\17\3\20\5\20\u00e8\n\20\3\20"+
		"\3\20\3\21\3\21\3\21\7\21\u00ef\n\21\f\21\16\21\u00f2\13\21\3\21\5\21"+
		"\u00f5\n\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\7\24\u0103\n\24\f\24\16\24\u0106\13\24\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u010d\n\25\3\25\3\25\7\25\u0111\n\25\f\25\16\25\u0114\13\25\3\25\5\25"+
		"\u0117\n\25\3\26\3\26\6\26\u011b\n\26\r\26\16\26\u011c\3\26\3\26\6\26"+
		"\u0121\n\26\r\26\16\26\u0122\7\26\u0125\n\26\f\26\16\26\u0128\13\26\3"+
		"\27\6\27\u012b\n\27\r\27\16\27\u012c\3\30\7\30\u0130\n\30\f\30\16\30\u0133"+
		"\13\30\3\30\3\30\6\30\u0137\n\30\r\30\16\30\u0138\3\31\6\31\u013c\n\31"+
		"\r\31\16\31\u013d\3\31\3\31\7\31\u0142\n\31\f\31\16\31\u0145\13\31\3\31"+
		"\3\31\3\31\6\31\u014a\n\31\r\31\16\31\u014b\3\31\3\31\6\31\u0150\n\31"+
		"\r\31\16\31\u0151\3\31\5\31\u0155\n\31\3\32\3\32\5\32\u0159\n\32\3\32"+
		"\6\32\u015c\n\32\r\32\16\32\u015d\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\5"+
		"!\u0179\n!\3!\3!\3!\3!\5!\u017f\n!\7!\u0181\n!\f!\16!\u0184\13!\3!\3!"+
		"\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0191\n\"\3\"\3\"\3\"\3\"\5\"\u0197"+
		"\n\"\7\"\u0199\n\"\f\"\16\"\u019c\13\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#"+
		"\3#\3#\7#\u01a9\n#\f#\16#\u01ac\13#\3#\3#\3$\3$\3$\3$\3$\7$\u01b5\n$\f"+
		"$\16$\u01b8\13$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\5%\u01d0\n%\3&\3&\3&\3\'\3\'\3(\3(\7(\u01d9\n(\f(\16(\u01dc"+
		"\13(\3(\3(\3)\3)\3*\3*\5*\u01e4\n*\3+\3+\5+\u01e8\n+\3,\3,\6,\u01ec\n"+
		",\r,\16,\u01ed\3,\3,\3,\5,\u01f3\n,\3-\3-\5-\u01f7\n-\3.\3.\5.\u01fb\n"+
		".\3/\3/\3/\3/\3\60\5\60\u0202\n\60\3\61\3\61\3\61\3\62\3\62\3\62\5\62"+
		"\u020a\n\62\3\63\3\63\5\63\u020e\n\63\3\64\3\64\3\64\5\64\u0213\n\64\3"+
		"\65\3\65\5\65\u0217\n\65\3\66\3\66\3\66\5\66\u021c\n\66\3\67\3\67\5\67"+
		"\u0220\n\67\38\78\u0223\n8\f8\168\u0226\138\38\38\39\79\u022b\n9\f9\16"+
		"9\u022e\139\39\39\3:\7:\u0233\n:\f:\16:\u0236\13:\3:\3:\7:\u023a\n:\f"+
		":\16:\u023d\13:\3:\3:\3;\3;\3;\5;\u0244\n;\3<\3<\5<\u0248\n<\3=\3=\3="+
		"\5=\u024d\n=\2\2>\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\2e\2"+
		"g\2i\2k\2m\2o\2q\2s\2u\2w\2y\2\3\2\31\5\2\13\f\16\17\"\"\3\2\62;\4\2C"+
		"\\c|\5\2\62;C\\c|\4\2GGgg\4\2--//\5\2))^^``\4\2$$^^\6\2\f\f\17\17$$^^"+
		"\5\2\"\"}}\177\177\6\2\f\f\17\17))^^\n\2$$))^^ddhhppttvv\5\2\13\f\17\17"+
		"\"\"\17\2C\\c|\u00c2\u00d8\u00da\u00f8\u00fa\u0301\u0372\u037f\u0381\u2001"+
		"\u200e\u200f\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2\uffff"+
		"\t\2//\62;??AA\u00b9\u00b9\u0302\u0371\u2041\u2042\5\2\62;CHch\t\2##%"+
		"\61==??ABaa\u0080\u0080\4\2%%\62<\5\2%%\60\61<=\4\2}}\177\177\4\2\61\61"+
		"<<\b\2%%\'(\60\61<=BB^^\6\2%(\60\61<<^^\2\u0291\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3{\3\2\2\2\5}\3"+
		"\2\2\2\7\u0085\3\2\2\2\t\u008d\3\2\2\2\13\u0093\3\2\2\2\r\u0099\3\2\2"+
		"\2\17\u009b\3\2\2\2\21\u009d\3\2\2\2\23\u009f\3\2\2\2\25\u00a3\3\2\2\2"+
		"\27\u00a9\3\2\2\2\31\u00cc\3\2\2\2\33\u00ce\3\2\2\2\35\u00dd\3\2\2\2\37"+
		"\u00e7\3\2\2\2!\u00eb\3\2\2\2#\u00f6\3\2\2\2%\u00f9\3\2\2\2\'\u00fc\3"+
		"\2\2\2)\u0107\3\2\2\2+\u0118\3\2\2\2-\u012a\3\2\2\2/\u0131\3\2\2\2\61"+
		"\u0154\3\2\2\2\63\u0156\3\2\2\2\65\u015f\3\2\2\2\67\u0162\3\2\2\29\u0165"+
		"\3\2\2\2;\u0168\3\2\2\2=\u016b\3\2\2\2?\u016e\3\2\2\2A\u0171\3\2\2\2C"+
		"\u0189\3\2\2\2E\u01a1\3\2\2\2G\u01af\3\2\2\2I\u01cf\3\2\2\2K\u01d1\3\2"+
		"\2\2M\u01d4\3\2\2\2O\u01d6\3\2\2\2Q\u01df\3\2\2\2S\u01e3\3\2\2\2U\u01e7"+
		"\3\2\2\2W\u01f2\3\2\2\2Y\u01f4\3\2\2\2[\u01fa\3\2\2\2]\u01fc\3\2\2\2_"+
		"\u0201\3\2\2\2a\u0203\3\2\2\2c\u0209\3\2\2\2e\u020d\3\2\2\2g\u0212\3\2"+
		"\2\2i\u0216\3\2\2\2k\u021b\3\2\2\2m\u021f\3\2\2\2o\u0224\3\2\2\2q\u022c"+
		"\3\2\2\2s\u0234\3\2\2\2u\u0243\3\2\2\2w\u0247\3\2\2\2y\u024c\3\2\2\2{"+
		"|\7\60\2\2|\4\3\2\2\2}~\7B\2\2~\177\7r\2\2\177\u0080\7t\2\2\u0080\u0081"+
		"\7g\2\2\u0081\u0082\7h\2\2\u0082\u0083\7k\2\2\u0083\u0084\7z\2\2\u0084"+
		"\6\3\2\2\2\u0085\u0086\7B\2\2\u0086\u0087\7R\2\2\u0087\u0088\7T\2\2\u0088"+
		"\u0089\7G\2\2\u0089\u008a\7H\2\2\u008a\u008b\7K\2\2\u008b\u008c\7Z\2\2"+
		"\u008c\b\3\2\2\2\u008d\u008e\7B\2\2\u008e\u008f\7d\2\2\u008f\u0090\7c"+
		"\2\2\u0090\u0091\7u\2\2\u0091\u0092\7g\2\2\u0092\n\3\2\2\2\u0093\u0094"+
		"\7B\2\2\u0094\u0095\7D\2\2\u0095\u0096\7C\2\2\u0096\u0097\7U\2\2\u0097"+
		"\u0098\7G\2\2\u0098\f\3\2\2\2\u0099\u009a\7=\2\2\u009a\16\3\2\2\2\u009b"+
		"\u009c\7.\2\2\u009c\20\3\2\2\2\u009d\u009e\7c\2\2\u009e\22\3\2\2\2\u009f"+
		"\u00a0\7`\2\2\u00a0\u00a1\7`\2\2\u00a1\24\3\2\2\2\u00a2\u00a4\t\2\2\2"+
		"\u00a3\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\b\13\2\2\u00a8\26\3\2\2\2\u00a9"+
		"\u00ab\7}\2\2\u00aa\u00ac\5y=\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2"+
		"\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0"+
		"\7\177\2\2\u00b0\30\3\2\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7t\2\2\u00b3"+
		"\u00b4\7w\2\2\u00b4\u00cd\7g\2\2\u00b5\u00b6\7V\2\2\u00b6\u00b7\7T\2\2"+
		"\u00b7\u00b8\7W\2\2\u00b8\u00cd\7G\2\2\u00b9\u00ba\7V\2\2\u00ba\u00bb"+
		"\7t\2\2\u00bb\u00bc\7w\2\2\u00bc\u00cd\7g\2\2\u00bd\u00be\7h\2\2\u00be"+
		"\u00bf\7c\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7u\2\2\u00c1\u00cd\7g\2\2"+
		"\u00c2\u00c3\7H\2\2\u00c3\u00c4\7C\2\2\u00c4\u00c5\7N\2\2\u00c5\u00c6"+
		"\7U\2\2\u00c6\u00cd\7G\2\2\u00c7\u00c8\7H\2\2\u00c8\u00c9\7c\2\2\u00c9"+
		"\u00ca\7n\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cd\7g\2\2\u00cc\u00b1\3\2\2"+
		"\2\u00cc\u00b5\3\2\2\2\u00cc\u00b9\3\2\2\2\u00cc\u00bd\3\2\2\2\u00cc\u00c2"+
		"\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cd\32\3\2\2\2\u00ce\u00d2\7>\2\2\u00cf"+
		"\u00d1\5w<\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2"+
		"\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d7"+
		"\7}\2\2\u00d6\u00d8\5w<\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7@"+
		"\2\2\u00dc\34\3\2\2\2\u00dd\u00e1\7>\2\2\u00de\u00e0\5u;\2\u00df\u00de"+
		"\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7@\2\2\u00e5\36\3\2\2\2"+
		"\u00e6\u00e8\5!\21\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9"+
		"\3\2\2\2\u00e9\u00ea\7<\2\2\u00ea \3\2\2\2\u00eb\u00f4\5Q)\2\u00ec\u00ef"+
		"\5U+\2\u00ed\u00ef\7\60\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef"+
		"\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2"+
		"\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f5\5U+\2\u00f4\u00f0\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\"\3\2\2\2\u00f6\u00f7\5\37\20\2\u00f7\u00f8\5Y-\2\u00f8"+
		"$\3\2\2\2\u00f9\u00fa\5\37\20\2\u00fa\u00fb\5W,\2\u00fb&\3\2\2\2\u00fc"+
		"\u00fd\7a\2\2\u00fd\u00fe\7<\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0104\5\27"+
		"\f\2\u0100\u0101\7a\2\2\u0101\u0103\5\27\f\2\u0102\u0100\3\2\2\2\u0103"+
		"\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105(\3\2\2\2"+
		"\u0106\u0104\3\2\2\2\u0107\u0108\7a\2\2\u0108\u0109\7<\2\2\u0109\u010c"+
		"\3\2\2\2\u010a\u010d\5S*\2\u010b\u010d\t\3\2\2\u010c\u010a\3\2\2\2\u010c"+
		"\u010b\3\2\2\2\u010d\u0116\3\2\2\2\u010e\u0111\5U+\2\u010f\u0111\7\60"+
		"\2\2\u0110\u010e\3\2\2\2\u0110\u010f\3\2\2\2\u0111\u0114\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0112\3\2"+
		"\2\2\u0115\u0117\5U+\2\u0116\u0112\3\2\2\2\u0116\u0117\3\2\2\2\u0117*"+
		"\3\2\2\2\u0118\u011a\7B\2\2\u0119\u011b\t\4\2\2\u011a\u0119\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0126\3\2"+
		"\2\2\u011e\u0120\7/\2\2\u011f\u0121\t\5\2\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2"+
		"\2\2\u0124\u011e\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126"+
		"\u0127\3\2\2\2\u0127,\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012b\t\3\2\2"+
		"\u012a\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d"+
		"\3\2\2\2\u012d.\3\2\2\2\u012e\u0130\t\3\2\2\u012f\u012e\3\2\2\2\u0130"+
		"\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2"+
		"\2\2\u0133\u0131\3\2\2\2\u0134\u0136\7\60\2\2\u0135\u0137\t\3\2\2\u0136"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\60\3\2\2\2\u013a\u013c\t\3\2\2\u013b\u013a\3\2\2\2\u013c\u013d"+
		"\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0143\7\60\2\2\u0140\u0142\t\3\2\2\u0141\u0140\3\2\2\2\u0142\u0145\3"+
		"\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2\2\2\u0145"+
		"\u0143\3\2\2\2\u0146\u0155\5\63\32\2\u0147\u0149\7\60\2\2\u0148\u014a"+
		"\t\3\2\2\u0149\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u0155\5\63\32\2\u014e\u0150\t"+
		"\3\2\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151"+
		"\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0155\5\63\32\2\u0154\u013b\3"+
		"\2\2\2\u0154\u0147\3\2\2\2\u0154\u014f\3\2\2\2\u0155\62\3\2\2\2\u0156"+
		"\u0158\t\6\2\2\u0157\u0159\t\7\2\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159\u015b\3\2\2\2\u015a\u015c\t\3\2\2\u015b\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\64\3\2\2"+
		"\2\u015f\u0160\7-\2\2\u0160\u0161\5-\27\2\u0161\66\3\2\2\2\u0162\u0163"+
		"\7/\2\2\u0163\u0164\5-\27\2\u01648\3\2\2\2\u0165\u0166\7-\2\2\u0166\u0167"+
		"\5\61\31\2\u0167:\3\2\2\2\u0168\u0169\7/\2\2\u0169\u016a\5\61\31\2\u016a"+
		"<\3\2\2\2\u016b\u016c\7-\2\2\u016c\u016d\5/\30\2\u016d>\3\2\2\2\u016e"+
		"\u016f\7/\2\2\u016f\u0170\5/\30\2\u0170@\3\2\2\2\u0171\u0172\7)\2\2\u0172"+
		"\u0173\7)\2\2\u0173\u0174\7)\2\2\u0174\u0182\3\2\2\2\u0175\u0179\7)\2"+
		"\2\u0176\u0177\7)\2\2\u0177\u0179\7)\2\2\u0178\u0175\3\2\2\2\u0178\u0176"+
		"\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017e\3\2\2\2\u017a\u017f\t\b\2\2\u017b"+
		"\u017f\5K&\2\u017c\u017f\5I%\2\u017d\u017f\7$\2\2\u017e\u017a\3\2\2\2"+
		"\u017e\u017b\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017f\u0181"+
		"\3\2\2\2\u0180\u0178\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2\2\2\u0185\u0186\7)"+
		"\2\2\u0186\u0187\7)\2\2\u0187\u0188\7)\2\2\u0188B\3\2\2\2\u0189\u018a"+
		"\7$\2\2\u018a\u018b\7$\2\2\u018b\u018c\7$\2\2\u018c\u019a\3\2\2\2\u018d"+
		"\u0191\7$\2\2\u018e\u018f\7$\2\2\u018f\u0191\7$\2\2\u0190\u018d\3\2\2"+
		"\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0196\3\2\2\2\u0192\u0197"+
		"\n\t\2\2\u0193\u0197\5K&\2\u0194\u0197\5I%\2\u0195\u0197\7)\2\2\u0196"+
		"\u0192\3\2\2\2\u0196\u0193\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0195\3\2"+
		"\2\2\u0197\u0199\3\2\2\2\u0198\u0190\3\2\2\2\u0199\u019c\3\2\2\2\u019a"+
		"\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c\u019a\3\2"+
		"\2\2\u019d\u019e\7$\2\2\u019e\u019f\7$\2\2\u019f\u01a0\7$\2\2\u01a0D\3"+
		"\2\2\2\u01a1\u01aa\7$\2\2\u01a2\u01a9\n\n\2\2\u01a3\u01a9\7)\2\2\u01a4"+
		"\u01a5\7^\2\2\u01a5\u01a9\7$\2\2\u01a6\u01a9\t\13\2\2\u01a7\u01a9\5K&"+
		"\2\u01a8\u01a2\3\2\2\2\u01a8\u01a3\3\2\2\2\u01a8\u01a4\3\2\2\2\u01a8\u01a6"+
		"\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa\u01a8\3\2\2\2\u01aa"+
		"\u01ab\3\2\2\2\u01ab\u01ad\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad\u01ae\7$"+
		"\2\2\u01aeF\3\2\2\2\u01af\u01b6\7)\2\2\u01b0\u01b5\n\f\2\2\u01b1\u01b5"+
		"\5K&\2\u01b2\u01b5\5I%\2\u01b3\u01b5\7$\2\2\u01b4\u01b0\3\2\2\2\u01b4"+
		"\u01b1\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b3\3\2\2\2\u01b5\u01b8\3\2"+
		"\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b9\3\2\2\2\u01b8"+
		"\u01b6\3\2\2\2\u01b9\u01ba\7)\2\2\u01baH\3\2\2\2\u01bb\u01bc\7^\2\2\u01bc"+
		"\u01bd\7w\2\2\u01bd\u01be\3\2\2\2\u01be\u01bf\5_\60\2\u01bf\u01c0\5_\60"+
		"\2\u01c0\u01c1\5_\60\2\u01c1\u01c2\5_\60\2\u01c2\u01d0\3\2\2\2\u01c3\u01c4"+
		"\7^\2\2\u01c4\u01c5\7W\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c7\5_\60\2\u01c7"+
		"\u01c8\5_\60\2\u01c8\u01c9\5_\60\2\u01c9\u01ca\5_\60\2\u01ca\u01cb\5_"+
		"\60\2\u01cb\u01cc\5_\60\2\u01cc\u01cd\5_\60\2\u01cd\u01ce\5_\60\2\u01ce"+
		"\u01d0\3\2\2\2\u01cf\u01bb\3\2\2\2\u01cf\u01c3\3\2\2\2\u01d0J\3\2\2\2"+
		"\u01d1\u01d2\7^\2\2\u01d2\u01d3\t\r\2\2\u01d3L\3\2\2\2\u01d4\u01d5\t\16"+
		"\2\2\u01d5N\3\2\2\2\u01d6\u01da\7]\2\2\u01d7\u01d9\5M\'\2\u01d8\u01d7"+
		"\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01da\u01db\3\2\2\2\u01db"+
		"\u01dd\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd\u01de\7_\2\2\u01deP\3\2\2\2\u01df"+
		"\u01e0\t\17\2\2\u01e0R\3\2\2\2\u01e1\u01e4\5Q)\2\u01e2\u01e4\7a\2\2\u01e3"+
		"\u01e1\3\2\2\2\u01e3\u01e2\3\2\2\2\u01e4T\3\2\2\2\u01e5\u01e8\5S*\2\u01e6"+
		"\u01e8\t\20\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e6\3\2\2\2\u01e8V\3\2\2\2"+
		"\u01e9\u01eb\7}\2\2\u01ea\u01ec\5q9\2\u01eb\u01ea\3\2\2\2\u01ec\u01ed"+
		"\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ee\u01f3\3\2\2\2\u01ef"+
		"\u01f0\5c\62\2\u01f0\u01f1\5s:\2\u01f1\u01f3\3\2\2\2\u01f2\u01e9\3\2\2"+
		"\2\u01f2\u01ef\3\2\2\2\u01f3X\3\2\2\2\u01f4\u01f6\5c\62\2\u01f5\u01f7"+
		"\5o8\2\u01f6\u01f5\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7Z\3\2\2\2\u01f8\u01fb"+
		"\5]/\2\u01f9\u01fb\5a\61\2\u01fa\u01f8\3\2\2\2\u01fa\u01f9\3\2\2\2\u01fb"+
		"\\\3\2\2\2\u01fc\u01fd\7\'\2\2\u01fd\u01fe\5_\60\2\u01fe\u01ff\5_\60\2"+
		"\u01ff^\3\2\2\2\u0200\u0202\t\21\2\2\u0201\u0200\3\2\2\2\u0202`\3\2\2"+
		"\2\u0203\u0204\7^\2\2\u0204\u0205\t\22\2\2\u0205b\3\2\2\2\u0206\u020a"+
		"\5S*\2\u0207\u020a\t\23\2\2\u0208\u020a\5[.\2\u0209\u0206\3\2\2\2\u0209"+
		"\u0207\3\2\2\2\u0209\u0208\3\2\2\2\u020ad\3\2\2\2\u020b\u020e\5c\62\2"+
		"\u020c\u020e\7}\2\2\u020d\u020b\3\2\2\2\u020d\u020c\3\2\2\2\u020ef\3\2"+
		"\2\2\u020f\u0213\5U+\2\u0210\u0213\t\24\2\2\u0211\u0213\5[.\2\u0212\u020f"+
		"\3\2\2\2\u0212\u0210\3\2\2\2\u0212\u0211\3\2\2\2\u0213h\3\2\2\2\u0214"+
		"\u0217\5g\64\2\u0215\u0217\t\25\2\2\u0216\u0214\3\2\2\2\u0216\u0215\3"+
		"\2\2\2\u0217j\3\2\2\2\u0218\u021c\5U+\2\u0219\u021c\t\26\2\2\u021a\u021c"+
		"\5[.\2\u021b\u0218\3\2\2\2\u021b\u0219\3\2\2\2\u021b\u021a\3\2\2\2\u021c"+
		"l\3\2\2\2\u021d\u0220\5k\66\2\u021e\u0220\7\177\2\2\u021f\u021d\3\2\2"+
		"\2\u021f\u021e\3\2\2\2\u0220n\3\2\2\2\u0221\u0223\5g\64\2\u0222\u0221"+
		"\3\2\2\2\u0223\u0226\3\2\2\2\u0224\u0222\3\2\2\2\u0224\u0225\3\2\2\2\u0225"+
		"\u0227\3\2\2\2\u0226\u0224\3\2\2\2\u0227\u0228\5k\66\2\u0228p\3\2\2\2"+
		"\u0229\u022b\5i\65\2\u022a\u0229\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a"+
		"\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022f\3\2\2\2\u022e\u022c\3\2\2\2\u022f"+
		"\u0230\5m\67\2\u0230r\3\2\2\2\u0231\u0233\5i\65\2\u0232\u0231\3\2\2\2"+
		"\u0233\u0236\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0237"+
		"\3\2\2\2\u0236\u0234\3\2\2\2\u0237\u023b\7}\2\2\u0238\u023a\5i\65\2\u0239"+
		"\u0238\3\2\2\2\u023a\u023d\3\2\2\2\u023b\u0239\3\2\2\2\u023b\u023c\3\2"+
		"\2\2\u023c\u023e\3\2\2\2\u023d\u023b\3\2\2\2\u023e\u023f\5m\67\2\u023f"+
		"t\3\2\2\2\u0240\u0244\5U+\2\u0241\u0244\t\27\2\2\u0242\u0244\5I%\2\u0243"+
		"\u0240\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0242\3\2\2\2\u0244v\3\2\2\2"+
		"\u0245\u0248\5u;\2\u0246\u0248\t\25\2\2\u0247\u0245\3\2\2\2\u0247\u0246"+
		"\3\2\2\2\u0248x\3\2\2\2\u0249\u024d\5U+\2\u024a\u024d\t\30\2\2\u024b\u024d"+
		"\5I%\2\u024c\u0249\3\2\2\2\u024c\u024a\3\2\2\2\u024c\u024b\3\2\2\2\u024d"+
		"z\3\2\2\2@\2\u00a3\u00a5\u00ad\u00cc\u00d2\u00d9\u00e1\u00e7\u00ee\u00f0"+
		"\u00f4\u0104\u010c\u0110\u0112\u0116\u011c\u0122\u0126\u012c\u0131\u0138"+
		"\u013d\u0143\u014b\u0151\u0154\u0158\u015d\u0178\u017e\u0182\u0190\u0196"+
		"\u019a\u01a8\u01aa\u01b4\u01b6\u01cf\u01da\u01e3\u01e7\u01ed\u01f2\u01f6"+
		"\u01fa\u0201\u0209\u020d\u0212\u0216\u021b\u021f\u0224\u022c\u0234\u023b"+
		"\u0243\u0247\u024c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}