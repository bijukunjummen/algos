package org.bk.algo.ws;

public class Job{
	private final int weight;
	private final int length;
	
	public Job(int w, int l) {
		this.length = l;
		this.weight = w;
	}

	public int getWeight() {
		return weight;
	}

	public int getLength() {
		return length;
	}
}
