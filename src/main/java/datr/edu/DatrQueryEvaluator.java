package datr.edu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * DATR query evaluation logic.
 */
public class DatrQueryEvaluator {

    final DatrTheory theory;

    final DatrQueryEnvironment environment;

    final Map<DatrQueryEnvironment.Context, AtomicInteger> visits = new HashMap<>();

    private Optional<DatrQueryEvaluationListener> listener = Optional.empty();

    private int maxVisits = 20;

    public DatrQueryEvaluator(DatrTheory theory, DatrQuery query) {
        this.theory = theory;
        this.environment = new DatrQueryEnvironment(query);
    }

    public void setMaxVisits(int maxVisits) {
        this.maxVisits = maxVisits;
    }

    public String evaluate() throws DatrQueryEvaluationException {
        return evaluate(environment.query);
    }

    public void setListener(DatrQueryEvaluationListener listener) {
        this.listener = Optional.ofNullable(listener);
    }

    String evaluate(DatrQuery query) throws DatrQueryEvaluationException {
        DatrPath<DatrAtomValueExpression> path = DatrPathUtils.extend(query.path, environment.extensions.peek());
        DatrQueryEnvironment.Context context = environment.local.clone();

        return theory.sentences.get(query.node).stream()
                .sorted(Comparator.comparing(
                        equation -> equation.lhs.elements,
                        DatrPathUtils.changeComparator(path.elements)))
                .findFirst().map(eq -> {
                    try {
                        environment.extensions.push(DatrPathUtils.extension(eq.lhs.elements, path.elements));
                        environment.local.node = query.node;
                        environment.local.path = eq.lhs;

                        int visits = this.visits.computeIfAbsent(environment.local, k -> new AtomicInteger()).getAndIncrement();
                        if (visits > maxVisits) {
                            throw new DatrQueryEvaluationException("Context " + environment.local + " has been visited " + visits + " times. There might be an endless recursion.");
                        }

                        listener.ifPresent(l -> l.beforeEquation(eq, query, this.environment));
                        String result = eq.evaluate(this);
                        listener.ifPresent(l -> l.afterEquation(result, eq, query, this.environment));
                        return result;
                    } finally {
                        environment.local.set(context);
                        environment.extensions.pop();
                    }
                }).orElseThrow(() -> new DatrQueryEvaluationException("Unable to evaluate " + query));

    }

    public interface DatrQueryEvaluationListener {

        void beforeEquation(DatrEquation equation, DatrQueryEnvironment.Context context, DatrQueryEnvironment environment);

        void afterEquation(String result, DatrEquation equation, DatrQueryEnvironment.Context context, DatrQueryEnvironment environment);

    }

    public static class DatrQueryEvaluationException extends RuntimeException {

        public DatrQueryEvaluationException(String message) {
            super(message);
        }

    }

}
