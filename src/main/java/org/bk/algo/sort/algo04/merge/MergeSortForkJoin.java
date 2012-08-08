package org.bk.algo.sort.algo04.merge;

import java.lang.reflect.Array;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MergeSortForkJoin {
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		@SuppressWarnings("unchecked")
		T[] helper = (T[])Array.newInstance(a[0].getClass() , a.length);
		ForkJoinPool forkJoinPool = new ForkJoinPool(10);
		forkJoinPool.invoke(new MergeSortTask<T>(a, helper, 0, a.length-1));
	}
	

	private static class MergeSortTask<T extends Comparable<? super T>> extends RecursiveAction{
		private static final long serialVersionUID = -749935388568367268L;
		private final T[] a;
		private final T[] helper;
		private final int lo;
		private final int hi;
		
		public MergeSortTask(T[] a, T[] helper, int lo, int hi){
			this.a = a;
			this.helper = helper;
			this.lo = lo;
			this.hi = hi;
		}
		@Override
		protected void compute() {
			if (lo>=hi) return;
			int mid = lo + (hi-lo)/2;
			MergeSortTask<T> left = new MergeSortTask<>(a, helper, lo, mid);
			MergeSortTask<T> right = new MergeSortTask<>(a, helper, mid+1, hi);
			invokeAll(left, right);
			merge(this.a, this.helper, this.lo, mid, this.hi);
			
			
		}
		private void merge(T[] a, T[] helper, int lo, int mid, int hi){
			for (int i=lo;i<=hi;i++){
				helper[i]=a[i];
			}
			int i=lo,j=mid+1;
			for(int k=lo;k<=hi;k++){
				if (i>mid){
					a[k]=helper[j++];
				}else if (j>hi){
					a[k]=helper[i++];
				}else if(isLess(helper[i], helper[j])){
					a[k]=helper[i++];
				}else{
					a[k]=helper[j++];
				}
			}
		}
		private boolean isLess(T a, T b) {
			return a.compareTo(b) < 0;
		}
	}
}

