package org.bk.algo.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

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
    
    public void myMethod(List<? super Number> aList){
        aList.add(2);
        aList.add(23d);
    }

}
