package org.bk.algo.sort.algo04.merge;

import java.lang.reflect.Array;

public class MergeSort {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        T[] helper = (T[]) Array.newInstance(a[0].getClass(), a.length);
        mergeSort(a, helper, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] helper, int lo, int hi) {
        int mid = (lo + hi) / 2;

        if (lo >= hi) {
            return;
        }

        mergeSort(a, helper, lo, mid);
        mergeSort(a, helper, mid + 1, hi);
        merge(a, helper, lo, mid, hi);
    }

    private static <T extends Comparable<? super T>> void merge(T[] a, T[] helper, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            helper[i] = a[i];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = helper[j++];
            } else if (j > hi) {
                a[k] = helper[i++];
            } else if (isLess(helper[i], helper[j])) {
                a[k] = helper[i++];
            } else {
                a[k] = helper[j++];
            }
        }
    }


    private static <T extends Comparable<? super T>> boolean isLess(T a, T b) {
        return a.compareTo(b) < 0;
    }
}
