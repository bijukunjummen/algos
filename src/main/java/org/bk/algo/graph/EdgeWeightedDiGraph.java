package org.bk.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDiGraph {
    private final int V;
    private int E = 0;
    private List<List<DirectedEdge>> adj;

    public EdgeWeightedDiGraph(int V) {
        this.V = V;
        this.adj = new ArrayList<>(V);
        for (int v = 0; v < this.V; v++) {
            adj.set(v, new ArrayList<>());
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        adj.get(v).add(e);
        E++;
    }
}
