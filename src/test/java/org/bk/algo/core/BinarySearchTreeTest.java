package org.bk.algo.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

public class BinarySearchTreeTest {
    
    @Test
    public void testSearchForASimpleKeyValPair(){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
        bst.put(1, "One");
        bst.put(2, "Two");
        bst.put(3, "Three");
        
        assertThat(bst.get(1), is("One"));        
    }

}
