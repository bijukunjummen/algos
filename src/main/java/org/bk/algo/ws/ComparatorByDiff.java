package org.bk.algo.ws;

import java.util.Comparator;

public class ComparatorByDiff implements Comparator<Job>{

	@Override
	public int compare(Job o1, Job o2) {
		int w1 = (o1.getWeight() - o1.getLength());
		int w2 = (o2.getWeight() - o2.getLength());
		int diff = w1 - w2;
		if (diff != 0) {
			return diff;
		}else {
			return o1.getWeight() - o2.getWeight();
		}
	}

}
