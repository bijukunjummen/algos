package org.bk.algo.general.bt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, new ArrayList<>(), result);
        return result;
    }

    private void binaryTreePaths(TreeNode node, List<String> history, List<String> result) {
        if (node == null) {
            return;
        }
        List<String> newHistory = new ArrayList<>(history);
        newHistory.add(String.valueOf(node.val));

        if (node.left == null && node.right == null) {
            result.add(String.join("->", newHistory));
            return;
        }

        binaryTreePaths(node.left, newHistory, result);
        binaryTreePaths(node.right, newHistory, result);
    }

    @Test
    void testPaths() {
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4));

        assertThat(binaryTreePaths(root)).containsExactlyInAnyOrder("3->1->2", "3->4");

    }
}