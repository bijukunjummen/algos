import algos.graph.Graph;
import algos.graph.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphDepTest {

    /**
     * A -> B
     * B -> C
     * D -> B
     *
     */
    @Test
    void depTest() {
        Node c = new Node("C");
        Node b = new Node("B", Set.of(c));
        Node a = new Node("A", Set.of(b));
        Node d = new Node("D", Set.of(b));

        Graph graph = new Graph(List.of(a, b, c, d));

        dfs(graph);
    }
    /**
     * A -> B
     * B -> C
     * B -> D
     * D -> A
     */
    @Test
    void cycleTest() {
        Node c = new Node("C");
        Node d = new Node("D", Set.of());
        Node b = new Node("B", Set.of(c, d));
        Node a = new Node("A", Set.of(b));
        d.addChild(a);

        Graph graph = new Graph(List.of(a, b, c, d));
        detectCycle(graph);
    }
    void dfs(Graph graph) {
        Set<Node> marked = new HashSet<>();
        for (Node node : graph.getNodes()) {
            dfs(node, marked, "");
        }
    }

    private void dfs(Node node, Set<Node> marked, String indent) {
        if (marked.contains(node)) {
            return;
        }
        visit(node, indent);
        marked.add(node);
        for (Node child : node.getChildren()) {
            dfs(child, marked, indent + "\t");
        }
    }

    private List<Node> detectCycle(Graph graph) {
        return List.of();
    }

    private void visit(Node node, String indent) {
        System.out.println(indent + node);
    }


}
