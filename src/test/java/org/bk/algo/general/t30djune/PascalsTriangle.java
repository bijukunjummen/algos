package org.bk.algo.general.t30djune;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PascalsTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int colIndex = 0; colIndex <= rowIndex; colIndex++) {
            row.add(getValue(rowIndex, colIndex, new HashMap<>()));
        }
        return row;
    }

    private Integer getValue(int rowIndex, int colIndex, Map<Integer, int[]> dp) {
        if (!dp.containsKey(rowIndex)) {
            dp.put(rowIndex, new int[rowIndex + 1]);
        }
        int[] cache = dp.get(rowIndex);
        if (cache[colIndex] != 0) {
            return cache[colIndex];
        }
        if (colIndex == 0 || colIndex == rowIndex) {
            cache[colIndex] = 1;
            return 1;
        }

        int res = getValue(rowIndex - 1, colIndex - 1, dp) + getValue(rowIndex - 1, colIndex, dp);
        cache[colIndex] = res;
        return res;
    }

    @Test
    void testValue() {
        assertThat(getValue(0, 0, new HashMap<>())).isEqualTo(1);
        assertThat(getValue(1, 0, new HashMap<>())).isEqualTo(1);
        assertThat(getValue(1, 1, new HashMap<>())).isEqualTo(1);
        assertThat(getValue(2, 0, new HashMap<>())).isEqualTo(1);
        assertThat(getValue(2, 1, new HashMap<>())).isEqualTo(2);
        assertThat(getValue(2, 2, new HashMap<>())).isEqualTo(1);
        assertThat(getValue(3, 0, new HashMap<>())).isEqualTo(1);
        assertThat(getValue(3, 0, new HashMap<>())).isEqualTo(1);
        assertThat(getValue(3, 1, new HashMap<>())).isEqualTo(3);
        assertThat(getValue(3, 2, new HashMap<>())).isEqualTo(3);
        assertThat(getValue(3, 3, new HashMap<>())).isEqualTo(1);
    }
}