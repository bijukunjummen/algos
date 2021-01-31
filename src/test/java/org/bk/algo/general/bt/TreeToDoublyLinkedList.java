package org.bk.algo.general.bt;

import java.util.ArrayList;
import java.util.List;

class TreeToDoublyLinkedList {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        NodeReference first = new NodeReference(null);
        NodeReference last = new NodeReference(null);
        inOrderTraverse(root, first, last);
        first.node.left = last.node;
        last.node.right = first.node;
        return first.node;
    }

    private void inOrderTraverse(TreeNode node, NodeReference first, NodeReference last) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.left, first, last);
        if (last.node == null) {
            first.node = node;
        } else {
            last.node.right = node;
            node.left = last.node;
        }
        last.node = node;
        inOrderTraverse(node.right, first, last);
    }

    static class NodeReference {
        TreeNode node;

        NodeReference(TreeNode node) {
            this.node = node;
        }
    }

    public TreeNode treeToDoublyListIter(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> flattened = new ArrayList<>();
        flattenInOrder(root, flattened);

        TreeNode head = flattened.get(0);
        TreeNode current = head;
        for (int i = 1; i < flattened.size(); i++) {
            TreeNode node = flattened.get(i);
            current.right = node;
            node.left = current;
            current = node;
        }
        head.left = current;
        current.right = head;
        return head;
    }

    private void flattenInOrder(TreeNode node, List<TreeNode> flattened) {
        if (node == null) {
            return;
        }

        flattenInOrder(node.left, flattened);
        flattened.add(node);
        flattenInOrder(node.right, flattened);
    }
}