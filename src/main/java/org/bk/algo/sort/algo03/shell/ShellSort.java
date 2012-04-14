package org.bk.algo.sort.algo03.shell;

public class ShellSort {
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		int length = a.length;
		int gap = 1;
		
		while (gap<length/3){
			gap = 3*gap + 1;
		}
		while (gap>0){
			for (int i=gap;i<length;i++){
				for (int j=i;j>=gap && isLess(a[j], a[j-gap]);j-=gap){
					exchange(a, j, j-gap);
				}
			}
			
			gap = gap/3;
		}
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
