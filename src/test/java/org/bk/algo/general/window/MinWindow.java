package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MinWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> pattern = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = pattern.getOrDefault(c, 0);
            pattern.put(c, count + 1);
        }

        Map<Character, Integer> sPattern = new HashMap<>();
        int l = 0;
        int r = 0;
        int formed = 0;
        int required = pattern.size();
        int smallestWindow = -1;
        int smallL = 0;
        int smallR = 0;
        while (r < s.length()) {
            char rChar = s.charAt(r);
            int count = sPattern.getOrDefault(rChar, 0);
            sPattern.put(rChar, count + 1);

            if (pattern.containsKey(rChar) && pattern.get(rChar) == count + 1) {
                formed++;
            }

            while (l <= r && formed == required) {
                if (smallestWindow == -1 || (r - l + 1) < smallestWindow) {
                    smallestWindow = r - l + 1;
                    smallL = l;
                    smallR = r;
                }
                char cL = s.charAt(l);
                sPattern.put(cL, sPattern.get(cL) - 1);
                if (pattern.containsKey(cL) && sPattern.get(cL) < pattern.get(cL)) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return (smallestWindow == -1) ? "" : s.substring(smallL, smallR + 1);
    }

    @Test
    void testMinWindow() {
        assertThat(minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
        assertThat(minWindow("a", "a")).isEqualTo("a");
    }
}