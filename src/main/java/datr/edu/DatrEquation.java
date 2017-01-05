package datr.edu;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * DATR equation. A collection of DatrValueExpression objects which is evaluated in a linear fashion.
 */
public class DatrEquation implements DatrValueExpression {

    public final DatrPath<DatrAtomValueExpression> lhs;

    public final List<DatrValueExpression> rhs;

    public DatrEquation(DatrPath<DatrAtomValueExpression> lhs, List<DatrValueExpression> rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String evaluate(DatrQueryEvaluator evaluator) {
        return rhs.stream().map(exp -> exp.evaluate(evaluator)).collect(Collectors.joining(" "));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lhs);
    }

    @Override
    public boolean equals(Object obj) {
        return DatrEquation.class.isInstance(obj) && Objects.equals(((DatrEquation) obj).lhs, this.lhs);
    }

    @Override
    public String toString() {
        return lhs.toString() + " == " + rhs.stream().map(DatrValueExpression::toString).collect(Collectors.joining(" "));
    }

}
