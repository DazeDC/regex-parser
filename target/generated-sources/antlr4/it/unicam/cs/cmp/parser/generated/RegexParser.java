// Generated from Regex.g4 by ANTLR 4.9.2

   package it.unicam.cs.cmp.parser.generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RegexParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, EPSILON=3, LETTER=4, DIGIT=5, PLUS=6, KLEENE=7, WS=8;
	public static final int
		RULE_expr = 0, RULE_union = 1, RULE_concat = 2, RULE_kleene = 3, RULE_term = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"expr", "union", "concat", "kleene", "term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'epsilon'", null, null, "'+'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "EPSILON", "LETTER", "DIGIT", "PLUS", "KLEENE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Regex.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RegexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnionEOFContext extends ExprContext {
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(RegexParser.EOF, 0); }
		public UnionEOFContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterUnionEOF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitUnionEOF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitUnionEOF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		try {
			_localctx = new UnionEOFContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			union(0);
			setState(11);
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

	public static class UnionContext extends ParserRuleContext {
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
	 
		public UnionContext() { }
		public void copyFrom(UnionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnionMatchContext extends UnionContext {
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(RegexParser.PLUS, 0); }
		public ConcatContext concat() {
			return getRuleContext(ConcatContext.class,0);
		}
		public UnionMatchContext(UnionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterUnionMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitUnionMatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitUnionMatch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnionConcatContext extends UnionContext {
		public ConcatContext concat() {
			return getRuleContext(ConcatContext.class,0);
		}
		public UnionConcatContext(UnionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterUnionConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitUnionConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitUnionConcat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		return union(0);
	}

	private UnionContext union(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		UnionContext _localctx = new UnionContext(_ctx, _parentState);
		UnionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_union, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new UnionConcatContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(14);
			concat(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(21);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new UnionMatchContext(new UnionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_union);
					setState(16);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(17);
					match(PLUS);
					setState(18);
					concat(0);
					}
					} 
				}
				setState(23);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConcatContext extends ParserRuleContext {
		public ConcatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concat; }
	 
		public ConcatContext() { }
		public void copyFrom(ConcatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConcatKleeneContext extends ConcatContext {
		public KleeneContext kleene() {
			return getRuleContext(KleeneContext.class,0);
		}
		public ConcatKleeneContext(ConcatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterConcatKleene(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitConcatKleene(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitConcatKleene(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcatMatchContext extends ConcatContext {
		public ConcatContext concat() {
			return getRuleContext(ConcatContext.class,0);
		}
		public KleeneContext kleene() {
			return getRuleContext(KleeneContext.class,0);
		}
		public ConcatMatchContext(ConcatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterConcatMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitConcatMatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitConcatMatch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatContext concat() throws RecognitionException {
		return concat(0);
	}

	private ConcatContext concat(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConcatContext _localctx = new ConcatContext(_ctx, _parentState);
		ConcatContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_concat, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ConcatKleeneContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(25);
			kleene();
			}
			_ctx.stop = _input.LT(-1);
			setState(31);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConcatMatchContext(new ConcatContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_concat);
					setState(27);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(28);
					kleene();
					}
					} 
				}
				setState(33);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class KleeneContext extends ParserRuleContext {
		public KleeneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kleene; }
	 
		public KleeneContext() { }
		public void copyFrom(KleeneContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class KleeneMatchContext extends KleeneContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode KLEENE() { return getToken(RegexParser.KLEENE, 0); }
		public KleeneMatchContext(KleeneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterKleeneMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitKleeneMatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitKleeneMatch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class KleeneTermContext extends KleeneContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public KleeneTermContext(KleeneContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterKleeneTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitKleeneTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitKleeneTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KleeneContext kleene() throws RecognitionException {
		KleeneContext _localctx = new KleeneContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_kleene);
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new KleeneMatchContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				term();
				setState(35);
				match(KLEENE);
				}
				break;
			case 2:
				_localctx = new KleeneTermContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				term();
				}
				break;
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

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TermParenthesisContext extends TermContext {
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public TermParenthesisContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterTermParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitTermParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitTermParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermLetterContext extends TermContext {
		public TerminalNode LETTER() { return getToken(RegexParser.LETTER, 0); }
		public TermLetterContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterTermLetter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitTermLetter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitTermLetter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermEpsilonContext extends TermContext {
		public TerminalNode EPSILON() { return getToken(RegexParser.EPSILON, 0); }
		public TermEpsilonContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterTermEpsilon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitTermEpsilon(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitTermEpsilon(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermDigitContext extends TermContext {
		public TerminalNode DIGIT() { return getToken(RegexParser.DIGIT, 0); }
		public TermDigitContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).enterTermDigit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RegexListener ) ((RegexListener)listener).exitTermDigit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RegexVisitor ) return ((RegexVisitor<? extends T>)visitor).visitTermDigit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_term);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LETTER:
				_localctx = new TermLetterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(LETTER);
				}
				break;
			case DIGIT:
				_localctx = new TermDigitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				match(DIGIT);
				}
				break;
			case EPSILON:
				_localctx = new TermEpsilonContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				match(EPSILON);
				}
				break;
			case T__0:
				_localctx = new TermParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				match(T__0);
				setState(44);
				union(0);
				setState(45);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return union_sempred((UnionContext)_localctx, predIndex);
		case 2:
			return concat_sempred((ConcatContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean union_sempred(UnionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean concat_sempred(ConcatContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n\64\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\26"+
		"\n\3\f\3\16\3\31\13\3\3\4\3\4\3\4\3\4\3\4\7\4 \n\4\f\4\16\4#\13\4\3\5"+
		"\3\5\3\5\3\5\5\5)\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\62\n\6\3\6\2\4\4"+
		"\6\7\2\4\6\b\n\2\2\2\64\2\f\3\2\2\2\4\17\3\2\2\2\6\32\3\2\2\2\b(\3\2\2"+
		"\2\n\61\3\2\2\2\f\r\5\4\3\2\r\16\7\2\2\3\16\3\3\2\2\2\17\20\b\3\1\2\20"+
		"\21\5\6\4\2\21\27\3\2\2\2\22\23\f\4\2\2\23\24\7\b\2\2\24\26\5\6\4\2\25"+
		"\22\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\5\3\2\2\2\31"+
		"\27\3\2\2\2\32\33\b\4\1\2\33\34\5\b\5\2\34!\3\2\2\2\35\36\f\4\2\2\36 "+
		"\5\b\5\2\37\35\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\7\3\2\2\2#!"+
		"\3\2\2\2$%\5\n\6\2%&\7\t\2\2&)\3\2\2\2\')\5\n\6\2($\3\2\2\2(\'\3\2\2\2"+
		")\t\3\2\2\2*\62\7\6\2\2+\62\7\7\2\2,\62\7\5\2\2-.\7\3\2\2./\5\4\3\2/\60"+
		"\7\4\2\2\60\62\3\2\2\2\61*\3\2\2\2\61+\3\2\2\2\61,\3\2\2\2\61-\3\2\2\2"+
		"\62\13\3\2\2\2\6\27!(\61";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}