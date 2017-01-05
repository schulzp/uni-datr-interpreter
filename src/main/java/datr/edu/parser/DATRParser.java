// Generated from /Users/peter/Documents/git/uni/datr-interpreter/src/main/resources/DATR.g4 by ANTLR 4.5.3
package datr.edu.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DATRParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, COMMENT=2, ATOM=3, VARIABLE=4, NODE=5, NODE_CHAR=6, ATOM_CHAR=7, 
		SYMBOL_CHAR=8, CHAR=9, SINGLE_QUOTE=10, DOUBLE_QUOTE=11, VAR_PREFIX=12, 
		NODE_SEPARATOR=13, COMMENT_SEPARTOR=14, LPAREN=15, RPAREN=16, LPATH=17, 
		RPATH=18, ASSIGN=19, DOT=20, WS=21, NL=22;
	public static final int
		RULE_query = 0, RULE_theory = 1, RULE_sentence = 2, RULE_equation = 3, 
		RULE_lhs = 4, RULE_rhs = 5, RULE_valueExpression = 6, RULE_descriptor = 7, 
		RULE_globalDescriptor = 8, RULE_path = 9, RULE_atom = 10, RULE_variable = 11, 
		RULE_node = 12;
	public static final String[] ruleNames = {
		"query", "theory", "sentence", "equation", "lhs", "rhs", "valueExpression", 
		"descriptor", "globalDescriptor", "path", "atom", "variable", "node"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\r'", null, null, null, null, null, null, null, null, "'''", "'\"'", 
		"'$'", "':'", "'%'", "'('", "')'", "'<'", "'>'", "'=='", "'.'", null, 
		"'\n'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "COMMENT", "ATOM", "VARIABLE", "NODE", "NODE_CHAR", "ATOM_CHAR", 
		"SYMBOL_CHAR", "CHAR", "SINGLE_QUOTE", "DOUBLE_QUOTE", "VAR_PREFIX", "NODE_SEPARATOR", 
		"COMMENT_SEPARTOR", "LPAREN", "RPAREN", "LPATH", "RPATH", "ASSIGN", "DOT", 
		"WS", "NL"
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
	public String getGrammarFileName() { return "DATR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DATRParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public NodeContext node() {
			return getRuleContext(NodeContext.class,0);
		}
		public TerminalNode NODE_SEPARATOR() { return getToken(DATRParser.NODE_SEPARATOR, 0); }
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DATRParser.EOF, 0); }
		public TerminalNode WS() { return getToken(DATRParser.WS, 0); }
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			node();
			setState(27);
			match(NODE_SEPARATOR);
			setState(28);
			lhs();
			setState(30);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(29);
				match(WS);
				}
			}

			setState(32);
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

	public static class TheoryContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(DATRParser.EOF, 0); }
		public List<SentenceContext> sentence() {
			return getRuleContexts(SentenceContext.class);
		}
		public SentenceContext sentence(int i) {
			return getRuleContext(SentenceContext.class,i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(DATRParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(DATRParser.COMMENT, i);
		}
		public List<TerminalNode> WS() { return getTokens(DATRParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(DATRParser.WS, i);
		}
		public List<TerminalNode> NL() { return getTokens(DATRParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DATRParser.NL, i);
		}
		public TheoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_theory; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterTheory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitTheory(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitTheory(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TheoryContext theory() throws RecognitionException {
		TheoryContext _localctx = new TheoryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_theory);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT || _la==WS) {
				{
				{
				setState(35);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(34);
					match(WS);
					}
				}

				setState(37);
				match(COMMENT);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(43);
			sentence();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(44);
					match(NL);
					setState(46);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(45);
						match(WS);
						}
					}

					}
					}
					setState(50); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NL );
				setState(52);
				sentence();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(58);
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

	public static class SentenceContext extends ParserRuleContext {
		public NodeContext node() {
			return getRuleContext(NodeContext.class,0);
		}
		public TerminalNode NODE_SEPARATOR() { return getToken(DATRParser.NODE_SEPARATOR, 0); }
		public TerminalNode DOT() { return getToken(DATRParser.DOT, 0); }
		public List<EquationContext> equation() {
			return getRuleContexts(EquationContext.class);
		}
		public EquationContext equation(int i) {
			return getRuleContext(EquationContext.class,i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(DATRParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(DATRParser.COMMENT, i);
		}
		public List<TerminalNode> NL() { return getTokens(DATRParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(DATRParser.NL, i);
		}
		public List<TerminalNode> WS() { return getTokens(DATRParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(DATRParser.WS, i);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitSentence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitSentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sentence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			node();
			setState(61);
			match(NODE_SEPARATOR);
			{
			setState(66);
			_la = _input.LA(1);
			if (_la==NL) {
				{
				setState(62);
				match(NL);
				setState(64);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(63);
					match(WS);
					}
				}

				}
			}

			setState(68);
			equation();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				{
				setState(69);
				match(NL);
				setState(71);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(70);
					match(WS);
					}
				}

				}
				setState(73);
				equation();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(79);
			match(DOT);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT || _la==WS) {
				{
				{
				setState(81);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(80);
					match(WS);
					}
				}

				setState(83);
				match(COMMENT);
				}
				}
				setState(88);
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

	public static class EquationContext extends ParserRuleContext {
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(DATRParser.ASSIGN, 0); }
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(DATRParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(DATRParser.WS, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(DATRParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(DATRParser.COMMENT, i);
		}
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterEquation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitEquation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_equation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			lhs();
			setState(91);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(90);
				match(WS);
				}
			}

			setState(93);
			match(ASSIGN);
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(94);
				match(WS);
				}
				break;
			}
			setState(97);
			rhs();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT || _la==WS) {
				{
				{
				setState(99);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(98);
					match(WS);
					}
				}

				setState(101);
				match(COMMENT);
				}
				}
				setState(106);
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

	public static class LhsContext extends ParserRuleContext {
		public TerminalNode LPATH() { return getToken(DATRParser.LPATH, 0); }
		public TerminalNode RPATH() { return getToken(DATRParser.RPATH, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(DATRParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(DATRParser.WS, i);
		}
		public LhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterLhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitLhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitLhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LhsContext lhs() throws RecognitionException {
		LhsContext _localctx = new LhsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(LPATH);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATOM) | (1L << VARIABLE) | (1L << SINGLE_QUOTE) | (1L << WS))) != 0)) {
				{
				{
				setState(109);
				_la = _input.LA(1);
				if (_la==WS) {
					{
					setState(108);
					match(WS);
					}
				}

				setState(111);
				atom();
				setState(113);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(112);
					match(WS);
					}
					break;
				}
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(RPATH);
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

	public static class RhsContext extends ParserRuleContext {
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(DATRParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(DATRParser.WS, i);
		}
		public TerminalNode LPAREN() { return getToken(DATRParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DATRParser.RPAREN, 0); }
		public RhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterRhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitRhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitRhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhsContext rhs() throws RecognitionException {
		RhsContext _localctx = new RhsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rhs);
		int _la;
		try {
			setState(145);
			switch (_input.LA(1)) {
			case COMMENT:
			case ATOM:
			case VARIABLE:
			case NODE:
			case SINGLE_QUOTE:
			case DOUBLE_QUOTE:
			case LPATH:
			case DOT:
			case WS:
			case NL:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATOM) | (1L << VARIABLE) | (1L << NODE) | (1L << SINGLE_QUOTE) | (1L << DOUBLE_QUOTE) | (1L << LPATH))) != 0)) {
					{
					{
					setState(122);
					valueExpression();
					setState(124);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						setState(123);
						match(WS);
						}
						break;
					}
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(LPAREN);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATOM) | (1L << VARIABLE) | (1L << NODE) | (1L << SINGLE_QUOTE) | (1L << DOUBLE_QUOTE) | (1L << LPATH) | (1L << WS))) != 0)) {
					{
					{
					setState(133);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(132);
						match(WS);
						}
					}

					setState(135);
					valueExpression();
					setState(137);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						setState(136);
						match(WS);
						}
						break;
					}
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(RPAREN);
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

	public static class ValueExpressionContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public DescriptorContext descriptor() {
			return getRuleContext(DescriptorContext.class,0);
		}
		public GlobalDescriptorContext globalDescriptor() {
			return getRuleContext(GlobalDescriptorContext.class,0);
		}
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitValueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitValueExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_valueExpression);
		try {
			setState(150);
			switch (_input.LA(1)) {
			case ATOM:
			case VARIABLE:
			case SINGLE_QUOTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				atom();
				}
				break;
			case NODE:
			case LPATH:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				descriptor();
				}
				break;
			case DOUBLE_QUOTE:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				globalDescriptor();
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

	public static class DescriptorContext extends ParserRuleContext {
		public NodeContext node() {
			return getRuleContext(NodeContext.class,0);
		}
		public TerminalNode NODE_SEPARATOR() { return getToken(DATRParser.NODE_SEPARATOR, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public DescriptorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterDescriptor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitDescriptor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitDescriptor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptorContext descriptor() throws RecognitionException {
		DescriptorContext _localctx = new DescriptorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_descriptor);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				node();
				setState(153);
				match(NODE_SEPARATOR);
				setState(154);
				path();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				node();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				path();
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

	public static class GlobalDescriptorContext extends ParserRuleContext {
		public Token lquote;
		public Token rquote;
		public DescriptorContext descriptor() {
			return getRuleContext(DescriptorContext.class,0);
		}
		public List<TerminalNode> DOUBLE_QUOTE() { return getTokens(DATRParser.DOUBLE_QUOTE); }
		public TerminalNode DOUBLE_QUOTE(int i) {
			return getToken(DATRParser.DOUBLE_QUOTE, i);
		}
		public GlobalDescriptorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDescriptor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterGlobalDescriptor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitGlobalDescriptor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitGlobalDescriptor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalDescriptorContext globalDescriptor() throws RecognitionException {
		GlobalDescriptorContext _localctx = new GlobalDescriptorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_globalDescriptor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			((GlobalDescriptorContext)_localctx).lquote = match(DOUBLE_QUOTE);
			setState(161);
			descriptor();
			setState(162);
			((GlobalDescriptorContext)_localctx).rquote = match(DOUBLE_QUOTE);
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

	public static class PathContext extends ParserRuleContext {
		public TerminalNode LPATH() { return getToken(DATRParser.LPATH, 0); }
		public TerminalNode RPATH() { return getToken(DATRParser.RPATH, 0); }
		public List<TerminalNode> WS() { return getTokens(DATRParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(DATRParser.WS, i);
		}
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_path);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(LPATH);
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(165);
				match(WS);
				}
				break;
			}
			setState(176);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ATOM) | (1L << VARIABLE) | (1L << NODE) | (1L << SINGLE_QUOTE) | (1L << DOUBLE_QUOTE) | (1L << LPATH))) != 0)) {
				{
				setState(168);
				valueExpression();
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(169);
						match(WS);
						setState(170);
						valueExpression();
						}
						} 
					}
					setState(175);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				}
			}

			setState(179);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(178);
				match(WS);
				}
			}

			setState(181);
			match(RPATH);
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

	public static class AtomContext extends ParserRuleContext {
		public Token lquote;
		public Token rquote;
		public TerminalNode ATOM() { return getToken(DATRParser.ATOM, 0); }
		public List<TerminalNode> SINGLE_QUOTE() { return getTokens(DATRParser.SINGLE_QUOTE); }
		public TerminalNode SINGLE_QUOTE(int i) {
			return getToken(DATRParser.SINGLE_QUOTE, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atom);
		int _la;
		try {
			setState(193);
			switch (_input.LA(1)) {
			case ATOM:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(ATOM);
				}
				break;
			case SINGLE_QUOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				((AtomContext)_localctx).lquote = match(SINGLE_QUOTE);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << ATOM) | (1L << VARIABLE) | (1L << NODE) | (1L << NODE_CHAR) | (1L << ATOM_CHAR) | (1L << SYMBOL_CHAR) | (1L << CHAR) | (1L << DOUBLE_QUOTE) | (1L << VAR_PREFIX) | (1L << NODE_SEPARATOR) | (1L << COMMENT_SEPARTOR) | (1L << LPAREN) | (1L << RPAREN) | (1L << LPATH) | (1L << RPATH) | (1L << ASSIGN) | (1L << DOT) | (1L << WS))) != 0)) {
					{
					{
					setState(185);
					_la = _input.LA(1);
					if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SINGLE_QUOTE) | (1L << NL))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(191);
				((AtomContext)_localctx).rquote = match(SINGLE_QUOTE);
				}
				break;
			case VARIABLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				variable();
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(DATRParser.VARIABLE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(VARIABLE);
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

	public static class NodeContext extends ParserRuleContext {
		public TerminalNode NODE() { return getToken(DATRParser.NODE, 0); }
		public NodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).enterNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DATRListener ) ((DATRListener)listener).exitNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DATRVisitor ) return ((DATRVisitor<? extends T>)visitor).visitNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeContext node() throws RecognitionException {
		NodeContext _localctx = new NodeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_node);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(NODE);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u00ca\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\5\2!\n\2\3\2\3\2\3\3\5"+
		"\3&\n\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\3\3\3\3\3\5\3\61\n\3\6\3\63\n\3"+
		"\r\3\16\3\64\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4C"+
		"\n\4\5\4E\n\4\3\4\3\4\3\4\5\4J\n\4\3\4\7\4M\n\4\f\4\16\4P\13\4\3\4\3\4"+
		"\5\4T\n\4\3\4\7\4W\n\4\f\4\16\4Z\13\4\3\5\3\5\5\5^\n\5\3\5\3\5\5\5b\n"+
		"\5\3\5\3\5\5\5f\n\5\3\5\7\5i\n\5\f\5\16\5l\13\5\3\6\3\6\5\6p\n\6\3\6\3"+
		"\6\5\6t\n\6\7\6v\n\6\f\6\16\6y\13\6\3\6\3\6\3\7\3\7\5\7\177\n\7\7\7\u0081"+
		"\n\7\f\7\16\7\u0084\13\7\3\7\3\7\5\7\u0088\n\7\3\7\3\7\5\7\u008c\n\7\7"+
		"\7\u008e\n\7\f\7\16\7\u0091\13\7\3\7\5\7\u0094\n\7\3\b\3\b\3\b\5\b\u0099"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a1\n\t\3\n\3\n\3\n\3\n\3\13\3\13\5"+
		"\13\u00a9\n\13\3\13\3\13\3\13\7\13\u00ae\n\13\f\13\16\13\u00b1\13\13\5"+
		"\13\u00b3\n\13\3\13\5\13\u00b6\n\13\3\13\3\13\3\f\3\f\3\f\7\f\u00bd\n"+
		"\f\f\f\16\f\u00c0\13\f\3\f\3\f\5\f\u00c4\n\f\3\r\3\r\3\16\3\16\3\16\2"+
		"\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\3\5\2\3\3\f\f\30\30\u00e0\2\34"+
		"\3\2\2\2\4*\3\2\2\2\6>\3\2\2\2\b[\3\2\2\2\nm\3\2\2\2\f\u0093\3\2\2\2\16"+
		"\u0098\3\2\2\2\20\u00a0\3\2\2\2\22\u00a2\3\2\2\2\24\u00a6\3\2\2\2\26\u00c3"+
		"\3\2\2\2\30\u00c5\3\2\2\2\32\u00c7\3\2\2\2\34\35\5\32\16\2\35\36\7\17"+
		"\2\2\36 \5\n\6\2\37!\7\27\2\2 \37\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\7\2"+
		"\2\3#\3\3\2\2\2$&\7\27\2\2%$\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\')\7\4\2\2("+
		"%\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-9\5\6\4\2"+
		".\60\7\30\2\2/\61\7\27\2\2\60/\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62"+
		".\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\668"+
		"\5\6\4\2\67\62\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2"+
		"\2\2<=\7\2\2\3=\5\3\2\2\2>?\5\32\16\2?D\7\17\2\2@B\7\30\2\2AC\7\27\2\2"+
		"BA\3\2\2\2BC\3\2\2\2CE\3\2\2\2D@\3\2\2\2DE\3\2\2\2EF\3\2\2\2FN\5\b\5\2"+
		"GI\7\30\2\2HJ\7\27\2\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KM\5\b\5\2LG\3\2\2"+
		"\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QX\7\26\2\2RT\7\27"+
		"\2\2SR\3\2\2\2ST\3\2\2\2TU\3\2\2\2UW\7\4\2\2VS\3\2\2\2WZ\3\2\2\2XV\3\2"+
		"\2\2XY\3\2\2\2Y\7\3\2\2\2ZX\3\2\2\2[]\5\n\6\2\\^\7\27\2\2]\\\3\2\2\2]"+
		"^\3\2\2\2^_\3\2\2\2_a\7\25\2\2`b\7\27\2\2a`\3\2\2\2ab\3\2\2\2bc\3\2\2"+
		"\2cj\5\f\7\2df\7\27\2\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2gi\7\4\2\2he\3\2"+
		"\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\t\3\2\2\2lj\3\2\2\2mw\7\23\2\2np\7"+
		"\27\2\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qs\5\26\f\2rt\7\27\2\2sr\3\2\2\2"+
		"st\3\2\2\2tv\3\2\2\2uo\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2"+
		"yw\3\2\2\2z{\7\24\2\2{\13\3\2\2\2|~\5\16\b\2}\177\7\27\2\2~}\3\2\2\2~"+
		"\177\3\2\2\2\177\u0081\3\2\2\2\u0080|\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0094\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0085\u008f\7\21\2\2\u0086\u0088\7\27\2\2\u0087\u0086\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\5\16\b\2\u008a\u008c\7"+
		"\27\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d"+
		"\u0087\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0094\7\22\2\2\u0093"+
		"\u0082\3\2\2\2\u0093\u0085\3\2\2\2\u0094\r\3\2\2\2\u0095\u0099\5\26\f"+
		"\2\u0096\u0099\5\20\t\2\u0097\u0099\5\22\n\2\u0098\u0095\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\17\3\2\2\2\u009a\u009b\5\32\16"+
		"\2\u009b\u009c\7\17\2\2\u009c\u009d\5\24\13\2\u009d\u00a1\3\2\2\2\u009e"+
		"\u00a1\5\32\16\2\u009f\u00a1\5\24\13\2\u00a0\u009a\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\21\3\2\2\2\u00a2\u00a3\7\r\2\2\u00a3"+
		"\u00a4\5\20\t\2\u00a4\u00a5\7\r\2\2\u00a5\23\3\2\2\2\u00a6\u00a8\7\23"+
		"\2\2\u00a7\u00a9\7\27\2\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00b2\3\2\2\2\u00aa\u00af\5\16\b\2\u00ab\u00ac\7\27\2\2\u00ac\u00ae\5"+
		"\16\b\2\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00aa\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b6\7\27\2\2\u00b5"+
		"\u00b4\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7\24"+
		"\2\2\u00b8\25\3\2\2\2\u00b9\u00c4\7\5\2\2\u00ba\u00be\7\f\2\2\u00bb\u00bd"+
		"\n\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c4\7\f"+
		"\2\2\u00c2\u00c4\5\30\r\2\u00c3\u00b9\3\2\2\2\u00c3\u00ba\3\2\2\2\u00c3"+
		"\u00c2\3\2\2\2\u00c4\27\3\2\2\2\u00c5\u00c6\7\6\2\2\u00c6\31\3\2\2\2\u00c7"+
		"\u00c8\7\7\2\2\u00c8\33\3\2\2\2# %*\60\649BDINSX]aejosw~\u0082\u0087\u008b"+
		"\u008f\u0093\u0098\u00a0\u00a8\u00af\u00b2\u00b5\u00be\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}