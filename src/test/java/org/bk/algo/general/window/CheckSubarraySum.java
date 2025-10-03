package org.bk.algo.general.window;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i < prefixSum.length; i++) {
            int mod = prefixSum[i] % k;
            if  (map.containsKey(mod)) {
                int idx = map.get(mod);
                if (i - idx > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }

    @Test
    void testSums() {
//        assertThat(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)).isEqualTo(true);
//        assertThat(checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7)).isEqualTo(true);
        assertThat(checkSubarraySum(new int[]{0}, 1)).isEqualTo(false);
    }

    @Test
    void testMono() {
        System.out.println(Mono.from(Flux.empty()).block());

    }
}