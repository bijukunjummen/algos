package org.bk.algo.graph.uf;

import java.util.Arrays;


//Based on http://algs4.cs.princeton.edu/home/

public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz; //to maintain the size of the component
	
	public WeightedQuickUnionUF(int N){
		id = new int[N];
		sz = new int[N];
		for (int i=0;i<N;i++){
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public boolean connected(int p, int q){
		return root(p)==root(q);
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		
		if (sz[i]<sz[j]){
			id[i] = j;
			sz[j] += sz[i];
		}else{
			id[j] = i;
			sz[i] += sz[j];
		}
	}
	
	private int root(int p){
		while(id[p]!=p){
			p=id[p];
		}
		return p;
	}

	@Override
	public String toString(){
		return Arrays.toString(id);
	}

}
