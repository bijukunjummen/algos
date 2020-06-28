package org.bk.algo.general.t30djune;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class TwoCitiesSchedulingCost {
    public int twoCitySchedCost(int[][] costs) {
        return -1;
    }

    List<List<Integer>> getCombinations(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        getCombinations(n, k, 0, List.of(), results);
        return results;
    }

    void getCombinations(int n, int k, int currIndex, List<Integer> currHistory, List<List<Integer>> currResults) {
        if (currHistory.size() == k) {
            currResults.add(currHistory);
            return;
        }
        if (currIndex > n - 1) {
            return;
        }
        List<Integer> withCurrIndex = new ArrayList<>(currHistory);
        withCurrIndex.add(currIndex);

        getCombinations(n, k, currIndex + 1, withCurrIndex, currResults);
        getCombinations(n, k, currIndex + 1, currHistory, currResults);
    }

    @Test
    void testCombinations() {
        System.out.println(getCombinations(8, 3));
    }


}