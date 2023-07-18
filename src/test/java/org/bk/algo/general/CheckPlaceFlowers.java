package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int availablePlaces = calculateAvailability(flowerbed);
        return availablePlaces >= n;
    }

    private int calculateAvailability(int[] flowerbed) {
        int count = 0;

        int[] withfilled = new int[flowerbed.length];
        System.arraycopy(flowerbed, 0, withfilled, 0, flowerbed.length);
        for (int i = 0; i < flowerbed.length; i++) {
            if (withfilled[i] == 0 && checkNext(i, withfilled) && checkPrev(i, withfilled)) {
                withfilled[i] = 1;
                count++;
            }
        }
        return count;
    }

    private boolean checkNext(int i, int[] flowerbed) {
        if (flowerbed.length >= i + 2) {
            return flowerbed[i + 1] == 0;
        }
        return true;
    }

    private boolean checkPrev(int i, int[] flowerbed) {
        if (i == 0) {
            return true;
        }

        return flowerbed[i - 1] == 0;
    }

    @Test
    void testPlace() {
//        assertThat(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1)).isTrue();
        assertThat(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2)).isFalse();
    }
}