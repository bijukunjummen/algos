package org.bk.algo.core;

import java.util.Iterator;


public class LinkedList<T> implements Iterable<T>{
	
	private Node<T> first;
	private Node<T> last;
	private int size;
	
	public int getSize(){
		return size;
	}
	
	public void insertAtBeginning(T item){
		if (first==null){
			first = new Node<T>(item, null, null);
			last = first;
		}else{
			Node<T> oldFirst = first;
			first = new Node<T>(item, oldFirst, null);
			oldFirst.previous = first;
		}
		size++;
	}
	
	public void insertAtEnd(T item){
		if (last==null){
			last = new Node<T>(item, null, null);
			first = last;
		}else{
			Node<T> oldLast = last;
			last = new Node<T>(item, null, oldLast);
			oldLast.next = last;
		}
		size++;
	}	
	
	public T kthFromEndIterative(int k){
		Node<T> first = this.first;
		Node<T> second = this.first;
		
		for (int i=0;i<k-1;i++){
			second = second.next;
		}
		
		while (second.next!=null){
			first = first.next;
			second = second.next;
		}
		
		return first.item;
	}

	private class IntWrapper{
		private int value;
	}
	
	public T kthFromEndRecurs(int k){
		return kthFromEndRecurs(this.first, k, new IntWrapper()).item;
	}
	
	
	private Node<T> kthFromEndRecurs(Node<T> head, final int k, IntWrapper intWrapper){
		if (head==null) return null;

		Node<T> node = kthFromEndRecurs(head.next, k, intWrapper);
		intWrapper.value = intWrapper.value + 1;		
		if (intWrapper.value==k){
			return head;
		}
		return node;
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

	
	private static class Node<T>{
		T item; 
		Node<T> next;
		Node<T> previous;
		
		Node(T item, Node<T> next, Node<T> previous){
			this.item = item;
			this.next = next;
			this.previous = previous;
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

		private Node<T> currNode;
		
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

		private Node<T> currNode;
		
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
