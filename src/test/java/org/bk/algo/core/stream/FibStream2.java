package org.bk.algo.core.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FibStream2 {

    @Test
    void fibStream() {
        assertThat(streamOfFib()
                .limit(15)
                .collect(Collectors.toList()))
                .containsExactly(1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L);
    }


    private Stream<Long> streamOfFib() {
        return Stream
                .iterate(new FibState(), fibState -> fibState.nextFib())
                .map(fibState -> fibState.getValue());
    }

    private static class FibState {
        private final long[] prev;
        private final int index;

        public FibState() {
            this(new long[]{-1, 1}, 0);
        }

        public FibState(long[] prev, int index) {
            this.prev = prev;
            this.index = index;
        }

        public FibState nextFib() {
            int nextIndex = index + 1;
            long result = (nextIndex == 1) ? 1 : prev[0] + prev[1];
            return new FibState(new long[]{prev[1], result}, nextIndex);
        }

        public long getValue() {
            return prev[1];
        }
    }
}
