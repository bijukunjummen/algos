package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;


//[8,5,1,7,10,12]
class BstFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {

        return bstHelper(Integer.MIN_VALUE, Integer.MAX_VALUE, new AtomicInteger(0), preorder);
    }

    private TreeNode bstHelper(int minValue, int maxValue, AtomicInteger idxRef, int[] preorder) {
        int idx = idxRef.get();
        if (idx == preorder.length) {
            return null;
        }
        final int val = preorder[idx];
        if (val < minValue || val > maxValue) return null;

        TreeNode treeNode = new TreeNode(val);
        idxRef.incrementAndGet();
        treeNode.left = bstHelper(minValue, val, idxRef, preorder);
        treeNode.right = bstHelper(val, maxValue, idxRef, preorder);
        return treeNode;
    }

    @Test
    void testATree() {
        TreeNode tree = bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        assertThat(tree.val).isEqualTo(8);
        assertThat(tree.left.val).isEqualTo(5);
        assertThat(tree.left.left.val).isEqualTo(1);
        assertThat(tree.left.right.val).isEqualTo(7);
        assertThat(tree.right.val).isEqualTo(10);
        assertThat(tree.right.left).isNull();
        assertThat(tree.right.right.val).isEqualTo(12);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}