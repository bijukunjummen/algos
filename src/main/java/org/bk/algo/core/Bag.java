package org.bk.algo.core;

import java.util.Iterator;

public class Bag<T> implements Iterable<T>{
	private LinkedList<T> holder = new LinkedList<T>();
	
	public void add(T item){
		this.holder.insertAtEnd(item);
	}
		
	public int size(){
		return this.holder.getSize();
	}

	public boolean isEmpty(){
		return this.size()==0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return this.holder.iterator();
	}
	
}
