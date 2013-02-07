package org.bk.algo.graph;

import org.bk.algo.core.Bag;

public class Graph {
    private final int v;
    private int e;
    
    private Bag<Integer>[] adj;
    
    public Graph(int v){
        this.v = v;
        this.e = 0;
        this.adj = (Bag<Integer>[])new Bag[v];
        
        for (int i=0;i<v;i++){
            this.adj[i] = new Bag<Integer>();
        }
    }
    
    public void addEdge(int v, int w){
        this.adj[v].add(w);
    }
    
    public int degree(int v){
        return this.adj[v].size();
    }
    
    public int verticeCount(){
        return this.v;
    }
    
    public Bag<Integer> adj(int v){
        return this.adj[v];
    }
    
}
