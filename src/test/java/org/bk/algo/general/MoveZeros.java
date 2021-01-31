package org.bk.algo.general;

class MoveZeros {
    public void moveZeroes(int[] nums) {
        int swapCount = 0;
        for (int i = 0; i < nums.length;i++) {
            int n = nums[i];
            if (n == 0) {
                swapCount++;
            } else if (swapCount != 0){
                swapLeft(nums, i, swapCount);
            }
        }
    }
    
    private void swapLeft(int[] nums, int idx, int swapCount) {
        int p = idx - swapCount;
        int q = idx;
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}