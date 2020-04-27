package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryMatrixSearch {
    public int earliestOneInRow(int[] binMatrixRow) {
        return earliestOneInRow(binMatrixRow, 0, binMatrixRow.length - 1);
    }

    private int earliestOneInRow(int[] binMatrixRow, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        int mid = (lo + hi) / 2;

        if (binMatrixRow[mid] == 0) {
            return earliestOneInRow(binMatrixRow, mid + 1, hi);
        } else {
            if (mid == 0) {
                return 0;
            } else {
                int oneBefore = binMatrixRow[mid - 1];
                if (oneBefore == 0) {
                    return mid;
                } else {
                    return earliestOneInRow(binMatrixRow, lo, mid - 1);
                }
            }
        }
    }

    @Test
    void testEarliest1InRow() {
        assertThat(earliestOneInRow(new int[]{0, 0, 0, 1, 1, 1})).isEqualTo(3);
    }
}
