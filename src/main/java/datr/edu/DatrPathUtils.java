package datr.edu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * DATR path logic.
 */
public class DatrPathUtils {

    public static <T> Comparator<List<T>> changeComparator(List<T> reference) {
        return (a, b) -> {
            List<T> sharedWithA = sharedPrefix(a, reference);
            int overheadA = a.size() - sharedWithA.size();
            List<T> sharedWithB = sharedPrefix(b, reference);
            int overheadB = b.size() - sharedWithB.size();
            if (sharedWithA.size() > 0 && sharedWithB.size() > 0) {
                int prefixRelation = Integer.compare(sharedWithA.size(), sharedWithB.size());
                if (prefixRelation == 0) {
                    return Integer.compare(a.size(), b.size());
                }
                return -prefixRelation;
            } else if (sharedWithA.size() > 0) {
                return overheadA > overheadB ? 1 : -1;
            } else if (sharedWithB.size() > 0) {
                return 1;
            } else if (sharedWithA.size() == 0 && sharedWithB.size() == 0) {
                if (a.isEmpty() && !b.isEmpty()) {
                    return -1;
                } else if (!a.isEmpty() && b.isEmpty()) {
                    return 1;
                }
            }
            return 0;
        };
    }

    public static <T> List<T> sharedPrefix(List<T> a, List<T> b) {
        int i;
        for (i = 0; i < Math.min(a.size(), b.size()); ++i) {
            if (!a.get(i).equals(b.get(i))) {
                break;
            }
        }
        return a.subList(0, i);
    }

    public static <T extends DatrValueExpression> DatrPath<T> extend(DatrPath<T> path, List<T> with) {
        List<T> elements;
        if (Objects.isNull(with) || with.isEmpty()) {
            elements = new ArrayList<>(path.elements);
        } else {
            elements = new ArrayList<>(path.elements.size() + with.size());
            elements.addAll(path.elements);
            elements.addAll(with);
        }
        return new DatrPath<>(elements);
    }

    public static <T> List<T> extension(List<T> lhs, List<T> rhs) {
        return rhs.subList(sharedPrefix(lhs, rhs).size(), rhs.size());
    }

}
