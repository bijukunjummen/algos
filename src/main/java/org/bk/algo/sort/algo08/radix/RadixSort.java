package org.bk.algo.sort.algo08.radix;



public class RadixSort {
    public static void sort(Integer[] a) {
    	int length = a.length;    	
    	int radix = 10;
    	int largest = scanAndFindLargest(a);
    	int numberOfPasses = determineNumberOfPasses(largest);
    	
    	for (int p=0;p<numberOfPasses;p++){
        	int[] count = new int[radix+1];
        	int[] aux = new int[length];
    		
    		int pow = (int)Math.pow(10, p);
	    	for (int i=0;i<length;i++){
	    		count[(a[i]/pow)%10+1]++;
	    	}
	    	for (int r=0;r<radix;r++){
	    		count[r+1] += count[r];
	    	}
	    	
	    	for (int i=0;i<length;i++){
	    		aux[count[(a[i]/pow)%10]++] = a[i];
	    	}
	    	
	    	for (int i=0;i<length;i++){
	    		a[i] = aux[i];
	    	}
    	}
    }
    
    private static int scanAndFindLargest(Integer[] a){
    	int largest = a[0];
    	for (int i=1;i<a.length;i++){
    		if (a[i]>largest){
    			largest = a[i];
    		}
    	}
    	return largest;
    }
    
    protected static int determineNumberOfPasses(int num){
    	int count=0;
    	while (num!=0){
    		count++;
    		num=num/10;
    	}
    	return count;
    }
}