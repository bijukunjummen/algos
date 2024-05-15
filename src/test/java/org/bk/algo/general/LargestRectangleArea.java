package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

class LargestRectangleArea {

    //Not optimal. It has a runtime of N^3
    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                }
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> indexStack = new ArrayDeque<>();
        indexStack.push(-1);
        int maxArea = 0;
        int length = heights.length;
        for (int i = 0; i < heights.length; i++) {
            while ((indexStack.peek() != -1) && (heights[indexStack.peek()] >= heights[i])) {
                int stackIndex = indexStack.pop();
                int currHeight = heights[stackIndex];
                int currWidth = i - indexStack.peek() - 1;
                System.out.println("target index = " + i + ", right = " + stackIndex + ", left = " + indexStack.peek());
                maxArea = Math.max(maxArea, currWidth * currHeight);
            }
            indexStack.push(i);
        }

        while (indexStack.peek() != -1) {
            int stackIndex = indexStack.pop();
            int currHeight = heights[stackIndex];
            int currWidth = length - indexStack.peek() - 1;
            System.out.println("outside for: target index = " + (length - 1) + ", right = " + stackIndex + ", left = " + indexStack.peek());
            maxArea = Math.max(maxArea, currWidth * currHeight);
        }
        return maxArea;
    }


    @Test
    void testLargestNonOptimal() {
        assertThat(largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3})).isEqualTo(10);
    }

    @Test
    void testLargestOptimal() {
        assertThat(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})).isEqualTo(10);
    }

}