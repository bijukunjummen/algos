package org.bk.algo.sort.algo02.insertion;

import org.bk.algo.sort.SortFixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BubbleSortTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		BubbleSort.sort(arr);		
		assertThat(arr).isEqualTo(SortFixtures.fixture1Expected());
	}

}
