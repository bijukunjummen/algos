package org.bk.algo.general.bt;


import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LowerCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfs(root, null, parentMap);
        List<TreeNode> list1 = createRootToNode(parentMap, p);
        List<TreeNode> list2 = createRootToNode(parentMap, p);

        int p1 = 0;
        int p2 = 0;
        TreeNode candidate = null;
        while (p1 < list1.size() && p2 < list2.size() && list1.get(p1) == list2.get(p2)) {
            candidate = list1.get(p1);
            if (p1 < list1.size() - 1) {
                p1++;
            }

            if (p2 < list2.size() - 1) {
                p2++;
            }
        }
        return candidate;

    }

    private List<TreeNode> createRootToNode(Map<TreeNode, TreeNode> parentMap, TreeNode node) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode current = node;
        while (current != null) {
            deque.addFirst(current);
            current = parentMap.get(current);
        }
        return new ArrayList<>(deque);
    }

    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (parent != null) {
            parentMap.put(node, parent);
        }

        if (node.left != null) {
            dfs(node.left, node, parentMap);
        }
        if (node.right != null) {
            dfs(node.right, node, parentMap);
        }
    }

    @Test
    void testLca() {
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("3,5,1,6,2,0,8,null,null,7,4");
        System.out.println(root);
    }
}