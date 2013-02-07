package org.bk.algo.sort.algo01.selection;

public class SelectionSort {
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		for (int i=0;i<a.length;i++){
			int minIndex = i;
			for (int j=i+1;j<a.length;j++){
				if (isLess(a[j],a[minIndex])){
					minIndex = j;
				}
			}
			exchange(a, i, minIndex);
		}
	}

	private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j) {
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static <T extends Comparable<? super T>> boolean isLess(T a, T b){
		return a.compareTo(b) < 0;
	}
}
