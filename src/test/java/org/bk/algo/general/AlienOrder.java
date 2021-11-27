package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AlienOrder {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            populateGraphUsingWords(word1, word2, adjList);
        }

        try {
            List<Character> ordered = topologicalSort(adjList);
            return ordered.stream().map(c -> String.valueOf(c)).collect(Collectors.joining());
        } catch (IllegalStateException illegalStateException) {
            return "";
        }
    }

    private List<Character> topologicalSort(Map<Character, List<Character>> adjList) {
        Deque<Character> reversePostOrderStack = new ArrayDeque<>();
        Set<Character> marked = new HashSet<>();
        Set<Character> onCallStack = new HashSet<>();
        for (Character c : adjList.keySet()) {
            if (!marked.contains(c)) {
                tps(c, adjList, marked, reversePostOrderStack, onCallStack);
            }
        }

        return reversePostOrderStack.stream().collect(Collectors.toList());
    }

    private void tps(Character c,
                     Map<Character, List<Character>> adjList,
                     Set<Character> marked,
                     Deque<Character> reversePostOrderStack,
                     Set<Character> onCallStack) {
        onCallStack.add(c);
        marked.add(c);
        List<Character> deps = adjList.get(c);
        if (deps == null) deps = List.of();
        for (Character w : deps) {
            if (!marked.contains(w)) {
                tps(w, adjList, marked, reversePostOrderStack, onCallStack);
            } else if (onCallStack.contains(w)) {
                throw new IllegalStateException("Has a cycle");
            }
        }
        reversePostOrderStack.push(c);
        onCallStack.remove(c);
    }

    private void populateGraphUsingWords(String word1, String word2, Map<Character, List<Character>> adjList) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
            if (arr1[i] != arr2[i]) {
                adjList.computeIfAbsent(arr1[i], c -> new ArrayList<>());
                adjList.get(arr1[i]).add(arr2[i]);
                return;
            } else {
                adjList.computeIfAbsent(arr1[i], c -> new ArrayList<>());
            }
        }
    }

    @Test
    void testOrder1() {
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        assertThat(alienOrder(words)).isEqualTo("wertf");
    }
}
