package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;

class IsValidSubsequence {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequence(root, 0, arr);
    }

    public boolean isValidSequence(TreeNode node, int currIndex, int[] arr) {
        if (node == null) {
            return false;
        }

        if (currIndex == arr.length - 1) {
            if (node.val == arr[currIndex] && isLeaf(node)) {
                return true;
            }
            return false;
        }

        if (node.val == arr[currIndex]) {
            return isValidSequence(node.left, currIndex + 1, arr) || isValidSequence(node.right, currIndex + 1, arr);
        }
        return false;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    @Test
    void test1() {
        TreeNode tree = new TreeNode(0,
                new TreeNode(1,
                        new TreeNode(0,
                                null,
                                new TreeNode(1)),
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(0))),
                new TreeNode(0,
                        new TreeNode(0),
                        null));

        assertThat(isValidSequence(tree, new int[]{0, 1, 0, 1})).isTrue();
    }

    @Test
    void test2() {
        TreeNode tree = new TreeNode(0,
                new TreeNode(1,
                        new TreeNode(0,
                                null,
                                new TreeNode(1)),
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(0))),
                new TreeNode(0,
                        new TreeNode(0),
                        null));

        assertThat(isValidSequence(tree, new int[]{0, 1, 1})).isFalse();
    }

    @Test
    void test3() {
        TreeNode tree = new TreeNode(8,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(5), new TreeNode(4)),
                        new TreeNode(1)),
                null);
        assertThat(isValidSequence(tree, new int[]{8})).isFalse();
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

        @Override
        public String toString() {
            return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("left=" + left)
                    .add("right=" + right)
                    .toString();
        }
    }
}