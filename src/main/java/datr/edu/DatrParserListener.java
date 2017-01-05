package datr.edu;


import datr.edu.parser.DATRBaseListener;
import datr.edu.parser.DATRParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Maps parsed tree nodes to linear chain of tokens for syntax highlighting.
 */
public class DatrParserListener extends DATRBaseListener {

    public enum Type {
        NODE, PAREN, PATH, QUOTE, COMMENT, LITERAL, ATOM
    }

    public class Token {

        public final Type type;

        public final int start;

        public final int stop;

        public final Token parent;

        public Token(Type type, int start, int stop, Token parent) {
            this.type = type;
            this.start = start;
            this.stop = stop;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return type + "[" + start + ":" + stop + "]";
        }
    }

    private final Deque<Token> anchestors = new LinkedList<>();

    public final List<Token> tokens = new LinkedList<>();

    @Override
    public void exitAtom(DATRParser.AtomContext ctx) {
        if (ctx.lquote != null && ctx.rquote != null) {
            anchestors.push(createToken(Type.LITERAL, ctx.lquote.getStartIndex(), 0));
        }

        tokens.add(createToken(Type.ATOM, ctx));

        if (ctx.lquote != null && ctx.rquote != null) {
            anchestors.pop();
        }
    }

    @Override
    public void exitNode(DATRParser.NodeContext ctx) {
        tokens.add(createToken(Type.NODE, ctx));
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        org.antlr.v4.runtime.Token symbol = node.getSymbol();
        int type = symbol.getType();
        if (type == DATRParser.COMMENT) {
            tokens.add(createToken(Type.COMMENT, symbol.getStartIndex(), symbol.getStopIndex() + 1));
        } else if (type == DATRParser.LPAREN) {
            tokens.add(openToken(Type.PAREN, symbol));
        } else if (type == DATRParser.RPAREN) {
            tokens.add(closeToken(Type.PAREN, symbol));
        } else if (type == DATRParser.LPATH) {
            tokens.add(openToken(Type.PATH, symbol));
        } else if (type == DATRParser.RPATH) {
            tokens.add(closeToken(Type.PATH, symbol));
        } else if (type == DATRParser.DOUBLE_QUOTE) {
            if (anchestors.peek() != null && anchestors.peek().type == Type.QUOTE) {
                tokens.add(closeToken(Type.QUOTE, symbol));
            } else {
                tokens.add(openToken(Type.QUOTE, symbol));
            }
        }
    }

    private Token openToken(Type type, org.antlr.v4.runtime.Token terminal) {
        Token token = createToken(type, terminal.getStartIndex(), terminal.getStopIndex() + 1);
        anchestors.push(token);
        return token;
    }

    private Token closeToken(Type type, org.antlr.v4.runtime.Token terminal) {
        if (anchestors.peek() == null || anchestors.peek().type != type) {
            throw new RuntimeException("Unmatched closing token: " + type);
        }
        Token token = createToken(type, terminal.getStartIndex(), terminal.getStopIndex() + 1);
        anchestors.pop();
        return token;
    }

    private Token createToken(Type type, ParserRuleContext ctx) {
        int start = ctx.getStart().getStartIndex();
        int stop = ctx.getStop().getStopIndex() + 1;
        return createToken(type, start, stop);
    }

    private Token createToken(Type type, int start, int stop) {
        return new Token(type, start, stop, anchestors.peek());
    }

}
