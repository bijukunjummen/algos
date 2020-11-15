package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsHeap {

    public List<String> permutations(String str) {
        char[] chars = str.toCharArray();
        List<String> result = new ArrayList<>();
        permutations(chars.length, chars, result);
        return result;
    }

    private void permutations(int k, char[] arr, List<String> result) {
        if (k == 1) {
            result.add(new String(arr));
            return;
        }
        permutations(k - 1, arr, result);
        for (int i = 0; i < k - 1; i++) {
            if (k % 2 == 0) {
                swap(arr, i, k - 1);
            } else {
                swap(arr, 0, k - 1);
            }
            permutations(k - 1, arr, result);
        }
    }
    private void swap(char[] arr, int p1, int p2) {
        if (p1 == p2) return;
        char temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    @Test
    void testPerms() {
        List<String> abcdPerms = permutations("ABCD");
        assertThat(abcdPerms).hasSize(24);
        assertThat(abcdPerms)
                .containsExactlyInAnyOrder(
                        "ABCD", "ABDC", "ACBD", "ACDB", "ADCB", "ADBC", "BACD", "BADC", "BCAD", "BCDA", "BDCA", "BDAC",
                        "CBAD", "CBDA", "CABD", "CADB", "CDAB", "CDBA", "DBCA", "DBAC", "DCBA", "DCAB", "DACB", "DABC");
    }
}
