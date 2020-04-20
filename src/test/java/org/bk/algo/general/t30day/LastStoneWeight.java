package org.bk.algo.general.t30day;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> weightsQueue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(stones).forEach(weightsQueue::add);

        while (weightsQueue.size() > 0) {
            int largest = weightsQueue.remove();
            if (weightsQueue.size() > 0) {
                int secondLargest = weightsQueue.remove();
                if (largest > secondLargest) {
                    weightsQueue.add(largest - secondLargest);
                }
            } else {
                return largest;
            }
        }

        if (weightsQueue.size() > 0) {
            return weightsQueue.remove();
        }

        return 0;
    }

    @Test
    void testWeights() {
        int[] weights = {2, 7, 4, 1, 8, 1};
        assertThat(lastStoneWeight(weights)).isEqualTo(1);
    }
}