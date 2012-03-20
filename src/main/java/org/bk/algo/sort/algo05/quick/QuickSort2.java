package org.bk.algo.sort.algo05.quick;

public class QuickSort2 {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void quicksort(T[] a, int lo, int hi) {
        if (hi <= lo) return;
        int i = lo;
        int j = hi;
        T partitionItem = a[lo + (hi-lo)/2];

        while (i<=j) {
            while (isLess(a[i], partitionItem)) i++;
            while (isLess(partitionItem, a[j])) j--;

            if (i <= j) {
                exchange(a, i, j);
                i++;j--;
            }
        }

        if (lo<j)quicksort(a, lo, j);
        if (i<hi)quicksort(a, j + 1, hi);
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
