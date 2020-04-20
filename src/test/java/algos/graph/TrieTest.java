package algos.graph;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class TrieTest {

    @Test
    void testTrie() {
        Trie trie = new Trie();
        trie.put("she", "val1");
        trie.put("sells", "val2");

        assertThat(trie.get("she")).isEqualTo("val1");
        assertThat(trie.get("sells")).isEqualTo("val2");

    }
}
