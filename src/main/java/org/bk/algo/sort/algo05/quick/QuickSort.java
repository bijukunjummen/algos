package org.bk.algo.sort.algo05.quick;


public class QuickSort {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void quicksort(T[] a, final int lo, final int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quicksort(a, lo, j - 1);
        quicksort(a, j + 1, hi);
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        final T p = a[lo];
        while (true) {
            while (isLess(a[++i], p)) if (i == hi) break;
            while (isLess(p, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }

    private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    private static <T extends Comparable<? super T>> boolean isLess(T a, T b) {
        return a.compareTo(b) < 0;
    }

}