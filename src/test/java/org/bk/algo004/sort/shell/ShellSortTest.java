package org.bk.algo004.sort.shell;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ShellSortTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = new Integer[]{5,3,10,2000,15,9,2,1};
		ShellSort.sort(arr);
		
		assertThat(arr[0], is(1));
		assertThat(arr[1], is(2));
		assertThat(arr[2], is(3));
		assertThat(arr[3], is(5));
		assertThat(arr[4], is(9));
		assertThat(arr[5], is(10));
		assertThat(arr[6], is(15));
		assertThat(arr[7], is(2000));
	}

}
