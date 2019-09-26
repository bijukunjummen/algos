package org.bk.algo.graph;


import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int v;

    private List<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        this.adj = (List<Integer>[]) new List[v];

        for (int i = 0; i < v; i++) {
            this.adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
    }

    public int degree(int v) {
        return this.adj[v].size();
    }

    public int verticeCount() {
        return this.v;
    }

    public List<Integer> adj(int v) {
        return this.adj[v];
    }

}
