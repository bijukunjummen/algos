package org.bk.algo.general.gcd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> finalList = new ArrayList<>();
        finalList.add(root);
        
        for (int i = 0; i < to_delete.length;i++) {
            int toDelete = to_delete[i];
            
            finalList = finalList.stream()
                            .flatMap(rootTreeNode -> delNodes(null, rootTreeNode, toDelete).stream())
                            .collect(Collectors.toList());
        }
        
        return finalList;
        

    }
    
    private List<TreeNode> delNodes(TreeNode parent, TreeNode node, int toDelete) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.val == toDelete) {
            if (parent != null) {
                if (parent.left != null && parent.left.val == toDelete) {
                    parent.left = null;
                }
                if (parent.right != null && parent.right.val == toDelete) {
                    parent.right = null;
                }
            }
            List<TreeNode> toReturn = new ArrayList<>();
            if (node.left != null) {
                toReturn.add(node.left);
            }
            if (node.right != null) {
                toReturn.add(node.right);
            }
            if (parent != null) {
                toReturn.add(parent);
            }
            return toReturn;                                
        }
        List<TreeNode> treeNodesLeft = delNodes(node, node.left, toDelete);
        List<TreeNode> treeNodesRight = delNodes(node, node.right, toDelete);
        
        List<TreeNode> result = new ArrayList<>();
        result.addAll(treeNodesLeft);
        result.addAll(treeNodesRight);
        
        return result;

    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;


    }
}