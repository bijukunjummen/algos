package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class OddEvenJumps {
    public int oddEvenJumps(int[] arr) {
        //maps value to index
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int n = arr.length;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        treeMap.put(arr[n - 1], n - 1);
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> hi = treeMap.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> lo = treeMap.floorEntry(arr[i]);
            if (hi != null) {
                higher[i] = lower[hi.getValue().intValue()];
            }
            if (lo != null) {
                lower[i] = higher[lo.getValue().intValue()];
            }
            if (higher[i]) res++;
            treeMap.put(arr[i], i);
        }
        return res;
    }

//    public int oddEvenJumps(int[] arr) {
//        int validJumps = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (checkGoodJump(i, arr)) {
//                validJumps++;
//            }
//        }
//        return validJumps;
//    }

//    private boolean checkGoodJump(int startIndex, int[] arr) {
//        if (startIndex == arr.length - 1) {
//            return true;
//        }
//        boolean isOdd = true;
//        int nextJumpIndex = nextJump(startIndex, isOdd, arr);
//        while (nextJumpIndex != -1) {
//            if (nextJumpIndex == arr.length - 1) {
//                return true;
//            }
//            isOdd = !isOdd;
//            nextJumpIndex = nextJump(nextJumpIndex, isOdd, arr);
//        }
//        return false;
//    }
//
//    private int nextJump(int startIndex, boolean isOdd, int[] arr) {
//        if (isOdd) {
//            return smallestOfLarger(startIndex, arr);
//        } else {
//            return largestOfSmaller(startIndex, arr);
//        }
//    }
//
//    private int largestOfSmaller(int startIndex, int[] arr) {
//        int largerOfSmaller = Integer.MIN_VALUE;
//        int maxIndex = -1;
//
//        for (int i = startIndex + 1; i < arr.length; i++) {
//            if (arr[i] <= arr[startIndex] && arr[i] > largerOfSmaller) {
//                largerOfSmaller = arr[i];
//                maxIndex = i;
//            }
//        }
//        return maxIndex;
//    }
//
//    private int smallestOfLarger(int startIndex, int[] arr) {
//        int smallerOfLarger = Integer.MAX_VALUE;
//        int minIndex = -1;
//
//        for (int i = startIndex + 1; i < arr.length; i++) {
//            if (arr[i] >= arr[startIndex] && arr[i] < smallerOfLarger) {
//                smallerOfLarger = arr[i];
//                minIndex = i;
//            }
//        }
//        return minIndex;
//    }

    @Test
    void test1() {
        assertThat(oddEvenJumps(new int[]{10, 13, 12, 14, 15})).isEqualTo(2);
        assertThat(oddEvenJumps(new int[]{2, 3, 1, 1, 4})).isEqualTo(3);
        assertThat(oddEvenJumps(new int[]{5, 1, 3, 4, 2})).isEqualTo(3);
    }
}
