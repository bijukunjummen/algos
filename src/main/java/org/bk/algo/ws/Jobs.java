package org.bk.algo.ws;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Jobs {
	private final List<Job> list;
	
	public Jobs() {
		this.list = new ArrayList<>();
	}
	
	public void addJob(Job job) {
		this.list.add(job);
	}
	
	public List<Job> getSortedList(Comparator<Job> jobComparator) {
		List<Job> dest = new ArrayList<>(this.list);
		Collections.copy(dest, this.list);
		Collections.sort(dest, jobComparator);
		Collections.reverse(dest);
		return dest;
	}
}
