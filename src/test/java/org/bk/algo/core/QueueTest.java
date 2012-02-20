package org.bk.algo.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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
		queue.enqueue("002");
		queue.enqueue("003");
		
		assertThat(queue.dequeue(), is("001"));
		assertThat(queue.dequeue(), is("002"));
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

}
