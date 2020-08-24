package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class WordDictionary {

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        char[] cs = word.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            TrieNode forChar = current.getAndAssignNodeFor(c);
            if (i == cs.length - 1) {
                forChar.setToValidWord();
            }
            current = forChar;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one
     * letter.
     */
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Queue<TrieNodeAndDepth> queue = new ArrayDeque();
        queue.add(new TrieNodeAndDepth(0, root));
        int targetDepth = cs.length;
        while (!queue.isEmpty()) {
            TrieNodeAndDepth node = queue.poll();

            boolean hasWord = hasWord(node, targetDepth);
            if (hasWord) {
                return true;
            }
            if (node.depth >= targetDepth) {
                continue;
            }

            char letter = cs[node.depth];
            if (letter == '.') {
                List<TrieNode> children = node.trieNode.getAllNonEmptyChildren();
                for (TrieNode child : children) {
                    queue.add(new TrieNodeAndDepth(node.depth + 1, child));
                }
            } else {
                TrieNode child = node.trieNode.getNodeFor(letter);
                if (child != null) {
                    queue.add(new TrieNodeAndDepth(node.depth + 1, child));
                }
            }
        }

        return false;
    }

    private boolean hasWord(TrieNodeAndDepth node, int targetDepth) {
        if (node.depth == targetDepth && node.trieNode.isValidWord()) {
            return true;
        }
        return false;
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

class TrieNodeAndDepth {
    int depth;
    TrieNode trieNode;

    TrieNodeAndDepth(int depth, TrieNode trieNode) {
        this.depth = depth;
        this.trieNode = trieNode;
    }

}


class TrieNode {
    private static final int RADIX = 'z' - 'a' + 1;
    private final TrieNode[] nodes = new TrieNode[RADIX];
    private boolean validWord = false;

    public void setToValidWord() {
        this.validWord = true;
    }

    public boolean isValidWord() {
        return validWord;
    }

    public TrieNode getNodeFor(char c) {
        return nodes[c - 'a'];
    }

    public void setNodeFor(char c) {
        nodes[c - 'a'] = new TrieNode();
    }

    public TrieNode getAndAssignNodeFor(char c) {
        TrieNode node = getNodeFor(c);
        if (node == null) {
            setNodeFor(c);
        }
        return getNodeFor(c);
    }

    public List<TrieNode> getAllNonEmptyChildren() {
        List<TrieNode> children = new ArrayList<>();
        for (TrieNode node : nodes) {
            if (node != null) {
                children.add(node);
            }
        }
        return children;
    }
}