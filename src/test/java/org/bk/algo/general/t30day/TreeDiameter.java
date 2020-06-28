package org.bk.algo.general.t30day;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeDiameter {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return diameterOfBinaryTreeComparing(root);
    }

    public int diameterOfBinaryTreeComparing(TreeNode node) {
        if (node == null) return 0;
        int atRoot = diameterOfBinaryTreeAt(node);
        int inLeft = node.left != null ? diameterOfBinaryTree(node.left) : 0;
        int inRight = node.right != null ? diameterOfBinaryTree(node.right) : 0;
        return Math.max(atRoot, Math.max(inLeft, inRight));
    }


    public int diameterOfBinaryTreeAt(TreeNode node) {
        if (node == null) return 0;
        return (node.left != null ? (height(node.left) + 1) : 0) + (node.right != null ? (height(node.right) + 1) : 0);
    }

    private int height(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        int l = height(node.left);
        int r = height(node.right);

        return Math.max(l, r) + 1;
    }


    @Test
    void testFarthest1() {
        TreeNode root =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)),
                        new TreeNode(3));

        assertThat(diameterOfBinaryTree(root)).isEqualTo(3);
    }

    @Test
    void testFarthest2() {
        TreeNode root =
                new TreeNode(4,
                        new TreeNode(-7),
                        new TreeNode(-3,
                                new TreeNode(-9,
                                        new TreeNode(9,
                                                new TreeNode(6,
                                                        new TreeNode(0,
                                                                null,
                                                                new TreeNode(-1)),
                                                        new TreeNode(6,
                                                                new TreeNode(-4),
                                                                null)),
                                                null),
                                        new TreeNode(-7,
                                                new TreeNode(-6,
                                                        new TreeNode(5),
                                                        null),
                                                new TreeNode(-6,
                                                        new TreeNode(9,
                                                                new TreeNode(-2), null),
                                                        null))),
                                new TreeNode(-3,
                                        new TreeNode(-4),
                                        null)));
        assertThat(diameterOfBinaryTree(root)).isEqualTo(8);
    }

    @Test
    void testHeight() {
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertThat(height(root1)).isEqualTo(1);

        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        assertThat(height(root2)).isEqualTo(1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this(x, null, null);
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
            this.val = x;
        }
    }
}