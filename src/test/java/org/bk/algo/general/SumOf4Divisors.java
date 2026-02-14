package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SumOf4Divisors {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            Set<Integer> divisors = divisors(num);
            if (divisors.size() == 4) {
                sum += divisors.stream().mapToInt(Integer::intValue).sum();
            }
        }
        return sum;
    }

    private Set<Integer> divisors(int num) {
        Set<Integer> divisors = new HashSet<>();
        for (int n = 1; n <= Math.sqrt(num); n++) {
            if (num % n == 0) {
                divisors.add(n);
                divisors.add(num / n);
            }
        }
        return divisors;
    }

    @Test
    void testSum() {
        assertThat(sumFourDivisors(new int[]{21, 4, 7})).isEqualTo(32);
    }
}