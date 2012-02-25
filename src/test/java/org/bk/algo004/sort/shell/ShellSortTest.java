package org.bk.algo004.sort.shell;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;

import org.bk.algo.sort.SortFixtures;
import org.junit.Test;

public class ShellSortTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		ShellSort.sort(arr);		
		assertThat(arr, is(arrayContaining(SortFixtures.fixture1Expected())));
	}

}
