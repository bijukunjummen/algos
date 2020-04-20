package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ContiguousArrayMaxLength {
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        int startWindow = (length % 2 == 0) ? length : length - 1;
        for (int win = startWindow; win > 1; win = win - 2) {
            Pair initial = getCounts(nums, 0, win - 1);
            int maxLength = findMaxLength(nums, win, initial);
            if (maxLength > 0) {
                return maxLength;
            }

        }
        return 0;
    }

    private int findMaxLength(int[] nums, int win, Pair incoming) {
        Pair pair = incoming;
        for (int i = 0; i <= (nums.length - win); i++) {
            if (pair.part1 == pair.part2) {
                return win;
            }
            if (nums[i] == 0) {
                pair = new Pair(pair.part1 - 1, pair.part2);
            } else {
                pair = new Pair(pair.part1, pair.part2 - 1);
            }

            if (i + win - 1 < nums.length - 1) {
                if (nums[i + win] == 0) {
                    pair = new Pair(pair.part1 + 1, pair.part2);
                } else {
                    pair = new Pair(pair.part1, pair.part2 + 1);
                }
            }
        }
        if (pair.part1 == pair.part2) return win;

        return 0;
    }

    private Pair getCounts(int[] nums, int start, int end) {
        int n0 = 0;
        int n1 = 0;

        for (int i = start; i <= end; i++) {
            if (nums[i] == 0) {
                n0++;
            } else {
                n1++;
            }
        }
        return new Pair(n0, n1);
    }

    static class Pair {
        final int part1;
        final int part2;

        Pair(int part1, int part2) {
            this.part1 = part1;
            this.part2 = part2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return part1 == pair.part1 &&
                    part2 == pair.part2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(part1, part2);
        }
    }


//    public int findMaxLength(int[] nums) {
//        Pair initial = getCounts(nums, 0, nums.length - 1);
//        return findMaxLength(nums, 0, nums.length - 1, nums.length, initial);
//    }
//
//    private int findMaxLength(int[] nums, int start, int end, int len, Pair incomingPair) {
//        Queue<State> states = new ArrayDeque<>();
//
//        State initial = new State(start, end, len, incomingPair);
//        states.add(initial);
//
//        Set<String> visited = new HashSet<>();
//        visited.add(keyFrom(initial));
//
//
//        while (!states.isEmpty()) {
//            State state = states.remove();
//            if (state.len < 2) return 0;
//
//            if (state.pair.part1 == state.pair.part2) {
//                return state.len;
//            }
//
//            if (state.len > 2) {
//                final State nextState1 = new State(state.start, state.end - 1, state.len - 1, nums[state.end] == 0 ? new Pair(state.pair.part1 - 1, state.pair.part2) : new Pair(state.pair.part1, state.pair.part2 - 1));
//                final State nextState2 = new State(state.start + 1, state.end, state.len - 1, nums[state.start] == 0 ? new Pair(state.pair.part1 - 1, state.pair.part2) : new Pair(state.pair.part1, state.pair.part2 - 1));
//                if (!visited.contains(keyFrom(nextState1))) {
//                    states.add(nextState1);
//                    visited.add(keyFrom(nextState1));
//                }
//                if (!visited.contains(nextState2))  {
//                    states.add(nextState2);
//                    visited.add(keyFrom(nextState2));
//                }
//            }
//        }
//        return 0;
//    }
//
//    private String keyFrom(State state) {
//        return state.start + ":" + state.end;
//    }


//    private Pair getCounts(int[] nums, int start, int end) {
//        int n0 = 0;
//        int n1 = 0;
//
//        for (int i = start; i <= end; i++) {
//            if (nums[i] == 0) {
//                n0++;
//            } else {
//                n1++;
//            }
//        }
//        return new Pair(n0, n1);
//    }


    static class State {
        final int start;
        final int end;
        final int len;
        final Pair pair;

        State(int start, int end, int len, Pair pair) {
            this.start = start;
            this.end = end;
            this.len = len;
            this.pair = pair;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            return start == state.start &&
                    end == state.end &&
                    len == state.len &&
                    Objects.equals(pair, state.pair);
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, len, pair);
        }
    }


    @Test
    void testOfSubArray() {
        assertThat(findMaxLength(new int[]{0, 1})).isEqualTo(2);
        assertThat(findMaxLength(new int[]{0, 1, 0})).isEqualTo(2);
        assertThat(findMaxLength(new int[]{0, 1, 1, 0})).isEqualTo(4);
        assertThat(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1})).isEqualTo(6);
        assertThat(findMaxLength(new int[]{0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1})).isEqualTo(68);
    }

}