package org.bk.algo.general.bt;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        AtomicInteger current = new AtomicInteger(0);
        TreeNode root = deserialize(tokens, current);
        return root;
    }

    private TreeNode deserialize(String[] tokens, AtomicInteger current) {
        String token = tokens[current.getAndIncrement()];
        if (token.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(token));
        node.left = deserialize(tokens, current);
        node.right = deserialize(tokens, current);
        return node;
    }

    @Test
    void testSerialize1() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        System.out.println(serialize(treeNode));
        TreeNode result = deserialize(serialize(treeNode));
        System.out.println(result);
    }

    @Test
    void testSerialize2() {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4, new TreeNode(14), new TreeNode(24)), new TreeNode(5, new TreeNode(6), new TreeNode(7))));
        System.out.println(serialize(treeNode));
        TreeNode result = deserialize(serialize(treeNode));
        System.out.println(result);
    }
}