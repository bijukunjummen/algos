package org.bk.algo.general.bt;

class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        Pair pair = diam(root);
        return pair.closed;
    }

    private Pair diam(TreeNode node) {
        if (node == null) {
            return new Pair(0, 0);
        }

        Pair left = diam(node.left);
        Pair right = diam(node.right);

        int closed = max(left.closed, right.closed, left.open + right.open);
        int open = max(left.open, right.open) + 1;
        return new Pair(closed, open);
    }

    private int max(int... nums) {
        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    record Pair(int closed, int open){}
}