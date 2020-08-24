package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyHashSet {

    private static final int INIT = 10;

    private int n;
    private int m;

    private SearchST<Integer>[] st;

    public MyHashSet() {
        this(INIT);
    }
    /** Initialize your data structure here. */
    public MyHashSet(int size) {
        this.m = size;
        st = new SearchST[size];
        for (int i = 0; i < m; i++) {
            st[i] = new SearchST<>();
        }
    }

    public void add(int key) {
        if (n >= 10 * m) resize(2 * m);
        int i = key % m;
        if (!st[i].contains(key)) {
            st[i].put(key);
            n++;
        }
    }

    public void remove(int key) {
        int i = key % m;
        if (st[i].contains(key)) {
            st[i].delete(key);
            n--;
        }

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int i = key % m;
        return st[i].contains(key);
    }

    private void resize(int newSize) {
        MyHashSet hashSet = new MyHashSet(newSize);
        for (int i = 0; i < m; i++) {
            for (Node<Integer> x = st[i].first; x != null; x = x.next) {
                hashSet.add(x.key);
            }
        }
        this.m = hashSet.m;
        this.n = hashSet.n;
        this.st = hashSet.st;
    }
}

class SearchST<K> {
    int n;
    Node<K> first;

    int size() {
        return n;
    }    boolean contains(K key) {
        for (Node<K> x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return true;
            }
        }
        return false;
    }



    void put(K key) {
        for (Node<K> x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return;
            }
        }
        first = new Node(key, first);
        n++;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    void delete(K key) {
        first = delete(first, key);
    }

    private Node<K> delete(Node<K> node, K key) {
        if (node == null) return null;
        if (key.equals(node.key)) {
            n--;
            return node.next;
        }
        node.next = delete(node.next, key);
        return node;
    }
}

class Node<K> {
    K key;
    Node<K> next;

    public Node(K key, Node<K> next) {
        this.key = key;
        this.next = next;
    }
}

class TestHashSet {
    @Test
    void testHashSet() {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        assertThat(myHashSet.contains(1)).isTrue();
        assertThat(myHashSet.contains(2)).isTrue();
        myHashSet.add(1);
        myHashSet.add(3);
        assertThat(myHashSet.contains(3)).isTrue();
        myHashSet.remove(1);
        assertThat(myHashSet.contains(1)).isFalse();
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */