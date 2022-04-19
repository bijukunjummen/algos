package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

public class TrapWater {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for (int current = 0; current < height.length; current++) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int dist = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                result += dist * bounded_height;
            }
            stack.push(current);
        }
        return result;
    }

    @Test
    void testTrap() {
        assertThat(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1})).isEqualTo(6);
        assertThat(trap(new int[]{4, 2, 0, 3, 2, 5})).isEqualTo(9);
    }
}
