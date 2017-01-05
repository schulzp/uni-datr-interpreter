package datr.edu;

import datr.edu.parser.DATRLexer;
import datr.edu.parser.DATRParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeListener;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Interface for mapping text to Datr objects.
 */
public class DatrParser {

    private final DatrVisitor visitor = new DatrVisitor();

    public Result<DatrTheory> parseTheory(String input) {
        return parseTheory(asStream(input));
    }

    public Result<DatrTheory> parseTheory(InputStream resource) {
        datr.edu.DatrParser.ErrorListener errorListener = new datr.edu.DatrParser.ErrorListener();
        DatrParserListener parserListener = new DatrParserListener();
        DATRParser theoryParser = createParser(createTokenStream(resource), errorListener, parserListener);
        DatrTheory theory = null;
        DATRParser.TheoryContext theoryContext = theoryParser.theory();
        if (errorListener.errors.isEmpty()) {
            theory = visitor.visitTheory(theoryContext);
        }
        return new Result<>(theory, parserListener.tokens, errorListener.errors);
    }

    public Result<DatrQuery> parseQuery(String input) {
        datr.edu.DatrParser.ErrorListener errorListener = new datr.edu.DatrParser.ErrorListener();
        DatrParserListener parserListener = new DatrParserListener();
        DATRParser queryParser = createParser(createTokenStream(asStream(input)), errorListener, parserListener);
        DatrQuery datrQuery = null;
        DATRParser.QueryContext queryContext = queryParser.query();
        if (errorListener.errors.isEmpty()) {
            datrQuery = visitor.visitQuery(queryContext);
        }
        return new Result<>(datrQuery, parserListener.tokens, errorListener.errors);
    }

    private TokenStream createTokenStream(InputStream resource) {
        CharStream input = new UnbufferedCharStream(resource);
        DATRLexer lexer = new DATRLexer(input);
        lexer.setTokenFactory(new CommonTokenFactory(true));
        return new UnbufferedTokenStream<CommonToken>(lexer);
    }

    private DATRParser createParser(TokenStream tokens, ErrorListener errorListener, ParseTreeListener parseTreeListener) {
        DATRParser parser = new DATRParser(tokens);
        parser.addParseListener(parseTreeListener);
        parser.addErrorListener(errorListener);
        parser.setBuildParseTree(true);
        return parser;
    }

    private static ByteArrayInputStream asStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    /**
     * Parsing result.
     * @param <T>
     */
    public static class Result<T> {

        public final Optional<T> result;

        public final List<DatrParserListener.Token> tokens;

        public final List<ErrorListener.Error> errors;

        public Result(T result, List<DatrParserListener.Token> tokens, List<ErrorListener.Error> errors) {
            this.result = Optional.ofNullable(result);
            this.tokens = tokens;
            this.errors = errors;
        }

    }

    /**
     * Error tracking.
     */
    public static class ErrorListener extends BaseErrorListener {

        final List<Error> errors = new LinkedList<>();

        public static class Error {

            public final int row;
            public final int col;
            public final String msg;

            public Error(int row, int col, String msg) {
                this.row = row;
                this.col = col;
                this.msg = msg;
            }

        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            errors.add(new Error(line, charPositionInLine, msg));
        }

    }

}
