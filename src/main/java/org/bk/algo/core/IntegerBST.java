package org.bk.algo.core;

public class IntegerBST<V> {

    private Node<V> root;


    public void put(Integer key, V value) {
        this.root = put(this.root, key, value);
    }

    private Node<V> put(Node<V> node, Integer key, V value) {
        if (node == null) {
            return new Node<>(key, value, 1);
        }

        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public int size() {
        return size(this.root);
    }

    private int size(Node<V> node) {
        if (node == null) return 0;

        return node.size;
    }

    public V get(Integer key) {
        return get(this.root, key);
    }

    private V get(Node<V> node, Integer key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }


    public boolean validateBST() {
        return checkBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(Node<V> node, Integer min, Integer max) {
        if (node == null) return true;
        if (!(node.key > min && node.key < max)) return false;
        return checkBST(node.left, min, node.key) && checkBST(node.right, node.key, max);
    }

    public boolean isBalanced() {
        if (checkHeightAndBalance(this.root) == -1) {
            return false;
        }
        return true;
    }

    private int checkHeightAndBalance(Node<V> node) {
        if (node == null) return 0;

        int leftHeight = checkHeightAndBalance(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeightAndBalance(node.right);

        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }


    private static class Node<V> {
        Integer key;
        V value;
        int size;
        Node<V> left;
        Node<V> right;

        public Node(Integer key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

        @Override
        public String toString() {
            return "key:" + this.key + ", value:" + this.value;
        }

    }
}



