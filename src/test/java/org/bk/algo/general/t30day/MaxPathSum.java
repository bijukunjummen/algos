// package org.bk.algo.general.t30day;
//
// import org.junit.jupiter.api.Test;
//
// import java.util.Comparator;
// import java.util.List;
//
// import static org.assertj.core.api.Assertions.assertThat;
//
// class MaxPathSum {
//     public int maxPathSum(TreeNode root) {
//         return maxPathSumRoot(root).t1;
//     }
//
//     private Pair<Integer, Boolean>> maxPathSumRoot(TreeNode node) {
//         if (node == null) {
//             return List.of(new Pair(Integer.MIN_VALUE, true));
//         }
//
//         Pair<Integer, Boolean> leftTree = maxPathSumRoot(node.left).get(0);
//         Pair<Integer, Boolean> rightTree = maxPathSumRoot(node.right).get(0);
//
//         Pair<Integer, Boolean> rootWithLeft =
//                 leftTree.t2 ? new Pair(((leftTree.t1 != Integer.MIN_VALUE) ? leftTree.t1 : 0) + node.val, true) :
//                         new Pair(Integer.MIN_VALUE, false);
//
//         Pair<Integer, Boolean> rootWithRight =
//                 rightTree.t2 ? new Pair(((rightTree.t1 != Integer.MIN_VALUE) ? rightTree.t1 : 0) + node.val, true) :
//                         new Pair(Integer.MIN_VALUE, false);
//
//         Pair<Integer, Boolean> rootWithRightAndLeft =
//                 (leftTree.t2 || rightTree.t2)
//                         ? new Pair(
//                         (leftTree.t2 ? ((leftTree.t1 != Integer.MIN_VALUE) ? leftTree.t1 : 0) : 0) +
//                                 (rightTree.t2 ? ((rightTree.t1 != Integer.MIN_VALUE) ? rightTree.t1 : 0) : 0) + node.val, true) : new Pair(Integer.MIN_VALUE, false);
//
//         Pair<Integer, Boolean> rootAlone = new Pair(node.val, true);
//
//         leftTree.t2 = false;
//         rightTree.t2 = false;
//         Pair<Integer, Boolean> max = List
//                 .of(leftTree, rightTree, rootWithLeft, rootWithRight, rootWithRightAndLeft, rootAlone).stream().max(Comparator.comparingInt(p -> p.t1))
//                 .orElseThrow();
//
//         if (max == rootWithRightAndLeft) {
//             Pair<Integer, Boolean> maxNoRoot = List
//                     .of(leftTree, rightTree, rootWithLeft, rootWithRight, rootAlone).stream().max(Comparator.comparingInt(p -> p.t1))
//                     .orElseThrow();
//             return List.of(rootWithRightAndLeft, )
//         }
//     }
//
//     static class Pair<T1, T2> {
//         T1 t1;
//         T2 t2;
//
//         Pair(T1 t1, T2 t2) {
//             this.t1 = t1;
//             this.t2 = t2;
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
//     void testMaxTree1() {
//         TreeNode tree = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
//         assertThat(maxPathSum(tree)).isEqualTo(42);
//     }
//
//     @Test
//     void testMaxTree3() {
//         TreeNode tree = new TreeNode(1, new TreeNode(-2), new TreeNode(3));
//         assertThat(maxPathSum(tree)).isEqualTo(4);
//     }
//
//     @Test
//     void testMaxTree2() {
//         TreeNode tree = new TreeNode(1,
//                 new TreeNode(-2,
//                         new TreeNode(1,
//                                 new TreeNode(-1),
//                                 null),
//                         new TreeNode(3)),
//                 new TreeNode(-3,
//                         new TreeNode(-2),
//                         null)
//         );
//         assertThat(maxPathSum(tree)).isEqualTo(3);
//     }
//
//
//     @Test
//     void testMaxTree4() {
//         TreeNode tree = new TreeNode(5,
//                 new TreeNode(4,
//                         new TreeNode(11,
//                                 new TreeNode(7),
//                                 new TreeNode(2)),
//                         null),
//                 new TreeNode(8,
//                         new TreeNode(13),
//                         new TreeNode(4,
//                                 null,
//                                 new TreeNode(1)))
//         );
//         assertThat(maxPathSum(tree)).isEqualTo(48);
//     }
// }