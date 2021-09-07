package org.bk.algo.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GraphTest {

    private Graph graph;
    
    @BeforeEach
    public void setUp(){
        graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);

        graph.addEdge(1, 0);
        graph.addEdge(1, 2);

        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        graph.addEdge(4, 2);
        graph.addEdge(4, 3);

        graph.addEdge(5, 0);
        graph.addEdge(5, 3);
    }
    
    @Test
    public void testBuildingASimpleGraph() {        
        assertThat(graph.verticeCount()).isEqualTo(6);
        assertThat(graph.degree(0)).isEqualTo(3);
        assertThat(graph.degree(2)).isEqualTo(4);
    }

    @Test
    public void testDFS() {
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        dfs.search();
    }
    
    @Test
    public void testDFSIterative() {
        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
        dfs.iterativeSearch();
    }
    
    @Test
    public void testBFS() {
        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
        bfs.search();
    }
}
