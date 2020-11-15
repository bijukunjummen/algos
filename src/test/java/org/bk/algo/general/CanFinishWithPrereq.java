package org.bk.algo.general;

import java.util.ArrayList;
import java.util.List;

class CanFinishWithPrereq {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);

        for (int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            graph.addEdge(pair[0], pair[1]);
        }
        return !hasCycle(graph);
    }

    private boolean hasCycle(Graph graph) {
        boolean[] onstack = new boolean[graph.V];
        boolean[] visited = new boolean[graph.V];
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, onstack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(Graph graph, int v, boolean[] visited, boolean[] onstack) {
        onstack[v] = true;
        visited[v] = true;
        for (Integer w : graph.adj[v]) {
            if (!visited[w]) {
                if (hasCycle(graph, w, visited, onstack)) {
                    return true;
                }
            } else if (onstack[w]) {
                return true;
            }
        }
        onstack[v] = false;
        return false;
    }


    static class Graph {
        int V;
        int E;

        List<Integer>[] adj;

        Graph(int V) {
            this.V = V;
            this.adj = (List<Integer>[]) new List[V];
            for (int i = 0; i < V; i++) {
                this.adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int v, int w) {
            this.adj[v].add(w);
        }
    }
}