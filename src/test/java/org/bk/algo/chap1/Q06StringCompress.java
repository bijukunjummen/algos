package org.bk.algo.chap1;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
