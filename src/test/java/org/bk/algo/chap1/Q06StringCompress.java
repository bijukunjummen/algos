package org.bk.algo.chap1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q06StringCompress {
    @Test
    public void testStringCompress() {
        assertThat(compress("aabccccaaa")).isEqualTo("a2b1c4a3");
    }

    private String compress(String s) {
        return null;
    }
}
