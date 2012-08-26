package org.bk.algo.sort.algo04.merge;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;

import org.bk.algo.sort.SortFixtures;
import org.junit.Test;

public class MergeSortForkJoinTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		MergeSortForkJoin.sort(arr);
		assertThat(arr, is(arrayContaining(SortFixtures.fixture1Expected())));
	}
	
	@Test
	public void testForALargeArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1MillionRecords();
		MergeSortForkJoin.sort(arr);
	}

}
