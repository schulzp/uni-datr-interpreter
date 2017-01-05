package datr.edu;

import java.util.Set;

/**
 * DATR sentence.
 */
public class DatrSentence {

    final Set<DatrEquation> equations;
    final String node;

    public DatrSentence(String node, Set<DatrEquation> equations) {
        this.node = node;
        this.equations = equations;
    }

}
