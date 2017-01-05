package datr.edu;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertThat;

/**
 * Created by peter on 20/11/16.
 */
public class DatrAtomValueExpressionTest {

    @Rule
    public MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    private DatrQueryEvaluator expressionContext;

    @Test
    public void evaluate() throws Exception {
        DatrValueExpression valueExpression = new DatrAtomValueExpression("a");
        assertThat(valueExpression.evaluate(expressionContext), CoreMatchers.is("a"));
    }

}