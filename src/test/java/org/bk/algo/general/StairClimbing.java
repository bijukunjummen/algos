package org.bk.algo.general;

import java.util.HashMap;
import java.util.Map;

class StairClimbing {
    public int climbStairs(int n) {
        return climbStairsMemoized(n, new HashMap<>());
    }
    
    public int climbStairsMemoized(int n, Map<Integer, Integer> calc) {
        if (n == 0) {
            return 0;
        }else  if ( n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        
        if (calc.containsKey(n)) {
            return calc.get(n);
        }

        Integer res =  climbStairsMemoized(n - 1, calc) + climbStairsMemoized(n - 2, calc);
        calc.put(n, res);
        return res;
    }
}