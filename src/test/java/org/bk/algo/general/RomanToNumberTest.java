package org.bk.algo.general;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanToNumberTest {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int currIndex = 0;
        while (currIndex < chars.length) {
            char c = chars[currIndex];
            if (nextMoreThanCurrent(c, currIndex, chars)) {
                res += (romanCharToInt(chars[currIndex + 1]) - romanCharToInt(c));
                currIndex++;
            } else {
                res += romanCharToInt(c);
            }
            currIndex++;
        }
        return res;
    }

    private boolean nextMoreThanCurrent(char c, int currIndex, char[] chars) {
        final int currCharToInt = romanCharToInt(c);

        if (currIndex >= chars.length - 1) {
            return false;
        }

        final int nextCharToInt = romanCharToInt(chars[currIndex + 1]);

        if (currCharToInt < nextCharToInt) {
            return true;
        }

        return false;
    }

    public int romanCharToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }


    @Test
    public void testRomanToInt() {
        assertThat(romanToInt("III")).isEqualTo(3);
        assertThat(romanToInt("IV")).isEqualTo(4);
        assertThat(romanToInt("IV")).isEqualTo(4);
    }
}