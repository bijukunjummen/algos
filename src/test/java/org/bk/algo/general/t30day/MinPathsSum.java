package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class MinPathsSum {
    public int minPathSum(int[][] grid) {
        VertexWeightedGraph graph = createGraph(grid);
        ShortestPath shortestPath = new ShortestPath(graph);
        int numRows = grid.length;
        int numCols = numRows > 0 ? grid[0].length : 0;

        return shortestPath.distanceTo(numRows - 1, numCols - 1, numCols);
    }

    private VertexWeightedGraph createGraph(int[][] grid) {
        int numRows = grid.length;
        int numCols = numRows > 0 ? grid[0].length : 0;

        VertexWeightedGraph vertexWeightedGraph = new VertexWeightedGraph(numRows * numCols);

        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                int weightAtNode = grid[r][c];
                Coord coord = new Coord(r, c, indexFor(r, c, numCols));
                Node node = vertexWeightedGraph.getNodeAtIndex(indexFor(r, c, numCols));
                node.coord = coord;
                node.weight = weightAtNode;
                addAdj(vertexWeightedGraph, node, r, c, numRows, numCols);
            }
        }
        return vertexWeightedGraph;
    }

    class ShortestPath {
        private int[] edgeTo;
        private int[] distTo;
        private PriorityQueue<IndexAndDistance> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

        ShortestPath(VertexWeightedGraph g) {
            final int vertices = g.nodes.size();
            edgeTo = new int[vertices];
            distTo = new int[vertices];

            for (int i = 0; i < vertices; i++) {
                distTo[i] = Integer.MAX_VALUE;
            }
            distTo[0] = g.getNodeAtIndex(0).weight;
            priorityQueue.add(new IndexAndDistance(0, g.getNodeAtIndex(0).weight));

            while (!priorityQueue.isEmpty()) {
                relax(g, priorityQueue.poll());
            }
        }

        private void relax(VertexWeightedGraph g, IndexAndDistance indexAndDistance) {
            int index = indexAndDistance.index;
            int distance = indexAndDistance.distance;
            for (Node w : g.getNodeAtIndex(index).adj) {
                int wIndex = w.coord.index;
                if (distTo[wIndex] > distTo[index] + w.weight) {
                    distTo[wIndex] = distTo[index] + w.weight;
                    edgeTo[wIndex] = index;
                    IndexAndDistance newIndexAndDistance = new IndexAndDistance(wIndex, distTo[wIndex]);
                    if (priorityQueue.contains(newIndexAndDistance)) {
                        priorityQueue.remove(newIndexAndDistance);
                        priorityQueue.add(newIndexAndDistance);
                    } else {
                        priorityQueue.add(newIndexAndDistance);
                    }
                }
            }
        }

        public int distanceTo(int r, int c, int numCols) {
            return distTo[indexFor(r, c, numCols)];
        }
    }

    static class IndexAndDistance {
        private int index;
        private int distance;


        IndexAndDistance(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IndexAndDistance that = (IndexAndDistance) o;
            return index == that.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
    }


    private void addAdj(VertexWeightedGraph vertexWeightedGraph, Node node, int r, int c, int numRows, int numCols) {
//        if (r - 1 >= 0) {
//            node.adj.add(vertexWeightedGraph.nodes.get(indexFor(r - 1, c, numCols)));
//        }
        if (r + 1 <= numRows - 1) {
            node.adj.add(vertexWeightedGraph.nodes.get(indexFor(r + 1, c, numCols)));
        }

//        if (c - 1 >= 0) {
//            node.adj.add(vertexWeightedGraph.nodes.get(indexFor(r, c - 1, numCols)));
//        }

        if (c + 1 <= numCols - 1) {
            node.adj.add(vertexWeightedGraph.nodes.get(indexFor(r, c + 1, numCols)));
        }
    }

    public int indexFor(int r, int c, int numCols) {
        return r * numCols + c;
    }

    static class VertexWeightedGraph {
        List<Node> nodes;

        public VertexWeightedGraph(int n) {
            nodes = new ArrayList<>();
            IntStream.range(0, n).forEach(i -> nodes.add(new Node()));
        }

        public Node getNodeAtIndex(int idx) {
            return nodes.get(idx);
        }
    }

    static class Node {
        private Coord coord;
        private int weight;
        private List<Node> adj = new ArrayList<>();

        public Node() {

        }


    }

    static class Coord {
        private final int r;
        private final int c;
        private final int index;

        public Coord(int r, int c, int index) {
            this.r = r;
            this.c = c;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coord)) return false;
            Coord coord = (Coord) o;
            return r == coord.r
                    && c == coord.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    @Test
    void test1() {
        int[][] grid1 =
                {
                        {1, 3, 1},
                        {1, 5, 1},
                        {4, 2, 1}
                };
        assertThat(minPathSum(grid1)).isEqualTo(7);
    }

    @Test
    void test2() {
        int[][] grid = {
                {5, 4, 2, 9, 6, 0, 3, 5, 1, 4, 9, 8, 4, 9, 7, 5, 1},
                {3, 4, 9, 2, 9, 9, 0, 9, 7, 9, 4, 7, 8, 4, 4, 5, 8},
                {6, 1, 8, 9, 8, 0, 3, 7, 0, 9, 8, 7, 4, 9, 2, 0, 1},
                {4, 0, 0, 5, 1, 7, 4, 7, 6, 4, 1, 0, 1, 0, 6, 2, 8},
                {7, 2, 0, 2, 9, 3, 4, 7, 0, 8, 9, 5, 9, 0, 1, 1, 0},
                {8, 2, 9, 4, 9, 7, 9, 3, 7, 0, 3, 6, 5, 3, 5, 9, 6},
                {8, 9, 9, 2, 6, 1, 2, 5, 8, 3, 7, 0, 4, 9, 8, 8, 8},
                {5, 8, 5, 4, 1, 5, 6, 6, 3, 3, 1, 8, 3, 9, 6, 4, 8},
                {0, 2, 2, 3, 0, 2, 6, 7, 2, 3, 7, 3, 1, 5, 8, 1, 3},
                {4, 4, 0, 2, 0, 3, 8, 4, 1, 3, 3, 0, 7, 4, 2, 9, 8},
                {5, 9, 0, 4, 7, 5, 7, 6, 0, 8, 3, 0, 0, 6, 6, 6, 8},
                {0, 7, 1, 8, 3, 5, 1, 8, 7, 0, 2, 9, 2, 2, 7, 1, 5},
                {1, 0, 0, 0, 6, 2, 0, 0, 2, 2, 8, 0, 9, 7, 0, 8, 0},
                {1, 1, 7, 2, 9, 6, 5, 4, 8, 7, 8, 5, 0, 3, 8, 1, 5},
                {8, 9, 7, 8, 1, 1, 3, 0, 1, 2, 9, 4, 0, 1, 5, 3, 1},
                {9, 2, 7, 4, 8, 7, 3, 9, 2, 4, 2, 2, 7, 8, 2, 6, 7},
                {3, 8, 1, 6, 0, 4, 8, 9, 8, 0, 2, 5, 3, 5, 5, 7, 5},
                {1, 8, 2, 5, 7, 7, 1, 9, 9, 8, 9, 2, 4, 9, 5, 4, 0},
                {3, 4, 4, 1, 5, 3, 3, 8, 8, 6, 3, 5, 3, 8, 7, 1, 3}
        };

        assertThat(minPathSum(grid)).isEqualTo(82);
    }

}