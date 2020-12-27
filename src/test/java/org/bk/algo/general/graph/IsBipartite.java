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

    private boolean isBipartite(int[][] graph, int v, boolean[] marked, boolean[] opp) {
        marked[v] = true;
        for (int w : graph[v]) {
            if (!marked[w]) {
                opp[w] = !opp[v];
                if (!isBipartite(graph, w, marked, opp)) {
                    return false;
                }
            } else if (opp[v] == opp[w]) {
                return false;
            }
        }
        return true;
    }
}