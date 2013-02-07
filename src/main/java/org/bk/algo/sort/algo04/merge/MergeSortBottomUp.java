package org.bk.algo.sort.algo04.merge;

import java.lang.reflect.Array;

public class MergeSortBottomUp {
    public static <T extends Comparable<? super T>> void sort(T[] a) {
        @SuppressWarnings("unchecked")
        T[] helper = (T[])Array.newInstance(a[0].getClass() , a.length);
        int N = a.length;
        for (int sz = 1; sz < N; sz=sz+sz){
            for (int lo = 0; lo < N-sz; lo += 2*sz ) {
                int mid = lo + sz - 1;
                int hi = Math.min(lo + 2*sz - 1, N-1);
                merge(a, helper, lo, mid, hi);
            }
        }
    }
    
    
    private static <T extends Comparable<? super T>> void merge(T[] a, T[] helper, int lo, int mid, int hi){
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
    
    private static <T extends Comparable<? super T>> boolean isLess(T a, T b) {
        return a.compareTo(b) < 0;
    }

}
