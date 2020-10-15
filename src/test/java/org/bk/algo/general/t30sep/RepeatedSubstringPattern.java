package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int l = s.length();

        boolean exhausted = false;
        int st = 0;
        while(!exhausted) {
            int p = findNextInstanceOfChar(s.charAt(0), st, s);
            if (p == -1) {
                return false;
            }
            int potentialLen = checkUptoLen(s, 0, p);
            boolean isRepeating = checkIfRepeating(s, st, potentialLen);
            if (isRepeating) return true;
            st = p;
        }
        return false;
    }
    
    private int findNextInstanceOfChar(char c, int st, String s) {
        for (int i = st + 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        
        return -1;
    }
    
    private boolean checkIfRepeating(String s, int st, int len) {
        String sub = s.substring(0, len);
        String matched = sub;
        int from = 0;
        while(from + len <= s.length()) {
            if (!sub.equals(s.substring(from, from + len))) {
                return false;
            }
            from = from + len;            
        }
        return (from == s.length());
    }
    
    private int checkUptoLen(String s, int st, int p) {
        int l = s.length();
        int idx1 = st;
        int idx2 = p;
        
        int count = 0;
        while (idx1 < p && idx2 <= (l - 1) && s.charAt(idx1) == s.charAt(idx2)) {
            idx1++;
            idx2++;
            count ++;
        }
        return count;
    }

    @Test
    void testRepeated() {
        assertThat(repeatedSubstringPattern("abab")).isTrue();
        assertThat(repeatedSubstringPattern("aba")).isFalse();
        assertThat(repeatedSubstringPattern("abaababaab")).isTrue();
        assertThat(repeatedSubstringPattern("aabaaba")).isFalse();
    }
}