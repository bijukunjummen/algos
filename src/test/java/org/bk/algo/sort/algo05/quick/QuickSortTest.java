package org.bk.algo.sort.algo05.quick;

import org.bk.algo.sort.SortFixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTest {
	
	@Test
	public void testForASmallArrayOfIntegers(){
		Integer[] arr = SortFixtures.fixture1();
		QuickSort.sort(arr);
		assertThat(arr).isEqualTo(SortFixtures.fixture1Expected());
	}
	
   @Test
   public void testForASmallArrayOfIntegersWithRepeatingValues(){
        Integer[] arr = SortFixtures.fixture2();
        QuickSort.sort(arr);
        assertThat(arr).isEqualTo(SortFixtures.fixture2Expected());
    }
   
   @Test
   public void testForASmallArrayOfIntegersWithRepeatingValues2(){
        Integer[] arr = SortFixtures.fixture3();
        QuickSort.sort(arr);
        assertThat(arr).isEqualTo(SortFixtures.fixture3Expected());
    }
   
   @Test
   public void testForASmallArrayOfIntegersValues3(){
        Integer[] arr = SortFixtures.fixture4();
        QuickSort.sort(arr);
        assertThat(arr).isEqualTo(SortFixtures.fixture4Expected());
    }
   
   @Test
   public void testForALargeArrayOfIntegers(){
       Integer[] arr = SortFixtures.fixture1MillionRecords();
       QuickSort.sort(arr);
       assertThat(arr[999999]).isEqualTo(999999806);
       assertThat(arr[999998]).isEqualTo(999999117);
       assertThat(arr[999997]).isEqualTo(999998470);
       assertThat(arr[999996]).isEqualTo(999998391);
       assertThat(arr[999995]).isEqualTo(999996735);
       assertThat(arr[999994]).isEqualTo(999995944);
       assertThat(arr[999993]).isEqualTo(999995497);
       assertThat(arr[999992]).isEqualTo(999994214);
       assertThat(arr[999991]).isEqualTo(999993723);
       assertThat(arr[999990]).isEqualTo(999992630);
   }
}
