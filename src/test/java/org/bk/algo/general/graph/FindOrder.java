package org.bk.algo.general.graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = createGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        AtomicBoolean hasCycle = new AtomicBoolean(false);
        List<Integer> ordered = new ArrayList<>();
        boolean[] onstack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited, ordered, onstack, hasCycle);
            }
        }
        if (hasCycle.get()) {
            return new int[0];
        }
        return ordered.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int idx, Map<Integer, List<Integer>> graph, boolean[] visited, List<Integer> ordered, boolean[] onstack, AtomicBoolean hasCycle) {
        onstack[idx] = true;
        visited[idx] = true;

        for (Integer child : graph.get(idx)) {
            if (hasCycle.get()) {
                return;
            }
            if (!visited[child]) {
                dfs(child, graph, visited, ordered, onstack, hasCycle);
            } else if (onstack[child]) {
                hasCycle.set(true);
            }
        }
        ordered.add(idx);
        onstack[idx] = false;
    }

    private Map<Integer, List<Integer>> createGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][0];
            int dest = prerequisites[i][1];

            graph.get(src).add(dest);
        }
        return graph;
    }

    @Test
    void testOrder() {
        assertThat(findOrder(2, new int[][]{{1, 0}})).isEqualTo(new int[]{0, 1});
        assertThat(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})).isEqualTo(new int[]{0, 1, 2, 3});
    }
}