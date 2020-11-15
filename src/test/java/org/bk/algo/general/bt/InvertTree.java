package org.bk.algo.general.bt;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = right;
        return root;
    }

    @Test
    void testInvert() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2),
                new TreeNode(7));

        TreeNode result = invertTree(root);

        assertThat(result.left.val).isEqualTo(7);
        assertThat(result.right.val).isEqualTo(2);
    }
}