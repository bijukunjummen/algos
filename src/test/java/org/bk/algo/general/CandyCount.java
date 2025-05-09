package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CandyCount {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            count[i] = 1;
        }
        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i > 0 && ratings[i] > ratings[i - 1] && count[i] <= count[i - 1]) {
                    count[i]++;
                    hasChanged = true;
                }

                if (i < ratings.length - 1 && ratings[i] > ratings[i + 1] && count[i] <= count[i + 1]) {
                    count[i]++;
                    hasChanged = true;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < count.length; i++) {
            total += count[i];
        }
        return total;
    }

    @Test
    void testCandy() {
        int[] ratings = {1, 0, 2};
        int count = candy(ratings);
        assertThat(count).isEqualTo(5);

        ratings = new int[]{1, 2, 2};
        count = candy(ratings);
        assertThat(count).isEqualTo(4);
    }
}