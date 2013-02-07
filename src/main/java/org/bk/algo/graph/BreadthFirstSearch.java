package org.bk.algo.graph;

import java.util.BitSet;

import org.bk.algo.core.Queue;

public class BreadthFirstSearch {
    private BitSet marked;
    private Graph graph;
    private int startingVertex;
    private int count;
    
    public BreadthFirstSearch(Graph graph, int v){
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
        Queue<Integer> vertices = new Queue<Integer>();
        vertices.enqueue(v);
        marked.set(v);
        
        while(!vertices.isEmpty()){
            int w = vertices.dequeue();
            for (int adj: graph.adj(w)){
                if (!marked.get(adj)){
                	System.out.println(w);
                    marked.set(adj);
                    vertices.enqueue(adj);
                }
            }
        }
    }
}
