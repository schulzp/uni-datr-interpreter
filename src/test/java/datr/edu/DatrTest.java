package datr.edu;

import org.assertj.core.api.Assertions;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

/**
 * Created by peter on 28/11/16.
 */
public class DatrTest {

    @Test
    public void exactMatch() {
        DatrQueryEvaluator evaluator = createEvaluator("N:<a b c> == x.", "N:<a b c>");

        Assert.assertThat(evaluator.evaluate(), CoreMatchers.is("x"));
    }

    @Test
    public void closestMatch() {
        DatrQueryEvaluator evaluator = createEvaluator("N:<a b c> == x.", "N:<a b d>");

        Assert.assertThat(evaluator.evaluate(), CoreMatchers.is("x"));
    }
    @Test
    public void pathReference() {
        DatrQueryEvaluator evaluator = createEvaluator("N:<a> == 0\n<c> == 1.\nN:<b> == <a>.", "N:<b>");

        Assert.assertThat(evaluator.evaluate(), CoreMatchers.is("0"));
    }

    @Test
    public void nodeReference() {
        DatrQueryEvaluator evaluator = createEvaluator("N0:<a> == 0\n<b> == 1.\nN1:<a> == N0.", "N1:<a>");

        Assert.assertThat(evaluator.evaluate(), CoreMatchers.is("0"));
    }

    @Test
    public void fullReference() {
        DatrQueryEvaluator evaluator = createEvaluator("N0:<a> == 0\n<b> == 1.\nN1:<a> == N0:<a>.", "N1:<a>");

        Assert.assertThat(evaluator.evaluate(), CoreMatchers.is("0"));
    }

    @Test
    public void singlePathExtension() {
        DatrQueryEvaluator evaluator = createEvaluator("N0:<b> == 0.\nN0:<b c> == 1.\nN1:<> == N0:<b>.", "N1:<c>");

        Assert.assertThat(evaluator.evaluate(), CoreMatchers.is("1"));
    }

    @Test
    public void multiplePathExtensions() {
        DatrQueryEvaluator evaluator = createEvaluator(
                "N0:<b> == 0\n<d> == 1\n<b d> == 2.\n" + "N1:<b c> == N0:<b>.\n" + "N2:<> == N1:<b>.",
                "N2:<c d>");

        Assert.assertThat(evaluator.evaluate(), CoreMatchers.is("2"));
    }

    @Test
    public void singleGlobalInheritance() {
        DatrQueryEvaluator evaluator = createEvaluator(
                "N0:<full> == \"<base>\" e.\n" + "N1:<full> == N0\n<base> == b.",
                "N1:<full>");

        Assert.assertThat(evaluator.evaluate(), CoreMatchers.is("b e"));
    }

    @Test
    public void multiplePathEvaluations() {
        Assert.assertThat(createEvaluator(COMPLEX_THEORY_1, "N1:<c>").evaluate(), CoreMatchers.is("x"));
        Assert.assertThat(createEvaluator(COMPLEX_THEORY_1, "N1:<c d>").evaluate(), CoreMatchers.is("y"));
    }

    @Test
    public void multipleSubEvaluations() {
        Assert.assertThat(createEvaluator(COMPLEX_THEORY_2, "N1:<a b>").evaluate(), CoreMatchers.is("4 5"));
    }

    @Test
    public void stackOverflow() {
        DatrQueryEvaluator evaluator = createEvaluator(ENDLESS_THEORY, "N:<b>");
        Assertions.assertThatThrownBy(evaluator::evaluate).isInstanceOf(DatrQueryEvaluator.DatrQueryEvaluationException.class);
    }

    @Test
    public void literal() {
        DatrQueryEvaluator evaluator = createEvaluator("N:<a> == 'a b c'.", "N:<a>");
        Assert.assertThat(evaluator.evaluate(), CoreMatchers.is("'a b c'"));
    }

    @Test
    public void theoryErrorHandling() {
        DatrParser datrParser = new DatrParser();
        DatrParser.Result<DatrTheory> datrTheoryResult = datrParser.parseTheory("N1<");
        System.out.println(datrTheoryResult.errors);
    }

    @Test
    public void verb() {
        Assert.assertThat(createEvaluator(VERB, "SINGEN:<dritte sing>").evaluate(), CoreMatchers.is("sing t"));
    }

    private DatrQueryEvaluator createEvaluator(String _theory, String _query) {
        DatrParser datrParser = new DatrParser();
        DatrParser.Result<DatrTheory> datrTheoryResult = datrParser.parseTheory(_theory);
        DatrTheory theory = datrTheoryResult.result.get();
        DatrParser.Result<DatrQuery> datrQueryResult = datrParser.parseQuery(_query);
        DatrQuery query = datrQueryResult.result.get();
        DatrQueryEvaluator evaluator = new DatrQueryEvaluator(theory, query);
        evaluator.setListener(new DatrQueryEvaluator.DatrQueryEvaluationListener() {

            @Override
            public void beforeEquation(DatrEquation equation, DatrQueryEnvironment.Context context, DatrQueryEnvironment environment) {
                String extension = environment.extensions.peek().stream().map(Object::toString).collect(Collectors.joining(" "));
                System.out.print("\n" + getIndent(environment)  + context.node + ":" + context.path);
                System.out.print(" => Matched " + context.node + ":" + equation.lhs);
                if (extension.length() > 0) {
                    System.out.print(" +<" + extension + ">");
                }
            }

            @Override
            public void afterEquation(String result, DatrEquation equation, DatrQueryEnvironment.Context context, DatrQueryEnvironment environment) {
                System.out.print("\n" + getIndent(environment) + "= " + result);
            }

            private String getIndent(DatrQueryEnvironment environment) {
                return environment.extensions.stream().map(ext -> "  ").collect(Collectors.joining());
            }

        });
        return evaluator;
    }

    static final String COMPLEX_THEORY_1 = "" +
            "N0:\n" +
            "  <c>     == < \"<b>\" 0 \"N2\" >\n" +
            "  <2 0 4> == x\n" +
            "  <1 0 3> == y.\n" +
            "\n" +
            "N1:\n" +
            "  <>      == N0\n" +
            "  <b>     == 2\n" +
            "  <b d>   == 1.\n" +
            "\n" +
            "N2:\n" +
            "  <>      == N1\n" +
            "  <b>     == 4\n" +
            "  <b d>   == 3.";

    static final String COMPLEX_THEORY_2 = "" +
            "N0:\n" +
            "  <a>   == N1:<> <c>\n" +
            "  <c b> == 5.\n" +
            "N1:\n" +
            "  <>    == N0\n" +
            "  <b>   == 4.";

    static final String ENDLESS_THEORY = "N:<> == <a>.";

    static final String VERB = "" +
            "VERB:\n" +
            "        <dritte sing> == ( \"<stem>\" t)\n" +
            "        <dritte sing prät> == (\"<stem>\" te)\n" +
            "        <erste sing> == (\"<stem>\" e).\n" +
            "GEHEN:\n" +
            "        <> == VERB\n" +
            "        <dritte sing prät> == ging\n" +
            "        <stem> == geh.\n" +
            "SAGEN:\n" +
            "        <> == VERB\n" +
            "        <stem> == sag.\n" +
            "SINGEN:\n" +
            "        <> == VERB\n" +
            "        <stem> == sing\n" +
            "        <dritte sing prät> == sang.";

}
