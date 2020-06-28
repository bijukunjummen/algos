package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        return visit(root, k, new AtomicInteger(0));
    }

    private Integer visit(TreeNode node, int k, AtomicInteger count) {
        if (node == null) {
            return null;
        }
        Integer inLeft = visit(node.left, k, count);
        if (inLeft != null) {
            return inLeft;
        }

        count.incrementAndGet();
        if (count.get() == k) {
            return node.val;
        }

        Integer inRight = visit(node.right, k, count);

        if (inRight != null) {
            return inRight;
        }

        return null;
    }

    @Test
    void testKthSmallest() {
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4));

        assertThat(kthSmallest(root, 1)).isEqualTo(1);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this(x, null, null);
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
            this.val = x;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
                    .add("val=" + val)
                    .add("left=" + left)
                    .add("right=" + right)
                    .toString();
        }
    }
}