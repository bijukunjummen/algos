package org.bk.algo.general.t30sep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> set1 = Arrays.stream(nums1).boxed()
                .collect(Collectors.toMap(k -> k, k -> 1, (v1, v2) -> v1 + v2));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int n2 = nums2[i];
            if (set1.containsKey(n2)) {
                int v = set1.get(n2);
                if (v > 0) {
                    result.add(n2);
                }
                set1.put(n2, v - 1);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}