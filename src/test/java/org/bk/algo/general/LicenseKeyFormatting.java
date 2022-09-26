package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        String noDash = s.replaceAll("-", "");
        int len = noDash.length();
        Deque<String> stack = new ArrayDeque<>();
        int endSegmentIndex = len - 1;

        while (endSegmentIndex >= 0) {
            int startSegmentIndex = endSegmentIndex - k + 1;
            if (startSegmentIndex < 0) startSegmentIndex = 0;
            stack.push(noDash.substring(startSegmentIndex, endSegmentIndex + 1));
            endSegmentIndex = endSegmentIndex - k;
        }
        return stack.stream().map(e -> e.toUpperCase()).collect(Collectors.joining("-"));
    }

    @Test
    void testKeyFormatting() {
        assertThat(licenseKeyFormatting("5F3Z-2e-9-w", 4)).isEqualTo("5F3Z-2E9W");
        assertThat(licenseKeyFormatting("2-5g-3-J", 2)).isEqualTo("2-5G-3J");
    }
}
