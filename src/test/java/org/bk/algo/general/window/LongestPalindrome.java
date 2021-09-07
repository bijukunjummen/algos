package org.bk.algo.general.window;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestPalindrome {
    public String longestPalindrome1(String s) {
        int len = s.length();
        String max = "";
        for (int i = 0; i < len - 1; i++) {
            String m1 = tryExpand(i, i, s);
            String m2 = tryExpand(i, i + 1, s);
            max = max(m1, m2, max);
        }
        return max;
    }

    private String max(String... strings) {
        String max = "";
        for (String s : strings) {
            if (s.length() > max.length()) {
                max = s;
            }
        }
        return max;
    }

    private String tryExpand(int i, int j, String s) {
        int l = i;
        int r = j;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public boolean isPalindrome(String s) {
        final int lastIndex = s.length() - 1;
        int mid = lastIndex / 2;

        for (int i = 0; i <= mid; i++) {
            char left = s.charAt(i);
            char right = s.charAt(lastIndex - i);
            if (!(left == right)) {
                return false;
            }
        }
        return true;
    }

    // Based on description here - http://users.eecs.northwestern.edu/~dda902/336/hw6-sol.pdf
    public int longestPalindrome2(String s) {
        char[] arr = s.toCharArray();
        int[][] L = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            L[i][i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                L[i][j] = computeCost(L, arr, i, j);
            }
        }
        return L[0][arr.length - 1];
    }

    private int computeCost(int[][] L, char[] arr, int i, int j) {
        if (i == j) {
            return L[i][j];
        } else if (arr[i] == arr[j]) {
            if (i + 1 < j - 1) {
                return L[i + 1][j - 1] + 2;
            } else {
                return 2;
            }
        } else {
            return Math.max(L[i + 1][j], L[i][j - 1]);
        }
    }

    @Test
    public void testSomeStrings() {
        assertThat(longestPalindrome1("dfaadjflakfdjalkfjdkljkldfjklajfdklajdkmanymoremalayalammoreofit")).isEqualTo("malayalam");
        assertThat(longestPalindrome1("abaab")).isEqualTo("baab");
    }

    @Test
    public void testLongestPalindrome2() {
        assertThat(longestPalindrome2("dfaadjflakfdjalkfjdkljkldfjklajfdklajdkmanymoremalayalammoreofit")).isEqualTo(9);
        assertThat(longestPalindrome2("abaab")).isEqualTo(4);
    }

    @Test
    public void testPalindrome() {
        assertThat(isPalindrome("malayalam")).isTrue();
        assertThat(isPalindrome("malayala")).isFalse();
        assertThat(isPalindrome("ala")).isTrue();
        assertThat(isPalindrome("a")).isTrue();
        assertThat(isPalindrome("bb")).isTrue();
        assertThat(isPalindrome("bab")).isTrue();
    }
}
