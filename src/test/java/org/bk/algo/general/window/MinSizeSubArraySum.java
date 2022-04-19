package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int s = 0;
    int sumSub = 0;
    int minCount = Integer.MAX_VALUE;
    for (int e = 0; e < arr.length; e++) {
      sumSub += arr[e];
      while (sumSub >= S) {
        minCount = Math.min(minCount, e - s + 1);
        sumSub -= arr[s];
        s++;
      }
    }
    return minCount == Integer.MAX_VALUE ? 0 : minCount;
  }

  @Test
  void test() {
    assertThat(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2})).isEqualTo(2);
    assertThat(findMinSubArray(7, new int[]{2, 1, 5, 2, 8})).isEqualTo(1);
    assertThat(findMinSubArray(8, new int[]{3, 4, 1, 1, 6})).isEqualTo(3);
    assertThat(findMinSubArray(26, new int[]{3, 4, 1, 1, 6})).isEqualTo(0);
  }
}