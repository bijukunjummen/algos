package org.bk.algo.general.gcd;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GcdTest {

    @Test
    public void testGcdOf4And6Is2() {
        assertThat(Gcd.of(4, 6)).isEqualTo(2);
    }

    @Test
    public void testGcdOf4And4Is4() {
        assertThat(Gcd.of(4, 4)).isEqualTo(4);
    }

    @Test
    public void testGcdOf17And23Is1() {
        assertThat(Gcd.of(17, 23)).isEqualTo(1);
    }

    @Test
    public void testGcdOf27And18Is9() {
        assertThat(Gcd.of(27, 18)).isEqualTo(9);
    }
}
