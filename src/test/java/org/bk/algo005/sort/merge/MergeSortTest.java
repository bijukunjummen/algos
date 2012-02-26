package org.bk.algo005.sort.merge;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;

import org.bk.algo.sort.SortFixtures;
import org.junit.Test;

public class MergeSortTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		MergeSort.sort(arr);
		assertThat(arr, is(arrayContaining(SortFixtures.fixture1Expected())));
	}

}
