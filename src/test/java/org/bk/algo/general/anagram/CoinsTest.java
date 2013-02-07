package org.bk.algo.general.anagram;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CoinsTest {
	
	@Test
	public void testUniqueSums(){
		assertThat(countOfUniqueSumsWith5Coins(1, 5, 10), is(21));
	}
	
	public int countOfUniqueSumsWith5Coins(final int value1, final int value2, final int value3){
		Set<Integer> uniqueSums = new HashSet<Integer>();
		sumWith(0, 0, value1, value2, value3, uniqueSums);
		return uniqueSums.size();
	}
	
	private void sumWith(int currSum, int currIndex, final int value1, final int value2, final int value3, Set<Integer> uniqueSums){
		if (currIndex==5){
			uniqueSums.add(currSum);
			System.out.println(currSum);
			return;
		}
		
		sumWith(currSum+value1, currIndex+1, value1, value2, value3, uniqueSums);
		sumWith(currSum+value2, currIndex+1, value1, value2, value3, uniqueSums);
		sumWith(currSum+value3, currIndex+1, value1, value2, value3, uniqueSums);
	}
}