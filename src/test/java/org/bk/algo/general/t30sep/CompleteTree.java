// package org.bk.algo.general.t30sep;
//
// import org.junit.jupiter.api.Test;
//
// import java.util.ArrayDeque;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Queue;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// public class CompleteTree {
//     public boolean isComplete(TreeNode treeNode) {
//         Queue<TreeNodeAndLevel> queue = new ArrayDeque<>();
//         queue.add(new TreeNodeAndLevel(0, treeNode));
//         Map<Integer, List<TreeNode>> result = new HashMap<>();
//         while (!queue.isEmpty()) {
//             TreeNodeAndLevel tl = queue.poll();
//             TreeNode node = tl.treeNode;
//             result.computeIfAbsent(tl.level, k -> new ArrayList<>());
//             result.get(tl.level).add(node);
//             if (node.left == null && node.right != null) {
//                 return false;
//             }
//             if (node.left != null) queue.add(new TreeNodeAndLevel(tl.level + 1, node.left));
//             if (node.right != null) queue.add(new TreeNodeAndLevel(tl.level + 1, node.right));
//
//
//         }
//     }
//
//     static class TreeNodeAndLevel {
//         int level;
//         TreeNode treeNode;
//
//         public TreeNodeAndLevel(int level, TreeNode treeNode) {
//             this.level = level;
//             this.treeNode = treeNode;
//         }
//     }
//
//     static class TreeNode {
//         int val;
//         TreeNode left;
//         TreeNode right;
//
//         TreeNode(int x) {
//             this(x, null, null);
//         }
//
//         TreeNode(int x, TreeNode left, TreeNode right) {
//             this.left = left;
//             this.right = right;
//             this.val = x;
//         }
//     }
//
//     @Test
//     void testInvert() {
//         TreeNode root = new TreeNode(4,
//                 new TreeNode(2),
//                 new TreeNode(7));
//
//
//         assertThat(isComplete(root)).isTrue();
//     }
// }
