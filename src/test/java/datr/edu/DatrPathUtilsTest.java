package datr.edu;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by peter on 28/11/16.
 */
public class DatrPathUtilsTest {

    @Test
    public void sharedPrefix() {
        List<String> shared = DatrPathUtils.sharedPrefix(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("a", "b", "d"));

        assertThat(shared, CoreMatchers.equalTo(Arrays.asList("a", "b")));

        shared = DatrPathUtils.sharedPrefix(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("b", "c", "d"));

        assertThat(shared.isEmpty(), is(true));
    }


    @Test
    public void extension() {
        assertThat(
                DatrPathUtils.extension(Arrays.asList("a", "b", "c"), Arrays.asList("a", "b", "d", "e")),
                is(Arrays.asList("d", "e")));
        assertThat(
                DatrPathUtils.extension(Arrays.asList("a", "b"), Arrays.asList("a", "b", "c")),
                is(Arrays.asList("c")));
    }

    @Test
    public void comparison() {
        List<String> l0 = Collections.emptyList();
        List<String> l1 = Arrays.asList("a");
        List<String> l2 = Arrays.asList("a", "b");
        List<String> l3 = Arrays.asList("a", "b", "c");
        List<String> l4 = Arrays.asList("a", "c", "b");

        assertThat("Expected empty-list fall-back", sort(Arrays.asList(l4, l3, l2, l1, l0), "b").get(0), is(l0));
        assertThat("Expected perfect match (prefix-length 1)", sort(Arrays.asList(l4, l3, l2, l1, l0), "a").get(0), is(l1));
        assertThat("Expected perfect match (prefix-length 2)", sort(Arrays.asList(l4, l3, l2, l1, l0), "a", "b").get(0), is(l2));
        assertThat("Expected perfect match (prefix-length 3)", sort(Arrays.asList(l4, l3, l2, l1, l0), "a", "b", "c").get(0), is(l3));
        assertThat("Expected partial match (prefix-length 2)", sort(Arrays.asList(l0, l1, l2, l3, l4), "a", "c").get(0), is(l1));
    }

    @Test
    public void comparison2() {
        List<String> l0 = Collections.emptyList();
        List<String> l3 = Arrays.asList("a", "b", "c");

        assertThat("Expected perfect match (prefix-length 3)", sort(Arrays.asList(l0, l3), "a", "b").get(0), is(l0));
    }

    private List<List<String>> sort(List<List<String>> lists, String...reference) {
        Comparator<List<String>> comparator = DatrPathUtils.changeComparator(Arrays.asList(reference));
        Collections.sort(lists, comparator);
        return lists;
    }

}