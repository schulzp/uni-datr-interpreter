package datr.edu;

import java.util.Map;
import java.util.Set;

/**
 * DATR theory.
 */
public class DatrTheory {

    final Map<String, Set<DatrEquation>> sentences;

    public DatrTheory(Map<String, Set<DatrEquation>> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        return "Theory with " + sentences.size() + " sentences.";
    }

}
