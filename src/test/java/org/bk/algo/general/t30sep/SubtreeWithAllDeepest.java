package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SubtreeWithAllDeepest {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<Integer, Set<TreeNode>> levelOrderedMap = new HashMap<>();


        levelOrder(root, 0, levelOrderedMap);

        Set<TreeNode> maxLevelNodes = levelOrderedMap.get(levelOrderedMap.size() - 1);
        return subtree(root, maxLevelNodes);
    }

    private void levelOrder(TreeNode node, int level, Map<Integer, Set<TreeNode>> levelOrderedMap) {
        if (node == null) {
            return;
        }
        levelOrderedMap.computeIfAbsent(level, (l) -> new HashSet<>());

        levelOrderedMap.get(level).add(node);

        levelOrder(node.left, level + 1, levelOrderedMap);
        levelOrder(node.right, level + 1, levelOrderedMap);
    }

    private TreeNode subtree(TreeNode node, Set<TreeNode> containing) {
        if (node == null) {
            return null;
        }
        TreeNode left = subtree(node.left, containing);
        if (left != null) {
            return left;
        }
        TreeNode right = subtree(node.right, containing);
        if (right != null) {
            return right;
        }
        if (containsAll(node, containing, new HashSet<>())) {
            return node;
        }
        return null;

    }

    private boolean containsAll(TreeNode node, Set<TreeNode> containing, Set<TreeNode> visited) {
        if (node == null) {
            return false;
        }
        visited.add(node);
        boolean inLeft = containsAll(node.left, containing, visited);
        boolean inRight = containsAll(node.right, containing, visited);

        if (inLeft || inRight) {
            return true;
        }
        return (subSet(containing, visited));
    }

    private boolean subSet(Set<TreeNode> sub, Set<TreeNode> sup) {
        for (TreeNode elem : sub) {
            if (!sup.contains(elem)) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testDeepest() {
        TreeNode root = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)));

        TreeNode result = subtreeWithAllDeepest(root);
        System.out.println(result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}