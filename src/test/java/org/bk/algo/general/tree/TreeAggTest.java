package org.bk.algo.general.tree;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TreeAggTest {

    record Node(String id, List<Node> children, int value) {

        Node(String id, List<Node> children) {
            this(id, children, 0);
        }

        Node(String id) {
            this(id, List.of(), 0);
        }
    }

    @Test
    void testAggregation() {
        Node root = new Node("0", List.of(
                new Node("00", List.of(
                        new Node("000", List.of(
                                new Node("0000", List.of(), 0),
                                new Node("0001", List.of(), 1))),
                        new Node("001", List.of(
                                new Node("0010", List.of(), 10),
                                new Node("0011", List.of(), 11))))),
                new Node("01", List.of(
                        new Node("010", List.of(
                                new Node("0100", List.of(), 100),
                                new Node("0101", List.of(), 101))),
                        new Node("011", List.of(
                                new Node("0110", List.of(), 110),
                                new Node("0111", List.of(), 111)))))));

        Assertions.assertThat(aggregate(root)).isEqualTo(444);
    }

    private int aggregate(Node node) {
        return 0;
    }
}
