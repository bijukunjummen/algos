package org.bk.algo.sort.algo08.radix;


import org.bk.algo.sort.SortFixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RadixSortTest {

    @Test
    public void testForASmallArrayOfIntegers() {
        Integer[] arr = SortFixtures.fixture1();
        RadixSort.sort(arr);
        assertThat(arr).isEqualTo(SortFixtures.fixture1Expected());
    }

    @Test
    public void testForASmallArrayOfIntegersWithRepeatingValues() {
        Integer[] arr = SortFixtures.fixture2();
        RadixSort.sort(arr);
        assertThat(arr).isEqualTo(SortFixtures.fixture2Expected());
    }

    @Test
    public void testForASmallArrayOfIntegersWithRepeatingValues2() {
        Integer[] arr = SortFixtures.fixture3();
        RadixSort.sort(arr);
        assertThat(arr).isEqualTo(SortFixtures.fixture3Expected());
    }

    @Test
    public void testForASmallArrayOfIntegersValues3() {
        Integer[] arr = SortFixtures.fixture4();
        RadixSort.sort(arr);
        assertThat(arr).isEqualTo(SortFixtures.fixture4Expected());
    }

}
