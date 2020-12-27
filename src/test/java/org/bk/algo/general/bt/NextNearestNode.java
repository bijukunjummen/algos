package org.bk.algo.general.bt;


import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class NextNearestNode {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<NodeAndLevel> queue = new ArrayDeque<>();
        queue.add(new NodeAndLevel(root, 0));
        boolean isNext = false;
        int nextLevel = -1;
        while (!queue.isEmpty()) {
            NodeAndLevel nodeAndLevel = queue.poll();
            TreeNode node = nodeAndLevel.node;
            if (isNext) {
                if (nodeAndLevel.level == nextLevel) {
                    return nodeAndLevel.node;
                } else {
                    return null;
                }
            }
            if (nodeAndLevel.node == u) {
                isNext = true;
                nextLevel = nodeAndLevel.level;
            }
            if (node.left != null) queue.add(new NodeAndLevel(node.left, nodeAndLevel.level + 1));
            if (node.right != null) queue.add(new NodeAndLevel(node.right, nodeAndLevel.level + 1));
        }
        return null;
    }

    static class NodeAndLevel {
        TreeNode node;
        int level;

        NodeAndLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    @Test
    void testNearestRightNode() {
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        null,
                        four),
                new TreeNode(3,
                        five,
                        new TreeNode(6)));

        assertThat(findNearestRightNode(root, four)).isEqualTo(five);
    }
}