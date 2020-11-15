package org.bk.algo.general.bt;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        Holder result = maxPathMult(root);
        return result.max;
    }

    private Holder maxPathMult(TreeNode node) {
        if (node == null) {
            return null;
        }

        Holder left = maxPathMult(node.left);
        Holder right = maxPathMult(node.right);


        int minOpen = max(left != null ? left.open : Integer.MIN_VALUE, right != null ? right.open : Integer.MIN_VALUE);
        int open = max(((minOpen == Integer.MIN_VALUE) ? 0 : minOpen) + node.val, node.val);

        int closed = max(
                open,
                left != null ? left.max : Integer.MIN_VALUE,
                right != null ? right.max : Integer.MIN_VALUE,
                ((left != null ? left.open : 0) + (right != null ? right.open : 0) + node.val)
        );

        return new Holder(open, closed);
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


    static class Holder {
        final int open;
        final int max;

        Holder(int open, int max) {
            this.open = open;
            this.max = max;
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
}