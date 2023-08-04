package org.bk.algo.general.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] marked = new boolean[n];
        int numProvince = 0;
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                numProvince++;
                dfs(isConnected, i, marked);
            }
        }
        return numProvince;
    }

    private void dfs(int[][] isConnected, int v, boolean[] marked) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            marked[node] = true;

            List<Integer> children = getChildren(isConnected, node);
            for (Integer child : children) {
                if (!marked[child]) {
                    stack.push(child);
                }
            }
        }
    }

    private List<Integer> getChildren(int[][] isConnected, int v) {
        List<Integer> children = new ArrayList<>();
        int[] connectedNodes = isConnected[v];
        for (int i = 0; i < connectedNodes.length; i++) {
            if (connectedNodes[i] == 1 && i != v) {
                children.add(i);
            }
        }
        return children;
    }

    @Test
    void testProvinces() {
        assertThat(findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}})).isEqualTo(1);
    }
}