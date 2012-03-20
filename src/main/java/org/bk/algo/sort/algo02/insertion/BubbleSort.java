package org.bk.algo.sort.algo02.insertion;

public class BubbleSort {
    
    public static <T extends Comparable<? super T>> void sort(T[] a){
        boolean swapped = true;
        while (swapped){
            swapped = false;
            for (int i=1;i<=a.length-1;i++){
                if (isLess(a[i], a[i-1])){
                    exchange(a, i, i-1);
                    swapped = true;
                }
            }
        }        
    }
    
    private static <T extends Comparable<? super T>> void exchange(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static <T extends Comparable<? super T>> boolean isLess(T a, T b){
        return a.compareTo(b)<0;
    }
}
