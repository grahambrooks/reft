// Generated from Migration.g4 by ANTLR 4.0

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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, Identifier=6, COMMENT=7, WS=8, 
		LINE_COMMENT=9;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'rename'", "'migration'", "'to'", "';'", "'.'", "Identifier", "COMMENT", 
		"WS", "LINE_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "Identifier", "Letter", "JavaIDDigit", 
		"COMMENT", "WS", "LINE_COMMENT"
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
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 8: COMMENT_action((RuleContext)_localctx, actionIndex); break;

		case 9: WS_action((RuleContext)_localctx, actionIndex); break;

		case 10: LINE_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void LINE_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: skip();  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: skip();  break;
		}
	}
	private void COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\13d\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7"+
		"\7\7\65\n\7\f\7\16\78\13\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\7\nB\n\n\f"+
		"\n\16\nE\13\n\3\n\3\n\3\n\3\n\3\n\3\13\6\13M\n\13\r\13\16\13N\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\7\fW\n\f\f\f\16\fZ\13\f\3\f\5\f]\n\f\3\f\3\f\5\fa\n\f"+
		"\3\f\3\f\3C\r\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\2\1\21\2\1\23\t"+
		"\2\25\n\3\27\13\4\3\2\6\16&&C\\aac|\u00c2\u00d8\u00da\u00f8\u00fa\u2001"+
		"\u3042\u3191\u3302\u3381\u3402\u3d2f\u4e02\ua001\uf902\ufb01\21\62;\u0662"+
		"\u066b\u06f2\u06fb\u0968\u0971\u09e8\u09f1\u0a68\u0a71\u0ae8\u0af1\u0b68"+
		"\u0b71\u0be9\u0bf1\u0c68\u0c71\u0ce8\u0cf1\u0d68\u0d71\u0e52\u0e5b\u0ed2"+
		"\u0edb\u1042\u104b\5\13\f\16\17\"\"\4\f\f\17\17h\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2\2\5 \3\2\2\2\7*\3\2\2\2\t-\3\2\2\2\13"+
		"/\3\2\2\2\r\61\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23=\3\2\2\2\25L\3\2\2\2"+
		"\27R\3\2\2\2\31\32\7t\2\2\32\33\7g\2\2\33\34\7p\2\2\34\35\7c\2\2\35\36"+
		"\7o\2\2\36\37\7g\2\2\37\4\3\2\2\2 !\7o\2\2!\"\7k\2\2\"#\7i\2\2#$\7t\2"+
		"\2$%\7c\2\2%&\7v\2\2&\'\7k\2\2\'(\7q\2\2()\7p\2\2)\6\3\2\2\2*+\7v\2\2"+
		"+,\7q\2\2,\b\3\2\2\2-.\7=\2\2.\n\3\2\2\2/\60\7\60\2\2\60\f\3\2\2\2\61"+
		"\66\5\17\b\2\62\65\5\17\b\2\63\65\5\21\t\2\64\62\3\2\2\2\64\63\3\2\2\2"+
		"\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\16\3\2\2\28\66\3\2\2\29:\t"+
		"\2\2\2:\20\3\2\2\2;<\t\3\2\2<\22\3\2\2\2=>\7\61\2\2>?\7,\2\2?C\3\2\2\2"+
		"@B\13\2\2\2A@\3\2\2\2BE\3\2\2\2CD\3\2\2\2CA\3\2\2\2DF\3\2\2\2EC\3\2\2"+
		"\2FG\7,\2\2GH\7\61\2\2HI\3\2\2\2IJ\b\n\2\2J\24\3\2\2\2KM\t\4\2\2LK\3\2"+
		"\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3\2\2\2PQ\b\13\3\2Q\26\3\2\2\2RS"+
		"\7\61\2\2ST\7\61\2\2TX\3\2\2\2UW\n\5\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2"+
		"XY\3\2\2\2Y`\3\2\2\2ZX\3\2\2\2[]\7\17\2\2\\[\3\2\2\2\\]\3\2\2\2]^\3\2"+
		"\2\2^a\7\f\2\2_a\7\1\2\2`\\\3\2\2\2`_\3\2\2\2ab\3\2\2\2bc\b\f\4\2c\30"+
		"\3\2\2\2\n\2\64\66CNX\\`";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}