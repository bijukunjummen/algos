package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IntToRoman {
    public String intToRoman(int num) {
        return "" + reduceAndReturn(num);
    }

    private String reduceAndReturn(int n) {
        if (n == 0) {
            return "";
        }
        Symbol s = forValue(n);
        return s.name() + reduceAndReturn(n - s.value);
    }

    private Symbol forValue(int n) {
        for (Symbol s : Symbol.highestToLowest()) {
            if (n >= s.value) {
                return s;
            }
        }
        throw new IllegalStateException("Strange!!");
    }

    enum Symbol {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100), CD(400),
        D(500), CM(900), M(1000);

        private final int value;
        private static List<Symbol> reverseOrderMemoized;

        Symbol(int value) {
            this.value = value;
        }

        public static List<Symbol> highestToLowest() {
            if (reverseOrderMemoized == null) {
                reverseOrderMemoized = Arrays.stream(Symbol.values()).sorted(Comparator.reverseOrder()).toList();
            }
            return reverseOrderMemoized;
        }
    }

    @Test
    void testIntToRoman() {
        assertThat(intToRoman(3)).isEqualTo("III");
        assertThat(intToRoman(58)).isEqualTo("LVIII");
        assertThat(intToRoman(1994)).isEqualTo("MCMXCIV");
    }
}