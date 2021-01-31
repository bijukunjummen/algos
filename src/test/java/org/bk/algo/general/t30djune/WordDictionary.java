package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class WordDictionary {

    Trie trie = new Trie();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    public void addWord(String word) {
        trie.addWord(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void addWord(String word) {
            root.addWord(word);
        }

        boolean search(String word) {
            return root.search(word);
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> nodes = new HashMap<>();
        boolean word;

        boolean search(String s) {
            if (s.length() == 0) {
                return word;
            }

            Character c = s.charAt(0);
            String sub = s.substring(1);

            if (c == '.') {
                return nodes.values().stream().anyMatch(child -> child.search(sub));
            } else {
                return (nodes.containsKey(c) && nodes.get(c).search(sub));
            }
        }

        void addWord(String s) {
            if (s.length() == 0) {
                word = true;
                return;
            }
            Character c = s.charAt(0);
            String sub = s.substring(1);
            if (!nodes.containsKey(c)) {
                nodes.put(c, new TrieNode());
            }
            nodes.get(c).addWord(sub);
        }
    }

    @Test
    void testBasics() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("test");
        dictionary.addWord("another");
        assertThat(dictionary.search("test")).isTrue();
        assertThat(dictionary.search("testanother")).isFalse();
        assertThat(dictionary.search("another")).isTrue();
        assertThat(dictionary.search(".noth.r")).isTrue();
    }

    @Test
    void testBasics2() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        dictionary.addWord("a");
        assertThat(dictionary.search("a")).isTrue();
        assertThat(dictionary.search(".at")).isFalse();
        dictionary.addWord("bat");
        assertThat(dictionary.search(".at")).isTrue();
        assertThat(dictionary.search("an.")).isTrue();
        assertThat(dictionary.search("a.d.")).isFalse();
        assertThat(dictionary.search("b.")).isFalse();
        assertThat(dictionary.search("a.d")).isTrue();
        assertThat(dictionary.search(".")).isTrue();
    }
}
