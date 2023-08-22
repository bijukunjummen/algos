package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumAverageSubtree {
    public double maximumAverageSubtree(TreeNode root) {
        Map<TreeNode, SumAndCount> map = new HashMap<>();
        SumAndCount rootSumAndCount = dfs(root, map);
        return rootSumAndCount.maxAverage;
    }

    @Test
    void testMaxAvg() {
        TreeNode root = new TreeNode(5, new TreeNode(6, null, null), new TreeNode(1, null, null));

        assertThat(maximumAverageSubtree(root)).isEqualTo(6d);
    }

    private SumAndCount dfs(TreeNode node, Map<TreeNode, SumAndCount> map) {
        if (node == null) {
            return new SumAndCount(0, 0, Double.MIN_VALUE);
        }
        SumAndCount left = dfs(node.left, map);
        SumAndCount right = dfs(node.right, map);
        int sum = left.sum + right.sum + node.val;
        int count = left.count + right.count + 1;
        double currentAverage = count > 0 ? (sum * 1.0d) / count : Double.MIN_VALUE;
        double maxAverage = Math.max(left.maxAverage, Math.max(right.maxAverage, currentAverage));
        SumAndCount sumAndCount = new SumAndCount(sum, count, maxAverage);
        return sumAndCount;
    }

    static class SumAndCount {
        int sum;
        int count;
        double maxAverage;

        public SumAndCount(int sum, int count, double maxAverage) {
            this.sum = sum;
            this.count = count;
            this.maxAverage = maxAverage;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}