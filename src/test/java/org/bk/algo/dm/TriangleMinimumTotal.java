package org.bk.algo.dm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleMinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (List<Integer> row : triangle) {
            List<Integer> rowData = new ArrayList<>();
            dp.add(rowData);
            for (Integer v : row) {
                rowData.add(v);
            }
        }
        int size = triangle.size();

        for (int r = size - 2; r >= 0; r--) {
            List<Integer> rowValues = triangle.get(r);
            for (int c = 0; c < rowValues.size(); c++) {
                int nextPath = Math.min(dp.get(r + 1).get(c), dp.get(r + 1).get(c + 1));
                dp.get(r).set(c, Integer.valueOf(rowValues.get(c) + nextPath));
            }
        }
        return dp.get(0).get(0);
    }

    @Test
    void testMinTotal() {
        assertThat(minimumTotal(
                List.of(
                        List.of(2),
                        List.of(3, 4),
                        List.of(6, 5, 7),
                        List.of(4, 1, 8, 3)))).isEqualTo(11);
        assertThat(minimumTotal(
                List.of(
                        List.of(-10)))).isEqualTo(-10);
    }
}
