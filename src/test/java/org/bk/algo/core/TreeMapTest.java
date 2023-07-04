package org.bk.algo.core;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

public class TreeMapTest {

    @Test
    void testTreeMap() {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("b", "b");
        treeMap.put("a", "a");

        System.out.println(treeMap.toString());
    }
}
