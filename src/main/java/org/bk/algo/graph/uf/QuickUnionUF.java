package org.bk.algo.graph.uf;

//Based on http://algs4.cs.princeton.edu/home/

public class QuickUnionUF {
	private int[] id;
	
	public QuickUnionUF(int N){
		id = new int[N];
		for (int i=0;i<N;i++){
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q){
		return root(p)==root(q);
	}
	
	public void union(int p, int q){
		id[p]=root(q);
	}
	
	private int root(int p){
		while(id[p]!=p){
			p=id[p];
		}
		return p;
	}

}
