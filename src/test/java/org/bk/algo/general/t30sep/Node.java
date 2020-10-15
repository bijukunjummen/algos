package org.bk.algo.general.t30sep;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> cloned = shallowClone(node);
        Node newRootNode = cloned.get(node);
        
        for (Map.Entry<Node, Node> entry: cloned.entrySet()) {
            Node old = entry.getKey();
            Node newNode = entry.getValue();
            newNode.neighbors = old.neighbors.stream().map(o -> cloned.get(o)).collect(Collectors.toList());
        }
        return newRootNode;
    }
    
    private Map<Node, Node> shallowClone(Node node) {
        Set<Integer> covered = new HashSet<>();
        Map<Node, Node> result = new HashMap<>();
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (!covered.contains(current.val)) {
                Node newNode = new Node(current.val);
                result.put(current, newNode);
                queue.addAll(current.neighbors);
                covered.add(current.val);
            }
        }
        return result;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}