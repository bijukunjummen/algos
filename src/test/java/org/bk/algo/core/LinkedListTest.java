package org.bk.algo.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LinkedListTest {
    @Test
    public void testRetrieveFromAnEmptyListThrowsException() {
        LinkedList<String> linkedList = new LinkedList<String>();
        try {
            linkedList.getFirstItem();
            assertTrue(false);
        } catch (NullPointerException nPe) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddAndRemoveItemsToAList() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.insertAtBeginning("001");
        assertThat(linkedList.getSize()).isEqualTo(1);
        linkedList.insertAtBeginning("002");
        assertThat(linkedList.getSize()).isEqualTo(2);
        linkedList.insertAtBeginning("003");
        assertThat(linkedList.getSize()).isEqualTo(3);
    }

    @Test
    public void testRemoveItemsFromAList() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.insertAtBeginning("001");
        linkedList.insertAtBeginning("002");
        linkedList.insertAtBeginning("003");
        linkedList.insertAtBeginning("004");
        assertThat(linkedList.getSize()).isEqualTo(4);
        linkedList.removeFromBeginning();
        assertThat(linkedList.getSize()).isEqualTo(3);
        linkedList.removeFromBeginning();
        assertThat(linkedList.getSize()).isEqualTo(2);
        linkedList.removeFromBeginning();
        assertThat(linkedList.getSize()).isEqualTo(1);
        linkedList.removeFromBeginning();
        assertThat(linkedList.getSize()).isEqualTo(0);
    }

    @Test
    public void testRemoveMoreThanPresentShouldThrowAnException() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.insertAtBeginning("001");
        linkedList.removeFromBeginning();
        try {
            linkedList.removeFromBeginning();
            assertTrue(false);
        } catch (NullPointerException npe) {

        }
    }

    @Test
    public void testListIterator() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.insertAtBeginning("001");
        linkedList.insertAtBeginning("002");
        linkedList.insertAtBeginning("003");
        linkedList.insertAtBeginning("004");
        String items = "";
        for (String item : linkedList) {
            items += item;
        }
        assertThat(items).isEqualTo("004003002001");
    }

    @Test
    public void testListIteratorWithAddingToEnd() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.insertAtEnd("001");
        linkedList.insertAtEnd("002");
        linkedList.insertAtEnd("003");
        linkedList.insertAtEnd("004");
        assertThat(linkedList.getSize()).isEqualTo(4);
        String items = "";
        for (String item : linkedList) {
            items += item;
        }
        assertThat(items).isEqualTo("001002003004");
    }

    @Test
    public void testKthFromEnd() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.insertAtEnd("001");
        linkedList.insertAtEnd("002");
        linkedList.insertAtEnd("003");
        linkedList.insertAtEnd("004");

        assertThat(linkedList.kthFromEndIterative(3)).isEqualTo("002");
    }

    @Test
    public void testKthFromEndRecurs() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.insertAtEnd("001");
        linkedList.insertAtEnd("002");
        linkedList.insertAtEnd("003");
        linkedList.insertAtEnd("004");

        assertThat(linkedList.kthFromEndRecurs(3)).isEqualTo("002");
    }
}
