package org.bk.algo.general.bt;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class SubtreeDeepest {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<Integer, List<TreeNode>> levelByLevelMap = traverseLevelByLevel(root);
        int levels = levelByLevelMap.size();
        if (levels > 0) {
            List<TreeNode> lowestLevel = levelByLevelMap.get(levels - 1);
            if (lowestLevel.size() == 1) {
                return lowestLevel.get(0);
            } else {
                return findLowestParent(root, lowestLevel.stream().collect(Collectors.toSet()));
            }
        }
        return root;
    }
    
    private TreeNode findLowestParent(TreeNode node, Set<TreeNode> lowestNodes) {
        if (node == null || lowestNodes.contains(node)) {
            return node;
        }
        TreeNode l = findLowestParent(node.left, lowestNodes);
        TreeNode r = findLowestParent(node.right, lowestNodes);
        if (l != null && r != null) {
            return node;
        } else if (l != null) {
            return l;
        } else if (r != null) {
            return r;
        }
        return null;
//        Map<TreeNode, Set<TreeNode>> descendants = createDescendants(node);
//        return traverse(node, descendants, lowestNodes);
    }
    
//    private Map<TreeNode, Set<TreeNode>> createDescendants(TreeNode node) {
//        Map<TreeNode, Set<TreeNode>> result = new HashMap<>();
//        createDescendants(node, result);
//        return result;
//    }
//
//    private void createDescendants(TreeNode node, Map<TreeNode, Set<TreeNode>> result) {
//        if (node == null) {
//            return;
//        }
//        Set<TreeNode> descendants = new HashSet<>();
//        if (node.left != null) {
//            descendants.add(node.left);
//            createDescendants(node.left, result);
//            if (result.containsKey(node.left)) {
//                descendants.addAll(result.get(node.left));
//            }
//        }
//
//        if (node.right != null) {
//            descendants.add(node.right);
//            createDescendants(node.right, result);
//            if (result.containsKey(node.right)) {
//                descendants.addAll(result.get(node.right));
//            }
//        }
//        result.put(node, descendants);
//    }
    
//    private TreeNode traverse(TreeNode node, Map<TreeNode, Set<TreeNode>> descendants, List<TreeNode> lowestNodes) {
//        if (node == null) {
//            return null;
//        }
//
//        if (descendants.containsKey(node) && descendants.get(node).containsAll(lowestNodes)) {
//            TreeNode left = traverse(node.left, descendants, lowestNodes);
//            if (left != null) {
//                return left;
//            }
//            TreeNode right = traverse(node.right, descendants, lowestNodes);
//            if (right != null) {
//                return right;
//            }
//            return node;
//        } else {
//            return null;
//        }
//    }
    
    private Map<Integer, List<TreeNode>> traverseLevelByLevel(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        Map<Integer, List<TreeNode>> result = new HashMap<>();
        int level = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            currentLevelNodes.addAll(queue);
            result.put(level, currentLevelNodes);
            level++;
            queue.clear();
            
            for (TreeNode n: currentLevelNodes) {
                if (n.left  != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            
        }
        return result;
    }
}