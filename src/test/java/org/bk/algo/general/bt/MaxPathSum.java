package org.bk.algo.general.bt;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        Holder holder = maxPath(root);
        return Math.max(holder.open, holder.closed);
    }

    private Holder maxPath(TreeNode node) {
        if (node == null) {
            return null;
        }

        Holder left = maxPath(node.left);
        Holder right = maxPath(node.right);

        int newOpen = max(max(left != null ? left.open : 0, right != null ? right.open : 0) + node.val, node.val);
        int newClosed = max(newOpen,
                ((left != null) ? left.closed : Integer.MIN_VALUE),
                ((right != null) ? right.closed : Integer.MIN_VALUE),
                ((left != null) ? left.open : 0) + ((right != null) ? right.open : 0) + +node.val);

        return new Holder(newOpen, newClosed);
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

    private static class Holder {
        int open;
        int closed;

        Holder(int open, int closed) {
            this.open = open;
            this.closed = closed;
        }
    }

    @Test
    void testMaxPathSum() {
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        assertThat(maxPathSum(root1)).isEqualTo(6);

        TreeNode root2 = new TreeNode(-3);

        assertThat(maxPathSum(root2)).isEqualTo(-3);

        TreeNode root3 = new TreeNode(2,
                new TreeNode(-1),
                null);

        assertThat(maxPathSum(root3)).isEqualTo(2);

        TreeNode root4 = new TreeNode(-2,
                new TreeNode(6,
                        new TreeNode(0),
                        new TreeNode(-6)),
                null);

        assertThat(maxPathSum(root4)).isEqualTo(6);

        TreeNode root5 = new TreeNode(-1,
                null,
                new TreeNode(9,
                        new TreeNode(-6),
                        new TreeNode(3, null, new TreeNode(-2))));

        assertThat(maxPathSum(root5)).isEqualTo(12);

    }


    @Test
    void testShift() {
        int i = 1 << 2;
        System.out.println(i);
    }
}