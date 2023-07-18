package org.bk.algo.general.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.assertj.core.api.Assertions.assertThat;

class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        boolean[] marked = new boolean[n];
        AtomicBoolean cycle = new AtomicBoolean(false);
        Deque<Integer> stack = new ArrayDeque<>();
        int components = 0;
        for (int v = 0; v < n; v++) {
            if (!marked[v]) {
                components++;
                dfs(v, -1, n, edges, marked, cycle, stack);
            }
        }
        if (components != 1) return false;
        if (cycle.get()) return false;

        return true;
    }

    private void dfs(int v, int u, int n, int[][] edges, boolean[] marked, AtomicBoolean cycle, Deque<Integer> stack) {
        if (cycle.get()) {
            return;
        }
        marked[v] = true;
        stack.push(v);
        for (int w : getEdges(v, edges, marked)) {
            if (!marked[w]) {
                dfs(w, v, n, edges, marked, cycle, stack);
            } else if (w != u && stack.contains(w)) {
                cycle.set(true);
            }
        }
        stack.pop();
    }

    private int[] getEdges(int v, int[][] edges, boolean[] marked) {
        List<Integer> other = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == v) {
                other.add(edges[i][1]);
            } else if (edges[i][1] == v) {
                other.add(edges[i][0]);
            }
        }
        return other.stream().mapToInt(n -> n).toArray();
    }

    @Test
    void testTree() {
        assertThat(validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}})).isTrue();
    }

    @Test
    void testTreeCycle() {
        assertThat(validTree(3, new int[][]{{0, 1}, {0, 2}, {1, 2}})).isFalse();
    }

    @Test
    void testLine() {
        assertThat(validTree(4, new int[][]{{0, 1}, {2, 3}, {1, 2}})).isTrue();
    }

    @Test
    void testDuo() {
        assertThat(validTree(2, new int[][]{{1, 0}})).isTrue();
    }
}