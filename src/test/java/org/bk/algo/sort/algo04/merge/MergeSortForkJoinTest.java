package org.bk.algo.sort.algo04.merge;

import org.bk.algo.sort.SortFixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeSortForkJoinTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		MergeSortForkJoin.sort(arr);
		assertThat(arr).isEqualTo(SortFixtures.fixture1Expected());
	}
	
	@Test
	public void testForALargeArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1MillionRecords();
		MergeSortForkJoin.sort(arr);
	}

}
