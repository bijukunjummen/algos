package org.bk.algo.general;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumTilePossibilitiesTest {
    public int numTilePossibilities(String tiles) {
        Set<String> found = new HashSet<>();
        int len = tiles.length();
        boolean[] used = new boolean[len];
        generateSequences(tiles, "", used, found);
        return found.size() - 1;
    }

    private void generateSequences(String tiles, String current, boolean[] used, Set<String> found) {
        found.add(current);
        for (int pos = 0; pos < tiles.length(); pos++) {
            if (!used[pos]) {
                used[pos] = true;
                generateSequences(tiles, current + tiles.charAt(pos), used, found);
                used[pos] = false;
            }
        }
    }

    @Test
    void testNumTiles() {
        assertThat(numTilePossibilities("AAB")).isEqualTo(8);
        assertThat(numTilePossibilities("AAABBC")).isEqualTo(188);
        assertThat(numTilePossibilities("V")).isEqualTo(1);

    }
}