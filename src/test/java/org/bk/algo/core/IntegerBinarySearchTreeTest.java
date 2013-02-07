package org.bk.algo.core;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class IntegerBinarySearchTreeTest {
    
    @Test
    public void testBST(){
        IntegerBST<String> bst = new IntegerBST<String>();        
        bst.put(3, "Three");
        bst.put(2, "Two");
        bst.put(1, "One");
        bst.put(6, "Six");
        bst.put(4, "Four");
        bst.put(5, "Five");
        
        //     3
        //  2      6
        //1      4
        //         5

        assertThat(bst.get(4), is("Four"));
        assertThat(bst.size(), is(6));
        assertThat(bst.validateBST(), is(true));
        
        assertThat(bst.isBalanced(), is(false));
    }
}
