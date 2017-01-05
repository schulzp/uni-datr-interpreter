package datr.edu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * DATR query environment with multiple contexts.
 */
public class DatrQueryEnvironment {

    public final Context local;
    public final Context global;

    public final DatrQuery query;

    public final Deque<List<DatrAtomValueExpression>> extensions = new LinkedList<>();

    public DatrQueryEnvironment(DatrQuery query) {
        this.query = query;
        this.local = new Context(query);
        this.global = new Context(query);
    }

    public static class Context implements Cloneable {

        public String node;
        public DatrPath<DatrAtomValueExpression> path;

        public Context(Context other) {
            this(other.node, other.path);
        }

        public Context(String node, DatrPath path) {
            this.node = node;
            this.path = path;
        }

        public void set(Context other) {
            this.node = other.node;
            this.path = other.path;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, path);
        }

        @Override
        public boolean equals(Object obj) {
            return Context.class.isInstance(obj)
                    && Objects.equals(((Context) obj).node, node)
                    && Objects.equals(((Context) obj).path, path);
        }

        @Override
        public Context clone() {
            return new Context(this);
        }

        @Override
        public String toString() {
            return node + ":" + path;
        }

    }

}
