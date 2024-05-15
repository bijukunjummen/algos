package org.bk.algo.general.window;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> charMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character sourceChar = s.charAt(i);
            Character destChar = t.charAt(i);
            if (charMap.containsKey(sourceChar) && (charMap.get(sourceChar) != destChar)) {
                return false;
            }
            if (tMap.containsKey(destChar) && tMap.get(destChar) != sourceChar) {
                return false;
            }
            charMap.put(sourceChar, destChar);
            tMap.put(destChar, sourceChar);
        }
        return true;
    }


    @Test
    void testIsomorphic() {
        assertThat(isIsomorphic("egg", "add")).isTrue();
        assertThat(isIsomorphic("foo", "bar")).isFalse();
        assertThat(isIsomorphic("bbbaaaba", "aaabbbba")).isFalse();
    }
}