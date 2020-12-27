package org.bk.algo.general;

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int uniques = 0;
        int moveAheadBy = 0;
        int i = 0;
        while (i < nums.length) {
            int n = nums[i];
            int j = i;
            while (j + 1 < nums.length && nums[j + 1] == n) {
                j++;
            }
            moveBy(nums, i, moveAheadBy);
            uniques += 1;
            moveAheadBy += (j - i);
            i = i + (j - i) + 1;
        }
        return uniques;
    }

    private void moveBy(int[] nums, int idx, int by) {
        if (by == 0) return;
        nums[idx - by] = nums[idx];
        nums[idx] = 0;
    }
}