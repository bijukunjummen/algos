package org.bk.algo.ws;

import java.util.Comparator;

public class ComparatorByRatio implements Comparator<Job>{

	@Override
	public int compare(Job o1, Job o2) {
		double diff = (o1.getWeight() * 1.0/o1.getLength()) -  (o2.getWeight() * 1.0/o2.getLength());
		if (diff > 0.0) {
			return 1;
		}else if (diff < 0.0) {
			return -1;
		}
		return 0;
	}

}
