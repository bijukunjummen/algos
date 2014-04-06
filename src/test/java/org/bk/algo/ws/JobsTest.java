package org.bk.algo.ws;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.bk.algo.sort.SortFixtures;
import org.junit.Test;

public class JobsTest {

	private Jobs loadJobsSample() {
		Jobs  jobs = new Jobs();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(JobsTest.class.getResourceAsStream("/jobs.txt")));
    	try{
    		String count = reader.readLine();
    		String line = reader.readLine();
    		while (line!=null){
    			String[] tokenStrings = line.split(" ");
    			jobs.addJob(new Job(Integer.parseInt(tokenStrings[0]), Integer.parseInt(tokenStrings[1]) ));
    			line = reader.readLine();
    		}
    	}catch(IOException ioException){
    		throw new RuntimeException(ioException);
    	}
    	return jobs;
	}
	@Test
	public void testWithDiff() {
		System.out.println(" By Diff: " + completionTime(new ComparatorByDiff()));
//		System.out.println(" By Ratio: " + completionTime(new ComparatorByRatio()));
	}
	
	private long completionTime(Comparator<Job> jobComparator) {
		Jobs jobs = loadJobsSample();
		List<Job> jobsWithDiff = jobs.getSortedList(jobComparator);
		long currLength = 0l;
		long totalCompletionTime = 0l;
		int i = 0;
		for (Job job: jobsWithDiff) {
			currLength +=  job.getLength();
			totalCompletionTime += currLength * job.getWeight();
//			if (i%20==0) {
//				System.out.println(job.getWeight() + ": " + job.getLength() + ": " + currLength + ": " + totalCompletionTime);
//			}
			i++;
		}
		return totalCompletionTime;
	}

}
