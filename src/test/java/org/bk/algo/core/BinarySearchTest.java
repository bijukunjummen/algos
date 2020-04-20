package org.bk.algo.core;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinarySearchTest {

    @Test
    public void testSearchWithASmallIntegerArray() {
        Integer[] anArr = {1, 2, 3, 5, 9, 10, 15, 2000};
        assertThat(BinarySearch.search(anArr, 9), is(4));
        assertThat(BinarySearch.search(anArr, 1), is(0));
        assertThat(BinarySearch.search(anArr, 2), is(1));
        assertThat(BinarySearch.search(anArr, 3), is(2));
        assertThat(BinarySearch.search(anArr, 5), is(3));
        assertThat(BinarySearch.search(anArr, 9), is(4));
        assertThat(BinarySearch.search(anArr, 10), is(5));
        assertThat(BinarySearch.search(anArr, 15), is(6));
        assertThat(BinarySearch.search(anArr, 20), is(-1));

    }

    @Test
    public void testSearchWithASmallIntegerArrayAndRecursiveSearch() {
        Integer[] anArr = {1, 2, 3, 5, 9, 10, 15, 2000};
        assertThat(BinarySearch.recSearch(anArr, 9), is(4));
        assertThat(BinarySearch.recSearch(anArr, 1), is(0));
        assertThat(BinarySearch.recSearch(anArr, 2), is(1));
        assertThat(BinarySearch.recSearch(anArr, 3), is(2));
        assertThat(BinarySearch.recSearch(anArr, 5), is(3));
        assertThat(BinarySearch.recSearch(anArr, 9), is(4));
        assertThat(BinarySearch.recSearch(anArr, 10), is(5));
        assertThat(BinarySearch.recSearch(anArr, 15), is(6));
        assertThat(BinarySearch.recSearch(anArr, 20), is(-1));

    }

    @Test
    public void testSearchWithASmallIntegerArrayAndRecursiveSearch2() {
        Integer[] anArr = {0, 3};
        assertThat(BinarySearch.recSearch(anArr, 3), is(1));
        assertThat(BinarySearch.recSearch(anArr, 0), is(0));

    }

}
