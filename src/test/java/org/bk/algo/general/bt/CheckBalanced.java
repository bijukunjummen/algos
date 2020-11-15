package org.bk.algo.general.bt;

public class CheckBalanced {

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
}
