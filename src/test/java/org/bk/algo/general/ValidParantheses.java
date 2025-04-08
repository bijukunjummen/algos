package org.bk.algo.general;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParantheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popped = stack.pop();

                if (c == ')' && popped != '(') {
                    return false;
                }
                if (c == '}' && popped != '{') {
                    return false;
                }
                if (c == ']' && popped != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @ParameterizedTest
    @MethodSource("sampleData")
    void testValid(String s, boolean expected) {
        assertThat(isValid(s)).isEqualTo(expected);
    }

    static Stream<Arguments> sampleData() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("]", false),
                Arguments.of("[", false)
        );
    }
}