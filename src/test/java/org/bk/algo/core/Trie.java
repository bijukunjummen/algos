package org.bk.algo.core;

import java.util.Map;

public class Trie {


    record TrieNode(Map<Character, TrieNode> nodes, String prefix,  boolean isWord) {}
}
