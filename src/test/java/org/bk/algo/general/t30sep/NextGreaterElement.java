package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num2AndIndex = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int n2 = nums2[i];
            num2AndIndex.put(n2, i);
        }
        int[] res = new int[nums1.length];
        int resIndex = 0;
        // Set<Integer> covered = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            int n2Index = num2AndIndex.get(n1);
            int nextGreater = scanForNextGreater(n1, n2Index, nums2);
            res[resIndex++] = nextGreater;
        }

        return res;
    }

    private int scanForNextGreater(int n, int fromIndex, int[] nums) {
        for (int i = fromIndex + 1; i < nums.length; i++) {
            if (nums[i] > n) {
                return nums[i];
            }
        }
        return -1;
    }

    @Test
    void testNextGreater() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println(nextGreaterElement(nums1, nums2));
    }
}