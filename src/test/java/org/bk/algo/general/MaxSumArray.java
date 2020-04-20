package org.bk.algo.general;

/**
 * Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with
 * -A[i], and we repeat this process K times in total.  (We may choose the same index i multiple times.)
 *
 * Return the largest possible sum of the array after modifying it in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [4,2,3], K = 1
 * Output: 5
 * Explanation: Choose indices (1,) and A becomes [4,-2,3].
 * Example 2:
 *
 * Input: A = [3,-1,0,2], K = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].
 * Example 3:
 *
 * Input: A = [2,-3,-1,5,-4], K = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
 */
public class MaxSumArray {
    public int largestSumAfterKNegations(int[] A, int K) {
        for (int i = 0; i < K; i++) {
            negateLowest(A);
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return sum;
    }

    private void negateLowest(int[] A) {
        int lowest = Integer.MAX_VALUE;
        int lowestIdx = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < lowest) {
                lowest = A[i];
                lowestIdx = i;
            }
        }

        A[lowestIdx] = -A[lowestIdx];
    }
}
