package algos.graph;

import java.util.List;

public class Graph {
    private final List<Node> nodes;

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
