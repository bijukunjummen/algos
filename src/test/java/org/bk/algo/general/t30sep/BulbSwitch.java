package org.bk.algo.general.t30sep;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

class BulbSwitch {
    public int bulbSwitch(int n) {
        BitSet bitSet = new BitSet(n);
        for (int i = 1; i <= n; i++) {
            setBits(bitSet, i, n);
        }
        return onBits(bitSet);
    }

    private int onBits(BitSet bitSet) {
        return (int) bitSet.stream().count();
    }

    private void setBits(BitSet bitSet, int idx, int n) {
        for (int i = 0; i < n; i++) {
            if ((i + 1) % idx == 0) {
                bitSet.flip(i);
            }
        }
    }

    @Test
    void testSwitch() {
        Assertions.assertThat(bulbSwitch(3)).isEqualTo(1);
        Assertions.assertThat(bulbSwitch(99999)).isEqualTo(316);
    }

}
