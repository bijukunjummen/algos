package org.bk.algo.general.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CountComponents {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = createAdjacency(n, edges);
        boolean[] marked = new boolean[n];

        int c = 0;
        for (int v = 0; v < n; v++) {
            if (!marked[v]) {
                c++;
                dfs(v, graph, marked);
            }
        }

        return c;
    }


    private Map<Integer, List<Integer>> createAdjacency(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int w = edges[i][1];
            graph.computeIfAbsent(v, ignore -> new ArrayList<>());
            graph.computeIfAbsent(w, ignore -> new ArrayList<>());
            graph.get(v).add(w);
            graph.get(w).add(v);
        }
        return graph;
    }

    private void dfs(int v, Map<Integer, List<Integer>> graph, boolean[] marked) {
        marked[v] = true;
        for (int w : graph.getOrDefault(v, Collections.emptyList())) {
            if (!marked[w]) {
                dfs(w, graph, marked);
            }
        }
    }

    @Test
    void testCountComp() {
        assertThat(countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}})).isEqualTo(2);
        assertThat(countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}})).isEqualTo(1);
    }
}