package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        int len1 = getSubSequences(text1)
                .filter(sub -> isSubsequence(text2, sub))
                .map(str -> str.length())
                .max(Comparator.naturalOrder())
                .orElse(0);

        int len2 = getSubSequences(text2)
                .filter(sub -> isSubsequence(text1, sub))
                .map(str -> str.length())
                .max(Comparator.naturalOrder())
                .orElse(0);

        return len1 >= len2 ? len1 : len2;
    }

    private Stream<String> getSubSequences(String text) {
        return getSubSequences("", text);
    }

    private Stream<String> getSubSequences(String prefix, String text) {
        if (text == null || text.length() == 0) {
            return Stream.of(prefix);
        }

        char firstChar = text.charAt(0);

        return Stream.concat(
                getSubSequences(prefix + firstChar, text.substring(1)),
                getSubSequences(prefix, text.substring(1))
        );
    }

    private boolean isSubsequence(String text, String sub) {
        String toRegex = toRegex(sub);
        return text.matches(toRegex);
    }

    private String toRegex(String sub) {
        String s = ".*?";
        for (char c : sub.toCharArray()) {
            s += c + ".*?";
        }
        return s;
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
    void testSubSequence() {
        assertThat(isSubsequence("abcde", "ace")).isTrue();
        assertThat(isSubsequence("ace", "abcde")).isFalse();
        assertThat(isSubsequence("abcde", "aze")).isFalse();
        assertThat(isSubsequence("abcde", "aed")).isFalse();
        assertThat(isSubsequence("vozsh", "s")).isTrue();
    }

    @Test
    void testAllSubstringStreams() {
        Stream<String> stream = getSubSequences("abc");

        stream.forEach(str -> {
            System.out.println(str);
        });
    }


}