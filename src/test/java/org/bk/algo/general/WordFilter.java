package org.bk.algo.general;

import java.util.HashMap;
import java.util.Map;

class WordFilter {
    private Trie trie = new Trie();

    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            trie.add(word, i);
        }
    }

    public int f(String prefix, String suffix) {
        return trie.find(prefix, suffix);
    }

    static class Trie {
        private TrieNode root = new TrieNode();

        public void add(String str, int index) {
            root.add(str, str, index);
        }

        public int find(String prefix, String suffix) {
            TrieNode trieNode = root.find(prefix);
            if (trieNode == null) {
                return -1;
            }
            if (trieNode.fullWord.contains(suffix)) {
                return trieNode.index;
            }
            return -1;
        }
    }

    static class TrieNode {
        private Map<Character, TrieNode> nodes = new HashMap<>();
        private boolean word = false;
        private String fullWord = "";
        private int index = -1;

        public void add(String original, String str, int index) {
            if (str.length() == 0) return;
            char first = str.charAt(0);
            nodes.computeIfAbsent(first, c -> new TrieNode());
            TrieNode trieNodeforChar = nodes.get(first);
            if (str.length() == 1) {
                trieNodeforChar.word = true;
                trieNodeforChar.fullWord = original;
                trieNodeforChar.index = index;
            } else {
                trieNodeforChar.add(original, str.substring(1), index);
            }
        }

        public TrieNode find(String prefix) {
            if (prefix.length() == 0) {
                return this;
            }
            Character c = prefix.charAt(0);
            if (nodes.containsKey(c)) {
                return nodes.get(c).find(prefix.substring(1));
            }
            return null;
        }
    }
}