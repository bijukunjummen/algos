package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

class LongestValidParens {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int lastGoodIndex = -1; //not set..
        Deque<CharAndIndex> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(new CharAndIndex(i, c));
            } else {
                if (!stack.isEmpty()) {
                    CharAndIndex charAndIndex = stack.pop();
//                    if (lastGoodIndex == -1) {
//                        lastGoodIndex = charAndIndex.index;
//                    }

                    maxans = Math.max(maxans, i - charAndIndex.index + 1);
                }
            }
        }
        return maxans;
    }

    static class CharAndIndex {
        int index;
        char c;

        CharAndIndex(int index, char c) {
            this.index = index;
            this.c = c;
        }
    }

    @Test
    void testValidParens() {
        assertThat(longestValidParentheses("(())")).isEqualTo(4);
        assertThat(longestValidParentheses(")()()")).isEqualTo(4);
    }
}