package org.bk.algo.core;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTest {
	Queue<String> queue = new Queue<>();
	
	@Test
	public void testEnqueueAndGetSize(){
		queue.enqueue("001");
		queue.enqueue("002");
		queue.enqueue("003");
		
		assertThat(queue.size()).isEqualTo(3);
	}
	
	@Test
	public void testDequeueAndGetSize(){
		queue.enqueue("001");
		assertThat(queue.dequeue()).isEqualTo("001");
        queue.enqueue("002");		
		assertThat(queue.dequeue()).isEqualTo("002");
		queue.enqueue("003");
		assertThat(queue.dequeue()).isEqualTo("003");
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
		assertThat(items).isEqualTo("001002003");
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
