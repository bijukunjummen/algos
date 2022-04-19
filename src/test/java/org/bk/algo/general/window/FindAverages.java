package org.bk.algo.general.window;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FindAverages {
    double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        int windowSum = 0;
        for (int winStart = 0, winEnd = 0; winEnd < arr.length; winEnd++) {
            windowSum += arr[winEnd];
            if (winEnd >= K - 1) {
                result[winStart] = (double) windowSum / K;
                windowSum -= arr[winStart];
                winStart++;
            }
        }
        return result;
    }

    @Test
    void testAverages() {
        double[] result = findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        assertThat(result).isEqualTo(new double[]{2.2, 2.8, 2.4, 3.6, 2.8});
    }
}
