package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        String decodedS = resolved(S);
        String decodedT = resolved(T);

        return decodedS.equals(decodedT);
    }

    private String resolved(String s) {
        char[] chars = s.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : chars) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        char[] resultArr = new char[stack.size()];
        int idx = 0;
        Iterable<Character> iterable = () -> stack.descendingIterator();
        for (Character c : iterable) {
            resultArr[idx++] = c;
        }
        return String.valueOf(resultArr);
    }

    @Test
    void tests() {
        assertThat(backspaceCompare("ab#c", "ad#c")).isTrue();
        assertThat(backspaceCompare("ab##", "c#d#")).isTrue();
        assertThat(backspaceCompare("a##c", "#a#c")).isTrue();
        assertThat(backspaceCompare("a#c", "b")).isFalse();
    }
}