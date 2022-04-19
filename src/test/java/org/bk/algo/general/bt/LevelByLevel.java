package org.bk.algo.general.bt;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class LevelByLevel {
    List<List<TreeNode>> traverseLevelByLevel(TreeNode node) {
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<NodeAndLevel> queue = new ArrayDeque<>();
        queue.add(new NodeAndLevel(node, 0));
        while (!queue.isEmpty()) {
            NodeAndLevel nodeAndLevel = queue.poll();
            TreeNode current = nodeAndLevel.node;
            int level = nodeAndLevel.level;
            if (result.size() < (level + 1)) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(current);
            if (current.left != null) {
                queue.add(new NodeAndLevel(current.left, level + 1));
            }
            if (current.right != null) {
                queue.add(new NodeAndLevel(current.right, level + 1));
            }
        }
        return result;
    }

    List<List<TreeNode>> traverseLevelByLevel2(TreeNode node) {
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<TreeNode> currentLevel = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    private static class NodeAndLevel {
        TreeNode node;
        int level;

        NodeAndLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    @Test
    void testTraverseLevelByLevel() {
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(21), new TreeNode(22)),
                new TreeNode(3, new TreeNode(31), null));

        List<List<TreeNode>> result = traverseLevelByLevel(root1);
        assertThat(result.get(0).size()).isEqualTo(1);
        assertThat(result.get(1).size()).isEqualTo(2);
        assertThat(result.get(2).size()).isEqualTo(3);
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void testTraverseLevelByLevel2() {
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(21), new TreeNode(22)),
                new TreeNode(3, new TreeNode(31), null));

        List<List<TreeNode>> result = traverseLevelByLevel2(root1);
        assertThat(result.get(0).size()).isEqualTo(1);
        assertThat(result.get(1).size()).isEqualTo(2);
        assertThat(result.get(2).size()).isEqualTo(3);
        assertThat(result.size()).isEqualTo(3);
    }
}