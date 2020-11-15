package org.bk.algo.general.bt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, List<TreeNode>> levelOrderedMap = new HashMap<>();
        createLevelOrderedMap(levelOrderedMap, root, 0);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < levelOrderedMap.size(); i++) {
            result.add(last(levelOrderedMap.get(i)).val);
        }
        return result;
    }

    private TreeNode last(List<TreeNode> list) {
        return list.get(list.size() - 1);
    }

    private void createLevelOrderedMap(Map<Integer, List<TreeNode>> levelOrderedMap, TreeNode node, int level) {
        if (node == null) return;
        levelOrderedMap.computeIfAbsent(level, (l) -> new ArrayList<>());

        levelOrderedMap.get(level).add(node);
        if (node.left != null) createLevelOrderedMap(levelOrderedMap, node.left, level + 1);
        if (node.right != null) createLevelOrderedMap(levelOrderedMap, node.right, level + 1);
    }
}