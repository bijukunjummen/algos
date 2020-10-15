package org.bk.algo.general.t30sep;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        int maxWin = len > k ? k : len;
        for (int idx = 0; idx <= len - 1 - k; idx++) {
            int win = expandWindowToMax(idx, k, s);
            if (win > maxWin) {
                maxWin = win;
            }
        }
        return maxWin;
    }

    private int expandWindowToMax(int startIndex, int k, String s) {
        String sub = s.substring(startIndex, startIndex + k);
        int nextIndex = startIndex + k;
        int dist = countDistinct(sub);
        while (dist <= k && nextIndex < s.length()) {
            String nextSub = sub + s.charAt(nextIndex);
            dist = countDistinct(nextSub);
            if (dist > k) {
                return sub.length();
            } else {
                sub = nextSub;
            }
            nextIndex++;
        }
        return sub.length();

    }

    private int countDistinct(String sub) {
        Set<Character> seen = new HashSet<>();
        int dist = 0;
        char[] cArr = sub.toCharArray();
        for (int i = 0; i < sub.length(); i++) {
            char c = cArr[i];
            if (!seen.contains(Character.valueOf(c))) {
                dist++;
                seen.add(Character.valueOf(c));
            }
        }
        return dist;
    }

    @Test
    void test() {
        Assertions.assertThat(lengthOfLongestSubstringKDistinct("eceba", 2)).isEqualTo(3);
        Assertions.assertThat(lengthOfLongestSubstringKDistinct("aa", 0)).isEqualTo(0);
        Assertions.assertThat(lengthOfLongestSubstringKDistinct("aa", 1)).isEqualTo(2);
    }
}