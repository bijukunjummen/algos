package org.bk.algo.sort.algo03.shell;

public class ShellSort {

	
	public static <T extends Comparable<? super T> > void sort(T[] arr){
		int length = arr.length;
		
		int gap = 1;
		while (gap<length/3){
			gap = 3*gap + 1;
		}
		
		while (gap>0){
			for (int i=gap;i<length;i++){
				for (int j=i;j>=gap && isLess(arr[j], arr[j-gap]);j-=gap){
					exchange(arr, j, j-gap);
				}
			}
			gap = gap/3;	
		}
	}
	
	public static <T extends Comparable<? super T>> void exchange(T[] arr, int i, int j){
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static <T extends Comparable<? super T>> boolean isLess(T a, T b) {
		return a.compareTo(b) < 0;
	}
}
