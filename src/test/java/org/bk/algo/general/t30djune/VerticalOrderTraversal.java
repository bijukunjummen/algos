package org.bk.algo.general.t30djune;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> sortedMap = new TreeMap<>();
        traverseBfsAndBuild(sortedMap, root);

        return sortedMap.values().stream().collect(Collectors.toList());

    }

    private void traverseBfsAndBuild(TreeMap<Integer, List<Integer>> sortedMap, TreeNode root) {
        if (root == null) return;

        Queue<NodeAndPosition> queue = new ArrayDeque<>();
        queue.add(new NodeAndPosition(root, 0));

        while (!queue.isEmpty()) {
            NodeAndPosition current = queue.poll();
            TreeNode node = current.node;
            int position = current.position;
            sortedMap.computeIfAbsent(position, (p) -> new ArrayList<>());
            sortedMap.get(position).add(node.val);

            if (node.left != null) queue.add(new NodeAndPosition(node.left, position - 1));
            if (node.right != null) queue.add(new NodeAndPosition(node.right, position + 1));
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static class NodeAndPosition {
        TreeNode node;
        int position;

        NodeAndPosition(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }
}