package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HeapsAlgorithm {
    public List<String> generatePermutations(int k, char[] arr) {
        if (k == 1) {
            return List.of(new String(arr));
        }

        List<String> res = new ArrayList<>();
        res.addAll(generatePermutations(k - 1, arr));

        for (int i = 0; i < k - 1; i++) {
            if (k % 2 == 0) {
                swap(arr, i, k - 1);
            } else {
                swap(arr, 0, k - 1);
            }
            res.addAll(generatePermutations(k - 1, arr));
        }
        return res;
    }

    private void swap(char[] arr, int p1, int p2) {
        char temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    @Test
    void testGetPerms() {
        System.out.println(generatePermutations(4, new char[]{'a', 'b', 'c', 'd'}));
    }
}
