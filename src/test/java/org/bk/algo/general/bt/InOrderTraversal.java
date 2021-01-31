package org.bk.algo.general.bt;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InOrderTraversal {
    public List<Integer> inOrderTraversalIterative(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, result);
        result.add(node.val);
        inOrderTraversal(node.right, result);
    }

    @Test
    void testInOrderTraversal() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7)));
        assertThat(inOrderTraversalIterative(root)).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7));
        assertThat(inOrderTraversal(root)).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7));
    }
}
