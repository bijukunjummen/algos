package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NumIslandsGraphRep {
    public int numIslands(char[][] grid) {
        Graph graph = convertToGraph(grid);
        boolean[] marked = new boolean[graph.v];
        int count = 0;
        for (int i = 0; i < graph.v; i++) {
            if (!graph.isIgnoredIndex(i) && !marked[i]) {
                dfs(graph, i, marked);
                count++;
            }
        }
        return count;
    }

    private Graph convertToGraph(char[][] grid) {
        int numRows = grid.length;
        int numCols = numRows > 0 ? grid[0].length : 0;
        Graph graph = new Graph(numRows * numCols);

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                char ch = grid[r][c];
                int index = indexFrom(r, c, numRows, numCols);
                if (ch == '0') {
                    graph.addIgnoredIndexes(index);
                } else {
                    List<Integer> adjacentIndexes = getAdj(r, c, index, numRows, numCols);
                    for (int adjIdx : adjacentIndexes) {
                        graph.addEdge(index, adjIdx);
                    }
                }
            }
        }
        return graph;
    }

    private void dfs(Graph graph, int v, boolean[] marked) {
        marked[v] = true;
        for (int w : graph.adj.get(v)) {
            if (!marked[w]) {
                dfs(graph, w, marked);
            }
        }
    }

    private List<Integer> getAdj(int r, int c, int index, int numRows, int numCols) {
        List<int[]> list = new ArrayList<>();
        if (r - 1 >= 0) {
            list.add(new int[]{r - 1, c});
        }
        if (r + 1 <= numRows - 1) {
            list.add(new int[]{r + 1, c});
        }

        if (c - 1 >= 0) {
            list.add(new int[]{r, c - 1});
        }
        if (c + 1 <= numCols - 1) {
            list.add(new int[]{r, c + 1});
        }

        return list.stream()
                .map(intArr -> indexFrom(intArr[0], intArr[1], numRows, numCols))
                .collect(Collectors.toList());
    }

    private int indexFrom(int r, int c, int numRows, int numCols) {
        return r * numCols + c;
    }

    static class Graph {
        int v;
        int e;
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> ignoredIndexes = new HashSet<>();

        Graph(int v) {
            this.v = v;
            for (int i = 0; i < v; i++) {
                this.adj.add(new ArrayList<>());
            }
        }

        void addEdge(int v, int w) {
            this.adj.get(v).add(w);
        }

        void addIgnoredIndexes(int v) {
            ignoredIndexes.add(v);
        }

        boolean isIgnoredIndex(int v) {
            return this.ignoredIndexes.contains(v);
        }
    }

    @Test
    void testIslands() {
        char[][] grid1 =
                {
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                };
        assertThat(numIslands(grid1)).isEqualTo(1);

        char[][] grid2 =
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };
        assertThat(numIslands(grid2)).isEqualTo(3);

        char[][] emptyGrid = {};
        assertThat(numIslands(emptyGrid)).isEqualTo(0);

    }
}