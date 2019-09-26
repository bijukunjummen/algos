package org.bk.algo.core;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class CheckBSTTest {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer leftLimit, Integer rightLimit) {
        if (node == null) {
            return true;
        }

        if (
                ((leftLimit != null && node.val > leftLimit) || leftLimit == null) &&
                        ((rightLimit != null && node.val < rightLimit) || rightLimit == null)
        ) {
            return isValidBST(node.left, leftLimit, node.val) && isValidBST(node.right, node.val, rightLimit);
        }

        return false;
    }
}
