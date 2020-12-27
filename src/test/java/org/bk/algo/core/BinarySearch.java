package org.bk.algo.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearch {
    public static <T extends Comparable<? super T>> int search(T[] arr, T anItem) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = anItem.compareTo(arr[mid]);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    @Test
    void testIter() {
        assertThat(search(new Integer[]{1, 2, 3, 4, 5, 6}, 3)).isEqualTo(2);
    }

    public static <T extends Comparable<? super T>> int recSearch(T[] arr, T anItem) {
        return recSearchHelper(arr, 0, arr.length - 1, anItem);
    }

    public static <T extends Comparable<? super T>> int recSearchFloor(T[] arr, T anItem) {
        return recSearchHelperFloor(arr, 0, arr.length - 1, anItem);
    }

    private static <T extends Comparable<? super T>> int recSearchHelperFloor(T[] arr, int lo, int hi, T anItem) {
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;
        int compareVal = anItem.compareTo(arr[mid]);

        if (compareVal == 0)
            return mid;
        else if (compareVal < 0) {
            return recSearchHelperFloor(arr, lo, mid - 1, anItem);
        } else {
            int result = recSearchHelperFloor(arr, mid + 1, hi, anItem);
            if (result == -1) {
                return mid;
            }
            return result;
        }
    }

    private static <T extends Comparable<? super T>> int recSearchHelper(T[] arr, int lo, int hi, T anItem) {
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;
        int compareVal = anItem.compareTo(arr[mid]);

        if (compareVal == 0)
            return mid;
        else if (compareVal < 0) {
            return recSearchHelper(arr, lo, mid - 1, anItem);
        } else {
            return recSearchHelper(arr, mid + 1, hi, anItem);
        }
    }

}
