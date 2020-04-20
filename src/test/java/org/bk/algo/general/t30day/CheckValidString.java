package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

class CheckValidString {

    public boolean checkValidString(String s) {
        Deque<Integer> parenStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            if (c == '(') {
                parenStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else { // )
                if (parenStack.peek() != null) {
                    parenStack.pop();
                } else if (starStack.peek() != null) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        return checkBalanced(parenStack, starStack);
    }

    private boolean checkBalanced(Deque<Integer> parenStack, Deque<Integer> starStack) {
        while (!parenStack.isEmpty() && !starStack.isEmpty()) {
            int parenPosition = parenStack.pop();
            int starPosition = starStack.pop();

            if (parenPosition > starPosition) {
                return false;
            }
        }
        return parenStack.isEmpty();
    }


    @Test
    void testValidity() {
        assertThat(checkValidString("()")).isTrue();
        assertThat(checkValidString("(*)")).isTrue();
        assertThat(checkValidString("((*)")).isTrue();
        assertThat(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*")).isFalse();
    }
}