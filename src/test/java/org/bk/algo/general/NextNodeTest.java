package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class NextNodeTest {

    /**
     * <pre>
     *            5
     *    2                8
     * 1     3        6         9
     *          4        7         10
     * </pre>
     */
    @Test
    public void testGetNextNode() {
        Node root = createBst(IntStream.range(1, 11).toArray(), 0, 9);
        navigateNode(root, "");

        assertThat(nextNode(root, 5).key).isEqualTo(6);
        assertThat(nextNode(root, 7).key).isEqualTo(8);
    }


    private Node nextNode(Node node, int k) {
        if (node == null) {
            return null;
        }

        if (k >= node.key) {
            return nextNode(node.right, k);
        }

        Node t = nextNode(node.left, k);

        if (t != null) {
            return t;
        }

        return node;
    }

    void navigateNode(Node node, String indent) {
        if (node == null) {
            return;
        }

        System.out.println(indent + node.key);
        navigateNode(node.left, indent + "\t");
        navigateNode(node.right, indent + "\t");
    }

    private Node createBst(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;

        Node n = new Node(arr[mid]);
        n.left = createBst(arr, start, mid - 1);
        n.right = createBst(arr, mid + 1, end);

        return n;

    }

    static class Node {
        private int key;
        private Node left;
        private Node right;

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public Node(int key) {
            this(key, null, null);
        }

        public int getKey() {
            return key;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
