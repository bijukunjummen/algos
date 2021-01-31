package org.bk.algo.general.bt;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Codec {

    // Encodes a tree to a single string.
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serialize(root, list);
        return String.join(",", list);
    }

    private void serialize(TreeNode node, List<String> result) {
        if (node == null) {
            result.add("null");
            return;
        }

        result.add(String.valueOf(node.val));
        serialize(node.left, result);
        serialize(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        Queue<String> tokensQueue = new LinkedList<>(Arrays.stream(tokens).collect(Collectors.toList()));
        TreeNode root = deserialize(tokensQueue);
        return root;
    }

    private TreeNode deserialize(Queue<String> queue) {
        String token = queue.poll();
        if (token.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(token));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }

    @Test
    void testSerialize1() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));
        String serialized = serialize(treeNode);
        System.out.println(serialized);
        TreeNode result = deserialize(serialized);
        assertThat(result).isEqualTo(treeNode);
    }

    @Test
    void testSerialize2() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(14), new TreeNode(24)), new TreeNode(5, new TreeNode(6), new TreeNode(7))));
        String serialized = serialize(treeNode);
        System.out.println(serialized);
        TreeNode result = deserialize(serialized);
        assertThat(result).isEqualTo(treeNode);
    }


}