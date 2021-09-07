package org.bk.algo.chap1;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q03Urlify {

    @Test
    public void testUrlify() {
        assertThat(urlify("mr john smith    ", 13)).isEqualTo("mr%20john%20smith");
    }

    private boolean urlify(String s, int len) {
        return false;
    }
}
