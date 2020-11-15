package org.bk.algo.general.bt;

import java.util.StringJoiner;

class TreeNode {
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