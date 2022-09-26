package org.bk.algo.graph;

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double weight;

    /**
     * Create an edge between v and w with given weight.
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * Return the weight of this edge.
     */
    public double weight() {
        return weight;
    }

    /**
     * Return either endpoint of this edge.
     */
    public int either() {
        return v;
    }

    /**
     * Return the endpoint of this edge that is different from the given vertex
     * (unless a self-loop).
     */
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Illegal endpoint");
    }

    /**
     * Compare edges by weight.
     */
    public int compareTo(Edge that) {
        if (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else return 0;
    }


    /**
     * Return a string representation of this edge.
     */
    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}
