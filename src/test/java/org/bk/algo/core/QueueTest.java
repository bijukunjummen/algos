package org.bk.algo.core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueueTest {
	Queue<String> queue = new Queue<String>();
	
	@Test
	public void testEnqueueAndGetSize(){
		queue.enqueue("001");
		queue.enqueue("002");
		queue.enqueue("003");
		
		assertThat(queue.size(), is(3));
	}
	
	@Test
	public void testDequeueAndGetSize(){
		queue.enqueue("001");
		assertThat(queue.dequeue(), is("001"));
        queue.enqueue("002");		
		assertThat(queue.dequeue(), is("002"));
		queue.enqueue("003");
		assertThat(queue.dequeue(), is("003"));
	}

	@Test
	public void testIterator(){
		queue.enqueue("001");
		queue.enqueue("002");
		queue.enqueue("003");
		String items = "";
		for (String item: queue){
			items += item;
		}
		assertThat(items, is("001002003"));
	}
	
	@Test
	public void testIter(){
		int N=100000000;
		int j=0;
		for (int i = 1; i <= N; i = i*2){
			j++;
		}
		System.out.println(j);
	}
}
