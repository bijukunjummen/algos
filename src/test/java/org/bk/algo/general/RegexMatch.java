package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegexMatch {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public boolean isMatch2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0)) || (p.charAt(0) == '.');

        boolean isFollowedByStar = p.length() >= 2 && p.charAt(1) == '*';

        if (isFollowedByStar) {
            return isMatch2(s, p.substring(2)) || (firstMatch && isMatch2(s.substring(1), p));
        } else {
            return firstMatch && isMatch2(s.substring(1), p.substring(1));
        }
    }

    @Test
    void isMatchTest() {
        assertThat(isMatch("aa", "a*")).isTrue();
        assertThat(isMatch("ab", ".*")).isTrue();
    }

    @Test
    void isMatchTest2() {
        assertThat(isMatch2("aa", "a*")).isTrue();
        assertThat(isMatch2("ab", ".*")).isTrue();
    }
}