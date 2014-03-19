// Generated from Migration.g4 by ANTLR 4.0

    package reft.migration.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MigrationParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, Identifier=6, COMMENT=7, WS=8, 
		LINE_COMMENT=9;
	public static final String[] tokenNames = {
		"<INVALID>", "'rename'", "'migration'", "'to'", "';'", "'.'", "Identifier", 
		"COMMENT", "WS", "LINE_COMMENT"
	};
	public static final int
		RULE_migrationFile = 0, RULE_migrationDeclaration = 1, RULE_renameMigration = 2, 
		RULE_qualifiedName = 3;
	public static final String[] ruleNames = {
		"migrationFile", "migrationDeclaration", "renameMigration", "qualifiedName"
	};

	@Override
	public String getGrammarFileName() { return "Migration.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public MigrationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MigrationFileContext extends ParserRuleContext {
		public MigrationDeclarationContext migrationDeclaration(int i) {
			return getRuleContext(MigrationDeclarationContext.class,i);
		}
		public List<MigrationDeclarationContext> migrationDeclaration() {
			return getRuleContexts(MigrationDeclarationContext.class);
		}
		public TerminalNode EOF() { return getToken(MigrationParser.EOF, 0); }
		public MigrationFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_migrationFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).enterMigrationFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).exitMigrationFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MigrationVisitor ) return ((MigrationVisitor<? extends T>)visitor).visitMigrationFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MigrationFileContext migrationFile() throws RecognitionException {
		MigrationFileContext _localctx = new MigrationFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_migrationFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(8); migrationDeclaration();
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(14); match(EOF);
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

	public static class MigrationDeclarationContext extends ParserRuleContext {
		public RenameMigrationContext renameMigration() {
			return getRuleContext(RenameMigrationContext.class,0);
		}
		public MigrationDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_migrationDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).enterMigrationDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).exitMigrationDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MigrationVisitor ) return ((MigrationVisitor<? extends T>)visitor).visitMigrationDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MigrationDeclarationContext migrationDeclaration() throws RecognitionException {
		MigrationDeclarationContext _localctx = new MigrationDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_migrationDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); match(2);
			{
			setState(17); renameMigration();
			setState(18); match(4);
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

	public static class RenameMigrationContext extends ParserRuleContext {
		public QualifiedNameContext predicate;
		public Token newName;
		public TerminalNode Identifier() { return getToken(MigrationParser.Identifier, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public RenameMigrationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renameMigration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).enterRenameMigration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).exitRenameMigration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MigrationVisitor ) return ((MigrationVisitor<? extends T>)visitor).visitRenameMigration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenameMigrationContext renameMigration() throws RecognitionException {
		RenameMigrationContext _localctx = new RenameMigrationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_renameMigration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); match(1);
			setState(21); ((RenameMigrationContext)_localctx).predicate = qualifiedName();
			setState(22); match(3);
			setState(23); ((RenameMigrationContext)_localctx).newName = match(Identifier);
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

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MigrationParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MigrationParser.Identifier, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MigrationVisitor ) return ((MigrationVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_qualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); match(Identifier);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(26); match(5);
				setState(27); match(Identifier);
				}
				}
				setState(32);
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
		"\2\3\13$\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5\37\n\5"+
		"\f\5\16\5\"\13\5\3\5\2\6\2\4\6\b\2\2!\2\r\3\2\2\2\4\22\3\2\2\2\6\26\3"+
		"\2\2\2\b\33\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2"+
		"\r\16\3\2\2\2\16\20\3\2\2\2\17\r\3\2\2\2\20\21\7\1\2\2\21\3\3\2\2\2\22"+
		"\23\7\4\2\2\23\24\5\6\4\2\24\25\7\6\2\2\25\5\3\2\2\2\26\27\7\3\2\2\27"+
		"\30\5\b\5\2\30\31\7\5\2\2\31\32\7\b\2\2\32\7\3\2\2\2\33 \7\b\2\2\34\35"+
		"\7\7\2\2\35\37\7\b\2\2\36\34\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2"+
		"\2!\t\3\2\2\2\" \3\2\2\2\4\r ";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}