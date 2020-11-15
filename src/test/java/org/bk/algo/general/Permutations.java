package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Permutations {

    public List<String> permutations(String str) {
        char[] chars = str.toCharArray();
        List<String> result = new ArrayList<>();
        permutations(0, chars, result);
        return result;
    }

    private void permutations(int idx, char[] arr, List<String> result) {
        if (idx == arr.length - 1) {
            result.add(new String(arr));
        }

        for (int i = idx; i <= arr.length - 1; i++) {
            swap(arr, i, idx);
            permutations(idx + 1, arr, result);
            swap(arr, i, idx);
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
