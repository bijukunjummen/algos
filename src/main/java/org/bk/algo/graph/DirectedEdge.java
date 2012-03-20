package org.bk.algo.graph;

public class DirectedEdge {
    private int s;
    private int t;
    private double weight;
    
    public DirectedEdge(int s, int t, double weight){
        this.s = s;
        this.t = t;
        this.weight = weight;
    }
    
    public int from(){
        return this.s;
    }
    
    public int to(){
        return this.t;
    }
    
    public double weight(){
        return this.weight;
    }
    
    public String toString(){
        return String.format("%d->%d %.2f", this.s, this.t, this.weight);
    }

}
