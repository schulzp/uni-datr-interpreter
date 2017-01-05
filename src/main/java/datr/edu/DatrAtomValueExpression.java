package datr.edu;

import java.util.Objects;

/**
 * Atomic expression, a literal or symbol.
 */
public class DatrAtomValueExpression implements DatrValueExpression {

    final String value;

    public DatrAtomValueExpression(String value) {
        this.value = value;
    }

    @Override
    public String evaluate(DatrQueryEvaluator evaluator) {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object obj) {
        return DatrAtomValueExpression.class.isInstance(obj) && Objects.equals(((DatrAtomValueExpression) obj).value, value);
    }

    @Override
    public String toString() {
        return Objects.toString(value);
    }
}
