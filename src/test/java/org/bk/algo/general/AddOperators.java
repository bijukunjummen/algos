package org.bk.algo.general;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class AddOperators {
    public List<String> addOperators(String num, int target) {
        int[] digits = getDigits(num);
        List<String> result = new ArrayList<>();
        recurse(result, digits, 0, target, 0, 0, List.of());
        return result;
    }

    private void recurse(List<String> result, int[] digits, int idx, int target, int current, int value,
                         List<String> ops) {
        if (idx == digits.length) {
            if (target == value) {
                result.add(stringValueOf(ops));
                return;
            }
        }
        int d = digits[idx];
        int next = current * 10 + d;
        recurse(result, digits, idx + 1, target, next, value + next, from(ops, String.valueOf(next)));
    }



    private String stringValueOf(List<String> ops) {
        return ops.stream().collect(Collectors.joining());
    }

    private List<String> from(List<String> source, String with) {
        ArrayList<String> result = new ArrayList<>(source);
        result.add(with);
        return result;
    }

    private static char getCharFromDigit(int digits) {
        return (char) ('0' + digits);
    }

    private int[] getDigits(String num) {
        int[] digits = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int digit = c - '0';
            digits[i] = digit;
        }
        return digits;
    }

    @Test
    void testAddOperators() {
        assertThat(addOperators("123", 6)).isEqualTo(List.of("1*2*3", "1+2+3"));
        assertThat(addOperators("232", 8)).isEqualTo(List.of("2*3+2", "2+3*2"));
    }
}