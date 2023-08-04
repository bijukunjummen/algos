package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            int a = asteroids[i];
            boolean movingRight = (a > 0) ? true : false;
            if (!movingRight) {
                int current = a;
                while (current < 0 && !stack.isEmpty()) {
                    int n = stack.pop();
                    if (n > Math.abs(current)) {
                        current = n;
                        stack.push(current);
                    } else if (n < Math.abs(current)) {
                        //
                    } else {
                        current = n;
                    }
                }
            } else {
                stack.push(a);
            }
        }
        int size = stack.size();
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            res[size - i - 1] = stack.pop();
        }
        return res;
    }

    @Test
    void testCollision() {
        assertThat(asteroidCollision(new int[]{5, 10, -5})).isEqualTo(new int[]{5, 10});
        assertThat(asteroidCollision(new int[]{10, 2, -5})).isEqualTo(new int[]{10});
    }
}