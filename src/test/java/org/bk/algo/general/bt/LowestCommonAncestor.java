package org.bk.algo.general.bt;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if ((left != null || right != null) && (root == p || root == q)) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }

        if (left != null) return left;
        if (right != null) return right;

        return null;
    }

    @Test
    void testLCA() {
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                        new TreeNode(7),
                        four));
        TreeNode tree = new TreeNode(3, five,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8))
        );

        assertThat(lowestCommonAncestor(tree, five, four)).isEqualTo(five);
    }
}
