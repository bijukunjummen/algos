package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumSimilarGroups {
    public int numSimilarGroups(String[] strs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            graph.computeIfAbsent(i, k -> new ArrayList<>());
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    graph.get(i).add(j);

                    graph.computeIfAbsent(j, k -> new ArrayList<>());
                    graph.get(j).add(i);
                }
            }
        }

        int compCount = 0;
        Set<Integer> visited = new HashSet<>();
        for (Integer node : graph.keySet()) {
            if (!visited.contains(node)) {
                visit(node, graph, visited);
                compCount++;
            }
        }
        return compCount;
    }

    private void visit(Integer node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        if (graph.containsKey(node)) {
            for (Integer child : graph.get(node)) {
                if (!visited.contains(child)) {
                    visit(child, graph, visited);
                }
            }
        }
    }

    boolean isSimilar(String str1, String str2) {
        int[] misMatchedIndexes = new int[2];
        int r = 0;

        if (str1.length() != str2.length()) return false;
        int numMisMatch = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                numMisMatch++;
                if (numMisMatch > 2) {
                    return false;
                }
                misMatchedIndexes[r++] = i;
            }
        }
        if (r == 0) {
            return true;
        }
        if (r == 1) { // only 1 mismatch!
            return false;
        }
        if (r == 2) {
            return str1.charAt(misMatchedIndexes[0]) == str2.charAt(misMatchedIndexes[1]) &&
                    str2.charAt(misMatchedIndexes[0]) == str1.charAt(misMatchedIndexes[1]);
        }

        return false;
    }

    @Test
    void testSimilarGroups() {
        assertThat(numSimilarGroups(new String[]{"tars", "rats", "arts", "star"})).isEqualTo(2);
        assertThat(numSimilarGroups(new String[]{"omv", "ovm"})).isEqualTo(1);
    }
}