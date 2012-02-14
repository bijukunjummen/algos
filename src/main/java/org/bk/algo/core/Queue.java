package org.bk.algo.core;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
	private LinkedList<T> holder = new LinkedList<T>();
	
	public void enqueue(T item){
		holder.insertAtEnd(item);
		
	}
	
	public T dequeue(){
		return holder.removeFromBeginning();
	}
	
	public int size(){
		return holder.getSize();
	}
	
	public boolean isEmpty(){
		return this.size()==0;
	}

	@Override
	public Iterator<T> iterator() {
		return holder.iterator();
	}
}
