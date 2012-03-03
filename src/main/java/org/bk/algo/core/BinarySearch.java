package org.bk.algo.core;

public class BinarySearch {
	public static<T extends Comparable<? super T>> int search(T[] arr, T anItem){
		int lo = 0;
		int hi = arr.length - 1;
		
		while (lo<=hi){
			int mid = lo + (hi - lo)/2;

			if (arr[mid].compareTo(anItem)>0){
				hi = mid - 1;
			}else if (arr[mid].compareTo(anItem)<0){
				lo = mid + 1;
			}else{
				return mid;
			}
			
		}
		
		return -1;
	}

}
