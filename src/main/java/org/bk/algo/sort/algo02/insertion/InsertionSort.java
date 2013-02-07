package org.bk.algo.sort.algo02.insertion;


public class InsertionSort {
    
    public static<T extends Comparable<? super T>> void sort(T[] a){
    	for (int i=1;i<a.length;i++){
    		for (int j=i;j>0 && isLess(a[j], a[j-1]);j--){
    			exchange(a, j, j-1);
    		}
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
