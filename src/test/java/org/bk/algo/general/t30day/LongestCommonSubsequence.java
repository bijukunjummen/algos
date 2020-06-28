package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        final int len1 = text1.length();

        final int len2 = text2.length();

        int[][] dp = new int[len1][len2];
        dp[0][0] = 0;
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = Math.max(i > 0 ? dp[i - 1][j] : 0, j > 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        // Arrays.stream(dp).forEach(arr -> {
        //     System.out.println(Arrays.toString(arr));
        // });
        return dp[len1 - 1][len2 - 1];
    }


    @Test
    void testSub1() {
        assertThat(longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
        assertThat(longestCommonSubsequence("ace", "ace")).isEqualTo(3);
        assertThat(longestCommonSubsequence("abc", "def")).isEqualTo(0);
        assertThat(longestCommonSubsequence("psnw", "vozsh")).isEqualTo(1);
        assertThat(longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy")).isEqualTo(2);
    }

    @Test
    void testSub2() {
        assertThat(longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq")).isEqualTo(6);
    }

    @Test
    void testSub3() {
        assertThat(longestCommonSubsequence(
                "lcnqdmvsdopkvqvejijcdyxetuzonuhuzkpelmva",
                "bklgfivmpozinybwlovcnafqfybodkhabyrglsnen")).isEqualTo(9);
    }
}