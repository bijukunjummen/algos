package org.bk.algo.core.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FibStream {

    @Test
    void fibStream() {
        assertThat(streamOfFib()
                .limit(15)
                .collect(Collectors.toList()))
                .containsExactly(1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L);
    }

    private Stream<Long> streamOfFib() {
        FibState fibState = new FibState();
        return Stream.generate(() -> fibState.nextFib());
    }

    private static class FibState {
        private long[] prev = new long[2];
        private int index = 0;

        public long nextFib() {
            long result = (index == 0) ? 1
                    : ((index == 1) ? 1 : prev[0] + prev[1]);
            prev[0] = prev[1];
            prev[1] = result;
            index++;
            return result;
        }
    }
}
