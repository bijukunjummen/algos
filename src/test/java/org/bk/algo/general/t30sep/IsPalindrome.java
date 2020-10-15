package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IsPalindrome {
    public boolean isPalindrome(String s) {
        Character[] p = canonical(s);
        int i = 0;
        int j = p.length- 1;
        while (i <= j) {
            if (p[i] != p[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private Character[] canonical(String s) {
        char[] p = s.toCharArray();
        List<Character> canonical = new ArrayList<>();
        for (char c: p) {
            if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                canonical.add(Character.toLowerCase(c));
            }
        }

        return canonical.toArray(new Character[canonical.size()]);
    }

    @Test
    void test() {
        assertThat(isPalindrome("A man, a plan, a canal: Panama")).isTrue();
    }
}