package datr.edu;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * DATR path.
 */
public class DatrPath<T extends DatrValueExpression> {

    public final List<T> elements;

    public DatrPath(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(elements);
    }

    @Override
    public boolean equals(Object obj) {
        return DatrPath.class.isInstance(obj) && Objects.equals(((DatrPath) obj).elements, this.elements);
    }

    @Override
    public String toString() {
        return "<" + elements.stream().map(Object::toString).collect(Collectors.joining(" ")) + ">";
    }

    public DatrPath<DatrAtomValueExpression> evaluate(DatrQueryEvaluator evaluator) {
        return new DatrPath<>(elements.stream()
                .map(element -> element.evaluate(evaluator))
                .map(DatrAtomValueExpression::new)
                .collect(Collectors.toList()));
    }

}
