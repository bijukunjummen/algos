package org.bk.algo.general.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        Deque<Integer> sortedOrder = new ArrayDeque<>();
        Map<Integer, List<Integer>> tree = convertToGraph(vertices, edges);
        Set<Integer> visited = new HashSet<>();

        for (Map.Entry<Integer, List<Integer>> entry : tree.entrySet()) {
            Integer vertex = entry.getKey();

            if (!visited.contains(vertex)) {
                dfs(vertex, tree, visited, sortedOrder);
            }
        }

        return sortedOrder.stream().collect(Collectors.toList());
    }

    private static void dfs(Integer vertex, Map<Integer, List<Integer>> tree, Set<Integer> visited, Deque<Integer> sortedOrder) {
        if (visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);

        for (Integer child : tree.get(vertex)) {
            dfs(child, tree, visited, sortedOrder);
        }
        sortedOrder.push(vertex);
    }


    private static Map<Integer, List<Integer>> convertToGraph(int vertices, int[][] edges) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            tree.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
        }
        return tree;
    }

    @Test
    void testTop() {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        assertThat(result).isEqualTo(List.of(3, 2, 1, 0));

        result = TopologicalSort.sort(5, new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0},
                new int[]{2, 1}, new int[]{3, 1}});
        assertThat(result).isEqualTo(List.of(4, 3, 2, 1, 0));

        result = TopologicalSort.sort(7, new int[][]{new int[]{6, 4}, new int[]{6, 2}, new int[]{5, 3},
                new int[]{5, 4}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}, new int[]{4, 1}});
        assertThat(result).isEqualTo(List.of(6, 5, 4, 3, 2, 1, 0));
    }
}
