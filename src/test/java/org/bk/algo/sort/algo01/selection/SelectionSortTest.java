package org.bk.algo.sort.algo01.selection;

import org.bk.algo.sort.SortFixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectionSortTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		SelectionSort.sort(arr);		
		assertThat(arr).isEqualTo(SortFixtures.fixture1Expected());
	}

}
