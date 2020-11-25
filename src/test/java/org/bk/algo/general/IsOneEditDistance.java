package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IsOneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        if (s.equals(t)) {
            return false;
        }

        Action action = null;

        if (arr1.length == arr2.length) {
            action = Action.REPLACE;
        } else if (Math.abs(arr1.length - arr2.length) == 1) {
            if (arr1.length < arr2.length) {
                action = Action.INSERT;
            } else {
                action = Action.DELETE;
            }
        } else {
            return false;
        }

        int diff = 0;
        int a1 = 0;
        int a2 = 0;

        while (a1 < arr1.length && a2 < arr2.length) {
            if (arr1[a1] == arr2[a2]) {
                a1++;
                a2++;
            } else if (arr1[a1] != arr2[a2]) {
                diff++;

                if (action == Action.REPLACE) {
                    a1++;
                    a2++;
                } else if (action == Action.DELETE) {
                    a1++;
                } else if (action == Action.INSERT) {
                    a2++;
                }
            }
            if (diff > 1) {
                return false;
            }
        }
        if (a1 != arr1.length && a2 != arr2.length) {
            return false;
        }

        if (diff == 1) {
            return true;
        } else {
            return false;
        }
    }


    enum Action {
        INSERT, DELETE, REPLACE
    }

    @Test
    void testOneEdit() {
//        assertThat(isOneEditDistance("ab", "acb")).isTrue();
        assertThat(isOneEditDistance("abc", "ab")).isTrue();
//        assertThat(isOneEditDistance("a", "")).isTrue();
//        assertThat(isOneEditDistance("a", "")).isTrue();
    }
}