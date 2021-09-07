package org.bk.algo.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class IntegerBinarySearchTreeTest {
    
    @Test
    public void testBST(){
        IntegerBST<String> bst = new IntegerBST<>();
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

        assertThat(bst.get(4)).isEqualTo("Four");
        assertThat(bst.size()).isEqualTo(6);
        assertThat(bst.validateBST()).isEqualTo(true);
        
        assertThat(bst.isBalanced()).isEqualTo(false);
    }
}
