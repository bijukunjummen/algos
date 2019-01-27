package org.bk.algo.digraph.weight;

import org.bk.algo.core.Bag;

public class EdgeWeightedDigraph {
    private final int verticeCount;
    private int edgeCount;
    private Bag<DirectedEdge>[] adj;
    
    
    @SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int verticeCount){
        this.verticeCount = verticeCount;
        this.edgeCount = 0;
        this.adj = (Bag<DirectedEdge>[])new Bag[this.verticeCount];
        for (int i=0;i<this.verticeCount;i++){
            adj[i] = new Bag<>();
        }
    }
    
    public int getVerticeCount(){
        return this.verticeCount;
    }
    
    public int getEdgeCount(){
        return this.edgeCount;
    }
    
    public void addEdge(DirectedEdge edge){
        this.adj[edge.from()].add(edge);
        this.edgeCount++;
    }
    
    public Iterable<DirectedEdge> adj(int s){
        return this.adj[s];
    }

}
