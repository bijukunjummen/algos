package algos.graph;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Node {
    private final String value;
    private final Set<Node> children;

    public Node(String value, Set<Node> children) {
        this.value = value;
        this.children = new LinkedHashSet<>(children);
    }

    public Node(String value) {
        this(value, Set.of());
    }

    public String getValue() {
        return value;
    }

    public Set<Node> getChildren() {
        return Collections.unmodifiableSet(children);
    }

    public void addChild(Node node) {
        this.children.add(node);
    }

    @Override
    public String toString() {
        return "Node{"
                + "value='" + value
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
