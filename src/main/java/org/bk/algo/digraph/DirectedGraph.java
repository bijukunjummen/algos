package org.bk.algo.digraph;

import java.util.ArrayList;
import java.util.List;


public class DirectedGraph {
	private int v; //count of vertices
	private int e; //count of edges
	private List<List<Integer>> adj; //edges to the vertices
	
	public DirectedGraph(int v){
		this.v = v;
		this.adj = new ArrayList<List<Integer>>();
		for (int i=0;i<this.v;i++){
			this.adj.add(new ArrayList<Integer>());
		}
	}
	
	public int getVertexCount(){
		return this.v;
	}
	
	public int getEdgeCount(){
		return this.e;
	}
	
	public void addEdge(int v, int w){
		this.adj.get(v).add(w);
		this.e++;
	}
	
	
	public List<Integer> getEdges(int v){
		return this.adj.get(v);
	}
}
