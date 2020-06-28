package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int rows = image.length;
        int cols = rows > 0 ? image[0].length : 0;
        BitSet visited = new BitSet(rows * cols);

        return floodFill(image, sr, sc, image[sr][sc], newColor, visited, rows, cols);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int originalColor, int newColor,
                             BitSet visited, int rows, int cols) {
        visited.set(getOffset(sr, sc, rows, cols));

        if (image[sr][sc] == originalColor) {
            image[sr][sc] = newColor;
        } else {
            return image;
        }

        for (Coord n : getNeighbours(image, sr, sc, rows, cols)) {
            if (!visited.get(getOffset(n.r, n.c, rows, cols))) {
                floodFill(image, n.r, n.c, originalColor, newColor, visited, rows, cols);
            }
        }
        return image;
    }


    private int getOffset(int r, int c, int rows, int cols) {
        return r * cols + c;
    }

    List<Coord> getNeighbours(int[][] image, int r, int c, int rows, int cols) {
        List<Coord> neigbours = new ArrayList<>();
        if (r - 1 >= 0) {
            neigbours.add(new Coord(r - 1, c));
        }

        if (r + 1 <= rows - 1) {
            neigbours.add(new Coord(r + 1, c));
        }

        if (c - 1 >= 0) {
            neigbours.add(new Coord(r, c - 1));
        }

        if (c + 1 <= cols - 1) {
            neigbours.add(new Coord(r, c + 1));
        }

        return neigbours;
    }


    static class Coord {
        int r;
        int c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    @Test
    void testGetOffset() {
        assertThat(getOffset(0, 0, 3, 3)).isEqualTo(0);
    }
}