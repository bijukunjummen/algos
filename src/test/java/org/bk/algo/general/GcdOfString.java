package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GcdOfString {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String currentMax = "";

        if ((str1 + str2).equals(str2 + str1)) {
            for (int i = 0; i < Math.min(len1, len2); i++) {
                String candidate = str1.substring(0, i + 1);
                int candidateLen = i + 1;
                if (verifyPossible(str1, candidate, candidateLen) && verifyPossible(str2, candidate, candidateLen)) {
                    currentMax = candidate;
                }
            }
            return currentMax;
        } else {
            return "";
        }
    }

    private boolean verifyPossible(String str1, String candidate, int candidateLen) {
        int multiple = str1.length() / candidateLen;
        StringBuilder builder = new StringBuilder(candidate);
        for (int i = 1; i < multiple; i++) {
            builder.append(candidate);
        }

        return str1.equals(builder.toString());
    }

    public String gcdOfStrings2(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String currentMax = "";

        if ((str1 + str2).equals(str2 + str1)) {
            int patternLength = gcd(len1, len2);
            return str1.substring(0, patternLength);
        } else {
            return "";
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


    @Test
    void testGcd() {
        assertThat(gcdOfStrings("ABABAB", "ABAB")).isEqualTo("AB");
        assertThat(gcdOfStrings("ABC", "DEF")).isEqualTo("");
    }

    @Test
    void testGcd2() {
        assertThat(gcdOfStrings2("ABABAB", "ABAB")).isEqualTo("AB");
        assertThat(gcdOfStrings2("ABAB", "ABABAB")).isEqualTo("AB");
        assertThat(gcdOfStrings2("ABC", "DEF")).isEqualTo("");
    }
}