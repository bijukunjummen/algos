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

    private static <T extends Comparable<? super T>> int partition(T[] a, final int lo, final int hi) {
        int i = lo;

        for (int j = lo + 1; j <= hi; j++) {
            if (isLess(a[j], a[lo])) {
                exchange(a, i + 1, j);
                i++;
            }
        }
        exchange(a, i, lo);

        return i;

    }

    private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int min) {
        T temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }

    private static <T extends Comparable<? super T>> boolean isLess(T a, T b) {
        return a.compareTo(b) < 0;
    }

}