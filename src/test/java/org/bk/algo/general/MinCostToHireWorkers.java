package org.bk.algo.general;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class MinCostToHireWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double minWage = Double.MAX_VALUE;
        for (int f = 0; f < quality.length; f++) {
            PriorityQueue<WageAndIndex> pq = new PriorityQueue<>(Comparator.comparing(p -> p.wageToQuality));
            double focusWage = wage[f];
            double currWage = focusWage;
            for (int o = 0; o < quality.length; o++) {
                if (o != f) {
                    pq.add(new WageAndIndex(o, wage[o] / quality[o]));
                }
            }

//            pq.poll()

        }
        return 1d;
    }

    private record WageAndIndex(int idx, double wageToQuality) {
    }


    @Test
    void test1() {
        assertThat(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2)).isEqualTo(105.0);
        assertThat(mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 2)).isEqualTo(30.66667);
    }
}