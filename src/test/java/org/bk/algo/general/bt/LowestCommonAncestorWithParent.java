package org.bk.algo.general.bt;

import java.util.ArrayList;
import java.util.List;

class LowestCommonAncestorWithParent {
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> pNodes = createChain(p);
        List<Node> qNodes = createChain(q);

        int p1 = pNodes.size();
        int q1 = qNodes.size();
        while (p1 - 1 >= 0 && q1 - 1 >= 0 && pNodes.get(p1 - 1) == qNodes.get(q1 - 1)) {
            p1--;
            q1--;
        }

        return pNodes.get(p1);
    }

    private List<Node> createChain(Node node) {
        List<Node> result = new ArrayList<>();
        while (node != null) {
            result.add(node);
            node = node.parent;
        }
        return result;
    }

    record Node(int val, Node left, Node right, Node parent) {
    }
}