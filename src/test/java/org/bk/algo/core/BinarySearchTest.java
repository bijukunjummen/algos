package org.bk.algo.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BinarySearchTest {

    @Test
    public void testSearchWithASmallIntegerArray() {
        Integer[] anArr = {1, 2, 3, 5, 9, 10, 15, 2000};
        assertEquals(BinarySearch.search(anArr, 9), 4);
        assertEquals(BinarySearch.search(anArr, 1), 0);
        assertEquals(BinarySearch.search(anArr, 2), 1);
        assertEquals(BinarySearch.search(anArr, 3), 2);
        assertEquals(BinarySearch.search(anArr, 5), 3);
        assertEquals(BinarySearch.search(anArr, 9), 4);
        assertEquals(BinarySearch.search(anArr, 10), 5);
        assertEquals(BinarySearch.search(anArr, 15), 6);
        assertEquals(BinarySearch.search(anArr, 20), -1);
    }

    @Test
    public void testSearchWithASmallIntegerArrayAndRecursiveSearch() {
        Integer[] anArr = {1, 2, 3, 5, 9, 10, 15, 2000};
        assertEquals(BinarySearch.recSearch(anArr, 9), 4);
        assertEquals(BinarySearch.recSearch(anArr, 1), 0);
        assertEquals(BinarySearch.recSearch(anArr, 2), 1);
        assertEquals(BinarySearch.recSearch(anArr, 3), 2);
        assertEquals(BinarySearch.recSearch(anArr, 5), 3);
        assertEquals(BinarySearch.recSearch(anArr, 9), 4);
        assertEquals(BinarySearch.recSearch(anArr, 10), 5);
        assertEquals(BinarySearch.recSearch(anArr, 15), 6);
        assertEquals(BinarySearch.recSearch(anArr, 20), -1);
    }

    @Test
    public void testFloor() {
        Integer[] anArr = {1, 2, 3, 5, 9, 10, 15, 2000};
        assertEquals(BinarySearch.recSearchFloor(anArr, 21), 6);
        assertEquals(BinarySearch.recSearchFloor(anArr, 11), 5);
        assertEquals(BinarySearch.recSearchFloor(anArr, 9), 4);
    }

    @Test
    public void testSearchWithASmallIntegerArrayAndRecursiveSearch2() {
        Integer[] anArr = {0, 3};
        assertEquals(BinarySearch.recSearch(anArr, 3), 1);
        assertEquals(BinarySearch.recSearch(anArr, 0), 0);
    }
}
