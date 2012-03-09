package org.bk.algo.core;

public class BinarySearch {
	public static<T extends Comparable<? super T>> int search(T[] arr, T anItem){
		int lo = 0;
		int hi = arr.length - 1;
		
		while (lo<=hi){
			int mid = lo + (hi - lo)/2;
			int  compareVal = anItem.compareTo(arr[mid]);
			if (compareVal < 0){
				hi = mid - 1;
			}else if (compareVal > 0){
				lo = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	public static<T extends Comparable<? super T>> int recSearch(T[] arr, T anItem){
	    return recSearchHelper(arr, 0, arr.length-1, anItem);
	}
	
	private static<T extends Comparable<? super T>> int recSearchHelper(T[] arr, int lo, int hi, T anItem){
	    if (lo>hi) return -1;

	    int mid = lo + (hi-lo)/2;	        
	    int compareVal = anItem.compareTo(arr[mid]);
	    
	    if (compareVal==0) 
	        return mid;
	    else if (compareVal<0){
	        return recSearchHelper(arr, lo, mid-1, anItem);
	    }else{
	        return recSearchHelper(arr, mid+1, hi, anItem);
	    }
	}

}
