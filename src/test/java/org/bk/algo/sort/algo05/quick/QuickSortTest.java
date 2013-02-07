package org.bk.algo.sort.algo05.quick;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsArrayContainingInOrder.arrayContaining;
import static org.junit.Assert.assertThat;

import org.bk.algo.sort.SortFixtures;
import org.junit.Test;

public class QuickSortTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		QuickSort.sort(arr);
		assertThat(arr, is(arrayContaining(SortFixtures.fixture1Expected())));
	}
	
   @Test
   public void testForASmallArrayOfIntegersWithRepeatingValues(){
        Integer[] arr = SortFixtures.fixture2();
        QuickSort.sort(arr);
        assertThat(arr, is(arrayContaining(SortFixtures.fixture2Expected())));
    }
   
   @Test
   public void testForASmallArrayOfIntegersWithRepeatingValues2(){
        Integer[] arr = SortFixtures.fixture3();
        QuickSort.sort(arr);
        assertThat(arr, is(arrayContaining(SortFixtures.fixture3Expected())));
    }
   
   @Test
   public void testForASmallArrayOfIntegersValues3(){
        Integer[] arr = SortFixtures.fixture4();
        QuickSort.sort(arr);
        assertThat(arr, is(arrayContaining(SortFixtures.fixture4Expected())));
    }
   
   @Test
   public void testForALargeArrayOfIntegers(){
       Integer[] arr = SortFixtures.fixture1MillionRecords();
       QuickSort.sort(arr);
       assertThat(arr[999999], is(999999806));
       assertThat(arr[999998], is(999999117));
       assertThat(arr[999997], is(999998470));
       assertThat(arr[999996], is(999998391));
       assertThat(arr[999995], is(999996735));
       assertThat(arr[999994], is(999995944));
       assertThat(arr[999993], is(999995497));
       assertThat(arr[999992], is(999994214));
       assertThat(arr[999991], is(999993723));
       assertThat(arr[999990], is(999992630));
   }
   

}
