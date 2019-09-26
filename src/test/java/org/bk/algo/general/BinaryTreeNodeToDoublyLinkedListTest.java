package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeNodeToDoublyLinkedListTest {

    @Test
    public void testSumInBinaryTree() {
        BNode root = new BNode(
                10,
                new BNode(5, new BNode(4), new BNode(7)),
                new BNode(12)
        );

        Path rootPath = new Path();
        List<Path> paths = findPathsForSum(22, root, rootPath);
        System.out.println(paths);
    }

    private List<Path> findPathsForSum(int sum, BNode node, Path rootPath) {
        System.out.println("Sum : " + sum + ", node Value: " + (node != null ? node.getValue() : node));


        final List<Path> paths = new ArrayList<>();

        if (node == null || node.getValue() > sum) {
            return paths;
        }

        if (node.getValue() == sum) {
            paths.add(rootPath.extend(node));
            return paths;
        }

        List<Path> leftPaths = findPathsForSum(sum - node.getValue(), node.getLeft(), rootPath.extend(node));
        List<Path> rightPaths = findPathsForSum(sum - node.getValue(), node.getRight(), rootPath.extend(node));

        paths.addAll(leftPaths);
        paths.addAll(rightPaths);
        return paths;
    }

    @Test
    public void testBinaryNodeToLinkedList() {
        BNode root = new BNode(
                10,
                new BNode(6,
                        new BNode(4),
                        new BNode(8)
                ),
                new BNode(14,
                        new BNode(12),
                        new BNode(16)
                )
        );

        LNode head = convertToLNode(root);
        while (head.getPrev() != null) {
            head = head.getPrev();
        }

        while (head.getNext() != null) {
            head = head.getNext();
        }

        assertThat(head.getValue()).isEqualTo(16);
    }

    private LNode convertToLNode(BNode node) {
        if (node == null) {
            return null;
        }
        LNode current = new LNode(node.value);

        LNode prevNode = convertToLNode(node.getLeft());
        LNode nextNode = convertToLNode(node.getRight());

        current.setNext(nextNode);

        if (nextNode != null) {
            nextNode.setPrev(current);
        }

        current.setPrev(prevNode);

        if (prevNode != null) {
            prevNode.setNext(current);
        }

        return current;
    }


    class Path {
        private final List<BNode> history;

        public Path() {
            this(new ArrayList<>());
        }

        public Path(List<BNode> history) {
            this.history = Collections.unmodifiableList(history);
        }

        public List<BNode> getHistory() {
            return history;
        }

        public Path extend(BNode node) {
            List<BNode> newList = new ArrayList<>(this.history);
            newList.add(node);
            return new Path(newList);
        }

        @Override
        public String toString() {
            return "Path{" +
                    "history=" +
                    history
                            .stream()
                            .map(node -> node.getValue() + "")
                            .collect(Collectors.joining(", ")) +
                    '}';
        }
    }

    class BNode {
        private final int value;
        private BNode left;
        private BNode right;

        public BNode(int value) {
            this(value, null, null);
        }

        public BNode(int value, BNode left, BNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public BNode getLeft() {
            return left;
        }

        public void setLeft(BNode left) {
            this.left = left;
        }

        public BNode getRight() {
            return right;
        }

        public void setRight(BNode right) {
            this.right = right;
        }
    }


    class LNode {
        private LNode next;
        private LNode prev;

        private final int value;

        public LNode(int value, LNode next, LNode prev) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        public LNode(int value) {
            this(value, null, null);
        }

        public LNode getNext() {
            return next;
        }

        public void setNext(LNode next) {
            this.next = next;
        }

        public LNode getPrev() {
            return prev;
        }

        public void setPrev(LNode prev) {
            this.prev = prev;
        }

        public int getValue() {
            return value;
        }

    }
}
