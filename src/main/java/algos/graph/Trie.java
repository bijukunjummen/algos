package algos.graph;

public class Trie {
    private static final int R = 256;

    private Node root;
    private int n;

    static class Node {
        String value;
        Node[] next = new Node[R];
    }

    public String get(String key) {
        return get(root, key, 0);
    }

    private String get(Node node, String key, int depth) {
        if (key.length() == depth) {
            return node.value;
        }
        int c = key.charAt(depth);
        return get(node.next[c], key, depth + 1);

    }
    public void put(String key, String value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node node, String key, String value, int d) {
        if (node == null) node = new Node();

        if (d == key.length()) {
            if (node.value == null) n++;
            node.value = value;
            return node;
        }

        char c = key.charAt(d);

        node.next[c] = put(node.next[c], key, value, d + 1);
        return node;
    }




}
