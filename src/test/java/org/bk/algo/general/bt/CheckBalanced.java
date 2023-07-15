package org.bk.algo.general.bt;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckBalanced {
    record TreeInfo(int height, boolean balanced) {
    }

    boolean isBalanced(TreeNode treeNode) {
        if (treeNode == null) return true;
        int diff = getHeight(treeNode.left) - getHeight(treeNode.right);
        if (Math.abs(diff) > 1) {
            return false;
        } else {
            return isBalanced(treeNode.left) && isBalanced(treeNode.right);
        }
    }

    int getHeight(TreeNode node) {
        if (node == null) return -1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    boolean isBalanced2(TreeNode treeNode) {
        return isBalancedHelper(treeNode).balanced;
    }

    private TreeInfo isBalancedHelper(TreeNode root) {
        if (root == null) return new TreeInfo(-1, true);

        TreeInfo left = isBalancedHelper(root.left);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }

        TreeInfo right = isBalancedHelper(root.right);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }

        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }

    @Test
    void testIsBalanced() {
        TreeNode tree1 = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4));

        assertThat(isBalanced(tree1)).isTrue();
        TreeNode tree2 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        assertThat(isBalanced(tree2)).isTrue();

        TreeNode tree3 = new TreeNode(10,
                new TreeNode(20,
                        new TreeNode(30, new TreeNode(40), new TreeNode(41)),
                        new TreeNode(31)),
                new TreeNode(21));
        assertThat(isBalanced(tree3)).isFalse();
    }

    @Test
    void testIsBalanced2() {
        TreeNode tree1 = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4));

        assertThat(isBalanced2(tree1)).isTrue();
        TreeNode tree2 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));

        assertThat(isBalanced2(tree2)).isTrue();

        TreeNode tree3 = new TreeNode(10,
                new TreeNode(20,
                        new TreeNode(30, new TreeNode(40), new TreeNode(41)),
                        new TreeNode(31)),
                new TreeNode(21));
        assertThat(isBalanced2(tree3)).isFalse();
    }
}
