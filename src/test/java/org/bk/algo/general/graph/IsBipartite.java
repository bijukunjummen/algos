package org.bk.algo.general.graph;

class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int vertices = graph.length;
        boolean[] marked = new boolean[vertices];
        boolean[] color = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!marked[i]) {
                if (!isBipartite(graph, i, marked, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartite(int[][] graph, int v, boolean[] marked, boolean[] color) {
        marked[v] = true;
        for (int w : graph[v]) {
            if (!marked[w]) {
                color[w] = !color[v];
                if (!isBipartite(graph, w, marked, color)) {
                    return false;
                }
            } else if (color[v] == color[w]) {
                return false;
            }
        }
        return true;
    }
}