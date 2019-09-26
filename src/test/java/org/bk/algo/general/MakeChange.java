package org.bk.algo.general;

import org.junit.jupiter.api.Test;

public class MakeChange {


    @Test
    void testMakeChange() {
        int[] denoms = {25, 10, 5, 1};
        System.out.println(makeChange(100, denoms));
    }
    // 100 cents
    // 25 50
    int makeChange(int n, int[] denom) {
        if (n == 0) {
            return 1;
        }
        return makeChange(n, 0, denom);
    }

    int makeChange(int n, int currentIndex, int[] denom) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (currentIndex > denom.length - 1) {
            return 0;
        }

        int d = denom[currentIndex];

        return makeChange(n - d, currentIndex, denom) + makeChange(n, currentIndex + 1, denom);


    }


}
