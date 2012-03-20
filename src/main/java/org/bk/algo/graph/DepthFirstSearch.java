package org.bk.algo.graph;

import java.util.BitSet;

public class DepthFirstSearch {
    private BitSet marked;
    private Graph graph;
    private int startingVertex;
    private int count;
    
    public DepthFirstSearch(Graph graph, int v){
        this.graph = graph;
        this.startingVertex = v;
        marked = new BitSet(graph.verticeCount());
    }
    
    public int getCount(){
        return count;
    }
    
    public void search(){
        search(startingVertex);
    }
    
    private void search(int v){
        marked.set(v);
        System.out.println(v);
        count++;
        for (int w: graph.adj(v)){
            if (!marked.get(w)) search(w);
        }
    }
    
    

}
