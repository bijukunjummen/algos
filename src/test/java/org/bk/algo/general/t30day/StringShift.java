package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringShift {
    public String stringShift(String s, int[][] shift) {
        int idx = 0;
        char[] sArr = s.toCharArray();
        for (int i = 0; i < shift.length; i++) {
            int direction = shift[i][0];
            int quant = shift[i][1];
            idx = stringShift(sArr, idx, direction, quant);
        }
        return recreateFrom(sArr, idx);
    }

    private String recreateFrom(char[] sArr, int idx) {
        int length = sArr.length;
        char[] resArr = new char[length];

        int resIdx = idx;
        for (int i = 0; i < sArr.length; i++) {
            resArr[resIdx % length] = sArr[i];
            resIdx++;
        }
        return String.valueOf(resArr);
    }

    private int stringShift(char[] sArr, int startIndex, int direction, int quant) {
        int length = sArr.length;
        if (direction == 0) {
            int resIndex = (startIndex - quant) % length;
            if (resIndex < 0) {
                resIndex = length + resIndex;
            }
            return resIndex;
        } else {
            //direction == 1
            return (startIndex + quant) % length;
        }
    }

    @Test
    void test1() {
        assertThat(stringShift("abc", new int[][]{{0, 1}, {1, 2}})).isEqualTo("cab");
        assertThat(stringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}})).isEqualTo("efgabcd");
    }
}