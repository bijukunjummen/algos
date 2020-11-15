package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddBinary {
    public String addBinary(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int len = Math.max(as.length, bs.length);
        char carry = '0';
        String result = "";
        for (int i = 0; i < len; i++) {
            BaseAndCarry bc = sum(i, as, bs, carry);
            carry = bc.carry;
            result = bc.base + result;
        }
        if (carry == '0') {
            return result;
        } else {
            return carry + result;
        }
    }

    private BaseAndCarry sum(int idx, char[] as, char[] bs, char carry) {
        char c1 = (idx <= as.length - 1) ? as[as.length - 1 - idx] : '0';
        char c2 = (idx <= bs.length - 1) ? bs[bs.length - 1 - idx] : '0';

        int result = (c1 - '0') + (c2 - '0') + (carry - '0');

        if (result == 0) {
            return new BaseAndCarry('0');
        } else if (result == 1) {
            return new BaseAndCarry('1');
        } else if (result == 2) {
            return new BaseAndCarry('0', '1');
        } else if (result == 3) {
            return new BaseAndCarry('1', '1');
        }
        throw new IllegalStateException("bad case!");
    }

    @Test
    void basicTest() {
        assertThat(addBinary("11", "1")).isEqualTo("100");
        assertThat(addBinary("1010", "1011")).isEqualTo("10101");
    }

    static class BaseAndCarry {
        char base;
        char carry;

        BaseAndCarry(char base, char carry) {
            this.base = base;
            this.carry = carry;
        }

        BaseAndCarry(char base) {
            this(base, '0');
        }
    }

}