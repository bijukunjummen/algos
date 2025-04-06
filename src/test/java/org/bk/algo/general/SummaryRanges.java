package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return List.of();
        }
        List<Range> ranges = getRanges(nums);
        return ranges.stream().map(this::convertRange).toList();
    }

    private List<Range> getRanges(int[] nums) {
        int currentRangeMin = nums[0];
        int currentRangeMax = nums[0];
        List<Range> ranges = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (isPartOfCurrentRange(i, nums)) {
                currentRangeMax = nums[i];
            } else {
                ranges.add(new Range(currentRangeMin, currentRangeMax));
                currentRangeMin = nums[i];
                currentRangeMax = nums[i];
            }
        }
        ranges.add(new Range(currentRangeMin, currentRangeMax));
        return ranges;
    }

    private String convertRange(Range range) {
        if (range.start == range.end) {
            return "" + range.start;
        }
        return "" + range.start + "->" + range.end;
    }

    private boolean isPartOfCurrentRange(int i, int[] nums) {
        return nums[i] == nums[i - 1] + 1;
    }

    record Range(int start, int end) {}

    @Test
    void testRanges() {
        List<Range> ranges = getRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println(ranges);
    }

    @Test
    void testSummaryRange() {
        assertThat(summaryRanges(new int[]{0, 1, 2, 4, 5, 7})).isEqualTo(List.of("0->2", "4->5", "7"));
        assertThat(summaryRanges(new int[]{0, 1, 2, 4, 5, 7})).isEqualTo(List.of("0->2", "4->5", "7"));
        assertThat(summaryRanges(new int[]{-1})).isEqualTo(List.of("-1"));
    }

    @Test
    void testCeil() {
        System.out.println(Math.ceil((double) 11 / (double) 10));
    }

}