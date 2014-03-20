// Generated from Migration.g4 by ANTLR 4.2

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
		T__5=1, T__4=2, T__3=3, T__2=4, T__1=5, T__0=6, Identifier=7, COMMENT=8, 
		WS=9, LINE_COMMENT=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'->'", "'migration'", "'('", "')'", "';'", "'.'", "Identifier", 
		"COMMENT", "WS", "LINE_COMMENT"
	};
	public static final int
		RULE_migrationFile = 0, RULE_migrationDeclaration = 1, RULE_invocation = 2, 
		RULE_qualifiedName = 3, RULE_qualification = 4;
	public static final String[] ruleNames = {
		"migrationFile", "migrationDeclaration", "invocation", "qualifiedName", 
		"qualification"
	};

	@Override
	public String getGrammarFileName() { return "Migration.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MigrationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MigrationFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MigrationParser.EOF, 0); }
		public MigrationDeclarationContext migrationDeclaration(int i) {
			return getRuleContext(MigrationDeclarationContext.class,i);
		}
		public List<MigrationDeclarationContext> migrationDeclaration() {
			return getRuleContexts(MigrationDeclarationContext.class);
		}
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
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(10); migrationDeclaration();
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16); match(EOF);
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
		public InvocationContext invocation() {
			return getRuleContext(InvocationContext.class,0);
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
			setState(18); match(2);
			{
			setState(19); invocation();
			setState(20); match(5);
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

	public static class InvocationContext extends ParserRuleContext {
		public QualifiedNameContext predicate;
		public QualifiedNameContext newName;
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public InvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).enterInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).exitInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MigrationVisitor ) return ((MigrationVisitor<? extends T>)visitor).visitInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvocationContext invocation() throws RecognitionException {
		InvocationContext _localctx = new InvocationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22); ((InvocationContext)_localctx).predicate = qualifiedName();
			setState(23); match(3);
			setState(24); match(4);
			setState(25); match(1);
			setState(26); ((InvocationContext)_localctx).newName = qualifiedName();
			setState(27); match(3);
			setState(28); match(4);
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
		public QualificationContext prefix;
		public Token name;
		public TerminalNode Identifier() { return getToken(MigrationParser.Identifier, 0); }
		public QualificationContext qualification() {
			return getRuleContext(QualificationContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); ((QualifiedNameContext)_localctx).prefix = qualification();
			setState(31); ((QualifiedNameContext)_localctx).name = match(Identifier);
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

	public static class QualificationContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MigrationParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MigrationParser.Identifier, i);
		}
		public QualificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).enterQualification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MigrationListener ) ((MigrationListener)listener).exitQualification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MigrationVisitor ) return ((MigrationVisitor<? extends T>)visitor).visitQualification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualificationContext qualification() throws RecognitionException {
		QualificationContext _localctx = new QualificationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_qualification);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(33); match(Identifier);
					setState(34); match(6);
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\f+\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\7\6&"+
		"\n\6\f\6\16\6)\13\6\3\6\2\2\7\2\4\6\b\n\2\2\'\2\17\3\2\2\2\4\24\3\2\2"+
		"\2\6\30\3\2\2\2\b \3\2\2\2\n\'\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\21"+
		"\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\22\3\2\2\2\21\17\3\2\2\2\22\23"+
		"\7\2\2\3\23\3\3\2\2\2\24\25\7\4\2\2\25\26\5\6\4\2\26\27\7\7\2\2\27\5\3"+
		"\2\2\2\30\31\5\b\5\2\31\32\7\5\2\2\32\33\7\6\2\2\33\34\7\3\2\2\34\35\5"+
		"\b\5\2\35\36\7\5\2\2\36\37\7\6\2\2\37\7\3\2\2\2 !\5\n\6\2!\"\7\t\2\2\""+
		"\t\3\2\2\2#$\7\t\2\2$&\7\b\2\2%#\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2"+
		"\2(\13\3\2\2\2)\'\3\2\2\2\4\17\'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}