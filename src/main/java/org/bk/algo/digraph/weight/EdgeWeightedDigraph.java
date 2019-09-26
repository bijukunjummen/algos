package org.bk.algo.digraph.weight;


import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
    private final int verticeCount;
    private int edgeCount;
    private List<DirectedEdge>[] adj;
    
    
    @SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int verticeCount){
        this.verticeCount = verticeCount;
        this.edgeCount = 0;
        this.adj = (List<DirectedEdge>[])new List[this.verticeCount];
        for (int i=0;i<this.verticeCount;i++){
            adj[i] = new ArrayList<>();
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
