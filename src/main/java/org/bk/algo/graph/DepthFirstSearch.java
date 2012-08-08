package org.bk.algo.graph;

import java.util.BitSet;

import org.bk.algo.core.Stack;

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
    
    public void iterativeSearch(){
    	iterativeSearch(startingVertex);
    }
    
    private void search(int v){
        marked.set(v);
        System.out.println(v);
        count++;
        for (int w: graph.adj(v)){
            if (!marked.get(w)) search(w);
        }
    }
    
    private void iterativeSearch(int v){
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.push(v);
    	marked.set(v);
    	System.out.println(v);
    	while (!stack.isEmpty()){
    		int w = stack.pop();
    		for (int adj:graph.adj(w)){
    			if (!marked.get(adj)){
    				marked.set(adj);
    				System.out.println(adj);
    				stack.push(adj);
    			}
    		}
    	}
    }
    
    

}
