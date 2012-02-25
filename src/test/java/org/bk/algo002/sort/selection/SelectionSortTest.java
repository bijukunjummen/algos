package org.bk.algo002.sort.selection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;

import org.bk.algo.sort.SortFixtures;
import org.junit.Test;

public class SelectionSortTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		SelectionSort.sort(arr);		
		assertThat(arr, is(arrayContaining(SortFixtures.fixture1Expected())));
	}

}
