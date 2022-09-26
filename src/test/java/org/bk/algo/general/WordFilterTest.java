package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordFilterTest {
    @Test
    void test1() {
        WordFilter wordFilter1 = new WordFilter(new String[]{"apple"});
        assertThat(wordFilter1.f("a", "e")).isEqualTo(0);
    }
}
