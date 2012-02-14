package org.bk.algo.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LinkedListTests {
	
	
	@Test
	public void testRetrieveFromAnEmptyListThrowsException(){
		LinkedList<String> linkedList = new LinkedList<String>();
		try{
			linkedList.getFirstItem();
			assertTrue(false);
		}catch(NullPointerException nPe){
			assertTrue(true);
		}
	}

	@Test
	public void testAddAndRemoveItemsToAList(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.insertAtBeginning("001");
		assertThat(linkedList.getSize(), is(1));
		linkedList.insertAtBeginning("002");
		assertThat(linkedList.getSize(), is(2));
		linkedList.insertAtBeginning("003");
		assertThat(linkedList.getSize(), is(3));
	}

	@Test
	public void testRemoveItemsFromAList(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.insertAtBeginning("001");
		linkedList.insertAtBeginning("002");
		linkedList.insertAtBeginning("003");
		linkedList.insertAtBeginning("004");
		assertThat(linkedList.getSize(), is(4));
		linkedList.removeFromBeginning();
		assertThat(linkedList.getSize(), is(3));
		linkedList.removeFromBeginning();
		assertThat(linkedList.getSize(), is(2));
		linkedList.removeFromBeginning();
		assertThat(linkedList.getSize(), is(1));
		linkedList.removeFromBeginning();
		assertThat(linkedList.getSize(), is(0));
	}

	@Test
	public void testRemoveMoreThanPresentShouldThrowAnException(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.insertAtBeginning("001");
		linkedList.removeFromBeginning();
		try{
			linkedList.removeFromBeginning();
			assertTrue(false);
		}catch(NullPointerException npe){
			
		}
	}

	@Test
	public void testListIterator(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.insertAtBeginning("001");
		linkedList.insertAtBeginning("002");
		linkedList.insertAtBeginning("003");
		linkedList.insertAtBeginning("004");
		String items = ""; 
		for (String item: linkedList){
			items += item;
		}
		assertThat(items, is("004003002001"));
	}

	@Test
	public void testListIteratorWithAddingToEnd(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.insertAtEnd("001");
		linkedList.insertAtEnd("002");
		linkedList.insertAtEnd("003");
		linkedList.insertAtEnd("004");
		assertThat(linkedList.getSize(), is(4));
		String items = ""; 
		for (String item: linkedList){
			items += item;
		}
		assertThat(items, is("001002003004"));
	}
}
