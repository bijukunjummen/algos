package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

class LongestValidParens {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    maxans = Math.max(maxans, i - stack.pop() + 1);
                }
            }
        }
        return maxans;
    }

    @Test
    void testValidParens() {
        assertThat(longestValidParentheses("(())")).isEqualTo(4);
        assertThat(longestValidParentheses(")()()")).isEqualTo(2);
    }
}