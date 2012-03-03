package org.bk.algo.core;

public class BinarySearchTree<K extends Comparable<? super K>, V> {
    private Node<K, V> root;
    
    public V get(K key){
        return get(key, root);
    }
    
    public void put(K key, V val){
        this.root = put(key, val, root);
    }
    
 
    private V get(K key, Node<K, V> node) {
        if (node==null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp==0) 
            return node.value;
        else if (cmp<0)
            return get(key, node.left);
        else 
            return get(key, node.right);
    }
    
    private Node<K, V> put(K key, V val, Node<K, V> node) {
        if (node==null){
            return new Node<K,V>(key, val, 1);
        }
        int cmp = key.compareTo(node.key);
        
        if (cmp<0){
            node.left = put(key, val, node.left);
        }else if (cmp>0){
            node.right = put(key, val, node.right);
        }else if (cmp==0){
            node.value = val;
        }
        
        node.size = size(node.left) + size(node.right) + 1;
        
        return node;
    }   
    
    public int size(){
        return size(this.root);
    }
    
    private int size(Node<K, V> node){
        if (node==null) return 0;
        return node.size;
    }


    private static class Node<K extends Comparable<? super K>, V>{
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;
        int size;
        
        public Node(K key, V value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
        
    }

}
