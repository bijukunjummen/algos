package org.bk.algo.graph;

import algos.graph.Trie;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrieTest {

    @Test
    void testTrie() {
        Trie trie = new Trie();
        trie.put("she", "val1");
        trie.put("sells", "val2");

        assertThat(trie.get("she")).isEqualTo("val1");
        assertThat(trie.get("sells")).isEqualTo("val2");
        assertThat(trie.get("abc")).isNull();
    }

    @Test
    void testBinaryMult() {
        System.out.println(4 & 1);
        System.out.println(multiply(8, 4));
    }

    int multiply(int a, int b) {
        int sum = 0;
        for (int i = 0; b != 0; i++) {
            if ((b & 1) != 0) {
                sum += (a << i);
            }
            b = b >> 1;
        }
        return sum;
    }
}
