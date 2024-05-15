package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        for (int s = 0, e = 0; e < nums.length; e++) {
            if (e > 0 && (nums[e] != (nums[e - 1] + 1))) {
                ranges.add(calcRange(s, e - 1, nums));
                s = e;
            }

            if (e == nums.length - 1) {
                ranges.add(calcRange(s, e, nums));
            }
        }
        return ranges;
    }

    private String calcRange(int s, int e, int[] nums) {
        if (s == e) {
            return nums[s] + "";
        } else {
            return nums[s] + "->" + nums[e];
        }
    }

    @Test
    void testSummaryRange() {
        assertThat(summaryRanges(new int[]{0, 1, 2, 4, 5, 7})).isEqualTo(List.of("0->2", "4->5", "7"));
        assertThat(summaryRanges(new int[]{-1})).isEqualTo(List.of("-1"));
    }
}