package org.bk.algo.graph;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class BinaryTreeToForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (Integer n: to_delete) {
            toDeleteSet.add(n);
        }
        
        List<TreeNode> currentList = new ArrayList<>();
        currentList.add(root);
        delNodes(currentList, null, root, toDeleteSet);
        return currentList;
    }
    
    private void delNodes(List<TreeNode> list, TreeNode parent, TreeNode node, Set<Integer> toDelete) {
        if (node == null) {
            return;
        }
        
        delNodes(list, node, node.left, toDelete);
        delNodes(list, node, node.right, toDelete);
        
        if (toDelete.contains(node.val)) {
            if (parent != null) {
                if (parent.left != null && parent.left == node) {
                    parent.left = null;
                } else if (parent.right != null && parent.right == node) {
                    parent.right = null;
                }
            } 
            if (list.contains(node)) {
                list.remove(node);
            }
            if (node.left != null) list.add(node.left);
            if (node.right != null) list.add(node.right);
        }
    }
}