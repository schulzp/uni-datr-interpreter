package datr.edu;

import java.util.Optional;

/**
 * A descriptor consisting of either a node, a path, or both.
 */
public class DatrDescriptorValueExpression implements DatrValueExpression {

    final Optional<String> node;
    final Optional<DatrPath> path;

    private final QueryFactory queryFactory;

    public DatrDescriptorValueExpression(Optional<String> node, Optional<DatrPath> path, QueryFactory queryFactory) {
        this.node = node;
        this.path = path;
        this.queryFactory = queryFactory;
    }

    @Override
    public String evaluate(DatrQueryEvaluator evaluator) {
        return evaluator.evaluate(
                queryFactory.create(
                        this.node,
                        this.path.map(p -> p.evaluate(evaluator)),
                        evaluator.environment));
    }

    @Override
    public String toString() {
        return node.map(n -> n + path.map(p -> ":").orElse("")).orElse("") + path.map(Object::toString).orElse("");
    }

    /**
     * Factory for creating sub-queries which may behave differently based on the (global) context.
     */
    @FunctionalInterface
    interface QueryFactory {

        DatrQuery create(
                Optional<String> node,
                Optional<DatrPath<DatrAtomValueExpression>> path,
                DatrQueryEnvironment environment);

    }

}
