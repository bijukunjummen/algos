package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConcatenatedBinary {
    private static int MODULO = 1_000_000_007;

    public int concatenatedBinary(int n) {
        if (n == 0) return 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); j++) {
                result = (result << 1) % MODULO;
            }
            result = result + i;
        }
        return result;
    }

//    private String decimalToBin(int n) {
//        String result = "";
//        while (n != 0) {
//            result = (n % 2) + result;
//            n = n / 2;
//        }
//        return result;
//    }

//    @Test
//    void toBinTest() {
//        assertThat(decimalToBin(8)).isEqualTo("1000");
//        assertThat(decimalToBin(1)).isEqualTo("1");
//        assertThat(decimalToBin(2)).isEqualTo("10");
//        assertThat(decimalToBin(4)).isEqualTo("100");
//    }

    @Test
    void binaryTest() {
        System.out.println(1);
        System.out.println(Integer.MAX_VALUE);

    }

    @Test
    void concatBinTest() {
        assertThat(concatenatedBinary(3)).isEqualTo(27);
        assertThat(concatenatedBinary(12)).isEqualTo(505379714);
    }


}