package org.bk.algo.core;

public class DummyNodeVisitor<K, V> implements Visitor<K, V> {
    @Override
    public void visit(K key, V val) {
        System.out.println(key.toString() + ":" + val.toString());
    }

}
