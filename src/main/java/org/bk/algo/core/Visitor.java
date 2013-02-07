package org.bk.algo.core;

public interface Visitor<K, V> {
    void visit(K key, V val);
}
