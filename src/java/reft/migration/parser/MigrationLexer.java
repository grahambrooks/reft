// Generated from Migration.g4 by ANTLR 4.2

    package reft.migration.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MigrationLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, Identifier=7, COMMENT=8, 
		WS=9, LINE_COMMENT=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'->'", "'migration'", "'('", "')'", "';'", "'.'", "Identifier", "COMMENT", 
		"WS", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Identifier", "Letter", 
		"JavaIDDigit", "COMMENT", "WS", "LINE_COMMENT"
	};


	public MigrationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Migration.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fc\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7\b\64\n\b\f\b\16\b\67"+
		"\13\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13A\n\13\f\13\16\13D\13\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\6\fL\n\f\r\f\16\fM\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\7\rV\n\r\f\r\16\rY\13\r\3\r\5\r\\\n\r\3\r\3\r\5\r`\n\r\3\r\3\r\3B\2"+
		"\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\n\27\13\31\f\3\2\6\16\2"+
		"&&C\\aac|\u00c2\u00d8\u00da\u00f8\u00fa\u2001\u3042\u3191\u3302\u3381"+
		"\u3402\u3d2f\u4e02\ua001\uf902\ufb01\21\2\62;\u0662\u066b\u06f2\u06fb"+
		"\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68\u0b71\u0be9\u0bf1"+
		"\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52\u0e5b\u0ed2\u0edb\u1042\u104b"+
		"\5\2\13\f\16\17\"\"\4\2\f\f\17\17g\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\36\3\2\2\2\7(\3\2\2\2\t*\3\2\2\2\13"+
		",\3\2\2\2\r.\3\2\2\2\17\60\3\2\2\2\218\3\2\2\2\23:\3\2\2\2\25<\3\2\2\2"+
		"\27K\3\2\2\2\31Q\3\2\2\2\33\34\7/\2\2\34\35\7@\2\2\35\4\3\2\2\2\36\37"+
		"\7o\2\2\37 \7k\2\2 !\7i\2\2!\"\7t\2\2\"#\7c\2\2#$\7v\2\2$%\7k\2\2%&\7"+
		"q\2\2&\'\7p\2\2\'\6\3\2\2\2()\7*\2\2)\b\3\2\2\2*+\7+\2\2+\n\3\2\2\2,-"+
		"\7=\2\2-\f\3\2\2\2./\7\60\2\2/\16\3\2\2\2\60\65\5\21\t\2\61\64\5\21\t"+
		"\2\62\64\5\23\n\2\63\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2"+
		"\2\2\65\66\3\2\2\2\66\20\3\2\2\2\67\65\3\2\2\289\t\2\2\29\22\3\2\2\2:"+
		";\t\3\2\2;\24\3\2\2\2<=\7\61\2\2=>\7,\2\2>B\3\2\2\2?A\13\2\2\2@?\3\2\2"+
		"\2AD\3\2\2\2BC\3\2\2\2B@\3\2\2\2CE\3\2\2\2DB\3\2\2\2EF\7,\2\2FG\7\61\2"+
		"\2GH\3\2\2\2HI\b\13\2\2I\26\3\2\2\2JL\t\4\2\2KJ\3\2\2\2LM\3\2\2\2MK\3"+
		"\2\2\2MN\3\2\2\2NO\3\2\2\2OP\b\f\2\2P\30\3\2\2\2QR\7\61\2\2RS\7\61\2\2"+
		"SW\3\2\2\2TV\n\5\2\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X_\3\2\2\2"+
		"YW\3\2\2\2Z\\\7\17\2\2[Z\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]`\7\f\2\2^`\7\2"+
		"\2\3_[\3\2\2\2_^\3\2\2\2`a\3\2\2\2ab\b\r\2\2b\32\3\2\2\2\n\2\63\65BMW"+
		"[_\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}