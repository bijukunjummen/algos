package org.bk.algo.general.t30djune;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<TreeNodeAndIndex>> treeMap =
                new TreeMap<>();

        Queue<TreeNodeAndIndex> queue = new ArrayDeque<>();

        queue.add(new TreeNodeAndIndex(root, new Coord(0, 0)));
        while (!queue.isEmpty()) {
            TreeNodeAndIndex nodeAndIndex = queue.poll();
            TreeNode node = nodeAndIndex.treeNode;
            Coord coord = nodeAndIndex.coord;

            treeMap.computeIfAbsent(nodeAndIndex.coord.x,
                    (k) -> new ArrayList<>());
            treeMap.get(nodeAndIndex.coord.x).add(nodeAndIndex);

            if (node.left != null) queue.add(new TreeNodeAndIndex(node.left, new Coord(coord.x - 1, coord.y - 1)));
            if (node.right != null) queue.add(new TreeNodeAndIndex(node.right, new Coord(coord.x + 1, coord.y - 1)));
        }
        return treeMap
                .values()
                .stream()
                .map(treeSet ->
                        treeSet
                                .stream()
                                .sorted(Comparator
                                        .comparingInt((TreeNodeAndIndex treNodeAndIndex) -> treNodeAndIndex.coord.y)
                                        .reversed()
                                        .thenComparingInt(treeNodeAndIndex -> treeNodeAndIndex.treeNode.val))
                                .map(treeNodeAndIndex -> treeNodeAndIndex.treeNode.val)
                                .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static class TreeNodeAndIndex {
        TreeNode treeNode;
        Coord coord;

        TreeNodeAndIndex(TreeNode treeNode, Coord coord) {
            this.treeNode = treeNode;
            this.coord = coord;
        }
    }

    private static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}