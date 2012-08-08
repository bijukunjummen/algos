package org.bk.algo.core;

import java.util.Iterator;


public class LinkedList<T> implements Iterable<T>{
	private Node first;
	private Node last;
	private int size;
	
	public int getSize(){
		return size;
	}
	
	public void insertAtBeginning(T item){
		if (first==null){
			first = new Node(item, null, null);
			last = first;
		}else{
			Node oldFirst = first;
			first = new Node(item, oldFirst, null);
			oldFirst.previous = first;
		}
		size++;
	}
	
	public void insertAtEnd(T item){
		if (last==null){
			last = new Node(item, null, null);
			first = last;
		}else{
			Node oldLast = last;
			last = new Node(item, null, oldLast);
			oldLast.next = last;
		}
		size++;
	}	

	public T removeFromBeginning(){
		T item = first.item;
		first = first.next;
		if (first!=null){
			first.previous = null;
		}else{
		    last = null;
		}
		size--;
		return item;
	}
	
	public T getFirstItem(){
		return first.item;
	}
	
	public T getLastItem(){
		return last.item;
	}

	public T kthFromEndIterative(int k){
		Node a = this.first;
		Node b = this.first;
		
		for (int i=0;i<k-1;i++){
			b = b.next;
		}
		
		while(b.next!=null){
			b=b.next;
			a = a.next;
		}
		
		return a.item;
	}

	private class IntWrapper{
		private int value=0;
	}
	
	public T kthFromEndRecurs(int k){
		return kthFromEndRecurs(this.first, k, new IntWrapper()).item;
	}
	
	private Node kthFromEndRecurs(Node node, final int k, IntWrapper intWrapper){
		if (node==null){
			return null;
		}
		
		Node anode = kthFromEndRecurs(node.next, k, intWrapper);
		intWrapper.value = intWrapper.value + 1;
		if (intWrapper.value==k){
			return node;
		}
		return anode;
		
	}	
	
	private class Node{
		T item;
		Node next;
		Node previous;
		
		public Node(T item, Node next, Node prev){
			this.item = item;
			this.next = next;
			this.previous = prev;
		}
	} 

	@Override
	public Iterator<T> iterator() {
		return new LstIterator();
	}


	public Iterator<T> reverseIterator() {
		return new ReverseIterator();
	}
	private class LstIterator implements Iterator<T>{

		private Node currNode;
		
		public LstIterator(){
			currNode = LinkedList.this.first;
		}
		
		
		@Override
		public boolean hasNext() {
			return this.currNode!=null;
		}

		@Override
		public T next() {
			T toReturn = this.currNode.item;
			this.currNode = currNode.next;
			return toReturn;
		}

		@Override
		public void remove() {
			//NOT IMPLEMENTED..
			throw new IllegalAccessError();
		}
		
	}

	private class ReverseIterator implements Iterator<T>{

		private Node currNode;
		
		public ReverseIterator(){
			this.currNode = LinkedList.this.last;
		}
		
		
		@Override
		public boolean hasNext() {
			return this.currNode!=null;
		}

		@Override
		public T next() {
			T toReturn = this.currNode.item;
			this.currNode = this.currNode.previous;
			return toReturn;
		}

		@Override
		public void remove() {
			//NOT IMPLEMENTED..
			throw new IllegalAccessError();
		}
		
	}



}
