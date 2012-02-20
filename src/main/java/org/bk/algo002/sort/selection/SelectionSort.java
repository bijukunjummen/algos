package org.bk.algo002.sort.selection;

public class SelectionSort {
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		int numElements = a.length;
		for (int i = 0; i < numElements; i++) {
			int min = i;
			for (int j = i + 1; j < numElements; j++) {
				if (a[j].compareTo(a[min]) < 0) {
					min = j;
				}
			}
			exchange(a, i, min);
		}
	}

	private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int min) {
		T temp = a[i];
		a[i] = a[min];
		a[min] = temp;
	}
}
