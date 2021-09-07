package org.bk.algo.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BinarySearchTreeTest {
    
    @Test
    public void testSearchForASimpleKeyValPair(){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
        
        bst.put(3, "Three");
        bst.put(2, "Two");
        bst.put(1, "One");
        
        assertThat(bst.get(1)).isEqualTo("One");
        assertThat(bst.size()).isEqualTo(3);

        bst.put(6, "Six");
        bst.put(4, "Four");
        bst.put(5, "Five");
        
        assertThat(bst.get(6)).isEqualTo("Six");
        assertThat(bst.size()).isEqualTo(6);
        
        bst.put(4, "Foure");
        assertThat(bst.get(4)).isEqualTo("Foure");
        assertThat(bst.size()).isEqualTo(6);
        
        System.out.println(bst.getHeight());
        
    }
    
    
    @Test
    public void testInOrderTraversalOfBinaryTree(){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();        
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
        
        NodeCollectingVisitor<Integer, String> vst =  new NodeCollectingVisitor<Integer, String>();
        bst.traverseInOrder(vst);
        assertThat(vst.getKeys()).contains(1,2,3,4,5,6);
    }
    
    @Test
    public void testPreOrderTraversalOfBinaryTree(){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();        
        bst.put(3, "Three");
        bst.put(2, "Two");
        bst.put(1, "One");
        bst.put(6, "Six");
        bst.put(4, "Four");
        bst.put(5, "Five");
        
        
        NodeCollectingVisitor<Integer, String> vst =  new NodeCollectingVisitor<Integer, String>();
        bst.traversePreOrder(vst);
        assertThat(vst.getKeys()).contains(3,2,1,6,4,5);
    }    

    @Test
    public void testPostOrderTraversalOfBinaryTree(){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();        
        bst.put(3, "Three");
        bst.put(2, "Two");
        bst.put(1, "One");
        bst.put(6, "Six");
        bst.put(4, "Four");
        bst.put(5, "Five");
        
        
        NodeCollectingVisitor<Integer, String> vst =  new NodeCollectingVisitor<Integer, String>();
        bst.traversePostOrder(vst);
        assertThat(vst.getKeys()).contains(1,2,5,4,6,3);
    }
    
    @Test
    public void testBST(){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();        
        bst.put(3, "Three");
        bst.put(2, "Two");
        bst.put(1, "One");
        bst.put(6, "Six");
        bst.put(4, "Four");
        bst.put(5, "Five");
        
        bst.checkBST();
    }    

    @Test
    public void testTraverseLevelOrder(){
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();        
        bst.put(45, "Three");
        bst.put(60, "Three");
        bst.put(62, "Three");
        bst.put(43, "Three");
        bst.put(19, "Three");
        bst.put(69, "Three");
        bst.put(23, "Three");
        bst.put(74, "Three");
        bst.put(21, "Three");
        bst.put(83, "Three");
        
        
        NodeCollectingVisitor<Integer, String> vst =  new NodeCollectingVisitor<Integer, String>();
        bst.traverseLevelOrder(vst);
        System.out.println(vst.getKeys());
    }

    private static class NodeCollectingVisitor<K, V> implements Visitor<K, V>{
        
        private List<K> keys = new ArrayList<K>();

        @Override
        public void visit(K key, V val) {
            keys.add(key);
        }
        
        public List<K> getKeys(){
            return keys;
        }
    }
}
