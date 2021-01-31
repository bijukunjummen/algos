package org.bk.algo.general.bt;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LevelByLevel {
    List<List<TreeNode>> traverseLevelByLevel(TreeNode node) {
        List<List<TreeNode>> result = new ArrayList<>();
        Deque<NodeAndLevel> queue = new ArrayDeque<>();
        queue.add(new NodeAndLevel(node, 0));
        Map<Integer, List<TreeNode>> levelToNodes = new HashMap<>();
        while (!queue.isEmpty()) {
            NodeAndLevel nodeAndLevel = queue.pop();
            TreeNode current = nodeAndLevel.node;
            int level = nodeAndLevel.level;
            levelToNodes.computeIfAbsent(level, k -> new ArrayList<>());
            levelToNodes.get(level).add(current);
            if (current.left != null) {
                queue.add(new NodeAndLevel(current.left, level + 1));
            }
            if (current.right != null) {
                queue.add(new NodeAndLevel(node.right, level + 1));
            }
        }
        for (int i = 0; i < levelToNodes.size(); i++) {
            List<TreeNode> forLevel =  levelToNodes.get(i);
            result.add(forLevel);
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
    void testMaxPathSum() {
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        List<List<TreeNode>> result = traverseLevelByLevel(root1);
        System.out.println(result);

        TreeNode root2 = new TreeNode(-3);


        TreeNode root3 = new TreeNode(2,
                new TreeNode(-1),
                null);

        TreeNode root4 = new TreeNode(-2,
                new TreeNode(6,
                        new TreeNode(0),
                        new TreeNode(-6)),
                null);

        TreeNode root5 = new TreeNode(-1,
                null,
                new TreeNode(9,
                        new TreeNode(-6),
                        new TreeNode(3, null, new TreeNode(-2))));

    }
}