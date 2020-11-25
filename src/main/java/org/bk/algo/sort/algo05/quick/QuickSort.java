package org.bk.algo.sort.algo05.quick;


public class QuickSort {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void quicksort(T[] a, final int lo, final int hi) {
        if (lo >= hi) {
            return;
        }

        int j = partition(a, lo, hi);
        quicksort(a, lo, j - 1);
        quicksort(a, j + 1, hi);
    }

    private static <T extends Comparable<? super T>> int partition(T[] a, int lo, int hi) {
        T p = a[lo];
        int l = lo + 1;
        int h = hi;

        while (l <= h) {
            while (l <= hi && a[l].compareTo(p) <= 0) {
                l++;
            }
            while (h >= lo && a[h].compareTo(p) > 0) {
                h--;
            }
            if (l < h) {
                exchange(a, l, h);
            }
        }
        if (lo < h) {
            exchange(a, lo, h);
        }
        return h;
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