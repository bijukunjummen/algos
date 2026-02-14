package org.bk.algo.general.bt;

import java.util.HashMap;
import java.util.Map;

class MaxProduct {
    public int maxProduct(TreeNode root) {
        Map<TreeNode, Long> nodeToSumUnder =  new HashMap<>();
        traverseAndComputeSum(root, nodeToSumUnder);

        long max = traverseDisconnectMax(root, nodeToSumUnder, nodeToSumUnder.get(root));

        return (int) (max % 1000000007);
    }

    private long traverseDisconnectMax(TreeNode node, Map<TreeNode, Long> nodeToSumUnder, Long rootSum) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        long max = Integer.MIN_VALUE;
        if (node.left != null) {
            long leftSum = nodeToSumUnder.get(node.left);
            long rootWithoutLeft = rootSum - leftSum;
            long product = leftSum * rootWithoutLeft;
            max = Math.max(max, product);
        }
        if (node.right != null) {
            long rightSum = nodeToSumUnder.get(node.right);
            long rootWithoutRight = rootSum - rightSum;
            long product = rightSum * rootWithoutRight;
            max = Math.max(max, product);
        }

        max = Math.max(max, traverseDisconnectMax(node.left, nodeToSumUnder, rootSum));
        max = Math.max(max, traverseDisconnectMax(node.right, nodeToSumUnder, rootSum));

        return max;


    }

    private Long traverseAndComputeSum(TreeNode node, Map<TreeNode, Long> nodeToSumUnder) {
        if (node == null) {
            return 0L;
        }
        long leftSum = traverseAndComputeSum(node.left, nodeToSumUnder);
        long rightSum = traverseAndComputeSum(node.right, nodeToSumUnder);

        long sum = node.val + leftSum + rightSum;
        nodeToSumUnder.put(node, sum);
        return sum;
    }

    void testMaxProduct() {

    }
}