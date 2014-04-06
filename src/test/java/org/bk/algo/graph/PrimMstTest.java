package org.bk.algo.graph;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.bk.algo.ws.Job;
import org.bk.algo.ws.Jobs;
import org.bk.algo.ws.JobsTest;
import org.junit.Test;

public class PrimMstTest {
	private EdgeWeightedGraph loadSample() {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(JobsTest.class.getResourceAsStream("/edges.txt")));
    	try{
    		String edgeMeta = reader.readLine();
    		String[] metaToken = edgeMeta.split(" ");
    		EdgeWeightedGraph graph = new EdgeWeightedGraph(Integer.parseInt(metaToken[0]));
    		
    		String line = reader.readLine();
    		while (line!=null){
    			String[] tkns = line.split(" ");
    			graph.addEdge(new Edge(Integer.parseInt(tkns[0]) - 1, Integer.parseInt(tkns[1]) - 1, Integer.parseInt(tkns[2])));
    			line = reader.readLine();
    		}
    		return graph;
    	}catch(IOException ioException){
    		throw new RuntimeException(ioException);
    	}
    	
	}
	@Test
	public void testPrim() {
		EdgeWeightedGraph graph = loadSample();
		PrimMST primMST = new PrimMST(graph);
		double w = 0.0;
		for (Edge edge: primMST.edges()) {
			w+=edge.weight();
		}
		System.out.println(w);
		
	}

}
