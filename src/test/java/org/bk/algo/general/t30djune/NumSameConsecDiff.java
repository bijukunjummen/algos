package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class NumSameConsecDiff {
    public int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            numSame("" + i, i, N, K, result);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void numSame(String prefix, int lastDigit, int N, int K, Set<Integer> result) {
        if (prefix.length() > N) {
            return;
        }
        if (prefix.length() == N) {
            result.add(Integer.valueOf(prefix));
            return;
        }

        if (prefix.equals("0")) return;

        if (lastDigit - K >= 0) {
            int p = lastDigit - K;
            numSame(prefix + p, p, N, K, result);
        }
        if (lastDigit + K < 10) {
            int p = lastDigit + K;
            numSame(prefix + p, p, N, K, result);
        }
    }

    @Test
    void testNumsConsec() {
        System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
    }
}