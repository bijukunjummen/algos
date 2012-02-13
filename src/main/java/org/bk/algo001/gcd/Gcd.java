package org.bk.algo001.gcd;

public class Gcd {
	public static int of(int a, int b){
		if (a%b==0) return b;
		return of(b, a%b);
	}
}
