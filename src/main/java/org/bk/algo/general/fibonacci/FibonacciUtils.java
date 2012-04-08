package org.bk.algo.general.fibonacci;

public class FibonacciUtils {
	public static long getRecFibAt(int n){
		if (n==0) return 0l;
		if (n==1) return 1l;
		else return (getRecFibAt(n-1) + getRecFibAt(n-2));
	}

	
	public static long getIterFibAt(int n){
		long prevTwiceRemoved = 0l;
		long prev = 1l;

		if (n==0) return prevTwiceRemoved;
		if (n==1) return prev;

		long fib = 0l;
		for (int i=2;i<=n;i++){
			fib = prev + prevTwiceRemoved;
			prevTwiceRemoved = prev;
			prev = fib;
		}
		
		return fib;
	}

}
