package org.bk.algo.graph.directed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SymbolDirectedGraph<T> {
	private Map<T, Integer> indexMap; //Mapping a text name to index in graph
	private int currentIndex=0;
	private DirectedGraph directedGraph;
	
	private List<T> keys;
	
	public SymbolDirectedGraph(int v){
		this.directedGraph = new DirectedGraph(v);
		this.indexMap = new HashMap<T, Integer>();
		this.keys = new ArrayList<T>();
	}
	
	public void addVertexAndEdges(T vertex, List<T> destinations){
		int vertexIndex = this.addAndGetIndex(vertex);
		
		for (T destination:destinations){
			int destinationIndex = this.addAndGetIndex(destination);
			this.directedGraph.addEdge(vertexIndex, destinationIndex);
		}
	}
	
	private int addAndGetIndex(T vertexKey){
		if(!contains(vertexKey)){
			this.keys.add(this.currentIndex, vertexKey);
			this.indexMap.put(vertexKey, this.currentIndex++);
		}
		return this.indexMap.get(vertexKey);
	}
	
	public List<T> getAdjacentsForVertex(T vertexKey){
		List<Integer> edges = this.directedGraph.getEdges(this.indexMap.get(vertexKey));
		List<T> edgestext = new ArrayList<T>();
		if (edges!=null){
			for (Integer edge: edges){
				edgestext.add(this.keys.get(edge));
			}
		}
		return edgestext;
	}
	
	public boolean contains(T vertexKey){
		return this.indexMap.containsKey(vertexKey);
	}
	
	@Override
	public String toString(){
		StringBuilder buffer = new StringBuilder();
		for (T key: this.keys){
			buffer.append(key).append(":").append(getAdjacentsForVertex(key));
			buffer.append("\n");
		}
		
		return buffer.toString();
	}
	

}
