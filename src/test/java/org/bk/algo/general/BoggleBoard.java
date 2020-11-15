package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BoggleBoard {
    static final String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GUQ", "EE"};
    static final int n = dictionary.length;
    static final int M = 3, N = 3;

    static boolean isWord(String str) {
        for (int i = 0; i < n; i++)
            if (str.equals(dictionary[i]))
                return true;
        return false;
    }

    static List<String> findWordsUtil(final int r, final int c, final boolean[][] visited, final char[][] boggle,
                                      final String prefix, final List<String> words) {
        String s = prefix + boggle[r][c];

        visited[r][c] = true;

        if (isWord(s)) {
            words.add(s);
        }
        for (int i = r - 1; i <= r + 1 && i < M; i++) {
            for (int j = c - 1; j <= c + 1 && j < N; j++) {
                if (i >= 0 && j >= 0 && !visited[i][j]) {
                    findWordsUtil(i, j, visited, boggle, s, words);
                }
            }
        }
        visited[r][c] = false;
        return words;
    }

    static List<String> findWords(char boggle[][]) {
        boolean visited[][] = new boolean[M][N];

        // Initialize current string
        String str = "";

        List<String> words = new ArrayList<>();

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                findWordsUtil(i, j, visited, boggle, str, words);

        return words;
    }

    public static void main(String args[]) {
        char[][] boggle = {
                {'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        System.out.println("Following words of dictionary are present");
        System.out.println(findWords(boggle));
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void addWord(String word) {
            root.addNode(0, word.toCharArray());
        }

        public boolean hasPrefix(String s) {
            return root.hasPrefix(0, s.toCharArray());
        }

        public boolean isWord(String s) {
            return root.isWord(0, s.toCharArray());
        }
    }

    static class TrieNode {
        private Map<Character, TrieNode> children;
        private boolean word;

        public TrieNode() {
            this(false);

        }

        public TrieNode(boolean word) {
            this.children = new HashMap<>();
            this.word = word;
        }

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public boolean isWord() {
            return word;
        }

        public boolean isWord(int idx, char[] rem) {
            if (idx == rem.length) {
                return isWord();
            }
            Character c = rem[idx];
            if (children.containsKey(c)) {
                return children.get(c).isWord(idx + 1, rem);
            }
            return false;
        }

        public boolean hasPrefix(int idx, char[] rem) {
            if (idx == rem.length) {
                return true;
            }
            Character c = rem[idx];
            if (children.containsKey(c)) {
                return children.get(c).hasPrefix(idx + 1, rem);
            }
            return false;
        }

        public void addNode(int idx, char[] remaining) {
            if (idx == remaining.length - 1) {
                children.computeIfAbsent(remaining[idx], (ignored) -> new TrieNode(true));
                return;
            } else {
                children.computeIfAbsent(remaining[idx], (ignored) -> new TrieNode(false));
            }
            children.get(remaining[idx]).addNode(idx + 1, remaining);
        }
    }

    @Test
    void trieTest() {
        Trie trie = new Trie();
        trie.addWord("test");
        assertThat(trie.hasPrefix("te")).isTrue();
        assertThat(trie.hasPrefix("ab")).isFalse();

        trie.addWord("abc");
        assertThat(trie.hasPrefix("ab")).isTrue();
        assertThat(trie.isWord("test")).isTrue();
        assertThat(trie.isWord("abc")).isTrue();
        assertThat(trie.isWord("ab")).isFalse();
    }
} 