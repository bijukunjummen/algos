package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountVowelStrings {
    // 'a', 'e', 'i', 'other', 'u'
    public int countVowelStrings(int n) {
        return countVowelStrings(0, '0', n);
    }

    private int countVowelStrings(int idx, char c, int n) {
        if (idx > n - 1) {
            return 1;
        }
        char[] cs = getLargerThanOrEqualTo(c);
        int sum = 0;
        for (char ch : cs) {
            sum += countVowelStrings(idx + 1, ch, n);
        }
        return sum;
    }

    private char[] getLargerThanOrEqualTo(char c) {
        switch (c) {
            case '0':
            case 'a':
                return new char[]{'a', 'e', 'i', 'o', 'u'};
            case 'e':
                return new char[]{'e', 'i', 'o', 'u'};
            case 'i':
                return new char[]{'i', 'o', 'u'};
            case 'o':
                return new char[]{'o', 'u'};
            case 'u':
                return new char[]{'u'};
            default:
                throw new IllegalStateException("unepected :" + c);
        }
    }

    @Test
    void testCountVowel() {
        assertThat(countVowelStrings(1)).isEqualTo(5);
    }
}