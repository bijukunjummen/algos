package org.bk.algo.sort.algo03.shell;

import org.bk.algo.sort.SortFixtures;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShellSortTest {

    @Test
    public void testForASmallArrayOfIntegers() {
        Integer[] arr = SortFixtures.fixture1();
        ShellSort.sort(arr);
        assertThat(arr).isEqualTo(SortFixtures.fixture1Expected());
    }

}
