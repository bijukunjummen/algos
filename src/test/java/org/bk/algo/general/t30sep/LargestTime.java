package org.bk.algo.general.t30sep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LargestTime {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        List<NumAndIndex> h1P = findCandidatesSortedDesc(2, A, new boolean[4]);
        for (NumAndIndex h1: h1P) {
            boolean[] used = new boolean[4];
            used[h1.idx] = true;
            List<String> maxList = findMaxPossibleForPosition("" + h1.num, 1, h1.num, A, used);
            for (String max: maxList) {
                if (max.length() == 4) {
                    return max.substring(0, 2) + ":" + max.substring(2);
                }
            }
        }
        return "";
    }
    
    List<String> findMaxPossibleForPosition(String prefix, int position, int value, int[] A, boolean[] used) {
        if (position == 4) {
            return List.of(prefix);
        }

        int maxForNextPosition = maxForNextPosition(position, value, A, used);
        List<NumAndIndex> pot = findCandidatesSortedDesc(maxForNextPosition, A, used);
        if (pot.size() == 0) {
            return List.of();
        }
        List<String> potentialResults = new ArrayList<>();
        for (NumAndIndex h: pot) {
            boolean[] newUsed = copyAndSetIndex(used, h.idx);
            potentialResults.addAll(findMaxPossibleForPosition(prefix + h.num, position + 1, h.num, A, newUsed));
        }
        return potentialResults;
        
    }

    private boolean[] copyAndSetIndex(boolean[] used, int idx) {
        boolean[] newUsed = new boolean[4];
        System.arraycopy(used, 0, newUsed, 0, 4);
        newUsed[idx] = true;
        return newUsed;
    }

    private int maxForNextPosition(int position, int value, int[] A, boolean[] used) {
        switch(position) {
            case 1: return (value == 2)? 3:9;
            case 2: return 5;
            case 3: return (value == 6)? 0:9;
            case 4: return -1;
        }
        throw new IllegalStateException("Should not reach this point.." + position);
    }
    
    private List<NumAndIndex> findCandidatesSortedDesc(int max, int[] A, boolean[] used) {
        List<NumAndIndex> candidates = new ArrayList<>();
        for (int i = A.length - 1;i >= 0; i--) {
            if (!used[i] && A[i] <= max) {
                candidates.add(new NumAndIndex(A[i], i));
            } 
        }
        return candidates;
    }
    
    
    class NumAndIndex {
        int num;
        int idx;
        
        NumAndIndex(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    @Test
    void largestTime() {
        System.out.println(largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }
}