package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LargestNumber {
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums).boxed()
                .sorted((n1, n2) -> {
                    String s1 = String.valueOf(n1);
                    String s2 = String.valueOf(n2);
                    return (s2 + s1).compareTo(s1 + s2);
                })
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining());
    }


    @Test
    void testSamples() {
        assertThat(largestNumber(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
    }

    @Test
    void sample2() {
        assertThat(largestNumber(new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512})).isEqualTo("8645124322562161281");
    }
}