package org.bk.algo.sort.algo08.radix;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;

import org.bk.algo.sort.SortFixtures;
import org.junit.Test;

public class RadixSortTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		RadixSort.sort(arr);
		assertThat(arr, arrayContaining(SortFixtures.fixture1Expected()));
	}
	
   @Test
   public void testForASmallArrayOfIntegersWithRepeatingValues(){
        Integer[] arr = SortFixtures.fixture2();
        RadixSort.sort(arr);
        assertThat(arr, arrayContaining(SortFixtures.fixture2Expected()));
    }
   
   @Test
   public void testForASmallArrayOfIntegersWithRepeatingValues2(){
        Integer[] arr = SortFixtures.fixture3();
        RadixSort.sort(arr);
        assertThat(arr, arrayContaining(SortFixtures.fixture3Expected()));
    }
   
   @Test
   public void testForASmallArrayOfIntegersValues3(){
        Integer[] arr = SortFixtures.fixture4();
        RadixSort.sort(arr);
        assertThat(arr, arrayContaining(SortFixtures.fixture4Expected()));
    }
	
	
}
