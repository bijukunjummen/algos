package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AlienOrder {
    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String word : words) {
            for  (char c : word.toCharArray()) {
                graph.computeIfAbsent(c, k -> new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            createGraphFrom(words[i], words[i + 1], graph);
        }

        System.out.println(graph);
        List<Character> sorted = topologicalSort(graph);
        String str  = sorted.stream().map(c -> c.toString()).collect(Collectors.joining());
        return str;
    }

    private void createGraphFrom(String w1, String w2, Map<Character, Set<Character>> graph) {
        int len1 = w1.length();
        int len2 = w2.length();
        int i = 0;
        int upto = Math.min(len1, len2);
        while (i < upto && w1.charAt(i) == w2.charAt(i) ) {
            i++;
        }
        if (i == upto) {
            return;
        }
        if (w1.charAt(i) != w2.charAt(i)) {
            graph.get(w1.charAt(i)).add(w2.charAt(i));
        }
    }

    private List<Character> topologicalSort(Map<Character, Set<Character>> graph) {
        List<Character> sorted = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        Set<Character> onStack = new HashSet<>();
        try {
            traverse(graph, sorted, visited, onStack);
        }catch (IllegalStateException e) {
//            e.printStackTrace();
            return List.of();
        }
        return sorted.reversed();
    }

    private void traverse(Map<Character, Set<Character>> graph, List<Character> sorted, Set<Character> visited, Set<Character> onStack) {
        for (Character c: graph.keySet()) {
            if (!visited.contains(c)) {
                traverse(graph, c, sorted, visited, onStack);
            }
        }
    }

    private void traverse(Map<Character, Set<Character>> graph, Character c, List<Character> sorted,
                          Set<Character> visited, Set<Character> onStack) {
        if (visited.contains(c)) {
            return;
        }
        onStack.add(c);
        visited.add(c);
        if (graph.containsKey(c)) {
            for (Character child : graph.get(c)) {
                if (!visited.contains(child)) {
                    traverse(graph, child, sorted, visited, onStack);
                } else if (onStack.contains(child)) {
                    throw new IllegalStateException("cycle..");
                }
            }
        }
        sorted.add(c);
        onStack.remove(c);
    }


    @Test
    void testOrder1() {
        assertThat(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"})).isEqualTo("wertf");
        assertThat(alienOrder(new String[]{"z", "x"})).isEqualTo("zx");
        assertThat(alienOrder(new String[]{"z", "x", "z"})).isEqualTo("");
        assertThat(alienOrder(new String[]{"z", "z"})).isEqualTo("z");
    }
}
