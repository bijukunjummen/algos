package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 > l2) {
            return false;
        }
        Map<Character, Integer> p1 = getCharFrequency(s1);
        int l = 0, r = 0;
        Map<Character, Integer> p2 = new HashMap<>();
        while (r < l2) {
            char c = s2.charAt(r);

            if (r - l + 1 < l1) { // increment r until window size matches up
                int count = p2.getOrDefault(c, 0);
                p2.put(c, count + 1);
                r++;
            } else if (r - l + 1 == l1) { //when it matches up, increment l and r while comparing patterns..
                // add r
                int count = p2.getOrDefault(c, 0);
                p2.put(c, count + 1);

                if (l > 0) {
                    // remove l - 1
                    char atL = s2.charAt(l - 1);
                    int lCount = p2.get(atL);
                    if (lCount - 1 == 0) {
                        p2.remove(atL);
                    } else {
                        p2.put(atL, lCount - 1);
                    }
                }
                if (p1.equals(p2)) {
                    return true;
                }
                r++;
                l++;
            }
        }
        return false;
    }

    private Map<Character, Integer> getCharFrequency(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            int count = freq.getOrDefault(c, 0);
            freq.put(c, count + 1);
        }
        return freq;
    }

    @Test
    void testInclusion() {
        assertThat(checkInclusion("ab", "eidbaooo")).isTrue();
        assertThat(checkInclusion("ab", "eidboaoo")).isFalse();
    }
}